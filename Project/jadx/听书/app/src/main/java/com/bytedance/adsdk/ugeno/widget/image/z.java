package com.bytedance.adsdk.ugeno.widget.image;

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
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.wp;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f254a;
    private final RectF dl;
    private final int e;
    private final Paint fo;
    private float fv;
    private final Paint gc;
    private final RectF gz;
    private Shader.TileMode i;
    private ColorStateList js;
    private final RectF kb;
    private final boolean[] ls;
    private final int m;
    private boolean p;
    private float pf;
    private ImageView.ScaleType tb;
    private final Matrix uy;
    private boolean v;
    private Shader.TileMode wp;
    private final RectF z = new RectF();
    private final RectF g = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public z(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.dl = rectF;
        this.gz = new RectF();
        this.uy = new Matrix();
        this.kb = new RectF();
        this.wp = Shader.TileMode.CLAMP;
        this.i = Shader.TileMode.CLAMP;
        this.v = true;
        this.pf = 0.0f;
        this.ls = new boolean[]{true, true, true, true};
        this.p = false;
        this.fv = 0.0f;
        this.js = ColorStateList.valueOf(-16777216);
        this.tb = ImageView.ScaleType.FIT_CENTER;
        this.f254a = bitmap;
        int width = bitmap.getWidth();
        this.m = width;
        int height = bitmap.getHeight();
        this.e = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.gc = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.fo = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.js.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.fv);
    }

    public static z z(Bitmap bitmap) {
        if (bitmap != null) {
            return new z(bitmap);
        }
        return null;
    }

    public static Drawable z(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof z) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), z(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapG = g(drawable);
        return bitmapG != null ? new z(bitmapG) : drawable;
    }

    public static Bitmap g(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            wp.z(th);
            wp.g("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.js.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.js.getColorForState(iArr, 0);
        if (this.fo.getColor() != colorForState) {
            this.fo.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.z$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            z = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                z[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void z() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.z[this.tb.ordinal()];
        if (i == 1) {
            this.gz.set(this.z);
            RectF rectF = this.gz;
            float f = this.fv;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.uy.reset();
            this.uy.setTranslate((int) (((this.gz.width() - this.m) * 0.5f) + 0.5f), (int) (((this.gz.height() - this.e) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.gz.set(this.z);
            RectF rectF2 = this.gz;
            float f2 = this.fv;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.uy.reset();
            float fWidth2 = 0.0f;
            if (this.m * this.gz.height() > this.gz.width() * this.e) {
                fWidth = this.gz.height() / this.e;
                fHeight = 0.0f;
                fWidth2 = (this.gz.width() - (this.m * fWidth)) * 0.5f;
            } else {
                fWidth = this.gz.width() / this.m;
                fHeight = (this.gz.height() - (this.e * fWidth)) * 0.5f;
            }
            this.uy.setScale(fWidth, fWidth);
            Matrix matrix = this.uy;
            float f3 = this.fv;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.uy.reset();
            float fMin = (((float) this.m) > this.z.width() || ((float) this.e) > this.z.height()) ? Math.min(this.z.width() / this.m, this.z.height() / this.e) : 1.0f;
            float fWidth3 = (int) (((this.z.width() - (this.m * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.z.height() - (this.e * fMin)) * 0.5f) + 0.5f);
            this.uy.setScale(fMin, fMin);
            this.uy.postTranslate(fWidth3, fHeight2);
            this.gz.set(this.dl);
            this.uy.mapRect(this.gz);
            RectF rectF3 = this.gz;
            float f4 = this.fv;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.uy.setRectToRect(this.dl, this.gz, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.gz.set(this.dl);
            this.uy.setRectToRect(this.dl, this.z, Matrix.ScaleToFit.END);
            this.uy.mapRect(this.gz);
            RectF rectF4 = this.gz;
            float f5 = this.fv;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.uy.setRectToRect(this.dl, this.gz, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.gz.set(this.dl);
            this.uy.setRectToRect(this.dl, this.z, Matrix.ScaleToFit.START);
            this.uy.mapRect(this.gz);
            RectF rectF5 = this.gz;
            float f6 = this.fv;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.uy.setRectToRect(this.dl, this.gz, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.gz.set(this.dl);
            this.uy.setRectToRect(this.dl, this.z, Matrix.ScaleToFit.CENTER);
            this.uy.mapRect(this.gz);
            RectF rectF6 = this.gz;
            float f7 = this.fv;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.uy.setRectToRect(this.dl, this.gz, Matrix.ScaleToFit.FILL);
        } else {
            this.gz.set(this.z);
            RectF rectF7 = this.gz;
            float f8 = this.fv;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.uy.reset();
            this.uy.setRectToRect(this.dl, this.gz, Matrix.ScaleToFit.FILL);
        }
        this.g.set(this.gz);
        this.v = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.z.set(rect);
        z();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.v) {
            BitmapShader bitmapShader = new BitmapShader(this.f254a, this.wp, this.i);
            if (this.wp == Shader.TileMode.CLAMP && this.i == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.uy);
            }
            this.gc.setShader(bitmapShader);
            this.v = false;
        }
        if (this.p) {
            if (this.fv > 0.0f) {
                canvas.drawOval(this.g, this.gc);
                canvas.drawOval(this.gz, this.fo);
                return;
            } else {
                canvas.drawOval(this.g, this.gc);
                return;
            }
        }
        if (z(this.ls)) {
            float f = this.pf;
            if (this.fv > 0.0f) {
                canvas.drawRoundRect(this.g, f, f, this.gc);
                canvas.drawRoundRect(this.gz, f, f, this.fo);
                z(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.g, f, f, this.gc);
            z(canvas);
            return;
        }
        canvas.drawRect(this.g, this.gc);
        if (this.fv > 0.0f) {
            canvas.drawRect(this.gz, this.fo);
        }
    }

    private void z(Canvas canvas) {
        if (g(this.ls) || this.pf == 0.0f) {
            return;
        }
        float f = this.g.left;
        float f2 = this.g.top;
        float fWidth = this.g.width() + f;
        float fHeight = this.g.height() + f2;
        float f3 = this.pf;
        if (!this.ls[0]) {
            this.kb.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.kb, this.gc);
        }
        if (!this.ls[1]) {
            this.kb.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.kb, this.gc);
        }
        if (!this.ls[2]) {
            this.kb.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.kb, this.gc);
        }
        if (this.ls[3]) {
            return;
        }
        this.kb.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.kb, this.gc);
    }

    private void g(Canvas canvas) {
        if (g(this.ls) || this.pf == 0.0f) {
            return;
        }
        float f = this.g.left;
        float f2 = this.g.top;
        float fWidth = f + this.g.width();
        float fHeight = f2 + this.g.height();
        float f3 = this.pf;
        float f4 = this.fv / 2.0f;
        if (!this.ls[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.fo);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.fo);
        }
        if (!this.ls[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.fo);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.fo);
        }
        if (!this.ls[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.fo);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.fo);
        }
        if (this.ls[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.fo);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.fo);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.gc.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.gc.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.gc.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.gc.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.gc.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.gc.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.e;
    }

    public z z(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.pf = fFloatValue;
        } else {
            this.pf = 0.0f;
        }
        boolean[] zArr = this.ls;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public z z(float f) {
        this.fv = f;
        this.fo.setStrokeWidth(f);
        return this;
    }

    public z z(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.js = colorStateList;
        this.fo.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public z z(boolean z) {
        this.p = z;
        return this;
    }

    public z z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.tb != scaleType) {
            this.tb = scaleType;
            z();
        }
        return this;
    }

    public z z(Shader.TileMode tileMode) {
        if (this.wp != tileMode) {
            this.wp = tileMode;
            this.v = true;
            invalidateSelf();
        }
        return this;
    }

    public z g(Shader.TileMode tileMode) {
        if (this.i != tileMode) {
            this.i = tileMode;
            this.v = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean z(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean g(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
