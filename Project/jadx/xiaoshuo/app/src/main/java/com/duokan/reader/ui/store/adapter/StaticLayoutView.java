package com.duokan.reader.ui.store.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class StaticLayoutView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StaticLayout f6450a;

    public StaticLayoutView(Context context) {
        super(context);
    }

    public StaticLayout getStaticLayout() {
        return this.f6450a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        StaticLayout staticLayout = this.f6450a;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    public void setStaticLayout(StaticLayout staticLayout) {
        this.f6450a = staticLayout;
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
