package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends FrameLayout {
    private static final int fo = (kb.g("", 0.0f, true)[1] / 2) + 1;
    private static final int uy = (kb.g("", 0.0f, true)[1] / 2) + 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f610a;
    private float dl;
    private double e;
    LinearLayout g;
    private Drawable gc;
    private float gz;
    private Drawable m;
    LinearLayout z;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = new LinearLayout(getContext());
        this.g = new LinearLayout(getContext());
        this.z.setOrientation(0);
        this.z.setGravity(GravityCompat.START);
        this.g.setOrientation(0);
        this.g.setGravity(GravityCompat.START);
        this.gc = tb.dl(context, "tt_star_thick");
        this.m = tb.dl(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.gc;
    }

    public Drawable getStarFillDrawable() {
        return this.m;
    }

    public void z(double d, int i, int i2, int i3) {
        float f = i2;
        this.dl = (int) gz.dl(getContext(), f);
        this.f610a = (int) gz.dl(getContext(), f);
        this.e = d;
        this.gz = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.g.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.z.addView(starImageView2);
        }
        addView(this.z);
        addView(this.g);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.dl, (int) this.f610a));
        imageView.setPadding(1, fo, 1, uy);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.z.measure(i, i2);
        double d = this.e;
        float f = this.dl;
        this.g.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.z.getMeasuredHeight(), 1073741824));
        if (this.gz > 0.0f) {
            this.z.setPadding(0, ((int) (r7.getMeasuredHeight() - this.gz)) / 2, 0, 0);
            this.g.setPadding(0, ((int) (this.z.getMeasuredHeight() - this.gz)) / 2, 0, 0);
        }
    }
}
