package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final long a = System.currentTimeMillis();
    private static u b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f18797c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f18800f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, t>> f18799e = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18798d = aa.b().f18472d;

    private u(Context context) {
        this.f18797c = context;
        this.f18800f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0054, Exception -> 0x0056, PHI: r6
  0x003e: PHI (r6v10 java.io.ObjectInputStream) = (r6v9 java.io.ObjectInputStream), (r6v11 java.io.ObjectInputStream) binds: [B:17:0x003c, B:22:0x004a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0056, blocks: (B:4:0x0003, B:10:0x002c, B:18:0x003e, B:26:0x0050, B:27:0x0053), top: B:39:0x0003, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T d(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r3 = r5.f18797c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r6 != 0) goto L1c
            monitor-exit(r5)
            return r0
        L1c:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            monitor-exit(r5)
            return r2
        L31:
            r2 = move-exception
            r6 = r0
            goto L4e
        L34:
            r6 = r0
        L35:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
        L3e:
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L42:
            r6 = r0
        L43:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
            goto L3e
        L4d:
            r2 = move-exception
        L4e:
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L53:
            throw r2     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L54:
            r6 = move-exception
            goto L5f
        L56:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L54
            com.tencent.bugly.proguard.al.e(r6, r1)     // Catch: java.lang.Throwable -> L54
        L5d:
            monitor-exit(r5)
            return r0
        L5f:
            monitor-exit(r5)
            goto L62
        L61:
            throw r6
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.d(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c(int i2) {
        try {
            List<t> listD = d(i2);
            if (listD == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (t tVar : listD) {
                if (tVar.b != null && tVar.b.equalsIgnoreCase(this.f18798d) && tVar.f18793d > 0) {
                    arrayList.add(tVar);
                }
                if (tVar.f18792c + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(tVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                listD.removeAll(arrayList2);
                a(i2, listD);
                return false;
            }
            if (arrayList.size() <= 0 || ((t) arrayList.get(arrayList.size() - 1)).f18792c + 86400000 >= jCurrentTimeMillis) {
                return true;
            }
            listD.clear();
            a(i2, listD);
            return false;
        } catch (Exception unused) {
            al.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final synchronized boolean b(final int i2) {
        boolean z2;
        z2 = true;
        try {
            z2 = this.f18800f.getBoolean(i2 + "_" + this.f18798d, true);
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.u.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zC = u.this.c(i2);
                    u.this.f18800f.edit().putBoolean(i2 + "_" + u.this.f18798d, !zC).commit();
                }
            });
        } catch (Exception unused) {
            al.e("canInit error", new Object[0]);
            return z2;
        }
        return z2;
    }

    public static synchronized u a(Context context) {
        if (b == null) {
            b = new u(context);
        }
        return b;
    }

    public static synchronized u a() {
        return b;
    }

    static /* synthetic */ boolean b(t tVar, t tVar2) {
        String str = tVar.f18794e;
        if (str != null && !str.equalsIgnoreCase(tVar2.f18794e)) {
            return true;
        }
        String str2 = tVar.f18795f;
        return !(str2 == null || str2.equalsIgnoreCase(tVar2.f18795f)) || tVar.f18793d <= 0;
    }

    public final void a(final int i2) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1
            final /* synthetic */ int a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                t tVar;
                try {
                    if (TextUtils.isEmpty(u.this.f18798d)) {
                        return;
                    }
                    List<t> listD = u.this.d(this.a);
                    if (listD == null) {
                        listD = new ArrayList();
                    }
                    if (u.this.f18799e.get(Integer.valueOf(this.a)) == null) {
                        u.this.f18799e.put(Integer.valueOf(this.a), new HashMap());
                    }
                    if (((Map) u.this.f18799e.get(Integer.valueOf(this.a))).get(u.this.f18798d) == null) {
                        tVar = new t();
                        tVar.a = this.a;
                        tVar.f18796g = u.a;
                        tVar.b = u.this.f18798d;
                        tVar.f18795f = aa.b().f18483o;
                        tVar.f18794e = aa.b().f18476h;
                        tVar.f18792c = System.currentTimeMillis();
                        tVar.f18793d = i2;
                        ((Map) u.this.f18799e.get(Integer.valueOf(this.a))).put(u.this.f18798d, tVar);
                    } else {
                        tVar = (t) ((Map) u.this.f18799e.get(Integer.valueOf(this.a))).get(u.this.f18798d);
                        tVar.f18793d = i2;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z2 = false;
                    for (t tVar2 : listD) {
                        if (u.a(tVar2, tVar)) {
                            z2 = true;
                            tVar2.f18793d = tVar.f18793d;
                        }
                        if (u.b(tVar2, tVar)) {
                            arrayList.add(tVar2);
                        }
                    }
                    listD.removeAll(arrayList);
                    if (!z2) {
                        listD.add(tVar);
                    }
                    u.this.a(this.a, listD);
                } catch (Exception unused) {
                    al.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <T extends List<?>> void a(int i2, T t2) {
        if (t2 == null) {
            return;
        }
        try {
            File file = new File(this.f18797c.getDir("crashrecord", 0), String.valueOf(i2));
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                    try {
                        objectOutputStream2.writeObject(t2);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        al.a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused) {
            al.e("writeCrashRecord error", new Object[0]);
        }
    }

    static /* synthetic */ boolean a(t tVar, t tVar2) {
        String str;
        return tVar.f18796g == tVar2.f18796g && (str = tVar.b) != null && str.equalsIgnoreCase(tVar2.b);
    }
}
