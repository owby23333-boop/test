package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: VivoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class aj implements z {
    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String strB = null;
        try {
            if (i0.a.b.d.a.d.a(context)) {
                strB = i0.a.b.d.a.d.b(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strB;
    }
}
