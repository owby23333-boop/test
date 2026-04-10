package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeleteBatchListener extends BmobCallback2<String[], BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(String[] strArr, BmobException bmobException);
}
