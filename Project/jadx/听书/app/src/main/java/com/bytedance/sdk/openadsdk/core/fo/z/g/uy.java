package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g(z = "SINGLETON")
public class uy implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "interaction_type")
    private int f1052a;

    @com.bytedance.sdk.component.kb.g.z(z = "url")
    private String dl;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_landing_page")
    private boolean e;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "activity_type")
    private int gc;

    @com.bytedance.sdk.component.kb.g.z(z = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.g.g gz;

    @com.bytedance.sdk.component.kb.g.z(z = "is_open_web_page")
    private boolean m;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.kb.z.z zVar) {
        if (this.m) {
            return true;
        }
        if (this.e) {
            zVar.g(map2);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.z.vk());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.z.wm()));
            jSONObject.putOpt("req_id", this.z.aq());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z("landing_page", "native", 0, jSONObject);
        if (this.f1052a == 2) {
            boolean z = z();
            if (z) {
                zVar.z(map2);
            } else {
                zVar.g(map2);
            }
            return z;
        }
        if (this.gz != null && new com.bytedance.sdk.openadsdk.core.fo.z.z.g.g(this.gz).z(new HashMap())) {
            zVar.z(map2);
            return true;
        }
        Intent intent = new Intent(this.g, (Class<?>) eo.m(this.gc));
        if (!(this.g instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        na naVar = this.z;
        if (naVar != null) {
            intent.putExtra("get_phone_num_status", naVar.dl());
        }
        if (map == null) {
            com.bytedance.sdk.component.utils.wp.a("UChain_LP", "param == null");
            zVar.g(map2);
        }
        map.putAll(map2);
        map.remove(d.R);
        map.remove("activity_type");
        Object objRemove = map.remove("source");
        eo.z(map, this.z);
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra("source", i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.g.z(this.g, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.uy.1
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
                zVar.z(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
                zVar.g(map2);
            }
        });
        return true;
    }

    private boolean z() {
        if (!com.bytedance.sdk.component.utils.v.z(this.dl)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.dl));
            if (!(this.g instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.g.z(this.g, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
