package com.taobao.accs.net;

import androidx.core.app.NotificationCompat;
import anet.channel.session.TnetSpdySession;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class q implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f18235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f18236d;

    q(j jVar, int i2, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f18236d = jVar;
        this.a = i2;
        this.b = bArr;
        this.f18235c = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != 200) {
            ALog.e(this.f18236d.d(), "drop frame len:" + this.b.length + " frameType" + this.a, new Object[0]);
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f18236d.f18202e.a(this.b, this.f18235c.getHost());
            com.taobao.accs.ut.a.d dVarG = this.f18236d.f18202e.g();
            if (dVarG != null) {
                dVarG.f18274c = String.valueOf(jCurrentTimeMillis);
                dVarG.f18278g = this.f18236d.f18200c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
                dVarG.a();
            }
        } catch (Throwable th) {
            ALog.e(this.f18236d.d(), "onDataReceive ", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
