package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SelfAdLogoFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f5069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f5070t;

    public SelfAdLogoFrameLayout(Context context) {
        this(context, null);
    }

    public void a() {
        ImageView imageView = this.f5070t;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public ImageView getIv_native_image() {
        return this.f5069s;
    }

    public void setLogoImgeViewMargin(int i2) {
        ImageView imageView = this.f5070t;
        if (imageView != null) {
            com.amgcyo.cuttadon.f.o.a(imageView, i2, 0, i2, 0);
        }
    }

    public SelfAdLogoFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.selfadlogo_layout, this);
        this.f5069s = (ImageView) findViewById(R.id.imageview);
        this.f5070t = (ImageView) findViewById(R.id.logoImgeview);
    }
}
