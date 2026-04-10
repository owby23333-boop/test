package com.yuewen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import com.duokan.reader.ui.general.MaskView;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes5.dex */
public class jz3 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f13302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f13303b;

    public jz3(Context context, int i) {
        this(context, new ColorDrawable(i), -34816);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f13302a.setVisibility(z ? 0 : 4);
        this.f13303b.setVisibility(z ? 4 : 0);
    }

    public void setSelectedBorderColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(getResources().getDimensionPixelSize(rt2.g.Fs), i);
        gradientDrawable.setShape(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(rt2.g.Xt);
        gradientDrawable.setSize(dimensionPixelSize, dimensionPixelSize);
        this.f13302a.setForeground(gradientDrawable);
        invalidate();
    }

    public jz3(Context context, int i, int i2) {
        this(context, new ColorDrawable(i), i2);
    }

    public jz3(Context context, Drawable drawable2) {
        this(context, drawable2, -34816);
    }

    public jz3(Context context, Drawable drawable2, int i) {
        super(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f13302a = frameLayout;
        MaskView maskView = new MaskView(getContext());
        maskView.setBackgroundDrawable(drawable2);
        Resources resources = getResources();
        int i2 = rt2.h.kk;
        maskView.setForeground(resources.getDrawable(i2));
        Resources resources2 = getResources();
        int i3 = rt2.g.Xt;
        int dimensionPixelSize = resources2.getDimensionPixelSize(i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(getResources().getDimensionPixelSize(rt2.g.Fs), i);
        gradientDrawable.setShape(1);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i3);
        gradientDrawable.setSize(dimensionPixelSize2, dimensionPixelSize2);
        frameLayout.addView(maskView, new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17));
        frameLayout.setForeground(gradientDrawable);
        frameLayout.setForegroundGravity(17);
        addView(frameLayout);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f13303b = frameLayout2;
        MaskView maskView2 = new MaskView(getContext());
        maskView2.setBackgroundDrawable(drawable2);
        maskView2.setForeground(getResources().getDrawable(i2));
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i3);
        frameLayout2.addView(maskView2, new FrameLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3, 17));
        addView(frameLayout2);
    }
}
