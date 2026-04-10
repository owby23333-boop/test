package com.taobao.accs.init;

import java.io.Serializable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Launcher_InitAgooLifecycle implements Serializable {
    private static final String a = Launcher_InitAgooLifecycle.class.getSimpleName();
    public static Class<?> adaemonClazz;
    public static boolean mADaemonValid;

    static {
        try {
            adaemonClazz = Class.forName("com.taobao.adaemon.ADaemon");
            mADaemonValid = true;
        } catch (Exception unused) {
            mADaemonValid = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        r10 = r4;
        r5 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.app.Application r9, java.util.HashMap<java.lang.String, java.lang.Object> r10) {
        /*
            r8 = this;
            java.lang.String r0 = com.taobao.accs.init.Launcher_InitAgooLifecycle.a
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "init"
            com.taobao.accs.utl.ALog.i(r0, r3, r2)
            android.content.Context r0 = r9.getApplicationContext()
            com.taobao.accs.client.GlobalClientInfo.a = r0
            com.taobao.accs.utl.l r0 = com.taobao.accs.utl.l.a()
            r0.a(r9)
            com.taobao.accs.client.GlobalClientInfo r0 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)
            com.taobao.accs.IAppReceiver r2 = com.taobao.accs.init.Launcher_InitAccs.mAppReceiver
            java.lang.String r3 = "default"
            r0.setAppReceiver(r3, r2)
            r0 = 0
            r2 = 1
            java.lang.String r3 = "envIndex"
            java.lang.Object r3 = r10.get(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L5e
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = "onlineAppKey"
            java.lang.Object r4 = r10.get(r4)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L5e
            r5 = 2
            if (r3 != r2) goto L47
            java.lang.String r3 = "preAppKey"
            java.lang.Object r10 = r10.get(r3)     // Catch: java.lang.Throwable -> L45
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L45
            r5 = 1
            goto L6b
        L45:
            r10 = move-exception
            goto L60
        L47:
            if (r3 != r5) goto L4b
            r6 = 1
            goto L4c
        L4b:
            r6 = 0
        L4c:
            r7 = 3
            if (r3 != r7) goto L51
            r3 = 1
            goto L52
        L51:
            r3 = 0
        L52:
            r3 = r3 | r6
            if (r3 == 0) goto L69
            java.lang.String r3 = "dailyAppkey"
            java.lang.Object r10 = r10.get(r3)     // Catch: java.lang.Throwable -> L45
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L45
            goto L6b
        L5e:
            r10 = move-exception
            r4 = r0
        L60:
            java.lang.String r3 = com.taobao.accs.init.Launcher_InitAgooLifecycle.a
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "init get param error"
            com.taobao.accs.utl.ALog.e(r3, r6, r10, r5)
        L69:
            r10 = r4
            r5 = 0
        L6b:
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L74
            java.lang.String r10 = "21646297"
            r5 = 0
        L74:
            com.taobao.accs.ACCSManager.setAppkey(r9, r10, r5)
            boolean r10 = com.taobao.accs.init.Launcher_InitAgooLifecycle.mADaemonValid
            if (r10 == 0) goto L9b
            java.lang.Class<?> r10 = com.taobao.accs.init.Launcher_InitAgooLifecycle.adaemonClazz     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = "initializeLifecycle"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L91
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r1] = r5     // Catch: java.lang.Exception -> L91
            java.lang.reflect.Method r10 = r10.getMethod(r3, r4)     // Catch: java.lang.Exception -> L91
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L91
            r2[r1] = r9     // Catch: java.lang.Exception -> L91
            r10.invoke(r0, r2)     // Catch: java.lang.Exception -> L91
            goto L9b
        L91:
            r9 = move-exception
            java.lang.String r10 = com.taobao.accs.init.Launcher_InitAgooLifecycle.a
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "adaemon initializeLifecycle error"
            com.taobao.accs.utl.ALog.e(r10, r1, r9, r0)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.init.Launcher_InitAgooLifecycle.init(android.app.Application, java.util.HashMap):void");
    }
}
