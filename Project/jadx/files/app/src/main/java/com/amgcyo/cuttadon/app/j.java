package com.amgcyo.cuttadon.app;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/* JADX INFO: compiled from: AppLifecyclesImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements me.jessyan.art.base.f.e {
    @Override // me.jessyan.art.base.f.e
    public void a(@NonNull Application application) {
    }

    @Override // me.jessyan.art.base.f.e
    public void attachBaseContext(@NonNull Context context) {
    }

    @Override // me.jessyan.art.base.f.e
    public void b(@NonNull Application application) {
        if (LeakCanary.isInAnalyzerProcess(application)) {
            return;
        }
        me.jessyan.art.f.e.a(application).e().put(me.jessyan.art.d.j.c.d(RefWatcher.class.getName()), RefWatcher.DISABLED);
    }
}
