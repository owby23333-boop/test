package com.bytedance.adsdk.ugeno.widget.image;

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
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.adsdk.ugeno.dl.gc;
import com.bytedance.adsdk.ugeno.z.e;
import com.bytedance.adsdk.ugeno.z.gz;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class RoundImageView extends ImageView implements gc, e {
    static final /* synthetic */ boolean g = true;
    private float dl;
    private ColorStateList e;
    private ColorFilter fo;
    private Shader.TileMode fv;
    private final float[] gc;
    private float gz;
    private boolean i;
    private Shader.TileMode js;
    private Drawable kb;
    private int ls;
    private Drawable m;
    private ImageView.ScaleType p;
    private int pf;
    private gz q;
    private dl tb;
    private boolean uy;
    private boolean v;
    private boolean wp;
    public static final Shader.TileMode z = Shader.TileMode.CLAMP;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImageView.ScaleType[] f253a = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public RoundImageView(Context context) {
        super(context);
        this.gc = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.e = ColorStateList.valueOf(-16777216);
        this.gz = 0.0f;
        this.fo = null;
        this.uy = false;
        this.wp = false;
        this.i = false;
        this.v = false;
        Shader.TileMode tileMode = z;
        this.fv = tileMode;
        this.js = tileMode;
        this.q = new gz(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.p;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!g && scaleType == null) {
            throw new AssertionError();
        }
        if (this.p != scaleType) {
            this.p = scaleType;
            int i = AnonymousClass1.z[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            dl();
            z(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            z = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                z[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.pf = 0;
        this.kb = z.z(drawable);
        dl();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.pf = 0;
        this.kb = z.z(bitmap);
        dl();
        super.setImageDrawable(this.kb);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.pf != i) {
            this.pf = i;
            this.kb = z();
            dl();
            super.setImageDrawable(this.kb);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable z() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.pf;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                wp.g("RoundedImageView", "Unable to find resource: " + this.pf, e);
                this.pf = 0;
            }
        }
        return z.z(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.ls != i) {
            this.ls = i;
            Drawable drawableG = g();
            this.m = drawableG;
            setBackgroundDrawable(drawableG);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.m = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable g() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.ls;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                wp.g("RoundedImageView", "Unable to find resource: " + this.ls, e);
                this.ls = 0;
            }
        }
        return z.z(drawable);
    }

    private void dl() {
        z(this.kb, this.p);
    }

    private void z(boolean z2) {
        if (this.v) {
            if (z2) {
                this.m = z.z(this.m);
            }
            z(this.m, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.fo != colorFilter) {
            this.fo = colorFilter;
            this.wp = true;
            this.uy = true;
            a();
            invalidate();
        }
    }

    private void a() {
        Drawable drawable = this.kb;
        if (drawable == null || !this.uy) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.kb = drawableMutate;
        if (this.wp) {
            drawableMutate.setColorFilter(this.fo);
        }
    }

    private void z(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof z) {
            z zVar = (z) drawable;
            zVar.z(scaleType).z(this.gz).z(this.e).z(this.i).z(this.fv).g(this.js);
            float[] fArr = this.gc;
            if (fArr != null) {
                zVar.z(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                z(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.m = drawable;
        z(true);
        super.setBackgroundDrawable(this.m);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.gc) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        z(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        z(f, f, f, f);
    }

    public void z(float f, float f2, float f3, float f4) {
        float[] fArr = this.gc;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        dl();
        z(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.gz;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.gz == f) {
            return;
        }
        this.gz = f;
        dl();
        z(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.e.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.e;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.e = colorStateList;
        dl();
        z(false);
        if (this.gz > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z2) {
        this.i = z2;
        dl();
        z(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.fv;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.fv == tileMode) {
            return;
        }
        this.fv = tileMode;
        dl();
        z(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.js;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.js == tileMode) {
            return;
        }
        this.js = tileMode;
        dl();
        z(false);
        invalidate();
    }

    public void z(dl dlVar) {
        this.tb = dlVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.tb;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z2, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.z(canvas, this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.gc, com.bytedance.adsdk.ugeno.z.e
    public float getRipple() {
        return this.dl;
    }

    public void setShine(float f) {
        gz gzVar = this.q;
        if (gzVar != null) {
            gzVar.dl(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getShine() {
        return this.q.getShine();
    }

    public void setStretch(float f) {
        gz gzVar = this.q;
        if (gzVar != null) {
            gzVar.a(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getStretch() {
        return this.q.getStretch();
    }

    public void setRubIn(float f) {
        gz gzVar = this.q;
        if (gzVar != null) {
            gzVar.gc(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRubIn() {
        return this.q.getRubIn();
    }

    public void setRipple(float f) {
        this.dl = f;
        gz gzVar = this.q;
        if (gzVar != null) {
            gzVar.g(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.z(z2);
        }
    }

    public void setBorderRadius(float f) {
        gz gzVar = this.q;
        if (gzVar != null) {
            gzVar.z(f);
        }
    }

    public float getBorderRadius() {
        return this.q.z();
    }
}
