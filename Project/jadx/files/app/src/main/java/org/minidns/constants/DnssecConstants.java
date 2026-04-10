package org.minidns.constants;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DnssecConstants {
    private static final Map<Byte, SignatureAlgorithm> a = new HashMap();
    private static final Map<Byte, DigestAlgorithm> b = new HashMap();

    public enum DigestAlgorithm {
        SHA1(1, "SHA-1"),
        SHA256(2, "SHA-256"),
        GOST(3, "GOST R 34.11-94"),
        SHA384(4, "SHA-384");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final byte f21399s;

        DigestAlgorithm(int i2, String str) {
            if (i2 < 0 || i2 > 255) {
                throw new IllegalArgumentException();
            }
            this.f21399s = (byte) i2;
            DnssecConstants.b.put(Byte.valueOf(this.f21399s), this);
        }

        public static DigestAlgorithm a(byte b) {
            return (DigestAlgorithm) DnssecConstants.b.get(Byte.valueOf(b));
        }
    }

    public enum SignatureAlgorithm {
        RSAMD5(1, "RSA/MD5"),
        DH(2, "Diffie-Hellman"),
        DSA(3, "DSA/SHA1"),
        RSASHA1(5, "RSA/SHA-1"),
        DSA_NSEC3_SHA1(6, "DSA_NSEC3-SHA1"),
        RSASHA1_NSEC3_SHA1(7, "RSASHA1-NSEC3-SHA1"),
        RSASHA256(8, "RSA/SHA-256"),
        RSASHA512(10, "RSA/SHA-512"),
        ECC_GOST(12, "GOST R 34.10-2001"),
        ECDSAP256SHA256(13, "ECDSA Curve P-256 with SHA-256"),
        ECDSAP384SHA384(14, "ECDSA Curve P-384 with SHA-384"),
        INDIRECT(252, "Reserved for Indirect Keys"),
        PRIVATEDNS(253, "private algorithm"),
        PRIVATEOID(254, "private algorithm oid");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final byte f21407s;

        SignatureAlgorithm(int i2, String str) {
            if (i2 < 0 || i2 > 255) {
                throw new IllegalArgumentException();
            }
            this.f21407s = (byte) i2;
            DnssecConstants.a.put(Byte.valueOf(this.f21407s), this);
        }

        public static SignatureAlgorithm a(byte b) {
            return (SignatureAlgorithm) DnssecConstants.a.get(Byte.valueOf(b));
        }
    }
}
