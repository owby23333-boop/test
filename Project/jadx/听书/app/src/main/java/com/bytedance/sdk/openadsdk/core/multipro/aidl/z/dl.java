package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.i;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class dl extends z {
    private static volatile dl g;
    public static HashMap<String, RemoteCallbackList<i>> z = new HashMap<>();

    public static dl g() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, i iVar) throws RemoteException {
        if (iVar == null) {
            return;
        }
        RemoteCallbackList<i> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iVar);
        z.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, int i) throws RemoteException {
        RemoteCallbackList<i> remoteCallbackListRemove = z.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            i iVar = (i) remoteCallbackListRemove.getBroadcastItem(i2);
            if (iVar != null) {
                if (i == 1) {
                    iVar.z();
                } else if (i == 2) {
                    iVar.g();
                } else if (i == 3) {
                    iVar.dl();
                } else {
                    iVar.dl();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
