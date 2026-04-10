package cn.bmob.v3.listener;

import cn.bmob.v3.exception.BmobException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class QueryListListener<T> extends BmobCallback2<List<T>, BmobException> {
    @Override // cn.bmob.v3.listener.BmobCallback2
    public abstract void done(List<T> list, BmobException bmobException);
}
