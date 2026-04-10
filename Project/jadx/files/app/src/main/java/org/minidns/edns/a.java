package org.minidns.edns;

import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.edns.Edns;

/* JADX INFO: compiled from: EdnsOption.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final byte[] f21505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f21506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f21507e;

    /* JADX INFO: renamed from: org.minidns.edns.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EdnsOption.java */
    static /* synthetic */ class C0589a {
        static final /* synthetic */ int[] a = new int[Edns.OptionCode.values().length];

        static {
            try {
                a[Edns.OptionCode.NSID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected a(int i2, byte[] bArr) {
        this.a = i2;
        this.b = bArr.length;
        this.f21505c = bArr;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.write(this.f21505c);
    }

    protected abstract CharSequence b();

    public abstract Edns.OptionCode c();

    protected abstract CharSequence d();

    public final String toString() {
        if (this.f21506d == null) {
            this.f21506d = d().toString();
        }
        return this.f21506d;
    }

    public final String a() {
        if (this.f21507e == null) {
            this.f21507e = b().toString();
        }
        return this.f21507e;
    }

    protected a(byte[] bArr) {
        this.a = c().f21501s;
        this.b = bArr.length;
        this.f21505c = bArr;
    }

    public static a a(int i2, byte[] bArr) {
        if (C0589a.a[Edns.OptionCode.b(i2).ordinal()] != 1) {
            return new c(i2, bArr);
        }
        return new b(bArr);
    }
}
