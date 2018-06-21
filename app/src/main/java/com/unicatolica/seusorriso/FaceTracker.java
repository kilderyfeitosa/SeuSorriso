/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.unicatolica.seusorriso;

import android.graphics.PointF;

import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;
import com.unicatolica.seusorriso.ui.camera.GraphicOverlay;

import java.util.HashMap;
import java.util.Map;

class FaceTracker extends Tracker<Face> {
    private static final float MOUTH_CLOSED_THRESHOLD = 0.4f;
    private String opcao;
    private GraphicOverlay mOverlay;
    private MouthGraphic mMouthGraphic;
    private Map<Integer, PointF> mPreviousProportions = new HashMap<>();
    private boolean mPreviousIsButtomOpen = true;
    private boolean mPreviousIsLeftOpen = true;
    private boolean mPreviousIsRightOpen = true;
    //==============================================================================================
    // Methods
    //==============================================================================================

    FaceTracker(GraphicOverlay overlay, String opcao) {
        mOverlay = overlay;
        this.opcao = opcao;
    }

    @Override
    public void onNewItem(int id, Face face) {
        mMouthGraphic = new MouthGraphic(mOverlay, opcao);
    }

    @Override
    public void onUpdate(FaceDetector.Detections<Face> detectionResults, Face face) {
        mOverlay.add(mMouthGraphic);

        updatePreviousProportions(face);

        PointF buttomPosition = getLandmarkPosition(face, Landmark.BOTTOM_MOUTH);
        PointF leftPosition = getLandmarkPosition(face, Landmark.LEFT_MOUTH);
        PointF rightPosition = getLandmarkPosition(face, Landmark.RIGHT_MOUTH);

        float buttomOpenScore = face.getIsSmilingProbability();
        boolean isButtomOpen;
        if (buttomOpenScore == Face.UNCOMPUTED_PROBABILITY) {
            isButtomOpen = mPreviousIsButtomOpen;
        } else {
            isButtomOpen = (buttomOpenScore > MOUTH_CLOSED_THRESHOLD);
            mPreviousIsButtomOpen = isButtomOpen;
        }

        float leftOpenScore = face.getIsSmilingProbability();
        boolean isLeftOpen;
        if (leftOpenScore == Face.UNCOMPUTED_PROBABILITY) {
            isLeftOpen = mPreviousIsLeftOpen;
        } else {
            isLeftOpen = (leftOpenScore > MOUTH_CLOSED_THRESHOLD);
            mPreviousIsLeftOpen = isLeftOpen;
        }

        float rightOpenScore = face.getIsSmilingProbability();
        boolean isRightOpen;
        if (rightOpenScore == Face.UNCOMPUTED_PROBABILITY) {
            isRightOpen = mPreviousIsRightOpen;
        } else {
            isRightOpen = (rightOpenScore > MOUTH_CLOSED_THRESHOLD);
            mPreviousIsRightOpen = isRightOpen;
        }

        mMouthGraphic.updateMouth(buttomPosition, isButtomOpen,leftPosition, isLeftOpen, rightPosition, isRightOpen);
    }

    @Override
    public void onMissing(FaceDetector.Detections<Face> detectionResults) {
        mOverlay.remove(mMouthGraphic);
    }

    @Override
    public void onDone() {
        mOverlay.remove(mMouthGraphic);
    }

    //==============================================================================================
    // Private
    //==============================================================================================

    private void updatePreviousProportions(Face face) {
        for (Landmark landmark : face.getLandmarks()) {
            PointF position = landmark.getPosition();
            float xProp = (position.x - face.getPosition().x) / face.getWidth();
            float yProp = (position.y - face.getPosition().y) / face.getHeight();
            mPreviousProportions.put(landmark.getType(), new PointF(xProp, yProp));
        }
    }

    private PointF getLandmarkPosition(Face face, int landmarkId) {
        for (Landmark landmark : face.getLandmarks()) {
            if (landmark.getType() == landmarkId) {
                return landmark.getPosition();
            }
        }

        PointF prop = mPreviousProportions.get(landmarkId);
        if (prop == null) {
            return null;
        }

        float x = face.getPosition().x + (prop.x * face.getWidth());
        float y = face.getPosition().y + (prop.y * face.getHeight());
        return new PointF(x, y);
    }
}