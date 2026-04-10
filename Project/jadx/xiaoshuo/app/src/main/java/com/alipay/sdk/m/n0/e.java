package com.alipay.sdk.m.n0;

import android.content.BroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public final class e extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L88
            if (r6 != 0) goto L6
            goto L88
        L6:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "shouldUpdateId, notifyFlag : "
            java.lang.String r2 = r3.concat(r2)
            com.alipay.sdk.m.n0.f.a(r2)
            r2 = 1
            if (r0 != r2) goto L2f
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L46
            goto L45
        L2f:
            r3 = 2
            if (r0 != r3) goto L43
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L46
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L46
        L43:
            if (r0 != 0) goto L46
        L45:
            r1 = r2
        L46:
            if (r1 != 0) goto L49
            return
        L49:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            com.alipay.sdk.m.n0.f r6 = com.alipay.sdk.m.n0.f.a()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L5e
            com.alipay.sdk.m.n0.a r5 = r6.f1884b
            goto L82
        L5e:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L6a
            com.alipay.sdk.m.n0.a r5 = r6.d
            goto L82
        L6a:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L75
            com.alipay.sdk.m.n0.a r5 = r6.c
            goto L82
        L75:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L81
            com.alipay.sdk.m.n0.a r5 = r6.f1883a
            goto L82
        L81:
            r5 = 0
        L82:
            if (r5 != 0) goto L85
            return
        L85:
            r5.b()
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n0.e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
