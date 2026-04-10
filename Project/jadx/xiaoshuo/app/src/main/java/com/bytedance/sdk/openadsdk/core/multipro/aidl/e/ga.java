package com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ga extends e {
    private static volatile ga bf;
    private static Map<String, RemoteCallbackList<l>> e = Collections.synchronizedMap(new HashMap());

    public static ga bf() {
        if (bf == null) {
            synchronized (ga.class) {
                if (bf == null) {
                    bf = new ga();
                }
            }
        }
        return bf;
    }

    private synchronized void d(String str, String str2) {
        try {
            if (e != null) {
                RemoteCallbackList<l> remoteCallbackListRemove = "recycleRes".equals(str2) ? e.remove(str) : e.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            l lVar = (l) remoteCallbackListRemove.getBroadcastItem(i);
                            if (lVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    lVar.bf();
                                } else if ("onAdClose".equals(str2)) {
                                    lVar.tg();
                                } else if ("onVideoComplete".equals(str2)) {
                                    lVar.ga();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    lVar.vn();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    lVar.d();
                                } else if ("recycleRes".equals(str2)) {
                                    lVar.e();
                                }
                            }
                        } catch (Throwable th) {
                            wu.d("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            wu.d("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public synchronized void e(String str, l lVar) throws RemoteException {
        RemoteCallbackList<l> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(lVar);
        e.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, String str2) throws RemoteException {
        d(str, str2);
    }
}
