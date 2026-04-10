package com.yuewen;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8921b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8923b;
        public long c;
        public long d = -1;
        public long e = -1;
        public String f;
        public int g;

        public b0 h() {
            return new b0(this);
        }

        public a i(long j) {
            this.e = j;
            return this;
        }

        public a j(String str) {
            this.f8922a = str;
            return this;
        }

        public a k(int i) {
            this.g = i;
            return this;
        }

        public a l(String str) {
            this.f = str;
            return this;
        }

        public a m(long j) {
            this.c = j;
            return this;
        }

        public a n(String str) {
            this.f8923b = str;
            return this;
        }

        public a o(long j) {
            this.d = j;
            return this;
        }
    }

    public String toString() {
        return "id = " + this.f8920a + ", title = " + this.f8921b + ",\u3000price = " + this.c + ",\u3000updateTime = " + this.d + ", duration = " + this.e;
    }

    public b0(a aVar) {
        this.f8920a = aVar.f8922a;
        this.f8921b = aVar.f8923b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }
}
