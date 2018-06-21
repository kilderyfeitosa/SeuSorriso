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
import android.os.SystemClock;

class MouthPhysics {
    private final long TIME_PERIOD_MS = 1000;
    private final float FRICTION = 2.2f;
    private final float GRAVITY = 40.0f;
    private final float BOUNCE_MULTIPLIER = 20.0f;
    private final float ZERO_TOLERANCE = 0.001f;
    private long mLastUpdateTimeMs = SystemClock.elapsedRealtime();
    private PointF mMouthPosition;
    private float mMouthRadius;
    private PointF mSmilePosition;
    private float mSmileRadius;
    private float vx = 0.0f;
    private float vy = 0.0f;
    private int mConsecutiveBounces = 0;

    //==============================================================================================
    // Methods
    //==============================================================================================

    PointF nextSmilePosition(PointF mouthPosition, float mouthRadius, float smileRadius) {
        mMouthPosition = mouthPosition;
        mMouthRadius = mouthRadius;
        if (mSmilePosition == null) {
            mSmilePosition = mouthPosition;
        }
        mSmileRadius = smileRadius;

        long nowMs = SystemClock.elapsedRealtime();
        long elapsedTimeMs = nowMs - mLastUpdateTimeMs;
        float simulationRate = (float) elapsedTimeMs / TIME_PERIOD_MS;
        mLastUpdateTimeMs = nowMs;

        if (!isStopped()) {
            vy += GRAVITY * simulationRate;
        }

        vx = applyFriction(vx, simulationRate);
        vy = applyFriction(vy, simulationRate);

        float x = mSmilePosition.x + (vx * mSmileRadius * simulationRate);
        float y = mSmilePosition.y + (vy * mSmileRadius * simulationRate);
        mSmilePosition = new PointF(x, y);

        makeSmileInBounds(simulationRate);

        return mSmilePosition;
    }

    private float applyFriction(float velocity, float simulationRate) {
        if (isZero(velocity)) {
            velocity = 0.0f;
        } else if (velocity > 0) {
            velocity = Math.max(0.0f, velocity - (FRICTION * simulationRate));
        } else {
            velocity = Math.min(0.0f, velocity + (FRICTION * simulationRate));
        }
        return velocity;
    }

    private void makeSmileInBounds(float simulationRate) {
        float smileOffsetX = mSmilePosition.x - mMouthPosition.x;
        float smileOffsetY = mSmilePosition.y - mMouthPosition.y;

        float maxDistance = mMouthRadius - mSmileRadius;
        float distance = (float) Math.sqrt(Math.pow(smileOffsetX, 2) + Math.pow(smileOffsetY, 2));
        if (distance <= maxDistance) {
            mConsecutiveBounces = 0;
            return;
        }

        mConsecutiveBounces++;

        float ratio = maxDistance / distance;
        float x = mMouthPosition.x + (ratio * smileOffsetX);
        float y = mMouthPosition.y + (ratio * smileOffsetY);

        float dx = x - mSmilePosition.x;
        vx = applyBounce(vx, dx, simulationRate) / mConsecutiveBounces;

        float dy = y - mSmilePosition.y;
        vy = applyBounce(vy, dy, simulationRate) / mConsecutiveBounces;

        mSmilePosition = new PointF(x, y);
    }

    private float applyBounce(float velocity, float distOutOfBounds, float simulationRate) {
        if (isZero(distOutOfBounds)) {
            return velocity;
        }
        velocity *= -1;
        float bounce = BOUNCE_MULTIPLIER * Math.abs(distOutOfBounds / mSmileRadius);
        if (velocity > 0) {
            velocity += bounce * simulationRate;
        } else {
            velocity -= bounce * simulationRate;
        }

        return velocity;
    }
    private boolean isStopped() {
        if (mMouthPosition.y >= mSmilePosition.y) {
            return false;
        }

        float smileOffsetY = mSmilePosition.y - mMouthPosition.y;
        float maxDistance = mMouthRadius - mSmileRadius;
        if (smileOffsetY < maxDistance) {
            return false;
        }

        return (isZero(vx) && isZero(vy));
    }

    private boolean isZero(float num) {
        return ((num < ZERO_TOLERANCE) && (num > -1 * ZERO_TOLERANCE));
    }
}
