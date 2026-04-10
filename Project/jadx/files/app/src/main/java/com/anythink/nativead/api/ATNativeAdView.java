package com.anythink.nativead.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.nativead.api.NativeAd;

/* JADX INFO: loaded from: classes2.dex */
public class ATNativeAdView extends FrameLayout {
    private static final String TAG = ATNativeAdView.class.getSimpleName();
    View mAdView;
    NativeAd.ImpressionEventListener mImpressionEventListener;
    boolean mIsInWindow;
    NativeAd mNativeAd;
    int mNativeAdId;

    public ATNativeAdView(Context context) {
        super(context);
    }

    private void callbackImpression() {
        NativeAd.ImpressionEventListener impressionEventListener = this.mImpressionEventListener;
        if (impressionEventListener != null) {
            impressionEventListener.onImpression();
        }
    }

    public synchronized void attachNativeAd(NativeAd nativeAd) {
        this.mNativeAd = nativeAd;
    }

    synchronized void clear() {
        if (this.mNativeAd != null) {
            try {
                this.mNativeAd.clear(this);
            } catch (Throwable unused) {
            }
            this.mNativeAd = null;
        }
    }

    public void clearImpressionListener(int i2) {
        if (this.mNativeAdId == i2) {
            this.mImpressionEventListener = null;
        }
    }

    public void destory() {
        this.mImpressionEventListener = null;
    }

    protected boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
        if (getVisibility() == 0) {
            callbackImpression();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0 && getVisibility() == 0) {
            callbackImpression();
        }
    }

    protected void renderView(int i2, View view, NativeAd.ImpressionEventListener impressionEventListener) {
        View view2 = this.mAdView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mAdView = view;
        this.mNativeAdId = i2;
        this.mImpressionEventListener = impressionEventListener;
        addView(this.mAdView);
        if (this.mIsInWindow && getVisibility() == 0) {
            callbackImpression();
        }
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
