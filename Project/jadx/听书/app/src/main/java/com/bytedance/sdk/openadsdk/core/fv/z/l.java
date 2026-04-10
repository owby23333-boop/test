package com.bytedance.sdk.openadsdk.core.fv.z;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1066a;
    private com.bytedance.sdk.openadsdk.core.js.gc dl;
    private na g;
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, final com.bytedance.sdk.openadsdk.core.mc mcVar, final na naVar) {
        pVar.z("requestVideoDelayCallback", new a.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.l.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new l(mcVar, naVar);
            }
        });
    }

    public l(com.bytedance.sdk.openadsdk.core.mc mcVar, na naVar) {
        this.z = new WeakReference<>(mcVar);
        this.g = naVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar = this.z.get();
        if (mcVar == null || jSONObject == null) {
            dl();
            return;
        }
        this.dl = new com.bytedance.sdk.openadsdk.core.js.gc() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.l.2
            @Override // com.bytedance.sdk.openadsdk.core.js.gc
            public void z() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.l.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            l.this.z(new JSONObject());
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.wp.a("requestVideoDelay", e.getMessage());
                        }
                    }
                }, l.this.f1066a);
            }
        };
        int iOptInt = jSONObject.optInt("delay", -1);
        if (iOptInt < 0) {
            return;
        }
        this.f1066a = iOptInt;
        if (mcVar.dl() != null && mcVar.dl().E_()) {
            this.dl.z();
        } else {
            mcVar.z(this.dl);
        }
    }
}
