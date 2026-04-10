package com.funny.audio.core.ext;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u001a\u0012\u0010\r\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\n\u0010\u0011\u001a\u00020\u0007*\u00020\b\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"lastClickTimeMillis", "", "getLastClickTimeMillis", "()J", "setLastClickTimeMillis", "(J)V", "click", "", "Landroid/view/View;", "gap", "", "block", "Lkotlin/Function0;", "dpToPx", "Landroid/content/Context;", t.q, "", "hideKeyboard", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewKt {
    private static long lastClickTimeMillis;

    public static final long getLastClickTimeMillis() {
        return lastClickTimeMillis;
    }

    public static final void setLastClickTimeMillis(long j) {
        lastClickTimeMillis = j;
    }

    public static /* synthetic */ void click$default(View view, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 200;
        }
        click(view, i, function0);
    }

    public static final void click(View view, final int i, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.core.ext.ViewKt$click$listener$1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - ViewKt.getLastClickTimeMillis() > i) {
                    ViewKt.setLastClickTimeMillis(jCurrentTimeMillis);
                    block.invoke();
                }
            }
        });
    }

    public static final void hideKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final int dpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }
}
