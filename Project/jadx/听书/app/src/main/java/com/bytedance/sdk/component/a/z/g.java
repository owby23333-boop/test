package com.bytedance.sdk.component.a.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    Function z;

    public g(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getAndroidId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getAppLogDid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getBoot() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getBuildSerial() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getCarrierName() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getCompilingTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getConnType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDeviceModel() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDeviceName() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getDeviceType(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Boolean.valueOf(z));
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getDisplayDensity() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getIP() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getImei(Boolean bool) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, bool);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getImsi(Boolean bool) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        sparseArray.put(1, bool);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getIpv6() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getLanguage() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getLocalLanguage() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.z.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.bytedance.sdk.component.a.z.z
    public dl getLocation() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        ?? Apply = this.z.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new a((Function) Apply);
        }
        return (dl) aVar;
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMacAddress(Boolean bool) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, bool);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMcc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getMnc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String[] getNewIpAddrs(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getOAID(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getOs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getOsVersion() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getRom() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getSSID(Boolean bool) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, bool);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTimeZone() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public int getTimeZoneInt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTotalMem() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getTotalSpace() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getUUId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getUserAgent() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getVendor() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getWebViewUA() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z.z
    public String getWifiMac(Boolean bool) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, bool);
        return (String) this.z.apply(sparseArray);
    }
}
