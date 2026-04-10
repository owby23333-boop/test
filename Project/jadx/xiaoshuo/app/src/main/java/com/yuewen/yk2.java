package com.yuewen;

import com.duokan.download.domain.DownloadType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class yk2 extends st0 {
    public static final /* synthetic */ boolean g = false;
    public String e;
    public String f;

    public yk2() {
        this.e = "";
        this.f = "";
    }

    public static yk2 e(JSONObject jSONObject) {
        try {
            if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.PLUGIN) {
                return null;
            }
            return new yk2(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.yuewen.st0
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put("plugin_name", this.e);
            jSONObject.put("plugin_type", this.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yuewen.st0
    public DownloadType b() {
        return DownloadType.PLUGIN;
    }

    @Override // com.yuewen.st0
    public String c() {
        return this.e;
    }

    public yk2(JSONObject jSONObject) {
        super(jSONObject);
        this.e = "";
        this.f = "";
        this.e = jSONObject.optString("plugin_name");
        this.f = jSONObject.optString("plugin_type");
    }
}
