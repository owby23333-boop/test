package com.yuewen;

import com.duokan.download.domain.DownloadType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class a54 extends st0 {
    public static final /* synthetic */ boolean g = false;
    public String e;
    public JSONObject f;

    public a54() {
        this.e = "";
        this.f = new JSONObject();
    }

    public static a54 f(JSONObject jSONObject) {
        try {
            if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.TTS_PACK) {
                return null;
            }
            return new a54(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.yuewen.st0
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put("pack_name", this.e);
            jSONObject.put("pack_info", this.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yuewen.st0
    public DownloadType b() {
        return DownloadType.TTS_PACK;
    }

    @Override // com.yuewen.st0
    public String c() {
        return this.e;
    }

    public JSONObject e() {
        return this.f;
    }

    public a54(JSONObject jSONObject) {
        super(jSONObject);
        this.e = "";
        this.f = new JSONObject();
        this.e = jSONObject.optString("pack_name");
        this.f = jSONObject.optJSONObject("pack_info");
    }
}
