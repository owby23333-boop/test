package cn.bmob.v3.listener;

import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public abstract class SQLQueryListener<T> extends BmobCallback2<BmobQueryResult<T>, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(BmobQueryResult<T> bmobQueryResult, BmobException bmobException);
}
