package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes10.dex */
public class TTRatingBar2 extends FrameLayout {
    LinearLayout bf;
    private int d;
    LinearLayout e;
    private double ga;
    private Drawable m;
    private int p;
    private int tg;
    private int v;
    private int vn;
    private Drawable wu;
    private int zk;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new LinearLayout(getContext());
        this.bf = new LinearLayout(getContext());
        this.e.setOrientation(0);
        this.e.setGravity(GravityCompat.START);
        this.bf.setOrientation(0);
        this.bf.setGravity(GravityCompat.START);
        this.m = dt.d(context, "tt_ratingbar_empty_star2");
        this.wu = dt.d(context, "tt_ratingbar_full_star2");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d, this.tg);
        layoutParams.leftMargin = this.vn;
        layoutParams.topMargin = this.p;
        layoutParams.rightMargin = this.v;
        layoutParams.bottomMargin = this.zk;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void e(int i, int i2) {
        this.d = i2;
        this.tg = i;
    }

    public Drawable getEmptyStarDrawable() {
        return this.m;
    }

    public Drawable getFillStarDrawable() {
        return this.wu;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.e.measure(i, i2);
        double dFloor = Math.floor(this.ga);
        int i3 = this.vn;
        int i4 = this.v + i3;
        int i5 = this.d;
        this.bf.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.ga - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.e.getMeasuredHeight(), 1073741824));
    }

    public void setRating(double d) {
        this.ga = d;
    }

    public void e() {
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.bf.addView(starImageView);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.e.addView(starImageView2);
        }
        addView(this.e);
        addView(this.bf);
        requestLayout();
    }

    public void e(int i, int i2, int i3, int i4) {
        this.vn = i;
        this.p = i2;
        this.v = i3;
        this.zk = i4;
    }
}
