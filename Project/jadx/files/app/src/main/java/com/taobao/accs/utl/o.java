package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class o implements Runnable {
    final /* synthetic */ l a;

    o(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (l.b bVar : l.f18332d) {
            if (bVar != null) {
                Application unused = l.f18333e;
                bVar.b();
            }
        }
    }
}
