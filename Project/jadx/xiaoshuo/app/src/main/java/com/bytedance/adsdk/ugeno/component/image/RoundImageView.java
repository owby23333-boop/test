package com.bytedance.adsdk.ugeno.component.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class RoundImageView extends ImageView {
    static final /* synthetic */ boolean bf = true;
    private boolean bh;
    private Shader.TileMode f;
    private Drawable ga;
    private com.bytedance.adsdk.ugeno.bf k;
    private Shader.TileMode l;
    private Drawable m;
    private float p;
    private int s;
    private int t;
    private final float[] tg;
    private ColorFilter v;
    private ColorStateList vn;
    private ImageView.ScaleType w;
    private boolean wu;
    private boolean xu;
    private boolean zk;
    public static final Shader.TileMode e = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] d = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.component.image.RoundImageView$1, reason: invalid class name */
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
                e[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                e[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                e[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.tg = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.vn = ColorStateList.valueOf(-16777216);
        this.p = 0.0f;
        this.v = null;
        this.zk = false;
        this.wu = false;
        this.xu = false;
        this.bh = false;
        Shader.TileMode tileMode = e;
        this.l = tileMode;
        this.f = tileMode;
    }

    private Drawable bf() {
        Resources resources = getResources();
        Drawable drawable2 = null;
        if (resources == null) {
            return null;
        }
        int i = this.s;
        if (i != 0) {
            try {
                drawable2 = resources.getDrawable(i);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.s, e2);
                this.s = 0;
            }
        }
        return e.e(drawable2);
    }

    private void d() {
        e(this.m, this.w);
    }

    private Drawable e() {
        Resources resources = getResources();
        Drawable drawable2 = null;
        if (resources == null) {
            return null;
        }
        int i = this.t;
        if (i != 0) {
            try {
                drawable2 = resources.getDrawable(i);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.t, e2);
                this.t = 0;
            }
        }
        return e.e(drawable2);
    }

    private void tg() {
        Drawable drawable2 = this.m;
        if (drawable2 == null || !this.zk) {
            return;
        }
        Drawable drawableMutate = drawable2.mutate();
        this.m = drawableMutate;
        if (this.wu) {
            drawableMutate.setColorFilter(this.v);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.vn.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.vn;
    }

    public float getBorderWidth() {
        return this.p;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.tg) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.w;
    }

    public Shader.TileMode getTileModeX() {
        return this.l;
    }

    public Shader.TileMode getTileModeY() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.bf bfVar = this.k;
        if (bfVar != null) {
            bfVar.tg();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.bf bfVar = this.k;
        if (bfVar != null) {
            bfVar.ga();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.bf bfVar = this.k;
        if (bfVar != null) {
            bfVar.e(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.bf bfVar = this.k;
        if (bfVar != null) {
            bfVar.e(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.bf bfVar = this.k;
        if (bfVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrE = bfVar.e(i, i2);
            super.onMeasure(iArrE[0], iArrE[1]);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable2) {
        setBackgroundDrawable(drawable2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.ga = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable2) {
        this.ga = drawable2;
        e(true);
        super.setBackgroundDrawable(this.ga);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.s != i) {
            this.s = i;
            Drawable drawableBf = bf();
            this.ga = drawableBf;
            setBackgroundDrawable(drawableBf);
        }
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.v != colorFilter) {
            this.v = colorFilter;
            this.wu = true;
            this.zk = true;
            tg();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        e(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        e(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.t = 0;
        this.m = e.e(bitmap);
        d();
        super.setImageDrawable(this.m);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable2) {
        this.t = 0;
        this.m = e.e(drawable2);
        d();
        super.setImageDrawable(this.m);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.t != i) {
            this.t = i;
            this.m = e();
            d();
            super.setImageDrawable(this.m);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.xu = z;
        d();
        e(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!bf && scaleType == null) {
            throw new AssertionError();
        }
        if (this.w != scaleType) {
            this.w = scaleType;
            switch (AnonymousClass1.e[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            d();
            e(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.l == tileMode) {
            return;
        }
        this.l = tileMode;
        d();
        e(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f == tileMode) {
            return;
        }
        this.f = tileMode;
        d();
        e(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.vn.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.vn = colorStateList;
        d();
        e(false);
        if (this.p > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.p == f) {
            return;
        }
        this.p = f;
        d();
        e(false);
        invalidate();
    }

    private void e(boolean z) {
        if (this.bh) {
            if (z) {
                this.ga = e.e(this.ga);
            }
            e(this.ga, ImageView.ScaleType.FIT_XY);
        }
    }

    private void e(Drawable drawable2, ImageView.ScaleType scaleType) {
        if (drawable2 == null) {
            return;
        }
        if (drawable2 instanceof e) {
            e eVar = (e) drawable2;
            eVar.e(scaleType).e(this.p).e(this.vn).e(this.xu).e(this.l).bf(this.f);
            float[] fArr = this.tg;
            if (fArr != null) {
                eVar.e(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            tg();
            return;
        }
        if (drawable2 instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable2;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                e(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    public void e(float f, float f2, float f3, float f4) {
        float[] fArr = this.tg;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        d();
        e(false);
        invalidate();
    }

    public void e(com.bytedance.adsdk.ugeno.bf bfVar) {
        this.k = bfVar;
    }
}
