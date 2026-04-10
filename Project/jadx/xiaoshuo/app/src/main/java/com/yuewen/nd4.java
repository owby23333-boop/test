package com.yuewen;

import android.graphics.Canvas;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes12.dex */
public interface nd4 {
    boolean a(MotionEvent motionEvent);

    void b(int i);

    void c(Canvas canvas);

    boolean d();

    void onAttachedToWindow();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onWindowVisibilityChanged(int i);
}
