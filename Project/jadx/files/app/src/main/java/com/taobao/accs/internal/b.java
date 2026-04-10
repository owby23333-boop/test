package com.taobao.accs.internal;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class b implements Runnable {
    final /* synthetic */ com.taobao.accs.c a;
    final /* synthetic */ ACCSManagerImpl b;

    b(ACCSManagerImpl aCCSManagerImpl, com.taobao.accs.c cVar) {
        this.b = aCCSManagerImpl;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.accs.c cVar = this.a;
        if (cVar != null) {
            cVar.a(true, false);
        }
    }
}
