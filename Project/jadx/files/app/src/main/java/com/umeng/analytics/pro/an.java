package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: classes3.dex */
public class an implements av<an, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<e, bh> f19467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f19468l = 420342210744516016L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final bz f19469m = new bz("UMEnvelope");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final bp f19470n = new bp("version", (byte) 11, 1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final bp f19471o = new bp("address", (byte) 11, 2);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final bp f19472p = new bp("signature", (byte) 11, 3);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final bp f19473q = new bp("serial_num", (byte) 8, 4);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final bp f19474r = new bp("ts_secs", (byte) 8, 5);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final bp f19475s = new bp("length", (byte) 8, 6);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final bp f19476t = new bp("entity", (byte) 11, 7);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final bp f19477u = new bp("guid", (byte) 11, 8);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final bp f19478v = new bp("checksum", (byte) 11, 9);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final bp f19479w = new bp("codex", (byte) 8, 10);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f19480x = new HashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f19481y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f19482z = 1;
    private byte C;
    private e[] D;
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f19487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f19488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f19489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19490j;

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class a extends ce<an> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, an anVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    buVar.k();
                    if (!anVar.m()) {
                        throw new bv("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!anVar.p()) {
                        throw new bv("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (anVar.s()) {
                        anVar.G();
                        return;
                    }
                    throw new bv("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (bpVarL.f19582c) {
                    case 1:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.a = buVar.z();
                            anVar.a(true);
                        }
                        break;
                    case 2:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.b = buVar.z();
                            anVar.b(true);
                        }
                        break;
                    case 3:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19483c = buVar.z();
                            anVar.c(true);
                        }
                        break;
                    case 4:
                        if (b != 8) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19484d = buVar.w();
                            anVar.d(true);
                        }
                        break;
                    case 5:
                        if (b != 8) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19485e = buVar.w();
                            anVar.e(true);
                        }
                        break;
                    case 6:
                        if (b != 8) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19486f = buVar.w();
                            anVar.f(true);
                        }
                        break;
                    case 7:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19487g = buVar.A();
                            anVar.g(true);
                        }
                        break;
                    case 8:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19488h = buVar.z();
                            anVar.h(true);
                        }
                        break;
                    case 9:
                        if (b != 11) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19489i = buVar.z();
                            anVar.i(true);
                        }
                        break;
                    case 10:
                        if (b != 8) {
                            bx.a(buVar, b);
                        } else {
                            anVar.f19490j = buVar.w();
                            anVar.j(true);
                        }
                        break;
                    default:
                        bx.a(buVar, b);
                        break;
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, an anVar) throws bb {
            anVar.G();
            buVar.a(an.f19469m);
            if (anVar.a != null) {
                buVar.a(an.f19470n);
                buVar.a(anVar.a);
                buVar.c();
            }
            if (anVar.b != null) {
                buVar.a(an.f19471o);
                buVar.a(anVar.b);
                buVar.c();
            }
            if (anVar.f19483c != null) {
                buVar.a(an.f19472p);
                buVar.a(anVar.f19483c);
                buVar.c();
            }
            buVar.a(an.f19473q);
            buVar.a(anVar.f19484d);
            buVar.c();
            buVar.a(an.f19474r);
            buVar.a(anVar.f19485e);
            buVar.c();
            buVar.a(an.f19475s);
            buVar.a(anVar.f19486f);
            buVar.c();
            if (anVar.f19487g != null) {
                buVar.a(an.f19476t);
                buVar.a(anVar.f19487g);
                buVar.c();
            }
            if (anVar.f19488h != null) {
                buVar.a(an.f19477u);
                buVar.a(anVar.f19488h);
                buVar.c();
            }
            if (anVar.f19489i != null) {
                buVar.a(an.f19478v);
                buVar.a(anVar.f19489i);
                buVar.c();
            }
            if (anVar.F()) {
                buVar.a(an.f19479w);
                buVar.a(anVar.f19490j);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class c extends cf<an> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(anVar.a);
            caVar.a(anVar.b);
            caVar.a(anVar.f19483c);
            caVar.a(anVar.f19484d);
            caVar.a(anVar.f19485e);
            caVar.a(anVar.f19486f);
            caVar.a(anVar.f19487g);
            caVar.a(anVar.f19488h);
            caVar.a(anVar.f19489i);
            BitSet bitSet = new BitSet();
            if (anVar.F()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (anVar.F()) {
                caVar.a(anVar.f19490j);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            anVar.a = caVar.z();
            anVar.a(true);
            anVar.b = caVar.z();
            anVar.b(true);
            anVar.f19483c = caVar.z();
            anVar.c(true);
            anVar.f19484d = caVar.w();
            anVar.d(true);
            anVar.f19485e = caVar.w();
            anVar.e(true);
            anVar.f19486f = caVar.w();
            anVar.f(true);
            anVar.f19487g = caVar.A();
            anVar.g(true);
            anVar.f19488h = caVar.z();
            anVar.h(true);
            anVar.f19489i = caVar.z();
            anVar.i(true);
            if (caVar.b(1).get(0)) {
                anVar.f19490j = caVar.w();
                anVar.j(true);
            }
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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
        f19480x.put(ce.class, new b());
        f19480x.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.ADDRESS, new bh("address", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.SIGNATURE, new bh("signature", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bh("serial_num", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.TS_SECS, new bh("ts_secs", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.LENGTH, new bh("length", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.ENTITY, new bh("entity", (byte) 1, new bi((byte) 11, true)));
        enumMap.put(e.GUID, new bh("guid", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.CHECKSUM, new bh("checksum", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.CODEX, new bh("codex", (byte) 2, new bi((byte) 8)));
        f19467k = Collections.unmodifiableMap(enumMap);
        bh.a(an.class, f19467k);
    }

    public an() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f19489i;
    }

    public void B() {
        this.f19489i = null;
    }

    public boolean C() {
        return this.f19489i != null;
    }

    public int D() {
        return this.f19490j;
    }

    public void E() {
        this.C = as.b(this.C, 3);
    }

    public boolean F() {
        return as.a(this.C, 3);
    }

    public void G() throws bb {
        if (this.a == null) {
            throw new bv("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new bv("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f19483c == null) {
            throw new bv("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f19487g == null) {
            throw new bv("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f19488h == null) {
            throw new bv("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f19489i != null) {
            return;
        }
        throw new bv("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public an deepCopy() {
        return new an(this);
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
        this.f19483c = null;
        d(false);
        this.f19484d = 0;
        e(false);
        this.f19485e = 0;
        f(false);
        this.f19486f = 0;
        this.f19487g = null;
        this.f19488h = null;
        this.f19489i = null;
        j(false);
        this.f19490j = 0;
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
        return this.f19483c;
    }

    public void i() {
        this.f19483c = null;
    }

    public boolean j() {
        return this.f19483c != null;
    }

    public int k() {
        return this.f19484d;
    }

    public void l() {
        this.C = as.b(this.C, 0);
    }

    public boolean m() {
        return as.a(this.C, 0);
    }

    public int n() {
        return this.f19485e;
    }

    public void o() {
        this.C = as.b(this.C, 1);
    }

    public boolean p() {
        return as.a(this.C, 1);
    }

    public int q() {
        return this.f19486f;
    }

    public void r() {
        this.C = as.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f19480x.get(buVar.D()).b().b(buVar, this);
    }

    public boolean s() {
        return as.a(this.C, 2);
    }

    public byte[] t() {
        a(aw.c(this.f19487g));
        ByteBuffer byteBuffer = this.f19487g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f19483c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f19484d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f19485e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f19486f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f19487g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            aw.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f19488h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f19489i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f19490j);
        }
        sb.append(com.umeng.message.proguard.ad.f20406s);
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f19487g;
    }

    public void v() {
        this.f19487g = null;
    }

    public boolean w() {
        return this.f19487g != null;
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f19480x.get(buVar.D()).b().a(buVar, this);
    }

    public String x() {
        return this.f19488h;
    }

    public void y() {
        this.f19488h = null;
    }

    public boolean z() {
        return this.f19488h != null;
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum e implements bc {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f19499k = new HashMap();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final short f19501l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f19502m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f19499k.put(eVar.b(), eVar);
            }
        }

        e(short s2, String str) {
            this.f19501l = s2;
            this.f19502m = str;
        }

        public static e a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f19502m;
        }

        public static e a(String str) {
            return f19499k.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f19501l;
        }
    }

    public an a(String str) {
        this.a = str;
        return this;
    }

    public an b(String str) {
        this.b = str;
        return this;
    }

    public an c(String str) {
        this.f19483c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = as.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = as.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = as.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f19487g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f19488h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f19489i = null;
    }

    public void j(boolean z2) {
        this.C = as.a(this.C, 3, z2);
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
        this.f19483c = null;
    }

    public an d(String str) {
        this.f19488h = str;
        return this;
    }

    public an e(String str) {
        this.f19489i = str;
        return this;
    }

    public an(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.f19483c = str3;
        this.f19484d = i2;
        d(true);
        this.f19485e = i3;
        e(true);
        this.f19486f = i4;
        f(true);
        this.f19487g = byteBuffer;
        this.f19488h = str4;
        this.f19489i = str5;
    }

    public an a(int i2) {
        this.f19484d = i2;
        d(true);
        return this;
    }

    public an b(int i2) {
        this.f19485e = i2;
        e(true);
        return this;
    }

    public an c(int i2) {
        this.f19486f = i2;
        f(true);
        return this;
    }

    public an d(int i2) {
        this.f19490j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public an a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public an a(ByteBuffer byteBuffer) {
        this.f19487g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public an(an anVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = anVar.C;
        if (anVar.d()) {
            this.a = anVar.a;
        }
        if (anVar.g()) {
            this.b = anVar.b;
        }
        if (anVar.j()) {
            this.f19483c = anVar.f19483c;
        }
        this.f19484d = anVar.f19484d;
        this.f19485e = anVar.f19485e;
        this.f19486f = anVar.f19486f;
        if (anVar.w()) {
            this.f19487g = aw.d(anVar.f19487g);
        }
        if (anVar.z()) {
            this.f19488h = anVar.f19488h;
        }
        if (anVar.C()) {
            this.f19489i = anVar.f19489i;
        }
        this.f19490j = anVar.f19490j;
    }
}
