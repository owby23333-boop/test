package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.account.AccountType;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class st1 {
    public static final st1 g = new st1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountType f17624b;
    public final String c;
    public final String d;
    public final String e;
    public final Map<String, String> f;

    public st1() {
        this(null);
    }

    public boolean a() {
        AccountType accountType = this.f17624b;
        if (accountType == AccountType.XIAO_MI || accountType == AccountType.XIAOMI_GUEST) {
            return TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.e);
        }
        if (accountType == AccountType.ANONYMOUS) {
            return TextUtils.isEmpty(this.c);
        }
        return true;
    }

    public boolean b() {
        return !d();
    }

    public boolean c(st1 st1Var) {
        return TextUtils.equals(this.f17623a, st1Var.f17623a);
    }

    public boolean d() {
        return !a() && (AccountType.XIAO_MI.equals(this.f17624b) || AccountType.XIAOMI_GUEST.equals(this.f17624b));
    }

    public st1(bi biVar) {
        if (biVar == null || biVar.isEmpty()) {
            this.f17623a = "";
            this.f17624b = AccountType.NONE;
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = null;
            return;
        }
        this.f17623a = biVar.m();
        this.f17624b = biVar.s();
        this.c = biVar.g();
        this.d = biVar.j().b();
        this.e = biVar.k();
        this.f = biVar.t();
    }
}
