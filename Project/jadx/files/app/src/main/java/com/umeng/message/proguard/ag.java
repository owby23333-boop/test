package com.umeng.message.proguard;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;

/* JADX INFO: compiled from: HttpDnsManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class ag {
    private static final String a = "HttpDnsManager";
    private static final int b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20443c = 5;

    public static String a(Context context, String str) {
        String ipByHostAsync;
        try {
            HttpDnsService service = HttpDns.getService(context, MsgConstant.ACCOUNT_ID);
            service.setExpiredIPEnabled(true);
            ipByHostAsync = null;
            int i2 = 0;
            do {
                try {
                    ipByHostAsync = service.getIpByHostAsync(str);
                    if (ipByHostAsync != null) {
                        break;
                    }
                    Thread.sleep(500L);
                    i2++;
                } catch (Throwable th) {
                    th = th;
                    UPLog.e(a, "getIpByHost error:", th.getMessage());
                }
            } while (i2 < 5);
        } catch (Throwable th2) {
            th = th2;
            ipByHostAsync = null;
        }
        return ipByHostAsync;
    }
}
