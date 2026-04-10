package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class aq extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static aq f18560d;
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18561c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18562e = true;
    private IntentFilter a = new IntentFilter();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static synchronized aq a() {
        if (f18560d == null) {
            f18560d = new aq();
        }
        return f18560d;
    }

    public final synchronized void b(Context context) {
        try {
            al.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void a(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        al.c("add action %s", str);
    }

    public final synchronized void a(Context context) {
        this.b = context;
        ap.a(new Runnable() { // from class: com.tencent.bugly.proguard.aq.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    al.a(aq.f18560d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        aq.this.b.registerReceiver(aq.f18560d, aq.this.a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f18562e) {
                    this.f18562e = false;
                    return true;
                }
                String strC = ab.c(this.b);
                al.c("is Connect BC ".concat(String.valueOf(strC)), new Object[0]);
                al.a("network %s changed to %s", this.f18561c, String.valueOf(strC));
                if (strC == null) {
                    this.f18561c = null;
                    return true;
                }
                String str = this.f18561c;
                this.f18561c = strC;
                long jCurrentTimeMillis = System.currentTimeMillis();
                ac acVarA = ac.a();
                ai aiVarA = ai.a();
                aa aaVarA = aa.a(context);
                if (acVarA != null && aiVarA != null && aaVarA != null) {
                    if (!strC.equals(str) && jCurrentTimeMillis - aiVarA.a(at.a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at atVarA = at.a();
                        if (atVarA != null) {
                            atVarA.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
