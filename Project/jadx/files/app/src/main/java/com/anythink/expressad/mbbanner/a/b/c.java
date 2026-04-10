package com.anythink.expressad.mbbanner.a.b;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final String a = "2000067";
    public static final String b = "2000068";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10790c = "2000069";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10800m;

    private c() {
    }

    private c a(boolean z2) {
        this.f10800m = z2;
        return this;
    }

    private String b() {
        return this.f10791d;
    }

    private String c() {
        return this.f10792e;
    }

    private String d() {
        return this.f10793f;
    }

    private String e() {
        return this.f10794g;
    }

    private String f() {
        return this.f10795h;
    }

    private String g() {
        return this.f10796i;
    }

    private String h() {
        return this.f10797j;
    }

    private String i() {
        return this.f10798k;
    }

    private int j() {
        return this.f10799l;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f10792e)) {
            sb.append("unit_id=");
            sb.append(this.f10792e);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(this.f10794g)) {
            sb.append("cid=");
            sb.append(this.f10794g);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(this.f10795h)) {
            sb.append("rid=");
            sb.append(this.f10795h);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(this.f10796i)) {
            sb.append("rid_n=");
            sb.append(this.f10796i);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(this.f10797j)) {
            sb.append("creative_id=");
            sb.append(this.f10797j);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(this.f10798k)) {
            sb.append("reason=");
            sb.append(this.f10798k);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (this.f10799l != 0) {
            sb.append("result=");
            sb.append(this.f10799l);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (this.f10800m) {
            sb.append("hb=1&");
        }
        sb.append("network_type=");
        n.a().g();
        sb.append(k.a());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        if (!TextUtils.isEmpty(this.f10791d)) {
            sb.append("key=");
            sb.append(this.f10791d);
        }
        return sb.toString();
    }

    private static c a() {
        return new c();
    }

    private c b(String str) {
        this.f10792e = str;
        return this;
    }

    private c c(String str) {
        this.f10793f = str;
        return this;
    }

    private c d(String str) {
        this.f10794g = str;
        return this;
    }

    private c e(String str) {
        this.f10795h = str;
        return this;
    }

    private c f(String str) {
        this.f10796i = str;
        return this;
    }

    private c g(String str) {
        this.f10797j = str;
        return this;
    }

    private c h(String str) {
        this.f10798k = str;
        return this;
    }

    private c a(String str) {
        this.f10791d = str;
        return this;
    }

    private c a(int i2) {
        this.f10799l = i2;
        return this;
    }
}
