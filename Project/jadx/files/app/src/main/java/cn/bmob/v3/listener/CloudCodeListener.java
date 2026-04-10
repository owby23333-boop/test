package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloudCodeListener extends BmobCallback2<Object, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(Object obj, BmobException bmobException);
}
