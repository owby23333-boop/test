package com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.s;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class d extends e {
    private static volatile d bf;
    public static HashMap<String, RemoteCallbackList<s>> e = new HashMap<>();

    public static d bf() {
        if (bf == null) {
            synchronized (d.class) {
                if (bf == null) {
                    bf = new d();
                }
            }
        }
        return bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, s sVar) throws RemoteException {
        if (sVar == null) {
            return;
        }
        RemoteCallbackList<s> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(sVar);
        e.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, int i) throws RemoteException {
        RemoteCallbackList<s> remoteCallbackListRemove = e.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            s sVar = (s) remoteCallbackListRemove.getBroadcastItem(i2);
            if (sVar != null) {
                if (i == 1) {
                    sVar.e();
                } else if (i == 2) {
                    sVar.bf();
                } else if (i != 3) {
                    sVar.d();
                } else {
                    sVar.d();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
