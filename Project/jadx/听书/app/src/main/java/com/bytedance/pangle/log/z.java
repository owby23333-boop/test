package com.bytedance.pangle.log;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f517a;
    private String dl;
    private String g;
    private long gc;
    private String z;

    public static z z(String str, String str2, String str3) {
        return new z(str, str2, str3);
    }

    private z(String str, String str2, String str3) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.gc = jCurrentTimeMillis;
        this.f517a = jCurrentTimeMillis;
        ZeusLogger.i(this.z, this.g + String.format(" watcher[%s]-start", str3));
    }

    public long z(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.gc;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.f517a;
        ZeusLogger.i(this.z, this.g + String.format(" watcher[%s]-%s cost=%s, total=%s", this.dl, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long z() {
        return System.currentTimeMillis() - this.f517a;
    }
}
