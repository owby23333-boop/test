package com.anythink.china.common;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.anythink.china.common.a.a;
import com.anythink.china.common.a.e;
import com.anythink.china.common.a.g;
import com.anythink.china.common.service.ApkDownloadService;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.k.h;
import com.anythink.core.common.m;
import com.baidu.mobads.sdk.internal.bj;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.ad;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    public static final String a = "a";
    public static final String b = "action_offer_download_start";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6363c = "action_offer_download_end";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6364d = "action_offer_install_start";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6365e = "action_offer_install_successful";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6366f = "receiver_extra_offer_id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6367g = "receiver_extra_click_id";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f6368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f6369i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<String, e> f6374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<String, e> f6375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ConcurrentHashMap<String, e> f6376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, e> f6377q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private BroadcastReceiver f6380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ApkDownloadService.a f6381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BroadcastReceiver f6382v;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f6378r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f6379s = bj.f12906d;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ServiceConnection f6383w = new ServiceConnection() { // from class: com.anythink.china.common.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f6381u = (ApkDownloadService.a) iBinder;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f6381u = null;
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<e> f6370j = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<String, e> f6371k = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<String, e> f6372l = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, a.InterfaceC0150a> f6373m = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.anythink.china.common.a$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f6377q != null) {
                synchronized (a.this.f6377q) {
                    Iterator it = a.this.f6377q.entrySet().iterator();
                    while (it.hasNext()) {
                        e eVar = (e) ((Map.Entry) it.next()).getValue();
                        String str = ad.f20405r + eVar.f6422c + ") retry to download";
                        eVar.e();
                        a.this.d(eVar);
                        it.remove();
                    }
                }
            }
        }
    }

    private a(Context context) {
        this.f6369i = context.getApplicationContext();
        String strA = com.anythink.china.common.c.b.a();
        if (!TextUtils.isEmpty(strA)) {
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            this.f6382v = new BroadcastReceiver() { // from class: com.anythink.china.common.a.2
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context2)) {
                            return;
                        }
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (h.a(context2) && activeNetworkInfo.getType() == 1) {
                            a.a(a.this);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f6369i.registerReceiver(this.f6382v, intentFilter);
        } catch (Throwable unused) {
        }
    }

    private void g() {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass4());
    }

    private void h() {
        try {
            if (this.f6380t != null) {
                return;
            }
            this.f6380t = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme(Constants.KEY_PACKAGE);
            this.f6369i.registerReceiver(this.f6380t, intentFilter);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            if (this.f6380t != null) {
                this.f6369i.unregisterReceiver(this.f6380t);
                this.f6380t = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.china.common.a.g
    public final int a() {
        return 1;
    }

    /* JADX INFO: renamed from: com.anythink.china.common.a$3, reason: invalid class name */
    final class AnonymousClass3 implements a.InterfaceC0150a {
        AnonymousClass3() {
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0150a
        public final void a(final e eVar, final long j2, final long j3) {
            new StringBuilder("onStartBefore: ").append(eVar.b);
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (j2 < j3) {
                        a.this.d("正在下载： " + eVar.f6422c);
                        com.anythink.china.common.b.a.a(a.this.f6369i).c(eVar);
                        com.anythink.china.common.b.a.a(a.this.f6369i).a(eVar, j2, j3);
                    }
                    Intent intent = new Intent();
                    intent.setAction(a.b);
                    intent.setPackage(a.this.f6369i.getPackageName());
                    intent.putExtra(a.f6366f, eVar.f6425f);
                    intent.putExtra(a.f6367g, eVar.f6432m);
                    m.a(a.this.f6369i).a(intent);
                    e eVar2 = eVar;
                    com.anythink.core.common.j.c.a(eVar2.a, eVar2.f6425f, eVar2.b, 1, (String) null, 0L, j3);
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0150a
        public final void b(final e eVar, final long j2, final long j3) {
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.china.common.b.a.a(a.this.f6369i).a(eVar, j2, j3);
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0150a
        public final void a(final e eVar, final long j2) {
            String str = "onSuccess: " + eVar.f6422c;
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.f6373m.remove(eVar.f6433n);
                    a.this.f6371k.remove(eVar.f6433n);
                    if (a.this.f6374n == null) {
                        a.this.f6374n = new ConcurrentHashMap();
                    }
                    ConcurrentHashMap concurrentHashMap = a.this.f6374n;
                    e eVar2 = eVar;
                    concurrentHashMap.put(eVar2.f6433n, eVar2);
                    Intent intent = new Intent();
                    intent.setAction(a.f6363c);
                    intent.setPackage(a.this.f6369i.getPackageName());
                    intent.putExtra(a.f6366f, eVar.f6425f);
                    intent.putExtra(a.f6367g, eVar.f6432m);
                    m.a(a.this.f6369i).a(intent);
                    a.this.b(eVar);
                    com.anythink.china.common.b.a.a(a.this.f6369i).c(eVar);
                    com.anythink.china.common.b.a.a(a.this.f6369i).a(eVar);
                    e eVar3 = eVar;
                    com.anythink.core.common.j.c.a(eVar3.a, eVar3.f6425f, eVar3.b, 2, (String) null, j2, eVar3.f6427h);
                    a.this.b();
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0150a
        public final void a(final e eVar, final String str) {
            String str2 = ad.f20405r + eVar.f6422c + ") download fail: " + str;
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.d("下载失败： " + eVar.f6422c);
                    a.this.f6373m.remove(eVar.f6433n);
                    a.this.f6371k.remove(eVar.f6433n);
                    if (a.this.f6377q == null) {
                        a.this.f6377q = Collections.synchronizedMap(new HashMap());
                    }
                    Map map = a.this.f6377q;
                    e eVar2 = eVar;
                    map.put(eVar2.f6433n, eVar2);
                    com.anythink.china.common.b.a.a(a.this.f6369i).c(eVar);
                    com.anythink.china.common.b.a.a(a.this.f6369i).a(eVar, 0L, 100L);
                    e eVar3 = eVar;
                    com.anythink.core.common.j.c.a(eVar3.a, eVar3.f6425f, eVar3.b, 3, str, 0L, eVar3.f6427h);
                    a.this.b();
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0150a
        public final void a(final e eVar, final long j2, final long j3, final int i2) {
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.5
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.f6371k.remove(eVar.f6433n);
                    com.anythink.china.common.b.a.a(a.this.f6369i).c(eVar);
                    int i3 = i2;
                    if (i3 == 2) {
                        String str = ad.f20405r + eVar.f6422c + ") pause download";
                        com.anythink.china.common.b.a.a(a.this.f6369i).a(eVar, j2, j3);
                        a.this.b();
                        return;
                    }
                    if (i3 == 3) {
                        String str2 = ad.f20405r + eVar.f6422c + ") stop download";
                    }
                }
            });
        }
    }

    private void e(e eVar) {
        this.f6371k.put(eVar.f6433n, eVar);
        this.f6373m.put(eVar.f6433n, new AnonymousClass3());
        try {
            if (this.f6381u != null) {
                this.f6381u.a(eVar.f6433n);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.f6369i, ApkDownloadService.class);
            intent.putExtra(ApkDownloadService.a, eVar.f6433n);
            this.f6369i.bindService(intent, this.f6383w, 1);
        } catch (Throwable unused) {
        }
    }

    private static String f(e eVar) {
        return com.anythink.china.common.c.b.a(eVar.f6433n) + com.anythink.china.common.a.a.f6395g;
    }

    @Override // com.anythink.china.common.a.g
    public final void b() {
        synchronized (this.f6370j) {
            int size = this.f6370j.size();
            if (size == 0) {
                return;
            }
            int size2 = this.f6371k.size();
            if (size2 > 0) {
                return;
            }
            int iMin = Math.min(1 - size2, size);
            for (int i2 = 0; i2 < iMin && this.f6370j.size() > 0; i2++) {
                e eVarRemove = this.f6370j.remove(0);
                this.f6371k.put(eVarRemove.f6433n, eVarRemove);
                this.f6373m.put(eVarRemove.f6433n, new AnonymousClass3());
                try {
                    if (this.f6381u != null) {
                        this.f6381u.a(eVarRemove.f6433n);
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(this.f6369i, ApkDownloadService.class);
                        intent.putExtra(ApkDownloadService.a, eVarRemove.f6433n);
                        this.f6369i.bindService(intent, this.f6383w, 1);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.anythink.china.common.a.g
    public final boolean c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f6369i.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    @Override // com.anythink.china.common.a.g
    @TargetApi(26)
    public final void d() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f6369i.getPackageName()));
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        this.f6369i.startActivity(intent);
    }

    public final Map<String, e> f() {
        return this.f6371k;
    }

    @Override // com.anythink.china.common.a.g
    public final void c(e eVar) {
        String strF = f(eVar);
        if (TextUtils.isEmpty(strF)) {
            return;
        }
        new StringBuilder("install: ").append(eVar.f6422c);
        File file = new File(strF);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                intent.setDataAndType(FileProvider.getUriForFile(this.f6369i, this.f6369i.getPackageName() + ".anythink.fileProvider", file), AdBaseConstants.MIME_APK);
            } else {
                intent.setDataAndType(Uri.parse("file://".concat(String.valueOf(strF))), AdBaseConstants.MIME_APK);
            }
            this.f6369i.startActivity(intent);
            com.anythink.core.common.j.c.a(eVar.a, eVar.f6425f, eVar.b, 4, (String) null, 0L, file.length());
        } catch (Throwable th) {
            th.printStackTrace();
            com.anythink.core.common.j.c.a(eVar.a, eVar.f6425f, eVar.b, 10, th.getMessage(), 0L, file.length());
        }
    }

    public static a a(Context context) {
        if (f6368h == null) {
            synchronized (a.class) {
                if (f6368h == null) {
                    f6368h = new a(context);
                }
            }
        }
        return f6368h;
    }

    @Override // com.anythink.china.common.a.g
    public final void d(e eVar) {
        try {
            if (a(eVar.f6433n)) {
                eVar.l();
                b(eVar);
                return;
            }
            e eVar2 = this.f6372l.get(eVar.f6433n);
            if (eVar2 != null) {
                this.f6372l.remove(eVar.f6433n);
                eVar2.e();
                a(eVar2);
            } else {
                a(eVar);
            }
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0137 A[Catch: all -> 0x0173, TryCatch #0 {all -> 0x0173, blocks: (B:37:0x00e5, B:40:0x00f1, B:42:0x00fc, B:45:0x0101, B:47:0x0110, B:49:0x011e, B:53:0x0125, B:55:0x012f, B:58:0x0137, B:62:0x0147, B:59:0x013b, B:61:0x0144, B:63:0x014a, B:65:0x0150), top: B:71:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013b A[Catch: all -> 0x0173, TryCatch #0 {all -> 0x0173, blocks: (B:37:0x00e5, B:40:0x00f1, B:42:0x00fc, B:45:0x0101, B:47:0x0110, B:49:0x011e, B:53:0x0125, B:55:0x012f, B:58:0x0137, B:62:0x0147, B:59:0x013b, B:61:0x0144, B:63:0x014a, B:65:0x0150), top: B:71:0x00e5 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r18, com.anythink.core.common.e.j r19, com.anythink.core.common.e.i r20, java.lang.String r21, java.lang.String r22, java.lang.Runnable r23, com.anythink.core.common.f.b r24) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.a(android.content.Context, com.anythink.core.common.e.j, com.anythink.core.common.e.i, java.lang.String, java.lang.String, java.lang.Runnable, com.anythink.core.common.f.b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[Catch: all -> 0x008e, TryCatch #0 {all -> 0x008e, blocks: (B:2:0x0000, B:5:0x000b, B:7:0x0016, B:10:0x001a, B:12:0x002a, B:14:0x0038, B:18:0x003f, B:20:0x0049, B:23:0x0051, B:27:0x0061, B:24:0x0055, B:26:0x005e, B:28:0x0064, B:30:0x006a), top: B:36:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[Catch: all -> 0x008e, TryCatch #0 {all -> 0x008e, blocks: (B:2:0x0000, B:5:0x000b, B:7:0x0016, B:10:0x001a, B:12:0x002a, B:14:0x0038, B:18:0x003f, B:20:0x0049, B:23:0x0051, B:27:0x0061, B:24:0x0055, B:26:0x005e, B:28:0x0064, B:30:0x006a), top: B:36:0x0000 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r13 = this;
            java.lang.String r0 = com.anythink.china.common.c.b.a()     // Catch: java.lang.Throwable -> L8e
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto Lb
            return
        Lb:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L8e
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8e
            java.io.File[] r0 = r1.listFiles()     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L1a
            int r1 = r0.length     // Catch: java.lang.Throwable -> L8e
            if (r1 != 0) goto L1a
            return
        L1a:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8e
            r1.<init>()     // Catch: java.lang.Throwable -> L8e
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8e
            long r4 = r13.f6379s     // Catch: java.lang.Throwable -> L8e
            int r6 = r0.length     // Catch: java.lang.Throwable -> L8e
            r7 = 0
            r8 = 0
        L28:
            if (r8 >= r6) goto L64
            r9 = r0[r8]     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r11 = ".apk"
            boolean r10 = r10.endsWith(r11)     // Catch: java.lang.Throwable -> L8e
            if (r10 == 0) goto L55
            android.content.Context r10 = r13.f6369i     // Catch: java.lang.Throwable -> L8e
            if (r10 == 0) goto L4e
            if (r9 != 0) goto L3f
            goto L4e
        L3f:
            java.lang.String r11 = com.anythink.china.common.c.a.a(r10, r9)     // Catch: java.lang.Throwable -> L8e
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L8e
            if (r12 != 0) goto L4e
            boolean r10 = com.anythink.china.common.c.a.a(r10, r11)     // Catch: java.lang.Throwable -> L8e
            goto L4f
        L4e:
            r10 = 0
        L4f:
            if (r10 == 0) goto L55
            r1.add(r9)     // Catch: java.lang.Throwable -> L8e
            goto L61
        L55:
            long r10 = r9.lastModified()     // Catch: java.lang.Throwable -> L8e
            long r10 = r10 + r4
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 >= 0) goto L61
            r1.add(r9)     // Catch: java.lang.Throwable -> L8e
        L61:
            int r8 = r8 + 1
            goto L28
        L64:
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L8e
        L68:
            if (r7 >= r0) goto L8d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "clean expired file -> "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r3 = r1.get(r7)     // Catch: java.lang.Throwable -> L8e
            java.io.File r3 = (java.io.File) r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L8e
            r2.append(r3)     // Catch: java.lang.Throwable -> L8e
            r2.toString()     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r2 = r1.get(r7)     // Catch: java.lang.Throwable -> L8e
            java.io.File r2 = (java.io.File) r2     // Catch: java.lang.Throwable -> L8e
            r2.delete()     // Catch: java.lang.Throwable -> L8e
            int r7 = r7 + 1
            goto L68
        L8d:
            return
        L8e:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.e():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        n.a().a(new Runnable() { // from class: com.anythink.china.common.a.5
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(a.this.f6369i, str, 0).show();
            }
        });
    }

    public final a.InterfaceC0150a c(String str) {
        return this.f6373m.get(str);
    }

    @Override // com.anythink.china.common.a.g
    public final void b(e eVar) {
        Intent intent = new Intent();
        intent.setAction(f6364d);
        intent.setPackage(this.f6369i.getPackageName());
        intent.putExtra(f6366f, eVar.f6425f);
        intent.putExtra(f6367g, eVar.f6432m);
        m.a(this.f6369i).a(intent);
        if (this.f6375o == null) {
            this.f6375o = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(eVar.f6424e)) {
            String strF = f(eVar);
            if (!TextUtils.isEmpty(strF)) {
                eVar.f6424e = com.anythink.china.common.c.a.a(this.f6369i, new File(strF));
            }
        }
        this.f6375o.put(eVar.f6424e, eVar);
        try {
            if (this.f6380t == null) {
                this.f6380t = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme(Constants.KEY_PACKAGE);
                this.f6369i.registerReceiver(this.f6380t, intentFilter);
            }
        } catch (Throwable unused) {
        }
        String strF2 = f(eVar);
        if (TextUtils.isEmpty(strF2)) {
            return;
        }
        new StringBuilder("install: ").append(eVar.f6422c);
        File file = new File(strF2);
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            if (Build.VERSION.SDK_INT >= 24) {
                intent2.addFlags(1);
                intent2.setDataAndType(FileProvider.getUriForFile(this.f6369i, this.f6369i.getPackageName() + ".anythink.fileProvider", file), AdBaseConstants.MIME_APK);
            } else {
                intent2.setDataAndType(Uri.parse("file://".concat(String.valueOf(strF2))), AdBaseConstants.MIME_APK);
            }
            this.f6369i.startActivity(intent2);
            com.anythink.core.common.j.c.a(eVar.a, eVar.f6425f, eVar.b, 4, (String) null, 0L, file.length());
        } catch (Throwable th) {
            th.printStackTrace();
            com.anythink.core.common.j.c.a(eVar.a, eVar.f6425f, eVar.b, 10, th.getMessage(), 0L, file.length());
        }
    }

    public final void b(String str) {
        e eVar;
        try {
            if (this.f6375o.containsKey(str) && (eVar = this.f6375o.get(str)) != null) {
                String strF = f(eVar);
                if (!TextUtils.isEmpty(strF)) {
                    new File(strF).delete();
                }
                eVar.m();
                this.f6375o.remove(str);
                if (this.f6376p == null) {
                    this.f6376p = new ConcurrentHashMap<>();
                }
                this.f6376p.put(eVar.f6433n, eVar);
                if (this.f6374n != null) {
                    this.f6374n.remove(eVar.f6433n);
                }
                com.anythink.china.common.b.a.a(this.f6369i).c(eVar);
                com.anythink.china.common.b.a.a(this.f6369i).a(eVar, 0L, 100L, true);
                Intent intent = new Intent();
                intent.setAction(f6365e);
                intent.setPackage(this.f6369i.getPackageName());
                intent.putExtra(f6366f, eVar.f6425f);
                intent.putExtra(f6367g, eVar.f6432m);
                m.a(this.f6369i).a(intent);
                com.anythink.core.common.j.c.a(eVar.a, eVar.f6425f, eVar.b, 5, (String) null, 0L, 0L);
                if (this.f6375o.size() == 0) {
                    try {
                        if (this.f6380t != null) {
                            this.f6369i.unregisterReceiver(this.f6380t);
                            this.f6380t = null;
                        }
                    } catch (Throwable unused) {
                    }
                }
                a(eVar, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(long j2) {
        if (j2 > 0) {
            this.f6379s = j2;
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f6371k.containsKey(eVar.f6433n)) {
            File file = new File(com.anythink.china.common.c.b.a(eVar.f6433n) + com.anythink.china.common.a.a.f6393e);
            File file2 = new File(com.anythink.china.common.c.b.a(eVar.f6433n) + com.anythink.china.common.a.a.f6394f);
            if (file.exists() && file2.exists()) {
                String str = ad.f20405r + eVar.f6422c + ") is downloading, do nothing";
                d("正在下载中： " + eVar.f6422c);
                return;
            }
            this.f6371k.remove(eVar.f6433n);
        }
        int size = this.f6370j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(eVar.f6433n, this.f6370j.get(i2).f6433n)) {
                String str2 = ad.f20405r + eVar.f6422c + ") is waiting for downloading, do nothing";
                d("等待下载： " + eVar.f6422c);
                return;
            }
        }
        this.f6370j.add(eVar);
        com.anythink.china.common.b.a.a(this.f6369i).c(eVar);
        com.anythink.china.common.b.a.a(this.f6369i).a(eVar, 0L, 100L, true);
    }

    @Override // com.anythink.china.common.a.g
    public final boolean a(String str) {
        String str2 = com.anythink.china.common.c.b.a(str) + com.anythink.china.common.a.a.f6395g;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str2).exists();
    }

    public final int b(i iVar) {
        String strA = com.anythink.core.common.k.g.a(iVar);
        synchronized (this.f6370j) {
            for (int i2 = 0; i2 < this.f6370j.size(); i2++) {
                e eVar = this.f6370j.get(i2);
                if (eVar != null && eVar.f6433n.equals(strA)) {
                    return 0;
                }
            }
            ConcurrentHashMap<String, e> concurrentHashMap = this.f6371k;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(strA)) {
                return 0;
            }
            ConcurrentHashMap<String, e> concurrentHashMap2 = this.f6372l;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(strA)) {
                return 6;
            }
            ConcurrentHashMap<String, e> concurrentHashMap3 = this.f6374n;
            if ((concurrentHashMap3 == null || !concurrentHashMap3.containsKey(strA)) && !a(strA)) {
                return com.anythink.china.common.c.a.a(this.f6369i, iVar.B()) ? 5 : 1;
            }
            return 4;
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(String str, String str2, int i2) {
        e eVar;
        try {
            if (str2.equals(e.a.FAIL.toString())) {
                if (this.f6377q != null) {
                    e eVarRemove = this.f6377q.remove(str);
                    if (eVarRemove != null) {
                        eVarRemove.e();
                        String str3 = ad.f20405r + eVarRemove.f6422c + ") onClickNotification: download fail to retry";
                        d(eVarRemove);
                        return;
                    }
                    com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                    return;
                }
                return;
            }
            if (str2.equals(e.a.FINISH.toString())) {
                if (this.f6374n != null) {
                    e eVar2 = this.f6374n.get(str);
                    if (eVar2 != null) {
                        String str4 = ad.f20405r + eVar2.f6422c + ") onClickNotification: start intall";
                        com.anythink.china.common.b.a.a(this.f6369i).c(eVar2);
                        com.anythink.china.common.b.a.a(this.f6369i).a(eVar2);
                        b(eVar2);
                        return;
                    }
                    com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                    return;
                }
                return;
            }
            if (str2.equals(e.a.INSTALLED.toString())) {
                if (this.f6376p != null) {
                    e eVar3 = this.f6376p.get(str);
                    if (eVar3 != null) {
                        String str5 = ad.f20405r + eVar3.f6422c + ") onClickNotification: start open";
                        com.anythink.china.common.b.a.a(this.f6369i).c(eVar3);
                        a(eVar3, true);
                        return;
                    }
                    com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                    return;
                }
                return;
            }
            if (str2.equals(e.a.LOADING.toString())) {
                e eVar4 = this.f6371k.get(str);
                if (eVar4 != null) {
                    if (!eVar4.d() || eVar4.f6436q == 2) {
                        return;
                    }
                    String str6 = ad.f20405r + eVar4.f6422c + ") onClickNotification: pause download";
                    if (this.f6381u != null) {
                        this.f6381u.b(eVar4.f6433n);
                    }
                    this.f6372l.put(eVar4.f6433n, eVar4);
                    return;
                }
                com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                return;
            }
            if (str2.equals(e.a.PAUSE.toString())) {
                e eVar5 = this.f6372l.get(str);
                if (eVar5 != null) {
                    String str7 = ad.f20405r + eVar5.f6422c + ") onClickNotification: resume download";
                    d(eVar5);
                    return;
                }
                com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                return;
            }
            if (str2.equals(e.a.IDLE.toString())) {
                synchronized (this.f6370j) {
                    Iterator<e> it = this.f6370j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            eVar = null;
                            break;
                        }
                        e next = it.next();
                        if (next.f6433n.equals(str)) {
                            if (next.f6436q == 2) {
                                return;
                            }
                            String str8 = ad.f20405r + next.f6422c + ") onClickNotification: pause download";
                            this.f6370j.remove(next);
                            eVar = next;
                        }
                    }
                    if (eVar != null) {
                        eVar.k();
                        this.f6372l.put(eVar.f6433n, eVar);
                        com.anythink.china.common.b.a.a(this.f6369i).c(eVar);
                        com.anythink.china.common.b.a.a(this.f6369i).a(eVar, 0L, 100L, true);
                        return;
                    }
                    com.anythink.china.common.b.a.a(this.f6369i).a(i2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(String str, String str2) {
        e eVar;
        try {
            if (str2.equals(e.a.FAIL.toString()) && this.f6377q != null && this.f6377q.containsKey(str)) {
                e eVar2 = this.f6377q.get(str);
                String str3 = ad.f20405r + eVar2.f6422c + ") onCleanNotification: download fail";
                com.anythink.china.common.b.a.a(this.f6369i).c(eVar2);
                this.f6377q.remove(str);
            }
            if (str2.equals(e.a.FINISH.toString()) && this.f6374n != null && this.f6374n.containsKey(str)) {
                e eVar3 = this.f6374n.get(str);
                String str4 = ad.f20405r + eVar3.f6422c + ") onCleanNotification: download success";
                com.anythink.china.common.b.a.a(this.f6369i).c(eVar3);
                this.f6374n.remove(str);
            }
            if (str2.equals(e.a.INSTALLED.toString()) && this.f6376p != null && this.f6376p.containsKey(str)) {
                e eVar4 = this.f6376p.get(str);
                String str5 = ad.f20405r + eVar4.f6422c + ") onCleanNotification: install success";
                com.anythink.china.common.b.a.a(this.f6369i).c(eVar4);
                this.f6376p.remove(str);
            }
            if (!str2.equals(e.a.PAUSE.toString()) || (eVar = this.f6372l.get(str)) == null) {
                return;
            }
            if (this.f6381u != null) {
                this.f6381u.c(eVar.f6433n);
            }
            this.f6372l.remove(str);
            String str6 = ad.f20405r + eVar.f6422c + ") onCleanNotification: stop download";
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(e eVar, boolean z2) {
        com.anythink.core.common.f.b bVar = eVar.f6431l;
        if (bVar != null) {
            bVar.a(eVar.f6429j, eVar.a, eVar.b, z2);
        }
    }

    public final boolean a(i iVar) {
        String strA = com.anythink.core.common.k.g.a(iVar);
        ConcurrentHashMap<String, e> concurrentHashMap = this.f6371k;
        return concurrentHashMap != null && concurrentHashMap.containsKey(strA);
    }

    static /* synthetic */ void a(a aVar) {
        com.anythink.core.common.k.b.a.a().a(aVar.new AnonymousClass4());
    }
}
