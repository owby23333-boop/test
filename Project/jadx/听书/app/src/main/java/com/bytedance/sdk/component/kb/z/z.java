package com.bytedance.sdk.component.kb.z;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.kb.a.a;
import com.bytedance.sdk.component.kb.a.gc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f758a;
    private com.bytedance.sdk.component.kb.dl.z dl;
    private a e;
    private Map<String, Object> fo;
    private Map<String, Object> g;
    private String gc;
    private String gz;
    private com.bytedance.sdk.component.kb.a.g kb;
    private a m;
    private int uy = 1;
    private JSONObject z;

    public z(com.bytedance.sdk.component.kb.dl.z zVar, JSONObject jSONObject, Map<String, Object> map) {
        this.dl = zVar;
        this.z = jSONObject;
        this.g = map;
    }

    public z(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.z = jSONObject;
        this.g = map;
    }

    public Map<String, Object> z() {
        return this.g;
    }

    public Map<String, Object> g() {
        return this.fo;
    }

    public JSONObject dl() {
        return this.z;
    }

    public void z(String str) {
        this.gc = str;
    }

    public String a() {
        return this.gc;
    }

    public a gc() {
        return this.m;
    }

    public void z(a aVar) {
        if (aVar instanceof g) {
            this.m = aVar;
        } else {
            this.e = aVar;
        }
    }

    private void gz() {
        if (this.uy != 2) {
            com.bytedance.sdk.component.kb.dl.z zVar = this.dl;
            if (zVar == null) {
                return;
            } else {
                this.gz = zVar.g();
            }
        }
        if (!TextUtils.isEmpty(this.gz)) {
            this.f758a = Uri.parse(this.gz).getHost();
        }
        if (!TextUtils.isEmpty(this.f758a)) {
            String str = this.f758a.split("/")[0];
            this.f758a = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.f758a.length();
            }
            this.f758a = this.f758a.substring(0, iIndexOf);
        }
        g(this.gz);
    }

    private void g(String str) {
        JSONObject jSONObjectZ = com.bytedance.sdk.component.kb.gz.g.z(str);
        if (jSONObjectZ == null) {
            return;
        }
        Iterator<String> itKeys = jSONObjectZ.keys();
        this.fo = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectZ.opt(next);
                if (objOpt instanceof String) {
                    objOpt = z((String) objOpt, this.z);
                }
                this.fo.put(next, objOpt);
            }
        }
    }

    private static Object z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.bytedance.adsdk.g.g.z.z(str.substring(2, str.length() - 1)).z(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void z(com.bytedance.sdk.component.kb.a.g gVar) {
        this.kb = gVar;
    }

    public void m() {
        gz();
        com.bytedance.sdk.component.kb.a.g gVar = this.kb;
        if (gVar != null) {
            gVar.z();
        } else {
            com.bytedance.sdk.component.kb.e.z.z().z(this.f758a, this, new com.bytedance.sdk.component.kb.a.z() { // from class: com.bytedance.sdk.component.kb.z.z.1
            });
        }
    }

    public void z(Map<String, Object> map) {
        gc gcVarG;
        gc gcVarG2;
        a aVar = this.m;
        if (aVar != null && (gcVarG2 = aVar.g()) != null) {
            gcVarG2.z(this, map);
        }
        a aVar2 = this.e;
        if (aVar2 == null || (gcVarG = aVar2.g()) == null) {
            return;
        }
        gcVarG.z(this, map);
    }

    public void g(Map<String, Object> map) {
        gc gcVarG;
        gc gcVarG2;
        a aVar = this.m;
        if (aVar != null && (gcVarG2 = aVar.g()) != null) {
            gcVarG2.g(this, this.g);
        }
        a aVar2 = this.e;
        if (aVar2 == null || (gcVarG = aVar2.g()) == null) {
            return;
        }
        gcVarG.g(this, map);
    }

    public com.bytedance.sdk.component.kb.dl.z e() {
        return this.dl;
    }
}
