package com.baidu.tts.modelmanager.info;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.network.JsonResponseHandler;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetListHttpHandler extends JsonResponseHandler {
    private static final String TAG = "GetListHttpHandler";
    private ModelBags mModelBags;
    private TtsError mTtsError;

    public ModelBags getModelBags() {
        return this.mModelBags;
    }

    public TtsError getTtsError() {
        return this.mTtsError;
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, Throwable th) {
        LoggerProxy.d(TAG, "onFailure1");
        this.mTtsError = TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, i2, str, th);
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, JSONObject jSONObject) {
        LoggerProxy.d(TAG, "onSuccess response=" + jSONObject);
        int iOptInt = jSONObject.optInt(KeyEnum.ERROR_NUMBER.getShortName());
        String strOptString = jSONObject.optString(KeyEnum.ERROR_MESSAGE.getShortName());
        if (iOptInt != 0 && iOptInt != -1004) {
            this.mTtsError = TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_SERVER_ERROR, iOptInt, strOptString);
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(KeyEnum.DATA_LIST.getFullName());
        this.mModelBags = new ModelBags();
        this.mModelBags.parseJson(jSONArrayOptJSONArray);
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        LoggerProxy.d(TAG, "onFailure2");
        this.mTtsError = TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, i2, jSONObject != null ? jSONObject.toString() : null, th);
    }
}
