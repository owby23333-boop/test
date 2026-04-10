package com.bytedance.sdk.openadsdk.core.l.z;

import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    /* JADX INFO: Access modifiers changed from: private */
    public iq z() {
        iq iqVar = new iq(zw.getContext(), 1, uy.ls().gc());
        boolean z = iqVar.z(0);
        z(z ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            iqVar.g(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void z(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.l.z.z().g() > z(i)) {
            e.z(new fo("reg_sensor") { // from class: com.bytedance.sdk.openadsdk.core.l.z.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.z();
                }
            });
        }
    }
}
