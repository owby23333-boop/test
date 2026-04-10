package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dangdang.zframework.R;
import com.dangdang.zframework.utils.UiUtil;

/* JADX INFO: loaded from: classes10.dex */
public class ProgressLoadingLayout extends LoadingLayout {
    private RotateAnimation animation;
    private ProgressBar mBar;
    private ImageView mImage;
    private RotateAnimation reAnimation;

    public ProgressLoadingLayout(Context context, int i, String str, String str2, String str3) {
        super(context, i, str, str2, str3);
    }

    private RotateAnimation getResetAnimation() {
        if (this.reAnimation == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.reAnimation = rotateAnimation;
            rotateAnimation.setDuration(500L);
            this.reAnimation.setFillAfter(false);
        }
        return this.reAnimation;
    }

    private RotateAnimation getRotateAnimation() {
        if (this.animation == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.animation = rotateAnimation;
            rotateAnimation.setDuration(500L);
            this.animation.setFillAfter(true);
        }
        return this.animation;
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void init(Context context, int i, String str, String str2, String str3) {
        this.mLoadingView = new RelativeLayout(context);
        TextView textView = new TextView(context);
        this.mPromptView = textView;
        textView.setTextColor(-6908266);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        int iDip2px = UiUtil.dip2px(context, 10.0f);
        layoutParams.setMargins(iDip2px, 0, iDip2px, 0);
        this.mPromptView.setId(R.id.textview);
        ((ViewGroup) this.mLoadingView).addView(this.mPromptView, layoutParams);
        ImageView imageView = new ImageView(context);
        this.mImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iDip2px2 = UiUtil.dip2px(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDip2px2, iDip2px2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.textview);
        ((ViewGroup) this.mLoadingView).addView(this.mImage, layoutParams2);
        this.mImage.setImageBitmap(i == 2 ? BitmapFactory.decodeResource(context.getResources(), R.drawable.pulltorefresh_up_arrow) : BitmapFactory.decodeResource(context.getResources(), R.drawable.pulltorefresh_down_arrow));
        this.mBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iDip2px2, iDip2px2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, R.id.textview);
        ((ViewGroup) this.mLoadingView).addView(this.mBar, layoutParams3);
        this.mRefreshingLabel = str3;
        this.mReleaseLabel = str;
        this.mPullLabel = str2;
        this.mBar.setVisibility(8);
        addView(this.mLoadingView, new ViewGroup.LayoutParams(-1, UiUtil.dip2px(context, 60.0f)));
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void pullToRefresh() {
        super.pullToRefresh();
        this.mImage.startAnimation(getResetAnimation());
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void refreshing() {
        super.refreshing();
        this.mImage.setVisibility(8);
        this.mImage.clearAnimation();
        this.mBar.setVisibility(0);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void releaseToRefresh() {
        super.releaseToRefresh();
        this.mImage.startAnimation(getRotateAnimation());
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void reset() {
        super.reset();
        this.mImage.setVisibility(0);
        this.mImage.clearAnimation();
        this.mBar.setVisibility(8);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.LoadingLayout
    public void setRefreshValid(int i) {
    }
}
