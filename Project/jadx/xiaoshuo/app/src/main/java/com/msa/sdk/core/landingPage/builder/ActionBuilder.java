package com.msa.sdk.core.landingPage.builder;

import com.miui.systemAdSolution.landingPageV2.task.action.Action;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActionBuilder<T> {
    public static final int DOWNLOAD_SOURCE_DEFAULT = 3;
    public static final int DOWNLOAD_SOURCE_MIMARKET = 1;
    public static final int DOWNLOAD_SOURCE_NATIVE = 2;
    protected boolean mIsForwardWhenSuccess;
    protected T mListener;
    protected Action.AdTrackInfo mTrackInfo;

    public abstract Action build();

    public ActionBuilder buildAdTrackInfo(Action.AdTrackInfo adTrackInfo) {
        this.mTrackInfo = adTrackInfo;
        return this;
    }

    public ActionBuilder buildIsForwardWhenSuccess(boolean z) {
        this.mIsForwardWhenSuccess = z;
        return this;
    }

    public ActionBuilder buildListener(T t) {
        this.mListener = t;
        return this;
    }
}
