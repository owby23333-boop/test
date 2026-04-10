package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class UploadFileListener extends BmobErrorCallback<Void> {
    public abstract void done(BmobException bmobException);

    public void onProgress(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bmob.v3.listener.BmobErrorCallback
    public final void done(Void r1, BmobException bmobException) {
        done(bmobException);
    }
}
