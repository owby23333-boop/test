package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ RequestStatistic a;
    final /* synthetic */ ExceptionDetector b;

    c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.b = exceptionDetector;
        this.a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.a.ip) && this.a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.a.host)) {
                    this.b.b = this.a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.a.host)) {
                    this.b.f300c = this.a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.a.host)) {
                    this.b.f301d = this.a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.a.url)) {
                this.b.f302e.add(Pair.create(this.a.url, Integer.valueOf(this.a.statusCode)));
            }
            if (this.b.c()) {
                this.b.b();
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}
