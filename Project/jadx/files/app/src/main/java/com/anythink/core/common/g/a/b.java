package com.anythink.core.common.g.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7440c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f7441k = b.class.getSimpleName();
    boolean b = true;

    public b(String str, int i2) {
        this.f7440c = 1;
        this.a = str;
        if (i2 == 1000) {
            this.f7440c = 1;
        } else if (i2 == 1001) {
            this.f7440c = 2;
        }
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i2) {
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return this.f7440c;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        return !TextUtils.isEmpty(this.a) ? c.a(this.a) : new byte[0];
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return this.b;
    }
}
