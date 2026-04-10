package com.yuewen;

import android.graphics.Canvas;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes12.dex */
public final class kc3 implements nd4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nd4 f13445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nd4 f13446b;
    public nd4 c;

    public kc3(u01 u01Var) {
        this.f13445a = new t01(u01Var);
        jw0 jw0Var = new jw0();
        this.f13446b = jw0Var;
        this.c = jw0Var;
    }

    @Override // com.yuewen.nd4
    public boolean a(MotionEvent motionEvent) {
        return this.c.a(motionEvent);
    }

    @Override // com.yuewen.nd4
    public void b(int i) {
        this.c.b(i);
    }

    @Override // com.yuewen.nd4
    public void c(Canvas canvas) {
        this.c.c(canvas);
    }

    @Override // com.yuewen.nd4
    public boolean d() {
        return this.c.d();
    }

    public void e(boolean z) {
        if (z) {
            this.c = this.f13445a;
        } else {
            this.c = this.f13446b;
        }
    }

    @Override // com.yuewen.nd4
    public void onAttachedToWindow() {
        this.c.onAttachedToWindow();
    }

    @Override // com.yuewen.nd4
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.c.onTouchEvent(motionEvent);
    }

    @Override // com.yuewen.nd4
    public void onWindowVisibilityChanged(int i) {
        this.c.onWindowVisibilityChanged(i);
    }
}
