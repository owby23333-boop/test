package com.yuewen;

import android.content.SharedPreferences;
import com.duokan.core.app.AppWrapper;
import com.duokan.reader.BasePrivacyManager;
import com.duokan.reader.ReaderEnv;

/* JADX INFO: loaded from: classes11.dex */
public class m6 {
    public static final String e = "env";
    public static final String f = "global__topon_ad_id_";
    public static final String g = "global__toutiao_ad_id_";
    public static final String h = "global__reading_ad_xout_time_";
    public static final String i = "global__ad_disabled";
    public static final String j = "exper_page_ad_refresh";
    public static final String k = "key_page_ad_stop_time";
    public static final String l = "key_page_ad_stop_count";
    public static final String m = "bottom_slide_click_ad_count";
    public static final String n = "bottom_slide_click_ad_count_time";
    public static final String o = "isUseSdkSplashPositive";
    public static final String p = "splashPositiveDayLimit";
    public static final String q = "splashPositiveInterval";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f14309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f14310b;
    public final String c;
    public final String d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m6 f14311a = new m6();
    }

    public static m6 h() {
        return a.f14311a;
    }

    public boolean A() {
        return this.f14309a.getInt(o, 1) == 1;
    }

    public boolean B() {
        return BasePrivacyManager.o().w() && com.duokan.core.app.b.get().isWebAccessEnabled();
    }

    public void C(boolean z) {
        SharedPreferences.Editor editorEdit = this.f14309a.edit();
        editorEdit.putBoolean("global__ad_disabled", z);
        editorEdit.apply();
    }

    public final void D(long j2) {
        SharedPreferences.Editor editorEdit = this.f14309a.edit();
        editorEdit.putLong(n, j2);
        editorEdit.apply();
    }

    public final void E(int i2) {
        SharedPreferences.Editor editorEdit = this.f14309a.edit();
        editorEdit.putInt(m, i2);
        editorEdit.apply();
    }

    public final synchronized void F(int i2) {
        r().putInt("key_click_reward_video_count", i2);
        f();
    }

    public final synchronized void G(long j2) {
        r().putLong("key_click_reward_video_time", j2);
        f();
    }

    public final void H(long j2) {
        SharedPreferences.Editor editorEdit = this.f14309a.edit();
        editorEdit.putLong("slide_click_ad_count_time", j2);
        editorEdit.apply();
    }

    public synchronized void I(int i2) {
        r().putInt(j, i2);
        f();
    }

    public void J(boolean z) {
        ReaderEnv.get().L9(z);
    }

    public synchronized void K(String str) {
        r().putLong("global__reading_ad_xout_time_" + str, System.currentTimeMillis());
        f();
    }

    public final void L(int i2) {
        SharedPreferences.Editor editorEdit = this.f14309a.edit();
        editorEdit.putInt("slide_click_ad_count", i2);
        editorEdit.apply();
    }

    public void M(int i2) {
        r().putInt("splashPositiveDayCount", i2);
        f();
    }

    public void N(int i2) {
        r().putInt(p, i2);
        f();
    }

    public void O(long j2) {
        r().putLong(q, j2);
        f();
    }

    public void P(long j2) {
        r().putLong("splashPositiveShowTime", j2);
        f();
    }

    public synchronized void Q(String str, String str2) {
        r().putString("global__topon_ad_id_" + str, str2);
        f();
    }

    public synchronized void R(String str, String str2) {
        r().putString("global__toutiao_ad_id_" + str, str2);
        f();
    }

    public void S(int i2) {
        r().putInt(o, i2);
        f();
    }

    public void a() {
        SharedPreferences.Editor editorR = r();
        if (c04.m(p())) {
            editorR.putInt(l, this.f14309a.getInt(l, 0) + 1);
        } else {
            editorR.putInt(l, 1).putLong(k, System.currentTimeMillis());
        }
        f();
    }

    public void b() {
        if (c04.m(j())) {
            E(k() + 1);
        } else {
            E(1);
            D(System.currentTimeMillis());
        }
    }

    public void c() {
        F(l() + 1);
        G(System.currentTimeMillis());
    }

    public void d() {
        if (c04.m(n())) {
            L(t() + 1);
        } else {
            L(1);
        }
        H(System.currentTimeMillis());
    }

    public void e() {
        if (c04.m(h().m())) {
            return;
        }
        h().F(0);
    }

    public synchronized void f() {
        SharedPreferences.Editor editor = this.f14310b;
        if (editor != null) {
            editor.apply();
            this.f14310b = null;
        }
    }

    public synchronized boolean g() {
        return this.f14309a.getInt(j, -1) > 0;
    }

    public boolean i() {
        return this.f14309a.getBoolean("global__ad_disabled", false) || qt1.d;
    }

    public final long j() {
        return this.f14309a.getLong(n, 0L);
    }

    public int k() {
        if (c04.m(j())) {
            return this.f14309a.getInt(m, 0);
        }
        return 0;
    }

    public synchronized int l() {
        return this.f14309a.getInt("key_click_reward_video_count", 0);
    }

    public final synchronized long m() {
        return this.f14309a.getLong("key_click_reward_video_time", 0L);
    }

    public final long n() {
        return this.f14309a.getLong("slide_click_ad_count_time", 0L);
    }

    public int o() {
        if (c04.m(p())) {
            return this.f14309a.getInt(l, 0);
        }
        return 0;
    }

    public final long p() {
        return this.f14309a.getLong(k, 0L);
    }

    public boolean q() {
        return ReaderEnv.get().u5();
    }

    public final SharedPreferences.Editor r() {
        if (this.f14310b == null) {
            this.f14310b = this.f14309a.edit();
        }
        return this.f14310b;
    }

    public synchronized long s(String str) {
        return this.f14309a.getLong("global__reading_ad_xout_time_" + str, 0L);
    }

    public int t() {
        if (c04.m(n())) {
            return this.f14309a.getInt("slide_click_ad_count", 0);
        }
        return 0;
    }

    public int u() {
        return this.f14309a.getInt("splashPositiveDayCount", 0);
    }

    public int v() {
        return this.f14309a.getInt(p, 3);
    }

    public long w() {
        return this.f14309a.getLong(q, 180L);
    }

    public long x() {
        return this.f14309a.getLong("splashPositiveShowTime", 0L);
    }

    public synchronized String y(String str, String str2) {
        return this.f14309a.getString("global__topon_ad_id_" + str, str2);
    }

    public synchronized String z(String str, String str2) {
        return this.f14309a.getString("global__toutiao_ad_id_" + str, str2);
    }

    public m6() {
        this.f14310b = null;
        this.c = "splashPositiveDayCount";
        this.d = "splashPositiveShowTime";
        this.f14309a = com.duokan.utils.mmkv.a.e().f("env", AppWrapper.v());
    }
}
