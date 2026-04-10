package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.media3.session.MediaController;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f284a;
    private final SharedPreferences dl;
    private volatile JSONObject e;
    private final gz g;
    private final SharedPreferences gc;
    private volatile JSONObject m;
    private final Context z;

    public static String z() {
        return "embed_applog_stats";
    }

    String sy() {
        return null;
    }

    public boolean z(ArrayList<sd> arrayList) {
        return true;
    }

    public bv(Context context, gz gzVar) {
        this.z = context;
        this.g = gzVar;
        this.gc = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "embed_applog_stats", 0);
        this.dl = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "embed_header_custom", 0);
        this.f284a = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "embed_last_sp_session", 0);
    }

    String g() {
        return this.g.gz();
    }

    public String dl() {
        return this.f284a.getString("session_last_day", "");
    }

    public void z(String str, int i) {
        this.f284a.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int a() {
        return this.f284a.getInt("session_order", 0);
    }

    public SharedPreferences gc() {
        return this.gc;
    }

    public boolean m() {
        return this.g.g();
    }

    public JSONObject e() {
        return this.e;
    }

    public void z(JSONObject jSONObject) {
        if (cb.g) {
            cb.z("setConfig, " + jSONObject.toString(), null);
        }
        this.e = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.gc.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt > 0 && jOptInt <= 604800) {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        } else {
            editorEdit.remove("session_interval");
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 > 0 && jOptInt2 <= 604800) {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        } else {
            editorEdit.remove("batch_event_interval");
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt > 0 && iOptInt <= 604800) {
            editorEdit.putInt("send_launch_timely", iOptInt);
        } else {
            editorEdit.remove("send_launch_timely");
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 > 20 && jOptInt3 <= 604800) {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        } else {
            editorEdit.remove("abtest_fetch_interval");
        }
        boolean zOptBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (zOptBoolean) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        cb.z = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            wo.z(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            wo.z(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long gz() {
        return this.gc.getLong("app_log_last_config_time", 0L);
    }

    public int fo() {
        return this.gc.getInt("bav_monitor_rate", 0);
    }

    public String uy() {
        return this.g.dl();
    }

    String kb() {
        return this.g.a();
    }

    String wp() {
        return this.g.gc();
    }

    String i() {
        return this.g.m();
    }

    String v() {
        return this.g.e();
    }

    void g(JSONObject jSONObject) {
        this.dl.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    String pf() {
        return this.dl.getString("header_custom_info", null);
    }

    String ls() {
        return this.dl.getString("ab_sdk_version", "");
    }

    String p() {
        return this.dl.getString("user_unique_id", null);
    }

    public boolean fv() {
        if (this.g.fo() == 0) {
            String strZ = o.z(this.z);
            if (!TextUtils.isEmpty(strZ)) {
                this.g.z(strZ.contains(":") ? 2 : 1);
            } else {
                this.g.z(0);
            }
        }
        return this.g.fo() == 1;
    }

    public long js() {
        return this.gc.getLong("abtest_fetch_interval", 0L);
    }

    void dl(JSONObject jSONObject) {
        cb.z("setAbConfig, " + jSONObject.toString(), null);
        this.dl.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.m = null;
    }

    public String tb() {
        if (!TextUtils.isEmpty(this.g.tb())) {
            return this.g.tb();
        }
        return this.dl.getString("ab_version", null);
    }

    public JSONObject q() {
        JSONObject jSONObject = this.m;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (iq()) {
                        jSONObject = new JSONObject(this.dl.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.m = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean iq() {
        return this.gc.getBoolean("bav_ab_config", false);
    }

    public boolean zw() {
        return this.gc.getBoolean("bav_log_collect", false);
    }

    public long io() {
        return this.gc.getLong("session_interval", MediaController.RELEASE_UNBIND_TIMEOUT_MS);
    }

    public long uf() {
        return this.gc.getLong("batch_event_interval", MediaController.RELEASE_UNBIND_TIMEOUT_MS);
    }

    String hh() {
        return this.g.z();
    }

    String l() {
        return this.gc.getString("user_agent", null);
    }

    public String h() {
        return this.g.wp();
    }

    public int gk() {
        return this.g.pf();
    }

    public int x() {
        return this.g.ls();
    }

    public int lq() {
        return this.g.p();
    }

    public String mc() {
        return this.g.i();
    }

    public String un() {
        return this.g.v();
    }

    public String ti() {
        return this.g.js();
    }

    public String eo() {
        return this.g.q();
    }

    public String oq() {
        return this.g.iq();
    }

    public String wj() {
        return this.g.zw();
    }

    public String na() {
        return this.g.gk() == null ? "" : this.g.gk();
    }

    public String xl() {
        return this.g.x() == null ? "" : this.g.x();
    }

    public boolean j() {
        return this.g.sy();
    }

    public boolean gp() {
        return this.g.hh();
    }

    public String t() {
        return this.g.h();
    }

    public gz vm() {
        return this.g;
    }

    public CharSequence y() {
        return this.g.io();
    }
}
