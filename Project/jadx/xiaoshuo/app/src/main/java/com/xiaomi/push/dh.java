package com.xiaomi.push;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class dh implements Comparable<dh> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f7879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedList<cx> f236a;

    public dh() {
        this(null, 0);
    }

    public synchronized void a(cx cxVar) {
        if (cxVar != null) {
            this.f236a.add(cxVar);
            int iA = cxVar.a();
            if (iA > 0) {
                this.f7879a += cxVar.a();
            } else {
                int i = 0;
                for (int size = this.f236a.size() - 1; size >= 0 && this.f236a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f7879a += iA * i;
            }
            if (this.f236a.size() > 30) {
                this.f7879a -= this.f236a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f235a + ":" + this.f7879a;
    }

    public dh(String str) {
        this(str, 0);
    }

    public dh(String str, int i) {
        this.f236a = new LinkedList<>();
        this.f234a = 0L;
        this.f235a = str;
        this.f7879a = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(dh dhVar) {
        if (dhVar == null) {
            return 1;
        }
        return dhVar.f7879a - this.f7879a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.TAG_TT, this.f234a);
        jSONObject.put("wt", this.f7879a);
        jSONObject.put("host", this.f235a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cx> it = this.f236a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m273a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized dh a(JSONObject jSONObject) {
        this.f234a = jSONObject.getLong(TtmlNode.TAG_TT);
        this.f7879a = jSONObject.getInt("wt");
        this.f235a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f236a.add(new cx().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
