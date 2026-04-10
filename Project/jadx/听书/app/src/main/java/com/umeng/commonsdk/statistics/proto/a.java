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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements aw<a, e>, Serializable, Cloneable {
    public static final Map<e, bi> e;
    private static final long f = 9132678615281394583L;
    private static final ca g = new ca("IdJournal");
    private static final bq h = new bq("domain", (byte) 11, 1);
    private static final bq i = new bq("old_id", (byte) 11, 2);
    private static final bq j = new bq("new_id", (byte) 11, 3);
    private static final bq k = new bq("ts", (byte) 10, 4);
    private static final Map<Class<? extends cd>, ce> l;
    private static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2356a;
    public String b;
    public String c;
    public long d;
    private byte n;
    private e[] o;

    static {
        HashMap map = new HashMap();
        l = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bi("domain", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.OLD_ID, new bi("old_id", (byte) 2, new bj((byte) 11)));
        enumMap.put(e.NEW_ID, new bi("new_id", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.TS, new bi("ts", (byte) 1, new bj((byte) 10)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = mapUnmodifiableMap;
        bi.a(a.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements bd {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");

        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                e.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return e.get(str);
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.f;
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.g;
        }
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(String str, String str2, long j2) {
        this();
        this.f2356a = str;
        this.c = str2;
        this.d = j2;
        d(true);
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f2356a = aVar.f2356a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f2356a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
    }

    public String b() {
        return this.f2356a;
    }

    public a a(String str) {
        this.f2356a = str;
        return this;
    }

    public void c() {
        this.f2356a = null;
    }

    public boolean d() {
        return this.f2356a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f2356a = null;
    }

    public String e() {
        return this.b;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public String h() {
        return this.c;
    }

    public a c(String str) {
        this.c = str;
        return this;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public long k() {
        return this.d;
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public void l() {
        this.n = at.b(this.n, 0);
    }

    public boolean m() {
        return at.a(this.n, 0);
    }

    public void d(boolean z) {
        this.n = at.a(this.n, 0, z);
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        l.get(bvVar.D()).b().b(bvVar, this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        l.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(domain:");
        String str = this.f2356a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    public void n() throws bc {
        if (this.f2356a == null) {
            throw new bw("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bw("Required field 'new_id' was not present! Struct: " + toString());
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
            this.n = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0498a b() {
            return new C0498a();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdJournal.java */
    private static class C0498a extends cf<a> {
        private C0498a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, a aVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b == 0) {
                    break;
                }
                short s = bqVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s == 4) {
                                if (bqVarL.b == 10) {
                                    aVar.d = bvVar.x();
                                    aVar.d(true);
                                } else {
                                    by.a(bvVar, bqVarL.b);
                                }
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                        } else if (bqVarL.b == 11) {
                            aVar.c = bvVar.z();
                            aVar.c(true);
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else if (bqVarL.b == 11) {
                        aVar.b = bvVar.z();
                        aVar.b(true);
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                } else if (bqVarL.b == 11) {
                    aVar.f2356a = bvVar.z();
                    aVar.a(true);
                } else {
                    by.a(bvVar, bqVarL.b);
                }
                bvVar.m();
            }
            bvVar.k();
            if (!aVar.m()) {
                throw new bw("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            aVar.n();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, a aVar) throws bc {
            aVar.n();
            bvVar.a(a.g);
            if (aVar.f2356a != null) {
                bvVar.a(a.h);
                bvVar.a(aVar.f2356a);
                bvVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                bvVar.a(a.i);
                bvVar.a(aVar.b);
                bvVar.c();
            }
            if (aVar.c != null) {
                bvVar.a(a.j);
                bvVar.a(aVar.c);
                bvVar.c();
            }
            bvVar.a(a.k);
            bvVar.a(aVar.d);
            bvVar.c();
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class c extends cg<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, a aVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(aVar.f2356a);
            cbVar.a(aVar.c);
            cbVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cbVar.a(bitSet, 1);
            if (aVar.g()) {
                cbVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, a aVar) throws bc {
            cb cbVar = (cb) bvVar;
            aVar.f2356a = cbVar.z();
            aVar.a(true);
            aVar.c = cbVar.z();
            aVar.c(true);
            aVar.d = cbVar.x();
            aVar.d(true);
            if (cbVar.b(1).get(0)) {
                aVar.b = cbVar.z();
                aVar.b(true);
            }
        }
    }
}
