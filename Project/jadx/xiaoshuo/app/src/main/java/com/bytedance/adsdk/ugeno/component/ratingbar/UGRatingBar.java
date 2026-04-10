package com.bytedance.adsdk.ugeno.component.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.bf;
import com.bytedance.adsdk.ugeno.tg.d;
import com.bytedance.adsdk.ugeno.tg.p;

/* JADX INFO: loaded from: classes.dex */
public class UGRatingBar extends FrameLayout {
    private float bf;
    private Drawable d;
    private float e;
    private double ga;
    private bf m;
    private LinearLayout p;
    private Drawable tg;
    private LinearLayout v;
    private float vn;
    private Context zk;

    public UGRatingBar(Context context) {
        super(context);
        this.zk = context;
        this.p = new LinearLayout(context);
        this.v = new LinearLayout(context);
        this.p.setOrientation(0);
        this.p.setGravity(GravityCompat.START);
        this.v.setOrientation(0);
        this.v.setGravity(GravityCompat.START);
        this.d = d.e(context, "tt_star_thick");
        this.tg = d.e(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.e, (int) this.bf);
        layoutParams.leftMargin = 1;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = 1;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void e(double d, int i, int i2, int i3) {
        removeAllViews();
        this.p.removeAllViews();
        this.v.removeAllViews();
        float f = i2;
        this.e = (int) p.e(this.zk, f);
        this.bf = (int) p.e(this.zk, f);
        this.ga = d;
        this.vn = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.v.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.p.addView(starImageView2);
        }
        addView(this.p);
        addView(this.v);
        requestLayout();
    }

    public Drawable getStarEmptyDrawable() {
        return this.d;
    }

    public Drawable getStarFillDrawable() {
        return this.tg;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bf bfVar = this.m;
        if (bfVar != null) {
            bfVar.tg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bf bfVar = this.m;
        if (bfVar != null) {
            bfVar.ga();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        bf bfVar = this.m;
        if (bfVar != null) {
            bfVar.e(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bf bfVar = this.m;
        if (bfVar != null) {
            bfVar.e(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        bf bfVar = this.m;
        if (bfVar != null) {
            bfVar.e(i, i2);
        }
        super.onMeasure(i, i2);
        this.p.measure(i, i2);
        double dFloor = Math.floor(this.ga);
        float f = this.e;
        this.v.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (2.0f + f)) * dFloor) + 1.0d + ((this.ga - dFloor) * ((double) f))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.p.getMeasuredHeight(), 1073741824));
    }

    public void e(bf bfVar) {
        this.m = bfVar;
    }
}
