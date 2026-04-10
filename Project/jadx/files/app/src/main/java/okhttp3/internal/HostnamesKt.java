package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: hostnames.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (i.a(cCharAt, 31) <= 0 || i.a(cCharAt, 127) >= 0 || StringsKt__StringsKt.a((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (i.a(cCharAt, 48) < 0 || i.a(cCharAt, 57) > 0) {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        if (r12 == r8.length) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        if (r13 != (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009d, code lost:
    
        r1 = r12 - r13;
        java.lang.System.arraycopy(r8, r13, r8, r8.length - r1, r1);
        java.util.Arrays.fill(r8, r13, (r8.length - r12) + r13, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b0, code lost:
    
        return java.net.InetAddress.getByAddress(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r17, int r18, int r19) {
        /*
            r6 = r17
            r7 = r19
            r0 = 16
            byte[] r8 = new byte[r0]
            r10 = -1
            r11 = r18
            r12 = 0
            r13 = -1
            r14 = -1
        Le:
            r15 = 0
            if (r11 >= r7) goto L97
            int r0 = r8.length
            if (r12 != r0) goto L15
            return r15
        L15:
            int r5 = r11 + 2
            if (r5 > r7) goto L38
            r3 = 0
            r4 = 4
            r16 = 0
            java.lang.String r1 = "::"
            r0 = r17
            r2 = r11
            r9 = r5
            r5 = r16
            boolean r0 = kotlin.text.f.a(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L38
            if (r13 == r10) goto L2e
            return r15
        L2e:
            int r12 = r12 + 2
            if (r9 != r7) goto L35
            r13 = r12
            goto L97
        L35:
            r14 = r9
            r13 = r12
            goto L67
        L38:
            if (r12 == 0) goto L66
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r0 = r17
            r2 = r11
            boolean r0 = kotlin.text.f.a(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L4b
            int r11 = r11 + 1
            goto L66
        L4b:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r0 = r17
            r2 = r11
            boolean r0 = kotlin.text.f.a(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L65
            int r0 = r12 + (-2)
            boolean r0 = decodeIpv4Suffix(r6, r14, r7, r8, r0)
            if (r0 != 0) goto L62
            return r15
        L62:
            int r12 = r12 + 2
            goto L97
        L65:
            return r15
        L66:
            r14 = r11
        L67:
            r11 = r14
            r0 = 0
        L69:
            if (r11 >= r7) goto L7c
            char r1 = r6.charAt(r11)
            int r1 = okhttp3.internal.Util.parseHexDigit(r1)
            if (r1 != r10) goto L76
            goto L7c
        L76:
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r11 = r11 + 1
            goto L69
        L7c:
            int r1 = r11 - r14
            if (r1 == 0) goto L96
            r2 = 4
            if (r1 <= r2) goto L84
            goto L96
        L84:
            int r1 = r12 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r8[r12] = r2
            int r12 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r8[r1] = r0
            goto Le
        L96:
            return r15
        L97:
            int r0 = r8.length
            if (r12 == r0) goto Lac
            if (r13 != r10) goto L9d
            return r15
        L9d:
            int r0 = r8.length
            int r1 = r12 - r13
            int r0 = r0 - r1
            java.lang.System.arraycopy(r8, r13, r8, r0, r1)
            int r0 = r8.length
            int r0 = r0 - r12
            int r0 = r0 + r13
            r1 = 0
            byte r1 = (byte) r1
            java.util.Arrays.fill(r8, r13, r0, r1)
        Lac:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i3 < bArr.length) {
            int i6 = i3;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i3;
            if (i7 > i5 && i7 >= 4) {
                i4 = i3;
                i5 = i7;
            }
            i3 = i6 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < bArr.length) {
            if (i2 == i4) {
                buffer.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String str) {
        if (!StringsKt__StringsKt.a((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                Locale locale = Locale.US;
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                if ((lowerCase.length() == 0) || containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (n.b(str, "[", false, 2, null) && n.a(str, "]", false, 2, null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length == 16) {
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return inetAddressDecodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
