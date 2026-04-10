package com.baidu.tts.client.model;

import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.JsonTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Conditions {
    private Set<String> mDomains;
    private Set<String> mGenders;
    private Set<String> mLanguages;
    private Set<String> mModelIds;
    private Set<String> mQualitys;
    private Set<String> mSpeakers;
    private String mVersion;

    public void appendDomain(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mDomains == null) {
            this.mDomains = new HashSet();
        }
        this.mDomains.add(str);
    }

    public void appendGender(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mGenders == null) {
            this.mGenders = new HashSet();
        }
        this.mGenders.add(str);
    }

    public void appendId(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mModelIds == null) {
            this.mModelIds = new HashSet();
        }
        this.mModelIds.add(str);
    }

    public void appendLanguage(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mLanguages == null) {
            this.mLanguages = new HashSet();
        }
        this.mLanguages.add(str);
    }

    public void appendQuality(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mQualitys == null) {
            this.mQualitys = new HashSet();
        }
        this.mQualitys.add(str);
    }

    public void appendSpeaker(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mSpeakers == null) {
            this.mSpeakers = new HashSet();
        }
        this.mSpeakers.add(str);
    }

    public String[] getDomainArray() {
        return DataTool.fromSetToArray(this.mDomains);
    }

    public Set<String> getDomains() {
        return this.mDomains;
    }

    public String[] getGenderArray() {
        return DataTool.fromSetToArray(this.mGenders);
    }

    public JSONArray getGenderJA() {
        return JsonTool.fromSetToJson(this.mGenders);
    }

    public Set<String> getGenders() {
        return this.mGenders;
    }

    public JSONObject getJSONConditions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KeyEnum.ID.getFullName(), JsonTool.fromSetToJson(this.mModelIds));
            jSONObject.put(KeyEnum.VERSION.getFullName(), this.mVersion);
            jSONObject.put(KeyEnum.LANGUAGE.getFullName(), JsonTool.fromSetToJson(this.mLanguages));
            jSONObject.put(KeyEnum.GENDER.getFullName(), JsonTool.fromSetToJson(this.mGenders));
            jSONObject.put(KeyEnum.SPEAKER.getFullName(), JsonTool.fromSetToJson(this.mSpeakers));
            jSONObject.put(KeyEnum.DOMAIN.getFullName(), JsonTool.fromSetToJson(this.mDomains));
            jSONObject.put(KeyEnum.QUALITY.getFullName(), JsonTool.fromSetToJson(this.mQualitys));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String[] getLanguageArray() {
        return DataTool.fromSetToArray(this.mLanguages);
    }

    public Set<String> getLanguages() {
        return this.mLanguages;
    }

    public Set<String> getModelIds() {
        return this.mModelIds;
    }

    public String[] getModelIdsArray() {
        return DataTool.fromSetToArray(this.mModelIds);
    }

    public String[] getQualityArray() {
        return DataTool.fromSetToArray(this.mQualitys);
    }

    public Set<String> getQualitys() {
        return this.mQualitys;
    }

    public String[] getSpeakerArray() {
        return DataTool.fromSetToArray(this.mSpeakers);
    }

    public JSONArray getSpeakerJA() {
        return JsonTool.fromSetToJson(this.mSpeakers);
    }

    public Set<String> getSpeakers() {
        return this.mSpeakers;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setDomains(Set<String> set) {
        this.mDomains = set;
    }

    public void setGenders(Set<String> set) {
        this.mGenders = set;
    }

    public void setLanguages(Set<String> set) {
        this.mLanguages = set;
    }

    public void setModelIds(Set<String> set) {
        this.mModelIds = set;
    }

    public void setQualitys(Set<String> set) {
        this.mQualitys = set;
    }

    public void setSpeakers(Set<String> set) {
        this.mSpeakers = set;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public void setDomains(String[] strArr) {
        this.mDomains = DataTool.fromArrayToSet(strArr);
    }

    public void setLanguages(String[] strArr) {
        this.mLanguages = DataTool.fromArrayToSet(strArr);
    }

    public void setQualitys(String[] strArr) {
        this.mQualitys = DataTool.fromArrayToSet(strArr);
    }
}
