package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
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

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements av<d, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bh> f20169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f20170e = 2846460275012375038L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bz f20171f = new bz("Imprint");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bp f20172g = new bp("property", cb.f19602k, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bp f20173h = new bp("version", (byte) 8, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bp f20174i = new bp("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f20175j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20176k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20177c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f20178l;

    /* JADX INFO: compiled from: Imprint.java */
    private static class a extends ce<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, d dVar) throws bb {
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
                        } else if (b == 11) {
                            dVar.f20177c = buVar.z();
                            dVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = buVar.w();
                        dVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 13) {
                    br brVarN = buVar.n();
                    dVar.a = new HashMap(brVarN.f19583c * 2);
                    for (int i2 = 0; i2 < brVarN.f19583c; i2++) {
                        String strZ = buVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(buVar);
                        dVar.a.put(strZ, eVar);
                    }
                    buVar.o();
                    dVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, d dVar) throws bb {
            dVar.l();
            buVar.a(d.f20171f);
            if (dVar.a != null) {
                buVar.a(d.f20172g);
                buVar.a(new br((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            buVar.a(d.f20173h);
            buVar.a(dVar.b);
            buVar.c();
            if (dVar.f20177c != null) {
                buVar.a(d.f20174i);
                buVar.a(dVar.f20177c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class c extends cf<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            caVar.a(dVar.b);
            caVar.a(dVar.f20177c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            dVar.a = new HashMap(brVar.f19583c * 2);
            for (int i2 = 0; i2 < brVar.f19583c; i2++) {
                String strZ = caVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(caVar);
                dVar.a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.b = caVar.w();
            dVar.b(true);
            dVar.f20177c = caVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Imprint.java */
    private static class C0558d implements cd {
        private C0558d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f20175j.put(ce.class, new b());
        f20175j.put(cf.class, new C0558d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bh("property", (byte) 1, new bk(cb.f19602k, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.CHECKSUM, new bh("checksum", (byte) 1, new bi((byte) 11)));
        f20169d = Collections.unmodifiableMap(enumMap);
        bh.a(d.class, f20169d);
    }

    public d() {
        this.f20178l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.f20177c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.f20178l = as.b(this.f20178l, 0);
    }

    public boolean h() {
        return as.a(this.f20178l, 0);
    }

    public String i() {
        return this.f20177c;
    }

    public void j() {
        this.f20177c = null;
    }

    public boolean k() {
        return this.f20177c != null;
    }

    public void l() throws bb {
        if (this.a == null) {
            throw new bv("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f20177c != null) {
            return;
        }
        throw new bv("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f20175j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
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
        String str = this.f20177c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f20175j.get(buVar.D()).b().a(buVar, this);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements bc {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f20180d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f20182e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f20183f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f20180d.put(eVar.b(), eVar);
            }
        }

        e(short s2, String str) {
            this.f20182e = s2;
            this.f20183f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return PROPERTY;
            }
            if (i2 == 2) {
                return VERSION;
            }
            if (i2 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f20183f;
        }

        public static e a(String str) {
            return f20180d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f20182e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void b(boolean z2) {
        this.f20178l = as.a(this.f20178l, 0, z2);
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f20177c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.f20177c = str;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f20178l = (byte) 0;
        this.f20178l = dVar.f20178l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = map;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.f20177c = dVar.f20177c;
        }
    }

    public d a(String str) {
        this.f20177c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f20178l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
