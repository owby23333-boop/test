package com.amgcyo.cuttadon.view.showcaseview.j;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {
    private final View a;

    public b(View view) {
        this.a = view;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.j.a
    public Rect a() {
        int[] iArr = new int[2];
        this.a.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + this.a.getMeasuredWidth(), iArr[1] + this.a.getMeasuredHeight());
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.j.a
    public Point b() {
        int[] iArr = new int[2];
        this.a.getLocationInWindow(iArr);
        return new Point(iArr[0] + (this.a.getWidth() / 2), iArr[1] + (this.a.getHeight() / 2));
    }

    public View c() {
        return this.a;
    }
}
