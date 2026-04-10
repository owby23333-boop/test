package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes3.dex */
class a implements Runnable {
    final /* synthetic */ b a;

    a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f17804d.getPOFactory();
            this.a.b = true;
        } catch (e e2) {
            GDTLogger.e(e2.getMessage(), e2);
        }
    }
}
