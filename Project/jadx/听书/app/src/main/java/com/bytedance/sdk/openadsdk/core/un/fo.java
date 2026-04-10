package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.umeng.analytics.pro.an;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements com.bytedance.sdk.component.a.z.z, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return getAndroidId();
            case 2:
            case 6:
            case 19:
            case 22:
            case 23:
            case 24:
            case 27:
            case 28:
            default:
                return null;
            case 3:
                return Integer.valueOf(getConnType());
            case 4:
                return getDeviceModel();
            case 5:
                return getDeviceName();
            case 7:
                return getLanguage();
            case 8:
                return getLocalLanguage();
            case 9:
                return getMcc();
            case 10:
                return getMnc();
            case 11:
                return Integer.valueOf(getOs());
            case 12:
                return getOsVersion();
            case 13:
                return getTimeZone();
            case 14:
                return getTotalMem();
            case 15:
                return getTotalSpace();
            case 16:
                return getVendor();
            case 17:
                return getBoot();
            case 18:
                return getCarrierName();
            case 20:
                return getIP();
            case 21:
                return getUUId();
            case 25:
                return getCompilingTime();
            case 26:
                return getBuildSerial();
            case 29:
                return getUserAgent();
            case 30:
                return getRom();
            case 31:
                return Integer.valueOf(getTimeZoneInt());
            case 32:
                return getDisplayDensity();
            case 33:
                return Integer.valueOf(getDeviceType(((Boolean) sparseArray.get(1)).booleanValue()));
            case 34:
                return getWebViewUA();
            case 35:
                return getNewIpAddrs(((Boolean) sparseArray.get(1)).booleanValue());
            case 36:
                return getWifiMac((Boolean) sparseArray.get(1));
            case 37:
                com.bytedance.sdk.component.a.z.dl location = getLocation();
                return location != null ? new com.bytedance.sdk.component.a.z.a(location) : location;
            case 38:
                return getImei((Boolean) sparseArray.get(1));
            case 39:
                return getMacAddress((Boolean) sparseArray.get(1));
            case 40:
                return getSSID((Boolean) sparseArray.get(1));
            case 41:
                return getImsi((Boolean) sparseArray.get(1));
            case 42:
                return getOAID(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return getAppLogDid();
            case 44:
                return getIpv6();
        }
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getOs() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getAndroidId() {
        return com.bytedance.sdk.openadsdk.core.tb.m();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getConnType() {
        return com.bytedance.sdk.component.utils.v.dl(com.bytedance.sdk.openadsdk.core.zw.getContext());
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDeviceModel() {
        return com.bytedance.sdk.openadsdk.core.tb.fv();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDeviceName() {
        Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        return context == null ? "" : Settings.Global.getString(context.getContentResolver(), an.J);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getLocalLanguage() {
        return kb.kb();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMcc() {
        return com.bytedance.sdk.openadsdk.core.tb.i();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMnc() {
        return com.bytedance.sdk.openadsdk.core.tb.pf();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTotalMem() {
        return String.valueOf(Long.parseLong(eo.wp()) * 1024);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTotalSpace() {
        return String.valueOf(eo.p());
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getVendor() {
        return Build.MANUFACTURER;
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getBoot() {
        String string;
        double dCurrentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            string = new Formatter().format("%.6f", Double.valueOf(dCurrentTimeMillis)).toString();
        } catch (Exception unused) {
            string = "";
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return new DecimalFormat("#0.000000").format(dCurrentTimeMillis);
        } catch (Exception unused2) {
            return string;
        }
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getCarrierName() {
        return com.bytedance.sdk.openadsdk.core.tb.p();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getIP() {
        return kb.m();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getUUId() {
        return com.bytedance.sdk.openadsdk.core.dl.z.dl();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getCompilingTime() {
        return com.bytedance.sdk.openadsdk.core.tb.a();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getBuildSerial() {
        return com.bytedance.sdk.openadsdk.core.tb.gz();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getUserAgent() {
        return eo.m();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getRom() {
        return com.bytedance.sdk.openadsdk.core.q.z.kb();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getTimeZoneInt() {
        return com.bytedance.sdk.openadsdk.core.q.z.wp();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDisplayDensity() {
        return com.bytedance.sdk.openadsdk.core.q.z.z(oq.gz(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getDeviceType(boolean z) {
        return kb.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), z);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getWebViewUA() {
        return eo.e();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String[] getNewIpAddrs(boolean z) {
        return kb.z(z);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public com.bytedance.sdk.component.a.z.dl getLocation() {
        return a.z(com.bytedance.sdk.openadsdk.core.zw.getContext());
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getWifiMac(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.tb.a(bool);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getImei(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.tb.z(bool);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMacAddress(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.tb.gc(bool);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getSSID(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.tb.dl(bool);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getImsi(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.tb.g(bool);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getOAID(boolean z) {
        return zw.z(z);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getAppLogDid() {
        return com.bytedance.sdk.openadsdk.core.m.z().dl();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getIpv6() {
        return kb.e();
    }
}
