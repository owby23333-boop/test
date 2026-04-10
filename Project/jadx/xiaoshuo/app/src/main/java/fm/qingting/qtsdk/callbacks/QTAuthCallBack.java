package fm.qingting.qtsdk.callbacks;

import fm.qingting.qtsdk.QTException;
import fm.qingting.qtsdk.entity.UserToken;

/* JADX INFO: loaded from: classes8.dex */
public interface QTAuthCallBack {
    void onCancel();

    void onComplete(UserToken response);

    void onException(QTException e);
}
