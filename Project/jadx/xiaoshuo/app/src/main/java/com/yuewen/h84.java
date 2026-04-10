package com.yuewen;

import com.duokan.account.UserAccount;
import com.yuewen.i3;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class h84<T extends i3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11960b;
    public final T c;

    public h84(String str, String str2, T t) {
        this.f11959a = str;
        this.f11960b = str2;
        this.c = t;
    }

    public T a() {
        return this.c;
    }

    public Map<String, String> b() {
        return UserAccount.V(this.f11959a, this.f11960b);
    }

    public Map<String, String> c() {
        return UserAccount.V(null, this.f11960b);
    }

    public String d() {
        return this.f11959a;
    }

    public String e() {
        return this.f11960b;
    }
}
