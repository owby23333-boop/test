package d.a.o;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private l f20731u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Request f20734x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile boolean f20729s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    volatile Cancelable f20730t = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f20732v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f20733w = 0;

    public d(l lVar) {
        this.f20731u = lVar;
        this.f20734x = lVar.a.a();
    }

    static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f20733w;
        dVar.f20733w = i2 + 1;
        return i2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f20729s = true;
        if (this.f20730t != null) {
            this.f20730t.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f20729s) {
            return;
        }
        if (this.f20731u.a.i()) {
            String strB = d.a.k.a.b(this.f20731u.a.g());
            if (!TextUtils.isEmpty(strB)) {
                Request.Builder builderNewBuilder = this.f20734x.newBuilder();
                String str = this.f20734x.getHeaders().get(HttpConstant.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    strB = StringUtils.concatString(str, "; ", strB);
                }
                builderNewBuilder.addHeader(HttpConstant.COOKIE, strB);
                this.f20734x = builderNewBuilder.build();
            }
        }
        RequestStatistic requestStatistic = this.f20734x.a;
        requestStatistic.degraded = 2;
        requestStatistic.sendBeforeTime = System.currentTimeMillis() - this.f20734x.a.reqStart;
        anet.channel.session.b.a(this.f20734x, new e(this));
    }
}
