package com.yuewen;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes17.dex */
public class g94 {
    public static final String m = ".gz";
    public static final int n = 3;
    public static final long o = 5242880;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z84 f11516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f11517b;
    public final long c;
    public final File d;
    public File e;
    public File f;
    public final boolean g;
    public int h;
    public final boolean i;
    public final List<File> j;
    public boolean k;
    public final h94 l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f11518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11519b;
        public boolean e;
        public h94 f;
        public String i;
        public long c = 5242880;
        public int d = 1;
        public boolean g = false;
        public final Map<String, String> h = new HashMap();

        public a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("File path must not be null!");
            }
            this.f11518a = new File(str);
            this.i = str;
        }

        public a j(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.h.put(str, str2);
            }
            return this;
        }

        public g94 k() {
            return new g94(this);
        }

        public a l(boolean z) {
            this.g = z;
            return this;
        }

        public a m(boolean z) {
            this.e = z;
            return this;
        }

        public a n(boolean z) {
            this.f11519b = z;
            return this;
        }

        public a o(boolean z, long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("cuteSize must greater than 0");
            }
            this.f11519b = z;
            this.c = j;
            return this;
        }

        public a p(int i) {
            if (i > 3) {
                throw new IllegalArgumentException("retries must less than or equal three");
            }
            this.d = i;
            return this;
        }

        public a q(h94 h94Var) {
            this.f = h94Var;
            return this;
        }
    }

    public g94(a aVar) {
        z84 z84Var = new z84();
        this.f11516a = z84Var;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = false;
        File file = aVar.f11518a;
        this.d = file;
        this.e = file;
        arrayList.add(file);
        this.i = aVar.f11519b;
        this.c = aVar.c;
        this.h = aVar.d;
        this.l = aVar.f;
        this.g = aVar.e;
        this.k = aVar.g;
        this.f11517b = aVar.h;
        z84Var.n("slice_" + file.getName());
        z84Var.g = aVar.i;
    }

    public String a() {
        return this.d.getPath().concat(m);
    }

    public int b() {
        return this.h;
    }

    public File c() {
        return this.d;
    }

    public Map<String, String> d() {
        return this.f11517b;
    }

    public List<File> e() {
        return this.j;
    }

    public File f() {
        return this.f;
    }

    public long g() {
        return this.c;
    }

    public z84 h() {
        return this.f11516a;
    }

    public int i() {
        long length = this.e.length();
        long j = this.c;
        int i = (int) (length / j);
        return length % j != 0 ? i + 1 : i;
    }

    public h94 j() {
        return this.l;
    }

    public File k() {
        return this.e;
    }

    public boolean l() {
        return this.k;
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return this.i;
    }

    public void o(File file) {
        this.f = file;
    }

    public void p(File file) {
        this.e = file;
    }

    public Future<g94> q() {
        return cl2.o(new i94(this));
    }
}
