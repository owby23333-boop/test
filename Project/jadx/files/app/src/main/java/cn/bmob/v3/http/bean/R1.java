package cn.bmob.v3.http.bean;

import cn.bmob.v3.exception.BmobException;

/* JADX INFO: loaded from: classes.dex */
public class R1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BmobException f2165e;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Boolean f2166r;

    public R1() {
    }

    public BmobException getE() {
        return this.f2165e;
    }

    public Boolean getR() {
        return this.f2166r;
    }

    public R1 setE(BmobException bmobException) {
        this.f2165e = bmobException;
        return this;
    }

    public R1 setR(Boolean bool) {
        this.f2166r = bool;
        return this;
    }

    public String toString() {
        return "R1{r=" + this.f2166r + ", e=" + this.f2165e + '}';
    }

    public R1(Boolean bool, BmobException bmobException) {
        this.f2166r = bool;
        this.f2165e = bmobException;
    }
}
