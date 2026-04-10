package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile eo f7924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private en f293a;

    public static eo a() {
        if (f7924a == null) {
            synchronized (eo.class) {
                if (f7924a == null) {
                    f7924a = new eo();
                }
            }
        }
        return f7924a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public en m327a() {
        return this.f293a;
    }

    public void a(en enVar) {
        this.f293a = enVar;
    }
}
