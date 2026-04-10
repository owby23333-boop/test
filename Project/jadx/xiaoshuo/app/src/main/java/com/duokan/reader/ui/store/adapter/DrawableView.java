package com.duokan.reader.ui.store.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DrawableView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f6449a;

    public interface a {
        void a(Canvas canvas);
    }

    public DrawableView(Context context) {
        super(context);
    }

    public a getCanvaser() {
        return this.f6449a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.f6449a;
        if (aVar != null) {
            aVar.a(canvas);
        }
    }

    public void setCanvaser(a aVar) {
        this.f6449a = aVar;
    }

    public DrawableView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
