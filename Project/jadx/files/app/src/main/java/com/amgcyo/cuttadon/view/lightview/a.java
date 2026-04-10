package com.amgcyo.cuttadon.view.lightview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: RoundedDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitmapShader f4862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f4863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f4865g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f4867i;
    private final RectF a = new RectF();
    private final RectF b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f4861c = new RectF();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f4866h = new RectF();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Matrix f4868j = new Matrix();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f4869k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4870l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4871m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorStateList f4872n = ColorStateList.valueOf(-16777216);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView.ScaleType f4873o = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.lightview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RoundedDrawable.java */
    static /* synthetic */ class C0116a {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        this.f4864f = bitmap.getWidth();
        this.f4865g = bitmap.getHeight();
        this.f4861c.set(0.0f, 0.0f, this.f4864f, this.f4865g);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f4862d = new BitmapShader(bitmap, tileMode, tileMode);
        this.f4862d.setLocalMatrix(this.f4868j);
        this.f4863e = new Paint();
        this.f4863e.setStyle(Paint.Style.FILL);
        this.f4863e.setAntiAlias(true);
        this.f4863e.setFilterBitmap(true);
        this.f4863e.setShader(this.f4862d);
        this.f4867i = new Paint();
        this.f4867i.setStyle(Paint.Style.STROKE);
        this.f4867i.setAntiAlias(true);
        this.f4867i.setColor(this.f4872n.getColorForState(getState(), -16777216));
        this.f4867i.setStrokeWidth(this.f4871m);
    }

    public static a a(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable b(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapA = a(drawable);
            return bitmapA != null ? new a(bitmapA) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), b(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4870l) {
            if (this.f4871m <= 0.0f) {
                canvas.drawOval(this.b, this.f4863e);
                return;
            } else {
                canvas.drawOval(this.b, this.f4863e);
                canvas.drawOval(this.f4866h, this.f4867i);
                return;
            }
        }
        if (this.f4871m <= 0.0f) {
            RectF rectF = this.b;
            float f2 = this.f4869k;
            canvas.drawRoundRect(rectF, f2, f2, this.f4863e);
        } else {
            canvas.drawRoundRect(this.b, Math.max(this.f4869k, 0.0f), Math.max(this.f4869k, 0.0f), this.f4863e);
            RectF rectF2 = this.f4866h;
            float f3 = this.f4869k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f4867i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4865g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4864f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f4872n.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f4872n.getColorForState(iArr, 0);
        if (this.f4867i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f4867i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f4863e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4863e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f4863e.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f4863e.setFilterBitmap(z2);
        invalidateSelf();
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 1), Math.max(drawable.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a() {
        float fWidth;
        float fWidth2;
        int i2 = C0116a.a[this.f4873o.ordinal()];
        if (i2 == 1) {
            this.f4866h.set(this.a);
            RectF rectF = this.f4866h;
            float f2 = this.f4871m;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.f4868j.set(null);
            this.f4868j.setTranslate((int) (((this.f4866h.width() - this.f4864f) * 0.5f) + 0.5f), (int) (((this.f4866h.height() - this.f4865g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f4866h.set(this.a);
            RectF rectF2 = this.f4866h;
            float f3 = this.f4871m;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.f4868j.set(null);
            float fHeight = 0.0f;
            if (this.f4864f * this.f4866h.height() > this.f4866h.width() * this.f4865g) {
                fWidth = this.f4866h.height() / this.f4865g;
                fWidth2 = (this.f4866h.width() - (this.f4864f * fWidth)) * 0.5f;
            } else {
                fWidth = this.f4866h.width() / this.f4864f;
                fHeight = (this.f4866h.height() - (this.f4865g * fWidth)) * 0.5f;
                fWidth2 = 0.0f;
            }
            this.f4868j.setScale(fWidth, fWidth);
            Matrix matrix = this.f4868j;
            float f4 = this.f4871m;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + f4, ((int) (fHeight + 0.5f)) + f4);
        } else if (i2 == 3) {
            this.f4868j.set(null);
            float fMin = (((float) this.f4864f) > this.a.width() || ((float) this.f4865g) > this.a.height()) ? Math.min(this.a.width() / this.f4864f, this.a.height() / this.f4865g) : 1.0f;
            float fWidth3 = (int) (((this.a.width() - (this.f4864f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.a.height() - (this.f4865g * fMin)) * 0.5f) + 0.5f);
            this.f4868j.setScale(fMin, fMin);
            this.f4868j.postTranslate(fWidth3, fHeight2);
            this.f4866h.set(this.f4861c);
            this.f4868j.mapRect(this.f4866h);
            RectF rectF3 = this.f4866h;
            float f5 = this.f4871m;
            rectF3.inset(f5 / 2.0f, f5 / 2.0f);
            this.f4868j.setRectToRect(this.f4861c, this.f4866h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f4866h.set(this.f4861c);
            this.f4868j.setRectToRect(this.f4861c, this.a, Matrix.ScaleToFit.END);
            this.f4868j.mapRect(this.f4866h);
            RectF rectF4 = this.f4866h;
            float f6 = this.f4871m;
            rectF4.inset(f6 / 2.0f, f6 / 2.0f);
            this.f4868j.setRectToRect(this.f4861c, this.f4866h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f4866h.set(this.f4861c);
            this.f4868j.setRectToRect(this.f4861c, this.a, Matrix.ScaleToFit.START);
            this.f4868j.mapRect(this.f4866h);
            RectF rectF5 = this.f4866h;
            float f7 = this.f4871m;
            rectF5.inset(f7 / 2.0f, f7 / 2.0f);
            this.f4868j.setRectToRect(this.f4861c, this.f4866h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f4866h.set(this.f4861c);
            this.f4868j.setRectToRect(this.f4861c, this.a, Matrix.ScaleToFit.CENTER);
            this.f4868j.mapRect(this.f4866h);
            RectF rectF6 = this.f4866h;
            float f8 = this.f4871m;
            rectF6.inset(f8 / 2.0f, f8 / 2.0f);
            this.f4868j.setRectToRect(this.f4861c, this.f4866h, Matrix.ScaleToFit.FILL);
        } else {
            this.f4866h.set(this.a);
            RectF rectF7 = this.f4866h;
            float f9 = this.f4871m;
            rectF7.inset(f9 / 2.0f, f9 / 2.0f);
            this.f4868j.set(null);
            this.f4868j.setRectToRect(this.f4861c, this.f4866h, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.f4866h);
        this.f4862d.setLocalMatrix(this.f4868j);
    }

    public a a(float f2) {
        this.f4869k = f2;
        return this;
    }

    public a a(int i2) {
        this.f4871m = i2;
        this.f4867i.setStrokeWidth(this.f4871m);
        return this;
    }

    public a a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4872n = colorStateList;
        this.f4867i.setColor(this.f4872n.getColorForState(getState(), -16777216));
        return this;
    }

    public a a(boolean z2) {
        this.f4870l = z2;
        return this;
    }

    public a a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f4873o != scaleType) {
            this.f4873o = scaleType;
            a();
        }
        return this;
    }
}
