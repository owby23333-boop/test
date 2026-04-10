package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import android.text.TextUtils;
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
public class gc implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "registration_popup_listener")
    private m.z f1047a;

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
        TTDelegateActivity.z(this.z, this.dl, this.gc, this.g);
        zVar.z(map2);
        return true;
    }

    private m.z z() {
        return new m.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                if (gc.this.f1047a == null) {
                    return;
                }
                gc.this.f1047a.onDialogBtnYes();
                gc gcVar = gc.this;
                gcVar.z(gcVar.m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (gc.this.f1047a == null) {
                    return;
                }
                gc.this.f1047a.onDialogBtnNo();
                gc gcVar = gc.this;
                gcVar.z(gcVar.e);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (gc.this.f1047a == null) {
                    return;
                }
                gc.this.f1047a.onDialogCancel();
                gc gcVar = gc.this;
                gcVar.z(gcVar.gz);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("material_meta", this.g);
        map.put(d.R, this.z);
        new g.z(str).z(this.g.kv()).z(map).z().z();
    }
}
