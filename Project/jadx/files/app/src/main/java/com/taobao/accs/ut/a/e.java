package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f18287g = "sendAck";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18288h = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f18288h) {
            return;
        }
        this.f18288h = true;
        HashMap map = new HashMap();
        try {
            str = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.a);
            map.put("session_id", this.b);
            map.put("data_id", this.f18283c);
            map.put("ack_date", this.f18284d);
            map.put("service_id", this.f18285e);
            map.put("fail_reasons", this.f18286f);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }
}
