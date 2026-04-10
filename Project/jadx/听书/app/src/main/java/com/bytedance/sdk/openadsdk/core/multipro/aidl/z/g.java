package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.js;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g extends z {
    private static volatile g g;
    private static Map<String, RemoteCallbackList<js>> z = Collections.synchronizedMap(new HashMap());

    public static g g() {
        if (g == null) {
            synchronized (g.class) {
                if (g == null) {
                    g = new g();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, js jsVar) throws RemoteException {
        RemoteCallbackList<js> remoteCallbackList = z.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(jsVar);
        z.put(str, remoteCallbackList);
        wp.a("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        wp.a("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + z.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void g(String str, js jsVar) throws RemoteException {
        Map<String, RemoteCallbackList<js>> map = z;
        if (map == null) {
            wp.a("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<js> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            wp.a("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        z(remoteCallbackListRemove);
        wp.a("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        wp.a("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + z.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        g(str, str2, j, j2, str3, str4);
    }

    private synchronized void g(String str, String str2, long j, long j2, String str3, String str4) {
        try {
            if (z == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                z(z.remove(str));
                wp.a("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                wp.a("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + z.size());
                return;
            }
            RemoteCallbackList<js> remoteCallbackList = z.get(str);
            if (remoteCallbackList != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        js jsVar = (js) remoteCallbackList.getBroadcastItem(i);
                        if (jsVar != null) {
                            if ("onIdle".equals(str2)) {
                                jsVar.z();
                            } else if ("onDownloadActive".equals(str2)) {
                                jsVar.z(j, j2, str3, str4);
                            } else if ("onDownloadPaused".equals(str2)) {
                                jsVar.g(j, j2, str3, str4);
                            } else if ("onDownloadFailed".equals(str2)) {
                                jsVar.dl(j, j2, str3, str4);
                            } else if ("onDownloadFinished".equals(str2)) {
                                try {
                                    jsVar.z(j, str3, str4);
                                } catch (Throwable th) {
                                    th = th;
                                    wp.dl("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onInstalled".equals(str2)) {
                                jsVar.z(str3, str4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            wp.dl("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }

    private void z(RemoteCallbackList<js> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        js jsVar = (js) remoteCallbackList.getBroadcastItem(i);
                        if (jsVar != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m) jsVar).dl();
                        }
                    } catch (Throwable th) {
                        wp.dl("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                wp.dl("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }
}
