package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: UPushNotifyPreferences.java */
/* JADX INFO: loaded from: classes3.dex */
class aa {
    private static final String a = "e_u";
    private static final String b = "e_s";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20359c = "req_interval";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20360d = "req_ts";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20361e = "rep_ts";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20362f = "info";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f20363g = "sync";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final af f20364h = new af(AgooConstants.MESSAGE_NOTIFICATION);

    private long h() {
        return this.f20364h.b(f20360d, 0L);
    }

    private long i() {
        return this.f20364h.b(f20361e, 0L);
    }

    private long j() {
        return Math.max(600L, Math.min(this.f20364h.b(f20359c, com.anythink.expressad.d.a.b.aC), 86400L)) * 1000;
    }

    public void a(boolean z2) {
        this.f20364h.a(a, z2);
    }

    public void b(boolean z2) {
        this.f20364h.a(b, z2);
    }

    public boolean c() {
        return Math.abs(System.currentTimeMillis() - h()) > j();
    }

    public boolean d() {
        return Math.abs(System.currentTimeMillis() - h()) > 86400000;
    }

    public boolean e() {
        return Math.abs(System.currentTimeMillis() - i()) < 60000;
    }

    public String f() {
        String strB = this.f20364h.b("info", "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                return new String(i.a(strB));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public boolean g() {
        return this.f20364h.b(f20363g, false);
    }

    public boolean a() {
        return this.f20364h.b(a, true);
    }

    public boolean b() {
        return this.f20364h.b(b, true);
    }

    public void c(long j2) {
        this.f20364h.a(f20359c, j2);
    }

    public void a(long j2) {
        this.f20364h.a(f20360d, j2);
    }

    public void b(long j2) {
        this.f20364h.a(f20361e, j2);
    }

    public void c(boolean z2) {
        this.f20364h.a(f20363g, z2);
    }

    public void a(String str) {
        String strD = null;
        if (str != null) {
            try {
                strD = i.d(str.getBytes());
            } catch (Exception unused) {
            }
        }
        this.f20364h.a("info", strD);
    }
}
