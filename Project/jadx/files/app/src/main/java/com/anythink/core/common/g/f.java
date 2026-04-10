package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.e.an;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7494e = 1;
    String a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f7495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f7496d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private an f7497f;

    private f(String str) {
        this.f7496d = 0;
        this.a = str;
    }

    public static f a(String str, int i2, String str2) {
        return new f(str, i2, str2);
    }

    public static f b(String str) {
        return new f(str);
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        return "";
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        an anVar;
        if (1 != this.f7496d || (anVar = this.f7497f) == null) {
            return null;
        }
        anVar.a("200");
        com.anythink.core.common.j.c.a(this.f7497f);
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        an anVar;
        if (1 == this.f7496d && ErrorCode.httpStatuException.equals(adError.getCode()) && (anVar = this.f7497f) != null) {
            anVar.a(adError.getPlatformCode());
            this.f7497f.b(adError.getPlatformMSG());
            com.anythink.core.common.j.c.a(this.f7497f);
        }
    }

    private f(String str, int i2, String str2) {
        this(str);
        this.f7496d = 1;
        this.b = i2;
        this.f7495c = str2;
    }

    public final void a(an anVar) {
        this.f7497f = anVar;
    }
}
