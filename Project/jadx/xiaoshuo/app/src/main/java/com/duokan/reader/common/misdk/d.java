package com.duokan.reader.common.misdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.duokan.reader.BaseEnv;
import com.duokan.reader.BasePrivacyManager;
import com.yuewen.lb2;
import com.yuewen.wf2;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.duokan.reader.common.misdk.a, BasePrivacyManager.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f4047b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.duokan.reader.common.misdk.a f4048a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f4049a = "com.xiaomi";
    }

    public interface b {
        void a(Account account);
    }

    public d() {
        if (BasePrivacyManager.o() == null || !BasePrivacyManager.o().w()) {
            this.f4048a = new e();
        } else {
            this.f4048a = new MiAccountSdkManager();
        }
        w(BaseEnv.get());
        A();
    }

    public static d B() {
        if (f4047b == null) {
            synchronized (d.class) {
                if (f4047b == null) {
                    f4047b = new d();
                    if (BasePrivacyManager.o() != null) {
                        BasePrivacyManager.o().c(f4047b);
                    }
                }
            }
        }
        return f4047b;
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void A() {
        this.f4048a.A();
    }

    @Override // com.duokan.reader.BasePrivacyManager.b
    public void W9() {
        this.f4048a = new MiAccountSdkManager();
        A();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void a() {
        this.f4048a.a();
    }

    @Override // com.duokan.reader.common.misdk.a
    public Account b() {
        return this.f4048a.b();
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean c() {
        return this.f4048a.c();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void d(Runnable runnable) {
        this.f4048a.d(runnable);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void e(Runnable runnable) {
        this.f4048a.e(runnable);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void f() {
        this.f4048a.f();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void g(Runnable runnable) {
        this.f4048a.g(runnable);
    }

    @Override // com.duokan.reader.common.misdk.a
    public String getUserData(Account account, String str) {
        return this.f4048a.getUserData(account, str);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized Account getXiaomiAccount() {
        return this.f4048a.getXiaomiAccount();
    }

    @Override // com.duokan.reader.common.misdk.a
    public String h(Context context, String str) {
        return this.f4048a.h(context, str);
    }

    @Override // com.duokan.reader.common.misdk.a
    public void i(String str, Runnable runnable, Runnable runnable2) {
        this.f4048a.i(str, runnable, runnable2);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void invalidateAuthToken(String str, String str2) {
        this.f4048a.invalidateAuthToken(str, str2);
    }

    @Override // com.duokan.reader.common.misdk.a
    public void j(@NonNull b bVar) {
        this.f4048a.A();
        this.f4048a.j(bVar);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void k() {
        this.f4048a.k();
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized Account l() {
        return this.f4048a.l();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void m(b bVar) {
        this.f4048a.m(bVar);
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean n() {
        return this.f4048a.n();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void o(@NonNull lb2 lb2Var) {
        this.f4048a.o(lb2Var);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void p(Activity activity) {
        this.f4048a.p(activity);
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean q() {
        return this.f4048a.q();
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized Account r() {
        return this.f4048a.r();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void s(wf2<Boolean> wf2Var) {
        this.f4048a.s(wf2Var);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void setPassword(Account account, String str) {
        this.f4048a.setPassword(account, str);
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean t() {
        return this.f4048a.t();
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean u() {
        return this.f4048a.u();
    }

    @Override // com.duokan.reader.common.misdk.a
    public boolean v() {
        return this.f4048a.v();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void w(BaseEnv baseEnv) {
        this.f4048a.w(baseEnv);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized boolean x() {
        return this.f4048a.x();
    }

    @Override // com.duokan.reader.common.misdk.a
    public void y(Context context, String str, wf2<String> wf2Var) {
        this.f4048a.y(context, str, wf2Var);
    }

    @Override // com.duokan.reader.common.misdk.a
    public synchronized void z(String str, Bundle bundle, AccountManagerCallback<Bundle> accountManagerCallback) {
        this.f4048a.z(str, bundle, accountManagerCallback);
    }
}
