package anet.channel.strategy;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public final int a;
        public final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f466f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f467g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f468h;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.b = jSONObject.optString("protocol");
            this.f463c = jSONObject.optInt("cto");
            this.f464d = jSONObject.optInt("rto");
            this.f465e = jSONObject.optInt("retry");
            this.f466f = jSONObject.optInt("heartbeat");
            this.f467g = jSONObject.optString("rtt", "");
            this.f468h = jSONObject.optString("publickey");
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class b {
        public final String a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String[] f473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a[] f474h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e[] f475i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f476j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f477k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f478l;

        public b(JSONObject jSONObject) {
            this.a = jSONObject.optString(Constants.KEY_HOST);
            this.b = jSONObject.optInt("ttl");
            this.f469c = jSONObject.optString("safeAisles");
            this.f470d = jSONObject.optString("cname", null);
            this.f471e = jSONObject.optString("unit", null);
            this.f476j = jSONObject.optInt("clear") == 1;
            this.f477k = jSONObject.optBoolean("effectNow");
            this.f478l = jSONObject.optInt("version");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f472f = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f472f[i2] = jSONArrayOptJSONArray.optString(i2);
                }
            } else {
                this.f472f = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sips");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                this.f473g = null;
            } else {
                int length2 = jSONArrayOptJSONArray2.length();
                this.f473g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f473g[i3] = jSONArrayOptJSONArray2.optString(i3);
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("aisles");
            if (jSONArrayOptJSONArray3 != null) {
                int length3 = jSONArrayOptJSONArray3.length();
                this.f474h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.f474h[i4] = new a(jSONArrayOptJSONArray3.optJSONObject(i4));
                }
            } else {
                this.f474h = null;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                this.f475i = null;
                return;
            }
            int length4 = jSONArrayOptJSONArray4.length();
            this.f475i = new e[length4];
            for (int i5 = 0; i5 < length4; i5++) {
                this.f475i[i5] = new e(jSONArrayOptJSONArray4.optJSONObject(i5));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class c {
        public final String a;
        public final e[] b;

        public c(JSONObject jSONObject) {
            this.a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray == null) {
                this.b = null;
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            this.b = new e[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.b[i2] = new e(jSONArrayOptJSONArray.optJSONObject(i2));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class d {
        public final String a;
        public final b[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c[] f479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f484h;

        public d(JSONObject jSONObject) {
            this.a = jSONObject.optString("ip");
            this.f480d = jSONObject.optString("uid", null);
            this.f481e = jSONObject.optString("utdid", null);
            this.f482f = jSONObject.optInt("cv");
            this.f483g = jSONObject.optInt("fcl");
            this.f484h = jSONObject.optInt("fct");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.b = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.b[i2] = new b(jSONArrayOptJSONArray.optJSONObject(i2));
                }
            } else {
                this.b = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (jSONArrayOptJSONArray2 == null) {
                this.f479c = null;
                return;
            }
            int length2 = jSONArrayOptJSONArray2.length();
            this.f479c = new c[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.f479c[i3] = new c(jSONArrayOptJSONArray2.optJSONObject(i3));
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class e {
        public final String a;
        public final a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f485c;

        public e(JSONObject jSONObject) {
            this.a = jSONObject.optString("ip");
            this.f485c = jSONObject.optString("path");
            this.b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e2) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
