package com.baidu.tts.modelmanager.info;

import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.network.HttpClientUtil;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetServerDefaultModelsWork implements Callable<ModelBags> {
    private String getEntity() {
        try {
            JSONObject jSONObject = new JSONObject(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
            jSONObject.put(KeyEnum.FUNCTION.getShortName(), "getDefaultList");
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void cancel() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ModelBags call() throws Exception {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String url = UrlEnum.MODEL_SERVER.getUrl();
        String entity = getEntity();
        GetListHttpHandler getListHttpHandler = new GetListHttpHandler();
        httpClientUtil.post(url, entity, getListHttpHandler);
        return getListHttpHandler.getModelBags();
    }
}
