package com.yuewen;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11979b;
    public long c;
    public float d;
    public float e;
    public b f;
    public d g;
    public d h;
    public e i;
    public g j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11981b;
        public int c;
        public int d;

        public int a() {
            return this.d;
        }

        public int b() {
            return this.f11980a;
        }

        public int c() {
            return this.f11981b;
        }

        public int d() {
            return this.c;
        }

        public void e(int i) {
            this.d = i;
        }

        public void f(int i) {
            this.f11980a = i;
        }

        public void g(int i) {
            this.f11981b = i;
        }

        public void h(int i) {
            this.c = i;
        }

        public b(int i, int i2, int i3, int i4) {
            this.f11980a = i;
            this.f11981b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11982a = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11983b = -1.0f;
        public long c = -1;
        public float d = -1.0f;
        public float e = -1.0f;
        public b f;
        public d g;
        public d h;
        public e i;
        public g j;

        public hc a() {
            return new hc(this.f11982a, this.f11983b, this.c, this.d, this.e, this.f, this.g, this.i, this.j, this.h);
        }

        public c b(float f) {
            this.f11982a = f;
            return this;
        }

        public c c(int i, int i2, int i3, int i4) {
            this.h = new d(i, i2, i3, i4);
            return this;
        }

        public c d(int i, int i2, int i3, int i4) {
            this.f = new b(i, i2, i3, i4);
            return this;
        }

        public c e(long j) {
            this.c = j;
            return this;
        }

        public c f(int i, int i2) {
            this.i = new e(i, i2);
            return this;
        }

        public c g(float f) {
            this.f11983b = f;
            return this;
        }

        public c h(int i, int i2, int i3, int i4) {
            this.g = new d(i, i2, i3, i4);
            return this;
        }

        public c i(float f) {
            this.d = f;
            return this;
        }

        public c j(float f) {
            this.e = f;
            return this;
        }

        public c k(f... fVarArr) {
            this.j = new g(fVarArr);
            return this;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11985b;
        public int c;
        public int d;

        public float a() {
            return this.f11984a;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return (this.f11984a << 24) | (this.f11985b << 16) | (this.c << 8) | this.d;
        }

        public int d() {
            return this.c;
        }

        public int e() {
            return this.f11985b;
        }

        public void f(int i) {
            this.f11984a = i;
        }

        public void g(int i) {
            this.d = i;
        }

        public void h(int i) {
            this.c = i;
        }

        public void i(int i) {
            this.f11985b = i;
        }

        public d(int i, int i2, int i3, int i4) {
            this.f11984a = i;
            this.f11985b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11987b;

        public int a() {
            return this.f11986a;
        }

        public int b() {
            return this.f11987b;
        }

        public void c(int i) {
            this.f11986a = i;
        }

        public void d(int i) {
            this.f11987b = i;
        }

        public e(int i, int i2) {
            this.f11986a = i;
            this.f11987b = i2;
        }
    }

    public static class f {
        public static final int f = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11989b;
        public float d;
        public float c = -1.0f;
        public float e = -1.0f;

        public float a() {
            return this.f11989b;
        }

        public float b() {
            return this.c;
        }

        public String c() {
            return this.f11988a;
        }

        public float d() {
            return this.d;
        }

        public float e() {
            return this.e;
        }

        public f f(float f2) {
            this.f11989b = f2;
            return this;
        }

        public f g(float f2) {
            this.c = f2;
            return this;
        }

        public f h(String str) {
            this.f11988a = str;
            return this;
        }

        public f i(float f2) {
            this.d = f2;
            return this;
        }

        public f j(float f2) {
            this.e = f2;
            return this;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f11990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f11991b;

        public g() {
        }

        public Object[] a() {
            return this.f11990a;
        }

        public Object[] b() {
            return this.f11991b;
        }

        public final Object[] c(boolean z, f... fVarArr) {
            int i;
            if (fVarArr == null || fVarArr.length == 0) {
                return null;
            }
            int length = fVarArr.length * 3;
            Object[] objArr = new Object[length];
            int i2 = 0;
            for (f fVar : fVarArr) {
                int i3 = i2 + 1;
                objArr[i2] = fVar.c();
                if (z) {
                    i = i3 + 1;
                    objArr[i3] = Float.valueOf(fVar.a());
                    if (fVar.b() != -1.0f) {
                        objArr[i] = Float.valueOf(fVar.b());
                        i++;
                    }
                } else {
                    i = i3 + 1;
                    objArr[i3] = Float.valueOf(fVar.d());
                    if (fVar.e() != -1.0f) {
                        i2 = i + 1;
                        objArr[i] = Float.valueOf(fVar.e());
                    }
                }
                i2 = i;
            }
            return (i2 >= length || objArr[i2] != null) ? objArr : Arrays.copyOfRange(objArr, 0, i2);
        }

        public g d(f... fVarArr) {
            this.f11990a = c(true, fVarArr);
            return this;
        }

        public g e(Object... objArr) {
            this.f11990a = objArr;
            return this;
        }

        public g f(f... fVarArr) {
            this.f11991b = c(false, fVarArr);
            return this;
        }

        public g g(Object... objArr) {
            this.f11991b = objArr;
            return this;
        }

        public g(f... fVarArr) {
            this.f11990a = c(true, fVarArr);
            this.f11991b = c(false, fVarArr);
        }
    }

    public float a() {
        return this.f11978a;
    }

    public d b() {
        return this.h;
    }

    public b c() {
        return this.f;
    }

    public long d() {
        return this.c;
    }

    public e e() {
        return this.i;
    }

    public float f() {
        return this.f11979b;
    }

    public d g() {
        return this.g;
    }

    public float h() {
        return this.d;
    }

    public float i() {
        return this.e;
    }

    public g j() {
        return this.j;
    }

    public hc() {
        this.f11978a = -1.0f;
        this.f11979b = -1.0f;
        this.c = -1L;
        this.d = -1.0f;
        this.e = -1.0f;
    }

    public hc(float f2, float f3, long j, float f4, float f5, b bVar, d dVar, e eVar, g gVar, d dVar2) {
        this.f11978a = f2;
        this.f11979b = f3;
        this.c = j;
        this.f = bVar;
        this.g = dVar;
        this.i = eVar;
        this.d = f4;
        this.e = f5;
        this.j = gVar;
        this.h = dVar2;
    }
}
