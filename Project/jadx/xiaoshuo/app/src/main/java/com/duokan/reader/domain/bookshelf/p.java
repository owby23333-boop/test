package com.duokan.reader.domain.bookshelf;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4559b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4561b;
        public long c;
        public long d = -1;
        public long e = -1;
        public String f;
        public int g;

        public p h() {
            return new p(this);
        }

        public a i(long j) {
            this.e = j;
            return this;
        }

        public a j(String str) {
            this.f4560a = str;
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
            this.f4561b = str;
            return this;
        }

        public a o(long j) {
            this.d = j;
            return this;
        }
    }

    public String toString() {
        return "id = " + this.f4558a + ", title = " + this.f4559b + ",\u3000price = " + this.c + ",\u3000updateTime = " + this.d + ", duration = " + this.e;
    }

    public p(a aVar) {
        this.f4558a = aVar.f4560a;
        this.f4559b = aVar.f4561b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }
}
