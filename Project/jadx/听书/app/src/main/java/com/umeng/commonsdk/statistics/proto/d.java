package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bs;
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

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements aw<d, e>, Serializable, Cloneable {
    public static final Map<e, bi> d;
    private static final long e = 2846460275012375038L;
    private static final ca f = new ca("Imprint");
    private static final bq g = new bq("property", (byte) 13, 1);
    private static final bq h = new bq("version", (byte) 8, 2);
    private static final bq i = new bq("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cd>, ce> j;
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f2362a;
    public int b;
    public String c;
    private byte l;

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(cf.class, new b());
        map.put(cg.class, new C0501d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bi("property", (byte) 1, new bl((byte) 13, new bj((byte) 11), new bn((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bi("version", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 1, new bj((byte) 11)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bi.a(d.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements bd {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");

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
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
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

    public d() {
        this.l = (byte) 0;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f2362a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f2362a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f2362a = map;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f2362a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f2362a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f2362a == null) {
            this.f2362a = new HashMap();
        }
        this.f2362a.put(str, eVar);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f2362a;
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f2362a = map;
        return this;
    }

    public void d() {
        this.f2362a = null;
    }

    public boolean e() {
        return this.f2362a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f2362a = null;
    }

    public int f() {
        return this.b;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public void g() {
        this.l = at.b(this.l, 0);
    }

    public boolean h() {
        return at.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = at.a(this.l, 0, z);
    }

    public String i() {
        return this.c;
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
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
        StringBuilder sb = new StringBuilder("Imprint(property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f2362a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public void l() throws bc {
        if (this.f2362a == null) {
            throw new bw("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bw("Required field 'checksum' was not present! Struct: " + toString());
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
            this.l = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class a extends cf<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, d dVar) throws bc {
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
                            if (bqVarL.b == 11) {
                                dVar.c = bvVar.z();
                                dVar.c(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else if (bqVarL.b == 8) {
                        dVar.b = bvVar.w();
                        dVar.b(true);
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                } else if (bqVarL.b == 13) {
                    bs bsVarN = bvVar.n();
                    dVar.f2362a = new HashMap(bsVarN.c * 2);
                    for (int i = 0; i < bsVarN.c; i++) {
                        String strZ = bvVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(bvVar);
                        dVar.f2362a.put(strZ, eVar);
                    }
                    bvVar.o();
                    dVar.a(true);
                } else {
                    by.a(bvVar, bqVarL.b);
                }
                bvVar.m();
            }
            bvVar.k();
            if (!dVar.h()) {
                throw new bw("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            dVar.l();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, d dVar) throws bc {
            dVar.l();
            bvVar.a(d.f);
            if (dVar.f2362a != null) {
                bvVar.a(d.g);
                bvVar.a(new bs((byte) 11, (byte) 12, dVar.f2362a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f2362a.entrySet()) {
                    bvVar.a(entry.getKey());
                    entry.getValue().write(bvVar);
                }
                bvVar.e();
                bvVar.c();
            }
            bvVar.a(d.h);
            bvVar.a(dVar.b);
            bvVar.c();
            if (dVar.c != null) {
                bvVar.a(d.i);
                bvVar.a(dVar.c);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Imprint.java */
    private static class C0501d implements ce {
        private C0501d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class c extends cg<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, d dVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(dVar.f2362a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f2362a.entrySet()) {
                cbVar.a(entry.getKey());
                entry.getValue().write(cbVar);
            }
            cbVar.a(dVar.b);
            cbVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, d dVar) throws bc {
            cb cbVar = (cb) bvVar;
            bs bsVar = new bs((byte) 11, (byte) 12, cbVar.w());
            dVar.f2362a = new HashMap(bsVar.c * 2);
            for (int i = 0; i < bsVar.c; i++) {
                String strZ = cbVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cbVar);
                dVar.f2362a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.b = cbVar.w();
            dVar.b(true);
            dVar.c = cbVar.z();
            dVar.c(true);
        }
    }
}
