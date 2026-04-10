package com.yuewen;

import cn.kuaipan.android.kss.upload.UploadFileInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class dq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f10317a;

    public dq1(UploadFileInfo uploadFileInfo) {
        JSONObject jSONObject = new JSONObject();
        this.f10317a = jSONObject;
        try {
            jSONObject.put(mo3.c, new JSONObject(uploadFileInfo.getKssString()));
        } catch (JSONException unused) {
        }
    }

    public JSONObject a() {
        return this.f10317a;
    }

    public dq1(JSONObject jSONObject) {
        this.f10317a = jSONObject;
    }
}
