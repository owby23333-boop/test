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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements av<a, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<e, bh> f20120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f20121f = 9132678615281394583L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bz f20122g = new bz("IdJournal");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bp f20123h = new bp("domain", (byte) 11, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bp f20124i = new bp("old_id", (byte) 11, 2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final bp f20125j = new bp("new_id", (byte) 11, 3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bp f20126k = new bp("ts", (byte) 10, 4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f20127l = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20128m = 0;
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20130d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f20131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private e[] f20132o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdJournal.java */
    private static class C0555a extends ce<a> {
        private C0555a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, a aVar) throws bb {
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
                            if (s2 != 4) {
                                bx.a(buVar, b);
                            } else if (b == 10) {
                                aVar.f20130d = buVar.x();
                                aVar.d(true);
                            } else {
                                bx.a(buVar, b);
                            }
                        } else if (b == 11) {
                            aVar.f20129c = buVar.z();
                            aVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 11) {
                        aVar.b = buVar.z();
                        aVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    aVar.a = buVar.z();
                    aVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, a aVar) throws bb {
            aVar.n();
            buVar.a(a.f20122g);
            if (aVar.a != null) {
                buVar.a(a.f20123h);
                buVar.a(aVar.a);
                buVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                buVar.a(a.f20124i);
                buVar.a(aVar.b);
                buVar.c();
            }
            if (aVar.f20129c != null) {
                buVar.a(a.f20125j);
                buVar.a(aVar.f20129c);
                buVar.c();
            }
            buVar.a(a.f20126k);
            buVar.a(aVar.f20130d);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0555a b() {
            return new C0555a();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class c extends cf<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(aVar.a);
            caVar.a(aVar.f20129c);
            caVar.a(aVar.f20130d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (aVar.g()) {
                caVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            aVar.a = caVar.z();
            aVar.a(true);
            aVar.f20129c = caVar.z();
            aVar.c(true);
            aVar.f20130d = caVar.x();
            aVar.d(true);
            if (caVar.b(1).get(0)) {
                aVar.b = caVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
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
        f20127l.put(ce.class, new b());
        f20127l.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bh("domain", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.OLD_ID, new bh("old_id", (byte) 2, new bi((byte) 11)));
        enumMap.put(e.NEW_ID, new bh("new_id", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.TS, new bh("ts", (byte) 1, new bi((byte) 10)));
        f20120e = Collections.unmodifiableMap(enumMap);
        bh.a(a.class, f20120e);
    }

    public a() {
        this.f20131n = (byte) 0;
        this.f20132o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
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
        this.b = null;
        this.f20129c = null;
        d(false);
        this.f20130d = 0L;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.f20129c;
    }

    public void i() {
        this.f20129c = null;
    }

    public boolean j() {
        return this.f20129c != null;
    }

    public long k() {
        return this.f20130d;
    }

    public void l() {
        this.f20131n = as.b(this.f20131n, 0);
    }

    public boolean m() {
        return as.a(this.f20131n, 0);
    }

    public void n() throws bb {
        if (this.a == null) {
            throw new bv("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f20129c != null) {
            return;
        }
        throw new bv("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f20127l.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
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
        String str3 = this.f20129c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f20130d);
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f20127l.get(buVar.D()).b().a(buVar, this);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements bc {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f20135e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final short f20137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f20138g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f20135e.put(eVar.b(), eVar);
            }
        }

        e(short s2, String str) {
            this.f20137f = s2;
            this.f20138g = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return DOMAIN;
            }
            if (i2 == 2) {
                return OLD_ID;
            }
            if (i2 == 3) {
                return NEW_ID;
            }
            if (i2 != 4) {
                return null;
            }
            return TS;
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
            return this.f20138g;
        }

        public static e a(String str) {
            return f20135e.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f20137f;
        }
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public a c(String str) {
        this.f20129c = str;
        return this;
    }

    public void d(boolean z2) {
        this.f20131n = as.a(this.f20131n, 0, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f20129c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.f20129c = str2;
        this.f20130d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f20130d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.f20131n = (byte) 0;
        this.f20132o = new e[]{e.OLD_ID};
        this.f20131n = aVar.f20131n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.f20129c = aVar.f20129c;
        }
        this.f20130d = aVar.f20130d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f20131n = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
