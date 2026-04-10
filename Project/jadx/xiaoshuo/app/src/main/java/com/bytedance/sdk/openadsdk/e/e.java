package com.bytedance.sdk.openadsdk.e;

import com.bytedance.sdk.component.utils.wu;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private String bf;
    private String d;
    private long e;
    private long ga;
    private long tg;

    public e(JSONObject jSONObject) {
        this.e = jSONObject.optLong("cid");
        this.bf = jSONObject.optString("url");
        this.d = jSONObject.optString("file_hash");
        this.tg = jSONObject.optLong("effective_time");
        this.ga = jSONObject.optLong("expiration_time");
    }

    public String bf() {
        return this.d;
    }

    public long d() {
        return this.tg;
    }

    public String e() {
        return this.bf;
    }

    public JSONObject ga() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.e);
            jSONObject.put("url", this.bf);
            jSONObject.put("file_hash", this.d);
            jSONObject.put("effective_time", this.tg);
            jSONObject.put("expiration_time", this.ga);
        } catch (Exception e) {
            wu.tg("BrandVideo", e.getMessage());
        }
        return jSONObject;
    }

    public boolean tg() {
        return System.currentTimeMillis() >= this.ga;
    }

    public boolean bf(String str) {
        File file = new File(str, this.d);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public long e(String str) {
        File file = new File(str, this.d);
        return file.exists() ? file.lastModified() : System.currentTimeMillis();
    }
}
