package com.qmuiteam.qmui.kotlin;

import android.os.SystemClock;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a$\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\u0006\u001a(\u0010\n\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a(\u0010\u000b\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a-\u0010\f\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"debounceClick", "Landroid/view/View$OnClickListener;", "wait", "", "block", "Lkotlin/Function1;", "Landroid/view/View;", "", "throttleClick", "clearSkin", "onClick", "onDebounceClick", "skin", "increment", "", "Lcom/qmuiteam/qmui/skin/QMUISkinValueBuilder;", "Lkotlin/ExtensionFunctionType;", "qmui_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewKtKt {
    public static /* synthetic */ View.OnClickListener throttleClick$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return throttleClick(j, function1);
    }

    public static final View.OnClickListener throttleClick(final long j, final Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new View.OnClickListener() { // from class: com.qmuiteam.qmui.kotlin.ViewKtKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKtKt.m620throttleClick$lambda0(j, block, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: throttleClick$lambda-0, reason: not valid java name */
    public static final void m620throttleClick$lambda0(long j, Function1 block, View v) {
        Intrinsics.checkNotNullParameter(block, "$block");
        long jUptimeMillis = SystemClock.uptimeMillis();
        Object tag = v.getTag(R.id.qmui_click_timestamp);
        Long l = tag instanceof Long ? (Long) tag : null;
        if (jUptimeMillis - (l == null ? 0L : l.longValue()) > j) {
            v.setTag(R.id.qmui_click_timestamp, Long.valueOf(jUptimeMillis));
            Intrinsics.checkNotNullExpressionValue(v, "v");
            block.invoke(v);
        }
    }

    public static /* synthetic */ View.OnClickListener debounceClick$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return debounceClick(j, function1);
    }

    public static final View.OnClickListener debounceClick(final long j, final Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new View.OnClickListener() { // from class: com.qmuiteam.qmui.kotlin.ViewKtKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKtKt.m619debounceClick$lambda1(block, j, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: debounceClick$lambda-1, reason: not valid java name */
    public static final void m619debounceClick$lambda1(Function1 block, long j, View v) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Object tag = v.getTag(R.id.qmui_click_debounce_action);
        DebounceAction debounceAction = tag instanceof DebounceAction ? (DebounceAction) tag : null;
        if (debounceAction == null) {
            Intrinsics.checkNotNullExpressionValue(v, "v");
            debounceAction = new DebounceAction(v, block);
            v.setTag(R.id.qmui_click_debounce_action, debounceAction);
        } else {
            debounceAction.setBlock(block);
        }
        DebounceAction debounceAction2 = debounceAction;
        v.removeCallbacks(debounceAction2);
        v.postDelayed(debounceAction2, j);
    }

    public static /* synthetic */ void onClick$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        onClick(view, j, function1);
    }

    public static final void onClick(View view, long j, Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(throttleClick(j, block));
    }

    public static /* synthetic */ void onDebounceClick$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        onDebounceClick(view, j, function1);
    }

    public static final void onDebounceClick(View view, long j, Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(debounceClick(j, block));
    }

    public static /* synthetic */ void skin$default(View view, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        skin(view, z, function1);
    }

    public static final void skin(View view, boolean z, Function1<? super QMUISkinValueBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        QMUISkinValueBuilder builder = QMUISkinValueBuilder.acquire();
        if (z) {
            Object tag = view.getTag(R.id.qmui_skin_value);
            if (tag instanceof String) {
                builder.convertFrom((String) tag);
            }
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        block.invoke(builder);
        QMUISkinHelper.setSkinValue(view, builder);
        builder.release();
    }

    public static final void clearSkin(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        QMUISkinHelper.setSkinValue(view, "");
    }
}
