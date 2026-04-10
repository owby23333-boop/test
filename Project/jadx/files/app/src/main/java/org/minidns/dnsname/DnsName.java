package org.minidns.dnsname;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.minidns.d.c;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsname.InvalidDnsNameException;

/* JADX INFO: loaded from: classes3.dex */
public final class DnsName implements CharSequence, Serializable, Comparable<DnsName> {
    public static boolean A;
    static final /* synthetic */ boolean B = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final DnsName f21472z = new DnsName(".");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f21473s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f21474t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private transient byte[] f21475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private transient DnsLabel[] f21476v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private transient DnsLabel[] f21477w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private transient int f21478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f21479y;

    static {
        new DnsName("in-addr.arpa");
        new DnsName("ip6.arpa");
        A = true;
    }

    private DnsName(String str) {
        this(str, true);
    }

    private static String a(DnsLabel[] dnsLabelArr, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            sb.append((CharSequence) dnsLabelArr[length]);
            sb.append('.');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static DnsLabel[] b(String str) {
        String[] strArrSplit = str.split("[.。．｡]", 128);
        for (int i2 = 0; i2 < strArrSplit.length / 2; i2++) {
            String str2 = strArrSplit[i2];
            int length = (strArrSplit.length - i2) - 1;
            strArrSplit[i2] = strArrSplit[length];
            strArrSplit[length] = str2;
        }
        try {
            return DnsLabel.a(strArrSplit);
        } catch (DnsLabel.LabelToLongException e2) {
            throw new InvalidDnsNameException.LabelTooLongException(str, e2.f21414s);
        }
    }

    private void k() {
        if (this.f21475u != null) {
            return;
        }
        l();
        this.f21475u = a(this.f21476v);
    }

    private void l() {
        if (this.f21476v == null || this.f21477w == null) {
            if (!i()) {
                this.f21476v = b(this.f21473s);
                this.f21477w = b(this.f21474t);
            } else {
                DnsLabel[] dnsLabelArr = new DnsLabel[0];
                this.f21476v = dnsLabelArr;
                this.f21477w = dnsLabelArr;
            }
        }
    }

    private void m() {
        k();
        byte[] bArr = this.f21475u;
        if (bArr.length > 255) {
            throw new InvalidDnsNameException.DNSNameTooLongException(this.f21473s, bArr);
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f21473s.charAt(i2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DnsName)) {
            return false;
        }
        DnsName dnsName = (DnsName) obj;
        k();
        dnsName.k();
        return Arrays.equals(this.f21475u, dnsName.f21475u);
    }

    public int f() {
        l();
        return this.f21476v.length;
    }

    public DnsName g() {
        return i() ? f21472z : b(f() - 1);
    }

    public String h() {
        return this.f21474t;
    }

    public int hashCode() {
        if (this.f21478x == 0 && !i()) {
            k();
            this.f21478x = Arrays.hashCode(this.f21475u);
        }
        return this.f21478x;
    }

    public boolean i() {
        return this.f21473s.isEmpty() || this.f21473s.equals(".");
    }

    public int j() {
        if (this.f21479y < 0) {
            if (i()) {
                this.f21479y = 1;
            } else {
                this.f21479y = this.f21473s.length() + 2;
            }
        }
        return this.f21479y;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f21473s.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f21473s.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f21473s;
    }

    private DnsName(String str, boolean z2) {
        this.f21479y = -1;
        if (str.isEmpty()) {
            this.f21474t = f21472z.f21474t;
        } else {
            int length = str.length();
            int i2 = length - 1;
            if (length >= 2 && str.charAt(i2) == '.') {
                str = str.subSequence(0, i2).toString();
            }
            if (z2) {
                this.f21474t = str;
            } else {
                this.f21474t = c.a(str);
            }
        }
        this.f21473s = this.f21474t.toLowerCase(Locale.US);
        if (A) {
            m();
        }
    }

    public void a(OutputStream outputStream) throws IOException {
        k();
        outputStream.write(this.f21475u);
    }

    private static byte[] a(DnsLabel[] dnsLabelArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            dnsLabelArr[length].a(byteArrayOutputStream);
        }
        byteArrayOutputStream.write(0);
        if (B || byteArrayOutputStream.size() <= 255) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new AssertionError();
    }

    public DnsName b(int i2) {
        l();
        DnsLabel[] dnsLabelArr = this.f21476v;
        if (i2 <= dnsLabelArr.length) {
            if (i2 == dnsLabelArr.length) {
                return this;
            }
            if (i2 == 0) {
                return f21472z;
            }
            return new DnsName((DnsLabel[]) Arrays.copyOfRange(this.f21477w, 0, i2), false);
        }
        throw new IllegalArgumentException();
    }

    private DnsName(DnsLabel[] dnsLabelArr, boolean z2) {
        this.f21479y = -1;
        this.f21477w = dnsLabelArr;
        this.f21476v = new DnsLabel[dnsLabelArr.length];
        int length = 0;
        for (int i2 = 0; i2 < dnsLabelArr.length; i2++) {
            length += dnsLabelArr[i2].length() + 1;
            this.f21476v[i2] = dnsLabelArr[i2].a();
        }
        this.f21474t = a(dnsLabelArr, length);
        this.f21473s = a(this.f21476v, length);
        if (z2 && A) {
            m();
        }
    }

    public static DnsName a(CharSequence charSequence) {
        return a(charSequence.toString());
    }

    public static DnsName a(String str) {
        return new DnsName(str, false);
    }

    public static DnsName a(DnsName dnsName, DnsName dnsName2) {
        dnsName.l();
        dnsName2.l();
        int length = dnsName.f21477w.length;
        DnsLabel[] dnsLabelArr = dnsName2.f21477w;
        DnsLabel[] dnsLabelArr2 = new DnsLabel[length + dnsLabelArr.length];
        System.arraycopy(dnsLabelArr, 0, dnsLabelArr2, 0, dnsLabelArr.length);
        DnsLabel[] dnsLabelArr3 = dnsName.f21477w;
        System.arraycopy(dnsLabelArr3, 0, dnsLabelArr2, dnsName2.f21477w.length, dnsLabelArr3.length);
        return new DnsName(dnsLabelArr2, true);
    }

    public static DnsName a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int unsignedByte = dataInputStream.readUnsignedByte();
        if ((unsignedByte & 192) == 192) {
            int unsignedByte2 = ((unsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(unsignedByte2));
            return a(bArr, unsignedByte2, hashSet);
        }
        if (unsignedByte == 0) {
            return f21472z;
        }
        byte[] bArr2 = new byte[unsignedByte];
        dataInputStream.readFully(bArr2);
        return a(new DnsName(new String(bArr2, StandardCharsets.US_ASCII)), a(dataInputStream, bArr));
    }

    private static DnsName a(byte[] bArr, int i2, HashSet<Integer> hashSet) throws IllegalStateException {
        int i3 = bArr[i2] & 255;
        if ((i3 & 192) != 192) {
            if (i3 == 0) {
                return f21472z;
            }
            int i4 = i2 + 1;
            return a(new DnsName(new String(bArr, i4, i3, StandardCharsets.US_ASCII)), a(bArr, i4 + i3, hashSet));
        }
        int i5 = ((i3 & 63) << 8) + (bArr[i2 + 1] & 255);
        if (!hashSet.contains(Integer.valueOf(i5))) {
            hashSet.add(Integer.valueOf(i5));
            return a(bArr, i5, hashSet);
        }
        throw new IllegalStateException("Cyclic offsets detected.");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DnsName dnsName) {
        return this.f21473s.compareTo(dnsName.f21473s);
    }
}
