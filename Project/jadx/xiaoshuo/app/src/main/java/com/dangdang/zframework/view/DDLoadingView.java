package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public class DDLoadingView extends LoadingView {
    private AnimationDrawable animationDrawable;
    private ImageView mImage;

    public DDLoadingView(Context context) {
        super(context);
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void init(Context context) {
        this.mLoadingView = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        this.mImage = imageView;
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        this.mMessageTV = textView;
        linearLayout.addView(textView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ((ViewGroup) this.mLoadingView).addView(linearLayout, layoutParams);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mImage.getBackground();
        this.animationDrawable = animationDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        ViewGroup.LayoutParams layoutParams2 = this.mLoadingView.getLayoutParams();
        if (layoutParams2 != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            layoutParams2.width = displayMetrics.widthPixels;
            layoutParams2.height = displayMetrics.heightPixels;
            this.mLoadingView.setLayoutParams(layoutParams2);
        }
        this.mLoadingView.setClickable(true);
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void reset() {
        AnimationDrawable animationDrawable = this.animationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        this.animationDrawable = null;
    }
}
