package com.baidu.tts.statistics;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.network.JsonResponseHandler;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UploadStatisticsHandler extends JsonResponseHandler {
    private static final String TAG = "UploadStatisticsHandler";
    private int result = -1;
    private TtsError ttsError;

    public int getResult() {
        return this.result;
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        this.ttsError = TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, i2, jSONObject != null ? jSONObject.toString() : null, th);
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt(KeyEnum.ERROR_NUMBER.getShortName());
        String strOptString = jSONObject.optString(KeyEnum.ERROR_MESSAGE.getShortName());
        if (iOptInt == 0) {
            this.result = iOptInt;
        } else {
            this.ttsError = TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_SERVER_ERROR, iOptInt, strOptString);
        }
    }
}
