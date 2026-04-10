package com.yuewen;

import cn.kuaipan.android.kss.upload.KssUploadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class eq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f10711a;

    public eq1(JSONObject jSONObject) {
        this.f10711a = jSONObject;
    }

    public static eq1 a(KssUploadInfo kssUploadInfo) {
        try {
            return new eq1(new JSONObject().put(mo3.c, new JSONObject(kssUploadInfo.getCommitString())));
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject b() {
        return this.f10711a;
    }
}
