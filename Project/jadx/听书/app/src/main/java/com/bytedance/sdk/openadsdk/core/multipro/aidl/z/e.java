package com.bytedance.sdk.openadsdk.core.multipro.aidl.z;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.fv;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e extends z {
    private static volatile e g;
    private static Map<String, RemoteCallbackList<fv>> z = Collections.synchronizedMap(new HashMap());

    public static e g() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public synchronized void z(String str, fv fvVar) throws RemoteException {
        RemoteCallbackList<fv> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(fvVar);
        z.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z, com.bytedance.sdk.openadsdk.core.ls
    public void z(String str, String str2, Bundle bundle) throws RemoteException {
        dl(str, str2, bundle);
    }

    private synchronized void dl(String str, String str2, Bundle bundle) {
        RemoteCallbackList<fv> remoteCallbackListRemove;
        RemoteCallbackList<fv> remoteCallbackListRemove2;
        try {
            if (z != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = z.remove(str);
                    remoteCallbackListRemove2 = z.remove(gp.z(str));
                } else {
                    remoteCallbackListRemove = z.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            fv fvVar = (fv) remoteCallbackListRemove.getBroadcastItem(i);
                            if (fvVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    fvVar.g();
                                } else if ("onAdClose".equals(str2)) {
                                    fvVar.a();
                                } else if ("onVideoComplete".equals(str2)) {
                                    fvVar.gc();
                                } else if ("onVideoError".equals(str2)) {
                                    fvVar.m();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    fvVar.dl();
                                } else if ("onRewardVerify".equals(str2)) {
                                    z(fvVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    g(fvVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    fvVar.e();
                                } else if ("recycleRes".equals(str2)) {
                                    fvVar.z();
                                }
                            }
                        } catch (Throwable th) {
                            wp.dl("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
                if (remoteCallbackListRemove2 != null) {
                    int iBeginBroadcast2 = remoteCallbackListRemove2.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast2; i2++) {
                        try {
                            fv fvVar2 = (fv) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (fvVar2 != null && "recycleRes".equals(str2)) {
                                fvVar2.z();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            wp.dl("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    private void z(fv fvVar, Bundle bundle) throws RemoteException {
        boolean z2 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        fvVar.z(z2, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void g(fv fvVar, Bundle bundle) throws RemoteException {
        boolean z2 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        fvVar.z(z2, i, eo.z(i, bundle));
    }
}
