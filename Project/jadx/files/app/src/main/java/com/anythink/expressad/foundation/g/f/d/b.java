package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.j;
import com.anythink.expressad.foundation.g.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private j a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<a> f10525c = new LinkedList<>();
    private int b = 3;

    public class a {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f10526c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f10527d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f10528e = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f10530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private File f10531h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private com.anythink.expressad.foundation.g.f.e<Void> f10532i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.anythink.expressad.foundation.g.f.d.a f10533j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f10534k;

        /* synthetic */ a(b bVar, File file, String str, com.anythink.expressad.foundation.g.f.e eVar, byte b2) {
            this(file, str, (com.anythink.expressad.foundation.g.f.e<Void>) eVar);
        }

        static /* synthetic */ int c(a aVar) {
            aVar.f10534k = 3;
            return 3;
        }

        private int d() {
            return this.f10534k;
        }

        private boolean e() {
            int i2 = this.f10534k;
            if (i2 == 0) {
                this.f10534k = 2;
                b.this.b();
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            this.f10533j.e();
            this.f10534k = 2;
            b.this.b();
            return true;
        }

        private boolean f() {
            if (this.f10534k != 2) {
                return false;
            }
            this.f10534k = 0;
            b.this.b();
            return true;
        }

        public final boolean a() {
            return this.f10534k == 1;
        }

        private a(b bVar, String str, String str2, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
            this(new File(str), str2, eVar);
        }

        static /* synthetic */ boolean a(a aVar) {
            if (aVar.f10534k != 0) {
                return false;
            }
            aVar.f10533j = new com.anythink.expressad.foundation.g.f.d.a(aVar.f10531h, aVar.f10530g);
            aVar.f10533j.a((com.anythink.expressad.foundation.g.f.e) aVar.new AnonymousClass1());
            aVar.f10534k = 1;
            b.this.a.a((i) aVar.f10533j);
            return true;
        }

        private boolean c() {
            if (this.f10534k != 0) {
                return false;
            }
            this.f10533j = new com.anythink.expressad.foundation.g.f.d.a(this.f10531h, this.f10530g);
            this.f10533j.a((com.anythink.expressad.foundation.g.f.e) new AnonymousClass1());
            this.f10534k = 1;
            b.this.a.a((i) this.f10533j);
            return true;
        }

        public final boolean b() {
            int i2 = this.f10534k;
            if (i2 == 4 || i2 == 3) {
                return false;
            }
            if (i2 == 1) {
                this.f10533j.e();
            }
            this.f10534k = 4;
            b.a(b.this, this);
            return true;
        }

        private a(File file, String str, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
            this.f10531h = file;
            this.f10532i = eVar;
            this.f10530g = str;
        }

        /* JADX INFO: renamed from: com.anythink.expressad.foundation.g.f.d.b$a$1, reason: invalid class name */
        final class AnonymousClass1 extends com.anythink.expressad.foundation.g.f.f<Void> {
            boolean a;

            AnonymousClass1() {
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a() {
                if (this.a) {
                    return;
                }
                a.c(a.this);
                a.this.f10532i.a();
                a aVar = a.this;
                b.a(b.this, aVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void b() {
                a.this.f10532i.b();
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void c() {
                a.this.f10532i.c();
                this.a = true;
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(k kVar) {
                if (this.a) {
                    return;
                }
                a.this.f10532i.a(kVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(com.anythink.expressad.foundation.g.f.a.a aVar) {
                if (this.a) {
                    return;
                }
                a.this.f10532i.a(aVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(long j2, long j3) {
                a.this.f10532i.a(j2, j3);
            }
        }
    }

    public b(j jVar) {
        this.a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            int i2 = 0;
            Iterator<a> it = this.f10525c.iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    i2++;
                }
            }
            if (i2 >= this.b) {
                return;
            }
            Iterator<a> it2 = this.f10525c.iterator();
            while (it2.hasNext()) {
                if (a.a(it2.next()) && (i2 = i2 + 1) == this.b) {
                    return;
                }
            }
        }
    }

    public final a a(File file, String str, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
        a aVar = new a(this, file, str, eVar, (byte) 0);
        synchronized (this) {
            this.f10525c.add(aVar);
        }
        b();
        return aVar;
    }

    private a a(String str, String str2, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
        return a(new File(str), str2, eVar);
    }

    private void a(a aVar) {
        synchronized (this) {
            this.f10525c.remove(aVar);
        }
        b();
    }

    public final void a() {
        synchronized (this) {
            while (!this.f10525c.isEmpty()) {
                this.f10525c.get(0).b();
            }
        }
    }

    private static com.anythink.expressad.foundation.g.f.d.a a(File file, String str) {
        return new com.anythink.expressad.foundation.g.f.d.a(file, str);
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        synchronized (bVar) {
            bVar.f10525c.remove(aVar);
        }
        bVar.b();
    }
}
