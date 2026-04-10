package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static r f16766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Application f16767d;
    public boolean a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Random f16768f = new Random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, s> f16769g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Map<String, s> f16770h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    private r() {
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!dm.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String strA = f.a(file);
        return TextUtils.isEmpty(strA) ? new Pair<>(Boolean.FALSE, "") : !strA.equalsIgnoreCase(str) ? new Pair<>(Boolean.FALSE, strA) : new Pair<>(Boolean.TRUE, "");
    }

    public static r a() {
        return f16766c;
    }

    public static r a(Context context, boolean z2) {
        try {
            if (f16766c == null) {
                f16767d = (Application) context.getApplicationContext();
                f16766c = new r();
            }
        } catch (Throwable unused) {
        }
        return f16766c;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0131 A[EDGE_INSN: B:104:0x0131->B:50:0x0131 BREAK  A[LOOP:2: B:87:0x0126->B:49:0x012d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d A[Catch: all -> 0x014f, LOOP:2: B:87:0x0126->B:49:0x012d, LOOP_END, TryCatch #5 {all -> 0x014f, blocks: (B:47:0x0126, B:49:0x012d, B:50:0x0131, B:52:0x013a, B:53:0x013d), top: B:87:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013a A[Catch: all -> 0x014f, TryCatch #5 {all -> 0x014f, blocks: (B:47:0x0126, B:49:0x012d, B:50:0x0131, B:52:0x013a, B:53:0x013d), top: B:87:0x0126 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r17, java.lang.String r18, java.lang.String r19, java.util.HashSet<java.lang.String> r20, byte[] r21, java.lang.StringBuilder r22, boolean r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:26|(1:67)(6:30|247|31|(1:33)(1:35)|36|(5:50|254|51|(3:256|52|(1:54)(1:265))|55)(2:264|97))|242|68|(1:90)(10:73|240|74|238|75|(4:230|76|77|(3:234|79|267)(1:266))|80|(1:82)|83|84)|96|261|97|228|24) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01bf, code lost:
    
        r5 = r1;
        r7 = r3;
        r14 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0275 A[PHI: r10 r13 r14
  0x0275: PHI (r10v8 ??) = (r10v5 ??), (r10v6 ??), (r10v9 ??) binds: [B:129:0x023d, B:147:0x0273, B:138:0x0258] A[DONT_GENERATE, DONT_INLINE]
  0x0275: PHI (r13v8 ??) = (r13v5 ??), (r13v6 ??), (r13v9 ??) binds: [B:129:0x023d, B:147:0x0273, B:138:0x0258] A[DONT_GENERATE, DONT_INLINE]
  0x0275: PHI (r14v10 java.util.zip.ZipFile) = (r14v4 java.util.zip.ZipFile), (r14v5 java.util.zip.ZipFile), (r14v11 java.util.zip.ZipFile) binds: [B:129:0x023d, B:147:0x0273, B:138:0x0258] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396 A[Catch: all -> 0x045b, TryCatch #31 {all -> 0x045b, blocks: (B:186:0x0375, B:187:0x0388, B:189:0x0396, B:191:0x03a0, B:193:0x03aa, B:194:0x03ae, B:202:0x0418, B:203:0x0419, B:205:0x041d, B:207:0x0425, B:209:0x042d, B:196:0x03f2, B:198:0x03f4, B:199:0x0415, B:195:0x03af), top: B:249:0x0375, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x041d A[Catch: all -> 0x045b, TryCatch #31 {all -> 0x045b, blocks: (B:186:0x0375, B:187:0x0388, B:189:0x0396, B:191:0x03a0, B:193:0x03aa, B:194:0x03ae, B:202:0x0418, B:203:0x0419, B:205:0x041d, B:207:0x0425, B:209:0x042d, B:196:0x03f2, B:198:0x03f4, B:199:0x0415, B:195:0x03af), top: B:249:0x0375, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:268:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r19, java.lang.String r20, java.lang.String r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private synchronized boolean a(s sVar) {
        boolean z2;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.f16775e)) {
                s sVar2 = f16769g.get(sVar.f16775e);
                if (sVar2 != null) {
                    if (sVar2.f16774d.equals(sVar.f16774d)) {
                        return true;
                    }
                    a(sVar2.f16775e);
                }
                try {
                    sVar.f16776f = f16767d;
                    if (sVar.f16786p == 1) {
                        try {
                            try {
                                if (TextUtils.isEmpty(sVar.f16773c) || TextUtils.isEmpty(sVar.f16775e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                sVar.f16783m = f16767d.getFilesDir().getCanonicalPath() + bh.f16571j + sVar.a;
                                String str = sVar.f16783m + "/dex";
                                String str2 = sVar.f16783m + "/lib/" + this.f16771e;
                                dm.c(sVar.f16783m + "/lib");
                                String str3 = str2 + "/" + f16768f.nextInt();
                                e(str);
                                dm.a(str, Boolean.FALSE);
                                e(str3);
                                a(sVar, str3, str, false);
                                f16770h.put(sVar.f16773c, sVar);
                                f16769g.put(sVar.f16775e, sVar);
                                z2 = false;
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.f16775e);
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    if (sVar.f16786p != 1 || z2) {
                        PackageInfo packageArchiveInfo = sVar.f16788r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = f16767d.getPackageManager().getPackageArchiveInfo(sVar.f16775e, 1);
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.packageName) || !packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            throw new Exception("weapon package name check failed");
                        }
                        if (sVar.f16786p != 1 && sVar.b != 1 && !((Boolean) a(sVar.f16780j, sVar.f16775e).first).booleanValue()) {
                            return false;
                        }
                        sVar.f16773c = packageArchiveInfo.packageName;
                        sVar.f16785o = packageArchiveInfo.applicationInfo.className;
                        sVar.f16774d = packageArchiveInfo.versionName;
                        sVar.f16782l = packageArchiveInfo.activities;
                        sVar.f16787q = packageArchiveInfo.applicationInfo.theme;
                        sVar.f16783m = f16767d.getFilesDir().getCanonicalPath() + bh.f16571j + sVar.a;
                        String str4 = sVar.f16783m + "/dex";
                        String str5 = sVar.f16783m + "/lib/" + this.f16771e;
                        dm.c(sVar.f16783m + "/lib");
                        String str6 = str5 + "/" + f16768f.nextInt();
                        e(str4);
                        dm.a(str4, Boolean.FALSE);
                        e(str6);
                        a(sVar, str6, str4, true);
                        f16770h.put(sVar.f16773c, sVar);
                        f16769g.put(sVar.f16775e, sVar);
                        b.add(Integer.valueOf(sVar.a));
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.f16775e);
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(s sVar, boolean z2) {
        this.a = z2;
        this.f16771e = sVar.f16774d;
        return a(sVar);
    }

    public boolean a(String str) {
        s sVar = f16769g.get(str);
        if (sVar == null) {
            return false;
        }
        f16769g.remove(str);
        f16770h.remove(sVar.f16773c);
        dm.c(sVar.f16783m);
        Application application = f16767d;
        if (application == null) {
            return true;
        }
        dm.c(application.getFileStreamPath(sVar.f16773c).getAbsolutePath());
        return true;
    }

    public Map<String, s> b() {
        return f16770h;
    }

    public boolean b(String str) {
        s sVar = f16770h.get(str);
        if (sVar == null) {
            return false;
        }
        f16769g.remove(sVar.f16775e);
        f16770h.remove(str);
        dm.c(sVar.f16783m);
        Application application = f16767d;
        if (application == null) {
            return true;
        }
        dm.c(application.getFileStreamPath(sVar.f16773c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return f16769g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return f16770h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
