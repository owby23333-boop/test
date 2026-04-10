package com.bytedance.pangle.log;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f14608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f14609e;

    private a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.f14607c = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f14609e = jCurrentTimeMillis;
        this.f14608d = jCurrentTimeMillis;
        ZeusLogger.i(this.a, this.b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f14609e;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.f14608d;
        ZeusLogger.i(this.a, this.b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f14607c, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f14608d;
    }
}
