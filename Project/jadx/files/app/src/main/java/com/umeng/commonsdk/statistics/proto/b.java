package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements av<b, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bh> f20139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f20140e = -6496538196005191531L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bz f20141f = new bz("IdSnapshot");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bp f20142g = new bp("identity", (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bp f20143h = new bp("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bp f20144i = new bp("version", (byte) 8, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f20145j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20146k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20147l = 1;
    public String a;
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20148c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte f20149m;

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class a extends ce<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, b bVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    break;
                }
                short s2 = bpVarL.f19582c;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            bx.a(buVar, b);
                        } else if (b == 8) {
                            bVar.f20148c = buVar.w();
                            bVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = buVar.x();
                        bVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = buVar.z();
                    bVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (!bVar.g()) {
                throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, b bVar) throws bb {
            bVar.k();
            buVar.a(b.f20141f);
            if (bVar.a != null) {
                buVar.a(b.f20142g);
                buVar.a(bVar.a);
                buVar.c();
            }
            buVar.a(b.f20143h);
            buVar.a(bVar.b);
            buVar.c();
            buVar.a(b.f20144i);
            buVar.a(bVar.f20148c);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class C0556b implements cd {
        private C0556b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class c extends cf<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(bVar.a);
            caVar.a(bVar.b);
            caVar.a(bVar.f20148c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            bVar.a = caVar.z();
            bVar.a(true);
            bVar.b = caVar.x();
            bVar.b(true);
            bVar.f20148c = caVar.w();
            bVar.c(true);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f20145j.put(ce.class, new C0556b());
        f20145j.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bh("identity", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.TS, new bh("ts", (byte) 1, new bi((byte) 10)));
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 8)));
        f20139d = Collections.unmodifiableMap(enumMap);
        bh.a(b.class, f20139d);
    }

    public b() {
        this.f20149m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.f20148c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.f20149m = as.b(this.f20149m, 0);
    }

    public boolean g() {
        return as.a(this.f20149m, 0);
    }

    public int h() {
        return this.f20148c;
    }

    public void i() {
        this.f20149m = as.b(this.f20149m, 1);
    }

    public boolean j() {
        return as.a(this.f20149m, 1);
    }

    public void k() throws bb {
        if (this.a != null) {
            return;
        }
        throw new bv("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f20145j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f20148c);
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f20145j.get(buVar.D()).b().a(buVar, this);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements bc {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f20151d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f20153e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f20154f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f20151d.put(eVar.b(), eVar);
            }
        }

        e(short s2, String str) {
            this.f20153e = s2;
            this.f20154f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return IDENTITY;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i2) {
            e eVarA = a(i2);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f20154f;
        }

        public static e a(String str) {
            return f20151d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f20153e;
        }
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z2) {
        this.f20149m = as.a(this.f20149m, 0, z2);
    }

    public void c(boolean z2) {
        this.f20149m = as.a(this.f20149m, 1, z2);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.f20148c = i2;
        c(true);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f20148c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.f20149m = (byte) 0;
        this.f20149m = bVar.f20149m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.f20148c = bVar.f20148c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f20149m = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
