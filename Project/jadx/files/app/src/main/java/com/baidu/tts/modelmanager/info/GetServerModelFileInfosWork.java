package com.baidu.tts.modelmanager.info;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.tools.JsonTool;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetServerModelFileInfosWork implements Callable<ModelFileBags> {
    private static final String TAG = "GetServerModelFileInfosWork";
    private Set<String> mIds;

    public GetServerModelFileInfosWork(Set<String> set) {
        this.mIds = set;
    }

    private String getEntity() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KeyEnum.FUNCTION.getShortName(), "getURL");
            jSONObject.put(KeyEnum.IVERSION.getFullName(), "2");
            jSONObject.put(KeyEnum.ID.getFullName(), JsonTool.fromSetToJson(this.mIds));
            LoggerProxy.d(TAG, "geturl params=" + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void cancel() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ModelFileBags call() throws Exception {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String str = UrlEnum.MODEL_SERVER.getUrl() + "https=1";
        String entity = getEntity();
        GetModelFileInfosHttpHandler getModelFileInfosHttpHandler = new GetModelFileInfosHttpHandler();
        httpClientUtil.post(str, entity, getModelFileInfosHttpHandler);
        return getModelFileInfosHttpHandler.getModelFileBags();
    }
}
