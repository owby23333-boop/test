package cn.bmob.v3.http.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Upyun {
    private String domain;
    private String name;
    private String secret;

    public Upyun(String str, String str2, String str3) {
        this.name = str;
        this.domain = str2;
        this.secret = str3;
    }

    public static Upyun parse(JSONObject jSONObject) throws JSONException {
        return new Upyun(jSONObject.has("name") ? jSONObject.getString("name") : "", jSONObject.has("domain") ? jSONObject.getString("domain") : "", jSONObject.has("secret") ? jSONObject.getString("secret") : "");
    }

    public String getDomain() {
        return this.domain;
    }

    public String getName() {
        return this.name;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String toString() {
        return super.toString();
    }
}
