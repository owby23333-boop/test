package com.yuewen;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public class be4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f9056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9057b;
    public final LinkedList<a> c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f9059b;

        public a() {
            this.f9058a = 0;
            this.f9059b = new PointF();
        }
    }

    public be4() {
        this.f9056a = null;
        this.f9057b = 0;
        this.c = new LinkedList<>();
    }

    public void a() {
        this.f9056a = null;
        this.f9057b = 0;
        this.c.clear();
    }

    public PointF b(int i, PointF pointF) {
        PointF pointF2 = this.c.get(i).f9059b;
        pointF.set(pointF2.x, pointF2.y);
        return pointF;
    }

    public int c(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (this.c.get(i2).f9058a == i) {
                return i2;
            }
        }
        return -1;
    }

    public int d() {
        return this.f9057b;
    }

    public int e() {
        return this.c.size();
    }

    public int f(int i) {
        return this.c.get(i).f9058a;
    }

    public float g(int i) {
        return this.c.get(i).f9059b.x;
    }

    public float h(int i) {
        return this.c.get(i).f9059b.y;
    }

    public View i() {
        return this.f9056a;
    }

    public boolean j() {
        return this.f9056a == null;
    }

    public void k(be4 be4Var) {
        a();
        if (be4Var != null) {
            this.f9056a = be4Var.f9056a;
            this.f9057b = be4Var.f9057b;
            this.c.addAll(be4Var.c);
        }
    }

    public PointF l(PointF pointF) {
        e84.o1(pointF, this.f9056a);
        return pointF;
    }

    public PointF m(PointF pointF) {
        e84.u1(pointF, this.f9056a);
        pointF.offset(-this.f9056a.getScrollX(), -this.f9056a.getScrollY());
        return pointF;
    }

    public be4(View view, MotionEvent motionEvent) {
        this.f9056a = null;
        this.f9057b = 0;
        this.c = new LinkedList<>();
        this.f9056a = view;
        this.f9057b = motionEvent.getActionMasked();
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            a aVar = new a();
            aVar.f9058a = motionEvent.getPointerId(i);
            aVar.f9059b.x = motionEvent.getX(i) + this.f9056a.getScrollX();
            aVar.f9059b.y = motionEvent.getY(i) + this.f9056a.getScrollY();
            e84.w1(aVar.f9059b, this.f9056a);
            this.c.add(aVar);
        }
    }
}
