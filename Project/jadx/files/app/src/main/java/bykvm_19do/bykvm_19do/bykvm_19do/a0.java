package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private JSONArray f631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private JSONArray f632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private z f633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private JSONArray f634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private d0 f635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONObject f636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private JSONArray f637r;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.f628i = cursor.getBlob(1);
        this.f629j = cursor.getInt(2);
        this.f636q = null;
        this.f633n = null;
        this.f635p = null;
        this.f634o = null;
        this.f631l = null;
        this.f632m = null;
        this.f637r = null;
        return this;
    }

    void a(long j2, JSONObject jSONObject, z zVar, d0 d0Var, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.a = j2;
        this.f636q = jSONObject;
        this.f633n = zVar;
        this.f635p = d0Var;
        this.f634o = null;
        this.f631l = jSONArray2;
        this.f632m = jSONArray3;
        this.f637r = jSONArray4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", a.a(f().toString()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        l0.a(null);
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.f636q);
        jSONObject.put("time_sync", s.b);
        if (this.f633n != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f633n.f());
            jSONObject.put("launch", jSONArray);
        }
        d0 d0Var = this.f635p;
        if (d0Var != null) {
            JSONObject jSONObjectF = d0Var.f();
            JSONArray jSONArray2 = this.f634o;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i2 = 0; i2 < length; i2++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.f634o.optString(i2)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                jSONObjectF.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectF);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.f631l;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.f631l);
        }
        JSONArray jSONArray7 = this.f634o;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (this.f632m == null) {
            this.f632m = this.f634o;
        } else if (length3 > 0) {
            for (int i3 = 0; i3 < length3; i3++) {
                this.f632m.put(this.f634o.get(i3));
            }
        }
        JSONArray jSONArray8 = this.f632m;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.f632m);
        }
        JSONArray jSONArray9 = this.f637r;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.f637r);
        }
        StringBuilder sb = new StringBuilder("wP {");
        Object obj = this.f633n;
        if (obj == null) {
            obj = "la";
        }
        sb.append(obj);
        sb.append(", ");
        Object obj2 = this.f635p;
        if (obj2 == null) {
            obj2 = "te";
        }
        sb.append(obj2);
        sb.append(", p: ");
        sb.append(length3);
        sb.append(", v1: ");
        sb.append(length2);
        sb.append(", v3: ");
        sb.append(length4);
        sb.append("}");
        sb.append(", m: ");
        sb.append(length5);
        sb.append("}");
        l0.d(sb.toString(), null);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    String d() {
        return "pack";
    }
}
