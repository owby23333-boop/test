package okhttp3;

import com.anythink.expressad.d.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.g;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.s;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000¢\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", TTDownloadField.TT_HASHCODE, "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CertificatePinner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final Set<Pin> pins;

    /* JADX INFO: compiled from: CertificatePinner.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", b.ay, "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final Builder add(@NotNull String pattern, @NotNull String... pins) {
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(s.f((Iterable) this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
            return ByteString.Companion.of$default(ByteString.INSTANCE, x509Certificate.getPublicKey().getEncoded(), 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
            return ByteString.Companion.of$default(ByteString.INSTANCE, x509Certificate.getPublicKey().getEncoded(), 0, 0, 3, null).sha256();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Pin {

        @NotNull
        private final ByteString hash;

        @NotNull
        private final String hashAlgorithm;

        @NotNull
        private final String pattern;

        public Pin(@NotNull String str, @NotNull String str2) {
            if (!((n.b(str, "*.", false, 2, null) && StringsKt__StringsKt.a((CharSequence) str, "*", 1, false, 4, (Object) null) == -1) || (n.b(str, "**.", false, 2, null) && StringsKt__StringsKt.a((CharSequence) str, "*", 2, false, 4, (Object) null) == -1) || StringsKt__StringsKt.a((CharSequence) str, "*", 0, false, 6, (Object) null) == -1)) {
                throw new IllegalArgumentException(("Unexpected pattern: " + str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: " + str);
            }
            this.pattern = canonicalHost;
            if (n.b(str2, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                ByteString byteStringDecodeBase64 = ByteString.INSTANCE.decodeBase64(str2.substring(5));
                if (byteStringDecodeBase64 != null) {
                    this.hash = byteStringDecodeBase64;
                    return;
                }
                throw new IllegalArgumentException("Invalid pin hash: " + str2);
            }
            if (!n.b(str2, "sha256/", false, 2, null)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            this.hashAlgorithm = "sha256";
            ByteString byteStringDecodeBase642 = ByteString.INSTANCE.decodeBase64(str2.substring(7));
            if (byteStringDecodeBase642 != null) {
                this.hash = byteStringDecodeBase642;
                return;
            }
            throw new IllegalArgumentException("Invalid pin hash: " + str2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) other;
            return ((i.a((Object) this.pattern, (Object) pin.pattern) ^ true) || (i.a((Object) this.hashAlgorithm, (Object) pin.hashAlgorithm) ^ true) || (i.a(this.hash, pin.hash) ^ true)) ? false : true;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            String str = this.hashAlgorithm;
            int iHashCode = str.hashCode();
            if (iHashCode != -903629273) {
                if (iHashCode == 3528965 && str.equals("sha1")) {
                    return i.a(this.hash, CertificatePinner.INSTANCE.sha1Hash(certificate));
                }
            } else if (str.equals("sha256")) {
                return i.a(this.hash, CertificatePinner.INSTANCE.sha256Hash(certificate));
            }
            return false;
        }

        /* JADX WARN: Failed to inline method: kotlin.text.f.a(java.lang.String, int, java.lang.String, int, int, boolean, int, java.lang.Object):boolean */
        /* JADX WARN: Unknown register number '(r14v0 'hostname' java.lang.String)' in method call: kotlin.text.f.a(java.lang.String, int, java.lang.String, int, int, boolean, int, java.lang.Object):boolean */
        public final boolean matchesHostname(@NotNull String hostname) {
            if (n.b(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (!n.a(hostname, hostname.length() - length, this.pattern, 3, length, (hostname & 16) != 0 ? false : false)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!n.b(this.pattern, "*.", false, 2, null)) {
                    return i.a((Object) hostname, (Object) this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                if (!kotlin.text.f.a(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, (Object) null) || StringsKt__StringsKt.b((CharSequence) hostname, '.', length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(@NotNull Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return INSTANCE.pin(certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return INSTANCE.sha1Hash(x509Certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return INSTANCE.sha256Hash(x509Certificate);
    }

    public final void check(@NotNull final String hostname, @NotNull final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        check$okhttp(hostname, new a<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner.check.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.b.a
            @NotNull
            public final List<? extends X509Certificate> invoke() {
                List<Certificate> listClean;
                CertificateChainCleaner certificateChainCleaner = CertificatePinner.this.getCertificateChainCleaner();
                if (certificateChainCleaner == null || (listClean = certificateChainCleaner.clean(peerCertificates, hostname)) == null) {
                    listClean = peerCertificates;
                }
                ArrayList arrayList = new ArrayList(l.a(listClean, 10));
                for (Certificate certificate : listClean) {
                    if (certificate == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(@NotNull String str, @NotNull a<? extends List<? extends X509Certificate>> aVar) throws SSLPeerUnverifiedException {
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = aVar.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ByteString byteStringSha256Hash = null;
            ByteString byteStringSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int iHashCode = hashAlgorithm.hashCode();
                if (iHashCode != -903629273) {
                    if (iHashCode != 3528965 || !hashAlgorithm.equals("sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (byteStringSha1Hash == null) {
                        byteStringSha1Hash = INSTANCE.sha1Hash(x509Certificate);
                    }
                    if (i.a(pin.getHash(), byteStringSha1Hash)) {
                        return;
                    }
                } else {
                    if (!hashAlgorithm.equals("sha256")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (byteStringSha256Hash == null) {
                        byteStringSha256Hash = INSTANCE.sha256Hash(x509Certificate);
                    }
                    if (i.a(pin.getHash(), byteStringSha256Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(INSTANCE.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) other;
            if (i.a(certificatePinner.pins, this.pins) && i.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String hostname) {
        Set<Pin> set = this.pins;
        List<Pin> listA = k.a();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (listA.isEmpty()) {
                    listA = new ArrayList<>();
                }
                if (listA == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<T>");
                }
                kotlin.jvm.internal.n.a(listA).add(obj);
            }
        }
        return listA;
    }

    @Nullable
    /* JADX INFO: renamed from: getCertificateChainCleaner$okhttp, reason: from getter */
    public final CertificateChainCleaner getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        return i.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i2, f fVar) {
        this(set, (i2 & 2) != 0 ? null : certificateChainCleaner);
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@NotNull String hostname, @NotNull Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        check(hostname, g.f(peerCertificates));
    }
}
