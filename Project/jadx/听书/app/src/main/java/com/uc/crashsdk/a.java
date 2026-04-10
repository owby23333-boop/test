package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.uc.crashsdk.export.LogType;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2128a = "";
    public static String b = "";
    static final /* synthetic */ boolean d = true;
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    static boolean c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f2128a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    static long b() {
        return j;
    }

    static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f.add(str);
            }
            map.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str).append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    static void e() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static byte[] f() {
        return new byte[]{Ascii.CAN, 99, 121, 60};
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int iRemoveType;
        int iIntValue;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> map = k;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i3 = m;
                if (i3 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    m = i3 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i4 = n;
                if (i4 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    n = i4 + 1;
                }
            }
            if (LogType.isForUnexp(iRemoveType) && !LogType.isForUnexp(iIntValue)) {
                int i5 = o;
                if (i5 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                } else {
                    o = i5 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i6 = p;
                if (i6 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    p = i6 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z5 = false;
            } else {
                if (iIntValue == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return iRemoveType;
            }
            if (b.d && (1048833 & i2) != 0) {
                int iNativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForUnexp(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                }
                if (!LogType.isForANR(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(iRemoveType), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return iRemoveType;
        }
    }

    static void g() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), iIntValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #2 {all -> 0x00d8, blocks: (B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:17:0x003e), top: B:73:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:34:0x0080, B:36:0x009c, B:38:0x00a4, B:40:0x00b1, B:41:0x00b6), top: B:69:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:34:0x0080, B:36:0x009c, B:38:0x00a4, B:40:0x00b1, B:41:0x00b6), top: B:69:0x0080 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r18, java.lang.String r19, java.util.ArrayList<java.lang.String> r20) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String a(String str) {
        HashMap<String, Object[]> map = k;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            String str2 = (String) objArr[1];
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean zBooleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(zBooleanValue ? 1 : 0);
            if (!zBooleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:51:0x009a, B:53:0x00a1, B:55:0x00a9, B:57:0x00af, B:59:0x00b3, B:60:0x00b8, B:62:0x00be, B:64:0x00c6, B:66:0x00cc, B:68:0x00d0, B:69:0x00d5, B:71:0x00db, B:78:0x00ed, B:80:0x00ef, B:82:0x00f3, B:84:0x00f9, B:86:0x0105, B:88:0x010b, B:90:0x0112, B:91:0x0117, B:93:0x011d, B:95:0x0123, B:96:0x0128, B:98:0x012e, B:100:0x0134, B:102:0x013c, B:103:0x0158, B:75:0x00e5, B:42:0x007c, B:45:0x0081, B:46:0x008b, B:49:0x0092), top: B:108:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:51:0x009a, B:53:0x00a1, B:55:0x00a9, B:57:0x00af, B:59:0x00b3, B:60:0x00b8, B:62:0x00be, B:64:0x00c6, B:66:0x00cc, B:68:0x00d0, B:69:0x00d5, B:71:0x00db, B:78:0x00ed, B:80:0x00ef, B:82:0x00f3, B:84:0x00f9, B:86:0x0105, B:88:0x010b, B:90:0x0112, B:91:0x0117, B:93:0x011d, B:95:0x0123, B:96:0x0128, B:98:0x012e, B:100:0x0134, B:102:0x013c, B:103:0x0158, B:75:0x00e5, B:42:0x007c, B:45:0x0081, B:46:0x008b, B:49:0x0092), top: B:108:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    static void i() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, iIntValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|50|8|(3:57|10|(4:55|12|63|59)(4:54|16|(1:18)(1:19)|(1:24)(1:23)))(3:53|13|(4:56|15|60|59)(5:58|16|(0)(0)|(1:21)|24))|48|28|61|59|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        com.uc.crashsdk.e.a(r2, r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005f, B:21:0x0077, B:23:0x007d, B:24:0x0085, B:19:0x006d, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005f, B:21:0x0077, B:23:0x007d, B:24:0x0085, B:19:0x006d, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList<java.lang.String> r12) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    static String a(String str, boolean z2) {
        String string;
        HashMap<String, Object[]> map = q;
        synchronized (map) {
            Object[] objArr = map.get(str);
            long jLongValue = ((Long) objArr[2]).longValue();
            if (jLongValue != 0) {
                string = JNIBridge.nativeGetCallbackInfo(str, jLongValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                string = b(str, z2).toString();
            }
        }
        return string;
    }

    private static StringBuilder b(String str, boolean z2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    strA = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    if (callable != null) {
                        strA = (String) callable.call();
                    } else {
                        strA = d.a(str, z2);
                    }
                }
                if (strA != null) {
                    sb.append(strA);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    static String j() {
        String string;
        synchronized (q) {
            StringBuilder sb = new StringBuilder();
            List<String> list = r;
            synchronized (list) {
                boolean z2 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            }
            string = sb.toString();
        }
        return string;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0 A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:34:0x00c9, B:36:0x00d0, B:37:0x00d9, B:39:0x00de, B:41:0x00e2, B:42:0x00eb), top: B:61:0x00c9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00de A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:34:0x00c9, B:36:0x00d0, B:37:0x00d9, B:39:0x00de, B:41:0x00e2, B:42:0x00eb), top: B:61:0x00c9, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[1]).intValue();
                iRemoveType = LogType.addType(iIntValue, i3);
            } else {
                iRemoveType = i3;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i4 = C;
                if (i4 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    C = i4 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i5 = D;
                if (i5 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    D = i5 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i6 = E;
                if (i6 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    E = i6 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z2 = false;
            } else {
                if (iIntValue == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return iRemoveType;
            }
            if (b.d && (i3 & 1048577) != 0) {
                int iNativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, iRemoveType);
                if (!LogType.isForNative(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForANR(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(iRemoveType), new ArrayList()});
            return iRemoveType;
        }
    }

    public static int b(String str, String str2) {
        int iAddType;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr != null) {
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= iIntValue) {
                    list.remove(0);
                }
                list.add(str2);
                iAddType = LogType.isForJava(iIntValue2) ? LogType.addType(0, 16) : 0;
                if (!b.d) {
                    if (LogType.isForNative(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1);
                    }
                    if (LogType.isForANR(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1048576);
                    }
                }
                iAddType = iAddType;
                iAddType = iIntValue2;
            } else {
                iAddType = 0;
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1);
                }
                if (LogType.isForANR(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1048576);
                }
            }
        }
        return iAddType;
    }

    static void k() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & iIntValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, iIntValue, iIntValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void b(java.io.OutputStream r11, java.lang.String r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            int iIntValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(int i2, String str) {
        ?? r0;
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        if (!LogType.isForNative(i2) && !LogType.isForANR(i2)) {
            r0 = 0;
        } else if (b.d) {
            synchronized (y) {
                JNIBridge.nativeCmd(4, i2, str, null);
            }
            boolean zIsForNative = LogType.isForNative(i2);
            r0 = zIsForNative;
            if (LogType.isForANR(i2)) {
                r0 = (zIsForNative ? 1 : 0) | 1048576;
            }
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            r0 = 0;
        }
        if (!LogType.isForJava(i2)) {
            return r0;
        }
        a(str, Thread.currentThread());
        return r0 | 16;
    }

    public static boolean a(boolean z2) {
        int iG;
        if (!b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            iG = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.G() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            iG = g.G() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, iG);
        return true;
    }

    static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] strArrSplit = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static String m() throws Throwable {
        if (!G) {
            String strA = com.uc.crashsdk.a.b.a(b.m());
            g = strA;
            G = true;
            if (strA == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (H) {
            if (b.d) {
                JNIBridge.set(128, g);
            }
        } else {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String str = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + str);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b.d && c) {
                JNIBridge.nativeCmd(11, g.G(), String.valueOf(g.H()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 == 202) {
            p();
            String str = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
            g = m();
            if (b.d) {
                JNIBridge.set(128, g);
            }
            boolean z2 = !str.equals(g);
            if (z2) {
                com.uc.crashsdk.a.b.a(b.m(), str);
            }
            if (z2 && g.u()) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", g, str));
                b.v();
                return;
            }
            return;
        }
        if (!d) {
            throw new AssertionError();
        }
    }
}
