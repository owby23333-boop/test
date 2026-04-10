package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1521g;

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason", this.a);
            jSONObject.put("fill_error_code", this.b);
            jSONObject.put("fill_error_msg", this.f1517c);
            jSONObject.put("mediation_rit", this.f1518d);
            jSONObject.put("load_sort", this.f1519e);
            jSONObject.put("show_sort", this.f1520f);
            jSONObject.put("has_shown", this.f1521g);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "{\"name\": \"json err\"}";
        }
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(String str) {
        this.f1517c = str;
    }

    public void b(int i2) {
        this.f1521g = i2;
    }

    public void b(String str) {
        this.f1518d = str;
    }

    public void c(int i2) {
        this.f1519e = i2;
    }

    public void d(int i2) {
        this.a = i2;
    }

    public void e(int i2) {
        this.f1520f = i2;
    }
}
