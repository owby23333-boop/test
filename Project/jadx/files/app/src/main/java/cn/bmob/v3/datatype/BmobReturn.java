package cn.bmob.v3.datatype;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public class BmobReturn<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BmobException f2162e;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private T f2163t;

    public BmobReturn(T t2, BmobException bmobException) {
        this.f2163t = t2;
        this.f2162e = bmobException;
    }

    public BmobException getE() {
        return this.f2162e;
    }

    public T getT() {
        return this.f2163t;
    }

    public void setE(BmobException bmobException) {
        this.f2162e = bmobException;
    }

    public void setT(T t2) {
        this.f2163t = t2;
    }

    public BmobReturn() {
    }
}
