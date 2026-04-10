package com.duokan.reader.ui.reading.importflow;

import com.duokan.reader.ui.store.data.cms.Data;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AwardStatus extends Data {
    public String adId;
    public boolean finish;
    public boolean finishToday;
    public int progress;
    public boolean taskFinish;
    public int totalStep;

    private AwardStatus(JSONObject jSONObject) {
        this.adId = jSONObject.optString("adId");
        this.progress = jSONObject.optInt("progress");
        this.totalStep = jSONObject.optInt("totalStep");
        this.finish = jSONObject.optBoolean("finish");
        this.taskFinish = jSONObject.optBoolean("taskFinish");
        this.finishToday = jSONObject.optBoolean("finishToday");
    }

    public static List<AwardStatus> parseFromJsonArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new AwardStatus(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }
}
