package com.xiaomi.push;

import com.google.common.base.Ascii;
import com.yuewen.eq2;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.xiaomi.push.if, reason: invalid class name */
/* JADX INFO: loaded from: classes8.dex */
public class Cif implements jm<Cif, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f540a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f542a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f543b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f544b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f545c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f546d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f547e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f548f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f549g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final kc f537a = new kc("ClientUploadDataItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ju f8073a = new ju("", Ascii.VT, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ju f8074b = new ju("", Ascii.VT, 2);
    private static final ju c = new ju("", Ascii.VT, 3);
    private static final ju d = new ju("", (byte) 10, 4);
    private static final ju e = new ju("", (byte) 10, 5);
    private static final ju f = new ju("", (byte) 2, 6);
    private static final ju g = new ju("", Ascii.VT, 7);
    private static final ju h = new ju("", Ascii.VT, 8);
    private static final ju i = new ju("", Ascii.VT, 9);
    private static final ju j = new ju("", Ascii.CR, 10);
    private static final ju k = new ju("", Ascii.VT, 11);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m529a() {
    }

    public Cif b(String str) {
        this.f544b = str;
        return this;
    }

    public Cif c(String str) {
        this.f545c = str;
        return this;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m535d() {
        return this.f540a.get(0);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m536e() {
        return this.f540a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m532a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f540a.get(2);
    }

    public boolean g() {
        return this.f546d != null;
    }

    public boolean h() {
        return this.f547e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f548f != null;
    }

    public boolean j() {
        return this.f541a != null;
    }

    public boolean k() {
        return this.f549g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m531a()) {
            sb.append("channel:");
            String str = this.f539a;
            if (str == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m533b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f544b;
            if (str2 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m534c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f545c;
            if (str3 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m535d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f538a);
            z = false;
        }
        if (m536e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f543b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f542a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f546d;
            if (str4 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f547e;
            if (str5 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f548f;
            if (str6 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f541a;
            if (map == null) {
                sb.append(eq2.g);
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f549g;
            if (str7 == null) {
                sb.append(eq2.g);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m527a() {
        return this.f539a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m533b() {
        return this.f544b != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m534c() {
        return this.f545c != null;
    }

    public Cif d(String str) {
        this.f546d = str;
        return this;
    }

    public Cif e(String str) {
        this.f547e = str;
        return this;
    }

    public Cif f(String str) {
        this.f548f = str;
        return this;
    }

    public Cif g(String str) {
        this.f549g = str;
        return this;
    }

    public Cif a(String str) {
        this.f539a = str;
        return this;
    }

    public String b() {
        return this.f545c;
    }

    public void c(boolean z) {
        this.f540a.set(2, z);
    }

    public String d() {
        return this.f548f;
    }

    public String e() {
        return this.f549g;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m531a() {
        return this.f539a != null;
    }

    public Cif b(long j2) {
        this.f543b = j2;
        b(true);
        return this;
    }

    public String c() {
        return this.f547e;
    }

    public Cif a(long j2) {
        this.f538a = j2;
        m530a(true);
        return this;
    }

    public void b(boolean z) {
        this.f540a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m530a(boolean z) {
        this.f540a.set(0, z);
    }

    @Override // com.xiaomi.push.jm
    public void b(jx jxVar) {
        m529a();
        jxVar.a(f537a);
        if (this.f539a != null && m531a()) {
            jxVar.a(f8073a);
            jxVar.a(this.f539a);
            jxVar.b();
        }
        if (this.f544b != null && m533b()) {
            jxVar.a(f8074b);
            jxVar.a(this.f544b);
            jxVar.b();
        }
        if (this.f545c != null && m534c()) {
            jxVar.a(c);
            jxVar.a(this.f545c);
            jxVar.b();
        }
        if (m535d()) {
            jxVar.a(d);
            jxVar.a(this.f538a);
            jxVar.b();
        }
        if (m536e()) {
            jxVar.a(e);
            jxVar.a(this.f543b);
            jxVar.b();
        }
        if (f()) {
            jxVar.a(f);
            jxVar.a(this.f542a);
            jxVar.b();
        }
        if (this.f546d != null && g()) {
            jxVar.a(g);
            jxVar.a(this.f546d);
            jxVar.b();
        }
        if (this.f547e != null && h()) {
            jxVar.a(h);
            jxVar.a(this.f547e);
            jxVar.b();
        }
        if (this.f548f != null && i()) {
            jxVar.a(i);
            jxVar.a(this.f548f);
            jxVar.b();
        }
        if (this.f541a != null && j()) {
            jxVar.a(j);
            jxVar.a(new jw(Ascii.VT, Ascii.VT, this.f541a.size()));
            for (Map.Entry<String, String> entry : this.f541a.entrySet()) {
                jxVar.a(entry.getKey());
                jxVar.a(entry.getValue());
            }
            jxVar.d();
            jxVar.b();
        }
        if (this.f549g != null && k()) {
            jxVar.a(k);
            jxVar.a(this.f549g);
            jxVar.b();
        }
        jxVar.c();
        jxVar.mo686a();
    }

    public long a() {
        return this.f543b;
    }

    public Cif a(boolean z) {
        this.f542a = z;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f541a == null) {
            this.f541a = new HashMap();
        }
        this.f541a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m528a() {
        return this.f541a;
    }

    public Cif a(Map<String, String> map) {
        this.f541a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m532a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean zM531a = m531a();
        boolean zM531a2 = cif.m531a();
        if ((zM531a || zM531a2) && !(zM531a && zM531a2 && this.f539a.equals(cif.f539a))) {
            return false;
        }
        boolean zM533b = m533b();
        boolean zM533b2 = cif.m533b();
        if ((zM533b || zM533b2) && !(zM533b && zM533b2 && this.f544b.equals(cif.f544b))) {
            return false;
        }
        boolean zM534c = m534c();
        boolean zM534c2 = cif.m534c();
        if ((zM534c || zM534c2) && !(zM534c && zM534c2 && this.f545c.equals(cif.f545c))) {
            return false;
        }
        boolean zM535d = m535d();
        boolean zM535d2 = cif.m535d();
        if ((zM535d || zM535d2) && !(zM535d && zM535d2 && this.f538a == cif.f538a)) {
            return false;
        }
        boolean zM536e = m536e();
        boolean zM536e2 = cif.m536e();
        if ((zM536e || zM536e2) && !(zM536e && zM536e2 && this.f543b == cif.f543b)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = cif.f();
        if ((zF || zF2) && !(zF && zF2 && this.f542a == cif.f542a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = cif.g();
        if ((zG || zG2) && !(zG && zG2 && this.f546d.equals(cif.f546d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = cif.h();
        if ((zH || zH2) && !(zH && zH2 && this.f547e.equals(cif.f547e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = cif.i();
        if ((zI || zI2) && !(zI && zI2 && this.f548f.equals(cif.f548f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = cif.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f541a.equals(cif.f541a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = cif.k();
        if (zK || zK2) {
            return zK && zK2 && this.f549g.equals(cif.f549g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Cif cif) {
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
        if (!getClass().equals(cif.getClass())) {
            return getClass().getName().compareTo(cif.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m531a()).compareTo(Boolean.valueOf(cif.m531a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m531a() && (iA11 = jn.a(this.f539a, cif.f539a)) != 0) {
            return iA11;
        }
        int iCompareTo2 = Boolean.valueOf(m533b()).compareTo(Boolean.valueOf(cif.m533b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m533b() && (iA10 = jn.a(this.f544b, cif.f544b)) != 0) {
            return iA10;
        }
        int iCompareTo3 = Boolean.valueOf(m534c()).compareTo(Boolean.valueOf(cif.m534c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m534c() && (iA9 = jn.a(this.f545c, cif.f545c)) != 0) {
            return iA9;
        }
        int iCompareTo4 = Boolean.valueOf(m535d()).compareTo(Boolean.valueOf(cif.m535d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m535d() && (iA8 = jn.a(this.f538a, cif.f538a)) != 0) {
            return iA8;
        }
        int iCompareTo5 = Boolean.valueOf(m536e()).compareTo(Boolean.valueOf(cif.m536e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m536e() && (iA7 = jn.a(this.f543b, cif.f543b)) != 0) {
            return iA7;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA6 = jn.a(this.f542a, cif.f542a)) != 0) {
            return iA6;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA5 = jn.a(this.f546d, cif.f546d)) != 0) {
            return iA5;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA4 = jn.a(this.f547e, cif.f547e)) != 0) {
            return iA4;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA3 = jn.a(this.f548f, cif.f548f)) != 0) {
            return iA3;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA2 = jn.a(this.f541a, cif.f541a)) != 0) {
            return iA2;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (!k() || (iA = jn.a(this.f549g, cif.f549g)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.jm
    public void a(jx jxVar) {
        jxVar.mo682a();
        while (true) {
            ju juVarMo678a = jxVar.mo678a();
            byte b2 = juVarMo678a.f8143a;
            if (b2 == 0) {
                jxVar.f();
                m529a();
                return;
            }
            switch (juVarMo678a.f869a) {
                case 1:
                    if (b2 == 11) {
                        this.f539a = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f544b = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f545c = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f538a = jxVar.mo677a();
                        m530a(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f543b = jxVar.mo677a();
                        b(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f542a = jxVar.mo688a();
                        c(true);
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f546d = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f547e = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f548f = jxVar.mo683a();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jw jwVarMo680a = jxVar.mo680a();
                        this.f541a = new HashMap(jwVarMo680a.f871a * 2);
                        for (int i2 = 0; i2 < jwVarMo680a.f871a; i2++) {
                            this.f541a.put(jxVar.mo683a(), jxVar.mo683a());
                        }
                        jxVar.h();
                    } else {
                        ka.a(jxVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f549g = jxVar.mo683a();
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
}
