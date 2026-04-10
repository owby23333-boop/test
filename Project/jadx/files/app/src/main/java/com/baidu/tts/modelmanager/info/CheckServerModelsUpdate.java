package com.baidu.tts.modelmanager.info;

import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.network.ResponseHandler;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CheckServerModelsUpdate implements Callable<String> {
    private static final String KEY_RESPONSE_ERROR_CODE = "err_no";
    private static final String KEY_RESPONSE_UPDATE_INFO = "info";
    private static final String TAG = "GetServerModelsWork";
    private JSONArray jsonArray;

    public CheckServerModelsUpdate(JSONArray jSONArray) {
        this.jsonArray = jSONArray;
    }

    private String getEntity() throws UnsupportedEncodingException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KeyEnum.FUNCTION.getShortName(), "checkUpdate");
            jSONObject.put(KeyEnum.MODELSINFO.getShortName(), this.jsonArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void cancel() {
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        final String[] strArr = {""};
        new HttpClientUtil().post(UrlEnum.MODEL_SERVER.getUrl(), getEntity(), new ResponseHandler() { // from class: com.baidu.tts.modelmanager.info.CheckServerModelsUpdate.1
            @Override // com.baidu.tts.network.ResponseHandler
            public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
                LoggerProxy.d(CheckServerModelsUpdate.TAG, "onFileure statusCode:" + i2);
            }

            @Override // com.baidu.tts.network.ResponseHandler
            public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
                String str2 = new String(bArr);
                LoggerProxy.d(CheckServerModelsUpdate.TAG, "statusCode: " + i2 + " response: " + new String(bArr));
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if ("0".equals(jSONObject.optString(CheckServerModelsUpdate.KEY_RESPONSE_ERROR_CODE))) {
                        strArr[0] = jSONObject.optString("info");
                    }
                } catch (Exception e2) {
                    LoggerProxy.d(CheckServerModelsUpdate.TAG, "parse:" + e2.toString());
                }
            }
        });
        return strArr[0];
    }
}
