package com.zackratos.kblistener.kblistener;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a\f\u0010#\u001a\u00020\n*\u00020\u0002H\u0002\u001a1\u0010$\u001a\u00020\n*\u00020\u00022%\b\u0002\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u001a1\u0010&\u001a\u00020\n*\u00020\u00022%\b\u0002\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"b\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006*\u00020\u00022#\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\"(\u0010\u0011\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00108B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"b\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006*\u00020\u00022#\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f\"(\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c\"(\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u001c\"(\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010\u001c¨\u0006'"}, d2 = {"_visibleHeight", "", "Landroid/view/View;", "get_visibleHeight", "(Landroid/view/View;)I", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "originHeight", "", "closeKeyboardListener", "getCloseKeyboardListener", "(Landroid/view/View;)Lkotlin/jvm/functions/Function1;", "setCloseKeyboardListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "", "keyboardOpened", "getKeyboardOpened", "(Landroid/view/View;)Z", "setKeyboardOpened", "(Landroid/view/View;Z)V", MediaFormat.KEY_HEIGHT, "openKeyboardListener", "getOpenKeyboardListener", "setOpenKeyboardListener", "getOriginHeight", "setOriginHeight", "(Landroid/view/View;I)V", "originVisibleHeight", "getOriginVisibleHeight", "setOriginVisibleHeight", "visibleHeight", "getVisibleHeight", "setVisibleHeight", "addKeyboardListener", "onKeyboardClose", "block", "onKeyboardOpen", "kblistener_release"}, k = 2, mv = {1, 4, 2})
public final class ViewKt {
    public static /* synthetic */ void onKeyboardOpen$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        onKeyboardOpen(view, function1);
    }

    public static final void onKeyboardOpen(View onKeyboardOpen, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(onKeyboardOpen, "$this$onKeyboardOpen");
        addKeyboardListener(onKeyboardOpen);
        setOpenKeyboardListener(onKeyboardOpen, function1);
    }

    public static /* synthetic */ void onKeyboardClose$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        onKeyboardClose(view, function1);
    }

    public static final void onKeyboardClose(View onKeyboardClose, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(onKeyboardClose, "$this$onKeyboardClose");
        addKeyboardListener(onKeyboardClose);
        setCloseKeyboardListener(onKeyboardClose, function1);
    }

    private static final void addKeyboardListener(final View view) {
        if (Intrinsics.areEqual(view.getTag(R.id.kbl_keyboard_listener), (Object) true)) {
            return;
        }
        int height = view.getHeight();
        if (height > 0) {
            setOriginHeight(view, height);
            setOriginVisibleHeight(view, height);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.zackratos.kblistener.kblistener.ViewKt.addKeyboardListener.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (ViewKt.getOriginHeight(view) < 0) {
                    View view2 = view;
                    ViewKt.setOriginHeight(view2, view2.getHeight());
                }
                int i = ViewKt.get_visibleHeight(view);
                if (ViewKt.getOriginVisibleHeight(view) < 0) {
                    ViewKt.setOriginVisibleHeight(view, i);
                }
                int originVisibleHeight = ViewKt.getOriginVisibleHeight(view) - i;
                if (!ViewKt.getKeyboardOpened(view) && originVisibleHeight > ResExtKt.getDp(100)) {
                    Function1 openKeyboardListener = ViewKt.getOpenKeyboardListener(view);
                    if (openKeyboardListener != null) {
                    }
                    ViewKt.setKeyboardOpened(view, true);
                }
                if (ViewKt.getKeyboardOpened(view) && ViewKt.getVisibleHeight(view) > 0 && i - ViewKt.getVisibleHeight(view) > ResExtKt.getDp(100)) {
                    Function1 closeKeyboardListener = ViewKt.getCloseKeyboardListener(view);
                    if (closeKeyboardListener != null) {
                    }
                    ViewKt.setKeyboardOpened(view, false);
                }
                ViewKt.setVisibleHeight(view, i);
            }
        });
        view.setTag(R.id.kbl_keyboard_listener, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Integer, Unit> getOpenKeyboardListener(View view) {
        return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(view.getTag(R.id.kbl_open_keyboard), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOpenKeyboardListener(View view, Function1<? super Integer, Unit> function1) {
        view.setTag(R.id.kbl_open_keyboard, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Integer, Unit> getCloseKeyboardListener(View view) {
        return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(view.getTag(R.id.kbl_close_keyboard), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCloseKeyboardListener(View view, Function1<? super Integer, Unit> function1) {
        view.setTag(R.id.kbl_close_keyboard, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOriginHeight(View view) {
        Object tag = view.getTag(R.id.kbl_origin_height);
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOriginHeight(View view, int i) {
        view.setTag(R.id.kbl_origin_height, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOriginVisibleHeight(View view) {
        Object tag = view.getTag(R.id.kbl_origin_visible_height);
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOriginVisibleHeight(View view, int i) {
        view.setTag(R.id.kbl_origin_visible_height, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getVisibleHeight(View view) {
        Object tag = view.getTag(R.id.kbl_visible_height);
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisibleHeight(View view, int i) {
        view.setTag(R.id.kbl_visible_height, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getKeyboardOpened(View view) {
        return Intrinsics.areEqual(view.getTag(R.id.kbl_keyboard_opened), (Object) true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setKeyboardOpened(View view, boolean z) {
        view.setTag(R.id.kbl_keyboard_opened, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int get_visibleHeight(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }
}
