package com.bytedance.adsdk.ugeno.component.image;

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
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable {
    private Shader.TileMode bh;
    private final RectF d;
    private ImageView.ScaleType dt;
    private float f;
    private final Paint ga;
    private ColorStateList k;
    private boolean l;
    private final Matrix m;
    private final int p;
    private float s;
    private boolean t;
    private final Bitmap tg;
    private final RectF v;
    private final int vn;
    private final boolean[] w;
    private final RectF wu;
    private Shader.TileMode xu;
    private final Paint zk;
    private final RectF e = new RectF();
    private final RectF bf = new RectF();

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.component.image.e$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            e = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                e[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                e[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                e[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                e[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public e(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.d = rectF;
        this.v = new RectF();
        this.m = new Matrix();
        this.wu = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.xu = tileMode;
        this.bh = tileMode;
        this.t = true;
        this.s = 0.0f;
        this.w = new boolean[]{true, true, true, true};
        this.l = false;
        this.f = 0.0f;
        this.k = ColorStateList.valueOf(-16777216);
        this.dt = ImageView.ScaleType.FIT_CENTER;
        this.tg = bitmap;
        int width = bitmap.getWidth();
        this.vn = width;
        int height = bitmap.getHeight();
        this.p = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.ga = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.zk = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.k.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f);
    }

    public static Bitmap bf(Drawable drawable2) {
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable2.getIntrinsicWidth(), 2), Math.max(drawable2.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable2.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static e e(Bitmap bitmap) {
        if (bitmap != null) {
            return new e(bitmap);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.t) {
            BitmapShader bitmapShader = new BitmapShader(this.tg, this.xu, this.bh);
            Shader.TileMode tileMode = this.xu;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.bh == tileMode2) {
                bitmapShader.setLocalMatrix(this.m);
            }
            this.ga.setShader(bitmapShader);
            this.t = false;
        }
        if (this.l) {
            if (this.f <= 0.0f) {
                canvas.drawOval(this.bf, this.ga);
                return;
            } else {
                canvas.drawOval(this.bf, this.ga);
                canvas.drawOval(this.v, this.zk);
                return;
            }
        }
        if (!e(this.w)) {
            canvas.drawRect(this.bf, this.ga);
            if (this.f > 0.0f) {
                canvas.drawRect(this.v, this.zk);
                return;
            }
            return;
        }
        float f = this.s;
        if (this.f <= 0.0f) {
            canvas.drawRoundRect(this.bf, f, f, this.ga);
            e(canvas);
        } else {
            canvas.drawRoundRect(this.bf, f, f, this.ga);
            canvas.drawRoundRect(this.v, f, f, this.zk);
            e(canvas);
            bf(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ga.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.ga.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.vn;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.k.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.e.set(rect);
        e();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.k.getColorForState(iArr, 0);
        if (this.zk.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.zk.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.ga.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ga.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.ga.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.ga.setFilterBitmap(z);
        invalidateSelf();
    }

    public static Drawable e(Drawable drawable2) {
        if (drawable2 == null || (drawable2 instanceof e)) {
            return drawable2;
        }
        if (!(drawable2 instanceof LayerDrawable)) {
            Bitmap bitmapBf = bf(drawable2);
            return bitmapBf != null ? new e(bitmapBf) : drawable2;
        }
        Drawable.ConstantState constantState = drawable2.mutate().getConstantState();
        if (constantState != null) {
            drawable2 = constantState.newDrawable();
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable2;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i = 0; i < numberOfLayers; i++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), e(layerDrawable.getDrawable(i)));
        }
        return layerDrawable;
    }

    private void bf(Canvas canvas) {
        float f;
        if (bf(this.w) || this.s == 0.0f) {
            return;
        }
        RectF rectF = this.bf;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = f3 + this.bf.height();
        float f4 = this.s;
        float f5 = this.f / 2.0f;
        if (!this.w[0]) {
            canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.zk);
            canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.zk);
        }
        if (!this.w[1]) {
            canvas.drawLine((fWidth - f4) - f5, f3, fWidth, f3, this.zk);
            canvas.drawLine(fWidth, f3 - f5, fWidth, f3 + f4, this.zk);
        }
        if (this.w[2]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine((fWidth - f4) - f5, fHeight, fWidth + f5, fHeight, this.zk);
            canvas.drawLine(fWidth, fHeight - f, fWidth, fHeight, this.zk);
        }
        if (this.w[3]) {
            return;
        }
        canvas.drawLine(f2 - f5, fHeight, f2 + f, fHeight, this.zk);
        canvas.drawLine(f2, fHeight - f, f2, fHeight, this.zk);
    }

    private void e() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.e[this.dt.ordinal()];
        if (i == 1) {
            this.v.set(this.e);
            RectF rectF = this.v;
            float f = this.f;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.m.reset();
            this.m.setTranslate((int) (((this.v.width() - this.vn) * 0.5f) + 0.5f), (int) (((this.v.height() - this.p) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.v.set(this.e);
            RectF rectF2 = this.v;
            float f2 = this.f;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.m.reset();
            float fWidth2 = 0.0f;
            if (this.vn * this.v.height() > this.v.width() * this.p) {
                fWidth = this.v.height() / this.p;
                fHeight = 0.0f;
                fWidth2 = (this.v.width() - (this.vn * fWidth)) * 0.5f;
            } else {
                fWidth = this.v.width() / this.vn;
                fHeight = (this.v.height() - (this.p * fWidth)) * 0.5f;
            }
            this.m.setScale(fWidth, fWidth);
            Matrix matrix = this.m;
            float f3 = this.f;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.m.reset();
            float fMin = (((float) this.vn) > this.e.width() || ((float) this.p) > this.e.height()) ? Math.min(this.e.width() / this.vn, this.e.height() / this.p) : 1.0f;
            float fWidth3 = (int) (((this.e.width() - (this.vn * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.e.height() - (this.p * fMin)) * 0.5f) + 0.5f);
            this.m.setScale(fMin, fMin);
            this.m.postTranslate(fWidth3, fHeight2);
            this.v.set(this.d);
            this.m.mapRect(this.v);
            RectF rectF3 = this.v;
            float f4 = this.f;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.m.setRectToRect(this.d, this.v, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.v.set(this.d);
            this.m.setRectToRect(this.d, this.e, Matrix.ScaleToFit.END);
            this.m.mapRect(this.v);
            RectF rectF4 = this.v;
            float f5 = this.f;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.m.setRectToRect(this.d, this.v, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.v.set(this.d);
            this.m.setRectToRect(this.d, this.e, Matrix.ScaleToFit.START);
            this.m.mapRect(this.v);
            RectF rectF5 = this.v;
            float f6 = this.f;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.m.setRectToRect(this.d, this.v, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.v.set(this.d);
            this.m.setRectToRect(this.d, this.e, Matrix.ScaleToFit.CENTER);
            this.m.mapRect(this.v);
            RectF rectF6 = this.v;
            float f7 = this.f;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.m.setRectToRect(this.d, this.v, Matrix.ScaleToFit.FILL);
        } else {
            this.v.set(this.e);
            RectF rectF7 = this.v;
            float f8 = this.f;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.m.reset();
            this.m.setRectToRect(this.d, this.v, Matrix.ScaleToFit.FILL);
        }
        this.bf.set(this.v);
        this.t = true;
    }

    public e bf(Shader.TileMode tileMode) {
        if (this.bh != tileMode) {
            this.bh = tileMode;
            this.t = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean bf(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private void e(Canvas canvas) {
        if (bf(this.w) || this.s == 0.0f) {
            return;
        }
        RectF rectF = this.bf;
        float f = rectF.left;
        float f2 = rectF.top;
        float fWidth = rectF.width() + f;
        float fHeight = this.bf.height() + f2;
        float f3 = this.s;
        if (!this.w[0]) {
            this.wu.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.wu, this.ga);
        }
        if (!this.w[1]) {
            this.wu.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.wu, this.ga);
        }
        if (!this.w[2]) {
            this.wu.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.wu, this.ga);
        }
        if (this.w[3]) {
            return;
        }
        this.wu.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.wu, this.ga);
    }

    public e e(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(fFloatValue) && !Float.isNaN(fFloatValue) && fFloatValue >= 0.0f) {
                    this.s = fFloatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + fFloatValue);
                }
            } else {
                this.s = 0.0f;
            }
            boolean[] zArr = this.w;
            zArr[0] = f > 0.0f;
            zArr[1] = f2 > 0.0f;
            zArr[2] = f3 > 0.0f;
            zArr[3] = f4 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public e e(float f) {
        this.f = f;
        this.zk.setStrokeWidth(f);
        return this;
    }

    public e e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.k = colorStateList;
        this.zk.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public e e(boolean z) {
        this.l = z;
        return this;
    }

    public e e(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.dt != scaleType) {
            this.dt = scaleType;
            e();
        }
        return this;
    }

    public e e(Shader.TileMode tileMode) {
        if (this.xu != tileMode) {
            this.xu = tileMode;
            this.t = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean e(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }
}
