package d.a.k;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import java.net.HttpCookie;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ String f20723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ String f20724t;

    d(String str, String str2) {
        this.f20723s = str;
        this.f20724t = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f20717d == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(a.f20717d.a) || !HttpCookie.domainMatches(a.f20717d.f20720d, HttpUrl.parse(this.f20723s).host()) || TextUtils.isEmpty(this.f20724t)) {
                return;
            }
            if (this.f20724t.contains(a.f20717d.a + "=")) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f20723s);
            cookieMonitorStat.cookieName = a.f20717d.a;
            cookieMonitorStat.cookieText = a.f20717d.b;
            cookieMonitorStat.setCookie = a.f20717d.f20719c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
