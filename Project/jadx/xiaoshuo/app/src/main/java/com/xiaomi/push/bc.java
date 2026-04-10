package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class bc implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7817b;

    public bc(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f7816a = str;
        this.f7817b = str2;
    }

    @Override // com.xiaomi.push.be
    public String a() {
        return this.f7816a;
    }

    @Override // com.xiaomi.push.be
    public String b() {
        return this.f7817b;
    }
}
