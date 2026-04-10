package com.baidu.tts.modelmanager.info;

import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class GetLocalModelsWork implements Callable<ModelBags> {
    private boolean isFilter;
    private Conditions mConditions;
    private DbManager mDbManager;
    private ModelMediator mModelMediator;

    public GetLocalModelsWork(DbManager dbManager, Conditions conditions, ModelMediator modelMediator, boolean z2) {
        this.mConditions = conditions;
        this.mDbManager = dbManager;
        this.mModelMediator = modelMediator;
        this.isFilter = z2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ModelBags call() throws Exception {
        List<Map<String, String>> listSelectModelBags = this.mDbManager.selectModelBags(this.mConditions);
        ModelBags modelBags = new ModelBags();
        modelBags.setList(listSelectModelBags);
        if (this.isFilter) {
            Iterator<ModelInfo> it = modelBags.getModelInfos().iterator();
            while (it.hasNext()) {
                if (!this.mModelMediator.isModelValid(it.next().getServerId())) {
                    it.remove();
                }
            }
        }
        return modelBags;
    }
}
