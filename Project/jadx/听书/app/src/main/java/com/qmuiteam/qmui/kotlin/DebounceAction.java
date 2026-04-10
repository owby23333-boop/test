package com.qmuiteam.qmui.kotlin;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/qmuiteam/qmui/kotlin/DebounceAction;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "block", "Lkotlin/Function1;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "getView", "()Landroid/view/View;", "run", "qmui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DebounceAction implements Runnable {
    private Function1<? super View, Unit> block;
    private final View view;

    public DebounceAction(View view, Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        this.view = view;
        this.block = block;
    }

    public final Function1<View, Unit> getBlock() {
        return this.block;
    }

    public final View getView() {
        return this.view;
    }

    public final void setBlock(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.block = function1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.view.isAttachedToWindow()) {
            this.block.invoke(this.view);
        }
    }
}
