package d.a.k;

import anet.channel.util.ALog;
import java.net.HttpCookie;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ String f20722s;

    c(String str) {
        this.f20722s = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f20717d == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f20722s)) {
                if (httpCookie.getName().equals(a.f20717d.a)) {
                    a.f20717d.b = httpCookie.toString();
                    a.f20717d.f20720d = httpCookie.getDomain();
                    a.f20717d.f20719c = this.f20722s;
                    a.f20717d.a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
