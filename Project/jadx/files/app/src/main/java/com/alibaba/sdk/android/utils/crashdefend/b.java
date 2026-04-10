package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: CrashDefendManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b b;
    private com.alibaba.sdk.android.utils.c a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f51a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f2244c;
    private Context context;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.a f50a = new com.alibaba.sdk.android.utils.crashdefend.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final List<c> f52a = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f2245g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int[] f53a = new int[5];

    /* JADX INFO: compiled from: CrashDefendManager.java */
    private class a implements Runnable {
        private d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                try {
                    Thread.sleep(1000L);
                    d dVar = this.a;
                    dVar.f2249e--;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            } while (this.a.f2249e > 0);
            if (this.a.f2249e <= 0) {
                b.this.b(this.a.b);
                e.a(b.this.context, b.this.f50a, (List<c>) b.this.f52a);
                return;
            }
            return;
        }
    }

    private b(Context context, com.alibaba.sdk.android.utils.c cVar) {
        this.f2244c = null;
        this.context = context;
        this.a = cVar;
        this.f2244c = new f().a();
        for (int i2 = 0; i2 < 5; i2++) {
            this.f53a[i2] = (i2 * 5) + 5;
        }
        this.f2245g.put("sdkId", "utils");
        this.f2245g.put(Constants.KEY_SDK_VERSION, "2.0.0");
        try {
            a();
            b();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    private void b() {
        this.f51a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f52a) {
            for (c cVar : this.f52a) {
                if (cVar.crashCount >= cVar.b) {
                    arrayList.add(cVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar2 = (c) it.next();
                if (cVar2.f2248d < 5) {
                    long j2 = this.f50a.a - ((long) this.f53a[cVar2.f2248d]);
                    g.a("UtilsSDK", "after restart " + ((cVar2.a - j2) + 1) + " times, sdk will be restore");
                    if (cVar2.a < j2) {
                        this.f51a = cVar2;
                        break;
                    }
                } else {
                    String str = "SDK " + cVar2.f56c + " has been closed";
                }
            }
            if (this.f51a != null) {
                this.f51a.f2248d++;
                String str2 = this.f51a.f56c + " will restore --- startSerialNumber:" + this.f51a.a + "   crashCount:" + this.f51a.crashCount;
            }
        }
    }

    public void d(String str, String str2) {
    }

    public static synchronized b a(Context context, com.alibaba.sdk.android.utils.c cVar) {
        if (b == null) {
            b = new b(context, cVar);
        }
        return b;
    }

    private void a() {
        if (e.m38a(this.context, this.f50a, this.f52a)) {
            this.f50a.a++;
        } else {
            this.f50a.a = 1L;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m37a(c cVar, SDKMessageCallback sDKMessageCallback) {
        c cVarA;
        if (cVar != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(cVar.f57d) || TextUtils.isEmpty(cVar.f56c) || (cVarA = a(cVar, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean zM36a = m36a(cVarA);
                if (cVarA.crashCount == cVarA.b) {
                    a(cVarA.f56c, cVarA.f57d, cVarA.crashCount, cVarA.b);
                }
                cVarA.crashCount++;
                e.a(this.context, this.f50a, this.f52a);
                if (zM36a) {
                    a(cVarA);
                    String str = "START:" + cVarA.f56c + " --- limit:" + cVarA.b + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f2248d + "  startSerialNumber:" + cVarA.a + "  registerSerialNumber:" + cVarA.f55b;
                } else {
                    sDKMessageCallback.crashDefendMessage(cVarA.b, cVarA.crashCount - 1);
                    String str2 = "STOP:" + cVarA.f56c + " --- limit:" + cVarA.b + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f2248d + "  startSerialNumber:" + cVarA.a + "  registerSerialNumber:" + cVarA.f55b;
                }
                return true;
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        int i2 = cVar.f2248d;
        if (i2 > 0) {
            b(cVar.f56c, cVar.f57d, i2, 5);
        }
        cVar.crashCount = 0;
        cVar.f2248d = 0;
    }

    private void b(String str, String str2, int i2, int i3) {
        if (this.a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f2245g);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("recoverCount", String.valueOf(i2));
        map.put("recoverThreshold", String.valueOf(i3));
        this.a.sendCustomHit("utils_biz_recover", 0L, map);
    }

    private c a(c cVar, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f52a) {
            c cVar2 = null;
            if (this.f52a != null && this.f52a.size() > 0) {
                Iterator<c> it = this.f52a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && next.f56c.equals(cVar.f56c)) {
                        if (!next.f57d.equals(cVar.f57d)) {
                            next.f57d = cVar.f57d;
                            next.b = cVar.b;
                            next.f2247c = cVar.f2247c;
                            next.crashCount = 0;
                            next.f2248d = 0;
                        }
                        if (next.f58d) {
                            String str = "SDK " + cVar.f56c + " has been registered";
                            return null;
                        }
                        next.f58d = true;
                        next.f54a = sDKMessageCallback;
                        next.f55b = this.f50a.a;
                        cVar2 = next;
                    }
                }
            }
            if (cVar2 == null) {
                cVar2 = (c) cVar.clone();
                cVar2.f58d = true;
                cVar2.f54a = sDKMessageCallback;
                cVar2.crashCount = 0;
                cVar2.f55b = this.f50a.a;
                this.f52a.add(cVar2);
            }
            return cVar2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m36a(c cVar) {
        if (cVar.crashCount < cVar.b) {
            cVar.a = cVar.f55b;
            return true;
        }
        c cVar2 = this.f51a;
        if (cVar2 == null || !cVar2.f56c.equals(cVar.f56c)) {
            return false;
        }
        cVar.crashCount = cVar.b - 1;
        cVar.a = cVar.f55b;
        return true;
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d dVar = new d();
        dVar.b = cVar;
        dVar.f2249e = cVar.f2247c;
        a(dVar);
        SDKMessageCallback sDKMessageCallback = cVar.f54a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(cVar.b, cVar.crashCount - 1);
        }
    }

    private void a(d dVar) {
        if (dVar == null || dVar.b == null) {
            return;
        }
        this.f2244c.execute(new a(dVar));
    }

    private void a(String str, String str2, int i2, int i3) {
        if (this.a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f2245g);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("curCrashCount", String.valueOf(i2));
        map.put("crashThreshold", String.valueOf(i3));
        this.a.sendCustomHit("utils_biz_crash", 0L, map);
    }
}
