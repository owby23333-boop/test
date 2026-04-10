package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j2 {
    private final Context a;
    private final h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedPreferences f716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile JSONObject f719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile JSONObject f720g;

    public j2(Context context, h hVar) {
        this.a = context;
        this.b = hVar;
        this.f718e = this.a.getSharedPreferences("embed_applog_stats", 0);
        this.f716c = this.a.getSharedPreferences("embed_header_custom", 0);
        this.f717d = this.a.getSharedPreferences("embed_last_sp_session", 0);
    }

    public int A() {
        return this.f718e.getInt("bav_monitor_rate", 0);
    }

    public String B() {
        return this.b.e();
    }

    String C() {
        return this.b.j();
    }

    String D() {
        return this.b.k();
    }

    String E() {
        return this.b.l();
    }

    String F() {
        return this.b.q();
    }

    String G() {
        return this.f716c.getString("header_custom_info", null);
    }

    String H() {
        return this.f716c.getString("ab_sdk_version", "");
    }

    String I() {
        return this.f716c.getString("user_unique_id", null);
    }

    public boolean J() {
        if (this.b.p() == 0) {
            String strA = m0.a(this.a);
            if (TextUtils.isEmpty(strA)) {
                this.b.a(0);
            } else {
                this.b.a(strA.contains(":") ? 2 : 1);
            }
        }
        return this.b.p() == 1;
    }

    public long K() {
        return this.f718e.getLong("abtest_fetch_interval", 0L);
    }

    public String L() {
        return !TextUtils.isEmpty(this.b.d()) ? this.b.d() : this.f716c.getString("ab_version", null);
    }

    public JSONObject M() {
        JSONObject jSONObject = this.f719f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (N()) {
                        jSONObject = new JSONObject(this.f716c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f719f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean N() {
        return this.f718e.getBoolean("bav_ab_config", false);
    }

    public boolean O() {
        return this.f718e.getBoolean("bav_log_collect", false);
    }

    public long P() {
        return this.f718e.getLong("session_interval", 30000L);
    }

    public long Q() {
        return this.f718e.getLong("batch_event_interval", 30000L);
    }

    String R() {
        return null;
    }

    String S() {
        return this.b.r();
    }

    String a() {
        return this.f718e.getString("user_agent", null);
    }

    public void a(long j2) {
    }

    public void a(String str, int i2) {
        this.f717d.edit().putString("session_last_day", str).putInt("session_order", i2).apply();
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void a(JSONObject jSONObject) {
        if (l0.a) {
            l0.a("setConfig, " + jSONObject.toString(), null);
        }
        this.f720g = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.f718e.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt <= 0 || jOptInt > 604800) {
            editorEdit.remove("session_interval");
        } else {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 <= 0 || jOptInt2 > 604800) {
            editorEdit.remove("batch_event_interval");
        } else {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt <= 0 || iOptInt > 604800) {
            editorEdit.remove("send_launch_timely");
        } else {
            editorEdit.putInt("send_launch_timely", iOptInt);
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 <= 20 || jOptInt3 > 604800) {
            editorEdit.remove("abtest_fetch_interval");
        } else {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        }
        if (jSONObject.optBoolean("bav_log_collect", true)) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 <= 0 || iOptInt2 > 100) {
            editorEdit.remove("bav_monitor_rate");
            k0.a(false);
        } else {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            k0.a(true);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public boolean a(ArrayList<u> arrayList) {
        return true;
    }

    public long b() {
        return 10000L;
    }

    void b(JSONObject jSONObject) {
        this.f716c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public String c() {
        return this.b.i();
    }

    void c(JSONObject jSONObject) {
        l0.a("setAbConfig, " + jSONObject.toString(), null);
        this.f716c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f719f = null;
    }

    public int d() {
        return this.b.x();
    }

    public int e() {
        return this.b.u();
    }

    public int f() {
        return this.b.m();
    }

    public String g() {
        return this.b.w();
    }

    public String h() {
        return this.b.t();
    }

    public String i() {
        return this.b.a();
    }

    public String j() {
        return this.b.c();
    }

    public String k() {
        return this.b.b();
    }

    public String l() {
        return this.b.y();
    }

    public String m() {
        return this.b.h() == null ? "" : this.b.h();
    }

    public String n() {
        return this.b.g() == null ? "" : this.b.g();
    }

    public boolean o() {
        return this.b.B();
    }

    public h p() {
        return this.b;
    }

    public CharSequence q() {
        return this.b.z();
    }

    public String r() {
        return this.b.n();
    }

    public boolean s() {
        return this.b.D();
    }

    String t() {
        return this.b.f();
    }

    public String u() {
        return this.f717d.getString("session_last_day", "");
    }

    public int v() {
        return this.f717d.getInt("session_order", 0);
    }

    public SharedPreferences w() {
        return this.f718e;
    }

    public boolean x() {
        return this.b.C();
    }

    public JSONObject y() {
        return this.f720g;
    }

    public long z() {
        return this.f718e.getLong("app_log_last_config_time", 0L);
    }
}
