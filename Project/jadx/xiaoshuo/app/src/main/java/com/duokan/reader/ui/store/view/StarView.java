package com.duokan.reader.ui.store.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.yuewen.w51;
import com.yuewen.yt2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class StarView extends View {
    public static int m = yt2.h.pn;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f6541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f6542b;
    public Path c;
    public float[] d;
    public int e;
    public int f;
    public double g;
    public int h;
    public int i;
    public Rect j;
    public Rect k;
    public int l;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        public static final int y = 0;
        public static final int z = 1;
    }

    public StarView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f6541a = BitmapFactory.decodeResource(getResources(), m);
        this.f6542b = new Paint();
        this.c = new Path();
        this.f6542b.setAntiAlias(true);
        this.d = new float[this.e];
        this.j = new Rect();
        this.k = new Rect();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double d = this.g;
        if (d == w51.l) {
            return;
        }
        int i = this.h;
        float f = i >= 5 ? this.d[4] + this.f : (float) (((double) this.d[i]) + (((double) this.f) * (d - ((double) i))));
        if (this.l == 1) {
            canvas.clipRect(0.0f, 0.0f, f, this.f);
        } else {
            this.c.moveTo(0.0f, 0.0f);
            if (this.g - ((double) this.h) == w51.l) {
                this.c.lineTo(f, 0.0f);
                this.c.lineTo(f, this.f);
            } else {
                this.c.lineTo((this.f / 2.0f) + f, 0.0f);
                Path path = this.c;
                int i2 = this.f;
                path.lineTo(f - (i2 / 3.0f), i2);
            }
            this.c.lineTo(0.0f, this.f);
            this.c.lineTo(0.0f, 0.0f);
            canvas.clipPath(this.c);
        }
        this.j.set(0, 0, this.f6541a.getWidth(), this.f6541a.getHeight());
        this.k.set(0, 0, getWidth(), this.f);
        canvas.drawBitmap(this.f6541a, this.j, this.k, this.f6542b);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        this.f = size;
        int i3 = size * this.e;
        this.i = i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        for (int i4 = 0; i4 < this.e; i4++) {
            this.d[i4] = this.f * i4;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    public void setScore(double d) {
        double d2 = d / 2.0d;
        int i = this.e;
        if (d2 > i) {
            d2 = i;
        }
        if (d2 < w51.l) {
            d2 = 0.0d;
        }
        this.g = d2;
        this.h = (int) d2;
        invalidate();
    }

    public void setStarDrawble(int i) {
        this.f6541a = BitmapFactory.decodeResource(getResources(), i);
    }

    public StarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 5;
        this.l = 1;
        m = context.obtainStyledAttributes(attributeSet, yt2.t.QF).getResourceId(yt2.t.RF, yt2.h.pn);
        a();
    }
}
