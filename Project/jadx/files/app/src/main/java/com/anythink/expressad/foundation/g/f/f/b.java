package com.anythink.expressad.foundation.g.f.f;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final int a;
    private final List<com.anythink.expressad.foundation.g.f.c.c> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputStream f10551c;

    public b(int i2, List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this(i2, list, null);
    }

    public final int a() {
        return this.a;
    }

    public final List<com.anythink.expressad.foundation.g.f.c.c> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final InputStream c() {
        return this.f10551c;
    }

    public b(int i2, List<com.anythink.expressad.foundation.g.f.c.c> list, InputStream inputStream) {
        this.a = i2;
        this.b = list;
        this.f10551c = inputStream;
    }
}
