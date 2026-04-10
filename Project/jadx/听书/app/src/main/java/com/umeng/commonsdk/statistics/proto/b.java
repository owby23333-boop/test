package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
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
/* JADX INFO: loaded from: classes4.dex */
public class b implements aw<b, e>, Serializable, Cloneable {
    public static final Map<e, bi> d;
    private static final long e = -6496538196005191531L;
    private static final ca f = new ca("IdSnapshot");
    private static final bq g = new bq("identity", (byte) 11, 1);
    private static final bq h = new bq("ts", (byte) 10, 2);
    private static final bq i = new bq("version", (byte) 8, 3);
    private static final Map<Class<? extends cd>, ce> j;
    private static final int k = 0;
    private static final int l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2358a;
    public long b;
    public int c;
    private byte m;

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(cf.class, new C0499b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bi("identity", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.TS, new bi("ts", (byte) 1, new bj((byte) 10)));
        enumMap.put(e.VERSION, new bi("version", (byte) 1, new bj((byte) 8)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bi.a(b.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements bd {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.f;
        }
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(String str, long j2, int i2) {
        this();
        this.f2358a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f2358a = bVar.f2358a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f2358a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public String b() {
        return this.f2358a;
    }

    public b a(String str) {
        this.f2358a = str;
        return this;
    }

    public void c() {
        this.f2358a = null;
    }

    public boolean d() {
        return this.f2358a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f2358a = null;
    }

    public long e() {
        return this.b;
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.m = at.b(this.m, 0);
    }

    public boolean g() {
        return at.a(this.m, 0);
    }

    public void b(boolean z) {
        this.m = at.a(this.m, 0, z);
    }

    public int h() {
        return this.c;
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public void i() {
        this.m = at.b(this.m, 1);
    }

    public boolean j() {
        return at.a(this.m, 1);
    }

    public void c(boolean z) {
        this.m = at.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        j.get(bvVar.D()).b().b(bvVar, this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        j.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(identity:");
        String str = this.f2358a;
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
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    public void k() throws bc {
        if (this.f2358a == null) {
            throw new bw("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class C0499b implements ce {
        private C0499b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class a extends cf<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, b bVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b == 0) {
                    break;
                }
                short s = bqVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (bqVarL.b == 8) {
                                bVar.c = bvVar.w();
                                bVar.c(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else if (bqVarL.b == 10) {
                        bVar.b = bvVar.x();
                        bVar.b(true);
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                } else if (bqVarL.b == 11) {
                    bVar.f2358a = bvVar.z();
                    bVar.a(true);
                } else {
                    by.a(bvVar, bqVarL.b);
                }
                bvVar.m();
            }
            bvVar.k();
            if (!bVar.g()) {
                throw new bw("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (!bVar.j()) {
                throw new bw("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            bVar.k();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, b bVar) throws bc {
            bVar.k();
            bvVar.a(b.f);
            if (bVar.f2358a != null) {
                bvVar.a(b.g);
                bvVar.a(bVar.f2358a);
                bvVar.c();
            }
            bvVar.a(b.h);
            bvVar.a(bVar.b);
            bvVar.c();
            bvVar.a(b.i);
            bvVar.a(bVar.c);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class c extends cg<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, b bVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(bVar.f2358a);
            cbVar.a(bVar.b);
            cbVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, b bVar) throws bc {
            cb cbVar = (cb) bvVar;
            bVar.f2358a = cbVar.z();
            bVar.a(true);
            bVar.b = cbVar.x();
            bVar.b(true);
            bVar.c = cbVar.w();
            bVar.c(true);
        }
    }
}
