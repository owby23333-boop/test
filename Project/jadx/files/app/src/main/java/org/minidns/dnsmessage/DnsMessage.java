package org.minidns.dnsmessage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.edns.Edns;
import org.minidns.record.Record;
import org.minidns.record.h;

/* JADX INFO: loaded from: classes3.dex */
public class DnsMessage {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Logger f21415v = Logger.getLogger(DnsMessage.class.getName());
    public final int a;
    public final OPCODE b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RESPONSE_CODE f21416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f21419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f21420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f21422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f21423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<org.minidns.dnsmessage.a> f21424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Record<? extends h>> f21425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Record<? extends h>> f21426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Record<? extends h>> f21427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f21428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f21429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private byte[] f21430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f21431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f21432s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private DnsMessage f21433t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private transient Integer f21434u;

    public enum OPCODE {
        QUERY,
        INVERSE_QUERY,
        STATUS,
        UNASSIGNED3,
        NOTIFY,
        UPDATE;


        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final OPCODE[] f21441z = new OPCODE[values().length];

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final byte f21442s = (byte) ordinal();

        static {
            for (OPCODE opcode : values()) {
                if (f21441z[opcode.f()] != null) {
                    throw new IllegalStateException();
                }
                f21441z[opcode.f()] = opcode;
            }
        }

        OPCODE() {
        }

        public static OPCODE b(int i2) throws IllegalArgumentException {
            if (i2 < 0 || i2 > 15) {
                throw new IllegalArgumentException();
            }
            OPCODE[] opcodeArr = f21441z;
            if (i2 >= opcodeArr.length) {
                return null;
            }
            return opcodeArr[i2];
        }

        public byte f() {
            return this.f21442s;
        }
    }

    public enum RESPONSE_CODE {
        NO_ERROR(0),
        FORMAT_ERR(1),
        SERVER_FAIL(2),
        NX_DOMAIN(3),
        NO_IMP(4),
        REFUSED(5),
        YXDOMAIN(6),
        YXRRSET(7),
        NXRRSET(8),
        NOT_AUTH(9),
        NOT_ZONE(10),
        BADVERS_BADSIG(16),
        BADKEY(17),
        BADTIME(18),
        BADMODE(19),
        BADNAME(20),
        BADALG(21),
        BADTRUNC(22),
        BADCOOKIE(23);

        private static final Map<Integer, RESPONSE_CODE> M = new HashMap(values().length);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final byte f21450s;

        static {
            for (RESPONSE_CODE response_code : values()) {
                M.put(Integer.valueOf(response_code.f21450s), response_code);
            }
        }

        RESPONSE_CODE(int i2) {
            this.f21450s = (byte) i2;
        }

        public static RESPONSE_CODE b(int i2) throws IllegalArgumentException {
            if (i2 < 0 || i2 > 65535) {
                throw new IllegalArgumentException();
            }
            return M.get(Integer.valueOf(i2));
        }

        public byte f() {
            return this.f21450s;
        }
    }

    private enum SectionName {
        answer,
        authority,
        additional
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[SectionName.values().length];

