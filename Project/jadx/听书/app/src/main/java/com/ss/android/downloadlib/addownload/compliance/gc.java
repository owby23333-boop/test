package com.ss.android.downloadlib.addownload.compliance;

import androidx.core.app.NotificationCompat;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.e.i;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1977a;
    private int dl;
    private String e;
    private int fo;
    private z g;
    private int gc = 15;
    private String gz;
    private String i;
    private long kb;
    private int m;
    private String pf;
    private String uy;
    private g v;
    private String wp;
    private boolean z;

    public void z(boolean z2) {
        this.z = z2;
    }

    public void z(z zVar) {
        this.g = zVar;
    }

    public void z(int i) {
        this.dl = i;
    }

    public void g(int i) {
        this.f1977a = i;
    }

    public void dl(int i) {
        this.gc = i;
    }

    public void a(int i) {
        this.m = i;
    }

    public void z(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.gz = str;
    }

    public int z() {
        return this.fo;
    }

    public void gc(int i) {
        this.fo = i;
    }

    public void dl(String str) {
        this.uy = str;
    }

    public void z(long j) {
        this.kb = j;
    }

    public void z(g gVar) {
        this.v = gVar;
    }

    public void a(String str) {
        this.pf = str;
    }

    public void gc(String str) {
        this.wp = str;
    }

    public String g() {
        return this.i;
    }

    public void m(String str) {
        this.i = str;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1978a;
        private long dl;
        private List<C0440z> e;
        private String fo;
        private String g;
        private String gc;
        private String gz;
        private String kb;
        private String m;
        private String uy;
        private String wp;
        private String z;

        public void z(String str) {
            this.z = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void z(long j) {
            this.dl = j;
        }

        public void g(long j) {
            this.f1978a = j;
        }

        public void dl(String str) {
            this.gc = str;
        }

        public void a(String str) {
            this.m = str;
        }

        public void gc(String str) {
            this.gz = str;
        }

        public void z(List<C0440z> list) {
            this.e = list;
        }

        public void m(String str) {
            this.fo = str;
        }

        public void e(String str) {
            this.uy = str;
        }

        public void gz(String str) {
            this.kb = str;
        }

        public void fo(String str) {
            this.wp = str;
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.compliance.gc$z$z, reason: collision with other inner class name */
        public static class C0440z {
            private String g;
            private String z;

            public void z(String str) {
                this.z = str;
            }

            public void g(String str) {
                this.g = str;
            }
        }
    }

    public static class g {
        private String g;
        private int z;

        public void z(int i) {
            this.z = i;
        }

        public void z(String str) {
            this.g = str;
        }
    }

    public String toString() {
        return z(this);
    }

    public static String z(gc gcVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(gcVar.z ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(gcVar.dl));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(gcVar.f1977a));
            jSONObject.putOpt("market_online_status", Integer.valueOf(gcVar.gc));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(gcVar.m));
            jSONObject.putOpt(an.o, gcVar.e);
            jSONObject.putOpt("hijack_url", gcVar.gz);
            jSONObject.putOpt("code", Integer.valueOf(gcVar.fo));
            jSONObject.putOpt("message", gcVar.uy);
            jSONObject.putOpt("request_duration", Long.valueOf(gcVar.kb));
            jSONObject.putOpt("auth_info", g(gcVar.g));
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, g(gcVar.v));
            jSONObject.putOpt("back_web_url", gcVar.pf);
            jSONObject.putOpt("hw_app_id", gcVar.wp);
            jSONObject.putOpt("deep_link", gcVar.i);
        } catch (JSONException e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static gc e(String str) {
        gc gcVar = new gc();
        try {
            JSONObject jSONObject = new JSONObject(str);
            z zVarZ = z(jSONObject);
            g gVarG = g(jSONObject);
            gcVar.z(zVarZ);
            gcVar.z(gVarG);
            gcVar.z(jSONObject.optInt("show_auth", 0) == 1);
            gcVar.z(jSONObject.optInt("download_permit"));
            gcVar.g(jSONObject.optInt("appstore_permit"));
            gcVar.dl(jSONObject.optInt("market_online_status", 15));
            gcVar.a(jSONObject.optInt("hijack_permit"));
            gcVar.z(jSONObject.optString(an.o));
            gcVar.g(jSONObject.optString("hijack_url"));
            gcVar.gc(jSONObject.optInt("code"));
            gcVar.dl(jSONObject.optString("message"));
            gcVar.z(jSONObject.optLong("request_duration", 0L));
            gcVar.a(jSONObject.optString("back_web_url"));
            gcVar.gc(jSONObject.optString("hw_app_id"));
            gcVar.m(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "ComplianceResult fromJson");
        }
        return gcVar;
    }

    private static z z(JSONObject jSONObject) {
        z zVar = new z();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                zVar.z(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
                zVar.g(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                zVar.z(i.z(jSONObjectOptJSONObject, "update_time"));
                zVar.g(i.z(jSONObjectOptJSONObject, "size"));
                zVar.dl(jSONObjectOptJSONObject.optString("developer_name"));
                zVar.a(jSONObjectOptJSONObject.optString(an.o));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    z(jSONArrayOptJSONArray, arrayList);
                    zVar.z(arrayList);
                }
                zVar.gc(jSONObjectOptJSONObject.optString("permission_classify_url"));
                zVar.m(jSONObjectOptJSONObject.optString("policy_url"));
                zVar.e(jSONObjectOptJSONObject.optString("icon_url"));
                zVar.gz(jSONObjectOptJSONObject.optString("download_url"));
                zVar.fo(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "ComplianceResult getAuthInfo");
        }
        return zVar;
    }

    private static JSONObject g(z zVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (zVar != null) {
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, zVar.z);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, zVar.g);
            jSONObject.putOpt("update_time", Long.valueOf(zVar.dl));
            jSONObject.putOpt("size", Long.valueOf(zVar.f1978a));
            jSONObject.putOpt("developer_name", zVar.gc);
            jSONObject.putOpt("policy_url", zVar.fo);
            jSONObject.putOpt("icon_url", zVar.uy);
            jSONObject.putOpt("download_url", zVar.kb);
            jSONObject.putOpt("permissions", dl(zVar));
            jSONObject.putOpt("permission_classify_url", zVar.gz);
            jSONObject.putOpt("desc_url", zVar.wp);
        }
        return jSONObject;
    }

    private static g g(JSONObject jSONObject) {
        g gVar = new g();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS);
            if (jSONObjectOptJSONObject != null) {
                gVar.z(jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                gVar.z(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "ComplianceResult getStatus");
        }
        return gVar;
    }

    private static JSONObject g(g gVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (gVar != null) {
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(gVar.z));
            jSONObject.putOpt("message", gVar.g);
        }
        return jSONObject;
    }

    private static void z(JSONArray jSONArray, List<z.C0440z> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                z.C0440z c0440z = new z.C0440z();
                c0440z.z(jSONObjectOptJSONObject.optString("permission_name"));
                c0440z.g(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0440z);
            }
        }
    }

    private static JSONArray dl(z zVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<z.C0440z> list = zVar.e;
        if (list != null && list.size() > 0) {
            for (z.C0440z c0440z : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0440z.z);
                jSONObject.putOpt("permission_desc", c0440z.g);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
