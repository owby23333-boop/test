package com.ss.android.z.z.gc;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class gc {
    public boolean e;
    public String gc;
    public long z = -1;
    public int g = -1;
    public long dl = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2124a = -1;
    public int m = 0;

    public boolean equals(Object obj) {
        if ((obj instanceof gc) && obj != null) {
            gc gcVar = (gc) obj;
            return ((this.z > gcVar.z ? 1 : (this.z == gcVar.z ? 0 : -1)) == 0) && (this.g == gcVar.g) && ((this.dl > gcVar.dl ? 1 : (this.dl == gcVar.dl ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.gc) && TextUtils.isEmpty(gcVar.gc)) || (!TextUtils.isEmpty(this.gc) && !TextUtils.isEmpty(gcVar.gc) && this.gc.equals(gcVar.gc)));
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.z), Integer.valueOf(this.g), Long.valueOf(this.dl), this.gc});
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.z = dlVar.e();
        this.g = dlVar.p();
        this.f2124a = dlVar.sf();
        this.dl = dlVar.s();
        this.gc = dlVar.v();
        com.ss.android.socialbase.downloader.gc.z zVarGd = dlVar.gd();
        if (zVarGd != null) {
            this.m = zVarGd.z();
        } else {
            this.m = 0;
        }
        this.e = dlVar.io();
    }
}
