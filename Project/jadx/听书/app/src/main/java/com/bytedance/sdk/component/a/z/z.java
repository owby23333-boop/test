package com.bytedance.sdk.component.a.z;

/* JADX INFO: loaded from: classes2.dex */
public interface z {
    String getAndroidId();

    String getAppLogDid();

    String getBoot();

    String getBuildSerial();

    String getCarrierName();

    String getCompilingTime();

    int getConnType();

    String getDeviceModel();

    String getDeviceName();

    int getDeviceType(boolean z);

    String getDisplayDensity();

    String getIP();

    String getImei(Boolean bool);

    String getImsi(Boolean bool);

    String getIpv6();

    String getLanguage();

    String getLocalLanguage();

    dl getLocation();

    String getMacAddress(Boolean bool);

    String getMcc();

    String getMnc();

    String[] getNewIpAddrs(boolean z);

    String getOAID(boolean z);

    int getOs();

    String getOsVersion();

    String getRom();

    String getSSID(Boolean bool);

    String getTimeZone();

    int getTimeZoneInt();

    String getTotalMem();

    String getTotalSpace();

    String getUUId();

    String getUserAgent();

    String getVendor();

    String getWebViewUA();

    String getWifiMac(Boolean bool);
}
