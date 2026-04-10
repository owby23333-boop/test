package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LoadAdParams {
    private LoginType a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f17799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f17800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONObject f17801g = new JSONObject();

    public Map getDevExtra() {
        return this.f17799e;
    }

    public String getDevExtraJsonString() {
        try {
            return (this.f17799e == null || this.f17799e.size() <= 0) ? "" : new JSONObject(this.f17799e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f17800f;
    }

    public String getLoginAppId() {
        return this.b;
    }

    public String getLoginOpenid() {
        return this.f17797c;
    }

    public LoginType getLoginType() {
        return this.a;
    }

    public JSONObject getParams() {
        return this.f17801g;
    }

    public String getUin() {
        return this.f17798d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f17799e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f17800f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.b = str;
    }

    public void setLoginOpenid(String str) {
        this.f17797c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.a = loginType;
    }

    public void setUin(String str) {
        this.f17798d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.a + ", loginAppId=" + this.b + ", loginOpenid=" + this.f17797c + ", uin=" + this.f17798d + ", passThroughInfo=" + this.f17799e + ", extraInfo=" + this.f17800f + '}';
    }
}
