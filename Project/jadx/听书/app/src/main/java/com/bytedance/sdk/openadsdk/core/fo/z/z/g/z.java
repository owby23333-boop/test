package com.bytedance.sdk.openadsdk.core.fo.z.z.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.ls.dl.g.fo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1054a;
    private na dl;
    private String e;
    private Context g;
    private Map<String, Object> gc;
    private int gz;
    private com.bytedance.sdk.openadsdk.core.video.g.g kb;
    private boolean m;
    private String uy;
    private boolean z = false;
    private boolean fo = false;

    public z(na naVar, Context context, String str, int i) {
        this.dl = naVar;
        this.g = context;
        this.e = str;
        this.gz = i;
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.kb = gVar;
    }

    public void z(boolean z) {
        this.z = z;
    }

    public void g(boolean z) {
        this.m = z;
    }

    public void dl(boolean z) {
        this.fo = z;
    }

    public Class<?> z() {
        boolean z = this.z;
        this.z = false;
        if (this.f1054a instanceof fo) {
            if (uy.m(this.dl)) {
                return TTNativePageActivity.class;
            }
            return TTWebPageActivity.class;
        }
        if (na.g(this.dl) && !z && !z(this.f1054a) && eo.gc(this.dl)) {
            if (uy.m(this.dl)) {
                return TTNativePageActivity.class;
            }
            na naVar = this.dl;
            if (naVar != null && naVar.e()) {
                return TTWebPageActivity.class;
            }
            return g(TTVideoWebPageActivity.class);
        }
        if (uy.m(this.dl)) {
            return TTNativePageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    private static boolean z(Object obj) {
        if (obj == null || !(obj instanceof z.InterfaceC0190z)) {
            return false;
        }
        try {
            return ((z.InterfaceC0190z) obj).h();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void g(Map<String, Object> map) {
        this.gc = map;
    }

    public boolean z(Class cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.dl.vk());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.dl.wm()));
            jSONObject.putOpt("req_id", this.dl.aq());
            jSONObject.putOpt("uchain", Boolean.TRUE);
            jSONObject.putOpt("uchain_old", Boolean.TRUE);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.dl.lt()));
        } catch (JSONException unused) {
        }
        v.z().z("landing_page", "native", 0, jSONObject);
        if (this.dl.lt() == 2) {
            return g(this.dl.fp());
        }
        if (this.kb != null && new g(this.kb).z(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.g, (Class<?>) cls);
        if (!(this.g instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.dl.dl());
        g();
        if (this.gc == null) {
            this.gc = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.gc.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.g.z(this.g, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.g.z.1
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
            }
        });
        return true;
    }

    private boolean g(String str) {
        if (!com.bytedance.sdk.component.utils.v.z(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.g instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.g.z(this.g, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void z(String str) {
        this.uy = str;
    }

    private void g() {
        if (this.fo && this.dl != null) {
            if (this.gc == null) {
                this.gc = new HashMap();
            }
            if (TextUtils.isEmpty(this.uy)) {
                this.uy = this.dl.fp();
            }
            this.gc.put("url", this.uy);
            this.gc.put("gecko_id", this.dl.pd());
            this.gc.put("web_title", this.dl.li());
            this.gc.put("sdk_version", Integer.valueOf(gk.dl));
            this.gc.put("adid", this.dl.mj());
            this.gc.put(MediationConstant.EXTRA_LOG_EXTRA, this.dl.vk());
            this.gc.put("icon_url", this.dl.kp() == null ? null : this.dl.kp().z());
            this.gc.put("event_tag", this.e);
            this.gc.put("source", Integer.valueOf(this.gz));
            this.gc.put("is_outer_click", Boolean.TRUE);
            eo.z(this.gc, this.dl);
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.g.z dl() {
        Object obj;
        if (!na.g(this.dl) || (obj = this.f1054a) == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVarX = obj instanceof z.InterfaceC0190z ? ((z.InterfaceC0190z) obj).x() : null;
        if (zVarX != null) {
            this.gc.put("multi_process_data", zVarX.z().toString());
        }
        Object obj2 = this.f1054a;
        if (!(obj2 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.g)) {
            return zVarX;
        }
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVarKb = ((com.bytedance.sdk.openadsdk.core.nativeexpress.g) obj2).kb();
        if (zVarKb != null) {
            this.gc.put("multi_process_data", zVarKb.z().toString());
        }
        return zVarKb;
    }

    private Class g(Class cls) {
        int i;
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVarDl = dl();
        if (zVarDl != null) {
            this.gc.put("video_is_auto_play", Boolean.valueOf(zVarDl.f1272a));
        }
        if (!TTVideoWebPageActivity.class.equals(cls)) {
            return cls;
        }
        if (zVarDl == null && !this.m) {
            return cls;
        }
        try {
            if (zVarDl != null) {
                i = (int) ((zVarDl.e / zVarDl.gc) * 100.0f);
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
                zVar.e = 100L;
                zVar.z = true;
                zVar.f1272a = eo.q(this.dl);
                this.gc.put("multi_process_data", zVar.z().toString());
                i = 100;
            }
            if (this.dl.vt() == 0) {
                return TTVideoScrollWebPageActivity.class;
            }
            return (this.dl.vt() <= 0 || i <= this.dl.vt()) ? cls : eo.q(this.dl) ? TTVideoScrollWebPageActivity.class : cls;
        } catch (Throwable unused) {
            return cls;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        if (this.dl == null) {
            return false;
        }
        return z((Class) z());
    }
}
