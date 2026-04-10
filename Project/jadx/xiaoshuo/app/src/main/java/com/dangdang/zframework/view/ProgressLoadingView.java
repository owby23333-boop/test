package com.dangdang.zframework.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public class ProgressLoadingView extends LoadingView {
    public ProgressLoadingView(Context context) {
        super(context);
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void init(Context context) {
        this.mLoadingView = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(context));
        TextView textView = new TextView(context);
        this.mMessageTV = textView;
        textView.setVisibility(8);
        linearLayout.addView(this.mMessageTV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ((ViewGroup) this.mLoadingView).addView(linearLayout, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.mLoadingView.getLayoutParams();
        if (layoutParams2 != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            layoutParams2.width = displayMetrics.widthPixels;
            layoutParams2.height = displayMetrics.heightPixels;
            this.mLoadingView.setLayoutParams(layoutParams2);
        }
        this.mLoadingView.setBackgroundColor(-1442840576);
        this.mLoadingView.setClickable(true);
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void reset() {
    }
}
