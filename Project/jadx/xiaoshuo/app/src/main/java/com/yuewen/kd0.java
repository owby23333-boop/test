package com.yuewen;

import com.duokan.download.domain.DownloadType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class kd0 extends st0 {
    public static final /* synthetic */ boolean f = false;
    public String e;

    public kd0() {
    }

    public static kd0 e(JSONObject jSONObject) {
        try {
            if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.DICT) {
                return null;
            }
            return new kd0(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.yuewen.st0
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put("dict_name", this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yuewen.st0
    public DownloadType b() {
        return DownloadType.DICT;
    }

    @Override // com.yuewen.st0
    public String c() {
        return this.e;
    }

    public kd0(JSONObject jSONObject) {
        super(jSONObject);
        this.e = jSONObject.optString("dict_name");
    }
}
