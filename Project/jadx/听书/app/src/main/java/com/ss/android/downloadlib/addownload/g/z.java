package com.ss.android.downloadlib.addownload.g;

import com.bytedance.sdk.component.utils.wp;
import com.ss.android.downloadlib.e.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1989a;
    public long dl;
    public String e;
    public long g;
    public String gc;
    public volatile long gz;
    public String m;
    public long z;

    public z() {
    }

    public z(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.z = j;
        this.g = j2;
        this.dl = j3;
        this.f1989a = str;
        this.gc = str2;
        this.m = str3;
        this.e = str4;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.z);
            jSONObject.put("mAdId", this.g);
            jSONObject.put("mExtValue", this.dl);
            jSONObject.put("mPackageName", this.f1989a);
            jSONObject.put("mAppName", this.gc);
            jSONObject.put("mLogExtra", this.m);
            jSONObject.put("mFileName", this.e);
            jSONObject.put("mTimeStamp", this.gz);
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject;
    }

    public static z z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        try {
            zVar.z = i.z(jSONObject, "mDownloadId");
            zVar.g = i.z(jSONObject, "mAdId");
            zVar.dl = i.z(jSONObject, "mExtValue");
            zVar.f1989a = jSONObject.optString("mPackageName");
            zVar.gc = jSONObject.optString("mAppName");
            zVar.m = jSONObject.optString("mLogExtra");
            zVar.e = jSONObject.optString("mFileName");
            zVar.gz = i.z(jSONObject, "mTimeStamp");
            return zVar;
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }
}
