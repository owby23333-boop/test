package d.a.k;

import android.text.TextUtils;
import anet.channel.util.ALog;
import d.a.k.a;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(a.f())) {
                return;
            }
            a.C0562a unused = a.f20717d = new a.C0562a(a.f());
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "", null, e2, new Object[0]);
        }
    }
}
