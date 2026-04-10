package com.bytedance.sdk.openadsdk.core.zw;

import android.content.Context;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1434a = zw.getContext();
    private dl dl;
    private JSONObject g;
    private na gc;
    private com.bytedance.sdk.openadsdk.io.z.g.z.g z;

    public g(na naVar) {
        this.gc = naVar;
    }

    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        this.z = gVar;
    }

    public void z(dl dlVar) {
        this.dl = dlVar;
    }

    public na z() {
        return this.gc;
    }

    public Context getContext() {
        return this.f1434a;
    }

    public void z(na naVar) {
        if (this.z != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(sy.a(naVar)));
            } catch (JSONException e) {
                wp.z(e);
            }
            this.z.z(jSONObject);
        }
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        if (!sy.z()) {
            return jSONObject;
        }
        try {
            com.bytedance.sdk.openadsdk.io.z.g.z.g gVar = this.z;
            if (gVar != null) {
                JSONObject jSONObjectZ = gVar.z();
                this.g = jSONObjectZ;
                return jSONObjectZ;
            }
        } catch (Exception e) {
            wp.g("xeasy", e.getMessage());
        }
        return jSONObject;
    }

    public void z(boolean z, JSONObject jSONObject) {
        if (sy.z()) {
            wp.z("xeasy", "er:".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.io.z.g.z.g gVar = this.z;
            if (gVar != null) {
                if (z) {
                    gVar.g(jSONObject);
                    return;
                }
                HashMap map = new HashMap();
                map.put("success", 0);
                map.put("estimatedArea", this.g);
                map.put("realArea", this.dl.getMaxRectJson());
                map.put("exceedAreaRate", Double.valueOf(this.dl.getExceedAreaRate()));
                map.put("widgetArea", this.dl.getActualRectJson());
                uy.z(this.gc, false, sy.dl(this.gc), 2, (Map<String, Object>) map);
                this.z.dl(jSONObject);
            }
        }
    }

    public void dl() {
        if (sy.z()) {
            wp.z("xeasy", "oc");
            com.bytedance.sdk.openadsdk.io.z.g.z.g gVar = this.z;
            if (gVar != null) {
                gVar.g();
            }
        }
    }

    public static void z(na naVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            wp.z("xeasy", "e:" + e.getMessage());
        }
        uy.z(naVar, false, sy.dl(naVar), i, jSONObject);
    }
}
