package com.msa.sdk.core.landingPage.builder;

import com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import com.miui.systemAdSolution.landingPageV2.task.action.DeeplinkAction;

/* JADX INFO: loaded from: classes3.dex */
public class DeeplinkActionBuilder extends ActionBuilder<IDeeplinkListener> {
    private String mTargetPackageName;
    private String mUrl;

    @Override // com.msa.sdk.core.landingPage.builder.ActionBuilder
    public Action build() {
        return new DeeplinkAction(this.mTrackInfo, (IDeeplinkListener) this.mListener, this.mIsForwardWhenSuccess, this.mUrl, this.mTargetPackageName);
    }

    public DeeplinkActionBuilder buildTargetPackageName(String str) {
        this.mTargetPackageName = str;
        return this;
    }

    public DeeplinkActionBuilder buildUrl(String str) {
        this.mUrl = str;
        return this;
    }
}
