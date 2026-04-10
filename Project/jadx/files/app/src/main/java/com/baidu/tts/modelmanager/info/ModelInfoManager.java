package com.baidu.tts.modelmanager.info;

import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.Set;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class ModelInfoManager {
    private ModelMediator mModelMediator;

    public ModelInfoManager(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
    }

    public BasicHandler<String> checkModelsUpdate(JSONArray jSONArray) {
        BasicHandler<String> basicHandler = new BasicHandler<>(new FutureTask(new CheckServerModelsUpdate(jSONArray)));
        basicHandler.start();
        return basicHandler;
    }

    public LibEngineParams getEngineParams() {
        return new LibEngineParams(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new GetLocalModelFileInfosWork(this.mModelMediator.getDbManager(), set)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions, boolean z2) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new GetLocalModelsWork(this.mModelMediator.getDbManager(), conditions, this.mModelMediator, z2)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new GetServerDefaultModelsWork()));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new GetServerModelFileInfosWork(set)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new GetServerModelsWork(conditions)));
        basicHandler.start();
        return basicHandler;
    }
}
