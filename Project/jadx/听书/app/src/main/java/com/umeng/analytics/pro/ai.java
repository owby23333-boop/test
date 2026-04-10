package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
public class ai implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2171a = false;

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        try {
            if (!this.f2171a) {
                OpenIDSDK.a(context);
                this.f2171a = true;
            }
            if (!OpenIDSDK.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return OpenIDSDK.c(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
