package com.anythink.expressad.b;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.anythink.core.common.res.image.b {
    String a;

    private b(String str, String str2) {
        super(str);
        this.a = str2;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.a);
            byte[] bArr = new byte[2048];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 2);
    }
}
