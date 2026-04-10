package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.vivo.identifier.IdentifierManager;

/* JADX INFO: compiled from: VivoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
public class ak implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        String strB = null;
        try {
            if (!IdentifierManager.a(context)) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                strB = IdentifierManager.b(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strB;
    }
}
