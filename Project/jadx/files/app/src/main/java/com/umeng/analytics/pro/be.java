package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class be {
    private final ByteArrayOutputStream a;
    private final cg b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bu f19536c;

    public be() {
        this(new bo.a());
    }

    public byte[] a(av avVar) throws bb {
        this.a.reset();
        avVar.write(this.f19536c);
        return this.a.toByteArray();
    }

    public String b(av avVar) throws bb {
        return new String(a(avVar));
    }

    public be(bw bwVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new cg(this.a);
        this.f19536c = bwVar.a(this.b);
    }

    public String a(av avVar, String str) throws bb {
        try {
            return new String(a(avVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
