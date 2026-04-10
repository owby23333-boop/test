package com.funny.audio.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddressSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/funny/audio/api/AddressSettingDefault;", "", "()V", "BUSINESS", "", "getBUSINESS", "()Ljava/lang/String;", "setBUSINESS", "(Ljava/lang/String;)V", "BUSINESS_STATIC", "getBUSINESS_STATIC", "setBUSINESS_STATIC", "CLOUD", "getCLOUD", "setCLOUD", "NOTICE", "getNOTICE", "setNOTICE", "SEARCH", "getSEARCH", "setSEARCH", "STATIC_RESOURCE", "getSTATIC_RESOURCE", "setSTATIC_RESOURCE", "TRACK_RESOURCE", "getTRACK_RESOURCE", "setTRACK_RESOURCE", "USER", "getUSER", "setUSER", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AddressSettingDefault {
    public static final AddressSettingDefault INSTANCE = new AddressSettingDefault();
    private static String BUSINESS = "http://210.16.182.232:11001/";
    private static String BUSINESS_STATIC = "http://58.49.146.24:30102/";
    private static String USER = "http://210.16.182.232:11021/";
    private static String CLOUD = "https://umeng-log-v5.gz.bcebos.com/";
    private static String STATIC_RESOURCE = "http://58.49.150.186:10202/";
    private static String SEARCH = "http://210.16.182.232:11011/";
    private static String TRACK_RESOURCE = "http://track.umeng-zlog.com/";
    private static String NOTICE = "https://umeng-log-v6.gz.bcebos.com/";

    private AddressSettingDefault() {
    }

    public final String getBUSINESS() {
        return BUSINESS;
    }

    public final void setBUSINESS(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BUSINESS = str;
    }

    public final String getBUSINESS_STATIC() {
        return BUSINESS_STATIC;
    }

    public final void setBUSINESS_STATIC(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BUSINESS_STATIC = str;
    }

    public final String getUSER() {
        return USER;
    }

    public final void setUSER(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        USER = str;
    }

    public final String getCLOUD() {
        return CLOUD;
    }

    public final void setCLOUD(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        CLOUD = str;
    }

    public final String getSTATIC_RESOURCE() {
        return STATIC_RESOURCE;
    }

    public final void setSTATIC_RESOURCE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        STATIC_RESOURCE = str;
    }

    public final String getSEARCH() {
        return SEARCH;
    }

    public final void setSEARCH(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SEARCH = str;
    }

    public final String getTRACK_RESOURCE() {
        return TRACK_RESOURCE;
    }

    public final void setTRACK_RESOURCE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        TRACK_RESOURCE = str;
    }

    public final String getNOTICE() {
        return NOTICE;
    }

    public final void setNOTICE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        NOTICE = str;
    }
}
