package com.msa.sdk.core.landingPage.DownloadActionInfo;

import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadSetting {
    private int mDownloadSource = 3;
    private boolean mEnableAutoDownload;
    private boolean mIsForwardWhenActionSuccess;
    private boolean mIsSilentDownload;
    private IDownloadListener mListener;
    private int mMarketDownloadType;
    private int mMarketFloatCardPosition;
    private String mPackageName;
    private Action.AdTrackInfo mTrackInfo;

    public DownloadSetting(String str) {
        this.mPackageName = str;
    }

    public int getDownloadSource() {
        return this.mDownloadSource;
    }

    public boolean getEnableAutoDownload() {
        return this.mEnableAutoDownload;
    }

    public boolean getIsForwardWhenActionSuccess() {
        return this.mIsForwardWhenActionSuccess;
    }

    public boolean getIsSlientDownload() {
        return this.mIsSilentDownload;
    }

    public IDownloadListener getListener() {
        return this.mListener;
    }

    public int getMarketDownloadType() {
        return this.mMarketDownloadType;
    }

    public int getMarketFloatCardPosition() {
        return this.mMarketFloatCardPosition;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Action.AdTrackInfo getTrackInfo() {
        return this.mTrackInfo;
    }

    public DownloadSetting setDownloadSource(int i) {
        this.mDownloadSource = i;
        return this;
    }

    public DownloadSetting setEnableAutoDownload(boolean z) {
        this.mEnableAutoDownload = z;
        return this;
    }

    public DownloadSetting setIsForwardWhenActionSuccess(boolean z) {
        this.mIsForwardWhenActionSuccess = z;
        return this;
    }

    public DownloadSetting setIsSlientDownload(boolean z) {
        this.mIsSilentDownload = z;
        return this;
    }

    public DownloadSetting setListener(IDownloadListener iDownloadListener) {
        this.mListener = iDownloadListener;
        return this;
    }

    public DownloadSetting setMarketDownloadType(int i) {
        this.mMarketDownloadType = i;
        return this;
    }

    public DownloadSetting setMarketFloatCardPos(int i) {
        this.mMarketFloatCardPosition = i;
        return this;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public DownloadSetting setTrackInfo(Action.AdTrackInfo adTrackInfo) {
        this.mTrackInfo = adTrackInfo;
        return this;
    }
}
