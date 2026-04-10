package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1492a;
    private int dl;
    private Drawable e;
    private Drawable fo;
    private int g;
    private float gc;
    private Drawable gz;
    private float m;
    private int z;

    public TTRatingBar(Context context) {
        super(context);
        this.z = 5;
        this.g = 0;
        this.dl = 0;
        z(context);
    }

    private void z(Context context) {
        setOrientation(0);
        this.e = tb.dl(context, "tt_star_empty_bg");
        this.gz = tb.dl(context, "tt_star_full_bg");
        this.fo = tb.dl(context, "tt_star_empty_bg");
        this.f1492a = z(context, 15.0f);
        this.gc = z(context, 15.0f);
        this.m = z(context, 5.0f);
    }

    private int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStarFillNum() {
        return this.z;
    }

    public void setStarFillNum(int i) {
        this.z = i;
    }

    public int getStarHalfNum() {
        return this.g;
    }

    public void setStarHalfNum(int i) {
        this.g = i;
    }

    public int getStarEmptyNum() {
        return this.dl;
    }

    public void setStarEmptyNum(int i) {
        this.dl = i;
    }

    public float getStarImageWidth() {
        return this.f1492a;
    }

    public void setStarImageWidth(float f) {
        this.f1492a = f;
    }

    public float getStarImageHeight() {
        return this.gc;
    }

    public void setStarImageHeight(float f) {
        this.gc = f;
    }

    public float getStarImagePadding() {
        return this.m;
    }

    public void setStarImagePadding(float f) {
        this.m = f;
    }

    public Drawable getStarEmptyDrawable() {
        return this.e;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.e = drawable;
    }

    public Drawable getStarFillDrawable() {
        return this.gz;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.gz = drawable;
    }

    public Drawable getStarHalfDrawable() {
        return this.fo;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.fo = drawable;
    }

    public void z() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f1492a), Math.round(this.gc)));
        imageView.setPadding(0, 0, Math.round(this.m), 0);
        return imageView;
    }
}
