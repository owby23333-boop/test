package com.xiaomi.verificationsdk.internal;

import com.xiaomi.ad.common.util.SignatureUtils;
import com.yuewen.k12;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class CheckVirtual {
    private static final String TAG = "CheckVirtual";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String exec(java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L74
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L74
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            byte[] r5 = r5.getBytes()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r2.write(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r5 = 10
            r2.write(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r2.flush()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r2.close()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r1.waitFor()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            java.lang.String r5 = getStrFromBufferInputSteam(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L77
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r0 = move-exception
            r0.printStackTrace()
        L3e:
            r3.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r0 = move-exception
            r0.printStackTrace()
        L46:
            r1.destroy()
            return r5
        L4a:
            r5 = move-exception
            goto L4e
        L4c:
            r5 = move-exception
            r3 = r0
        L4e:
            r0 = r2
            goto L5a
        L50:
            r3 = r0
            goto L77
        L52:
            r5 = move-exception
            r3 = r0
            goto L5a
        L55:
            r2 = r0
            goto L76
        L57:
            r5 = move-exception
            r1 = r0
            r3 = r1
        L5a:
            if (r0 == 0) goto L64
            r0.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r0 = move-exception
            r0.printStackTrace()
        L64:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L6e
        L6a:
            r0 = move-exception
            r0.printStackTrace()
        L6e:
            if (r1 == 0) goto L73
            r1.destroy()
        L73:
            throw r5
        L74:
            r1 = r0
            r2 = r1
        L76:
            r3 = r2
        L77:
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L81
        L7d:
            r5 = move-exception
            r5.printStackTrace()
        L81:
            if (r3 == 0) goto L8b
            r3.close()     // Catch: java.io.IOException -> L87
            goto L8b
        L87:
            r5 = move-exception
            r5.printStackTrace()
        L8b:
            if (r1 == 0) goto L90
            r1.destroy()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.verificationsdk.internal.CheckVirtual.exec(java.lang.String):java.lang.String");
    }

    private static String getStrFromBufferInputSteam(BufferedInputStream bufferedInputStream) {
        int i;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (i >= 512);
        return sb.toString();
    }

    public static String getUidStrFormat() throws Throwable {
        String strExec = exec("cat /proc/self/cgroup");
        if (strExec != null && strExec.length() != 0) {
            int iLastIndexOf = strExec.lastIndexOf("uid");
            int iLastIndexOf2 = strExec.lastIndexOf("/pid");
            if (iLastIndexOf < 0) {
                return null;
            }
            if (iLastIndexOf2 <= 0) {
                iLastIndexOf2 = strExec.length();
            }
            try {
                String strReplaceAll = strExec.substring(iLastIndexOf + 4, iLastIndexOf2).replaceAll(SignatureUtils.DELIMITER, "");
                if (isNumber(strReplaceAll)) {
                    return String.format("u0_a%d", Integer.valueOf(Integer.valueOf(strReplaceAll).intValue() + k12.d));
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRunInVirtual() throws Throwable {
        String[] strArrSplit;
        String uidStrFormat = getUidStrFormat();
        if (uidStrFormat == null) {
            throw new UnknownValueException("getUidStrFormat is null");
        }
        String strExec = exec("ps");
        if (strExec == null || strExec.isEmpty() || (strArrSplit = strExec.split(SignatureUtils.DELIMITER)) == null || strArrSplit.length <= 0) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (strArrSplit[i2].contains(uidStrFormat)) {
                int iLastIndexOf = strArrSplit[i2].lastIndexOf(" ");
                String str = strArrSplit[i2];
                if (new File(String.format("/data/data/%s", str.substring(iLastIndexOf <= 0 ? 0 : iLastIndexOf + 1, str.length()), Locale.CHINA)).exists()) {
                    i++;
                }
            }
        }
        return i > 1;
    }
}
