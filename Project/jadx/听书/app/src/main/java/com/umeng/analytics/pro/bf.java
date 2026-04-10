package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes4.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f2188a;
    private final ch b;
    private bv c;

    public bf() {
        this(new bp.a());
    }

    public bf(bx bxVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f2188a = byteArrayOutputStream;
        ch chVar = new ch(byteArrayOutputStream);
        this.b = chVar;
        this.c = bxVar.a(chVar);
    }

    public byte[] a(aw awVar) throws bc {
        this.f2188a.reset();
        awVar.write(this.c);
        return this.f2188a.toByteArray();
    }

    public String a(aw awVar, String str) throws bc {
        try {
            return new String(a(awVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(aw awVar) throws bc {
        return new String(a(awVar));
    }
}
