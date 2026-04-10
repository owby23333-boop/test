package com.bytedance.adsdk.ugeno.dl;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f220a;
    private String dl;
    private boolean e;
    private float fo;
    private JSONObject g;
    private String gc;
    private float gz;
    private JSONObject m;
    private JSONObject z;

    public fo(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public fo(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.z = jSONObject.optJSONObject(TtmlNode.TAG_BODY);
            } else {
                this.z = jSONObject.optJSONObject("main_template");
            }
            this.g = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has("meta")) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has(TtmlNode.TAG_BODY)) {
                    this.e = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.dl = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.dl = "3.0";
                    }
                } else {
                    this.dl = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.gc = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.dl = "3.0";
                this.e = true;
            }
            this.f220a = jSONObject2;
            this.m = jSONObject3;
        }
    }

    public z z() {
        return gc();
    }

    public void z(float f, float f2) {
        this.gz = f;
        this.fo = f2;
    }

    private z gc() {
        if (!a()) {
            return z(this.z, (z) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put(MediaFormat.KEY_WIDTH, "match_parent");
            jSONObject.put(MediaFormat.KEY_HEIGHT, "wrap_content");
            float f = this.gz;
            if (f > 0.0f) {
                jSONObject.put(MediaFormat.KEY_WIDTH, f);
            }
            float f2 = this.fo;
            if (f2 > 0.0f) {
                jSONObject.put(MediaFormat.KEY_HEIGHT, f2);
            }
            String strOptString = this.f220a.optString("xSize");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (jSONObject2.optInt(MediaFormat.KEY_WIDTH) > 0) {
                    jSONObject.put(MediaFormat.KEY_WIDTH, jSONObject2.optInt(MediaFormat.KEY_WIDTH));
                }
                if (jSONObject2.optInt(MediaFormat.KEY_HEIGHT) > 0) {
                    jSONObject.put(MediaFormat.KEY_HEIGHT, jSONObject2.optInt(MediaFormat.KEY_HEIGHT));
                }
            }
        } catch (JSONException unused) {
        }
        z zVar = new z();
        zVar.g = "View";
        zVar.z = "virtualNode";
        zVar.dl = jSONObject;
        zVar.m = null;
        zVar.e = this.dl;
        zVar.gz = this.gc;
        zVar.z(z(this.z, zVar));
        return zVar;
    }

    public String g() {
        return this.dl;
    }

    public List<z> dl() {
        if (this.g == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.g.keys();
        while (itKeys.hasNext()) {
            z zVarZ = z(this.g.optJSONObject(itKeys.next()), (z) null);
            if (zVarZ != null) {
                arrayList.add(zVarZ);
            }
        }
        return arrayList;
    }

    private z z(JSONObject jSONObject, z zVar) {
        String strOptString;
        String strOptString2;
        z zVarZ;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
        z zVar2 = new z();
        zVar2.z = strOptString3;
        if (!this.e || !TextUtils.equals("Video", strOptString)) {
            zVar2.g = strOptString;
        } else {
            zVar2.g = strOptString + "V3";
        }
        zVar2.dl = jSONObject2;
        zVar2.m = zVar;
        zVar2.e = this.dl;
        zVar2.gz = this.gc;
        if (jSONObject2.has("i18n")) {
            zVar2.f221a = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            z(jSONObject, zVar2.dl);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectOptJSONObject.optString("id"), this.f220a);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.g;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strZ);
                        zVarZ = z(jSONObjectOptJSONObject, zVar2);
                    } else {
                        zVarZ = null;
                    }
                } else {
                    zVarZ = z(jSONObjectOptJSONObject, zVar2);
                }
                if (zVarZ != null) {
                    zVarZ.g(g(zVarZ));
                    zVarZ.z(z(zVarZ));
                }
                if (dl(zVarZ)) {
                    i++;
                    zVar2.g(zVarZ);
                } else if (zVarZ != null) {
                    zVar2.z(i2 - i, zVarZ);
                }
            }
        }
        return zVar2;
    }

    public boolean z(z zVar) {
        JSONObject jSONObjectA;
        if (zVar == null || (jSONObjectA = zVar.a()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectA.optString(MediaFormat.KEY_WIDTH), "match_parent");
    }

    public boolean g(z zVar) {
        JSONObject jSONObjectA;
        if (zVar == null || (jSONObjectA = zVar.a()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectA.optString(MediaFormat.KEY_HEIGHT), "match_parent");
    }

    public boolean dl(z zVar) {
        JSONObject jSONObjectA;
        if (zVar == null || (jSONObjectA = zVar.a()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectA.optString("position"), "absolute");
    }

    public boolean a() {
        return this.e;
    }

    private void z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.m == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.m.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, d.ar) && jSONObject3.has(d.ar)) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.m.g.z(jSONObject3.optJSONArray(d.ar), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static boolean a(z zVar) {
        return (zVar == null || zVar.dl == null) ? false : true;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f221a;
        private JSONObject dl;
        private String e;
        private boolean fo;
        private String g;
        private LinkedList<z> gc;
        private String gz;
        private z m;
        private boolean uy;
        private String z;

        public String z() {
            return this.z;
        }

        public String g() {
            return this.e;
        }

        public String dl() {
            return this.g;
        }

        public void z(String str) {
            this.g = str;
        }

        public void z(boolean z) {
            this.fo = z;
        }

        public void g(boolean z) {
            this.uy = z;
        }

        public JSONObject a() {
            return this.dl;
        }

        public List<z> gc() {
            return this.gc;
        }

        public void z(z zVar) {
            if (this.gc == null) {
                this.gc = new LinkedList<>();
            }
            this.gc.add(zVar);
        }

        public void g(z zVar) {
            if (this.gc == null) {
                this.gc = new LinkedList<>();
            }
            this.gc.addLast(zVar);
        }

        public void z(int i, z zVar) {
            if (this.gc == null) {
                this.gc = new LinkedList<>();
            }
            this.gc.add(i, zVar);
        }

        public JSONObject m() {
            return this.f221a;
        }

        public String toString() {
            return "UGNode{id='" + this.z + "', name='" + this.g + "'}";
        }
    }
}
