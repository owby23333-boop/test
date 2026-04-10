package com.xiaomi.ad.mediation;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdError {
    public static final int LOAD_AD_STYLE_NOT_MATCH = -1201;
    public static final int LOAD_CREATE_LOADER_ERROR = -1000;
    public static final int LOAD_GENERATE_ERROR = -800;
    public static final int LOAD_NO_AD = -100;
    public static final int LOAD_NO_AD_ADAPTER = -700;
    public static final int LOAD_NO_AD_CONFIG = -500;
    public static final int LOAD_NO_IMAGE_SIZE = -600;
    public static final int LOAD_NO_SDK_CONFIG = -400;
    public static final int LOAD_NO_VIEW_SIZE = -1200;
    public static final int LOAD_REQUEST_AD_EXISTS = -1100;
    public static final int LOAD_REQUEST_ERROR = -300;
    public static final int LOAD_TAG_ID_CLOSED = -900;
    public static final int LOAD_TIMEOUT = -200;
    public static final int SHOW_AD_ALREADY_SHOWN = -2200;
    public static final int SHOW_AD_ERROR = -2000;
    public static final int SHOW_AD_EXPIRED = -2100;
    public int errorCode;
    public String errorMessage;
    public String externalErrorCode;

    public MMAdError(int i) {
        this.errorCode = i;
    }

    public String toString() {
        return "{errorCode=" + this.errorCode + ", externalErrorCode='" + this.externalErrorCode + "', errorMessage='" + this.errorMessage + "'}";
    }

    public MMAdError(int i, String str, String str2) {
        this.errorCode = i;
        this.externalErrorCode = str;
        this.errorMessage = str2;
    }
}
