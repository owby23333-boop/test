package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private View dl;
    private ImageView g;
    private View z;

    public View getProgressBar() {
        return this.z;
    }

    public ImageView getProgressIcon() {
        return this.g;
    }

    public void setProgress(int i) {
        if (this.g.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.g.getLayoutParams()).leftMargin = z(this.z.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.z.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dl.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.dl.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
