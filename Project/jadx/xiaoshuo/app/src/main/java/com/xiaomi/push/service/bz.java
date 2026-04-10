package com.xiaomi.push.service;

import com.xiaomi.push.service.by;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
class bz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ by f8271a;

    public bz(by byVar) {
        this.f8271a = byVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Iterator it = this.f8271a.f1007a.values().iterator();
            while (it.hasNext()) {
                ((by.a) it.next()).run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("Sync job exception :" + e.getMessage());
        }
        this.f8271a.f1008a = false;
    }
}
