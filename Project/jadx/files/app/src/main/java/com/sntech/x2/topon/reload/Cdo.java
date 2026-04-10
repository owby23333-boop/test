package com.sntech.x2.topon.reload;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.expressad.d.a.b;
import com.google.gson.Gson;
import com.sntech.x2.Cif;
import com.sntech.x2.topon.reload.ReloadStore;
import com.sntech.x2.topon.strategy.ReloadStrategy;
import org.json.JSONException;
import org.json.JSONObject;
import r.c;
import x.a;
import z0.o;

/* JADX INFO: renamed from: com.sntech.x2.topon.reload.do, reason: invalid class name */
/* JADX INFO: compiled from: ReloadController.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static Cdo f143if;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public ReloadStore f144do = new ReloadStore();

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void m171do() {
        this.f144do.getClass();
        ReloadStrategy reloadStrategy = null;
        String strA = c.a("reload_stat", null);
        ReloadStore.ReloadStat reloadStat = strA == null ? new ReloadStore.ReloadStat() : (ReloadStore.ReloadStat) new Gson().fromJson(strA, ReloadStore.ReloadStat.class);
        if (!TextUtils.isEmpty(reloadStat.reloadId) && !reloadStat.reported) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("reloadID", reloadStat.reloadId);
                jSONObject.put(b.f8401z, reloadStat.reloadTime);
                jSONObject.put("reloadTimes", reloadStat.reloadTimes);
            } catch (JSONException unused) {
            }
            o.a().a("RELOAD", jSONObject);
            reloadStat.reported = true;
            this.f144do.getClass();
            c.b("reload_stat", new Gson().toJson(reloadStat));
        }
        a.b().getClass();
        try {
            String strA2 = f.a.a(z.a.f21746d, null);
            if (strA2 != null) {
                reloadStrategy = (ReloadStrategy) new Gson().fromJson(new JSONObject(strA2).toString(), ReloadStrategy.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (reloadStrategy == null || !reloadStrategy.reloadFlag.booleanValue()) {
            return;
        }
        if (!TextUtils.isEmpty(reloadStrategy.reloadID) && reloadStrategy.reloadFlag.booleanValue() && (!reloadStrategy.reloadID.equals(reloadStat.reloadId) || ((System.currentTimeMillis() - reloadStat.reloadTime) / 1000 > reloadStrategy.interval && reloadStat.reloadTimes < reloadStrategy.reloadTimes))) {
            ReloadStore.ReloadStat reloadStat2 = new ReloadStore.ReloadStat();
            reloadStat2.reloadId = reloadStrategy.reloadID;
            reloadStat2.reloadTime = System.currentTimeMillis();
            reloadStat2.reloadTimes = reloadStat.reloadTimes + 1;
            reloadStat2.reported = false;
            this.f144do.getClass();
            c.b("reload_stat", new Gson().toJson(reloadStat2));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused2) {
            }
            Context context = Cif.f137do;
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            launchIntentForPackage.addFlags(268468224);
            context.getApplicationContext().startActivity(launchIntentForPackage);
            Process.killProcess(Process.myPid());
        }
    }
}
