package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18258e = "BindApp";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18259f = false;

    private void b(String str) {
        String str2;
        String strValueOf;
        if (this.f18259f) {
            return;
        }
        this.f18259f = true;
        HashMap map = new HashMap();
        try {
            str2 = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.a);
            map.put("bind_date", this.b);
            map.put("ret", this.f18256c ? "y" : "n");
            map.put("fail_reasons", this.f18257d);
            map.put("push_token", "");
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str2, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }

    public void a(String str) {
        this.f18257d = str;
    }

    public void a(int i2) {
        if (i2 == -4) {
            a("msg too large");
            return;
        }
        if (i2 == -3) {
            a("service not available");
            return;
        }
        if (i2 == -2) {
            a("param error");
            return;
        }
        if (i2 == -1) {
            a("network fail");
        } else if (i2 != 200) {
            if (i2 != 300) {
                a(String.valueOf(i2));
            } else {
                a("app not bind");
            }
        }
    }

    public void a() {
        b("BindApp");
    }
}
