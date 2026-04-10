package org.minidns.dnslabel;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DnsLabel implements CharSequence, Comparable<DnsLabel> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f21410v;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f21411s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private transient DnsLabel f21412t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private transient byte[] f21413u;

    public static class LabelToLongException extends IllegalArgumentException {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final String f21414s;

        LabelToLongException(String str) {
            this.f21414s = str;
        }
    }

    static {
        a("*");
        f21410v = true;
    }

    protected DnsLabel(String str) {
        this.f21411s = str;
        if (f21410v) {
            b();
            if (this.f21413u.length > 63) {
                throw new LabelToLongException(str);
            }
        }
    }

    private void b() {
        if (this.f21413u == null) {
            this.f21413u = this.f21411s.getBytes(StandardCharsets.US_ASCII);
        }
    }

    public final DnsLabel a() {
        if (this.f21412t == null) {
            this.f21412t = a(this.f21411s.toLowerCase(Locale.US));
        }
        return this.f21412t;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f21411s.charAt(i2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DnsLabel) {
            return this.f21411s.equals(((DnsLabel) obj).f21411s);
        }
        return false;
    }

    public final int hashCode() {
        return this.f21411s.hashCode();
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f21411s.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return this.f21411s.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f21411s;
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        b();
        byteArrayOutputStream.write(this.f21413u.length);
        byte[] bArr = this.f21413u;
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(DnsLabel dnsLabel) {
        return a().f21411s.compareTo(dnsLabel.a().f21411s);
    }

    public static DnsLabel a(String str) {
        if (str != null && !str.isEmpty()) {
            if (c.c(str)) {
                return c.b(str);
            }
            return e.b(str);
        }
        throw new IllegalArgumentException("Label is null or empty");
    }

    public static DnsLabel[] a(String[] strArr) {
        DnsLabel[] dnsLabelArr = new DnsLabel[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            dnsLabelArr[i2] = a(strArr[i2]);
        }
        return dnsLabelArr;
    }
}
