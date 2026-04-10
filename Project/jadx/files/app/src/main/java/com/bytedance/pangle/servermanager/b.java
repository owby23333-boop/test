package com.bytedance.pangle.servermanager;

import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.taobao.accs.common.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final Object a = new Object();
    private static final Object b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f14655c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Boolean> f14656d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, d> f14657e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f14658f;

    public static d a(String str) {
        Boolean bool = f14656d.get(str);
        if (bool == null || !bool.booleanValue()) {
            f14657e.remove(str);
        }
        if (f14657e.get(str) == null) {
            synchronized (b) {
                d dVar = (d) a(NotificationCompat.CATEGORY_SERVICE, str);
                if (dVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                f14657e.put(str, dVar);
            }
        }
        return f14657e.get(str);
    }

    public static c a() {
        Boolean bool = f14656d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f14658f = null;
        }
        if (f14658f == null) {
            synchronized (f14655c) {
                c cVar = (c) a(Constants.KEY_PACKAGE, "main");
                if (cVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f14658f = cVar;
            }
        }
        return f14658f;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface a(java.lang.String r6, final java.lang.String r7) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto Lb2
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r7)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto La2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()
            android.content.ContentResolver r1 = r1.getContentResolver()
            r2 = 0
            java.lang.String r3 = "query_binder"
            android.os.Bundle r0 = r1.call(r0, r3, r6, r2)
            if (r0 == 0) goto L4d
            java.lang.Class<com.bytedance.pangle.servermanager.AbsServerManager> r1 = com.bytedance.pangle.servermanager.AbsServerManager.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            java.lang.String r1 = "binder"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.bytedance.pangle.servermanager.a r0 = (com.bytedance.pangle.servermanager.a) r0
            if (r0 == 0) goto L4d
            android.os.IBinder r0 = r0.a
            goto L4e
        L4d:
            r0 = r2
        L4e:
            if (r0 == 0) goto La1
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto La1
            com.bytedance.pangle.servermanager.b$1 r1 = new com.bytedance.pangle.servermanager.b$1     // Catch: android.os.RemoteException -> L99
            r1.<init>()     // Catch: android.os.RemoteException -> L99
            r3 = 0
            r0.linkToDeath(r1, r3)     // Catch: android.os.RemoteException -> L99
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.b.f14656d     // Catch: android.os.RemoteException -> L99
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L99
            r1.put(r7, r4)     // Catch: android.os.RemoteException -> L99
            r7 = -1
            int r1 = r6.hashCode()     // Catch: android.os.RemoteException -> L99
            r4 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r5 = 1
            if (r1 == r4) goto L81
            r3 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r1 == r3) goto L77
            goto L8a
        L77:
            java.lang.String r1 = "service"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L99
            if (r6 == 0) goto L8a
            r7 = 1
            goto L8a
        L81:
            java.lang.String r1 = "package"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L99
            if (r6 == 0) goto L8a
            r7 = 0
        L8a:
            if (r7 == 0) goto L94
            if (r7 == r5) goto L8f
            goto La1
        L8f:
            com.bytedance.pangle.d r6 = com.bytedance.pangle.d.a.a(r0)     // Catch: android.os.RemoteException -> L99
            return r6
        L94:
            com.bytedance.pangle.c r6 = com.bytedance.pangle.c.a.a(r0)     // Catch: android.os.RemoteException -> L99
            return r6
        L99:
            r6 = move-exception
            java.lang.String r7 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r7, r0, r6)
        La1:
            return r2
        La2:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        Lb2:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.b.a(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
