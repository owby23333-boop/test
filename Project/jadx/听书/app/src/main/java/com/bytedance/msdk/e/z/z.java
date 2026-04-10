package com.bytedance.msdk.e.z;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.core.gc.g.a;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private int dl = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f460a = -1;
    private int gc = -1;
    private int m = -1;
    private int e = -1;
    private int gz = -1;
    private int fo = -1;
    private int uy = -1;
    private l g = com.bytedance.msdk.e.z.g();

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private synchronized void g(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("event_batch_size", 100);
        this.dl = iOptInt;
        if (iOptInt <= 0 || iOptInt > 1000) {
            this.dl = 100;
        }
        long jOptLong = jSONObject.optLong("event_routine_interval", 120000L);
        this.f460a = jOptLong;
        if (jOptLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || jOptLong > 300000) {
            this.f460a = 120000L;
        }
        int iOptInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.gc = iOptInt2;
        if (iOptInt2 != 0 && iOptInt2 != 1) {
            this.gc = 0;
        }
        this.e = jSONObject.optInt("rv_start_time", 5000);
        int iOptInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
        this.m = iOptInt3;
        if (iOptInt3 != 0 && iOptInt3 != 1) {
            this.m = 0;
        }
        a.z().z(jSONObject.optInt("pre_fetch_count", 20));
        this.gz = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
        this.fo = jSONObject.optInt("can_log", -1);
        this.uy = jSONObject.optInt("enable_abtest_id", 0);
    }

    private synchronized JSONObject kb() {
        String strG = this.g.g("app_common_config");
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        if (!strG.startsWith("[") && !strG.startsWith("{")) {
            strG = com.bytedance.msdk.gz.z.g(strG, com.bytedance.msdk.gz.g.z());
        }
        if (!TextUtils.isEmpty(strG)) {
            try {
                return new JSONObject(strG);
            } catch (Throwable th) {
                wp.z(th);
                return null;
            }
        }
        return null;
    }

    public synchronized void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            g(jSONObject);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                this.g.z("app_common_config", string);
            }
        }
    }

    public synchronized int g() {
        JSONObject jSONObjectKb;
        int i = this.dl;
        if (i != -1) {
            return i;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 100;
        }
        g(jSONObjectKb);
        return this.dl;
    }

    public synchronized long dl() {
        JSONObject jSONObjectKb;
        long j = this.f460a;
        if (j != -1) {
            return j;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 120000L;
        }
        g(jSONObjectKb);
        return this.f460a;
    }

    public int a() {
        JSONObject jSONObjectKb;
        int i = this.gc;
        if (i != -1) {
            return i;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 0;
        }
        g(jSONObjectKb);
        return this.gc;
    }

    public int gc() {
        JSONObject jSONObjectKb;
        int i = this.m;
        if (i != -1) {
            return i;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 0;
        }
        g(jSONObjectKb);
        return this.m;
    }

    public int m() {
        JSONObject jSONObjectKb;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 5000;
        }
        g(jSONObjectKb);
        return this.e;
    }

    public synchronized boolean e() {
        JSONObject jSONObjectKb;
        int i = this.gz;
        if (i != -1) {
            return i == 1;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return false;
        }
        g(jSONObjectKb);
        return this.gz == 1;
    }

    public int gz() {
        return this.gz;
    }

    public boolean fo() {
        JSONObject jSONObjectKb;
        int i = this.fo;
        if (i != -1) {
            return i == 1;
        }
        if (this.g != null && (jSONObjectKb = kb()) != null) {
            g(jSONObjectKb);
            if (this.fo == 1) {
                return true;
            }
        }
        return false;
    }

    public int uy() {
        JSONObject jSONObjectKb;
        int i = this.uy;
        if (i != -1) {
            return i;
        }
        if (this.g == null || (jSONObjectKb = kb()) == null) {
            return 0;
        }
        g(jSONObjectKb);
        return this.uy;
    }
}
