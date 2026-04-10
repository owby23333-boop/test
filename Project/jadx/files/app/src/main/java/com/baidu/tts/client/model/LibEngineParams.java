package com.baidu.tts.client.model;

import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.JsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LibEngineParams {
    private String[] mDomain;
    private String mJson;
    private String[] mLanguage;
    private String[] mQuality;
    private String mVersion;

    public LibEngineParams(String str) {
        this.mJson = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mVersion = jSONObject.optString(KeyEnum.VERSION.getFullName());
            this.mDomain = JsonTool.getStringarray(jSONObject.optJSONArray(KeyEnum.DOMAIN.getFullName()));
            this.mLanguage = JsonTool.getStringarray(jSONObject.optJSONArray(KeyEnum.LANGUAGE.getFullName()));
            this.mQuality = JsonTool.getStringarray(jSONObject.optJSONArray(KeyEnum.QUALITY.getFullName()));
        } catch (Exception unused) {
        }
    }

    public String[] getDomain() {
        return this.mDomain;
    }

    public JSONObject getJsonResult() {
        try {
            return new JSONObject(this.mJson);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String[] getLanguage() {
        return this.mLanguage;
    }

    public String[] getQuality() {
        return this.mQuality;
    }

    public String getResult() {
        return this.mJson;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setDomain(String[] strArr) {
        this.mDomain = strArr;
    }

    public void setLanguage(String[] strArr) {
        this.mLanguage = strArr;
    }

    public void setQuality(String[] strArr) {
        this.mQuality = strArr;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }
}
