package com.msa.sdk.core.landingPage.DownloadActionInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCardSetting {
    private boolean mEnableAutoDismiss;
    private boolean mEnableCancel;

    public boolean getEnableAutoDismiss() {
        return this.mEnableAutoDismiss;
    }

    public boolean getEnableCancel() {
        return this.mEnableCancel;
    }

    public DownloadCardSetting setEnableAutoDismiss(boolean z) {
        this.mEnableAutoDismiss = z;
        return this;
    }

    public DownloadCardSetting setEnableCancel(boolean z) {
        this.mEnableCancel = z;
        return this;
    }
}
