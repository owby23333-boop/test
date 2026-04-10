package com.lcodecore.tkrefreshlayout;

import android.view.MotionEvent;

/* JADX INFO: compiled from: OnGestureListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d {
    void a(MotionEvent motionEvent, boolean z2);

    void onDown(MotionEvent motionEvent);

    void onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

    void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
}
