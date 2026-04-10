package org.minidns.dnsname;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InvalidDnsNameException extends IllegalStateException {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final String f21480s;

    public static class DNSNameTooLongException extends InvalidDnsNameException {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final byte[] f21481t;

        public DNSNameTooLongException(String str, byte[] bArr) {
            super(str);
            this.f21481t = bArr;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "The DNS name '" + this.f21480s + "' exceeds the maximum name length of 255 octets by " + (this.f21481t.length - 255) + " octets.";
        }
    }

    public static class LabelTooLongException extends InvalidDnsNameException {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final String f21482t;

        public LabelTooLongException(String str, String str2) {
            super(str);
            this.f21482t = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "The DNS name '" + this.f21480s + "' contains the label '" + this.f21482t + "' which exceeds the maximum label length of 63 octets by " + (this.f21482t.length() - 63) + " octets.";
        }
    }

    protected InvalidDnsNameException(String str) {
        this.f21480s = str;
    }
}
