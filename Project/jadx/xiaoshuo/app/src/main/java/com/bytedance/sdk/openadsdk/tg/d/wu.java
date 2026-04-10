package com.bytedance.sdk.openadsdk.tg.d;

import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class wu extends e {
    private String bf;
    private long d;
    private int ga;
    private String p;
    private long tg;
    private String vn;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.bf);
            jSONObject.put("preload_size", this.d);
            jSONObject.put("load_time", this.tg);
            jSONObject.put("error_code", this.ga);
            jSONObject.put(PushMessageHelper.ERROR_MESSAGE, this.vn);
            jSONObject.put("error_message_server", this.p);
            e(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bf(long j) {
        this.tg = j;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.bf = str;
    }

    public void bf(String str) {
        this.vn = str;
    }

    public void e(long j) {
        this.d = j;
    }

    public void e(int i) {
        this.ga = i;
    }
}
