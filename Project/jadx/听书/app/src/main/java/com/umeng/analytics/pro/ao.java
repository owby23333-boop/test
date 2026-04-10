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
/* JADX INFO: loaded from: classes4.dex */
public class ao implements aw<ao, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bi> k;
    private static final long l = 420342210744516016L;
    private static final ca m = new ca("UMEnvelope");
    private static final bq n = new bq("version", (byte) 11, 1);
    private static final bq o = new bq("address", (byte) 11, 2);
    private static final bq p = new bq("signature", (byte) 11, 3);
    private static final bq q = new bq("serial_num", (byte) 8, 4);
    private static final bq r = new bq("ts_secs", (byte) 8, 5);
    private static final bq s = new bq("length", (byte) 8, 6);
    private static final bq t = new bq("entity", (byte) 11, 7);
    private static final bq u = new bq("guid", (byte) 11, 8);
    private static final bq v = new bq("checksum", (byte) 11, 9);
    private static final bq w = new bq("codex", (byte) 8, 10);
    private static final Map<Class<? extends cd>, ce> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2175a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    static {
        HashMap map = new HashMap();
        x = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bi("version", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.ADDRESS, new bi("address", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.SIGNATURE, new bi("signature", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bi("serial_num", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.TS_SECS, new bi("ts_secs", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.LENGTH, new bi("length", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.ENTITY, new bi("entity", (byte) 1, new bj((byte) 11, true)));
        enumMap.put(e.GUID, new bi("guid", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 1, new bj((byte) 11)));
        enumMap.put(e.CODEX, new bi("codex", (byte) 2, new bj((byte) 8)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = mapUnmodifiableMap;
        bi.a(ao.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum e implements bd {
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

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                k.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
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

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return k.get(str);
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.l;
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.m;
        }
    }

    public ao() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public ao(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f2175a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public ao(ao aoVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = aoVar.C;
        if (aoVar.d()) {
            this.f2175a = aoVar.f2175a;
        }
        if (aoVar.g()) {
            this.b = aoVar.b;
        }
        if (aoVar.j()) {
            this.c = aoVar.c;
        }
        this.d = aoVar.d;
        this.e = aoVar.e;
        this.f = aoVar.f;
        if (aoVar.w()) {
            this.g = ax.d(aoVar.g);
        }
        if (aoVar.z()) {
            this.h = aoVar.h;
        }
        if (aoVar.C()) {
            this.i = aoVar.i;
        }
        this.j = aoVar.j;
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ao deepCopy() {
        return new ao(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.f2175a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public String b() {
        return this.f2175a;
    }

    public ao a(String str) {
        this.f2175a = str;
        return this;
    }

    public void c() {
        this.f2175a = null;
    }

    public boolean d() {
        return this.f2175a != null;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f2175a = null;
    }

    public String e() {
        return this.b;
    }

    public ao b(String str) {
        this.b = str;
        return this;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public String h() {
        return this.c;
    }

    public ao c(String str) {
        this.c = str;
        return this;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.c = null;
    }

    public int k() {
        return this.d;
    }

    public ao a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public void l() {
        this.C = at.b(this.C, 0);
    }

    public boolean m() {
        return at.a(this.C, 0);
    }

    public void d(boolean z2) {
        this.C = at.a(this.C, 0, z2);
    }

    public int n() {
        return this.e;
    }

    public ao b(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public void o() {
        this.C = at.b(this.C, 1);
    }

    public boolean p() {
        return at.a(this.C, 1);
    }

    public void e(boolean z2) {
        this.C = at.a(this.C, 1, z2);
    }

    public int q() {
        return this.f;
    }

    public ao c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public void r() {
        this.C = at.b(this.C, 2);
    }

    public boolean s() {
        return at.a(this.C, 2);
    }

    public void f(boolean z2) {
        this.C = at.a(this.C, 2, z2);
    }

    public byte[] t() {
        a(ax.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public ao a(byte[] bArr) {
        ByteBuffer byteBufferWrap;
        if (bArr == null) {
            byteBufferWrap = null;
        } else {
            byteBufferWrap = ByteBuffer.wrap(bArr);
        }
        a(byteBufferWrap);
        return this;
    }

    public ao a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public String x() {
        return this.h;
    }

    public ao d(String str) {
        this.h = str;
        return this;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public String A() {
        return this.i;
    }

    public ao e(String str) {
        this.i = str;
        return this;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public int D() {
        return this.j;
    }

    public ao d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public void E() {
        this.C = at.b(this.C, 3);
    }

    public boolean F() {
        return at.a(this.C, 3);
    }

    public void j(boolean z2) {
        this.C = at.a(this.C, 3, z2);
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        x.get(bvVar.D()).b().b(bvVar, this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        x.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f2175a;
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
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            ax.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public void G() throws bc {
        if (this.f2175a == null) {
            throw new bw("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new bw("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bw("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new bw("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new bw("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i == null) {
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
            this.C = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class a extends cf<ao> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, ao aoVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b != 0) {
                    switch (bqVarL.c) {
                        case 1:
                            if (bqVarL.b == 11) {
                                aoVar.f2175a = bvVar.z();
                                aoVar.a(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 2:
                            if (bqVarL.b == 11) {
                                aoVar.b = bvVar.z();
                                aoVar.b(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 3:
                            if (bqVarL.b == 11) {
                                aoVar.c = bvVar.z();
                                aoVar.c(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 4:
                            if (bqVarL.b == 8) {
                                aoVar.d = bvVar.w();
                                aoVar.d(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 5:
                            if (bqVarL.b == 8) {
                                aoVar.e = bvVar.w();
                                aoVar.e(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 6:
                            if (bqVarL.b == 8) {
                                aoVar.f = bvVar.w();
                                aoVar.f(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 7:
                            if (bqVarL.b == 11) {
                                aoVar.g = bvVar.A();
                                aoVar.g(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 8:
                            if (bqVarL.b == 11) {
                                aoVar.h = bvVar.z();
                                aoVar.h(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 9:
                            if (bqVarL.b == 11) {
                                aoVar.i = bvVar.z();
                                aoVar.i(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 10:
                            if (bqVarL.b == 8) {
                                aoVar.j = bvVar.w();
                                aoVar.j(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        default:
                            by.a(bvVar, bqVarL.b);
                            break;
                    }
                    bvVar.m();
                } else {
                    bvVar.k();
                    if (!aoVar.m()) {
                        throw new bw("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aoVar.p()) {
                        throw new bw("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aoVar.s()) {
                        throw new bw("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                    aoVar.G();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, ao aoVar) throws bc {
            aoVar.G();
            bvVar.a(ao.m);
            if (aoVar.f2175a != null) {
                bvVar.a(ao.n);
                bvVar.a(aoVar.f2175a);
                bvVar.c();
            }
            if (aoVar.b != null) {
                bvVar.a(ao.o);
                bvVar.a(aoVar.b);
                bvVar.c();
            }
            if (aoVar.c != null) {
                bvVar.a(ao.p);
                bvVar.a(aoVar.c);
                bvVar.c();
            }
            bvVar.a(ao.q);
            bvVar.a(aoVar.d);
            bvVar.c();
            bvVar.a(ao.r);
            bvVar.a(aoVar.e);
            bvVar.c();
            bvVar.a(ao.s);
            bvVar.a(aoVar.f);
            bvVar.c();
            if (aoVar.g != null) {
                bvVar.a(ao.t);
                bvVar.a(aoVar.g);
                bvVar.c();
            }
            if (aoVar.h != null) {
                bvVar.a(ao.u);
                bvVar.a(aoVar.h);
                bvVar.c();
            }
            if (aoVar.i != null) {
                bvVar.a(ao.v);
                bvVar.a(aoVar.i);
                bvVar.c();
            }
            if (aoVar.F()) {
                bvVar.a(ao.w);
                bvVar.a(aoVar.j);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class c extends cg<ao> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, ao aoVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(aoVar.f2175a);
            cbVar.a(aoVar.b);
            cbVar.a(aoVar.c);
            cbVar.a(aoVar.d);
            cbVar.a(aoVar.e);
            cbVar.a(aoVar.f);
            cbVar.a(aoVar.g);
            cbVar.a(aoVar.h);
            cbVar.a(aoVar.i);
            BitSet bitSet = new BitSet();
            if (aoVar.F()) {
                bitSet.set(0);
            }
            cbVar.a(bitSet, 1);
            if (aoVar.F()) {
                cbVar.a(aoVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, ao aoVar) throws bc {
            cb cbVar = (cb) bvVar;
            aoVar.f2175a = cbVar.z();
            aoVar.a(true);
            aoVar.b = cbVar.z();
            aoVar.b(true);
            aoVar.c = cbVar.z();
            aoVar.c(true);
            aoVar.d = cbVar.w();
            aoVar.d(true);
            aoVar.e = cbVar.w();
            aoVar.e(true);
            aoVar.f = cbVar.w();
            aoVar.f(true);
            aoVar.g = cbVar.A();
            aoVar.g(true);
            aoVar.h = cbVar.z();
            aoVar.h(true);
            aoVar.i = cbVar.z();
            aoVar.i(true);
            if (cbVar.b(1).get(0)) {
                aoVar.j = cbVar.w();
                aoVar.j(true);
            }
        }
    }
}
