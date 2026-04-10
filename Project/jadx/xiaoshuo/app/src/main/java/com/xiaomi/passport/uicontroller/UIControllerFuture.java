package com.xiaomi.passport.uicontroller;

import com.xiaomi.accountsdk.futureservice.ClientFuture;

/* JADX INFO: loaded from: classes8.dex */
public abstract class UIControllerFuture<ModelDataType, UIDataType> extends ClientFuture<ModelDataType, UIDataType> {

    public interface UICallback<UIDataType> extends ClientFuture.ClientCallback<UIDataType> {
    }

    public UIControllerFuture(UICallback<UIDataType> uICallback) {
        super(uICallback);
    }

    public abstract UIDataType convertModelDataToUIData(ModelDataType modeldatatype) throws Throwable;

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture
    public final UIDataType convertServerDataToClientData(ModelDataType modeldatatype) throws Throwable {
        return convertModelDataToUIData(modeldatatype);
    }
}
