package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogInListener<T> extends BmobCallback2<T, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(T t2, BmobException bmobException);
}
