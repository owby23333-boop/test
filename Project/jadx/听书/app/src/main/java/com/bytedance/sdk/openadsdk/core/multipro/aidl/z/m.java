package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class m extends z {
    private static volatile m g;
    private static final Map<String, RemoteCallbackList<p>> z = Collections.synchronizedMap(new HashMap());

    public static m g() {
        if (g == null) {
            synchronized (m.class) {
                if (g == null) {
                    g = new m();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, p pVar) throws RemoteException {
        RemoteCallbackList<p> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(pVar);
        z.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public Bundle g(String str, String str2, Bundle bundle) throws RemoteException {
        return dl(str, str2, bundle);
    }

    private synchronized Bundle dl(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        RemoteCallbackList<p> remoteCallbackListRemove;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<p>> map = z;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = map.remove(str);
                } else {
                    remoteCallbackListRemove = map.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            p pVar = (p) remoteCallbackListRemove.getBroadcastItem(i);
                            if (pVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = pVar.z(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }
}
