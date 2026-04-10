package com.bytedance.sdk.openadsdk.core.component.reward.z.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.g.dl;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.un.x;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final dl z = x.z("full_reward_adslot");

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g z(String str) {
        try {
            return l.z(z.get(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void z(String str, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (gVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                z.put(str, l.z(gVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
