package com.baidu.tts.modelmanager.info;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.network.HttpClientUtil;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetServerModelsWork implements Callable<ModelBags> {
    private static final String TAG = "GetServerModelsWork";
    private Conditions mConditions;

    public GetServerModelsWork(Conditions conditions) {
        this.mConditions = conditions;
    }

    private String getEntity() {
        JSONObject jSONConditions = this.mConditions.getJSONConditions();
        try {
            jSONConditions.put(KeyEnum.IVERSION.getFullName(), "2");
            jSONConditions.put(KeyEnum.FUNCTION.getShortName(), "getList");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = jSONConditions.toString();
        LoggerProxy.d(TAG, "getlist params=" + string);
        return string;
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
