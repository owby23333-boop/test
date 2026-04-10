package com.yuewen;

import com.duokan.download.domain.DownloadType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class v51 extends st0 {
    public static final /* synthetic */ boolean f = false;
    public String e;

    public v51() {
        this.e = "";
    }

    public static v51 e(JSONObject jSONObject) {
        try {
            if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.FONT) {
                return null;
            }
            return new v51(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.yuewen.st0
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put(so2.sa, this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yuewen.st0
    public DownloadType b() {
        return DownloadType.FONT;
    }

    @Override // com.yuewen.st0
    public String c() {
        return this.e;
    }

    public v51(JSONObject jSONObject) {
        super(jSONObject);
        this.e = "";
        this.e = jSONObject.optString(so2.sa);
    }
}
