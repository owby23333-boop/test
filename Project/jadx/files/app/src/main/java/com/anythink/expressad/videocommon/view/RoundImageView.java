package com.anythink.expressad.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.ATImageView;

/* JADX INFO: loaded from: classes2.dex */
public class RoundImageView extends ATImageView {
    private static final String a = "RoundImageView";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12265c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12266d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12267e = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f12268m = "state_instance";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f12269n = "state_type";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f12270o = "state_border_radius";
    private int b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f12272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Matrix f12274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BitmapShader f12275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RectF f12277l;

    public RoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12274i = new Matrix();
        this.f12272g = new Paint();
        this.f12272g.setAntiAlias(true);
        this.f12271f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    private void a() {
        Bitmap bitmapA;
        try {
            Drawable drawable = getDrawable();
            if (drawable == null || (bitmapA = a(drawable)) == null || bitmapA.isRecycled()) {
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f12275j = new BitmapShader(bitmapA, tileMode, tileMode);
            float fMax = 1.0f;
            if (this.b == 0) {
                fMax = (this.f12276k * 1.0f) / Math.min(bitmapA.getWidth(), bitmapA.getHeight());
            } else if (this.b == 1) {
                fMax = Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
            }
            this.f12274i.setScale(fMax, fMax);
            this.f12275j.setLocalMatrix(this.f12274i);
            this.f12272g.setShader(this.f12275j);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.widget.ATImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        try {
            if (getDrawable() == null) {
                return;
            }
            try {
                Drawable drawable = getDrawable();
                if (drawable != null && (bitmapA = a(drawable)) != null && !bitmapA.isRecycled()) {
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    this.f12275j = new BitmapShader(bitmapA, tileMode, tileMode);
                    float fMax = 1.0f;
                    if (this.b == 0) {
                        fMax = (this.f12276k * 1.0f) / Math.min(bitmapA.getWidth(), bitmapA.getHeight());
                    } else if (this.b == 1) {
                        fMax = Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
                    }
                    this.f12274i.setScale(fMax, fMax);
                    this.f12275j.setLocalMatrix(this.f12274i);
                    this.f12272g.setShader(this.f12275j);
                }
            } catch (Throwable th) {
                o.d(a, th.getMessage());
            }
            if (this.b == 1) {
                canvas.drawRoundRect(this.f12277l, this.f12271f, this.f12271f, this.f12272g);
            } else {
                canvas.drawCircle(this.f12273h, this.f12273h, this.f12273h, this.f12272g);
            }
        } catch (Throwable th2) {
            o.d(a, th2.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.b == 0) {
            this.f12276k = Math.min(getMeasuredWidth(), getMeasuredHeight());
            int i4 = this.f12276k;
            this.f12273h = i4 / 2;
            setMeasuredDimension(i4, i4);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(f12268m));
        this.b = bundle.getInt(f12269n);
        this.f12271f = bundle.getInt(f12270o);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f12268m, super.onSaveInstanceState());
        bundle.putInt(f12269n, this.b);
        bundle.putInt(f12270o, this.f12271f);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.b == 1) {
            this.f12277l = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i2) {
        int iB = t.b(getContext(), i2);
        if (this.f12271f != iB) {
            this.f12271f = iB;
            invalidate();
        }
    }

    public void setType(int i2) {
        if (this.b != i2) {
            this.b = i2;
            int i3 = this.b;
            if (i3 != 1 && i3 != 0) {
                this.b = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12274i = new Matrix();
        this.f12272g = new Paint();
        this.f12272g.setAntiAlias(true);
        this.f12271f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.f12274i = new Matrix();
        this.f12272g = new Paint();
        this.f12272g.setAntiAlias(true);
        this.f12271f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    private static Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            o.d("View", th.getMessage());
            return null;
        }
    }
}
