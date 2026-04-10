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
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.adexpress.dynamic.tg.wu;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class TTRatingBar2 extends FrameLayout {
    LinearLayout bf;
    private float d;
    LinearLayout e;
    private Drawable ga;
    private double p;
    private float tg;
    private float v;
    private Drawable vn;
    private static final int zk = (wu.bf("", 0.0f, true)[1] / 2) + 1;
    private static final int m = (wu.bf("", 0.0f, true)[1] / 2) + 3;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new LinearLayout(getContext());
        this.bf = new LinearLayout(getContext());
        this.e.setOrientation(0);
        this.e.setGravity(GravityCompat.START);
        this.bf.setOrientation(0);
        this.bf.setGravity(GravityCompat.START);
        this.ga = dt.d(context, "tt_star_thick");
        this.vn = dt.d(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.d, (int) this.tg));
        imageView.setPadding(1, zk, 1, m);
        return imageView;
    }

    public void e(double d, int i, int i2, int i3) {
        float f = i2;
        this.d = (int) bf.d(getContext(), f);
        this.tg = (int) bf.d(getContext(), f);
        this.p = d;
        this.v = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.bf.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.e.addView(starImageView2);
        }
        addView(this.e);
        addView(this.bf);
        requestLayout();
    }

    public Drawable getStarEmptyDrawable() {
        return this.ga;
    }

    public Drawable getStarFillDrawable() {
        return this.vn;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.e.measure(i, i2);
        double d = this.p;
        float f = this.d;
        this.bf.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.e.getMeasuredHeight(), 1073741824));
        if (this.v > 0.0f) {
            this.e.setPadding(0, ((int) (r7.getMeasuredHeight() - this.v)) / 2, 0, 0);
            this.bf.setPadding(0, ((int) (this.e.getMeasuredHeight() - this.v)) / 2, 0, 0);
        }
    }
}
