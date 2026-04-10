package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFileBags {
    private List<ModelFileInfo> mModelFileInfos;
    private TtsError mTtsError;

    public void addFileInfo(ModelFileInfo modelFileInfo) {
        if (this.mModelFileInfos == null) {
            this.mModelFileInfos = new ArrayList();
        }
        this.mModelFileInfos.add(modelFileInfo);
    }

    public void generateAbsPath(Context context) {
        List<ModelFileInfo> list = this.mModelFileInfos;
        if (list != null) {
            Iterator<ModelFileInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().generateAbsPath(context);
            }
        }
    }

    public ModelFileInfo getModelFileInfo(int i2) {
        List<ModelFileInfo> list = this.mModelFileInfos;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    public List<ModelFileInfo> getModelFileInfos() {
        return this.mModelFileInfos;
    }

    public TtsError getTtsError() {
        return this.mTtsError;
    }

    public String getUrl(int i2) {
        ModelFileInfo modelFileInfo = getModelFileInfo(i2);
        if (modelFileInfo != null) {
            return modelFileInfo.getUrl();
        }
        return null;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.mModelFileInfos);
    }

    public void parseJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            ModelFileInfo modelFileInfo = new ModelFileInfo();
            modelFileInfo.parseJson(jSONObjectOptJSONObject);
            addFileInfo(modelFileInfo);
        }
    }

    public void setList(List<Map<String, String>> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            ModelFileInfo modelFileInfo = new ModelFileInfo();
            modelFileInfo.setMap(map);
            arrayList.add(modelFileInfo);
        }
        this.mModelFileInfos = arrayList;
    }

    public void setModelFileInfos(List<ModelFileInfo> list) {
        this.mModelFileInfos = list;
    }

    public void setTtsError(TtsError ttsError) {
        this.mTtsError = ttsError;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            Iterator<ModelFileInfo> it = this.mModelFileInfos.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray;
    }
}
