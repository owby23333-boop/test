package com.xiaomi.push;

import com.google.common.base.Ascii;
import com.yuewen.eq2;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* JADX INFO: loaded from: classes8.dex */
public class ix implements jm<ix, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ib f687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public io f688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iq f689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f691a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f694b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final kc f686a = new kc("XmPushActionContainer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ju f8108a = new ju("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ju f8109b = new ju("", (byte) 2, 2);
    private static final ju c = new ju("", (byte) 2, 3);
    private static final ju d = new ju("", Ascii.VT, 4);
    private static final ju e = new ju("", Ascii.VT, 5);
    private static final ju f = new ju("", Ascii.VT, 6);
    private static final ju g = new ju("", Ascii.FF, 7);
    private static final ju h = new ju("", Ascii.FF, 8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f692a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f693a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f695b = true;

    public ib a() {
        return this.f687a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m601b() {
        return this.f693a;
    }

    public boolean c() {
        return this.f692a.get(0);
    }

    public boolean d() {
        return this.f692a.get(1);
    }

    public boolean e() {
        return this.f691a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ix)) {
            return m598a((ix) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f690a != null;
    }

    public boolean g() {
        return this.f694b != null;
    }

    public boolean h() {
        return this.f689a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f688a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        ib ibVar = this.f687a;
        if (ibVar == null) {
            sb.append(eq2.g);
        } else {
            sb.append(ibVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f693a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f695b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f690a;
            if (str == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f694b;
            if (str2 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        iq iqVar = this.f689a;
        if (iqVar == null) {
            sb.append(eq2.g);
        } else {
            sb.append(iqVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            io ioVar = this.f688a;
            if (ioVar == null) {
                sb.append(eq2.g);
            } else {
                sb.append(ioVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public ix a(ib ibVar) {
        this.f687a = ibVar;
        return this;
    }

    public ix b(boolean z) {
        this.f695b = z;
        m600b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m597a() {
        return this.f687a != null;
    }

    public ix a(boolean z) {
        this.f693a = z;
        m596a(true);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m600b(boolean z) {
        this.f692a.set(1, z);
    }

    public String b() {
        return this.f694b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m596a(boolean z) {
        this.f692a.set(0, z);
    }

    public ix b(String str) {
        this.f694b = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m599a() {
        a(jn.a(this.f691a));
        return this.f691a.array();
    }

    @Override // com.xiaomi.push.jm
    public void b(jx jxVar) throws jy {
        m595a();
        jxVar.a(f686a);
        if (this.f687a != null) {
            jxVar.a(f8108a);
            jxVar.mo687a(this.f687a.a());
            jxVar.b();
        }
        jxVar.a(f8109b);
        jxVar.a(this.f693a);
        jxVar.b();
        jxVar.a(c);
        jxVar.a(this.f695b);
        jxVar.b();
        if (this.f691a != null) {
            jxVar.a(d);
            jxVar.a(this.f691a);
            jxVar.b();
        }
        if (this.f690a != null && f()) {
            jxVar.a(e);
            jxVar.a(this.f690a);
            jxVar.b();
        }
        if (this.f694b != null && g()) {
            jxVar.a(f);
            jxVar.a(this.f694b);
            jxVar.b();
        }
        if (this.f689a != null) {
            jxVar.a(g);
            this.f689a.b(jxVar);
            jxVar.b();
        }
        if (this.f688a != null && i()) {
            jxVar.a(h);
            this.f688a.b(jxVar);
            jxVar.b();
        }
        jxVar.c();
        jxVar.mo686a();
    }

    public ix a(ByteBuffer byteBuffer) {
        this.f691a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m594a() {
        return this.f690a;
    }

    public ix a(String str) {
        this.f690a = str;
        return this;
    }

    public ix a(iq iqVar) {
        this.f689a = iqVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public io m593a() {
        return this.f688a;
    }

    public ix a(io ioVar) {
        this.f688a = ioVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m598a(ix ixVar) {
        if (ixVar == null) {
            return false;
        }
        boolean zM597a = m597a();
        boolean zM597a2 = ixVar.m597a();
        if (((zM597a || zM597a2) && (!zM597a || !zM597a2 || !this.f687a.equals(ixVar.f687a))) || this.f693a != ixVar.f693a || this.f695b != ixVar.f695b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ixVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f691a.equals(ixVar.f691a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ixVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f690a.equals(ixVar.f690a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ixVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f694b.equals(ixVar.f694b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ixVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f689a.m571a(ixVar.f689a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ixVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f688a.m563a(ixVar.f688a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ix ixVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(ixVar.getClass())) {
            return getClass().getName().compareTo(ixVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m597a()).compareTo(Boolean.valueOf(ixVar.m597a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m597a() && (iA8 = jn.a(this.f687a, ixVar.f687a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ixVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = jn.a(this.f693a, ixVar.f693a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ixVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = jn.a(this.f695b, ixVar.f695b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ixVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = jn.a(this.f691a, ixVar.f691a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ixVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = jn.a(this.f690a, ixVar.f690a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ixVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = jn.a(this.f694b, ixVar.f694b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ixVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = jn.a(this.f689a, ixVar.f689a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ixVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = jn.a(this.f688a, ixVar.f688a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.jm
    public void a(jx jxVar) throws jy {
        jxVar.mo682a();
        while (true) {
            ju juVarMo678a = jxVar.mo678a();
            byte b2 = juVarMo678a.f8143a;
            if (b2 == 0) {
                jxVar.f();
                if (c()) {
                    if (d()) {
                        m595a();
                        return;
                    }
                    throw new jy("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new jy("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (juVarMo678a.f869a) {
                case 1:
                    if (b2 == 8) {
                        this.f687a = ib.a(jxVar.mo676a());
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f693a = jxVar.mo688a();
                        m596a(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f695b = jxVar.mo688a();
                        m600b(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f691a = jxVar.mo684a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f690a = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f694b = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        iq iqVar = new iq();
                        this.f689a = iqVar;
                        iqVar.a(jxVar);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        io ioVar = new io();
                        this.f688a = ioVar;
                        ioVar.a(jxVar);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                default:
                    ka.a(jxVar, b2);
                    break;
            }
            jxVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m595a() throws jy {
        if (this.f687a != null) {
            if (this.f691a != null) {
                if (this.f689a != null) {
                    return;
                }
                throw new jy("Required field 'target' was not present! Struct: " + toString());
            }
            throw new jy("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new jy("Required field 'action' was not present! Struct: " + toString());
    }
}
