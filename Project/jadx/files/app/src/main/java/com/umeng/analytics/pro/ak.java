package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: XiaomiDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
class ak implements z {
    ak() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String strA = null;
        try {
            if (i0.a.b.c.a.a.a()) {
                strA = i0.a.b.c.a.a.a(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strA;
    }
}