        static {
            try {
                a[SectionName.answer.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SectionName.authority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SectionName.additional.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b {
        private int a;
        private OPCODE b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RESPONSE_CODE f21455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f21457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f21458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f21459g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f21460h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f21461i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f21462j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f21463k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<org.minidns.dnsmessage.a> f21464l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<Record<? extends h>> f21465m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<Record<? extends h>> f21466n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private List<Record<? extends h>> f21467o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Edns.b f21468p;

        /* synthetic */ b(a aVar) {
            this();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Builder of DnsMessage");
            a(sb);
            return sb.toString();
        }

        /* synthetic */ b(DnsMessage dnsMessage, a aVar) {
            this(dnsMessage);
        }

        public Edns.b b() {
            if (this.f21468p == null) {
                this.f21468p = Edns.c();
            }
            return this.f21468p;
        }

        private b() {
            this.b = OPCODE.QUERY;
            this.f21455c = RESPONSE_CODE.NO_ERROR;
            this.f21463k = -1L;
        }

        public b a(int i2) {
            this.a = i2 & 65535;
            return this;
        }

        public b a(boolean z2) {
            this.f21459g = z2;
            return this;
        }

        public b a(org.minidns.dnsmessage.a aVar) {
            this.f21464l = new ArrayList(1);
            this.f21464l.add(aVar);
            return this;
        }

        private b(DnsMessage dnsMessage) {
            this.b = OPCODE.QUERY;
            this.f21455c = RESPONSE_CODE.NO_ERROR;
            this.f21463k = -1L;
            this.a = dnsMessage.a;
            this.b = dnsMessage.b;
            this.f21455c = dnsMessage.f21416c;
            this.f21456d = dnsMessage.f21417d;
            this.f21457e = dnsMessage.f21418e;
            this.f21458f = dnsMessage.f21419f;
            this.f21459g = dnsMessage.f21420g;
            this.f21460h = dnsMessage.f21421h;
            this.f21461i = dnsMessage.f21422i;
            this.f21462j = dnsMessage.f21423j;
            this.f21463k = dnsMessage.f21429p;
            this.f21464l = new ArrayList(dnsMessage.f21424k.size());
            this.f21464l.addAll(dnsMessage.f21424k);
            this.f21465m = new ArrayList(dnsMessage.f21425l.size());
            this.f21465m.addAll(dnsMessage.f21425l);
            this.f21466n = new ArrayList(dnsMessage.f21426m.size());
            this.f21466n.addAll(dnsMessage.f21426m);
            this.f21467o = new ArrayList(dnsMessage.f21427n.size());
            this.f21467o.addAll(dnsMessage.f21427n);
        }

        public DnsMessage a() {
            return new DnsMessage(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(StringBuilder sb) {
            sb.append('(');
            sb.append(this.a);
            sb.append(' ');
            sb.append(this.b);
            sb.append(' ');
            sb.append(this.f21455c);
            sb.append(' ');
            if (this.f21456d) {
                sb.append("resp[qr=1]");
            } else {
                sb.append("query[qr=0]");
            }
            if (this.f21457e) {
                sb.append(" aa");
            }
            if (this.f21458f) {
                sb.append(" tr");
            }
            if (this.f21459g) {
                sb.append(" rd");
            }
            if (this.f21460h) {
                sb.append(" ra");
            }
            if (this.f21461i) {
                sb.append(" ad");
            }
            if (this.f21462j) {
                sb.append(" cd");
            }
            sb.append(")\n");
            List<org.minidns.dnsmessage.a> list = this.f21464l;
            if (list != null) {
                for (Object obj : list) {
                    sb.append("[Q: ");
                    sb.append(obj);
                    sb.append("]\n");
                }
            }
            List<Record<? extends h>> list2 = this.f21465m;
            if (list2 != null) {
                for (Object obj2 : list2) {
                    sb.append("[A: ");
                    sb.append(obj2);
                    sb.append("]\n");
                }
            }
            List<Record<? extends h>> list3 = this.f21466n;
            if (list3 != null) {
                for (Object obj3 : list3) {
                    sb.append("[N: ");
                    sb.append(obj3);
                    sb.append("]\n");
                }
            }
            List<Record<? extends h>> list4 = this.f21467o;
            if (list4 != null) {
                for (Record<? extends h> record : list4) {
                    sb.append("[X: ");
                    Edns ednsA = Edns.a(record);
                    if (ednsA != null) {
                        sb.append(ednsA.toString());
                    } else {
                        sb.append(record);
                    }
                    sb.append("]\n");
                }
            }
            if (sb.charAt(sb.length() - 1) == '\n') {
                sb.setLength(sb.length() - 1);
            }
        }
    }

    protected DnsMessage(b bVar) {
        this.f21432s = -1L;
        this.a = bVar.a;
        this.b = bVar.b;
        this.f21416c = bVar.f21455c;
        this.f21429p = bVar.f21463k;
        this.f21417d = bVar.f21456d;
        this.f21418e = bVar.f21457e;
        this.f21419f = bVar.f21458f;
        this.f21420g = bVar.f21459g;
        this.f21421h = bVar.f21460h;
        this.f21422i = bVar.f21461i;
        this.f21423j = bVar.f21462j;
        if (bVar.f21464l == null) {
            this.f21424k = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(bVar.f21464l.size());
            arrayList.addAll(bVar.f21464l);
            this.f21424k = Collections.unmodifiableList(arrayList);
        }
        if (bVar.f21465m == null) {
            this.f21425l = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(bVar.f21465m.size());
            arrayList2.addAll(bVar.f21465m);
            this.f21425l = Collections.unmodifiableList(arrayList2);
        }
        if (bVar.f21466n == null) {
            this.f21426m = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(bVar.f21466n.size());
            arrayList3.addAll(bVar.f21466n);
            this.f21426m = Collections.unmodifiableList(arrayList3);
        }
        if (bVar.f21467o == null && bVar.f21468p == null) {
            this.f21427n = Collections.emptyList();
        } else {
            int size = bVar.f21467o != null ? 0 + bVar.f21467o.size() : 0;
            ArrayList arrayList4 = new ArrayList(bVar.f21468p != null ? size + 1 : size);
            if (bVar.f21467o != null) {
                arrayList4.addAll(bVar.f21467o);
            }
            if (bVar.f21468p != null) {
                arrayList4.add(bVar.f21468p.a().a());
            }
            this.f21427n = Collections.unmodifiableList(arrayList4);
        }
        this.f21428o = a(this.f21427n);
        int i2 = this.f21428o;
        if (i2 != -1) {
            do {
                i2++;
                if (i2 >= this.f21427n.size()) {
                    return;
                }
            } while (this.f21427n.get(i2).b != Record.TYPE.OPT);
            throw new IllegalArgumentException("There must be only one OPT pseudo RR in the additional section");
        }
    }

    private static int a(List<Record<? extends h>> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).b == Record.TYPE.OPT) {
                return i2;
            }
        }
        return -1;
    }

    public static b g() {
        return new b((a) null);
    }

    private byte[] h() {
        byte[] bArr = this.f21430q;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int iC = c();
        try {
            dataOutputStream.writeShort((short) this.a);
            dataOutputStream.writeShort((short) iC);
            if (this.f21424k == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) this.f21424k.size());
            }
            if (this.f21425l == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) this.f21425l.size());
            }
            if (this.f21426m == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) this.f21426m.size());
            }
            if (this.f21427n == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) this.f21427n.size());
            }
            if (this.f21424k != null) {
                Iterator<org.minidns.dnsmessage.a> it = this.f21424k.iterator();
                while (it.hasNext()) {
                    dataOutputStream.write(it.next().b());
                }
            }
            if (this.f21425l != null) {
                Iterator<Record<? extends h>> it2 = this.f21425l.iterator();
                while (it2.hasNext()) {
                    dataOutputStream.write(it2.next().b());
                }
            }
            if (this.f21426m != null) {
                Iterator<Record<? extends h>> it3 = this.f21426m.iterator();
                while (it3.hasNext()) {
                    dataOutputStream.write(it3.next().b());
                }
            }
            if (this.f21427n != null) {
                Iterator<Record<? extends h>> it4 = this.f21427n.iterator();
                while (it4.hasNext()) {
                    dataOutputStream.write(it4.next().b());
                }
            }
            dataOutputStream.flush();
            this.f21430q = byteArrayOutputStream.toByteArray();
            return this.f21430q;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public DnsMessage b() {
        if (this.f21433t == null) {
            this.f21433t = new DnsMessage(this);
        }
        return this.f21433t;
    }

    int c() {
        int iF = this.f21417d ? 32768 : 0;
        OPCODE opcode = this.b;
        if (opcode != null) {
            iF += opcode.f() << 11;
        }
        if (this.f21418e) {
            iF += 1024;
        }
        if (this.f21419f) {
            iF += 512;
        }
        if (this.f21420g) {
            iF += 256;
        }
        if (this.f21421h) {
            iF += 128;
        }
        if (this.f21422i) {
            iF += 32;
        }
        if (this.f21423j) {
            iF += 16;
        }
        RESPONSE_CODE response_code = this.f21416c;
        return response_code != null ? iF + response_code.f() : iF;
    }

    public List<Record<? extends h>> d() {
        ArrayList arrayList = new ArrayList(this.f21426m.size());
        arrayList.addAll(this.f21426m);
        return arrayList;
    }

    public long e() {
        long j2 = this.f21432s;
        if (j2 >= 0) {
            return j2;
        }
        this.f21432s = Long.MAX_VALUE;
        Iterator<Record<? extends h>> it = this.f21425l.iterator();
        while (it.hasNext()) {
            this.f21432s = Math.min(this.f21432s, it.next().f21537e);
        }
        return this.f21432s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(h(), ((DnsMessage) obj).h());
    }

    public org.minidns.dnsmessage.a f() {
        return this.f21424k.get(0);
    }

    public int hashCode() {
        if (this.f21434u == null) {
            this.f21434u = Integer.valueOf(Arrays.hashCode(h()));
        }
        return this.f21434u.intValue();
    }

    public String toString() {
        String str = this.f21431r;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder("DnsMessage");
        a().a(sb);
        this.f21431r = sb.toString();
        return this.f21431r;
    }

    public DatagramPacket a(InetAddress inetAddress, int i2) {
        byte[] bArrH = h();
        return new DatagramPacket(bArrH, bArrH.length, inetAddress, i2);
    }

    public void a(OutputStream outputStream) throws IOException {
        a(outputStream, true);
    }

    public void a(OutputStream outputStream, boolean z2) throws IOException {
        byte[] bArrH = h();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        if (z2) {
            dataOutputStream.writeShort(bArrH.length);
        }
        dataOutputStream.write(bArrH);
    }

    public <D extends h> Set<D> a(org.minidns.dnsmessage.a aVar) {
        if (this.f21416c != RESPONSE_CODE.NO_ERROR) {
            return null;
        }
        HashSet hashSet = new HashSet(this.f21425l.size());
        for (Record<? extends h> record : this.f21425l) {
            if (record.a(aVar) && !hashSet.add(record.a())) {
                f21415v.log(Level.WARNING, "DnsMessage contains duplicate answers. Record: " + record + "; DnsMessage: " + this);
            }
        }
        return hashSet;
    }

    public b a() {
        return new b(this, null);
    }

    public DnsMessage(byte[] bArr) throws IOException {
        this.f21432s = -1L;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.a = dataInputStream.readUnsignedShort();
        int unsignedShort = dataInputStream.readUnsignedShort();
        this.f21417d = ((unsignedShort >> 15) & 1) == 1;
        this.b = OPCODE.b((unsignedShort >> 11) & 15);
        this.f21418e = ((unsignedShort >> 10) & 1) == 1;
        this.f21419f = ((unsignedShort >> 9) & 1) == 1;
        this.f21420g = ((unsignedShort >> 8) & 1) == 1;
        this.f21421h = ((unsignedShort >> 7) & 1) == 1;
        this.f21422i = ((unsignedShort >> 5) & 1) == 1;
        this.f21423j = ((unsignedShort >> 4) & 1) == 1;
        this.f21416c = RESPONSE_CODE.b(unsignedShort & 15);
        this.f21429p = System.currentTimeMillis();
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        int unsignedShort3 = dataInputStream.readUnsignedShort();
        int unsignedShort4 = dataInputStream.readUnsignedShort();
        int unsignedShort5 = dataInputStream.readUnsignedShort();
        this.f21424k = new ArrayList(unsignedShort2);
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            this.f21424k.add(new org.minidns.dnsmessage.a(dataInputStream, bArr));
        }
        this.f21425l = new ArrayList(unsignedShort3);
        for (int i3 = 0; i3 < unsignedShort3; i3++) {
            this.f21425l.add(Record.a(dataInputStream, bArr));
        }
        this.f21426m = new ArrayList(unsignedShort4);
        for (int i4 = 0; i4 < unsignedShort4; i4++) {
            this.f21426m.add(Record.a(dataInputStream, bArr));
        }
        this.f21427n = new ArrayList(unsignedShort5);
        for (int i5 = 0; i5 < unsignedShort5; i5++) {
            this.f21427n.add(Record.a(dataInputStream, bArr));
        }
        this.f21428o = a(this.f21427n);
    }

    private DnsMessage(DnsMessage dnsMessage) {
        this.f21432s = -1L;
        this.a = 0;
        this.f21417d = dnsMessage.f21417d;
        this.b = dnsMessage.b;
        this.f21418e = dnsMessage.f21418e;
        this.f21419f = dnsMessage.f21419f;
        this.f21420g = dnsMessage.f21420g;
        this.f21421h = dnsMessage.f21421h;
        this.f21422i = dnsMessage.f21422i;
        this.f21423j = dnsMessage.f21423j;
        this.f21416c = dnsMessage.f21416c;
        this.f21429p = dnsMessage.f21429p;
        this.f21424k = dnsMessage.f21424k;
        this.f21425l = dnsMessage.f21425l;
        this.f21426m = dnsMessage.f21426m;
        this.f21427n = dnsMessage.f21427n;
        this.f21428o = dnsMessage.f21428o;
    }
}
