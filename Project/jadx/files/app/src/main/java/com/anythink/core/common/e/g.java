package com.anythink.core.common.e;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends aa {
    public static final int a = 1;
    public static final int b = 2;
    private String R;
    private String S;
    private int am = 1;

    public final String a() {
        return this.S;
    }

    public final String b() {
        return this.R;
    }

    public final int c() {
        return this.am;
    }

    @Override // com.anythink.core.common.e.i
    public final int d() {
        return this.am == 1 ? 2 : 4;
    }

    public final void a(String str) {
        this.S = str;
    }

    public final void b(String str) {
        this.R = str;
    }

    public final void a(int i2) {
        this.am = i2;
    }
}
