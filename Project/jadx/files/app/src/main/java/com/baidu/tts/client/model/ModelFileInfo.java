package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.ResourceTools;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFileInfo {
    private String mAbsPath;
    private String mLength;
    private String mMd5;
    private String mName;
    private String mServerId;
    private String mUrl;

    public void generateAbsPath(Context context) {
        this.mAbsPath = ResourceTools.getModelFileAbsName(context, this.mName);
    }

    public String getAbsPath() {
        return this.mAbsPath;
    }

    public String getLength() {
        return this.mLength;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getName() {
        return this.mName;
    }

    public String getServerid() {
        return this.mServerId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void parseJson(JSONObject jSONObject) {
        this.mServerId = jSONObject.optString(KeyEnum.ID.getFullName());
        this.mLength = jSONObject.optString(KeyEnum.LENGTH.getFullName());
        this.mMd5 = jSONObject.optString(KeyEnum.MD5.getFullName());
        this.mName = jSONObject.optString(KeyEnum.NAME.getFullName());
        this.mUrl = jSONObject.optString(KeyEnum.URL.getFullName());
    }

    public void setAbsPath(String str) {
        this.mAbsPath = str;
    }

    public void setLength(String str) {
        this.mLength = str;
    }

    public void setMap(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mServerId = map.get(KeyEnum.ID.getFullName());
        this.mLength = map.get(KeyEnum.LENGTH.getFullName());
        this.mMd5 = map.get(KeyEnum.MD5.getFullName());
        this.mName = map.get(KeyEnum.NAME.getFullName());
        this.mAbsPath = map.get(KeyEnum.ABS_PATH.getFullName());
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setServerid(String str) {
        this.mServerId = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KeyEnum.ID.getFullName(), this.mServerId);
            jSONObject.putOpt(KeyEnum.LENGTH.getFullName(), this.mLength);
            jSONObject.putOpt(KeyEnum.MD5.getFullName(), this.mMd5);
            jSONObject.putOpt(KeyEnum.NAME.getFullName(), this.mName);
            jSONObject.putOpt(KeyEnum.ABS_PATH.getFullName(), this.mAbsPath);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
