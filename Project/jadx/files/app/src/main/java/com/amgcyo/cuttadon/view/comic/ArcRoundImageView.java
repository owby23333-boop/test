package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class ArcRoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Path f4429s;

    public ArcRoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            this.f4429s.moveTo(0.0f, 0.0f);
            this.f4429s.lineTo(0.0f, getHeight() - (getHeight() / 4));
            this.f4429s.quadTo(getWidth() / 2, getHeight() + (getHeight() / 18), getWidth(), getHeight() - (getHeight() / 4));
            this.f4429s.lineTo(getWidth(), 0.0f);
            this.f4429s.close();
            canvas.clipPath(this.f4429s);
            super.onDraw(canvas);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ArcRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4429s = new Path();
        setLayerType(1, null);
        new Paint().setAntiAlias(true);
    }
}
