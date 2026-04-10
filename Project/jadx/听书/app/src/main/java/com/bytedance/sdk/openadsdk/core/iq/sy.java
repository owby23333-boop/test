package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1195a;
    private g dl;
    private z g;
    private boolean z;

    public sy(JSONObject jSONObject) {
        this.z = false;
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.g = new z(jSONObjectOptJSONObject.optJSONObject("components"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject2 != null) {
            this.dl = new g(jSONObjectOptJSONObject2.optJSONObject("components"));
        }
        this.f1195a = jSONObject.optInt("style_category");
    }

    public static boolean z(na naVar) {
        sy syVarKq;
        z zVar;
        return (naVar == null || (syVarKq = naVar.kq()) == null || (zVar = syVarKq.g) == null || !zVar.e()) ? false : true;
    }

    public static boolean g(na naVar) {
        sy syVarKq;
        g gVar;
        return (naVar == null || (syVarKq = naVar.kq()) == null || !syVarKq.z || (gVar = syVarKq.dl) == null || !gVar.z()) ? false : true;
    }

    public static String dl(na naVar) {
        sy syVarKq;
        z zVar;
        if (naVar == null || (syVarKq = naVar.kq()) == null || (zVar = syVarKq.g) == null) {
            return null;
        }
        return zVar.g();
    }

    public static int a(na naVar) {
        if (naVar == null) {
            return 0;
        }
        return naVar.kq().f1195a;
    }

    public static boolean z() {
        return (com.bytedance.sdk.openadsdk.core.gk.dl >= 6322 && com.bytedance.sdk.openadsdk.core.gk.dl < 6400) || com.bytedance.sdk.openadsdk.core.gk.dl >= 6406;
    }

    public static g gc(na naVar) {
        sy syVarKq;
        if (naVar == null || (syVarKq = naVar.kq()) == null) {
            return null;
        }
        return syVarKq.dl;
    }

    public static z m(na naVar) {
        sy syVarKq;
        if (naVar == null || (syVarKq = naVar.kq()) == null) {
            return null;
        }
        return syVarKq.g;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1196a;
        private String dl;
        private int e;
        private String fo;
        private int g;
        private int gc;
        private int gz;
        private int m;
        private int z;

        public z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.g = jSONObject.optInt("displayAreaAndroid");
            this.dl = jSONObject.optString("ugen_md5");
            this.f1196a = jSONObject.optString("ugen_url");
            this.gc = jSONObject.optInt("need_backup_convert_area", 0);
            this.m = jSONObject.optInt("min_height", 0);
            this.e = jSONObject.optInt("min_width", 0);
            this.gz = jSONObject.optInt("min_ratio", 0);
            this.fo = jSONObject.optString("ugen_id");
            this.z = jSONObject.optInt("render_sequence", 2);
        }

        public int z() {
            return this.z;
        }

        public String g() {
            return this.fo;
        }

        public int dl() {
            return this.g;
        }

        public String a() {
            return this.dl;
        }

        public String gc() {
            return this.f1196a;
        }

        public boolean m() {
            return this.gc == 1;
        }

        public boolean e() {
            return !TextUtils.isEmpty(this.f1196a);
        }

        public boolean z(int i, int i2) {
            int iA = com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), i);
            int iA2 = com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), i2);
            int i3 = this.e;
            if (i3 != 0 && iA < i3) {
                return false;
            }
            int i4 = this.m;
            if (i4 == 0 || iA2 >= i4) {
                return iA == 0 || iA2 == 0 || ((float) iA2) / ((float) iA) >= ((float) this.gz);
            }
            return false;
        }
    }

    public static class g {
        z g;
        z z;

        public g(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.z = new z(jSONObject.optJSONObject("vertical"));
            this.g = new z(jSONObject.optJSONObject("horizontal"));
        }

        public boolean z() {
            z zVar = this.g;
            if (zVar != null && zVar.z()) {
                return true;
            }
            z zVar2 = this.z;
            return zVar2 != null && zVar2.z();
        }

        public String z(boolean z2) {
            z zVar;
            if (z2 && (zVar = this.z) != null && zVar.z()) {
                return this.z.z;
            }
            z zVar2 = this.g;
            if (zVar2 != null && zVar2.z()) {
                return this.g.z;
            }
            z zVar3 = this.z;
            return (zVar3 == null || !zVar3.z()) ? "" : this.z.z;
        }

        public int g() {
            z zVar = this.z;
            if (zVar != null) {
                return zVar.g;
            }
            z zVar2 = this.g;
            if (zVar2 != null) {
                return zVar2.g;
            }
            return 0;
        }

        public static class z {
            int g;
            String z;

            public z(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.z = jSONObject.optString("entry");
                this.g = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean z() {
                return !TextUtils.isEmpty(this.z);
            }
        }
    }
}
