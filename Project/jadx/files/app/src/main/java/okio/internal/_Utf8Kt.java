package okio.internal;

import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 4, 0})
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i2;
        int i3;
        char cCharAt;
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt2 = str.charAt(i4);
            if (i.a(cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char cCharAt3 = str.charAt(i4);
                    if (i.a(cCharAt3, 128) < 0) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) cCharAt3;
                        i4++;
                        while (i4 < length2 && i.a(str.charAt(i4), 128) < 0) {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (i.a(cCharAt3, 2048) < 0) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> 6) | 192);
                            byte b = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b2;
                        } else if (i.a(cCharAt3, 56319) > 0 || length2 <= (i3 = i4 + 1) || 56320 > (cCharAt = str.charAt(i3)) || 57343 < cCharAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((iCharAt >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((iCharAt >> 6) & 63) | 128);
                            byte b3 = (byte) ((iCharAt & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = b3;
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                return Arrays.copyOf(bArr, i5);
            }
            bArr[i4] = (byte) cCharAt2;
            i4++;
        }
        return Arrays.copyOf(bArr, str.length());
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x011b A[PHI: r6
  0x011b: PHI (r6v42 int) = (r6v39 int), (r6v44 int), (r6v44 int) binds: [B:103:0x0144, B:84:0x010e, B:89:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011e A[PHI: r6
  0x011e: PHI (r6v41 int) = (r6v40 int), (r6v44 int), (r6v44 int) binds: [B:97:0x0130, B:76:0x00fe, B:81:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@org.jetbrains.annotations.NotNull byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return commonToUtf8String(bArr, i2, i3);
    }
}
