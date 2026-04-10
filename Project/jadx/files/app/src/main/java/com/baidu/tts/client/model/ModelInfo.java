package com.baidu.tts.client.model;

import com.baidu.tts.enumtype.KeyEnum;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelInfo {
    private String mDomain;
    private String mGender;
    private String mLanguage;
    private String mName;
    private String mQuality;
    private String mServerId;
    private String mSpeaker;
    private String mSpeechDataId;
    private String mTextDataId;
    private String mVersionMax;
    private String mVersionMin;

    public String getDomain() {
        return this.mDomain;
    }

    public String getGender() {
        return this.mGender;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getName() {
        return this.mName;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public String getServerId() {
        return this.mServerId;
    }

    public String getSpeaker() {
        return this.mSpeaker;
    }

    public String getSpeechDataId() {
        return this.mSpeechDataId;
    }

    public String getTextDataId() {
        return this.mTextDataId;
    }

    public String getVersionMax() {
        return this.mVersionMax;
    }

    public String getVersionMin() {
        return this.mVersionMin;
    }

    public void parseJson(JSONObject jSONObject) {
        this.mServerId = jSONObject.optString(KeyEnum.ID.getFullName());
        this.mName = jSONObject.optString(KeyEnum.NAME.getFullName());
        this.mVersionMin = jSONObject.optString(KeyEnum.VERSION_MIN.getFullName());
        this.mVersionMax = jSONObject.optString(KeyEnum.VERSION_MAX.getFullName());
        this.mLanguage = jSONObject.optString(KeyEnum.LANGUAGE.getFullName());
        this.mGender = jSONObject.optString(KeyEnum.GENDER.getFullName());
        this.mSpeaker = jSONObject.optString(KeyEnum.SPEAKER.getFullName());
        this.mDomain = jSONObject.optString(KeyEnum.DOMAIN.getFullName());
        this.mQuality = jSONObject.optString(KeyEnum.QUALITY.getFullName());
        this.mTextDataId = jSONObject.optString(KeyEnum.TEXT_DATA_ID.getFullName());
        this.mSpeechDataId = jSONObject.optString(KeyEnum.SPEECH_DATA_ID.getFullName());
    }

    public void setDomain(String str) {
        this.mDomain = str;
    }

    public void setGender(String str) {
        this.mGender = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setMap(Map<String, String> map) {
        if (map != null) {
            this.mServerId = map.get(KeyEnum.ID.getFullName());
            this.mName = map.get(KeyEnum.NAME.getFullName());
            this.mVersionMin = map.get(KeyEnum.VERSION_MIN.getFullName());
            this.mVersionMax = map.get(KeyEnum.VERSION_MAX.getFullName());
            this.mLanguage = map.get(KeyEnum.LANGUAGE.getFullName());
            this.mGender = map.get(KeyEnum.GENDER.getFullName());
            this.mSpeaker = map.get(KeyEnum.SPEAKER.getFullName());
            this.mDomain = map.get(KeyEnum.DOMAIN.getFullName());
            this.mQuality = map.get(KeyEnum.QUALITY.getFullName());
            this.mTextDataId = map.get(KeyEnum.TEXT_DATA_ID.getFullName());
            this.mSpeechDataId = map.get(KeyEnum.SPEECH_DATA_ID.getFullName());
        }
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setQuality(String str) {
        this.mQuality = str;
    }

    public void setServerId(String str) {
        this.mServerId = str;
    }

    public void setSpeaker(String str) {
        this.mSpeaker = str;
    }

    public void setSpeechDataId(String str) {
        this.mSpeechDataId = str;
    }

    public void setTextDataId(String str) {
        this.mTextDataId = str;
    }

    public void setVersionMax(String str) {
        this.mVersionMax = str;
    }

    public void setVersionMin(String str) {
        this.mVersionMin = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(KeyEnum.ID.getFullName(), this.mServerId);
            jSONObject.putOpt(KeyEnum.NAME.getFullName(), this.mName);
            jSONObject.putOpt(KeyEnum.VERSION_MIN.getFullName(), this.mVersionMin);
            jSONObject.putOpt(KeyEnum.VERSION_MAX.getFullName(), this.mVersionMax);
            jSONObject.putOpt(KeyEnum.LANGUAGE.getFullName(), this.mLanguage);
            jSONObject.putOpt(KeyEnum.GENDER.getFullName(), this.mGender);
            jSONObject.putOpt(KeyEnum.SPEAKER.getFullName(), this.mSpeaker);
            jSONObject.putOpt(KeyEnum.DOMAIN.getFullName(), this.mDomain);
            jSONObject.putOpt(KeyEnum.QUALITY.getFullName(), this.mQuality);
            jSONObject.putOpt(KeyEnum.TEXT_DATA_ID.getFullName(), this.mTextDataId);
            jSONObject.putOpt(KeyEnum.SPEECH_DATA_ID.getFullName(), this.mSpeechDataId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
