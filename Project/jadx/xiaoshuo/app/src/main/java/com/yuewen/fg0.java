package com.yuewen;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface fg0 {
    static fg0 get() {
        return (fg0) com.duokan.core.app.b.get();
    }

    Application a();

    Context b(Context context);

    Class<? extends Activity> g();

    void i(Runnable runnable);

    boolean n();

    Class<? extends Activity> o();

    Class<? extends Activity> s();
}
