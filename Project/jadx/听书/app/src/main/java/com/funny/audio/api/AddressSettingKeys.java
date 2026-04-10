package com.funny.audio.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddressSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/funny/audio/api/AddressSettingKeys;", "", "()V", "BUSINESS", "", "getBUSINESS", "()Ljava/lang/String;", "BUSINESS_STATIC", "getBUSINESS_STATIC", "CLOUD", "getCLOUD", "NOTICE", "getNOTICE", "SEARCH", "getSEARCH", "STATIC_RESOURCE", "getSTATIC_RESOURCE", "setSTATIC_RESOURCE", "(Ljava/lang/String;)V", "TRACK_RESOURCE", "getTRACK_RESOURCE", "setTRACK_RESOURCE", "USER", "getUSER", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AddressSettingKeys {
    public static final AddressSettingKeys INSTANCE = new AddressSettingKeys();
    private static final String BUSINESS = "KEY_ADDRESS_SETTING_BUSINESS";
    private static final String BUSINESS_STATIC = "KEY_ADDRESS_SETTING_BUSINESS_STATIC";
    private static final String USER = "KEY_ADDRESS_SETTING_USER";
    private static final String CLOUD = "KEY_ADDRESS_SETTING_CLOUD";
    private static String STATIC_RESOURCE = "KEY_ADDRESS_SETTING_STATIC_RESOURCE";
    private static final String SEARCH = "KEY_ADDRESS_SETTING_SEARCH";
    private static String TRACK_RESOURCE = "KEY_ADDRESS_SETTING_TRACK_RESOURCE";
    private static final String NOTICE = "KEY_ADDRESS_SETTING_NOTICE";

    private AddressSettingKeys() {
    }

    public final String getBUSINESS() {
        return BUSINESS;
    }

    public final String getBUSINESS_STATIC() {
        return BUSINESS_STATIC;
    }

    public final String getUSER() {
        return USER;
    }

    public final String getCLOUD() {
        return CLOUD;
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
}
