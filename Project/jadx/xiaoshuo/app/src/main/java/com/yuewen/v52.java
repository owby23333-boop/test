package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class v52<T> implements u52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f18889b;

    public v52(String str, T t) {
        this.f18888a = str;
        this.f18889b = t;
    }

    public T a() {
        return this.f18889b;
    }

    @Override // com.yuewen.u52
    public String getName() {
        return this.f18888a;
    }

    public String toString() {
        return "NamedValue{mName='" + this.f18888a + "', mValue=" + this.f18889b + '}';
    }
}
