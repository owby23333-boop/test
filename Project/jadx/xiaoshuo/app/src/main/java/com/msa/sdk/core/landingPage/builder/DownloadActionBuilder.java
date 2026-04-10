package com.msa.sdk.core.landingPage.builder;

import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import com.miui.systemAdSolution.landingPageV2.task.action.DownloadAction;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadActionBuilder extends ActionBuilder<IDownloadListener> {
    private DownloadAction.DownloadInfo mDownloadInfo;
    private int mDownloadSource;
    private boolean mIsDownloadAutoStart;
    private boolean mIsDownloadByMiniCard;
    private int mMarketDownloadType;
    private int mMarketFloatCardPosition;
    private DownloadAction.MiniCardConfig mMiniCardConfig;
    private String mPackageName;

    @Override // com.msa.sdk.core.landingPage.builder.ActionBuilder
    public Action build() {
        return new DownloadAction(this.mTrackInfo, (IDownloadListener) this.mListener, this.mIsForwardWhenSuccess, this.mPackageName, this.mDownloadSource, this.mIsDownloadByMiniCard, this.mIsDownloadAutoStart, this.mMiniCardConfig, this.mDownloadInfo, this.mMarketDownloadType, this.mMarketFloatCardPosition);
    }

    public DownloadActionBuilder buildDownloadInfo(DownloadAction.DownloadInfo downloadInfo) {
        this.mDownloadInfo = downloadInfo;
        return this;
    }

    public DownloadActionBuilder buildDownloadSource(int i) {
        this.mDownloadSource = i;
        return this;
    }

    public DownloadActionBuilder buildIsDownloadByMiniCard(boolean z) {
        this.mIsDownloadByMiniCard = z;
        return this;
    }

    public DownloadActionBuilder buildIsMinicardAutoDownload(boolean z) {
        this.mIsDownloadAutoStart = z;
        return this;
    }

    public DownloadActionBuilder buildMarketDownloadType(int i) {
        this.mMarketDownloadType = i;
        return this;
    }

    public DownloadActionBuilder buildMarketFloatCardPos(int i) {
        this.mMarketFloatCardPosition = i;
        return this;
    }

    public DownloadActionBuilder buildMiniCardConfig(DownloadAction.MiniCardConfig miniCardConfig) {
        this.mMiniCardConfig = miniCardConfig;
        return this;
    }

    public DownloadActionBuilder buildPackageName(String str) {
        this.mPackageName = str;
        return this;
    }
}
