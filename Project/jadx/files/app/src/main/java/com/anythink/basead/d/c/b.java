package com.anythink.basead.d.c;

import android.text.TextUtils;
import com.anythink.core.common.e.i;
import com.anythink.expressad.foundation.h.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static void a(i iVar) {
        String strF = iVar.f();
        if (TextUtils.isEmpty(strF)) {
            return;
        }
        iVar.d(j.b(strF));
    }
}
