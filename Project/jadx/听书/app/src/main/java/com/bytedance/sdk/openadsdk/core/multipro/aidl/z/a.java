package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a extends z {
    private static volatile a g;
    private static HashMap<String, RemoteCallbackList<v>> z = new HashMap<>();

    public static a g() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, v vVar) throws RemoteException {
        if (vVar == null) {
            return;
        }
        RemoteCallbackList<v> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(vVar);
        z.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void g(String str, String str2) throws RemoteException {
        RemoteCallbackList<v> remoteCallbackListRemove = z.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            v vVar = (v) remoteCallbackListRemove.getBroadcastItem(i);
            if (vVar != null) {
                if (str2 == null) {
                    vVar.z();
                } else {
                    vVar.z(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
