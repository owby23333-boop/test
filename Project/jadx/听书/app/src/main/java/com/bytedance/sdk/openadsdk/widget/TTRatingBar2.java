package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1493a;
    private int dl;
    private int e;
    private int fo;
    LinearLayout g;
    private double gc;
    private int gz;
    private Drawable kb;
    private int m;
    private Drawable uy;
    LinearLayout z;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = new LinearLayout(getContext());
        this.g = new LinearLayout(getContext());
        this.z.setOrientation(0);
        this.z.setGravity(GravityCompat.START);
        this.g.setOrientation(0);
        this.g.setGravity(GravityCompat.START);
        this.uy = tb.dl(context, "tt_ratingbar_empty_star2");
        this.kb = tb.dl(context, "tt_ratingbar_full_star2");
    }

    public Drawable getEmptyStarDrawable() {
        return this.uy;
    }

    public Drawable getFillStarDrawable() {
        return this.kb;
    }

    public void setRating(double d) {
        this.gc = d;
    }

    public void z(int i, int i2) {
        this.dl = i2;
        this.f1493a = i;
    }

    public void z() {
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.g.addView(starImageView);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.z.addView(starImageView2);
        }
        addView(this.z);
        addView(this.g);
        requestLayout();
    }

    public void z(int i, int i2, int i3, int i4) {
        this.m = i;
        this.e = i2;
        this.gz = i3;
        this.fo = i4;
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dl, this.f1493a);
        layoutParams.leftMargin = this.m;
        layoutParams.topMargin = this.e;
        layoutParams.rightMargin = this.gz;
        layoutParams.bottomMargin = this.fo;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.z.measure(i, i2);
        double dFloor = Math.floor(this.gc);
        int i3 = this.m;
        int i4 = this.gz + i3;
        int i5 = this.dl;
        this.g.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.gc - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.z.getMeasuredHeight(), 1073741824));
    }
}
