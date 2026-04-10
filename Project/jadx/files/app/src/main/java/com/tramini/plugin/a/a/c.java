package com.tramini.plugin.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.tramini.plugin.a.h;
import com.tramini.plugin.a.k.b;
import com.tramini.plugin.a.k.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static c f19312i;
    private Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f19313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f19314d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f19317g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19315e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f19318h = false;
    private Handler b = new Handler(Looper.getMainLooper());

    final class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Context f19319s;

        a(Context context) {
            this.f19319s = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a(c.this, this.f19319s);
        }
    }

    final class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ l.c.a.a.a f19321s;

        b(c cVar, l.c.a.a.a aVar) {
            this.f19321s = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tramini.plugin.a.k.b.a().a(this.f19321s);
        }
    }

    /* JADX INFO: renamed from: com.tramini.plugin.a.a.c$c, reason: collision with other inner class name */
    final class RunnableC0537c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Context f19322s;

        /* JADX INFO: renamed from: com.tramini.plugin.a.a.c$c$a */
        final class a implements h.e {
            a() {
            }

            @Override // com.tramini.plugin.a.h.e
            public final void a(l.c.a.a.a aVar) {
                c.this.b(aVar);
                h.a(c.this.a).a();
                h.a(c.this.a).a(aVar, aVar.o());
            }
        }

        RunnableC0537c(Context context) {
            this.f19322s = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (l.c.a.a.b.a(this.f19322s).a()) {
                l.c.a.a.b.a(this.f19322s).a(new a());
            }
        }
    }

    final class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ l.c.a.a.a f19324s;

        d(l.c.a.a.a aVar) {
            this.f19324s = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int size;
            try {
                if (c.this.a == null) {
                    return;
                }
                try {
                    if (c.this.f19313c != null) {
                        com.tramini.plugin.a.a.b.a(c.this.a).a(c.this.f19313c);
                        c.this.f19313c = null;
                    }
                } catch (Throwable unused) {
                }
                c.this.f19313c = new com.tramini.plugin.a.b();
                IntentFilter intentFilter = new IntentFilter();
                List<String> listD = this.f19324s != null ? this.f19324s.d() : null;
                if (listD != null && (size = listD.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        intentFilter.addAction(listD.get(i2));
                    }
                }
                com.tramini.plugin.a.a.b.a(c.this.a).a(c.this.f19313c, intentFilter);
            } catch (Throwable unused2) {
            }
        }
    }

    final class e implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f19326s;

        e(String str) {
            this.f19326s = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(c.this.a, "tramini", "P_CE_PE", "");
            com.tramini.plugin.a.k.c.c(this.f19326s);
            c cVar = c.this;
            c.b(cVar, cVar.a);
        }
    }

    final class f implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f19328s;

        f(c cVar, String str) {
            this.f19328s = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tramini.plugin.a.k.d.a = new JSONObject(this.f19328s);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static c c() {
        if (f19312i == null) {
            synchronized (c.class) {
                f19312i = new c();
            }
        }
        return f19312i;
    }

    public final void b(Context context) {
        b.C0543b.a().a(new RunnableC0537c(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l.c.a.a.a aVar) {
        b(new d(aVar));
    }

    public final Context a() {
        return this.a;
    }

    public final void b(String str) {
        b.C0543b.a().a(new e(str));
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.a = context.getApplicationContext();
            if (com.tramini.plugin.a.k.h.a(context)) {
                return;
            }
            try {
                if (this.f19314d != null) {
                    com.tramini.plugin.a.a.b.a(this.a).a(this.f19314d);
                    this.f19314d = null;
                }
            } catch (Throwable unused) {
            }
            try {
                this.f19314d = new com.tramini.plugin.a.c();
                IntentFilter intentFilter = new IntentFilter();
                String packageName = this.a.getPackageName();
                intentFilter.addAction(com.tramini.plugin.a.k.f.a(packageName + packageName));
                com.tramini.plugin.a.a.b.a(this.a).a(this.f19314d, intentFilter);
            } catch (Throwable unused2) {
            }
            b.C0543b.a().a(new a(context), 1000L);
        } catch (Throwable unused3) {
        }
    }

    public final int b() {
        return this.f19315e;
    }

    private void b(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    public final void c(String str) {
        b.C0543b.a().a(new f(this, str));
    }

    static /* synthetic */ void b(c cVar, Context context) {
        cVar.b(l.c.a.a.b.a(context).b());
        cVar.b(context);
    }

    public final synchronized void a(l.c.a.a.a aVar) {
        if (this.f19318h) {
            return;
        }
        if (aVar != null) {
            this.f19318h = true;
            com.tramini.plugin.a.k.b.a().a(aVar);
            c().a(new b(this, aVar), 120000L);
        }
    }

    public final void a(String[] strArr) {
        this.f19317g = strArr;
    }

    public final boolean a(String str) {
        String[] strArr = this.f19317g;
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i2) {
        this.f19315e = i2;
    }

    public static void a(Runnable runnable) {
        b.C0543b.a().a(runnable);
    }

    public final void a(Runnable runnable, long j2) {
        this.b.postDelayed(runnable, j2);
    }

    static /* synthetic */ void a(c cVar, Context context) {
        boolean z2;
        String strB = i.b(cVar.a, "tramini", "P_IL_O", "");
        cVar.f19316f = false;
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (strB == null) {
            z2 = false;
        } else {
            if (!TextUtils.isEmpty(strB)) {
                String[] strArrSplit = strB.split("-");
                if (!TextUtils.equals(strArrSplit[0], str)) {
                    cVar.f19316f = true;
                } else {
                    try {
                        cVar.f19315e = Integer.parseInt(strArrSplit[1]);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        cVar.f19315e = 1;
                    }
                    z2 = false;
                }
            }
            z2 = true;
        }
        if (z2) {
            i.a(cVar.a, "tramini", "P_IL_O", str + GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
            cVar.f19315e = 1;
        }
        h.a(context).a(cVar.f19316f);
        cVar.f19316f = false;
    }
}
