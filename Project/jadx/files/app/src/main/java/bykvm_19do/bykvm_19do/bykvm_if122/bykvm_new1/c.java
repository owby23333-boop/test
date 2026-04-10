package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements f {
    private int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1764c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1765d = -1;
    private e0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.P();

    c() {
    }

    private JSONObject a() {
        String strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(this.a.d("app_common_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (strA != null && !TextUtils.isEmpty(strA)) {
            try {
                return new JSONObject(strA);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void b(JSONObject jSONObject) {
        this.b = jSONObject.optInt("event_batch_size", 100);
        int i2 = this.b;
        if (i2 <= 0 || i2 > 1000) {
            this.b = 100;
        }
        this.f1765d = jSONObject.optLong("event_routine_interval", 120000L);
        long j2 = this.f1765d;
        if (j2 < 10000 || j2 > 300000) {
            this.f1765d = 120000L;
        }
        this.f1764c = jSONObject.optInt("event_send_type", 0);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            b(jSONObject);
            String strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            if (strB != null && !TextUtils.isEmpty(strB)) {
                this.a.b("app_common_config", strB);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().a(jSONObject);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        JSONObject jSONObjectA;
        int i2 = this.b;
        if (i2 != -1) {
            return i2;
        }
        if (this.a == null || (jSONObjectA = a()) == null) {
            return 100;
        }
        b(jSONObjectA);
        return this.b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        JSONObject jSONObjectA;
        long j2 = this.f1765d;
        if (j2 != -1) {
            return j2;
        }
        if (this.a == null || (jSONObjectA = a()) == null) {
            return 120000L;
        }
        b(jSONObjectA);
        return this.f1765d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        JSONObject jSONObjectA;
        int i2 = this.f1764c;
        if (i2 != -1) {
            return i2;
        }
        if (this.a == null || (jSONObjectA = a()) == null) {
            return 0;
        }
        b(jSONObjectA);
        return this.f1764c;
    }
}
