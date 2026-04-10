package com.duokan.quality.manager.network;

import miuix.android.content.MiuiIntent;

/* JADX INFO: loaded from: classes17.dex */
public enum NetState {
    NOT_CONNECTED("NONE"),
    MOBILE_2G("2G"),
    MOBILE_3G("3G"),
    MOBILE_4G("4G"),
    MOBILE_5G("5G"),
    WIFI(MiuiIntent.WIFI_NAME),
    ETHERNET("ETHERNET"),
    UNKNOWN("UNKNOWN");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3872a;

    NetState(String str) {
        this.f3872a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f3872a;
    }
}
