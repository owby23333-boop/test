package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<e> f1406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f1408i;

    class a implements Comparator<e> {
        a(g gVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            long jE = eVar.e() - eVar2.e();
            if (jE == 0) {
                return 0;
            }
            return jE > 0 ? 1 : -1;
        }
    }

    private static class b {
        public String a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1409c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.f1409c = str3;
        }
    }

    public g(String str, String str2, String str3, String str4, int i2, String str5) {
        super(str, str2, str3, str4, i2);
        this.f1407h = str5;
        this.f1408i = !TextUtils.isEmpty(str2) ? new b("freq", "span", "rule_id") : new b("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
    }

    public void a(String str, int i2) {
        for (e eVar : i()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(i2);
                return;
            }
        }
    }

    public void a(String str, long j2) {
        for (e eVar : i()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(j2);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000b A[Catch: all -> 0x00b7, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:8:0x000f, B:10:0x001a, B:12:0x0026, B:13:0x002a, B:16:0x0033, B:17:0x003b, B:19:0x0041, B:21:0x0054, B:23:0x005a, B:25:0x007b, B:26:0x0084, B:28:0x008c, B:29:0x0095, B:33:0x00a1, B:35:0x00a9, B:32:0x009e), top: B:44:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> i() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> r0 = r7.f1406g     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto Lf
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto Lf
        Lb:
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> r0 = r7.f1406g     // Catch: java.lang.Throwable -> Lb7
            goto Lb5
        Lf:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb7
            r0.<init>()     // Catch: java.lang.Throwable -> Lb7
            r7.f1406g = r0     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r0 = r7.f1407h     // Catch: java.lang.Throwable -> Lb7
            if (r0 != 0) goto L2a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = r7.a     // Catch: java.lang.Throwable -> Lb7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g r0 = r0.h(r1)     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto L2a
            java.lang.String r0 = r0.f1407h     // Catch: java.lang.Throwable -> Lb7
            r7.f1407h = r0     // Catch: java.lang.Throwable -> Lb7
        L2a:
            java.lang.String r0 = r7.f1407h     // Catch: java.lang.Throwable -> Lb7
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto L33
            goto Lb
        L33:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r1 = r7.f1407h     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r0.<init>(r1)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r1 = 0
        L3b:
            int r2 = r0.length()     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            if (r1 >= r2) goto La1
            org.json.JSONObject r2 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e r3 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.<init>()     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g$b r4 = r7.f1408i     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r4 = r4.f1409c     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r4 = r2.getString(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            if (r2 == 0) goto L9a
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            if (r5 != 0) goto L9a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g$b r5 = r7.f1408i     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r5 = r5.a     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            int r5 = r2.optInt(r5)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.b(r5)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g$b r5 = r7.f1408i     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r5 = r5.b     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            long r5 = r2.optLong(r5)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.b(r5)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.a(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            java.lang.String r4 = "count"
            boolean r4 = r2.has(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            if (r4 == 0) goto L84
            java.lang.String r4 = "count"
            int r4 = r2.optInt(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.a(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
        L84:
            java.lang.String r4 = "effective_time"
            boolean r4 = r2.has(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            if (r4 == 0) goto L95
            java.lang.String r4 = "effective_time"
            long r4 = r2.optLong(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r3.a(r4)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
        L95:
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> r2 = r7.f1406g     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
            r2.add(r3)     // Catch: org.json.JSONException -> L9d java.lang.Throwable -> Lb7
        L9a:
            int r1 = r1 + 1
            goto L3b
        L9d:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb7
        La1:
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> r0 = r7.f1406g     // Catch: java.lang.Throwable -> Lb7
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lb7
            if (r0 <= 0) goto Lb
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.e> r0 = r7.f1406g     // Catch: java.lang.Throwable -> Lb7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g$a r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g$a     // Catch: java.lang.Throwable -> Lb7
            r1.<init>(r7)     // Catch: java.lang.Throwable -> Lb7
            java.util.Collections.sort(r0, r1)     // Catch: java.lang.Throwable -> Lb7
            goto Lb
        Lb5:
            monitor-exit(r7)
            return r0
        Lb7:
            r0 = move-exception
            monitor-exit(r7)
            goto Lbb
        Lba:
            throw r0
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g.i():java.util.List");
    }

    public String j() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (e eVar : i()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.f1408i.a, eVar.c());
                jSONObject.put(this.f1408i.b, eVar.e());
                jSONObject.put(this.f1408i.f1409c, eVar.d());
                jSONObject.put("count", eVar.a());
                jSONObject.put("effective_time", eVar.b());
                jSONArray.put(jSONObject);
            }
            this.f1407h = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f1407h;
    }

    public String k() {
        try {
            JSONArray jSONArray = new JSONArray(this.f1407h);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", f.a(jSONObject.getLong(this.f1408i.b)));
            }
            this.f1407h = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f1407h;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.a + "', showRulesVersion='" + this.f1399c + "', timingMode=" + this.f1401e + "}IntervalFreqctlBean{freqctlRules=" + this.f1406g + ", freqctlRulesJson='" + this.f1407h + "'}";
    }
}
