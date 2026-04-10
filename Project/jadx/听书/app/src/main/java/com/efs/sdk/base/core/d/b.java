package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1559a;
    public c b = new c();
    public byte[] c;
    public File d;

    public b(String str, byte b) {
        this.f1559a = new a(str, b);
    }

    public final long a() {
        d();
        return this.f1559a.f;
    }

    public final boolean b() {
        return !"none".equals(this.f1559a.d);
    }

    public final void a(String str) {
        this.f1559a.d = str;
    }

    public final void a(int i) {
        this.f1559a.e = i;
        d();
    }

    public final void b(int i) {
        this.f1559a.c = i;
    }

    public final void a(byte[] bArr) {
        this.c = bArr;
        d();
    }

    public final void c() {
        this.b.f1560a = true;
    }

    public static b a(ILogProtocol iLogProtocol) {
        b bVar = null;
        try {
            b bVar2 = new b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    bVar2.b(0);
                    bVar2.a(iLogProtocol.generate());
                } else if (bodyType == 1) {
                    bVar2.b(1);
                    bVar2.d = new File(iLogProtocol.getFilePath());
                } else {
                    Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                }
                return bVar2;
            } catch (Exception e) {
                e = e;
                bVar = bVar2;
                Log.e("efs.base", "log send error", e);
                return bVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void d() {
        byte[] bArr;
        if (this.f1559a.c == 0 && (bArr = this.c) != null) {
            this.f1559a.f = bArr.length;
        } else if (this.f1559a.c == 1 && this.d.exists()) {
            this.f1559a.f = this.d.length();
        }
    }
}
