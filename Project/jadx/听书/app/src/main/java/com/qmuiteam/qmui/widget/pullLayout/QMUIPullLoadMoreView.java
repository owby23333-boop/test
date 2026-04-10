package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPullLoadMoreView extends ConstraintLayout implements QMUIPullLayout.ActionPullWatcherView {
    private AppCompatImageView mArrowView;
    private int mHeight;
    private boolean mIsInReleaseState;
    private boolean mIsLoading;
    private QMUILoadingView mLoadingView;
    private String mPullText;
    private String mReleaseText;
    private AppCompatTextView mTextView;

    public QMUIPullLoadMoreView(Context context) {
        this(context, null);
    }

    public QMUIPullLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullLoadMoreStyle);
    }

    public QMUIPullLoadMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsLoading = false;
        this.mIsInReleaseState = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLoadMoreView, i, 0);
        this.mPullText = typedArrayObtainStyledAttributes.getString(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_pull_text);
        this.mReleaseText = typedArrayObtainStyledAttributes.getString(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_release_text);
        this.mHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_height, QMUIDisplayHelper.dp2px(context, 56));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_loading_size, QMUIDisplayHelper.dp2px(context, 20));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_text_size, QMUIDisplayHelper.sp2px(context, 14));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow_text_gap, QMUIDisplayHelper.dp2px(context, 10));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_bg_color, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_loading_tint_color, -16777216);
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_arrow_tint_color, -16777216);
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_text_color, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        QMUILoadingView qMUILoadingView = new QMUILoadingView(context);
        this.mLoadingView = qMUILoadingView;
        qMUILoadingView.setSize(dimensionPixelSize);
        this.mLoadingView.setColor(color2);
        this.mLoadingView.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        addView(this.mLoadingView, layoutParams);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.mArrowView = appCompatImageView;
        appCompatImageView.setId(View.generateViewId());
        this.mArrowView.setImageDrawable(drawable);
        this.mArrowView.setRotation(180.0f);
        ImageViewCompat.setImageTintList(this.mArrowView, ColorStateList.valueOf(color3));
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.mTextView = appCompatTextView;
        appCompatTextView.setId(View.generateViewId());
        this.mTextView.setTextSize(0, dimensionPixelSize2);
        this.mTextView.setTextColor(color4);
        this.mTextView.setText(this.mPullText);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToLeft = this.mTextView.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = 2;
        addView(this.mArrowView, layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.leftToRight = this.mArrowView.getId();
        layoutParams3.rightToRight = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.leftMargin = dimensionPixelSize3;
        addView(this.mTextView, layoutParams3);
        setBackgroundColor(color);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_pull_load_more_bg_color);
        QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.tintColor(R.attr.qmui_skin_support_pull_load_more_loading_tint_color);
        QMUISkinHelper.setSkinValue(this.mLoadingView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.tintColor(R.attr.qmui_skin_support_pull_load_more_arrow_tint_color);
        QMUISkinHelper.setSkinValue(this.mArrowView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_pull_load_more_text_color);
        QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onPull(QMUIPullLayout.PullAction pullAction, int i) {
        if (this.mIsLoading) {
            return;
        }
        if (this.mIsInReleaseState) {
            if (pullAction.getTargetTriggerOffset() > i) {
                this.mIsInReleaseState = false;
                this.mTextView.setText(this.mPullText);
                this.mArrowView.animate().rotation(180.0f).start();
                return;
            }
            return;
        }
        if (pullAction.getTargetTriggerOffset() <= i) {
            this.mIsInReleaseState = true;
            this.mTextView.setText(this.mReleaseText);
            this.mArrowView.animate().rotation(0.0f).start();
        }
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionTriggered() {
        this.mIsLoading = true;
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.start();
        this.mArrowView.setVisibility(8);
        this.mTextView.setVisibility(8);
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionFinished() {
        this.mIsLoading = false;
        this.mLoadingView.stop();
        this.mLoadingView.setVisibility(8);
        this.mArrowView.setVisibility(0);
        this.mTextView.setVisibility(0);
    }
}
