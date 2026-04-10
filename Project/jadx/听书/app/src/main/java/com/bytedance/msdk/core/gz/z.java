package com.bytedance.msdk.core.gz;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f401a;
    private long dl;
    private String g;
    private String z;

    public z(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public z(String str, String str2, long j, String str3) {
        this.z = str2;
        this.g = str;
        this.dl = j;
        this.f401a = str3;
    }

    public long z() {
        return this.dl;
    }

    public String g() {
        return this.f401a;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.z + "', adnName='" + this.g + "', effectiveTime=" + this.dl + '}';
    }
}
