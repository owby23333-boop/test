package com.xiaomi.push;

import com.google.common.base.Ascii;
import com.yuewen.eq2;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class io implements jm<io, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f603a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f604b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f605b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String> f606b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f607c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f608c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Map<String, String> f609c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f610d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f611e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final kc f597a = new kc("PushMetaInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ju f8091a = new ju("", Ascii.VT, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ju f8092b = new ju("", (byte) 10, 2);
    private static final ju c = new ju("", Ascii.VT, 3);
    private static final ju d = new ju("", Ascii.VT, 4);
    private static final ju e = new ju("", Ascii.VT, 5);
    private static final ju f = new ju("", (byte) 8, 6);
    private static final ju g = new ju("", Ascii.VT, 7);
    private static final ju h = new ju("", (byte) 8, 8);
    private static final ju i = new ju("", (byte) 8, 9);
    private static final ju j = new ju("", Ascii.CR, 10);
    private static final ju k = new ju("", Ascii.CR, 11);
    private static final ju l = new ju("", (byte) 2, 12);
    private static final ju m = new ju("", Ascii.CR, 13);

    public io() {
        this.f601a = new BitSet(5);
        this.f603a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public io m558a() {
        return new io(this);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m566b() {
        return this.f601a.get(0);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m568c() {
        return this.f605b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m569d() {
        return this.f608c != null;
    }

    public boolean e() {
        return this.f610d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m563a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f601a.get(1);
    }

    public boolean g() {
        return this.f611e != null;
    }

    public boolean h() {
        return this.f601a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f601a.get(3);
    }

    public boolean j() {
        return this.f602a != null;
    }

    public boolean k() {
        return this.f606b != null;
    }

    public boolean l() {
        return this.f603a;
    }

    public boolean m() {
        return this.f601a.get(4);
    }

    public boolean n() {
        return this.f609c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f600a;
        if (str == null) {
            sb.append(eq2.g);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f599a);
        if (m568c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f605b;
            if (str2 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str2);
            }
        }
        if (m569d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f608c;
            if (str3 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f610d;
            if (str4 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f598a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f611e;
            if (str5 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f604b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f607c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f602a;
            if (map == null) {
                sb.append(eq2.g);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f606b;
            if (map2 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f603a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f609c;
            if (map3 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m559a() {
        return this.f600a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m564b() {
        return this.f605b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m567c() {
        return this.f608c;
    }

    public String d() {
        return this.f610d;
    }

    public void e(boolean z) {
        this.f601a.set(4, z);
    }

    public io a(String str) {
        this.f600a = str;
        return this;
    }

    public io b(String str) {
        this.f605b = str;
        return this;
    }

    public io c(String str) {
        this.f608c = str;
        return this;
    }

    public io d(String str) {
        this.f610d = str;
        return this;
    }

    public io(io ioVar) {
        BitSet bitSet = new BitSet(5);
        this.f601a = bitSet;
        bitSet.clear();
        this.f601a.or(ioVar.f601a);
        if (ioVar.m562a()) {
            this.f600a = ioVar.f600a;
        }
        this.f599a = ioVar.f599a;
        if (ioVar.m568c()) {
            this.f605b = ioVar.f605b;
        }
        if (ioVar.m569d()) {
            this.f608c = ioVar.f608c;
        }
        if (ioVar.e()) {
            this.f610d = ioVar.f610d;
        }
        this.f598a = ioVar.f598a;
        if (ioVar.g()) {
            this.f611e = ioVar.f611e;
        }
        this.f604b = ioVar.f604b;
        this.f607c = ioVar.f607c;
        if (ioVar.j()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String> entry : ioVar.f602a.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            this.f602a = map;
        }
        if (ioVar.k()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry2 : ioVar.f606b.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue());
            }
            this.f606b = map2;
        }
        this.f603a = ioVar.f603a;
        if (ioVar.n()) {
            HashMap map3 = new HashMap();
            for (Map.Entry<String, String> entry3 : ioVar.f609c.entrySet()) {
                map3.put(entry3.getKey(), entry3.getValue());
            }
            this.f609c = map3;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m562a() {
        return this.f600a != null;
    }

    public void b(boolean z) {
        this.f601a.set(1, z);
    }

    public void c(boolean z) {
        this.f601a.set(2, z);
    }

    public void d(boolean z) {
        this.f601a.set(3, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m557a() {
        return this.f599a;
    }

    public int b() {
        return this.f604b;
    }

    public int c() {
        return this.f607c;
    }

    public void a(boolean z) {
        this.f601a.set(0, z);
    }

    public io b(int i2) {
        this.f604b = i2;
        c(true);
        return this;
    }

    public io c(int i2) {
        this.f607c = i2;
        d(true);
        return this;
    }

    public int a() {
        return this.f598a;
    }

    public io a(int i2) {
        this.f598a = i2;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f606b == null) {
            this.f606b = new HashMap();
        }
        this.f606b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f602a == null) {
            this.f602a = new HashMap();
        }
        this.f602a.put(str, str2);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<String, String> m565b() {
        return this.f606b;
    }

    @Override // com.xiaomi.push.jm
    public void b(jx jxVar) throws jy {
        m561a();
        jxVar.a(f597a);
        if (this.f600a != null) {
            jxVar.a(f8091a);
            jxVar.a(this.f600a);
            jxVar.b();
        }
        jxVar.a(f8092b);
        jxVar.a(this.f599a);
        jxVar.b();
        if (this.f605b != null && m568c()) {
            jxVar.a(c);
            jxVar.a(this.f605b);
            jxVar.b();
        }
        if (this.f608c != null && m569d()) {
            jxVar.a(d);
            jxVar.a(this.f608c);
            jxVar.b();
        }
        if (this.f610d != null && e()) {
            jxVar.a(e);
            jxVar.a(this.f610d);
            jxVar.b();
        }
        if (f()) {
            jxVar.a(f);
            jxVar.mo687a(this.f598a);
            jxVar.b();
        }
        if (this.f611e != null && g()) {
            jxVar.a(g);
            jxVar.a(this.f611e);
            jxVar.b();
        }
        if (h()) {
            jxVar.a(h);
            jxVar.mo687a(this.f604b);
            jxVar.b();
        }
        if (i()) {
            jxVar.a(i);
            jxVar.mo687a(this.f607c);
            jxVar.b();
        }
        if (this.f602a != null && j()) {
            jxVar.a(j);
            jxVar.a(new jw(Ascii.VT, Ascii.VT, this.f602a.size()));
            for (Map.Entry<String, String> entry : this.f602a.entrySet()) {
                jxVar.a(entry.getKey());
                jxVar.a(entry.getValue());
            }
            jxVar.d();
            jxVar.b();
        }
        if (this.f606b != null && k()) {
            jxVar.a(k);
            jxVar.a(new jw(Ascii.VT, Ascii.VT, this.f606b.size()));
            for (Map.Entry<String, String> entry2 : this.f606b.entrySet()) {
                jxVar.a(entry2.getKey());
                jxVar.a(entry2.getValue());
            }
            jxVar.d();
            jxVar.b();
        }
        if (m()) {
            jxVar.a(l);
            jxVar.a(this.f603a);
            jxVar.b();
        }
        if (this.f609c != null && n()) {
            jxVar.a(m);
            jxVar.a(new jw(Ascii.VT, Ascii.VT, this.f609c.size()));
            for (Map.Entry<String, String> entry3 : this.f609c.entrySet()) {
                jxVar.a(entry3.getKey());
                jxVar.a(entry3.getValue());
            }
            jxVar.d();
            jxVar.b();
        }
        jxVar.c();
        jxVar.mo686a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m560a() {
        return this.f602a;
    }

    public io a(Map<String, String> map) {
        this.f602a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m563a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean zM562a = m562a();
        boolean zM562a2 = ioVar.m562a();
        if (((zM562a || zM562a2) && !(zM562a && zM562a2 && this.f600a.equals(ioVar.f600a))) || this.f599a != ioVar.f599a) {
            return false;
        }
        boolean zM568c = m568c();
        boolean zM568c2 = ioVar.m568c();
        if ((zM568c || zM568c2) && !(zM568c && zM568c2 && this.f605b.equals(ioVar.f605b))) {
            return false;
        }
        boolean zM569d = m569d();
        boolean zM569d2 = ioVar.m569d();
        if ((zM569d || zM569d2) && !(zM569d && zM569d2 && this.f608c.equals(ioVar.f608c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ioVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f610d.equals(ioVar.f610d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ioVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f598a == ioVar.f598a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ioVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f611e.equals(ioVar.f611e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ioVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f604b == ioVar.f604b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ioVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f607c == ioVar.f607c)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ioVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f602a.equals(ioVar.f602a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = ioVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f606b.equals(ioVar.f606b))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = ioVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f603a == ioVar.f603a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = ioVar.n();
        if (zN || zN2) {
            return zN && zN2 && this.f609c.equals(ioVar.f609c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(io ioVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        if (!getClass().equals(ioVar.getClass())) {
            return getClass().getName().compareTo(ioVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(ioVar.m562a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m562a() && (iA13 = jn.a(this.f600a, ioVar.f600a)) != 0) {
            return iA13;
        }
        int iCompareTo2 = Boolean.valueOf(m566b()).compareTo(Boolean.valueOf(ioVar.m566b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m566b() && (iA12 = jn.a(this.f599a, ioVar.f599a)) != 0) {
            return iA12;
        }
        int iCompareTo3 = Boolean.valueOf(m568c()).compareTo(Boolean.valueOf(ioVar.m568c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m568c() && (iA11 = jn.a(this.f605b, ioVar.f605b)) != 0) {
            return iA11;
        }
        int iCompareTo4 = Boolean.valueOf(m569d()).compareTo(Boolean.valueOf(ioVar.m569d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m569d() && (iA10 = jn.a(this.f608c, ioVar.f608c)) != 0) {
            return iA10;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA9 = jn.a(this.f610d, ioVar.f610d)) != 0) {
            return iA9;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA8 = jn.a(this.f598a, ioVar.f598a)) != 0) {
            return iA8;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA7 = jn.a(this.f611e, ioVar.f611e)) != 0) {
            return iA7;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA6 = jn.a(this.f604b, ioVar.f604b)) != 0) {
            return iA6;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA5 = jn.a(this.f607c, ioVar.f607c)) != 0) {
            return iA5;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ioVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA4 = jn.a(this.f602a, ioVar.f602a)) != 0) {
            return iA4;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ioVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA3 = jn.a(this.f606b, ioVar.f606b)) != 0) {
            return iA3;
        }
        int iCompareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ioVar.m()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (m() && (iA2 = jn.a(this.f603a, ioVar.f603a)) != 0) {
            return iA2;
        }
        int iCompareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ioVar.n()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (!n() || (iA = jn.a(this.f609c, ioVar.f609c)) == 0) {
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
                if (m566b()) {
                    m561a();
                    return;
                }
                throw new jy("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (juVarMo678a.f869a) {
                case 1:
                    if (b2 == 11) {
                        this.f600a = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f599a = jxVar.mo677a();
                        a(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f605b = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f608c = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f610d = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f598a = jxVar.mo676a();
                        b(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f611e = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f604b = jxVar.mo676a();
                        c(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f607c = jxVar.mo676a();
                        d(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jw jwVarMo680a = jxVar.mo680a();
                        this.f602a = new HashMap(jwVarMo680a.f871a * 2);
                        while (i2 < jwVarMo680a.f871a) {
                            this.f602a.put(jxVar.mo683a(), jxVar.mo683a());
                            i2++;
                        }
                        jxVar.h();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 13) {
                        jw jwVarMo680a2 = jxVar.mo680a();
                        this.f606b = new HashMap(jwVarMo680a2.f871a * 2);
                        while (i2 < jwVarMo680a2.f871a) {
                            this.f606b.put(jxVar.mo683a(), jxVar.mo683a());
                            i2++;
                        }
                        jxVar.h();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f603a = jxVar.mo688a();
                        e(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 13) {
                        jw jwVarMo680a3 = jxVar.mo680a();
                        this.f609c = new HashMap(jwVarMo680a3.f871a * 2);
                        while (i2 < jwVarMo680a3.f871a) {
                            this.f609c.put(jxVar.mo683a(), jxVar.mo683a());
                            i2++;
                        }
                        jxVar.h();
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
    public void m561a() throws jy {
        if (this.f600a != null) {
            return;
        }
        throw new jy("Required field 'id' was not present! Struct: " + toString());
    }
}
