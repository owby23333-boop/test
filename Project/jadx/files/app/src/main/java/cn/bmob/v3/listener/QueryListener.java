package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class QueryListener<T> extends BmobCallback2<T, BmobException> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(T t2, BmobException bmobException);
}
