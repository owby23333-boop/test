package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.download.DownloadParams;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ModelManager {
    public Context mContext;
    private ModelMediator mModeMediator;

    public ModelManager(Context context) {
        this.mModeMediator = new ModelMediator(context);
        this.mContext = context;
    }

    private Conditions getConditions(AvailableConditions availableConditions) {
        Conditions engineConditions = getEngineConditions();
        if (engineConditions != null && availableConditions != null) {
            engineConditions.setSpeakers(availableConditions.getSpeakers());
            engineConditions.setGenders(availableConditions.getGenders());
        }
        return engineConditions;
    }

    private Conditions getEngineConditions() {
        Conditions conditions = new Conditions();
        LibEngineParams engineParams = getEngineParams();
        conditions.setVersion(engineParams.getVersion());
        conditions.setDomains(engineParams.getDomain());
        conditions.setLanguages(engineParams.getLanguage());
        conditions.setQualitys(engineParams.getQuality());
        return conditions;
    }

    public String checkModelsUpdate(Set<String> set) {
        return this.mModeMediator.checkModelsUpdate(set);
    }

    public DownloadHandler download(String str, OnDownloadListener onDownloadListener) {
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.setModelId(str);
        downloadParams.setDownloadListener(onDownloadListener);
        return this.mModeMediator.download(downloadParams);
    }

    public LibEngineParams getEngineParams() {
        return this.mModeMediator.getEngineParams();
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> set) {
        return this.mModeMediator.getLocalModelFileInfos(set);
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions) {
        return this.mModeMediator.getLocalModels(conditions, false);
    }

    public BasicHandler<ModelBags> getLocalModelsAvailable(AvailableConditions availableConditions) {
        return this.mModeMediator.getLocalModels(getConditions(availableConditions), true);
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        return this.mModeMediator.getServerDefaultModels();
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> set) {
        return this.mModeMediator.getServerModelFileInfos(set);
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        return this.mModeMediator.getServerModels(conditions);
    }

    public BasicHandler<ModelBags> getServerModelsAvailable(AvailableConditions availableConditions) {
        return getServerModels(getConditions(availableConditions));
    }

    public String getSpeechModelFileAbsPath(String str) {
        return this.mModeMediator.getModelFileAbsPath(KeyEnum.SPEECH_DATA_ID.getFullName(), str);
    }

    public String getTextModelFileAbsPath(String str) {
        return this.mModeMediator.getModelFileAbsPath(KeyEnum.TEXT_DATA_ID.getFullName(), str);
    }

    public boolean isModelFileValid(String str) {
        return this.mModeMediator.isModelFileValid(str);
    }

    public boolean isModelValid(String str) {
        return this.mModeMediator.isModelValid(str);
    }

    public int stop() {
        this.mModeMediator.stop();
        return 0;
    }
}
