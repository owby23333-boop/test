package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2323a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120 A[PHI: r3 r4 r12
  0x0120: PHI (r3v2 boolean) = (r3v0 boolean), (r3v0 boolean), (r3v3 boolean) binds: [B:34:0x010e, B:41:0x011d, B:23:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x0120: PHI (r4v10 java.io.OutputStream) = (r4v8 java.io.OutputStream), (r4v9 java.io.OutputStream), (r4v11 java.io.OutputStream) binds: [B:34:0x010e, B:41:0x011d, B:23:0x00f7] A[DONT_GENERATE, DONT_INLINE]
  0x0120: PHI (r12v7 ??) = (r12v5 javax.net.ssl.HttpsURLConnection), (r12v6 javax.net.ssl.HttpsURLConnection), (r12v8 ??) binds: [B:34:0x010e, B:41:0x011d, B:23:0x00f7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v14, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
