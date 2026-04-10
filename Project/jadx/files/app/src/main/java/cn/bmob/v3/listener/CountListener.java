package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CountListener extends BmobCallback2<Integer, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(Integer num, BmobException bmobException);
}
