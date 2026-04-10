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

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements av<e, EnumC0559e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0559e, bh> f20184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f20185e = 7501688097813630241L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bz f20186f = new bz("ImprintValue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bp f20187g = new bp("value", (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bp f20188h = new bp("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bp f20189i = new bp("guid", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f20190j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20191k = 0;
    public String a;
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20192c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f20193l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private EnumC0559e[] f20194m;

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends ce<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, e eVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    buVar.k();
                    eVar.k();
                    return;
                }
                short s2 = bpVarL.f19582c;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            eVar.f20192c = buVar.z();
                            eVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = buVar.x();
                        eVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = buVar.z();
                    eVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, e eVar) throws bb {
            eVar.k();
            buVar.a(e.f20186f);
            if (eVar.a != null && eVar.d()) {
                buVar.a(e.f20187g);
                buVar.a(eVar.a);
                buVar.c();
            }
            if (eVar.g()) {
                buVar.a(e.f20188h);
                buVar.a(eVar.b);
                buVar.c();
            }
            if (eVar.f20192c != null && eVar.j()) {
                buVar.a(e.f20189i);
                buVar.a(eVar.f20192c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends cf<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
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
            caVar.a(bitSet, 3);
            if (eVar.d()) {
                caVar.a(eVar.a);
            }
            if (eVar.g()) {
                caVar.a(eVar.b);
            }
            if (eVar.j()) {
                caVar.a(eVar.f20192c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSetB = caVar.b(3);
            if (bitSetB.get(0)) {
                eVar.a = caVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = caVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.f20192c = caVar.z();
                eVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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
        f20190j.put(ce.class, new b());
        f20190j.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0559e.class);
        enumMap.put(EnumC0559e.VALUE, new bh("value", (byte) 2, new bi((byte) 11)));
        enumMap.put(EnumC0559e.TS, new bh("ts", (byte) 2, new bi((byte) 10)));
        enumMap.put(EnumC0559e.GUID, new bh("guid", (byte) 2, new bi((byte) 11)));
        f20184d = Collections.unmodifiableMap(enumMap);
        bh.a(e.class, f20184d);
    }

    public e() {
        this.f20193l = (byte) 0;
        this.f20194m = new EnumC0559e[]{EnumC0559e.VALUE, EnumC0559e.TS, EnumC0559e.GUID};
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
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
        this.f20192c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.f20193l = as.b(this.f20193l, 0);
    }

    public boolean g() {
        return as.a(this.f20193l, 0);
    }

    public String h() {
        return this.f20192c;
    }

    public void i() {
        this.f20192c = null;
    }

    public boolean j() {
        return this.f20192c != null;
    }

    public void k() throws bb {
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f20190j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f20192c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f20190j.get(buVar.D()).b().a(buVar, this);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0559e implements bc {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0559e> f20196d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f20198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f20199f;

        static {
            for (EnumC0559e enumC0559e : EnumSet.allOf(EnumC0559e.class)) {
                f20196d.put(enumC0559e.b(), enumC0559e);
            }
        }

        EnumC0559e(short s2, String str) {
            this.f20198e = s2;
            this.f20199f = str;
        }

        public static EnumC0559e a(int i2) {
            if (i2 == 1) {
                return VALUE;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0559e b(int i2) {
            EnumC0559e enumC0559eA = a(i2);
            if (enumC0559eA != null) {
                return enumC0559eA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f20199f;
        }

        public static EnumC0559e a(String str) {
            return f20196d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f20198e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z2) {
        this.f20193l = as.a(this.f20193l, 0, z2);
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f20192c = null;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.f20192c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.f20192c = str;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0559e fieldForId(int i2) {
        return EnumC0559e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.f20193l = (byte) 0;
        this.f20194m = new EnumC0559e[]{EnumC0559e.VALUE, EnumC0559e.TS, EnumC0559e.GUID};
        this.f20193l = eVar.f20193l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.f20192c = eVar.f20192c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f20193l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
