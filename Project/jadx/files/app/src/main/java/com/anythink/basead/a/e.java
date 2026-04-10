package com.anythink.basead.a;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static int a(Context context, com.anythink.core.common.e.i iVar) {
        int iD = iVar.D();
        return (iD == 1 || iD == 4) ? com.anythink.core.common.k.h.a(context, "myoffer_cta_install_now", com.anythink.expressad.foundation.h.i.f10649g) : com.anythink.core.common.k.h.a(context, "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.f10649g);
    }

    public static boolean a(com.anythink.core.common.e.i iVar) {
        return (TextUtils.isEmpty(iVar.t()) && TextUtils.isEmpty(iVar.r()) && TextUtils.isEmpty(iVar.s())) ? false : true;
    }
}
