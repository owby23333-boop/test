package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class by {
    private View bbI;
    public Point bbH = new Point();
    public Rect bbF = new Rect();
    public Rect bbG = new Rect();

    public by(View view) {
        this.bbI = view;
    }

    public final boolean So() {
        boolean globalVisibleRect = this.bbI.getGlobalVisibleRect(this.bbF, this.bbH);
        if (this.bbH.x == 0 && this.bbH.y == 0 && this.bbF.height() == this.bbI.getHeight() && this.bbG.height() != 0 && Math.abs(this.bbF.top - this.bbG.top) > this.bbI.getHeight() / 2) {
            this.bbF.set(this.bbG);
        }
        this.bbG.set(this.bbF);
        return globalVisibleRect;
    }
}
