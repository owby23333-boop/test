package com.baidu.tts.modelmanager.info;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.DbManager;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class GetLocalModelFileInfosWork implements Callable<ModelFileBags> {
    private DbManager mDbManager;
    private Set<String> mIds;

    public GetLocalModelFileInfosWork(DbManager dbManager, Set<String> set) {
        this.mIds = set;
        this.mDbManager = dbManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public ModelFileBags call() throws Exception {
        List<Map<String, String>> listSelectModelFileInfos = this.mDbManager.selectModelFileInfos(this.mIds);
        ModelFileBags modelFileBags = new ModelFileBags();
        modelFileBags.setList(listSelectModelFileInfos);
        return modelFileBags;
    }
}
