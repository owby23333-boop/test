package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class bj {
    private View aAt;
    public Point aAs = new Point();
    public Rect aAq = new Rect();
    public Rect aAr = new Rect();

    public bj(View view) {
        this.aAt = view;
    }

    public final boolean EW() {
        boolean globalVisibleRect = this.aAt.getGlobalVisibleRect(this.aAq, this.aAs);
        Point point = this.aAs;
        if (point.x == 0 && point.y == 0 && this.aAq.height() == this.aAt.getHeight() && this.aAr.height() != 0 && Math.abs(this.aAq.top - this.aAr.top) > this.aAt.getHeight() / 2) {
            this.aAq.set(this.aAr);
        }
        this.aAr.set(this.aAq);
        return globalVisibleRect;
    }
}
