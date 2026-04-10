package com.yuewen;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.reader.domain.document.TextAnchor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o81 implements ek2 {
    @Override // com.yuewen.ek2
    public abstract int getHeight();

    @Override // com.yuewen.ek2
    public abstract int getWidth();

    public abstract Drawable r();

    public abstract ek2 s(int i);

    public abstract Rect t(int i);

    public abstract int u();

    public abstract Rect v();

    public abstract int w();

    public abstract TextAnchor x(Point point, Point point2);

    public abstract void y(int i);
}
