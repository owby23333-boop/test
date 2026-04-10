package l.c.a.a;

import android.text.TextUtils;
import com.tramini.plugin.a.g.c;
import com.tramini.plugin.a.g.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private String a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f21042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f21043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f21044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f21045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f21046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f21048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f21049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f21050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f21051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Set<d> f21053n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f21054o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f21055p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f21056q;

    /* JADX INFO: renamed from: l.c.a.a.a$a, reason: collision with other inner class name */
    static class C0576a {
        private static String a = "si";
        private static String b = "scto";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static String f21057c = "tf";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static String f21058d = "nl";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static String f21059e = "t_sw";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static String f21060f = "pil";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static String f21061g = "att_sw";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static String f21062h = "plst_addr";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static String f21063i = "pltk_addr";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static String f21064j = "cn_plst_addr";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static String f21065k = "cn_pltk_addr";
    }

    public final int a() {
        return this.f21054o;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final List<String> d() {
        return this.f21042c;
    }

    public final ConcurrentHashMap<String, c> e() {
        return this.f21043d;
    }

    public final String f() {
        return this.f21044e;
    }

    public final String g() {
        return this.f21045f;
    }

    public final String h() {
        return this.f21046g;
    }

    public final String i() {
        return this.f21047h;
    }

    public final String j() {
        return this.f21048i;
    }

    public final String k() {
        return this.f21049j;
    }

    public final String l() {
        return this.f21050k;
    }

    public final String m() {
        return this.f21051l;
    }

    public final int n() {
        return this.f21052m;
    }

    public final Set<d> o() {
        return this.f21053n;
    }

    public final String p() {
        return this.f21055p;
    }

    public final String q() {
        return this.f21056q;
    }

    public static a a(String str) {
        JSONArray jSONArray;
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull(C0576a.a)) {
                aVar.a = "";
            } else {
                aVar.a = jSONObject.optString(C0576a.a);
            }
            if (jSONObject.isNull(C0576a.b)) {
                aVar.b = 3600000L;
            } else {
                aVar.b = jSONObject.optInt(C0576a.b);
            }
            if (jSONObject.isNull(C0576a.f21061g)) {
                aVar.f21054o = 0;
            } else {
                aVar.f21054o = jSONObject.optInt(C0576a.f21061g);
            }
            if (!jSONObject.isNull(C0576a.f21062h)) {
                aVar.f21055p = jSONObject.optString(C0576a.f21062h);
            }
            if (!jSONObject.isNull(C0576a.f21063i)) {
                aVar.f21056q = jSONObject.optString(C0576a.f21063i);
            }
            if (!jSONObject.isNull(C0576a.f21064j)) {
                jSONObject.optString(C0576a.f21064j);
            }
            if (!jSONObject.isNull(C0576a.f21065k)) {
                jSONObject.optString(C0576a.f21065k);
            }
            if (!jSONObject.isNull(C0576a.f21057c)) {
                ConcurrentHashMap<String, c> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(C0576a.f21057c));
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        try {
                            String next = itKeys.next();
                            c cVar = new c();
                            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                            cVar.f19338d = jSONObjectOptJSONObject.optString("pml");
                            cVar.a = jSONObjectOptJSONObject.optString("uu");
                            cVar.b = jSONObjectOptJSONObject.optInt("dmin");
                            cVar.f19337c = jSONObjectOptJSONObject.optInt("dmax");
                            if (jSONObjectOptJSONObject.has("p_s") && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("p_s"))) {
                                cVar.f19339e = new JSONArray(jSONObjectOptJSONObject.optString("p_s"));
                            }
                            concurrentHashMap.put(next, cVar);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                aVar.f21043d = concurrentHashMap;
            }
            if (!jSONObject.isNull(C0576a.f21058d)) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString(C0576a.f21058d));
                aVar.f21044e = jSONObject3.optString("p1");
                aVar.f21045f = jSONObject3.optString(com.anythink.core.common.g.c.X);
                aVar.f21046g = jSONObject3.optString("p3");
                aVar.f21047h = jSONObject3.optString("p4");
                aVar.f21048i = jSONObject3.optString("p5");
                aVar.f21049j = jSONObject3.optString("p6");
                aVar.f21050k = jSONObject3.optString("p7");
                aVar.f21051l = jSONObject3.optString("p8");
                if (!jSONObject3.isNull("notifications") && (length = (jSONArray = new JSONArray(jSONObject3.optString("notifications"))).length()) > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                    aVar.f21042c = arrayList;
                }
            }
            if (jSONObject.isNull(C0576a.f21059e)) {
                aVar.f21052m = 0;
            } else {
                aVar.f21052m = jSONObject.optInt(C0576a.f21059e);
            }
            if (!jSONObject.isNull(C0576a.f21060f)) {
                JSONObject jSONObject4 = new JSONObject(jSONObject.optString(C0576a.f21060f));
                Iterator<String> itKeys2 = jSONObject4.keys();
                HashSet hashSet = new HashSet();
                while (itKeys2.hasNext()) {
                    d dVar = new d();
                    dVar.f19340s = itKeys2.next();
                    dVar.f19341t = jSONObject4.optString(dVar.f19340s);
                    hashSet.add(dVar);
                }
                aVar.f21053n = hashSet;
            }
            return aVar;
        } catch (JSONException unused3) {
            return null;
        }
    }
}
