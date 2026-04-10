package com.kwad.sdk.a;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.b.kwai.a.Hx.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }
}
