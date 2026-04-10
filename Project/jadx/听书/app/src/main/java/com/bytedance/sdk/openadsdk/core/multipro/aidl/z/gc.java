package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.pf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class gc extends z {
    private static volatile gc g;
    private static Map<String, RemoteCallbackList<pf>> z = Collections.synchronizedMap(new HashMap());

    public static gc g() {
        if (g == null) {
            synchronized (gc.class) {
                if (g == null) {
                    g = new gc();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public synchronized void z(String str, pf pfVar) throws RemoteException {
        RemoteCallbackList<pf> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(pfVar);
        z.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, String str2) throws RemoteException {
        dl(str, str2);
    }

    private synchronized void dl(String str, String str2) {
        RemoteCallbackList<pf> remoteCallbackListRemove;
        try {
            if (z != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = z.remove(str);
                } else {
                    remoteCallbackListRemove = z.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            pf pfVar = (pf) remoteCallbackListRemove.getBroadcastItem(i);
                            if (pfVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    pfVar.g();
                                } else if ("onAdClose".equals(str2)) {
                                    pfVar.a();
                                } else if ("onVideoComplete".equals(str2)) {
                                    pfVar.gc();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    pfVar.m();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    pfVar.dl();
                                } else if ("recycleRes".equals(str2)) {
                                    pfVar.z();
                                }
                            }
                        } catch (Throwable th) {
                            wp.dl("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            wp.dl("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }
}
