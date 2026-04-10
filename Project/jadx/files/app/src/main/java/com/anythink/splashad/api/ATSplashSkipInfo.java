package com.anythink.splashad.api;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.expressad.exoplayer.i.a;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashSkipInfo {
    public static final String TAG = "ATSplashSkipInfo";
    ATSplashSkipAdListener mATSplashSkipAdListener;
    long mCallbackInterval;
    ViewGroup mContainer;
    long mCountDownDuration;
    View mSkipView;

    public ATSplashSkipInfo(View view, long j2, long j3, ATSplashSkipAdListener aTSplashSkipAdListener) {
        this.mSkipView = view;
        this.mCountDownDuration = j2;
        this.mCallbackInterval = j3;
        this.mATSplashSkipAdListener = aTSplashSkipAdListener;
        if (this.mCountDownDuration < a.f9492f) {
            this.mCountDownDuration = a.f9492f;
        }
        long j4 = this.mCallbackInterval;
        if (j4 <= 0) {
            this.mCallbackInterval = 1000L;
        } else if (j4 < 20) {
            this.mCallbackInterval = 20L;
        }
    }

    public boolean canUseCustomSkipView() {
        return this.mSkipView != null;
    }

    public void destroy() {
        View view = this.mSkipView;
        if (view != null) {
            view.setOnClickListener(null);
            this.mSkipView = null;
        }
        this.mATSplashSkipAdListener = null;
    }

    public ATSplashSkipAdListener getATSplashSkipAdListener() {
        return this.mATSplashSkipAdListener;
    }

    public long getCallbackInterval() {
        return this.mCallbackInterval;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public long getCountDownDuration() {
        return this.mCountDownDuration;
    }

    public View getSkipView() {
        return this.mSkipView;
    }

    public void setContainer(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public ATSplashSkipInfo(View view, ATSplashSkipAdListener aTSplashSkipAdListener) {
        this(view, 5000L, 1000L, aTSplashSkipAdListener);
    }
}
