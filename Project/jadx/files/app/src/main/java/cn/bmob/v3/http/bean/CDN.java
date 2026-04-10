package cn.bmob.v3.http.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CDN {
    private Upyun upyun;

    public CDN(Upyun upyun) {
        this.upyun = upyun;
    }

    public static CDN parse(String str) throws JSONException {
        return new CDN(Upyun.parse(new JSONObject(str).getJSONObject("upyun")));
    }

    public Upyun getUpyun() {
        return this.upyun;
    }

    public void setUpyun(Upyun upyun) {
        this.upyun = upyun;
    }
}
