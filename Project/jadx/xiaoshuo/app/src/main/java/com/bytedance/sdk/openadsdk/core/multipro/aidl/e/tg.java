package com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.w;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class tg extends e {
    private static volatile tg bf;
    private static HashMap<String, RemoteCallbackList<w>> e = new HashMap<>();

    public static tg bf() {
        if (bf == null) {
            synchronized (tg.class) {
                if (bf == null) {
                    bf = new tg();
                }
            }
        }
        return bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, w wVar) throws RemoteException {
        if (wVar == null) {
            return;
        }
        wu.bf("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<w> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(wVar);
        e.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void bf(String str, String str2) throws RemoteException {
        wu.bf("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + ", " + str2);
        RemoteCallbackList<w> remoteCallbackListRemove = e.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            w wVar = (w) remoteCallbackListRemove.getBroadcastItem(i);
            if (wVar != null) {
                wu.bf("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + ", " + str2);
                if (str2 == null) {
                    wVar.e();
                } else {
                    wVar.e(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
