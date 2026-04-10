package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.IDataFactory;
import cn.kuaipan.android.kss.IKssUploadRequestResult;

/* JADX INFO: loaded from: classes17.dex */
public class MiCloudDataFactory implements IDataFactory {
    @Override // cn.kuaipan.android.kss.IDataFactory
    public IKssUploadRequestResult createUploadRequestResult(String str) throws KscException {
        return MiCloudUploadRequestResult.create(str);
    }
}
