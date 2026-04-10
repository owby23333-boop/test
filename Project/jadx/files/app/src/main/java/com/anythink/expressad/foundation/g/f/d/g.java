package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class g extends i<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10544c = g.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10545d;

    public g(int i2, String str, String str2, com.anythink.expressad.foundation.g.f.e<String> eVar) {
        super(i2, str, eVar);
        this.f10545d = str2;
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    protected final k<String> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return k.a(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.f10553d)), cVar);
        } catch (UnsupportedEncodingException e2) {
            o.d(f10544c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        try {
            if (this.f10545d == null) {
                return null;
            }
            return this.f10545d.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
