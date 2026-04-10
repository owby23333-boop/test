package com.anythink.expressad.exoplayer.e;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements h {
    private static final Constructor<? extends e> a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9015c;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.anythink.expressad.exoplayer.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        a = constructor;
    }

    private synchronized c a(int i2) {
        this.b = i2;
        return this;
    }

    private synchronized c b(int i2) {
        this.f9015c = i2;
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.e.h
    public final synchronized e[] a() {
        e[] eVarArr;
        eVarArr = new e[a == null ? 2 : 3];
        eVarArr[0] = new com.anythink.expressad.exoplayer.e.a.e(this.f9015c);
        eVarArr[1] = new com.anythink.expressad.exoplayer.e.a.g(this.b);
        if (a != null) {
            try {
                eVarArr[2] = a.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return eVarArr;
    }
}
