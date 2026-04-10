package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11375b;
    public int c;
    public long d;
    public int e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11377b;
        public int c;
        public long d;
        public int e;

        public b(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("remoteServerUrl==null");
            }
            this.f11376a = str;
            this.f11377b = 800;
            this.c = 50;
            this.d = 33554432L;
            this.e = 1;
        }

        public g a() {
            return new g(this);
        }
    }

    public g(b bVar) {
        this.f11374a = bVar.f11376a;
        this.f11375b = bVar.f11377b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
    }
}
