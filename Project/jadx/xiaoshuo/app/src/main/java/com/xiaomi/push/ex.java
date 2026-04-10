package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ex {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f301a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f302b;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7931a = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f303c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7932b = 0;
        private boolean f = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f300a = Collections.emptyList();
        private int c = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m335b() {
            return this.f303c;
        }

        public int c() {
            return this.f7931a;
        }

        public int d() {
            return this.f7932b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m338e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m334a() {
            return this.f301a;
        }

        public a b(int i) {
            this.d = true;
            this.f7932b = i;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m336c() {
            return this.f302b;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m337d() {
            return this.d;
        }

        public int e() {
            return this.f300a.size();
        }

        public a a(int i) {
            this.f301a = true;
            this.f7931a = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        public a a(boolean z) {
            this.f302b = true;
            this.f303c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = 0;
            int iB = m334a() ? c.b(1, c()) + 0 : 0;
            if (m336c()) {
                iB += c.a(2, m335b());
            }
            if (m337d()) {
                iB += c.a(3, d());
            }
            if (f()) {
                iB += c.a(4, m338e());
            }
            Iterator<String> it = m333a().iterator();
            while (it.hasNext()) {
                iA += c.a(it.next());
            }
            int size = iB + iA + (m333a().size() * 1);
            this.c = size;
            return size;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public List<String> m333a() {
            return this.f300a;
        }

        public a a(String str) {
            str.getClass();
            if (this.f300a.isEmpty()) {
                this.f300a = new ArrayList();
            }
            this.f300a.add(str);
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m334a()) {
                cVar.m255b(1, c());
            }
            if (m336c()) {
                cVar.m247a(2, m335b());
            }
            if (m337d()) {
                cVar.m242a(3, d());
            }
            if (f()) {
                cVar.m247a(4, m338e());
            }
            Iterator<String> it = m333a().iterator();
            while (it.hasNext()) {
                cVar.m246a(5, it.next());
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) throws d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 8) {
                    a(bVar.c());
                } else if (iM202a == 16) {
                    a(bVar.m208a());
                } else if (iM202a == 24) {
                    b(bVar.m211b());
                } else if (iM202a == 32) {
                    b(bVar.m208a());
                } else if (iM202a != 42) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    a(bVar.m205a());
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
