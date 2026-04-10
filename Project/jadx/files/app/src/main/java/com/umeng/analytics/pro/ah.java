package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class ah implements z {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.a) {
                i0.a.b.a.a.a.a.a(context);
                this.a = true;
            }
            if (i0.a.b.a.a.a.a.a()) {
                return i0.a.b.a.a.a.a.b(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
