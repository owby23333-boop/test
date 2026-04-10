package org.minidns.record;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.minidns.dnsname.DnsName;
import org.minidns.record.h;

/* JADX INFO: loaded from: classes3.dex */
public final class Record<D extends h> {
    public final DnsName a;
    public final TYPE b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CLASS f21535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f21537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D f21538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient byte[] f21539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Integer f21540h;

    public enum CLASS {
        IN(1),
        CH(3),
        HS(4),
        NONE(254),
        ANY(255);


        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final HashMap<Integer, CLASS> f21546y = new HashMap<>();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f21548s;

        static {
            for (CLASS r3 : values()) {
                f21546y.put(Integer.valueOf(r3.f()), r3);
            }
        }

        CLASS(int i2) {
            this.f21548s = i2;
        }

        public static CLASS b(int i2) {
            return f21546y.get(Integer.valueOf(i2));
        }

        public int f() {
            return this.f21548s;
        }
    }

    public enum TYPE {
        UNKNOWN(-1),
        A(1, org.minidns.record.a.class),
        NS(2, l.class),
        MD(3),
        MF(4),
        CNAME(5, c.class),
        SOA(6, t.class),
        MB(7),
        MG(8),
        MR(9),
        NULL(10),
        WKS(11),
        PTR(12, q.class),
        HINFO(13),
        MINFO(14),
        MX(15, k.class),
        TXT(16, v.class),
        RP(17),
        AFSDB(18),
        X25(19),
        ISDN(20),
        RT(21),
        NSAP(22),
        NSAP_PTR(23),
        SIG(24),
        KEY(25),
        PX(26),
        GPOS(27),
        AAAA(28, b.class),
        LOC(29),
        NXT(30),
        EID(31),
        NIMLOC(32),
        SRV(33, u.class),
        ATMA(34),
        NAPTR(35),
        KX(36),
        CERT(37),
        A6(38),
        DNAME(39, e.class),
        SINK(40),
        OPT(41, p.class),
        APL(42),
        DS(43, g.class),
        SSHFP(44),
        IPSECKEY(45),
        RRSIG(46, r.class),
        NSEC(47, n.class),
        DNSKEY(48, f.class),
        DHCID(49),
        NSEC3(50, NSEC3.class),
        NSEC3PARAM(51, m.class),
        TLSA(52, TLSA.class),
        HIP(55),
        NINFO(56),
        RKEY(57),
        TALINK(58),
        CDS(59),
        CDNSKEY(60),
        OPENPGPKEY(61, o.class),
        CSYNC(62),
        SPF(99),
        UINFO(100),
        UID(101),
        GID(102),
        UNSPEC(103),
        NID(104),
        L32(105),
        L64(106),
        LP(107),
        EUI48(108),
        EUI64(109),
        TKEY(249),
        TSIG(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION),
        IXFR(251),
        AXFR(252),
        MAILB(253),
        MAILA(254),
        ANY(255),
        URI(256),
        CAA(InputDeviceCompat.SOURCE_KEYBOARD),
        TA(32768),
        DLV(com.umeng.commonsdk.internal.a.f19974f, d.class);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f21583s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class<?> f21584t;
        private static final Map<Integer, TYPE> Z0 = new HashMap();

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        private static final Map<Class<?>, TYPE> f21550a1 = new HashMap();

        static {
            for (TYPE type : values()) {
                Z0.put(Integer.valueOf(type.g()), type);
                Class<?> cls = type.f21584t;
                if (cls != null) {
                    f21550a1.put(cls, type);
                }
            }
        }

        TYPE(int i2) {
            this(i2, null);
        }

        public static TYPE getType(int i2) {
            TYPE type = Z0.get(Integer.valueOf(i2));
            return type == null ? UNKNOWN : type;
        }

        public <D extends h> Class<D> f() {
            return (Class<D>) this.f21584t;
        }

        public int g() {
            return this.f21583s;
        }

        TYPE(int i2, Class cls) {
            this.f21583s = i2;
            this.f21584t = cls;
        }

