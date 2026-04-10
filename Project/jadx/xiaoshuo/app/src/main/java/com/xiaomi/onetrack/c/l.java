package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7638a = "eventName";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7639b = "data";
    private static final String c = "SystemImpCacheManager";
    private static final String d = "systemimp_cache";
    private static String e = "systemimp_cache_%s";
    private static volatile l f = null;
    private static String g = "system_imp_cache_manager";
    private Handler h;

    private l() {
        try {
            HandlerThread handlerThread = new HandlerThread(g);
            handlerThread.start();
            this.h = new Handler(handlerThread.getLooper());
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(c, "SystemImpCacheManager init Throwable: " + th.getMessage());
        }
    }

    public static void b() {
        if (f == null) {
            synchronized (l.class) {
                if (f == null) {
                    f = new l();
                }
            }
        }
    }

    private static String c() {
        return com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath() + File.separator + d;
    }

    public static l a() {
        if (f == null) {
            b();
        }
        return f;
    }

    public synchronized void c(String str) {
        if (this.h != null && !TextUtils.isEmpty(str)) {
            this.h.post(new n(this, str));
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.h == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.h.post(new m(this, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        byte[] bArrA;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            File file = new File(c(), String.format(e, str));
            if (!file.exists()) {
                if (file.getParentFile().exists()) {
                    file.createNewFile();
                } else {
                    new File(file.getParentFile().getAbsolutePath()).mkdirs();
                    file.createNewFile();
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("eventName", str2);
            jSONObject.put("data", str3);
            bArrA = c.a(jSONObject.toString());
            fileWriter = new FileWriter(file, true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(com.xiaomi.onetrack.d.c.a(bArrA));
            bufferedWriter.newLine();
            com.xiaomi.onetrack.util.m.a(bufferedWriter);
            com.xiaomi.onetrack.util.m.a(fileWriter);
        } catch (Throwable th3) {
            th = th3;
            fileWriter2 = fileWriter;
            try {
                com.xiaomi.onetrack.util.p.b(c, "systemimp doSaveData error: " + th.getMessage());
            } finally {
                com.xiaomi.onetrack.util.m.a(bufferedWriter);
                com.xiaomi.onetrack.util.m.a(fileWriter2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        r0[r3].delete();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r1 = c()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r1 = r0.exists()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r1 == 0) goto L47
            boolean r1 = r0.isDirectory()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r1 != 0) goto L17
            goto L47
        L17:
            java.lang.String r1 = com.xiaomi.onetrack.c.l.e     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r5 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
        L27:
            int r1 = r0.length     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r3 >= r1) goto L66
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r1 = r1.isFile()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r1 == 0) goto L44
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r1 = r1.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r1 == 0) goto L44
            r5 = r0[r3]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r5.delete()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            goto L66
        L44:
            int r3 = r3 + 1
            goto L27
        L47:
            monitor-exit(r4)
            return
        L49:
            r5 = move-exception
            goto L68
        L4b:
            r5 = move-exception
            java.lang.String r0 = "SystemImpCacheManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r1.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "systemimp removeObsoleteEvent error: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L49
            r1.append(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L49
            com.xiaomi.onetrack.util.p.b(r0, r5)     // Catch: java.lang.Throwable -> L49
        L66:
            monitor-exit(r4)
            return
        L68:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.onetrack.c.l.a(java.lang.String):void");
    }

    public static synchronized List<JSONObject> b(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        Exception e2;
        ArrayList arrayList;
        File file;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                file = new File(c(), String.format(e, str));
            } catch (Exception e3) {
                bufferedReader = null;
                fileReader = null;
                e2 = e3;
                arrayList = null;
            }
            if (!file.exists()) {
                com.xiaomi.onetrack.util.m.a((Closeable) null);
                com.xiaomi.onetrack.util.m.a((Closeable) null);
                return null;
            }
            arrayList = new ArrayList();
            try {
                fileReader = new FileReader(file);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                arrayList.add(new JSONObject(c.a(com.xiaomi.onetrack.d.c.a(line))));
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            com.xiaomi.onetrack.util.p.b(c, "cta getCacheData error: " + e2.toString());
                            e2.printStackTrace();
                            com.xiaomi.onetrack.util.m.a(bufferedReader);
                        }
                    }
                    com.xiaomi.onetrack.util.m.a(bufferedReader);
                } catch (Exception e5) {
                    bufferedReader = null;
                    e2 = e5;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                fileReader = null;
                e2 = e6;
                bufferedReader = null;
            }
            com.xiaomi.onetrack.util.m.a(fileReader);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        com.xiaomi.onetrack.util.m.a(bufferedReader2);
        com.xiaomi.onetrack.util.m.a(fileReader);
        throw th;
    }
}
