package com.bytedance.sdk.openadsdk.g;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1436a;
    private String dl;
    private String g;
    private long gc;
    private long z;

    public z(JSONObject jSONObject) {
        this.z = jSONObject.optLong(CmcdConfiguration.KEY_CONTENT_ID);
        this.g = jSONObject.optString("url");
        this.dl = jSONObject.optString("file_hash");
        this.f1436a = jSONObject.optLong("effective_time");
        this.gc = jSONObject.optLong("expiration_time");
    }

    public String z() {
        return this.g;
    }

    public String g() {
        return this.dl;
    }

    public long dl() {
        return this.f1436a;
    }

    public boolean a() {
        return System.currentTimeMillis() >= this.gc;
    }

    public long z(String str) {
        File file = new File(str, this.dl);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public JSONObject gc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, this.z);
            jSONObject.put("url", this.g);
            jSONObject.put("file_hash", this.dl);
            jSONObject.put("effective_time", this.f1436a);
            jSONObject.put("expiration_time", this.gc);
        } catch (Exception e) {
            wp.g("BrandVideo", e.getMessage());
        }
        return jSONObject;
    }

    public boolean g(String str) {
        File file = new File(str, this.dl);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }
}
