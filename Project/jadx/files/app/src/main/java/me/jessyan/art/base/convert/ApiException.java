package me.jessyan.art.base.convert;

/* JADX INFO: loaded from: classes3.dex */
public class ApiException extends RuntimeException {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f21147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f21148t;

    public ApiException(int i2, String str, String str2) {
        super(str2);
        this.f21147s = i2;
        this.f21148t = str2;
    }

    public int f() {
        return this.f21147s;
    }

    public String g() {
        return this.f21148t;
    }

    public ApiException(int i2, String str) {
        super(str);
        this.f21147s = i2;
        this.f21148t = str;
    }
}
