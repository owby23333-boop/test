package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.yuewen.e84;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class DotProgressBar extends View {
    public static final String p = "left";
    public static final String q = "center";
    public static final String r = "right";
    public static final /* synthetic */ boolean s = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f5414b;
    public final Drawable c;
    public final String d;
    public final b e;
    public int f;
    public float g;
    public int h;
    public int i;
    public final int j;
    public final int k;
    public int l;
    public Float m;
    public Paint n;
    public boolean o;

    public final class a implements b {
        @Override // com.duokan.reader.ui.general.DotProgressBar.b
        public void draw(Canvas canvas) {
            float paddingLeft = DotProgressBar.this.getPaddingLeft() + DotProgressBar.this.g;
            DotProgressBar dotProgressBar = DotProgressBar.this;
            dotProgressBar.e(canvas, false, paddingLeft, 0, Math.min(dotProgressBar.l + 1, DotProgressBar.this.f));
            DotProgressBar dotProgressBar2 = DotProgressBar.this;
            dotProgressBar2.e(canvas, true, paddingLeft, dotProgressBar2.l + 1, DotProgressBar.this.f);
        }

        public a() {
        }
    }

    public interface b {
        void draw(Canvas canvas);
    }

    public final class c implements b {
        @Override // com.duokan.reader.ui.general.DotProgressBar.b
        public void draw(Canvas canvas) {
            float paddingLeft = DotProgressBar.this.getPaddingLeft() + DotProgressBar.this.g;
            DotProgressBar dotProgressBar = DotProgressBar.this;
            dotProgressBar.e(canvas, true, paddingLeft, 0, dotProgressBar.l);
            DotProgressBar dotProgressBar2 = DotProgressBar.this;
            dotProgressBar2.e(canvas, false, paddingLeft, dotProgressBar2.l, DotProgressBar.this.l + 1);
            DotProgressBar dotProgressBar3 = DotProgressBar.this;
            dotProgressBar3.e(canvas, true, paddingLeft, dotProgressBar3.l + 1, DotProgressBar.this.f);
        }

        public c() {
        }
    }

    public DotProgressBar(Context context) {
        this(context, null);
    }

    public final void e(Canvas canvas, boolean z, float f, int i, int i2) {
        Drawable drawable2 = z ? this.f5414b : this.c;
        while (i < i2) {
            int iRound = Math.round(((this.j + (this.k * 2)) * i) + f);
            int intrinsicHeight = (this.h / 2) - (drawable2.getIntrinsicHeight() / 2);
            drawable2.setBounds(iRound, intrinsicHeight, drawable2.getIntrinsicWidth() + iRound, drawable2.getIntrinsicHeight() + intrinsicHeight);
            drawable2.draw(canvas);
            i++;
        }
    }

    public final String f(String str) {
        return (str == null || !(str.equalsIgnoreCase("left") || str.equalsIgnoreCase("center") || str.equalsIgnoreCase("right"))) ? "left" : str;
    }

    public final void g() {
        float paddingLeft = (this.i - getPaddingLeft()) - getPaddingRight();
        int i = this.j;
        int i2 = this.f;
        float f = (i * (i2 - 1)) + (i2 * 2 * this.k);
        if (this.d.equalsIgnoreCase("left")) {
            this.g = 0.0f;
        } else if (this.d.equalsIgnoreCase("center")) {
            this.g = (paddingLeft - f) / 2.0f;
        } else {
            this.g = paddingLeft - f;
        }
    }

    public int getNums() {
        return this.f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.o) {
            this.f = Math.round(this.i / (this.j + (this.k * 2))) - 1;
        }
        if (this.m != null) {
            if (r0.floatValue() < 0.005d) {
                this.l = -1;
            } else {
                this.l = Math.round(this.m.floatValue() * this.f);
                if (0.5d < this.m.floatValue() && this.m.floatValue() < 0.995d) {
                    this.l--;
                }
            }
        }
        this.e.draw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.i = i3 - i;
            this.h = i4 - i2;
            g();
        }
    }

    public void setCurrentIndex(int i) {
        if (i < -1) {
            i = -1;
        } else {
            int i2 = this.f;
            if (i >= i2) {
                i = i2 - 1;
            }
        }
        if (this.l != i) {
            this.l = i;
            invalidate();
        }
    }

    public void setNums(int i) {
        this.f = i;
        g();
        invalidate();
    }

    public void setPercentage(float f) {
        this.m = Float.valueOf(f);
        invalidate();
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0.0f;
        this.h = 0;
        this.i = 0;
        this.l = 0;
        byte b2 = 0;
        this.m = null;
        this.n = null;
        this.o = true;
        this.j = e84.k(getContext(), 2.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, st2.u.pn);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(st2.u.qn, true);
        this.f5413a = z;
        this.c = getResources().getDrawable(typedArrayObtainStyledAttributes.getResourceId(st2.u.sn, st2.h.yj));
        this.f5414b = getResources().getDrawable(typedArrayObtainStyledAttributes.getResourceId(st2.u.tn, st2.h.zj));
        this.d = f(typedArrayObtainStyledAttributes.getString(st2.u.rn));
        this.o = typedArrayObtainStyledAttributes.getBoolean(st2.u.un, true);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            this.e = new a();
            this.k = e84.k(getContext(), 5.0f);
        } else {
            this.e = new c();
            this.k = e84.k(getContext(), 9.0f);
        }
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
    }
}
