package com.sn.android;

import android.os.Process;
import com.anythink.expressad.video.module.a.a.m;
import com.sn.android.entity.InitConfig;
import com.sntech.cc.Cdo;
import e0.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import z0.o;

/* JADX INFO: renamed from: com.sn.android.try, reason: invalid class name */
/* JADX INFO: compiled from: RiskChecker.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ctry {

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public static Ctry f72try;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public ScheduledFuture f75if;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public Object f74for = new Object();

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public int f76new = 0;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final ScheduledExecutorService f73do = Executors.newScheduledThreadPool(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void m90for() {
        i.c(null, "check risk");
        this.f76new++;
        Cdo.m94do(new Cdo.InterfaceC0505do() { // from class: com.sn.android.e
            @Override // com.sntech.cc.Cdo.InterfaceC0505do
            /* JADX INFO: renamed from: do, reason: not valid java name */
            public final void mo76do(Object obj) {
                this.a.m89do(obj);
            }
        });
        synchronized (this.f74for) {
            try {
                this.f74for.wait();
            } catch (InterruptedException e2) {
                i.b(null, "exception: " + e2);
            }
        }
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static void m91new() {
        try {
            Thread.sleep(m.ag);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public synchronized void m92do() {
        InitConfig initConfig = n.a.a;
        boolean z2 = true;
        if (initConfig == null || initConfig.checkRisk != 1) {
            z2 = false;
        }
        if (z2 && this.f75if == null) {
            this.f75if = this.f73do.scheduleAtFixedRate(new Runnable() { // from class: com.sn.android.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17903s.m90for();
                }
            }, 0L, 1L, TimeUnit.MINUTES);
        }
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final void m93if() {
        new Thread(new Runnable() { // from class: com.sn.android.a
            @Override // java.lang.Runnable
            public final void run() {
                Ctry.m91new();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void m89do(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            m93if();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("riskUser", true);
                jSONObject.put("counter", this.f76new);
                jSONObject.put("timestamp", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            o.a().a("RISK_USER_CHECKED", jSONObject);
            this.f75if.cancel(false);
            this.f75if = null;
        }
        synchronized (this.f74for) {
            this.f74for.notify();
        }
    }
}
