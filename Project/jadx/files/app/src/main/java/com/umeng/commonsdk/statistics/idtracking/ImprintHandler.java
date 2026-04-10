package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.be;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class ImprintHandler implements FileLockCallback {
    private static final String a = "ImprintHandler";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20081c = ".imprint";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Context f20086k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static FileLockUtil f20087l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20088m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f20089n = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f20092e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f20093h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f20094i = null;
    private static Object b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f20082d = "pbl0".getBytes();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f20083f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f20084g = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ImprintHandler f20085j = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f20090o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Object f20091p = new Object();

    private ImprintHandler(Context context) {
        f20086k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f20084g) {
            try {
                int i2 = 0;
                if (f20083f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f20083f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i2 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i2 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f20083f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f20086k, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f A[Catch: all -> 0x00a1, DONT_GENERATE, TryCatch #0 {, blocks: (B:26:0x009f, B:25:0x009a, B:8:0x000d, B:10:0x0015, B:12:0x001f, B:14:0x0025, B:16:0x0040, B:18:0x0046, B:19:0x005e, B:20:0x0061, B:22:0x007f), top: B:32:0x000d, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.lang.String r5, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto La4
            if (r6 != 0) goto La
            goto La4
        La:
            java.lang.Object r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f20084g
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f20083f     // Catch: java.lang.Throwable -> L99
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L9f
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f20083f     // Catch: java.lang.Throwable -> L99
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L99
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> L99
            if (r6 == 0) goto L9f
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            if (r2 <= 0) goto L9f
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "--->>> removeCallback: before remove: callbacks size is: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            r3.append(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r3)     // Catch: java.lang.Throwable -> L99
            r3 = 0
        L3e:
            if (r3 >= r2) goto L61
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L99
            if (r6 != r4) goto L5e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "--->>> removeCallback: remove index "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            r6.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            r1.remove(r3)     // Catch: java.lang.Throwable -> L99
            goto L61
        L5e:
            int r3 = r3 + 1
            goto L3e
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "--->>> removeCallback: after remove: callbacks size is: "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            int r6 = r1.size()     // Catch: java.lang.Throwable -> L99
            if (r6 != 0) goto L9f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "--->>> removeCallback: remove key from map: key = "
            r6.append(r1)     // Catch: java.lang.Throwable -> L99
            r6.append(r5)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f20083f     // Catch: java.lang.Throwable -> L99
            r6.remove(r5)     // Catch: java.lang.Throwable -> L99
            goto L9f
        L99:
            r5 = move-exception
            android.content.Context r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f20086k     // Catch: java.lang.Throwable -> La1
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r5)     // Catch: java.lang.Throwable -> La1
        L9f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            return
        La1:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            throw r5
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b(java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback):void");
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String strH = eVar.h();
            if (!TextUtils.isEmpty(strH)) {
                byte[] bArrReverseHexString = DataHelper.reverseHexString(strH);
                byte[] bArrA = a(eVar);
                for (int i2 = 0; i2 < 4; i2++) {
                    if (bArrReverseHexString[i2] != bArrA[i2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        if (mapC.containsKey(am.f19446f)) {
            mapC.remove(am.f19446f);
            this.f20093h.a(am.f19446f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z2;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(mapC.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = mapC.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().a;
                synchronized (f20091p) {
                    z2 = !TextUtils.isEmpty(key) && f20090o.containsKey(key) && (uMImprintPreProcessCallback = f20090o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z2) {
                    arrayList3.add(key);
                }
                synchronized (f20084g) {
                    if (!TextUtils.isEmpty(key) && f20083f.containsKey(key) && (arrayList2 = f20083f.get(key)) != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            arrayList2.get(i2).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f20084g) {
                if (!TextUtils.isEmpty(str2) && f20083f.containsKey(str2) && (arrayList = f20083f.get(str2)) != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        arrayList.get(i3).onImprintValueChanged(str2, null);
                    }
                }
            }
            mapC.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        if (f20085j == null) {
            f20085j = new ImprintHandler(context);
            f20087l = new FileLockUtil();
            if (f20087l != null) {
                f20087l.doFileOperateion(new File(f20086k.getFilesDir(), f20081c), f20085j, 0);
            }
        }
        return f20085j;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i2) {
        if (i2 == 0) {
            f20085j.e();
        } else if (i2 == 1) {
            f20085j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f20091p) {
            try {
                if (f20090o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    f20090o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {
        private Map<String, String> a = new HashMap();

        a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                try {
                    if (dVar.e()) {
                        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
                        for (String str : mapC.keySet()) {
                            if (!TextUtils.isEmpty(str) && (eVar = mapC.get(str)) != null) {
                                String strB = eVar.b();
                                if (!TextUtils.isEmpty(strB)) {
                                    this.a.put(str, strB);
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        String str2 = "imKey is " + str + ", imValue is " + strB;
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public synchronized void a(String str) {
            if (this.a != null && this.a.size() > 0 && !TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.a.size() > 0) {
                String str3 = this.a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public void d() {
        if (this.f20094i == null || f20087l == null) {
            return;
        }
        File file = new File(f20086k.getFilesDir(), f20081c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(f20086k, e2);
            }
        }
        f20087l.doFileOperateion(file, f20085j, 1);
    }

    public a c() {
        return this.f20093h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d dVarA;
        boolean z2;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z3 = AnalyticsConstants.UM_DEBUG;
        HashMap map = new HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.f20094i;
            com.umeng.commonsdk.statistics.proto.d dVarD = d(dVar);
            String strI = null;
            String strI2 = dVar2 == null ? null : dVar2.i();
            if (dVar2 == null) {
                dVarA = e(dVarD);
            } else {
                dVarA = a(dVar2, dVarD, map);
            }
            this.f20094i = dVarA;
            if (dVarA != null) {
                strI = dVarA.i();
            }
            z2 = !a(strI2, strI);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f20094i;
        if (dVar3 != null) {
            boolean z4 = AnalyticsConstants.UM_DEBUG;
            if (z2) {
                this.f20093h.a(dVar3);
                com.umeng.commonsdk.statistics.internal.d dVar4 = this.f20092e;
                if (dVar4 != null) {
                    dVar4.onImprintChanged(this.f20093h);
                }
            }
        }
        if (map.size() > 0) {
            synchronized (f20084g) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f20083f.containsKey(key)) {
                        ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f20083f.get(key);
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                arrayList.get(i2).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f20091p) {
            try {
                if (f20090o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f20083f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    private void e() {
        FileInputStream fileInputStreamOpenFileInput;
        File file = new File(f20086k.getFilesDir(), f20081c);
        synchronized (b) {
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                byte[] streamToByteArray = null;
                try {
                    fileInputStreamOpenFileInput = f20086k.openFileInput(f20081c);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    th = th;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput);
                    } catch (Throwable th2) {
                        FileInputStream fileInputStream2 = fileInputStreamOpenFileInput;
                        th = th2;
                        fileInputStream = fileInputStream2;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
                HelperUtils.safeClose(fileInputStreamOpenFileInput);
                if (streamToByteArray != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new ay().a(dVar, streamToByteArray);
                        this.f20094i = dVar;
                        this.f20093h.a(dVar);
                        this.f20094i = d(this.f20094i);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f20092e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(null);
        byteBufferAllocate.putLong(eVar.e());
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr = f20082d;
        byte[] bArr2 = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i2] = (byte) (bArrArray[i2] ^ bArr[i2]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.f20094i == null) {
                    return null;
                }
                if (this.f20094i.b() <= 0) {
                    return null;
                }
                return new be().a(this.f20094i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f20086k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f20094i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i2 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().a;
                synchronized (f20091p) {
                    if (!TextUtils.isEmpty(key) && f20090o.containsKey(key) && (uMImprintPreProcessCallback = f20090o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    mapC.put(entry.getKey(), entry.getValue());
                    synchronized (f20084g) {
                        if (!TextUtils.isEmpty(key) && f20083f.containsKey(key) && f20083f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f20084g) {
                    if (!TextUtils.isEmpty(key2) && f20083f.containsKey(key2) && (arrayList = f20083f.get(key2)) != null) {
                        while (i2 < arrayList.size()) {
                            arrayList.get(i2).onImprintValueChanged(key2, null);
                            i2++;
                        }
                    }
                }
                mapC.remove(key2);
                this.f20093h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f20094i == null) {
            return;
        }
        try {
            synchronized (b) {
                byte[] bArrA = new be().a(this.f20094i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
