package com.duokan.reader.ui.store.selection;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6527b;
    public float c;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public Paint l;
    public int m;
    public boolean n;
    public int o;
    public int[] p;
    public int q;
    public boolean r;
    public boolean s;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        this.l.setAlpha(this.f);
        this.l.setShader(null);
        this.l.setColor(this.o);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.k);
        int i = this.f6526a;
        canvas.drawCircle(i / 2, i / 2, this.c - (this.j / 2.0f), this.l);
    }

    public final void b(Canvas canvas) {
        if (this.p != null) {
            int i = this.j;
            this.l.setShader(new LinearGradient(i, i, getMeasuredWidth() - this.j, getMeasuredHeight() - this.j, this.p, (float[]) null, Shader.TileMode.MIRROR));
        } else {
            this.l.setColor(this.g);
        }
        float f = this.r ? 360 - ((this.m * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) / 100) : (this.m * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) / 100;
        RectF rectF = new RectF();
        if (!this.n) {
            this.l.setStyle(Paint.Style.FILL);
            rectF.left = 0.0f;
            int i2 = this.f6527b;
            float f2 = this.c;
            rectF.top = (i2 / 2.0f) - f2;
            rectF.right = f2 * 2.0f;
            rectF.bottom = (i2 / 2.0f) + f2;
            canvas.drawArc(rectF, this.q, f, true, this.l);
            return;
        }
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.j);
        this.l.setStrokeCap(Paint.Cap.ROUND);
        int i3 = this.j;
        rectF.left = i3 / 2.0f;
        int i4 = this.f6527b;
        float f3 = this.c;
        rectF.top = ((i4 / 2.0f) - f3) + (i3 / 2.0f);
        rectF.right = (f3 * 2.0f) - (i3 / 2.0f);
        rectF.bottom = ((i4 / 2.0f) + f3) - (i3 / 2.0f);
        canvas.drawArc(rectF, this.q, f, false, this.l);
    }

    public final void c(Canvas canvas) {
        this.l.setColor(this.h);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setTextSize(this.i);
        Rect rect = new Rect();
        String str = this.m + "%";
        this.l.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, this.d - (rect.width() / 2.0f), this.e + (rect.height() / 2.0f), this.l);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        a(canvas);
        b(canvas);
        if (this.s) {
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f6526a = getMeasuredWidth();
        this.f6527b = getMeasuredHeight();
        this.c = Math.min(this.f6526a, r1) / 2.0f;
        this.d = this.f6526a / 2.0f;
        this.e = this.f6527b / 2.0f;
    }

    public void setBackgroundRingWidth(float f) {
        this.k = f;
    }

    public void setCircleBackgroundAlpha(int i) {
        this.f = i;
    }

    public void setCircleRingColor(int i) {
        this.g = i;
        this.p = null;
    }

    public void setCircleRingStyle(boolean z) {
        this.n = z;
    }

    public void setCircleRingWidth(int i) {
        this.j = i;
    }

    public void setColorArray(int[] iArr) {
        this.p = iArr;
    }

    public void setIsCw(boolean z) {
        this.r = z;
    }

    public void setIsDrawText(boolean z) {
        this.s = z;
    }

    public void setIsRingStyle(boolean z) {
        this.n = z;
    }

    public void setProgressTextColor(int i) {
        this.h = i;
    }

    public void setProgressTextSize(int i) {
        this.i = i;
    }

    public void setRingBackgroundColor(int i) {
        this.o = i;
    }

    public void setStartAngle(int i) {
        this.q = i;
    }

    public void setValue(int i) {
        this.m = i;
        invalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 256;
        this.g = Color.parseColor("#FF942B");
        this.h = -16777216;
        this.i = 32;
        this.j = 14;
        this.k = 10.0f;
        this.o = Color.parseColor("#ccc0c0c0");
        this.q = -90;
        this.r = true;
        this.s = true;
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setStyle(Paint.Style.FILL);
    }
}
