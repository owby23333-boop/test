package com.ss.android.socialbase.downloader.pf;

/* JADX INFO: loaded from: classes4.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2108a = 10;
    private int dl;
    private z g;
    private z z;

    public boolean z(long j, long j2) {
        synchronized (this) {
            z zVar = this.z;
            if (zVar != null) {
                if (j >= zVar.z && j2 >= zVar.g) {
                    z zVar2 = zVar.dl;
                    if (zVar2 != null && j2 - zVar2.g < 1000) {
                        zVar.z = j;
                        zVar.g = j2;
                        return true;
                    }
                }
                return false;
            }
            z zVarZ = z();
            zVarZ.z = j;
            zVarZ.g = j2;
            if (zVar != null) {
                zVarZ.dl = zVar;
                zVar.f2109a = zVarZ;
            }
            this.z = zVarZ;
            return true;
        }
    }

    public long g(long j, long j2) {
        synchronized (this) {
            z zVar = this.z;
            if (zVar == null) {
                return -1L;
            }
            z zVarZ = z(j);
            if (zVarZ == null) {
                return -1L;
            }
            long j3 = zVar.z - zVarZ.z;
            long j4 = j2 - zVarZ.g;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private z z() {
        z zVar;
        int i = this.dl;
        if (i >= this.f2108a && (zVar = this.g) != null) {
            z zVar2 = zVar.f2109a;
            zVar.f2109a = null;
            this.g = zVar2;
            if (zVar2 != null) {
                zVar2.dl = null;
            }
            return zVar;
        }
        this.dl = i + 1;
        return new z();
    }

    private z z(long j) {
        z zVar = this.z;
        z zVar2 = null;
        while (zVar != null && zVar.g > j) {
            zVar2 = zVar;
            zVar = zVar.dl;
        }
        return (zVar == null || zVar2 == null || zVar == zVar2 || j - zVar.g >= zVar2.g - j) ? zVar2 : zVar;
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        z f2109a;
        z dl;
        long g;
        long z;

        private z() {
        }
    }
}
