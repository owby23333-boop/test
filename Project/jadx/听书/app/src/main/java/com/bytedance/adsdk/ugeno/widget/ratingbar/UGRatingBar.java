package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.adsdk.ugeno.m.a;
import com.bytedance.adsdk.ugeno.m.gz;

/* JADX INFO: loaded from: classes2.dex */
public class UGRatingBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f256a;
    private double dl;
    private Context e;
    private float g;
    private LinearLayout gc;
    private dl gz;
    private LinearLayout m;
    private float z;

    public UGRatingBar(Context context) {
        super(context);
        this.e = context;
        this.gc = new LinearLayout(context);
        this.m = new LinearLayout(context);
        this.gc.setOrientation(0);
        this.gc.setGravity(GravityCompat.START);
        this.m.setOrientation(0);
        this.m.setGravity(GravityCompat.START);
    }

    public void z(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.gc.removeAllViews();
        this.m.removeAllViews();
        this.z = (int) gz.z(this.e, f);
        this.g = (int) gz.z(this.e, f);
        this.dl = d;
        this.f256a = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(a.g(this.e, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.m.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(a.g(this.e, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.gc.addView(starImageView2);
        }
        addView(this.gc);
        addView(this.m);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.z, (int) this.g);
        layoutParams.leftMargin = (int) this.f256a;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.f256a;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.z(i, i2);
        }
        super.onMeasure(i, i2);
        this.gc.measure(i, i2);
        double dFloor = Math.floor(this.dl);
        float f = this.f256a;
        float f2 = this.z;
        this.m.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.dl - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.gc.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }

    public void z(dl dlVar) {
        this.gz = dlVar;
    }
}
