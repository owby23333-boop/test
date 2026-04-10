package com.bytedance.sdk.openadsdk.core.multipro.aidl.e;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class vn extends e {
    private static volatile vn bf;
    private static final Map<String, RemoteCallbackList<k>> e = Collections.synchronizedMap(new HashMap());

    public static vn bf() {
        if (bf == null) {
            synchronized (vn.class) {
                if (bf == null) {
                    bf = new vn();
                }
            }
        }
        return bf;
    }

    private synchronized Bundle d(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<k>> map = e;
            if (map != null) {
                RemoteCallbackList<k> remoteCallbackListRemove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            k kVar = (k) remoteCallbackListRemove.getBroadcastItem(i);
                            if (kVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = kVar.e(bundle.getInt("callback_extra_key_next_play_again_count"));
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

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public void e(String str, k kVar) throws RemoteException {
        RemoteCallbackList<k> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(kVar);
        e.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e, com.bytedance.sdk.openadsdk.core.f
    public Bundle bf(String str, String str2, Bundle bundle) throws RemoteException {
        return d(str, str2, bundle);
    }
}
