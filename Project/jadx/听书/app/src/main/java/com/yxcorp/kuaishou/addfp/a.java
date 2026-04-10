package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.e;

/* JADX INFO: loaded from: classes4.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ KWEGIDDFP f2525a;

    a(KWEGIDDFP kwegiddfp) {
        this.f2525a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f2525a.mParamContext == null) {
                this.f2525a.mCallBack.onFailed(-3, "parameter error");
                return;
            }
            Context unused = this.f2525a.mParamContext;
            int i = e.c;
            if (Build.VERSION.SDK_INT >= 28) {
                e.a();
            }
            KWEGIDDFP kwegiddfp = this.f2525a;
            kwegiddfp.mPkgName = kwegiddfp.mParamContext.getPackageName();
            c.c().b(this.f2525a.mPkgName);
            KWEGIDDFP kwegiddfp2 = this.f2525a;
            kwegiddfp2.getEGid(kwegiddfp2.mCallBack);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
