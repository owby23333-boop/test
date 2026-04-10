package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f20047c;

    public c(Context context) {
        this.f20047c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f20047c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.f20034i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f20047c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f20047c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.f20033h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.f20036k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.f20034i = a.f20036k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.f20034i = a.f20033h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126 A[PHI: r1 r3 r11
  0x0126: PHI (r1v2 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v3 boolean) binds: [B:38:0x0112, B:47:0x0123, B:25:0x00f9] A[DONT_GENERATE, DONT_INLINE]
  0x0126: PHI (r3v9 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v10 java.io.OutputStream) binds: [B:38:0x0112, B:47:0x0123, B:25:0x00f9] A[DONT_GENERATE, DONT_INLINE]
  0x0126: PHI (r11v7 ??) = (r11v5 javax.net.ssl.HttpsURLConnection), (r11v6 javax.net.ssl.HttpsURLConnection), (r11v8 ??) binds: [B:38:0x0112, B:47:0x0123, B:25:0x00f9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
