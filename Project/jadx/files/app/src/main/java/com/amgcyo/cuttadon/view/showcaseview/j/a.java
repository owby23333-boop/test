package com.amgcyo.cuttadon.view.showcaseview.j;

import android.graphics.Point;
import android.graphics.Rect;

/* JADX INFO: compiled from: Target.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.showcaseview.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Target.java */
    class C0120a implements a {
        C0120a() {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.j.a
        public Rect a() {
            Point pointB = b();
            int i2 = pointB.x;
            int i3 = pointB.y;
            return new Rect(i2 - 190, i3 - 190, i2 + 190, i3 + 190);
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.j.a
        public Point b() {
            return new Point(1000000, 1000000);
        }
    }

    static {
        new C0120a();
    }

    Rect a();

    Point b();
}
