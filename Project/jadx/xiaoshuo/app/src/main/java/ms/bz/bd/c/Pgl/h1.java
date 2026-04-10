package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class h1 {
    private static final String e = (String) pblk.a(16777217, 0, 0, "c57de6", new byte[]{66, 37, 75, 19, 95, 50, 115, Ascii.ESC, 116});
    private static final String bf = (String) pblk.a(16777217, 0, 0, "f53c3e", new byte[]{95, 54, 82, 19, Ascii.ESC, 115, 119, 17});
    private static final String d = (String) pblk.a(16777217, 0, 0, "94272e", new byte[]{Ascii.SO, 51, 64, 87, Ascii.CAN, 96, Utf8.REPLACEMENT_BYTE, 6});
    private static final String tg = (String) pblk.a(16777217, 0, 0, "daf379", new byte[]{101, 96});
    private static final String ga = (String) pblk.a(16777217, 0, 0, "57484f", new byte[]{44, 34});
    private static final String vn = (String) pblk.a(16777217, 0, 0, "a0403f", new byte[]{118, 38});
    private static final String p = (String) pblk.a(16777217, 0, 0, "62e22f", new byte[]{42, 49, Ascii.SO});
    private static final String v = (String) pblk.a(16777217, 0, 0, "a9b44b", new byte[]{125, 50, Ascii.US});
    private static final String zk = (String) pblk.a(16777217, 0, 0, "f46e72", new byte[]{116, 57, 87, Ascii.DC4});
    private static final FileFilter m = new pgla();

    public static class pgla implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches((String) pblk.a(16777217, 0, 0L, "d7b6dc", new byte[]{118, 37, 4, 121, Ascii.VT, 57, 62, 43}), file.getName());
        }
    }

    private static HashMap<String, String> bf() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) pblk.a(16777217, 0, 0L, "a1cf32", new byte[]{Utf8.REPLACEMENT_BYTE, 35, 2, Ascii.GS, Ascii.SI, 106, 97, 0, 39, Utf8.REPLACEMENT_BYTE, 126, 53, Ascii.US}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] strArrSplit = line.split((String) pblk.a(16777217, 0, 0L, "2b34e0", new byte[]{121}), 2);
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                if (map.get(strTrim) == null) {
                                    map.put(strTrim, strTrim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return map;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return map;
    }

    private static int d() {
        try {
            return new File((String) pblk.a(16777217, 0, 0L, "7b9773", new byte[]{105, 115, 83, 80, 71, 32, 49, 85, 97, 100, 35, 115, 5, 80, 17, 55, 32, 70, 101, 40, 37, 112, 95, Ascii.FF})).listFiles(m).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapBf = bf();
            jSONObject.put(zk, d());
            jSONObject.put(tg, e(mapBf, e));
            jSONObject.put(ga, e(mapBf, bf));
            jSONObject.put(p, e((String) pblk.a(16777217, 0, 0L, "4c27b4", new byte[]{106, 114, 88, 80, 18, 39, 50, 84, 106, 100, 32, 114, Ascii.SO, 80, 68, 48, 35, 71, 110, 40, 38, 113, 84, Ascii.FF, 94, 51, 34, 18, 44, 100, 53, 116, 71, 81, 88, 50, 120, 65, 115, 114, 44, 111, 71, 76, 98, 46, 54, 90, 92, 97, 55, 100, 80})));
            jSONObject.put(v, e((String) pblk.a(16777217, 0, 0L, "e26a75", new byte[]{59, 35, 92, 6, 71, 38, 99, 5, 110, 50, 113, 35, 10, 6, 17, 49, 114, Ascii.SYN, 106, 126, 119, 32, 80, 90, Ascii.VT, 50, 115, 67, 40, 50, 100, 37, 67, 7, Ascii.CR, 51, 41, 16, 119, 36, 125, 62, 67, Ascii.SUB, 55, 47, 111, Ascii.GS, 88, 55, 102, 53, 84})));
            jSONObject.put(vn, e(mapBf, d));
        } catch (Throwable unused) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) pblk.a(16777217, 0, 0L, "197896", new byte[]{59, 38}) : string.trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r11) {
        /*
            r0 = 121(0x79, float:1.7E-43)
            r1 = 0
            r2 = 1
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L37
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L37
            boolean r11 = r4.exists()     // Catch: java.lang.Throwable -> L37
            if (r11 != 0) goto L23
            r5 = 16777217(0x1000001, float:2.350989E-38)
            r6 = 0
            r7 = 0
            java.lang.String r9 = "807ec5"
            byte[] r10 = new byte[r2]     // Catch: java.lang.Throwable -> L37
            r10[r1] = r0     // Catch: java.lang.Throwable -> L37
            java.lang.Object r11 = ms.bz.bd.c.Pgl.pblk.a(r5, r6, r7, r9, r10)     // Catch: java.lang.Throwable -> L37
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L37
            return r11
        L23:
            java.io.FileReader r11 = new java.io.FileReader     // Catch: java.lang.Throwable -> L37
            r11.<init>(r4)     // Catch: java.lang.Throwable -> L37
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L39
            r4.close()     // Catch: java.lang.Throwable -> L40
            goto L40
        L35:
            r4 = r3
            goto L39
        L37:
            r11 = r3
            r4 = r11
        L39:
            if (r4 == 0) goto L3e
            r4.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            if (r11 == 0) goto L43
        L40:
            r11.close()     // Catch: java.lang.Throwable -> L43
        L43:
            if (r3 != 0) goto L58
            byte[] r9 = new byte[r2]
            r9[r1] = r0
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.String r8 = "8ed674"
            java.lang.Object r11 = ms.bz.bd.c.Pgl.pblk.a(r4, r5, r6, r8, r9)
            java.lang.String r11 = (java.lang.String) r11
            goto L5c
        L58:
            java.lang.String r11 = r3.trim()
        L5c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.h1.e(java.lang.String):java.lang.String");
    }

    private static String e(HashMap<String, String> map, String str) {
        String str2;
        try {
            str2 = map.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }
}
