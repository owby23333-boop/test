package com.ss.android.socialbase.downloader.zk;

/* JADX INFO: loaded from: classes4.dex */
public class ga {
    private e bf;
    private int d;
    private e e;
    private int tg = 10;

    public static class e {
        long bf;
        e d;
        long e;
        e tg;

        private e() {
        }
    }

    public long bf(long j, long j2) {
        synchronized (this) {
            e eVar = this.e;
            if (eVar == null) {
                return -1L;
            }
            e eVarE = e(j);
            if (eVarE == null) {
                return -1L;
            }
            long j3 = eVar.e - eVarE.e;
            long j4 = j2 - eVarE.bf;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    public boolean e(long j, long j2) {
        synchronized (this) {
            e eVar = this.e;
            if (eVar != null) {
                if (j >= eVar.e && j2 >= eVar.bf) {
                    e eVar2 = eVar.d;
                    if (eVar2 != null && j2 - eVar2.bf < 1000) {
                        eVar.e = j;
                        eVar.bf = j2;
                        return true;
                    }
                }
                return false;
            }
            e eVarE = e();
            eVarE.e = j;
            eVarE.bf = j2;
            if (eVar != null) {
                eVarE.d = eVar;
                eVar.tg = eVarE;
            }
            this.e = eVarE;
            return true;
        }
    }

    private e e() {
        e eVar;
        int i = this.d;
        if (i >= this.tg && (eVar = this.bf) != null) {
            e eVar2 = eVar.tg;
            eVar.tg = null;
            this.bf = eVar2;
            if (eVar2 != null) {
                eVar2.d = null;
            }
            return eVar;
        }
        this.d = i + 1;
        return new e();
    }

    private e e(long j) {
        e eVar = this.e;
        e eVar2 = null;
        while (eVar != null && eVar.bf > j) {
            eVar2 = eVar;
            eVar = eVar.d;
        }
        return (eVar == null || eVar2 == null || eVar == eVar2 || j - eVar.bf >= eVar2.bf - j) ? eVar2 : eVar;
    }
}
