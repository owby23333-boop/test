package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.component.kb.z.g;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class g implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "function_desc_popup_listener")
    private m.z f1046a;

    @com.bytedance.sdk.component.kb.g.z(z = MediationConstant.EXTRA_ADID)
    private String dl;

    @com.bytedance.sdk.component.kb.g.z(z = "deny_event")
    private String e;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na g;

    @com.bytedance.sdk.component.kb.g.z(z = "app_manage_model")
    private String gc;

    @com.bytedance.sdk.component.kb.g.z(z = "cancel_event")
    private String gz;

    @com.bytedance.sdk.component.kb.g.z(z = "confirm_event")
    private String m;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        com.bytedance.sdk.openadsdk.core.un.m.z(this.dl, z());
        TTDelegateActivity.dl(this.z, this.dl, this.gc);
        zVar.z(map2);
        return true;
    }

    private m.z z() {
        return new m.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.g.1
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                if (g.this.f1046a == null) {
                    return;
                }
                g.this.f1046a.onDialogBtnYes();
                g gVar = g.this;
                gVar.z(gVar.m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (g.this.f1046a == null) {
                    return;
                }
                g.this.f1046a.onDialogBtnNo();
                g gVar = g.this;
                gVar.z(gVar.e);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (g.this.f1046a == null) {
                    return;
                }
                g.this.f1046a.onDialogCancel();
                g gVar = g.this;
                gVar.z(gVar.gz);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        HashMap map = new HashMap();
        map.put("material_meta", this.g);
        map.put(d.R, this.z);
        new g.z(str).z(this.g.kv()).z(map).z().z();
    }
}
