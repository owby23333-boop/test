package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MoreTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5683s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5684t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5685u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Bitmap f5686v;

    public MoreTextView(Context context) {
        this(context, null);
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(this.f5684t / width, this.f5683s / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void b() {
        BitmapDrawable bitmapDrawable;
        if (this.f5686v != null) {
            if (this.f5683s == 0 || this.f5684t == 0) {
                Resources resources = getResources();
                Bitmap bitmap = this.f5686v;
                bitmapDrawable = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), this.f5686v.getHeight(), true));
            } else {
                bitmapDrawable = new BitmapDrawable(getResources(), a(this.f5686v));
            }
            int i2 = this.f5685u;
            if (i2 == 0) {
                setCompoundDrawablesWithIntrinsicBounds(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (i2 == 1) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
            } else if (i2 == 2) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bitmapDrawable, (Drawable) null);
            } else {
                if (i2 != 3) {
                    return;
                }
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, bitmapDrawable);
            }
        }
    }

    public MoreTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.MoreTextView, i2, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == 0) {
                this.f5686v = BitmapFactory.decodeResource(getResources(), typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == 1) {
                this.f5683s = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(2, 0.0f, getResources().getDisplayMetrics()));
            } else if (index == 2) {
                this.f5685u = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == 3) {
                this.f5684t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(2, 0.0f, getResources().getDisplayMetrics()));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        b();
    }

    public void a() {
        this.f5685u = 1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen20dp);
        this.f5684t = dimensionPixelSize;
        this.f5683s = dimensionPixelSize;
        this.f5686v = BitmapFactory.decodeResource(getResources(), R.drawable.kf_png);
        setTextSize(2, 10.0f);
        setText("在线客服");
        o.a(this, 0, getResources().getDimensionPixelSize(R.dimen.dimen5dp), getResources().getDimensionPixelSize(R.dimen.dimen10dp), 0);
        setPadding(0, 0, 0, 0);
        setVisibility(0);
        b();
        postInvalidate();
    }
}
