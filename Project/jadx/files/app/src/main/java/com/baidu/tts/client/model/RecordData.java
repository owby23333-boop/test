package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.modelmanager.ModelMediator;
import com.umeng.analytics.AnalyticsConfig;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RecordData {
    private static final String TAG = "RecordData";
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    private ModelMediator mModelMediator;

    public class InsertData implements Callable<Integer> {
        private JSONObject data;
        private String mColumnName;
        private String mUuid;

        public InsertData(JSONObject jSONObject, String str, String str2) {
            this.data = jSONObject;
            this.mUuid = str;
            this.mColumnName = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            if (this.data == null && this.mColumnName == null) {
                RecordData.this.mModelMediator.insertStatisticsData(this.mUuid);
            } else {
                RecordData.this.mModelMediator.updataStatisticsData(this.mUuid, this.mColumnName, this.data.toString());
            }
            return 0;
        }
    }

    public RecordData(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
    }

    public void setEndInfo(String str, String str2, int i2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("modeId", str2);
            jSONObject.put("result", i2);
            jSONObject.put("endTime", str3);
            LoggerProxy.d(TAG, "EndInfo json= " + jSONObject.toString());
            this.executorService.submit(new InsertData(jSONObject, str, "endInfo"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setStartInfo(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AnalyticsConfig.RTD_START_TIME, str3);
            jSONObject.put("modeId", str2);
            LoggerProxy.d(TAG, " StartInfo json= " + jSONObject.toString());
            this.executorService.submit(new InsertData(null, str, null));
            this.executorService.submit(new InsertData(jSONObject, str, "startInfo"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
