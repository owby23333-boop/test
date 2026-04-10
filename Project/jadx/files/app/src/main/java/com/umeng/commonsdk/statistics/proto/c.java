package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements av<c, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bh> f20155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f20156e = -5764118265293965743L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bz f20157f = new bz("IdTracking");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bp f20158g = new bp("snapshots", cb.f19602k, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bp f20159h = new bp("journals", cb.f19604m, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bp f20160i = new bp("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f20161j = new HashMap();
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20162c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e[] f20163k;

    /* JADX INFO: compiled from: IdTracking.java */
    private static class a extends ce<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, c cVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    buVar.k();
                    cVar.n();
                    return;
                }
                short s2 = bpVarL.f19582c;
                int i2 = 0;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            cVar.f20162c = buVar.z();
                            cVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 15) {
                        bq bqVarP = buVar.p();
                        cVar.b = new ArrayList(bqVarP.b);
                        while (i2 < bqVarP.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(buVar);
                            cVar.b.add(aVar);
                            i2++;
                        }
                        buVar.q();
                        cVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 13) {
                    br brVarN = buVar.n();
                    cVar.a = new HashMap(brVarN.f19583c * 2);
                    while (i2 < brVarN.f19583c) {
                        String strZ = buVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(buVar);
                        cVar.a.put(strZ, bVar);
                        i2++;
                    }
                    buVar.o();
                    cVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, c cVar) throws bb {
            cVar.n();
            buVar.a(c.f20157f);
            if (cVar.a != null) {
                buVar.a(c.f20158g);
                buVar.a(new br((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                buVar.a(c.f20159h);
                buVar.a(new bq((byte) 12, cVar.b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(buVar);
                }
                buVar.f();
                buVar.c();
            }
            if (cVar.f20162c != null && cVar.m()) {
                buVar.a(c.f20160i);
                buVar.a(cVar.f20162c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdTracking.java */
    private static class C0557c extends cf<c> {
        private C0557c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            caVar.a(bitSet, 2);
            if (cVar.j()) {
                caVar.a(cVar.b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(caVar);
                }
            }
            if (cVar.m()) {
                caVar.a(cVar.f20162c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            cVar.a = new HashMap(brVar.f19583c * 2);
            for (int i2 = 0; i2 < brVar.f19583c; i2++) {
                String strZ = caVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(caVar);
                cVar.a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = caVar.b(2);
            if (bitSetB.get(0)) {
                bq bqVar = new bq((byte) 12, caVar.w());
                cVar.b = new ArrayList(bqVar.b);
                for (int i3 = 0; i3 < bqVar.b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(caVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f20162c = caVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0557c b() {
            return new C0557c();
        }
    }

    static {
        f20161j.put(ce.class, new b());
        f20161j.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new bh("snapshots", (byte) 1, new bk(cb.f19602k, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new bh("journals", (byte) 2, new bj(cb.f19604m, new bm((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new bh("checksum", (byte) 2, new bi((byte) 11)));
        f20155d = Collections.unmodifiableMap(enumMap);
        bh.a(c.class, f20155d);
    }

    public c() {
        this.f20163k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        this.b = null;
        this.f20162c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.f20162c;
    }

    public void l() {
        this.f20162c = null;
    }

    public boolean m() {
        return this.f20162c != null;
    }

    public void n() throws bb {
        if (this.a != null) {
            return;
        }
        throw new bv("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f20161j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f20162c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f20161j.get(buVar.D()).b().a(buVar, this);
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public enum e implements bc {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f20165d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f20167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f20168f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f20165d.put(eVar.b(), eVar);
            }
        }

        e(short s2, String str) {
            this.f20167e = s2;
            this.f20168f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return SNAPSHOTS;
            }
            if (i2 == 2) {
                return JOURNALS;
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
            return this.f20168f;
        }

        public static e a(String str) {
            return f20165d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f20167e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
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
        this.f20162c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.f20163k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.f20162c = cVar.f20162c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(String str) {
        this.f20162c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
