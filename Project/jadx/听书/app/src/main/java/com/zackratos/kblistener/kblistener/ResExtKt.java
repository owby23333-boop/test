package com.zackratos.kblistener.kblistener;

import android.content.res.Resources;
import android.util.TypedValue;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {t.q, "", "getDp", "(I)I", "kblistener_release"}, k = 2, mv = {1, 4, 2})
public final class ResExtKt {
    public static final int getDp(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) TypedValue.applyDimension(1, i, system.getDisplayMetrics());
    }
}
