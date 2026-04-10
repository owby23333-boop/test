package com.msa.sdk.core.landingPage.builder;

import com.miui.systemAdSolution.landingPageV2.listener.IH5Listener;
import com.miui.systemAdSolution.landingPageV2.task.action.H5Action;

/* JADX INFO: loaded from: classes3.dex */
public class H5ActionBuilder extends ActionBuilder<IH5Listener> {
    private String mH5Url;

    public H5ActionBuilder buildH5Url(String str) {
        this.mH5Url = str;
        return this;
    }

    @Override // com.msa.sdk.core.landingPage.builder.ActionBuilder
    public H5Action build() {
        return new H5Action(this.mTrackInfo, (IH5Listener) this.mListener, this.mIsForwardWhenSuccess, this.mH5Url);
    }
}
