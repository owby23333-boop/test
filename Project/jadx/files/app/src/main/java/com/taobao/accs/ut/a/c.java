package com.taobao.accs.ut.a;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public int a;
    public int b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18273k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18265c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18266d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18267e = 0;

    public void a() {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (jCurrentTimeMillis - this.f18273k) + " interval1:" + (jCurrentTimeMillis - this.f18270h), new Object[0]);
        }
        if (jCurrentTimeMillis - this.f18273k <= 1200000 || jCurrentTimeMillis - this.f18270h <= 60000) {
            return;
        }
        HashMap map = new HashMap();
        String str2 = null;
        try {
            strValueOf2 = String.valueOf(this.f18266d);
            try {
                strValueOf3 = String.valueOf(this.f18267e);
                try {
                    strValueOf = String.valueOf(221);
                    try {
                        map.put("connStatus", String.valueOf(this.a));
                        map.put("connType", String.valueOf(this.b));
                        map.put("tcpConnected", String.valueOf(this.f18265c));
                        map.put(IOptionConstant.proxy, String.valueOf(this.f18268f));
                        map.put("startServiceTime", String.valueOf(this.f18270h));
                        map.put("commitTime", String.valueOf(jCurrentTimeMillis));
                        map.put("networkAvailable", String.valueOf(this.f18271i));
                        map.put("threadIsalive", String.valueOf(this.f18272j));
                        map.put("url", this.f18269g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, strValueOf3, strValueOf, map), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str2 = strValueOf3;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + " " + th.toString(), new Object[0]);
                            }
                        }
                        str = strValueOf3;
                    } catch (Throwable th2) {
                        th = th2;
                        str = strValueOf3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = strValueOf3;
                    strValueOf = null;
                }
            } catch (Throwable th4) {
                th = th4;
                strValueOf = null;
            }
        } catch (Throwable th5) {
            th = th5;
            strValueOf = null;
            strValueOf2 = null;
        }
        try {
            UTMini.getInstance().commitEvent(66001, "MONITOR", strValueOf2, strValueOf3, strValueOf, map);
            this.f18273k = jCurrentTimeMillis;
        } catch (Throwable th6) {
            th = th6;
            strValueOf = strValueOf;
            str2 = str;
            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }
}
