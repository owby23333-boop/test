package com.bytedance.sdk.component.zk;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.wu;
import com.yuewen.eq2;

/* JADX INFO: loaded from: classes.dex */
class bf implements Comparable, Runnable {
    private e bf;
    private long d;
    private p e;
    private Thread tg = null;

    public bf(p pVar, e eVar) {
        this.d = 0L;
        this.e = pVar;
        this.bf = eVar;
        this.d = SystemClock.uptimeMillis();
    }

    private void e(String str, String str2, long j) {
        wu.vn("DelegateRunnable", "pool is " + str + "  name is " + str2 + "is timeout,cost " + j);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof bf) {
            return this.e.compareTo(((bf) obj).e());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        p pVar;
        return (obj instanceof bf) && (pVar = this.e) != null && pVar.equals(((bf) obj).e());
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        String strBf;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.d;
        this.tg = Thread.currentThread();
        p pVar = this.e;
        if (pVar != null) {
            pVar.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.bf != null) {
            tg.e();
        }
        if (wu.e()) {
            Object[] objArr = new Object[8];
            objArr[0] = "run: pool  = ";
            e eVar = this.bf;
            strBf = eq2.g;
            objArr[1] = eVar != null ? eVar.e() : eq2.g;
            objArr[2] = " waitTime =";
            objArr[3] = Long.valueOf(j);
            objArr[4] = " taskCost = ";
            objArr[5] = Long.valueOf(jUptimeMillis2);
            objArr[6] = " name=";
            p pVar2 = this.e;
            objArr[7] = pVar2 != null ? pVar2.bf() : eq2.g;
            wu.bf("DelegateRunnable", objArr);
            String strE = this.bf.e();
            strE.hashCode();
            switch (strE) {
                case "ad":
                case "init":
                    if (jUptimeMillis2 > 2000) {
                        e eVar2 = this.bf;
                        String strE2 = eVar2 != null ? eVar2.e() : eq2.g;
                        p pVar3 = this.e;
                        if (pVar3 != null) {
                            strBf = pVar3.bf();
                        }
                        e(strE2, strBf, jUptimeMillis2);
                        break;
                    }
                    break;
                case "io":
                    if (jUptimeMillis2 > 5000) {
                        e eVar3 = this.bf;
                        String strE3 = eVar3 != null ? eVar3.e() : eq2.g;
                        p pVar4 = this.e;
                        if (pVar4 != null) {
                            strBf = pVar4.bf();
                        }
                        e(strE3, strBf, jUptimeMillis2);
                        break;
                    }
                    break;
                case "log":
                    if (jUptimeMillis2 > 3000) {
                        e eVar4 = this.bf;
                        String strE4 = eVar4 != null ? eVar4.e() : eq2.g;
                        p pVar5 = this.e;
                        if (pVar5 != null) {
                            strBf = pVar5.bf();
                        }
                        e(strE4, strBf, jUptimeMillis2);
                        break;
                    }
                    break;
                case "computation":
                    if (jUptimeMillis2 > 1000) {
                        e eVar5 = this.bf;
                        String strE5 = eVar5 != null ? eVar5.e() : eq2.g;
                        p pVar6 = this.e;
                        if (pVar6 != null) {
                            strBf = pVar6.bf();
                        }
                        e(strE5, strBf, jUptimeMillis2);
                        break;
                    }
                    break;
            }
        }
    }

    public p e() {
        return this.e;
    }
}
