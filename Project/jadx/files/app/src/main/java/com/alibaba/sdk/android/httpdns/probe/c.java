package com.alibaba.sdk.android.httpdns.probe;

/* JADX INFO: loaded from: classes.dex */
class c {
    private String hostName;
    private String[] ips;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f2213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f2214l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f2215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f2216s;

    c(String str, String[] strArr, String str2, String str3, long j2, long j3) {
        this.hostName = str;
        this.ips = strArr;
        this.f2215r = str2;
        this.f2216s = str3;
        this.f2213k = j2;
        this.f2214l = j3;
    }

    public long c() {
        return this.f2213k;
    }

    public long d() {
        return this.f2214l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    public String j() {
        return this.f2215r;
    }

    public String k() {
        return this.f2216s;
    }
}
