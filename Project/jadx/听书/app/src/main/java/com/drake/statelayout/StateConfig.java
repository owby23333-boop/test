package com.drake.statelayout;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0019\u001a\u00020\u001c2\u001f\u00108\u001a\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dH\u0007J)\u0010\"\u001a\u00020\u001c2\u001f\u00108\u001a\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dH\u0007J)\u0010%\u001a\u00020\u001c2\u001f\u00108\u001a\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dH\u0007J)\u0010(\u001a\u00020\u001c2\u001f\u00108\u001a\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dH\u0007J\u0016\u00109\u001a\u00020\u001c2\f\b\u0001\u0010:\u001a\u00020,\"\u00020\u000bH\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R5\u0010\u0019\u001a\u001d\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a¢\u0006\u0002\b\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R5\u0010\"\u001a\u001d\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a¢\u0006\u0002\b\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R5\u0010%\u001a\u001d\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a¢\u0006\u0002\b\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R5\u0010(\u001a\u001d\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a¢\u0006\u0002\b\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/drake/statelayout/StateConfig;", "", "()V", "clickThrottle", "", "getClickThrottle$annotations", "getClickThrottle", "()J", "setClickThrottle", "(J)V", "emptyLayout", "", "getEmptyLayout$annotations", "getEmptyLayout", "()I", "setEmptyLayout", "(I)V", "errorLayout", "getErrorLayout$annotations", "getErrorLayout", "setErrorLayout", "loadingLayout", "getLoadingLayout$annotations", "getLoadingLayout", "setLoadingLayout", "onContent", "Lkotlin/Function2;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getOnContent$statelayout_release", "()Lkotlin/jvm/functions/Function2;", "setOnContent$statelayout_release", "(Lkotlin/jvm/functions/Function2;)V", "onEmpty", "getOnEmpty$statelayout_release", "setOnEmpty$statelayout_release", "onError", "getOnError$statelayout_release", "setOnError$statelayout_release", "onLoading", "getOnLoading$statelayout_release", "setOnLoading$statelayout_release", "retryIds", "", "getRetryIds$statelayout_release", "()[I", "setRetryIds$statelayout_release", "([I)V", "stateChangedHandler", "Lcom/drake/statelayout/StateChangedHandler;", "getStateChangedHandler$annotations", "getStateChangedHandler", "()Lcom/drake/statelayout/StateChangedHandler;", "setStateChangedHandler", "(Lcom/drake/statelayout/StateChangedHandler;)V", "block", "setRetryIds", "ids", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StateConfig {
    private static Function2<? super View, Object, Unit> onContent;
    private static Function2<? super View, Object, Unit> onEmpty;
    private static Function2<? super View, Object, Unit> onError;
    private static Function2<? super View, Object, Unit> onLoading;
    private static int[] retryIds;
    public static final StateConfig INSTANCE = new StateConfig();
    private static int errorLayout = -1;
    private static int emptyLayout = -1;
    private static int loadingLayout = -1;
    private static StateChangedHandler stateChangedHandler = StateChangedHandler.INSTANCE;
    private static long clickThrottle = 500;

    @JvmStatic
    public static /* synthetic */ void getClickThrottle$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEmptyLayout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getErrorLayout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLoadingLayout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getStateChangedHandler$annotations() {
    }

    private StateConfig() {
    }

    public final int[] getRetryIds$statelayout_release() {
        return retryIds;
    }

    public final void setRetryIds$statelayout_release(int[] iArr) {
        retryIds = iArr;
    }

    public final Function2<View, Object, Unit> getOnEmpty$statelayout_release() {
        return onEmpty;
    }

    public final void setOnEmpty$statelayout_release(Function2<? super View, Object, Unit> function2) {
        onEmpty = function2;
    }

    public final Function2<View, Object, Unit> getOnError$statelayout_release() {
        return onError;
    }

    public final void setOnError$statelayout_release(Function2<? super View, Object, Unit> function2) {
        onError = function2;
    }

    public final Function2<View, Object, Unit> getOnLoading$statelayout_release() {
        return onLoading;
    }

    public final void setOnLoading$statelayout_release(Function2<? super View, Object, Unit> function2) {
        onLoading = function2;
    }

    public final Function2<View, Object, Unit> getOnContent$statelayout_release() {
        return onContent;
    }

    public final void setOnContent$statelayout_release(Function2<? super View, Object, Unit> function2) {
        onContent = function2;
    }

    public static final int getErrorLayout() {
        return errorLayout;
    }

    public static final void setErrorLayout(int i) {
        errorLayout = i;
    }

    public static final int getEmptyLayout() {
        return emptyLayout;
    }

    public static final void setEmptyLayout(int i) {
        emptyLayout = i;
    }

    public static final int getLoadingLayout() {
        return loadingLayout;
    }

    public static final void setLoadingLayout(int i) {
        loadingLayout = i;
    }

    public static final StateChangedHandler getStateChangedHandler() {
        return stateChangedHandler;
    }

    public static final void setStateChangedHandler(StateChangedHandler stateChangedHandler2) {
        Intrinsics.checkNotNullParameter(stateChangedHandler2, "<set-?>");
        stateChangedHandler = stateChangedHandler2;
    }

    public static final long getClickThrottle() {
        return clickThrottle;
    }

    public static final void setClickThrottle(long j) {
        clickThrottle = j;
    }

    @JvmStatic
    public static final void onEmpty(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onEmpty = block;
    }

    @JvmStatic
    public static final void onError(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onError = block;
    }

    @JvmStatic
    public static final void onContent(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onContent = block;
    }

    @JvmStatic
    public static final void onLoading(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onLoading = block;
    }

    @JvmStatic
    public static final void setRetryIds(int... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        retryIds = ids;
    }
}
