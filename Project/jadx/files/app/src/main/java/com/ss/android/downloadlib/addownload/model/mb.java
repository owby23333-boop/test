package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadlib.utils.jb;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    public long b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18009h;
    public String hj;
    public String ko;
    public long mb;
    public long ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18010u;
    public volatile long ww;

    public mb() {
    }

    public JSONObject mb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.mb);
            jSONObject.put("mAdId", this.ox);
            jSONObject.put("mExtValue", this.b);
            jSONObject.put("mPackageName", this.hj);
            jSONObject.put("mAppName", this.f18009h);
            jSONObject.put("mLogExtra", this.f18010u);
            jSONObject.put("mFileName", this.ko);
            jSONObject.put("mTimeStamp", this.ww);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public mb(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.mb = j2;
        this.ox = j3;
        this.b = j4;
        this.hj = str;
        this.f18009h = str2;
        this.f18010u = str3;
        this.ko = str4;
    }

    public static mb mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        mb mbVar = new mb();
        try {
            mbVar.mb = jb.mb(jSONObject, "mDownloadId");
            mbVar.ox = jb.mb(jSONObject, "mAdId");
            mbVar.b = jb.mb(jSONObject, "mExtValue");
            mbVar.hj = jSONObject.optString("mPackageName");
            mbVar.f18009h = jSONObject.optString("mAppName");
            mbVar.f18010u = jSONObject.optString("mLogExtra");
            mbVar.ko = jSONObject.optString("mFileName");
            mbVar.ww = jb.mb(jSONObject, "mTimeStamp");
            return mbVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
