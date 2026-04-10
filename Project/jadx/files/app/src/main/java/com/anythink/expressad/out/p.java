package com.anythink.expressad.out;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public interface c {
        void a(int i2);

        void a(com.anythink.expressad.foundation.d.c cVar, String str);

        void a(j jVar);

        void a(j jVar, String str);

        boolean a();

        void b(j jVar);

        void b(j jVar, String str);

        void c(j jVar);

        void d(j jVar);
    }

    public static class d {
        private int a;
        private int b;

        private d(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        private int a() {
            return this.a;
        }

        private int b() {
            return this.b;
        }

        private void a(int i2) {
            this.a = i2;
        }

        private void b(int i2) {
            this.b = i2;
        }
    }

    public interface e extends c {
        void b();
    }
}
