package com.xiaomi.httpdns.data;

import com.yuewen.ho;
import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
public class Report implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7360a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7361b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = ho.j1;
    public int h = 0;
    public String i = "";
    public String j = "";
    public long k;
    public boolean l;
    public int m;

    public String toString() {
        return "Report{host='" + this.f7360a + "', ips='" + this.f7361b + "', error='" + this.c + "', netType='" + this.d + "', name='" + this.e + "', subName='" + this.f + "', bdPing=0, status='" + this.g + "', errorType=" + this.h + ", extra='" + this.i + "', originIps='" + this.j + "', time=" + this.k + ", isRedirect=" + this.l + ", code=" + this.m + '}';
    }
}
