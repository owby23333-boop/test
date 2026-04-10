package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes10.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private ImageView bf;
    private View d;
    private View e;

    public TTLoadingProgressBar(Context context) {
        super(context);
        e(context);
    }

    private void e(Context context) {
        LayoutInflater.from(context).inflate(dt.vn(context, "tt_progress_bar_layout"), (ViewGroup) this, true);
        this.e = findViewById(dt.ga(context, "tt_progress_bar"));
        this.bf = (ImageView) findViewById(dt.ga(context, "tt_progress_icon"));
        this.d = findViewById(dt.ga(context, "tt_progress_empty"));
    }

    public View getProgressBar() {
        return this.e;
    }

    public ImageView getProgressIcon() {
        return this.bf;
    }

    public void setProgress(int i) {
        if (this.bf.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.bf.getLayoutParams()).leftMargin = e(this.e.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.e.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.d.setLayoutParams(layoutParams2);
        requestLayout();
    }

    public TTLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public TTLoadingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
    }

    private int e(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
