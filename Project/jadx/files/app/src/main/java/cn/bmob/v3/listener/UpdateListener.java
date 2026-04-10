package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class UpdateListener extends BmobCallback1<BmobException> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.bmob.v3.listener.BmobCallback1
    public abstract void done(BmobException bmobException);
}
