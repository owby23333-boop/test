package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes10.dex */
public class TTRatingBar extends LinearLayout {
    private int bf;
    private int d;
    private int e;
    private float ga;
    private Drawable p;
    private float tg;
    private Drawable v;
    private float vn;
    private Drawable zk;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 5;
        this.bf = 0;
        this.d = 0;
        setOrientation(0);
        this.p = dt.d(context, "tt_star_empty_bg");
        this.v = dt.d(context, "tt_star_full_bg");
        this.zk = dt.d(context, "tt_star_empty_bg");
        this.tg = e(context, 15.0f);
        this.ga = e(context, 15.0f);
        this.vn = e(context, 5.0f);
    }

    private int e(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.tg), Math.round(this.ga)));
        imageView.setPadding(0, 0, Math.round(this.vn), 0);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.p;
    }

    public int getStarEmptyNum() {
        return this.d;
    }

    public Drawable getStarFillDrawable() {
        return this.v;
    }

    public int getStarFillNum() {
        return this.e;
    }

    public Drawable getStarHalfDrawable() {
        return this.zk;
    }

    public int getStarHalfNum() {
        return this.bf;
    }

    public float getStarImageHeight() {
        return this.ga;
    }

    public float getStarImagePadding() {
        return this.vn;
    }

    public float getStarImageWidth() {
        return this.tg;
    }

    public void setStarEmptyDrawable(Drawable drawable2) {
        this.p = drawable2;
    }

    public void setStarEmptyNum(int i) {
        this.d = i;
    }

    public void setStarFillDrawable(Drawable drawable2) {
        this.v = drawable2;
    }

    public void setStarFillNum(int i) {
        this.e = i;
    }

    public void setStarHalfDrawable(Drawable drawable2) {
        this.zk = drawable2;
    }

    public void setStarHalfNum(int i) {
        this.bf = i;
    }

    public void setStarImageHeight(float f) {
        this.ga = f;
    }

    public void setStarImagePadding(float f) {
        this.vn = f;
    }

    public void setStarImageWidth(float f) {
        this.tg = f;
    }

    public void e() {
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
}
