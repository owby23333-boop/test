package com.efs.sdk.base.core.config.a;

import com.efs.sdk.base.IConfigRefreshAction;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IConfigRefreshAction {

    /* JADX INFO: renamed from: com.efs.sdk.base.core.config.a.a$a, reason: collision with other inner class name */
    static class C0234a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1547a = new a();
    }

    public static a a() {
        return C0234a.f1547a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a1, code lost:
    
        return "";
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String refresh() {
        /*
            r10 = this;
            com.efs.sdk.base.core.config.GlobalEnvStruct r0 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r0 = r0.mAppContext
            boolean r0 = com.efs.sdk.base.core.util.NetworkUtil.isConnected(r0)
            java.lang.String r1 = "efs.config"
            java.lang.String r2 = ""
            if (r0 != 0) goto L16
            java.lang.String r0 = "Config refresh fail, network is disconnected."
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            return r2
        L16:
            com.efs.sdk.base.core.config.a.c r0 = com.efs.sdk.base.core.config.a.c.a()
            r3 = 1
            java.lang.String r0 = r0.a(r3)
            com.efs.sdk.base.core.a.c r4 = com.efs.sdk.base.core.a.c.a()
            r5 = 0
        L24:
            r6 = 3
            if (r5 >= r6) goto La2
            com.efs.sdk.base.core.a.a r6 = com.efs.sdk.base.core.a.a.a()
            java.lang.String r7 = r4.b()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r9 = "/apm_cc"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r6 = r6.f1525a
            if (r6 == 0) goto L55
            java.lang.String r6 = "get config from server, url is "
            java.lang.String r9 = java.lang.String.valueOf(r8)
            java.lang.String r6 = r6.concat(r9)
            java.lang.String r9 = "efs.px.api"
            com.efs.sdk.base.core.util.Log.i(r9, r6)
        L55:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r3)
            java.lang.String r9 = "wpk-header"
            r6.put(r9, r7)
            com.efs.sdk.base.core.util.a.d r7 = new com.efs.sdk.base.core.util.a.d
            r7.<init>(r8)
            com.efs.sdk.base.core.util.a.d r6 = r7.a(r6)
            com.efs.sdk.base.core.a.b r7 = com.efs.sdk.base.core.a.b.a()
            com.efs.sdk.base.core.util.a.d r6 = r6.a(r7)
            com.efs.sdk.base.core.util.a.c r6 = r6.a()
            com.efs.sdk.base.core.util.a.b r7 = r6.f1576a
            java.lang.String r8 = "get"
            r7.e = r8
            java.lang.Object r6 = r6.a()
            com.efs.sdk.base.http.HttpResponse r6 = (com.efs.sdk.base.http.HttpResponse) r6
            boolean r7 = r6.succ
            if (r7 == 0) goto L87
            java.lang.String r2 = r6.data
            goto La2
        L87:
            java.lang.String r7 = r6.getBizCode()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto La1
            java.lang.String r7 = "1000"
            java.lang.String r6 = r6.getBizCode()
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L9e
            goto La1
        L9e:
            int r5 = r5 + 1
            goto L24
        La1:
            return r2
        La2:
            java.lang.String r0 = "config request succ, config is:\n "
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.concat(r3)
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.config.a.a.refresh():java.lang.String");
    }
}
