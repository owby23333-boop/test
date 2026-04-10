package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class ey {

    public static final class a extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f306a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f309b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f312c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f314d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f316e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f317f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7933a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private long f304a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f305a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f308b = "";

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private String f311c = "";

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private String f313d = "";

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private String f315e = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7934b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private long f307b = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private long f310c = 0;
        private int e = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m345b() {
            return this.f309b;
        }

        public int c() {
            return this.f7933a;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m350d() {
            return this.f314d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m352e() {
            return this.f316e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m354f() {
            return this.f317f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m342a() {
            return this.f306a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m344b() {
            return this.f308b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m348c() {
            return this.f312c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public String m349d() {
            return this.f313d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public String m351e() {
            return this.f315e;
        }

        public int f() {
            return this.d;
        }

        public a a(int i) {
            this.f306a = true;
            this.f7933a = i;
            return this;
        }

        public a b(String str) {
            this.f314d = true;
            this.f308b = str;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public String m347c() {
            return this.f311c;
        }

        public a d(String str) {
            this.f317f = true;
            this.f313d = str;
            return this;
        }

        public a e(String str) {
            this.g = true;
            this.f315e = str;
            return this;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public String m353f() {
            return this.f;
        }

        public a c(String str) {
            this.f316e = true;
            this.f311c = str;
            return this;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public long m339a() {
            return this.f304a;
        }

        public a b(int i) {
            this.h = true;
            this.f7934b = i;
            return this;
        }

        public int d() {
            return this.f7934b;
        }

        public int e() {
            return this.c;
        }

        public a a(long j) {
            this.f309b = true;
            this.f304a = j;
            return this;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public long m343b() {
            return this.f307b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m341a() {
            return this.f305a;
        }

        public a b(long j) {
            this.l = true;
            this.f307b = j;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public long m346c() {
            return this.f310c;
        }

        public a a(String str) {
            this.f312c = true;
            this.f305a = str;
            return this;
        }

        public a c(long j) {
            this.m = true;
            this.f310c = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m342a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m345b()) {
                iA += com.xiaomi.push.c.b(2, m339a());
            }
            if (m348c()) {
                iA += com.xiaomi.push.c.a(3, m341a());
            }
            if (m350d()) {
                iA += com.xiaomi.push.c.a(4, m344b());
            }
            if (m352e()) {
                iA += com.xiaomi.push.c.a(5, m347c());
            }
            if (m354f()) {
                iA += com.xiaomi.push.c.a(6, m349d());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(7, m351e());
            }
            if (h()) {
                iA += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                iA += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                iA += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                iA += com.xiaomi.push.c.a(11, m353f());
            }
            if (l()) {
                iA += com.xiaomi.push.c.b(12, m343b());
            }
            if (m()) {
                iA += com.xiaomi.push.c.b(13, m346c());
            }
            this.e = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public a m340a() {
            this.f317f = false;
            this.f313d = "";
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m342a()) {
                cVar.m242a(1, c());
            }
            if (m345b()) {
                cVar.m256b(2, m339a());
            }
            if (m348c()) {
                cVar.m246a(3, m341a());
            }
            if (m350d()) {
                cVar.m246a(4, m344b());
            }
            if (m352e()) {
                cVar.m246a(5, m347c());
            }
            if (m354f()) {
                cVar.m246a(6, m349d());
            }
            if (g()) {
                cVar.m246a(7, m351e());
            }
            if (h()) {
                cVar.m242a(8, d());
            }
            if (i()) {
                cVar.m242a(9, e());
            }
            if (j()) {
                cVar.m242a(10, f());
            }
            if (k()) {
                cVar.m246a(11, m353f());
            }
            if (l()) {
                cVar.m256b(12, m343b());
            }
            if (m()) {
                cVar.m256b(13, m346c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                switch (iM202a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m211b());
                        break;
                    case 16:
                        a(bVar.m212b());
                        break;
                    case 26:
                        a(bVar.m205a());
                        break;
                    case 34:
                        b(bVar.m205a());
                        break;
                    case 42:
                        c(bVar.m205a());
                        break;
                    case 50:
                        d(bVar.m205a());
                        break;
                    case 58:
                        e(bVar.m205a());
                        break;
                    case 64:
                        b(bVar.m211b());
                        break;
                    case 72:
                        c(bVar.m211b());
                        break;
                    case 80:
                        d(bVar.m211b());
                        break;
                    case 90:
                        f(bVar.m205a());
                        break;
                    case 96:
                        b(bVar.m212b());
                        break;
                    case 104:
                        c(bVar.m212b());
                        break;
                    default:
                        if (!a(bVar, iM202a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    public static final class b extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f318a;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f320c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f321d;
        private boolean e;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f319b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7935a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7936b = 0;
        private int c = 0;
        private int d = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m356b() {
            return this.f318a;
        }

        public int c() {
            return this.f7935a;
        }

        public int d() {
            return this.f7936b;
        }

        public int e() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m355a() {
            return this.f319b;
        }

        public b b(int i) {
            this.f321d = true;
            this.f7936b = i;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m357c() {
            return this.f320c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m358d() {
            return this.f321d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m359e() {
            return this.e;
        }

        public b a(boolean z) {
            this.f318a = true;
            this.f319b = z;
            return this;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m356b() ? 0 + com.xiaomi.push.c.a(1, m355a()) : 0;
            if (m357c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m358d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m359e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            this.d = iA;
            return iA;
        }

        public b a(int i) {
            this.f320c = true;
            this.f7935a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m356b()) {
                cVar.m247a(1, m355a());
            }
            if (m357c()) {
                cVar.m242a(3, c());
            }
            if (m358d()) {
                cVar.m242a(4, d());
            }
            if (m359e()) {
                cVar.m242a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 8) {
                    a(bVar.m208a());
                } else if (iM202a == 24) {
                    a(bVar.m211b());
                } else if (iM202a == 32) {
                    b(bVar.m211b());
                } else if (iM202a != 40) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    c(bVar.m211b());
                }
            }
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }
    }

    public static final class c extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f323a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f324b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f325c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f326d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f327e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f328f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f322a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7938b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7937a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m362b() {
            return this.f7938b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m360a() {
            return this.f322a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m363b() {
            return this.f324b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m364c() {
            return this.f325c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m365d() {
            return this.f326d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m366e() {
            return this.f327e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m367f() {
            return this.f328f;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m361a() {
            return this.f323a;
        }

        public c b(String str) {
            this.f324b = true;
            this.f7938b = str;
            return this;
        }

        public c c(String str) {
            this.f325c = true;
            this.c = str;
            return this;
        }

        public c d(String str) {
            this.f326d = true;
            this.d = str;
            return this;
        }

        public c e(String str) {
            this.f327e = true;
            this.e = str;
            return this;
        }

        public c f(String str) {
            this.f328f = true;
            this.f = str;
            return this;
        }

        public c a(String str) {
            this.f323a = true;
            this.f322a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m361a() ? 0 + com.xiaomi.push.c.a(1, m360a()) : 0;
            if (m363b()) {
                iA += com.xiaomi.push.c.a(2, m362b());
            }
            if (m364c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m365d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m366e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (m367f()) {
                iA += com.xiaomi.push.c.a(6, f());
            }
            this.f7937a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m361a()) {
                cVar.m246a(1, m360a());
            }
            if (m363b()) {
                cVar.m246a(2, m362b());
            }
            if (m364c()) {
                cVar.m246a(3, c());
            }
            if (m365d()) {
                cVar.m246a(4, d());
            }
            if (m366e()) {
                cVar.m246a(5, e());
            }
            if (m367f()) {
                cVar.m246a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7937a < 0) {
                b();
            }
            return this.f7937a;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 10) {
                    a(bVar.m205a());
                } else if (iM202a == 18) {
                    b(bVar.m205a());
                } else if (iM202a == 26) {
                    c(bVar.m205a());
                } else if (iM202a == 34) {
                    d(bVar.m205a());
                } else if (iM202a == 42) {
                    e(bVar.m205a());
                } else if (iM202a != 50) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    f(bVar.m205a());
                }
            }
        }
    }

    public static final class d extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f330a;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f332c;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f331b = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f329a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7940b = "";
        private String c = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7939a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m371b() {
            return this.f330a;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m372c() {
            return this.f332c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m369a() {
            return this.f331b;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m370b() {
            return this.f7940b;
        }

        public String c() {
            return this.c;
        }

        public d a(boolean z) {
            this.f330a = true;
            this.f331b = z;
            return this;
        }

        public d b(String str) {
            this.d = true;
            this.f7940b = str;
            return this;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m368a() {
            return this.f329a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m371b() ? 0 + com.xiaomi.push.c.a(1, m369a()) : 0;
            if (m372c()) {
                iA += com.xiaomi.push.c.a(2, m368a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(3, m370b());
            }
            if (e()) {
                iA += com.xiaomi.push.c.a(4, c());
            }
            this.f7939a = iA;
            return iA;
        }

        public d a(String str) {
            this.f332c = true;
            this.f329a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m371b()) {
                cVar.m247a(1, m369a());
            }
            if (m372c()) {
                cVar.m246a(2, m368a());
            }
            if (d()) {
                cVar.m246a(3, m370b());
            }
            if (e()) {
                cVar.m246a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7939a < 0) {
                b();
            }
            return this.f7939a;
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 8) {
                    a(bVar.m208a());
                } else if (iM202a == 18) {
                    a(bVar.m205a());
                } else if (iM202a == 26) {
                    b(bVar.m205a());
                } else if (iM202a != 34) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    c(bVar.m205a());
                }
            }
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }
    }

    public static final class e extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f333a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f336a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private com.xiaomi.push.a f337b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f339b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f341c;
        private int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f343d;
        private int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f345e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f346f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7941a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f335a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f338b = "";

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private String f340c = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7942b = 0;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private String f342d = "";

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private String f344e = "";
        private String f = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f334a = null;
        private int c = 0;

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.f7782a;
            this.f333a = aVar;
            this.f337b = aVar;
            this.d = 0;
            this.e = -1;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m379b() {
            return this.f339b;
        }

        public int c() {
            return this.f7941a;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m383d() {
            return this.f343d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m385e() {
            return this.f345e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m387f() {
            return this.f346f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m376a() {
            return this.f336a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m378b() {
            return this.f338b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m381c() {
            return this.f341c;
        }

        public int d() {
            return this.f7942b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public String m384e() {
            return this.f344e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public String m386f() {
            return this.f;
        }

        public e a(int i) {
            this.f336a = true;
            this.f7941a = i;
            return this;
        }

        public e b(String str) {
            this.f341c = true;
            this.f338b = str;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public String m380c() {
            return this.f340c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public String m382d() {
            return this.f342d;
        }

        public e e(String str) {
            this.g = true;
            this.f344e = str;
            return this;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public e c(String str) {
            this.f343d = true;
            this.f340c = str;
            return this;
        }

        public e d(String str) {
            this.f346f = true;
            this.f342d = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m375a() {
            return this.f335a;
        }

        public e b(int i) {
            this.f345e = true;
            this.f7942b = i;
            return this;
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.d;
        }

        public e a(String str) {
            this.f339b = true;
            this.f335a = str;
            return this;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e d(int i) {
            this.m = true;
            this.d = i;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public com.xiaomi.push.a m377b() {
            return this.f337b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m374a() {
            return this.f334a;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.l = true;
            this.f337b = aVar;
            return this;
        }

        public e a(b bVar) {
            bVar.getClass();
            this.i = true;
            this.f334a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iB = m376a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m379b()) {
                iB += com.xiaomi.push.c.a(2, m375a());
            }
            if (m381c()) {
                iB += com.xiaomi.push.c.a(3, m378b());
            }
            if (m383d()) {
                iB += com.xiaomi.push.c.a(4, m380c());
            }
            if (m385e()) {
                iB += com.xiaomi.push.c.a(5, d());
            }
            if (m387f()) {
                iB += com.xiaomi.push.c.a(6, m382d());
            }
            if (g()) {
                iB += com.xiaomi.push.c.a(7, m384e());
            }
            if (h()) {
                iB += com.xiaomi.push.c.a(8, m386f());
            }
            if (i()) {
                iB += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m374a());
            }
            if (j()) {
                iB += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                iB += com.xiaomi.push.c.a(11, m373a());
            }
            if (l()) {
                iB += com.xiaomi.push.c.a(12, m377b());
            }
            if (m()) {
                iB += com.xiaomi.push.c.a(13, f());
            }
            this.e = iB;
            return iB;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m373a() {
            return this.f333a;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.k = true;
            this.f333a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m376a()) {
                cVar.m255b(1, c());
            }
            if (m379b()) {
                cVar.m246a(2, m375a());
            }
            if (m381c()) {
                cVar.m246a(3, m378b());
            }
            if (m383d()) {
                cVar.m246a(4, m380c());
            }
            if (m385e()) {
                cVar.m242a(5, d());
            }
            if (m387f()) {
                cVar.m246a(6, m382d());
            }
            if (g()) {
                cVar.m246a(7, m384e());
            }
            if (h()) {
                cVar.m246a(8, m386f());
            }
            if (i()) {
                cVar.m245a(9, (com.xiaomi.push.e) m374a());
            }
            if (j()) {
                cVar.m242a(10, e());
            }
            if (k()) {
                cVar.m244a(11, m373a());
            }
            if (l()) {
                cVar.m244a(12, m377b());
            }
            if (m()) {
                cVar.m242a(13, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                switch (iM202a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m205a());
                        break;
                    case 26:
                        b(bVar.m205a());
                        break;
                    case 34:
                        c(bVar.m205a());
                        break;
                    case 40:
                        b(bVar.m211b());
                        break;
                    case 50:
                        d(bVar.m205a());
                        break;
                    case 58:
                        e(bVar.m205a());
                        break;
                    case 66:
                        f(bVar.m205a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m211b());
                        break;
                    case 90:
                        a(bVar.m204a());
                        break;
                    case 98:
                        b(bVar.m204a());
                        break;
                    case 104:
                        d(bVar.m211b());
                        break;
                    default:
                        if (!a(bVar, iM202a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    public static final class f extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f349a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f350b;
        private boolean c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f348a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7944b = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f347a = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7943a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m391b() {
            return this.f7944b;
        }

        public boolean c() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m389a() {
            return this.f348a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m392b() {
            return this.f350b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m390a() {
            return this.f349a;
        }

        public f b(String str) {
            this.f350b = true;
            this.f7944b = str;
            return this;
        }

        public f a(String str) {
            this.f349a = true;
            this.f348a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m390a() ? 0 + com.xiaomi.push.c.a(1, m389a()) : 0;
            if (m392b()) {
                iA += com.xiaomi.push.c.a(2, m391b());
            }
            if (c()) {
                iA += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m388a());
            }
            this.f7943a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m388a() {
            return this.f347a;
        }

        public f a(b bVar) {
            bVar.getClass();
            this.c = true;
            this.f347a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m390a()) {
                cVar.m246a(1, m389a());
            }
            if (m392b()) {
                cVar.m246a(2, m391b());
            }
            if (c()) {
                cVar.m245a(3, (com.xiaomi.push.e) m388a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7943a < 0) {
                b();
            }
            return this.f7943a;
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 10) {
                    a(bVar.m205a());
                } else if (iM202a == 18) {
                    b(bVar.m205a());
                } else if (iM202a != 26) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }
    }

    public static final class g extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f352a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f353b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f354c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f351a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7946b = "";
        private String c = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7945a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m395b() {
            return this.f7946b;
        }

        public String c() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m393a() {
            return this.f351a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m396b() {
            return this.f353b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m397c() {
            return this.f354c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m394a() {
            return this.f352a;
        }

        public g b(String str) {
            this.f353b = true;
            this.f7946b = str;
            return this;
        }

        public g c(String str) {
            this.f354c = true;
            this.c = str;
            return this;
        }

        public g a(String str) {
            this.f352a = true;
            this.f351a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m394a() ? 0 + com.xiaomi.push.c.a(1, m393a()) : 0;
            if (m396b()) {
                iA += com.xiaomi.push.c.a(2, m395b());
            }
            if (m397c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            this.f7945a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m394a()) {
                cVar.m246a(1, m393a());
            }
            if (m396b()) {
                cVar.m246a(2, m395b());
            }
            if (m397c()) {
                cVar.m246a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7945a < 0) {
                b();
            }
            return this.f7945a;
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 10) {
                    a(bVar.m205a());
                } else if (iM202a == 18) {
                    b(bVar.m205a());
                } else if (iM202a != 26) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    c(bVar.m205a());
                }
            }
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }
    }

    public static final class h extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f356a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f357b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7947a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f355a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7948b = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m400b() {
            return this.f357b;
        }

        public int c() {
            return this.f7947a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m399a() {
            return this.f356a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m399a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m400b()) {
                iA += com.xiaomi.push.c.a(2, m398a());
            }
            this.f7948b = iA;
            return iA;
        }

        public h a(int i) {
            this.f356a = true;
            this.f7947a = i;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m398a() {
            return this.f355a;
        }

        public h a(String str) {
            this.f357b = true;
            this.f355a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m399a()) {
                cVar.m242a(1, c());
            }
            if (m400b()) {
                cVar.m246a(2, m398a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7948b < 0) {
                b();
            }
            return this.f7948b;
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 8) {
                    a(bVar.m211b());
                } else if (iM202a != 18) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    a(bVar.m205a());
                }
            }
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }
    }

    public static final class i extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f359a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f358a = com.xiaomi.push.a.f7782a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7949a = -1;

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m402a() ? 0 + com.xiaomi.push.c.a(1, m401a()) : 0;
            this.f7949a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m401a() {
            return this.f358a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m402a() {
            return this.f359a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f359a = true;
            this.f358a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m402a()) {
                cVar.m244a(1, m401a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7949a < 0) {
                b();
            }
            return this.f7949a;
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a != 10) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    a(bVar.m204a());
                }
            }
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }
    }

    public static final class j extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7951b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f360a = com.xiaomi.push.a.f7782a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f361a = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7950a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m406b() {
            return this.f7951b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m403a() {
            return this.f360a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m405a() ? 0 + com.xiaomi.push.c.a(1, m403a()) : 0;
            if (m406b()) {
                iA += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m404a());
            }
            this.f7950a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m405a() {
            return this.f362a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f362a = true;
            this.f360a = aVar;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m404a() {
            return this.f361a;
        }

        public j a(b bVar) {
            bVar.getClass();
            this.f7951b = true;
            this.f361a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m405a()) {
                cVar.m244a(1, m403a());
            }
            if (m406b()) {
                cVar.m245a(2, (com.xiaomi.push.e) m404a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7950a < 0) {
                b();
            }
            return this.f7950a;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 10) {
                    a(bVar.m204a());
                } else if (iM202a != 18) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }
    }

    public static final class k extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f365a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f368b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f364a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f367b = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private long f363a = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private long f366b = 0;
        private boolean f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7952a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7953b = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m411b() {
            return this.f367b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m413c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m408a() {
            return this.f364a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m412b() {
            return this.f368b;
        }

        public int c() {
            return this.f7952a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m409a() {
            return this.f365a;
        }

        public k b(String str) {
            this.f368b = true;
            this.f367b = str;
            return this;
        }

        public k a(String str) {
            this.f365a = true;
            this.f364a = str;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public long m410b() {
            return this.f366b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public long m407a() {
            return this.f363a;
        }

        public k b(long j) {
            this.d = true;
            this.f366b = j;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f363a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m409a() ? 0 + com.xiaomi.push.c.a(1, m408a()) : 0;
            if (m412b()) {
                iA += com.xiaomi.push.c.a(2, m411b());
            }
            if (m413c()) {
                iA += com.xiaomi.push.c.a(3, m407a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(4, m410b());
            }
            if (f()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(6, c());
            }
            this.f7953b = iA;
            return iA;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        public k a(int i) {
            this.g = true;
            this.f7952a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m409a()) {
                cVar.m246a(1, m408a());
            }
            if (m412b()) {
                cVar.m246a(2, m411b());
            }
            if (m413c()) {
                cVar.m243a(3, m407a());
            }
            if (d()) {
                cVar.m243a(4, m410b());
            }
            if (f()) {
                cVar.m247a(5, e());
            }
            if (g()) {
                cVar.m242a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f7953b < 0) {
                b();
            }
            return this.f7953b;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM202a = bVar.m202a();
                if (iM202a == 0) {
                    return this;
                }
                if (iM202a == 10) {
                    a(bVar.m205a());
                } else if (iM202a == 18) {
                    b(bVar.m205a());
                } else if (iM202a == 24) {
                    a(bVar.m203a());
                } else if (iM202a == 32) {
                    b(bVar.m203a());
                } else if (iM202a == 40) {
                    a(bVar.m208a());
                } else if (iM202a != 48) {
                    if (!a(bVar, iM202a)) {
                        return this;
                    }
                } else {
                    a(bVar.m211b());
                }
            }
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }
    }
}
