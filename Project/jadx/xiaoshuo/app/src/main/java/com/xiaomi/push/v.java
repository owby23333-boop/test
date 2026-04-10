package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
class v extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f8334a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.f8334a = runnable;
    }

    @Override // com.xiaomi.push.u
    public void a(Context context) {
        Runnable runnable = this.f8334a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
