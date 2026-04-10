package com.yuewen;

import android.content.Context;
import com.duokan.core.app.ManagedContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public final class x60 extends ManagedContext {
    public final Context g;
    public final WeakReference<xv1> h;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public x60(xv1 xv1Var) {
        Context context = (Context) xv1Var;
        super(context);
        this.g = context.getApplicationContext();
        this.h = new WeakReference<>(xv1Var);
    }

    @Override // com.duokan.core.app.ManagedContext, android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
        if (context != null) {
            i(context);
            return;
        }
        Context context2 = (Context) this.h.get();
        if (context2 != null) {
            i(context2);
        } else {
            i(this.g);
        }
    }
}
