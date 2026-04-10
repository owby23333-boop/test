package com.drake.statelayout;

import android.view.View;
import com.umeng.analytics.pro.an;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThrottleClick.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0000¨\u0006\n"}, d2 = {"throttleClick", "", "Landroid/view/View;", an.aU, "", "unit", "Ljava/util/concurrent/TimeUnit;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "statelayout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ThrottleClickKt {
    public static /* synthetic */ void throttleClick$default(View view, long j, TimeUnit timeUnit, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        throttleClick(view, j, timeUnit, function1);
    }

    public static final void throttleClick(View view, long j, TimeUnit unit, Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(new ThrottleClickListener(j, unit, block));
    }
}
