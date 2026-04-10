package com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.pe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class bf extends e {
    private static volatile bf bf;
    private static Map<String, RemoteCallbackList<pe>> e = Collections.synchronizedMap(new HashMap());

    public static bf bf() {
        if (bf == null) {
            synchronized (bf.class) {
                if (bf == null) {
                    bf = new bf();
                }
            }
        }
        return bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, pe peVar) throws RemoteException {
        RemoteCallbackList<pe> remoteCallbackList = e.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(peVar);
        e.put(str, remoteCallbackList);
        wu.vn("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:" + str);
        wu.vn("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + e.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void bf(String str, pe peVar) throws RemoteException {
        Map<String, RemoteCallbackList<pe>> map = e;
        if (map == null) {
            wu.vn("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:" + str);
            return;
        }
        RemoteCallbackList<pe> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            wu.vn("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:" + str);
            return;
        }
        e(remoteCallbackListRemove);
        wu.vn("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:" + str);
        wu.vn("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + e.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        bf(str, str2, j, j2, str3, str4);
    }

    private void e(RemoteCallbackList<pe> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        pe peVar = (pe) remoteCallbackList.getBroadcastItem(i);
                        if (peVar != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.vn) peVar).d();
                        }
                    } catch (Throwable th) {
                        wu.d("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                wu.d("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }

    private synchronized void bf(String str, String str2, long j, long j2, String str3, String str4) {
        try {
        } catch (Throwable th) {
            wu.d("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th);
        }
        if (e == null) {
            return;
        }
        if ("recycleRes".equals(str2)) {
            e(e.remove(str));
            wu.vn("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:" + str);
            wu.vn("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + e.size());
            return;
        }
        RemoteCallbackList<pe> remoteCallbackList = e.get(str);
        if (remoteCallbackList != null) {
            int iBeginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < iBeginBroadcast; i++) {
                try {
                    pe peVar = (pe) remoteCallbackList.getBroadcastItem(i);
                    if (peVar != null) {
                        if ("onIdle".equals(str2)) {
                            peVar.e();
                        } else if ("onDownloadActive".equals(str2)) {
                            peVar.e(j, j2, str3, str4);
                        } else if ("onDownloadPaused".equals(str2)) {
                            peVar.bf(j, j2, str3, str4);
                        } else if ("onDownloadFailed".equals(str2)) {
                            peVar.d(j, j2, str3, str4);
                        } else if ("onDownloadFinished".equals(str2)) {
                            try {
                                peVar.e(j, str3, str4);
                            } catch (Throwable th2) {
                                th = th2;
                                wu.d("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                            }
                        } else if ("onInstalled".equals(str2)) {
                            peVar.e(str3, str4);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }
}
