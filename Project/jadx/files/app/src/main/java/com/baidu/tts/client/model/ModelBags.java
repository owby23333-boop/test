package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelBags {
    private List<ModelInfo> mModelInfos;
    private TtsError mTtsError;

    public void addModelInfo(ModelInfo modelInfo) {
        if (this.mModelInfos == null) {
            this.mModelInfos = new ArrayList();
        }
        this.mModelInfos.add(modelInfo);
    }

    public List<ModelInfo> getModelInfos() {
        return this.mModelInfos;
    }

    public TtsError getTtsError() {
        return this.mTtsError;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.mModelInfos);
    }

    public void parseJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            ModelInfo modelInfo = new ModelInfo();
            modelInfo.parseJson(jSONObjectOptJSONObject);
            addModelInfo(modelInfo);
        }
    }

    public void setList(List<Map<String, String>> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> map : list) {
                ModelInfo modelInfo = new ModelInfo();
                modelInfo.setMap(map);
                arrayList.add(modelInfo);
            }
            this.mModelInfos = arrayList;
        }
    }

    public void setModelInfos(List<ModelInfo> list) {
        this.mModelInfos = list;
    }

    public void setTtsError(TtsError ttsError) {
        this.mTtsError = ttsError;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            Iterator<ModelInfo> it = this.mModelInfos.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray;
    }
}
