package com.dangdang.reader.dread.config;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public class TmpRect {
    public static final int TYPE_CURRENT = 1;
    public static final int TYPE_NOCURR = -1;
    private Rect[] rects;
    private int type = 1;

    public Rect[] getRects() {
        return this.rects;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCurrent() {
        return this.type == 1;
    }

    public void setRects(Rect[] rectArr) {
        this.rects = rectArr;
    }

    public void setType(int i) {
        this.type = i;
    }
}
