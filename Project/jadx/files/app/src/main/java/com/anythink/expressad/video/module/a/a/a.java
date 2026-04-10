package com.anythink.expressad.video.module.a.a;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {
    private com.anythink.expressad.foundation.d.c V;
    private Activity a;

    private a(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.a = activity;
        this.V = cVar;
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i2, Object obj) {
        Activity activity;
        super.a(i2, obj);
        if (i2 != 106 || (activity = this.a) == null || this.V == null) {
            return;
        }
        activity.finish();
    }
}
