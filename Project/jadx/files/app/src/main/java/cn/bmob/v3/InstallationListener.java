package cn.bmob.v3;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobCallback2;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstallationListener<T> extends BmobCallback2<T, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(T t2, BmobException bmobException);
}
