package com.bytedance.embedapplog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class oq extends mc {
    private boolean gc;
    static final long[] g = {920000};
    static final long[] dl = {920000};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f295a = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    @Override // com.bytedance.embedapplog.mc
    String a() {
        return "r";
    }

    oq(ti tiVar) {
        super(tiVar);
        this.gc = true;
    }

    @Override // com.bytedance.embedapplog.mc
    long z() {
        return this.z.gc().i() + ((long) (this.z.e().dl() ? 21600000 : 43200000));
    }

    @Override // com.bytedance.embedapplog.mc
    long[] g() {
        int iWp = this.z.gc().wp();
        if (iWp == 0) {
            return f295a;
        }
        if (iWp == 1) {
            return dl;
        }
        if (iWp == 2) {
            return g;
        }
        cb.g((Throwable) null);
        return dl;
    }

    @Override // com.bytedance.embedapplog.mc
    boolean dl() throws JSONException {
        JSONObject jSONObjectZ;
        JSONObject jSONObject = new JSONObject();
        gb gbVarGc = this.z.gc();
        JSONObject jSONObjectZ2 = gbVarGc.z();
        if (jSONObjectZ2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (gbVarGc) {
                jSONObjectZ = o.z(jSONObjectZ2);
            }
            jSONObject.put("header", jSONObjectZ);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectZ.optString("device_id")) && o.a() && this.gc) {
                this.gc = false;
                return false;
            }
            JSONObject jSONObjectZ3 = this.z.gc().z();
            JSONObject jSONObjectZ4 = r.z(yz.z(this.z.g(), jSONObjectZ3, this.z.gz().z(), true, z.a()), jSONObject);
            if (jSONObjectZ4 != null) {
                String strOptString = jSONObjectZ4.optString("device_id", "");
                boolean z = this.z.gc().z(jSONObjectZ4, strOptString, jSONObjectZ4.optString("install_id", ""), jSONObjectZ4.optString("ssid", ""));
                js.g("__kite", "start:" + o.m());
                try {
                    if (o.m()) {
                        new l(this.z.g()).z(jSONObjectZ3, strOptString);
                    }
                } catch (Throwable th) {
                    js.z("__kite", "error:" + o.m(), th);
                }
                return z;
            }
        } else {
            cb.g((Throwable) null);
        }
        return false;
    }
}
