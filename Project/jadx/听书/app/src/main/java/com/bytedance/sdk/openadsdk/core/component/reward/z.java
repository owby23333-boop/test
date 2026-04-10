package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.uy.uy;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.g.a;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.g.gc;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.e;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    protected static HashMap<Integer, ls> z = new HashMap<>();
    private static final ExecutorService g = com.bytedance.sdk.component.uy.dl.z(new uy("RewardFullCallback"));

    public static void z(final int i, final String str, final String str2, final Bundle bundle) {
        g.execute(new fo("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.1
            @Override // java.lang.Runnable
            public void run() {
                ls lsVarZ = z.z.get(Integer.valueOf(i));
                if (lsVarZ == null) {
                    lsVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(i));
                    z.z.put(Integer.valueOf(i), lsVarZ);
                }
                if (lsVarZ == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        lsVarZ.z(str, str2, bundle);
                    } else if (i2 == 1) {
                        lsVarZ.z(str, str2);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        lsVarZ.g(str, str2, bundle);
                    }
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }
        });
    }

    public static void z(final String str, final com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        g.execute(new fo("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.z zVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext());
                if (zVar != null) {
                    gc gcVar = new gc(zVar);
                    ls lsVarZ = e.z(zVarZ.z(0));
                    if (lsVarZ != null) {
                        try {
                            lsVarZ.z(str, gcVar);
                        } catch (RemoteException e) {
                            wp.z(e);
                        }
                    }
                }
            }
        });
    }

    public static void z(final String str, final com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar) {
        g.execute(new fo("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.z zVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext());
                if (gVar != null) {
                    a aVar = new a(gVar);
                    ls lsVarZ = e.z(zVarZ.z(5));
                    if (lsVarZ != null) {
                        try {
                            lsVarZ.z(str, aVar);
                        } catch (RemoteException e) {
                            wp.z(e);
                        }
                    }
                }
            }
        });
    }

    public static void z(final String str, final com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar) {
        g.execute(new fo("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.z zVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext());
                if (zVar != null) {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl dlVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.g.dl(zVar);
                    ls lsVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.gc.z(zVarZ.z(1));
                    if (lsVarZ != null) {
                        try {
                            lsVarZ.z(str, dlVar);
                        } catch (RemoteException e) {
                            wp.z(e);
                        }
                    }
                }
            }
        });
    }
}
