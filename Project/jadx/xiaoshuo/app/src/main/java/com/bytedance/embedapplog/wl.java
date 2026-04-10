package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class wl {
    private final InitConfig bf;
    private final SharedPreferences d;
    private final Context e;
    private final SharedPreferences ga;
    private volatile JSONObject p;
    private final SharedPreferences tg;
    private volatile JSONObject vn;

    public wl(Context context, InitConfig initConfig) {
        this.e = context;
        this.bf = initConfig;
        this.ga = context.getSharedPreferences("embed_applog_stats", 0);
        this.d = context.getSharedPreferences("embed_header_custom", 0);
        this.tg = context.getSharedPreferences("embed_last_sp_session", 0);
    }

    @Nullable
    public String a() {
        return this.ga.getString(com.alipay.sdk.m.n.b.f1872b, null);
    }

    public String b() {
        return this.bf.getAbGroup();
    }

    public String bf() {
        return this.tg.getString("session_last_day", "");
    }

    public String bh() {
        return this.bf.getRegion();
    }

    public String bm() {
        return this.bf.getAbClient();
    }

    public String bx() {
        return this.bf.getTweakedChannel();
    }

    public long cv() {
        return this.ga.getLong("session_interval", 30000L);
    }

    public int d() {
        return this.tg.getInt("session_order", 0);
    }

    public JSONObject dt() {
        JSONObject jSONObject = this.vn;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (pe()) {
                        jSONObject = new JSONObject(this.d.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.vn = jSONObject;
            }
        }
        return jSONObject;
    }

    public void e(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public long f() {
        return this.ga.getLong("abtest_fetch_interval", 0L);
    }

    public int fy() {
        return this.bf.getVersionCode();
    }

    public boolean ga() {
        return this.bf.isPlayEnable();
    }

    public int h() {
        return this.bf.getUpdateVersionCode();
    }

    public String hb() {
        return this.bf.getVersion();
    }

    public boolean i() {
        return this.bf.isAndroidIdEnable();
    }

    public boolean j() {
        return this.bf.isImeiEnable();
    }

    public String k() {
        return !TextUtils.isEmpty(this.bf.getAbVersion()) ? this.bf.getAbVersion() : this.d.getString("ab_version", null);
    }

    public boolean l() {
        if (this.bf.getProcess() == 0) {
            String strE = pl.e(this.e);
            if (TextUtils.isEmpty(strE)) {
                this.bf.setProcess(0);
            } else {
                this.bf.setProcess(strE.contains(":") ? 2 : 1);
            }
        }
        return this.bf.getProcess() == 1;
    }

    public String lc() {
        return this.bf.getReleaseBuild();
    }

    public String m() {
        return this.bf.getChannel();
    }

    public CharSequence ot() {
        return this.bf.getZiJieCloudPkg();
    }

    public long p() {
        return this.ga.getLong("app_log_last_config_time", 0L);
    }

    public boolean pe() {
        return this.ga.getBoolean("bav_ab_config", false);
    }

    public String q() {
        return this.bf.getAppImei() == null ? "" : this.bf.getAppImei();
    }

    public String r() {
        return this.bf.getAbFeature();
    }

    public InitConfig rb() {
        return this.bf;
    }

    public String rm() {
        return this.bf.getVersionMinor();
    }

    public String rt() {
        return this.bf.getAppBuildSerial() == null ? "" : this.bf.getAppBuildSerial();
    }

    public String s() {
        return this.d.getString("ab_sdk_version", "");
    }

    public String t() {
        return this.d.getString("header_custom_info", null);
    }

    public SharedPreferences tg() {
        return this.ga;
    }

    public String uk() {
        return this.bf.getAppName();
    }

    public int v() {
        return this.ga.getInt("bav_monitor_rate", 0);
    }

    public JSONObject vn() {
        return this.p;
    }

    public String w() {
        return this.d.getString("user_unique_id", null);
    }

    public long wl() {
        return this.ga.getLong("batch_event_interval", 30000L);
    }

    public String wu() {
        return this.bf.getGoogleAid();
    }

    public int x() {
        return this.bf.getManifestVersionCode();
    }

    public String xu() {
        return this.bf.getLanguage();
    }

    public boolean y() {
        return this.ga.getBoolean("bav_log_collect", false);
    }

    public String yl() {
        return this.bf.geCustomerAndroidId();
    }

    public String za() {
        return null;
    }

    public String zk() {
        return this.bf.getAid();
    }

    public void bf(JSONObject jSONObject) {
        this.d.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public void d(JSONObject jSONObject) {
        tx.e("setAbConfig, " + jSONObject.toString(), null);
        this.d.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.vn = null;
    }

    public boolean e(ArrayList<i> arrayList) {
        return true;
    }

    public String e() {
        return this.bf.getAliyunUdid();
    }

    public void e(String str, int i) {
        this.tg.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public void e(JSONObject jSONObject) {
        if (tx.bf) {
            tx.e("setConfig, " + jSONObject.toString(), null);
        }
        this.p = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.ga.edit();
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
        tx.e = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            vs.e(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            vs.e(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }
}
