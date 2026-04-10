package com.amgcyo.cuttadon.view.lightview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends AppCompatImageView {
    private static final ImageView.ScaleType[] B = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4853s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4854t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorStateList f4855u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4856v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f4857w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4858x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f4859y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f4860z;

    static /* synthetic */ class a {
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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f4853s = 0;
        this.f4854t = 0;
        this.f4855u = ColorStateList.valueOf(-16777216);
        this.f4856v = false;
        this.f4857w = false;
    }

    private Drawable a() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.f4858x;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f4858x = 0;
            }
        }
        return com.amgcyo.cuttadon.view.lightview.a.b(drawable);
    }

    private void b() {
        a(this.f4859y);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f4855u.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f4855u;
    }

    public int getBorderWidth() {
        return this.f4854t;
    }

    public int getCornerRadius() {
        return this.f4853s;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.A;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f4860z = drawable;
        a(true);
        super.setBackgroundDrawable(this.f4860z);
    }

    public void setBorderColor(int i2) {
        setBorderColors(ColorStateList.valueOf(i2));
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (this.f4855u.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f4855u = colorStateList;
        b();
        a(false);
        if (this.f4854t > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (this.f4854t == i2) {
            return;
        }
        this.f4854t = i2;
        b();
        a(false);
        invalidate();
    }

    public void setCornerRadius(int i2) {
        if (this.f4853s == i2) {
            return;
        }
        this.f4853s = i2;
        b();
        a(false);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f4858x = 0;
        this.f4859y = com.amgcyo.cuttadon.view.lightview.a.a(bitmap);
        b();
        super.setImageDrawable(this.f4859y);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f4858x = 0;
        this.f4859y = com.amgcyo.cuttadon.view.lightview.a.b(drawable);
        b();
        super.setImageDrawable(this.f4859y);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.f4858x != i2) {
            this.f4858x = i2;
            this.f4859y = a();
            b();
            super.setImageDrawable(this.f4859y);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setMutateBackground(boolean z2) {
        if (this.f4857w == z2) {
            return;
        }
        this.f4857w = z2;
        a(true);
        invalidate();
    }

    public void setOval(boolean z2) {
        this.f4856v = z2;
        b();
        a(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.A != scaleType) {
            this.A = scaleType;
            switch (a.a[scaleType.ordinal()]) {
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
            b();
            a(false);
            invalidate();
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(boolean z2) {
        if (this.f4857w) {
            if (z2) {
                this.f4860z = com.amgcyo.cuttadon.view.lightview.a.b(this.f4860z);
            }
            a(this.f4860z);
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4853s = 0;
        this.f4854t = 0;
        this.f4855u = ColorStateList.valueOf(-16777216);
        this.f4856v = false;
        this.f4857w = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundedImageView, i2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setScaleType(B[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.f4853s = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.f4854t = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1);
        if (this.f4853s < 0) {
            this.f4853s = 0;
        }
        if (this.f4854t < 0) {
            this.f4854t = 0;
        }
        this.f4855u = typedArrayObtainStyledAttributes.getColorStateList(2);
        if (this.f4855u == null) {
            this.f4855u = ColorStateList.valueOf(-16777216);
        }
        this.f4857w = typedArrayObtainStyledAttributes.getBoolean(4, false);
        this.f4856v = typedArrayObtainStyledAttributes.getBoolean(5, false);
        b();
        a(true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof com.amgcyo.cuttadon.view.lightview.a) {
            com.amgcyo.cuttadon.view.lightview.a aVar = (com.amgcyo.cuttadon.view.lightview.a) drawable;
            aVar.a(this.A);
            aVar.a(this.f4853s);
            aVar.a(this.f4854t);
            aVar.a(this.f4855u);
            aVar.a(this.f4856v);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                a(layerDrawable.getDrawable(i2));
            }
        }
    }
}
