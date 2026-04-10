package com.bytedance.msdk.gz.z;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f492a;
    private String dl;
    private String g;
    private long gc;
    private String z;

    public void z(String str) {
        this.z = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void dl(String str) {
        this.dl = str;
    }

    public String z() {
        return this.f492a;
    }

    public void a(String str) {
        this.f492a = str;
    }

    public void z(long j) {
        this.gc = j;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.z + "', adnRit='" + this.g + "', adnName='" + this.dl + "', adAction='" + this.f492a + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.gc)) + '}';
    }
}
