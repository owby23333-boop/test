package com.anythink.expressad.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.x;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static String a = "mtg_retry_report=1";
    public static int b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8000c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8001d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f8002e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f8003f = 50;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f8004g = 600000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f8005h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f8006i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f8007j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f8008k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f8009l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f8010m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f8011n = "RetryReportControl";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f8012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f8013r;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<String, com.anythink.expressad.a.a.b> f8014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c f8015p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private BroadcastReceiver f8016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Handler f8017t;

    /* JADX INFO: renamed from: com.anythink.expressad.a.a.a$1, reason: invalid class name */
    final class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.this.f8017t.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.a.a.a$a, reason: collision with other inner class name */
    private static class C0173a {
        private static a a = new a(0);

        private C0173a() {
        }
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                a.a(a.a());
            } else {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, com.anythink.expressad.a.a.b.a);
                }
            }
        }
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    private void c() {
        try {
            if (this.f8016s == null) {
                this.f8016s = new AnonymousClass1();
                Context contextG = n.a().g();
                if (contextG != null) {
                    contextG.registerReceiver(this.f8016s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        Context contextG;
        if (this.f8016s == null || (contextG = n.a().g()) == null) {
            return;
        }
        contextG.unregisterReceiver(this.f8016s);
    }

    private a() {
        this.f8014o = new ConcurrentHashMap<>();
        this.f8015p = new c(f8003f);
        this.f8017t = new b(Looper.getMainLooper());
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
        f8002e = aVarB.U();
        b = aVarB.W() * 1000;
        f8004g = aVarB.V() * 1000;
        f8012q = aVarB.T();
        f8013r = aVarB.S();
        try {
            if (this.f8016s == null) {
                this.f8016s = new AnonymousClass1();
                Context contextG = n.a().g();
                if (contextG != null) {
                    contextG.registerReceiver(this.f8016s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        return C0173a.a;
    }

    private void b() {
        c cVar = this.f8015p;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                a(it.next(), com.anythink.expressad.a.a.b.b);
            }
        }
    }

    private void a(String str, com.anythink.expressad.a.a.b bVar) {
        if (this.f8015p == null) {
            this.f8015p = new c(f8003f);
        }
        this.f8015p.a(str, bVar);
    }

    private static boolean b(int i2) {
        return i2 == f8006i || i2 == f8007j;
    }

    private void a(String str) {
        Message messageObtainMessage = this.f8017t.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = str;
        this.f8017t.sendMessageDelayed(messageObtainMessage, b);
    }

    private static boolean c(int i2) {
        return a(i2) || b(i2) || i2 == f8010m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        String str2;
        c cVar = this.f8015p;
        if (cVar != null) {
            com.anythink.expressad.a.a.b bVarB = cVar.b(str);
            this.f8015p.a(str);
            if (bVarB == null) {
                com.anythink.expressad.a.a.b bVar = this.f8014o.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.h() + ((long) f8004g) || bVar.g() >= f8002e || i2 == com.anythink.expressad.a.a.b.b) {
                    return;
                }
                a(str);
                return;
            }
            if (System.currentTimeMillis() <= bVarB.h() + ((long) f8004g)) {
                bVarB.a(i2);
                this.f8014o.put(str, bVarB);
                if (x.b(str) == 0) {
                    str2 = str + "?" + a;
                } else {
                    str2 = str + DispatchConstants.SIGN_SPLIT_SYMBOL + a;
                }
                com.anythink.expressad.a.a.a(n.a().g(), bVarB.f(), bVarB.e(), str2, bVarB.a(), bVarB.b(), bVarB.d());
                return;
            }
            if (i2 != com.anythink.expressad.a.a.b.b) {
            }
        }
    }

    private static boolean a(int i2) {
        return i2 == f8009l || i2 == f8008k;
    }

    public final void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, String str3, boolean z2, boolean z3, int i2) {
        if (!(a(i2) || b(i2) || i2 == f8010m) || TextUtils.isEmpty(str)) {
            return;
        }
        String strReplace = str.replace("?" + a, "").replace(DispatchConstants.SIGN_SPLIT_SYMBOL + a, "");
        if (this.f8014o == null) {
            this.f8014o = new ConcurrentHashMap<>();
        }
        com.anythink.expressad.a.a.b bVarRemove = this.f8014o.remove(strReplace);
        if (bVarRemove == null) {
            bVarRemove = new com.anythink.expressad.a.a.b(str, str2);
            bVarRemove.b(i2);
            bVarRemove.a(z2);
            bVarRemove.b(z3);
            bVarRemove.a(cVar);
            bVarRemove.a(str3);
        } else if (bVarRemove.c() != com.anythink.expressad.a.a.b.b) {
            bVarRemove.b(str2);
        }
        if ((a(i2) && f8012q != 0) || (b(i2) && f8013r != 0) || i2 == f8010m) {
            if (System.currentTimeMillis() < bVarRemove.h() + ((long) f8004g)) {
                if (this.f8015p == null) {
                    this.f8015p = new c(f8003f);
                }
                this.f8015p.a(strReplace, bVarRemove);
                if (bVarRemove.c() != com.anythink.expressad.a.a.b.a || bVarRemove.g() > f8002e) {
                    return;
                }
                a(strReplace);
                return;
            }
            bVarRemove.c();
        }
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f8015p;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                aVar.a(it.next(), com.anythink.expressad.a.a.b.b);
            }
        }
    }
}
