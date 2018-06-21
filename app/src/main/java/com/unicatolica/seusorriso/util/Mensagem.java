package com.unicatolica.seusorriso.util;

import android.support.design.widget.Snackbar;
import android.view.View;

public class Mensagem {

    public void rodapeRapido(View view, String mensagem) {
        Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    public void rodapeLongo(View view, String mensagem) {
        Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void rodapeIndefinido(View view, String mensagem) {
        Snackbar.make(view, mensagem, Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

}
