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

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements aw<e, EnumC0502e>, Serializable, Cloneable {
    public static final Map<EnumC0502e, bi> d;
    private static final long e = 7501688097813630241L;
    private static final ca f = new ca("ImprintValue");
    private static final bq g = new bq("value", (byte) 11, 1);
    private static final bq h = new bq("ts", (byte) 10, 2);
    private static final bq i = new bq("guid", (byte) 11, 3);
    private static final Map<Class<? extends cd>, ce> j;
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2364a;
    public long b;
    public String c;
    private byte l;
    private EnumC0502e[] m;

    public void k() throws bc {
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0502e.class);
        enumMap.put(EnumC0502e.VALUE, new bi("value", (byte) 2, new bj((byte) 11)));
        enumMap.put(EnumC0502e.TS, new bi("ts", (byte) 2, new bj((byte) 10)));
        enumMap.put(EnumC0502e.GUID, new bi("guid", (byte) 2, new bj((byte) 11)));
        Map<EnumC0502e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bi.a(e.class, mapUnmodifiableMap);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0502e implements bd {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC0502e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (EnumC0502e enumC0502e : EnumSet.allOf(EnumC0502e.class)) {
                d.put(enumC0502e.b(), enumC0502e);
            }
        }

        public static EnumC0502e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0502e b(int i) {
            EnumC0502e enumC0502eA = a(i);
            if (enumC0502eA != null) {
                return enumC0502eA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static EnumC0502e a(String str) {
            return d.get(str);
        }

        EnumC0502e(short s, String str) {
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

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0502e[]{EnumC0502e.VALUE, EnumC0502e.TS, EnumC0502e.GUID};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0502e[]{EnumC0502e.VALUE, EnumC0502e.TS, EnumC0502e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f2364a = eVar.f2364a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f2364a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public String b() {
        return this.f2364a;
    }

    public e a(String str) {
        this.f2364a = str;
        return this;
    }

    public void c() {
        this.f2364a = null;
    }

    public boolean d() {
        return this.f2364a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f2364a = null;
    }

    public long e() {
        return this.b;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.l = at.b(this.l, 0);
    }

    public boolean g() {
        return at.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = at.a(this.l, 0, z);
    }

    public String h() {
        return this.c;
    }

    public e b(String str) {
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

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0502e fieldForId(int i2) {
        return EnumC0502e.a(i2);
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
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f2364a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
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

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends cf<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, e eVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b != 0) {
                    short s = bqVarL.c;
                    if (s != 1) {
                        if (s != 2) {
                            if (s == 3) {
                                if (bqVarL.b == 11) {
                                    eVar.c = bvVar.z();
                                    eVar.c(true);
                                } else {
                                    by.a(bvVar, bqVarL.b);
                                }
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                        } else if (bqVarL.b == 10) {
                            eVar.b = bvVar.x();
                            eVar.b(true);
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else if (bqVarL.b == 11) {
                        eVar.f2364a = bvVar.z();
                        eVar.a(true);
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                    bvVar.m();
                } else {
                    bvVar.k();
                    eVar.k();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, e eVar) throws bc {
            eVar.k();
            bvVar.a(e.f);
            if (eVar.f2364a != null && eVar.d()) {
                bvVar.a(e.g);
                bvVar.a(eVar.f2364a);
                bvVar.c();
            }
            if (eVar.g()) {
                bvVar.a(e.h);
                bvVar.a(eVar.b);
                bvVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                bvVar.a(e.i);
                bvVar.a(eVar.c);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends cg<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, e eVar) throws bc {
            cb cbVar = (cb) bvVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cbVar.a(bitSet, 3);
            if (eVar.d()) {
                cbVar.a(eVar.f2364a);
            }
            if (eVar.g()) {
                cbVar.a(eVar.b);
            }
            if (eVar.j()) {
                cbVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, e eVar) throws bc {
            cb cbVar = (cb) bvVar;
            BitSet bitSetB = cbVar.b(3);
            if (bitSetB.get(0)) {
                eVar.f2364a = cbVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = cbVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.c = cbVar.z();
                eVar.c(true);
            }
        }
    }
}
