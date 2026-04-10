package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.a f1561a;

    public abstract com.efs.sdk.base.core.e.a.a a();

    public final void a(com.efs.sdk.base.core.d.b bVar) {
        try {
            if (this.f1561a == null) {
                synchronized (this) {
                    if (this.f1561a == null) {
                        com.efs.sdk.base.core.e.a.a aVarA = a();
                        this.f1561a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.f1561a.a(bVar);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
