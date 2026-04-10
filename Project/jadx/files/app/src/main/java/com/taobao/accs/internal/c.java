package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.j;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class c implements com.taobao.accs.c {
    private com.taobao.accs.net.b a;

    public c(String str) {
        this.a = new j(GlobalClientInfo.a, 1, str);
    }

    @Override // com.taobao.accs.c
    public void a() {
        this.a.a();
    }

    @Override // com.taobao.accs.c
    public void b() {
        this.a.k();
    }

    @Override // com.taobao.accs.c
    public String c() {
        return this.a.i();
    }

    @Override // com.taobao.accs.c
    public String d() {
        return this.a.f18206i.getAppSecret();
    }

    @Override // com.taobao.accs.c
    public boolean e(String str) {
        return this.a.j().c(str);
    }

    @Override // com.taobao.accs.c
    public boolean f(String str) {
        return this.a.j().d(str);
    }

    @Override // com.taobao.accs.c
    public void a(boolean z2, boolean z3) {
        this.a.a(z2, z3);
    }

    @Override // com.taobao.accs.c
    public String b(String str) {
        return this.a.b(str);
    }

    @Override // com.taobao.accs.c
    public void c(String str) {
        this.a.a = str;
    }

    @Override // com.taobao.accs.c
    public void d(String str) {
        this.a.b = str;
    }

    @Override // com.taobao.accs.c
    public String e() {
        return this.a.f18206i.getStoreId();
    }

    @Override // com.taobao.accs.c
    public boolean f() {
        return this.a.m();
    }

    @Override // com.taobao.accs.c
    public boolean a(String str) {
        return this.a.a(str);
    }

    @Override // com.taobao.accs.c
    public void b(AccsConnectStateListener accsConnectStateListener) {
        this.a.b(accsConnectStateListener);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, int i2) {
        this.a.b(message, i2);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, boolean z2) {
        this.a.b(message, z2);
    }

    @Override // com.taobao.accs.c
    public void a(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.b bVar = this.a;
        if (bVar instanceof j) {
            ((j) bVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.c
    public boolean a(String str, String str2) {
        return this.a.j().b(str, str2);
    }

    @Override // com.taobao.accs.c
    public void a(AccsConnectStateListener accsConnectStateListener) {
        this.a.a(accsConnectStateListener);
    }
}
