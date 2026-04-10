package com.bytedance.pangle.servermanager;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.dl;
import com.bytedance.pangle.gc;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static dl m;
    private static final Object z = new Object();
    private static final Object g = new Object();
    private static final Object dl = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f532a = new ConcurrentHashMap();
    private static final Map<String, gc> gc = new ConcurrentHashMap();

    public static gc z(String str) {
        Boolean bool = f532a.get(str);
        if (bool == null || !bool.booleanValue()) {
            gc.remove(str);
        }
        Map<String, gc> map = gc;
        if (map.get(str) == null) {
            synchronized (g) {
                gc gcVar = (gc) z(NotificationCompat.CATEGORY_SERVICE, str);
                if (gcVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, gcVar);
            }
        }
        return map.get(str);
    }

    public static dl z() {
        Boolean bool = f532a.get("main");
        if (bool == null || !bool.booleanValue()) {
            m = null;
        }
        if (m == null) {
            synchronized (dl) {
                dl dlVar = (dl) z("package", "main");
                if (dlVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                m = dlVar;
            }
        }
        return m;
    }

    private static IBinder z(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            z zVar = (z) bundleCall.getParcelable("binder");
            if (zVar != null) {
                return zVar.z();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface z(java.lang.String r4, final java.lang.String r5) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto L90
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r5)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto L80
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.os.IBinder r0 = z(r0, r4)
            if (r0 == 0) goto L7e
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto L7e
            com.bytedance.pangle.servermanager.g$1 r1 = new com.bytedance.pangle.servermanager.g$1     // Catch: android.os.RemoteException -> L76
            r1.<init>()     // Catch: android.os.RemoteException -> L76
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L76
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.g.f532a     // Catch: android.os.RemoteException -> L76
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L76
            r1.put(r5, r3)     // Catch: android.os.RemoteException -> L76
            int r5 = r4.hashCode()     // Catch: android.os.RemoteException -> L76
            r1 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r3 = 1
            if (r5 == r1) goto L5d
            r1 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r5 == r1) goto L53
            goto L66
        L53:
            java.lang.String r5 = "service"
            boolean r4 = r4.equals(r5)     // Catch: android.os.RemoteException -> L76
            if (r4 == 0) goto L66
            r2 = r3
            goto L67
        L5d:
            java.lang.String r5 = "package"
            boolean r4 = r4.equals(r5)     // Catch: android.os.RemoteException -> L76
            if (r4 == 0) goto L66
            goto L67
        L66:
            r2 = -1
        L67:
            if (r2 == 0) goto L71
            if (r2 == r3) goto L6c
            goto L7e
        L6c:
            com.bytedance.pangle.gc r4 = com.bytedance.pangle.gc.z.z(r0)     // Catch: android.os.RemoteException -> L76
            return r4
        L71:
            com.bytedance.pangle.dl r4 = com.bytedance.pangle.dl.z.z(r0)     // Catch: android.os.RemoteException -> L76
            return r4
        L76:
            r4 = move-exception
            java.lang.String r5 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r5, r0, r4)
        L7e:
            r4 = 0
            return r4
        L80:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r0.concat(r5)
            r4.<init>(r5)
            throw r4
        L90:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r0.concat(r5)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.g.z(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
