package com.drake.statelayout;

import android.view.View;
import com.umeng.analytics.pro.an;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThrottleClick.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B2\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u001f\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/drake/statelayout/ThrottleClickListener;", "Landroid/view/View$OnClickListener;", an.aU, "", "unit", "Ljava/util/concurrent/TimeUnit;", "block", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;)V", "lastTime", "onClick", "v", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThrottleClickListener implements View.OnClickListener {
    private Function1<? super View, Unit> block;
    private final long interval;
    private long lastTime;
    private final TimeUnit unit;

    public ThrottleClickListener(long j, TimeUnit unit, Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(block, "block");
        this.interval = j;
        this.unit = unit;
        this.block = block;
    }

    public /* synthetic */ ThrottleClickListener(long j, TimeUnit timeUnit, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 500L : j, (i & 2) != 0 ? TimeUnit.MILLISECONDS : timeUnit, function1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastTime > this.unit.toMillis(this.interval)) {
            this.lastTime = jCurrentTimeMillis;
            this.block.invoke(v);
        }
    }
}
