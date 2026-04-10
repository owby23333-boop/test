package com.yuewen;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public interface ok1 {
    /* JADX WARN: Multi-variable type inference failed */
    static <T extends View> T b(View view, int i) {
        if (!(view instanceof ok1)) {
            return (T) view.findViewById(i);
        }
        ok1 ok1Var = (ok1) view;
        T t = (T) ok1Var.e(i);
        if (t == null) {
            t = (T) view.findViewById(i);
        }
        if (t == null) {
            return t;
        }
        ok1Var.c(i, t);
        return t;
    }

    void c(int i, View view);

    View e(int i);

    View getAdView();

    void setAdType(int i);

    void setViewLifeCycleListener(rl1 rl1Var);
}
