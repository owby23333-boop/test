package com.miui.zeus.msa.framework.model;

import com.miui.systemAdSolution.landingPageV2.task.action.Action;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadConfig {
    public static final int INVALID_CALLER_VERSION = Integer.MIN_VALUE;
    public static final int MARKET_DOWNLOAD_FLOAT_CARD_BOTTOM = -1;
    public static final int MARKET_DOWNLOAD_FLOAT_CARD_TOP = 1;
    public static final int MARKET_DOWNLOAD_TYPE_CARD = 2;
    public static final int MARKET_DOWNLOAD_TYPE_FLOAT = 3;
    public static final int MARKET_DOWNLOAD_TYPE_MINI_CARD = 1;
    public static final int MARKET_DOWNLOAD_UNDEFINED = 0;
    public String callerPkg;
    public int callerVersion;
    public String downloadTargetPackageName;
    public String marketDownloadUrl;
    public Action.AdTrackInfo trackInfo;
    public String validationInfo;
    public int marketType = 0;
    public int floatCardPos = 1;
    public boolean autoDownload = false;
    public boolean finishWhenStart = false;

    public DownloadConfig() {
    }

    public DownloadConfig(Action.AdTrackInfo adTrackInfo, String str) {
        this.trackInfo = adTrackInfo;
        this.callerPkg = str;
    }
}
