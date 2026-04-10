package com.anythink.core.common.e;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ae {
    public int a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<String, a> f7142f;

    public static class a {
        public String a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7145e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f7146f;
    }

    public final a a(String str) {
        ConcurrentHashMap<String, a> concurrentHashMap = this.f7142f;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }
}
