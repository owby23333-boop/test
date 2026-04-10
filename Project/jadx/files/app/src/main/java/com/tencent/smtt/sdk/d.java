package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static String a = "EmergencyManager";
    private static int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19013c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19014d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19015e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f19016f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f19017g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static d f19018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f19019i = 60000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19020j = 86400000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f19021k = false;

    private d() {
    }

    public static synchronized d a() {
        if (f19018h == null) {
            f19018h = new d();
        }
        return f19018h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Context context, int i2, List<com.tencent.smtt.sdk.a.b> list) {
        String str;
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.smtt.sdk.a.g gVarA = com.tencent.smtt.sdk.a.g.a();
        List<String> listA = gVarA.a(context, "emergence_ids");
        HashSet hashSet = new HashSet();
        if (listA != null && !listA.isEmpty()) {
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                String[] strArrA = com.tencent.smtt.sdk.a.g.a(it.next());
                if (strArrA != null && strArrA.length == 4) {
                    hashSet.add(Integer.valueOf(Integer.parseInt(strArrA[0])));
                }
            }
        }
        for (com.tencent.smtt.sdk.a.b bVar : list) {
            int iB = bVar.b();
            int iA = bVar.a();
            if (hashSet.contains(Integer.valueOf(iA))) {
                str = a;
                str2 = "Command has been executed: " + bVar.toString() + ", ignored";
            } else if (bVar.e()) {
                str = a;
                str2 = "Command is out of date: " + bVar.toString() + ", now: " + com.tencent.smtt.sdk.a.a.a(System.currentTimeMillis());
            } else {
                linkedHashMap.put(Integer.valueOf(iB), bVar.c());
                gVarA.a(context, "emergence_ids", com.tencent.smtt.sdk.a.g.a(new String[]{String.valueOf(iA), String.valueOf(bVar.b()), String.valueOf(bVar.c()), String.valueOf(bVar.d())}));
            }
            TbsLog.d(str, str2);
        }
        a(context, Integer.valueOf(i2), linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[Catch: all -> 0x00e7, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x001d, B:6:0x0025, B:13:0x003e, B:15:0x0046, B:16:0x004a, B:20:0x005d, B:21:0x008b, B:23:0x0091, B:25:0x009d, B:27:0x00a3, B:29:0x00a7, B:31:0x00bc, B:35:0x00c9, B:34:0x00c5, B:17:0x004e, B:7:0x0029, B:12:0x0039), top: B:45:0x0001, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[Catch: all -> 0x00e7, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x001d, B:6:0x0025, B:13:0x003e, B:15:0x0046, B:16:0x004a, B:20:0x005d, B:21:0x008b, B:23:0x0091, B:25:0x009d, B:27:0x00a3, B:29:0x00a7, B:31:0x00bc, B:35:0x00c9, B:34:0x00c5, B:17:0x004e, B:7:0x0029, B:12:0x0039), top: B:45:0x0001, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void b(final android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.d.b(android.content.Context):void");
    }

    public synchronized void a(Context context) {
        com.tencent.smtt.sdk.a.g gVarA;
        if (!this.f19021k) {
            this.f19021k = true;
            com.tencent.smtt.sdk.a.g gVarA2 = com.tencent.smtt.sdk.a.g.a();
            if (gVarA2.b()) {
                a(context, f19016f, new ArrayList());
            } else {
                try {
                    gVarA2.a(context);
                    try {
                        long jB = com.tencent.smtt.sdk.a.g.a().b(context, "emergence_timestamp");
                        long jB2 = com.tencent.smtt.sdk.a.g.a().b(context, "emergence_req_interval");
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long j2 = jCurrentTimeMillis - jB;
                        long jMin = Math.min(Math.max(this.f19019i, jB2), this.f19020j);
                        if (j2 > jMin) {
                            TbsLog.d(a, "Emergency configuration is out of date, attempt to query again, " + (j2 / 1000) + " seconds has past");
                            com.tencent.smtt.sdk.a.g.a().a(context, "emergence_timestamp", jCurrentTimeMillis);
                            b(context);
                        } else {
                            a(context, f19013c, new ArrayList());
                            TbsLog.d(a, "Emergency configuration is up to date, " + (j2 / 1000) + " seconds has past, need " + (Math.abs(j2 - jMin) / 1000) + " more seconds for an another request");
                        }
                        gVarA = com.tencent.smtt.sdk.a.g.a();
                    } catch (Exception e2) {
                        a(context, f19017g, new ArrayList());
                        TbsLog.d(a, "Unexpected exception happened when query emergency configuration: " + e2.getMessage());
                        gVarA = com.tencent.smtt.sdk.a.g.a();
                    }
                    gVarA.c();
                } catch (Throwable th) {
                    com.tencent.smtt.sdk.a.g.a().c();
                    throw th;
                }
            }
        }
    }

    public synchronized void a(Context context, Integer num, Map<Integer, String> map) {
        c.a().b(context);
        TbsLog.e(a, "Dispatch emergency commands on tbs extension");
        QbSdk.a(context, num, map);
        g gVarA = g.a(true);
        if (gVarA == null) {
            return;
        }
        u uVarA = gVarA.a();
        if (uVarA == null) {
            return;
        }
        DexLoader dexLoaderC = uVarA.c();
        if (dexLoaderC != null) {
            TbsLog.e(a, "Dispatch emergency commands on tbs shell");
            dexLoaderC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
        } else {
            TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
        }
    }
}
