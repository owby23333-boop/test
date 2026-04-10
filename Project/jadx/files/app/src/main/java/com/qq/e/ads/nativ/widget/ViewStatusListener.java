package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z2);

    void onWindowVisibilityChanged(int i2);
}
