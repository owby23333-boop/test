package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f18216c;

    c(b bVar, String str, boolean z2) {
        this.f18216c = bVar;
        this.a = str;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f18216c.f18202e.a(this.a);
        if (messageA != null) {
            this.f18216c.f18202e.a(messageA, -9);
            this.f18216c.a(this.a, this.b, "receive data time out");
            ALog.e(this.f18216c.d(), this.a + "-> receive data time out!", new Object[0]);
        }
    }
}
