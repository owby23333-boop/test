package com.yuewen;

import android.text.TextUtils;
import com.duokan.download.common.DownloadDatabaseHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16578b;
    public String c;
    public String d;

    public qq() {
        this.f16577a = "";
        this.f16578b = "";
        this.c = "";
        this.d = "";
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadDatabaseHelper.b.a.e, this.f16577a);
            jSONObject.put("source_revision", this.f16578b);
            jSONObject.put("source_md5", this.c);
            jSONObject.put(DownloadDatabaseHelper.b.a.f, this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public qq(String str) {
        this.f16577a = "";
        this.f16578b = "";
        this.c = "";
        this.d = "";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f16577a = jSONObject.optString(DownloadDatabaseHelper.b.a.e);
            this.f16578b = jSONObject.optString("source_revision");
            this.c = jSONObject.optString("source_md5");
            this.d = jSONObject.optString(DownloadDatabaseHelper.b.a.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