        public static <D extends h> TYPE getType(Class<D> cls) {
            return f21550a1.get(cls);
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[TYPE.values().length];

        static {
            try {
                a[TYPE.SOA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TYPE.SRV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TYPE.MX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TYPE.AAAA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TYPE.A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TYPE.NS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TYPE.CNAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[TYPE.DNAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[TYPE.PTR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[TYPE.TXT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[TYPE.OPT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[TYPE.DNSKEY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[TYPE.RRSIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[TYPE.DS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[TYPE.NSEC.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[TYPE.NSEC3.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[TYPE.NSEC3PARAM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[TYPE.TLSA.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[TYPE.OPENPGPKEY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[TYPE.DLV.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[TYPE.UNKNOWN.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public Record(DnsName dnsName, TYPE type, int i2, long j2, D d2) {
        this(dnsName, type, CLASS.NONE, i2, j2, d2, false);
    }

    public static Record<h> a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        h hVarA;
        DnsName dnsNameA = DnsName.a(dataInputStream, bArr);
        TYPE type = TYPE.getType(dataInputStream.readUnsignedShort());
        int unsignedShort = dataInputStream.readUnsignedShort();
        CLASS classB = CLASS.b(unsignedShort & 32767);
        boolean z2 = (32768 & unsignedShort) > 0;
        long unsignedShort2 = (((long) dataInputStream.readUnsignedShort()) << 16) + ((long) dataInputStream.readUnsignedShort());
        int unsignedShort3 = dataInputStream.readUnsignedShort();
        switch (a.a[type.ordinal()]) {
            case 1:
                hVarA = t.a(dataInputStream, bArr);
                break;
            case 2:
                hVarA = u.a(dataInputStream, bArr);
                break;
            case 3:
                hVarA = k.a(dataInputStream, bArr);
                break;
            case 4:
                hVarA = b.a(dataInputStream);
                break;
            case 5:
                hVarA = org.minidns.record.a.a(dataInputStream);
                break;
            case 6:
                hVarA = l.a(dataInputStream, bArr);
                break;
            case 7:
                hVarA = c.a(dataInputStream, bArr);
                break;
            case 8:
                hVarA = e.a(dataInputStream, bArr);
                break;
            case 9:
                hVarA = q.a(dataInputStream, bArr);
                break;
            case 10:
                hVarA = v.a(dataInputStream, unsignedShort3);
                break;
            case 11:
                hVarA = p.a(dataInputStream, unsignedShort3);
                break;
            case 12:
                hVarA = f.a(dataInputStream, unsignedShort3);
                break;
            case 13:
                hVarA = r.a(dataInputStream, bArr, unsignedShort3);
                break;
            case 14:
                hVarA = g.b(dataInputStream, unsignedShort3);
                break;
            case 15:
                hVarA = n.a(dataInputStream, bArr, unsignedShort3);
                break;
            case 16:
                hVarA = NSEC3.a(dataInputStream, unsignedShort3);
                break;
            case 17:
                hVarA = m.a(dataInputStream);
                break;
            case 18:
                hVarA = TLSA.a(dataInputStream, unsignedShort3);
                break;
            case 19:
                hVarA = o.a(dataInputStream, unsignedShort3);
                break;
            case 20:
                hVarA = d.b(dataInputStream, unsignedShort3);
                break;
            default:
                hVarA = w.a(dataInputStream, unsignedShort3, type);
                break;
        }
        return new Record<>(dnsNameA, type, classB, unsignedShort, unsignedShort2, hVarA, z2);
    }

    public byte[] b() {
        if (this.f21539g == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.a.j() + 10 + this.f21538f.a());
            try {
                a(new DataOutputStream(byteArrayOutputStream));
                this.f21539g = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
        return (byte[]) this.f21539g.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Record record = (Record) obj;
        return this.a.equals(record.a) && this.b == record.b && this.f21535c == record.f21535c && this.f21538f.equals(record.f21538f);
    }

    public int hashCode() {
        if (this.f21540h == null) {
            this.f21540h = Integer.valueOf(((((((this.a.hashCode() + 37) * 37) + this.b.hashCode()) * 37) + this.f21535c.hashCode()) * 37) + this.f21538f.hashCode());
        }
        return this.f21540h.intValue();
    }

    public String toString() {
        return this.a.h() + ".\t" + this.f21537e + '\t' + this.f21535c + '\t' + this.b + '\t' + this.f21538f;
    }

    private Record(DnsName dnsName, TYPE type, CLASS r3, int i2, long j2, D d2, boolean z2) {
        this.a = dnsName;
        this.b = type;
        this.f21535c = r3;
        this.f21536d = i2;
        this.f21537e = j2;
        this.f21538f = d2;
    }

    public void a(OutputStream outputStream) throws IOException {
        if (this.f21538f != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            this.a.a(dataOutputStream);
            dataOutputStream.writeShort(this.b.g());
            dataOutputStream.writeShort(this.f21536d);
            dataOutputStream.writeInt((int) this.f21537e);
            dataOutputStream.writeShort(this.f21538f.a());
            this.f21538f.b(dataOutputStream);
            return;
        }
        throw new IllegalStateException("Empty Record has no byte representation");
    }

    public boolean a(org.minidns.dnsmessage.a aVar) {
        CLASS r02;
        TYPE type = aVar.b;
        return (type == this.b || type == TYPE.ANY) && ((r02 = aVar.f21469c) == this.f21535c || r02 == CLASS.ANY) && aVar.a.equals(this.a);
    }

    public D a() {
        return this.f21538f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends h> Record<E> a(Class<E> cls) {
        if (this.b.f21584t == cls) {
            return this;
        }
        return null;
    }
}
