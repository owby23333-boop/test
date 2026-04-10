package com.bykv.vk.openvk.component.video.api.m;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final MessageDigest z = z();
    private static final char[] g = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private g() {
    }

    private static MessageDigest z() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(java.io.File r10) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55
            java.security.DigestInputStream r10 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55
            java.security.MessageDigest r2 = com.bykv.vk.openvk.component.video.api.m.g.z     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55
            r10.<init>(r1, r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55
            r1 = 8192(0x2000, float:1.148E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
        L11:
            int r2 = r10.read(r1)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r3 = -1
            if (r2 != r3) goto L11
            java.security.MessageDigest r1 = r10.getMessageDigest()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            byte[] r1 = r1.digest()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r2.<init>()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            int r3 = r1.length     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r4 = 0
            r5 = r4
        L28:
            if (r5 >= r3) goto L41
            r6 = r1[r5]     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            java.lang.String r7 = "%02x"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r8[r4] = r6     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            java.lang.String r6 = java.lang.String.format(r7, r8)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r2.append(r6)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            int r5 = r5 + 1
            goto L28
        L41:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L65
            r10.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r10 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r10)
        L4d:
            return r0
        L4e:
            r1 = move-exception
            goto L57
        L50:
            r10 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L66
        L55:
            r1 = move-exception
            r10 = r0
        L57:
            r1.getMessage()     // Catch: java.lang.Throwable -> L65
            if (r10 == 0) goto L64
            r10.close()     // Catch: java.lang.Exception -> L60
            goto L64
        L60:
            r10 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r10)
        L64:
            return r0
        L65:
            r0 = move-exception
        L66:
            if (r10 == 0) goto L70
            r10.close()     // Catch: java.lang.Exception -> L6c
            goto L70
        L6c:
            r10 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r10)
        L70:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.api.m.g.z(java.io.File):java.lang.String");
    }

    public static String z(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = z;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (g.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return z(bArrDigest);
    }

    public static String z(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = g;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
