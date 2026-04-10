package com.drake.statelayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010G\u001a\u00020#2\u0006\u0010@\u001a\u00020?2\b\u0010'\u001a\u0004\u0018\u00010$H\u0002J6\u0010!\u001a\u00020\u00002.\u0010H\u001a*\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b)J6\u0010,\u001a\u00020\u00002.\u0010H\u001a*\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b)J6\u0010.\u001a\u00020\u00002.\u0010H\u001a*\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b)J\b\u0010I\u001a\u00020(H\u0014J6\u00100\u001a\u00020\u00002.\u0010H\u001a*\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b)J6\u00102\u001a\u00020\u00002.\u0010H\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0\"¢\u0006\u0002\b)J\u0006\u0010J\u001a\u00020(J\u0012\u0010K\u001a\u00020(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$J\u0010\u0010L\u001a\u00020(2\u0006\u0010@\u001a\u00020?H\u0002J\u0016\u0010M\u001a\u00020(2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020(0NH\u0002J\u000e\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020#J\u0014\u0010Q\u001a\u00020\u00002\f\b\u0001\u0010R\u001a\u000204\"\u00020\u0007J\u0012\u0010S\u001a\u00020(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$J\u0012\u0010T\u001a\u00020(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$J\u0012\u0010U\u001a\u00020(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$J&\u0010V\u001a\u00020(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010W\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u0019J\u001c\u0010X\u001a\u00020(2\u0006\u0010@\u001a\u00020?2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010F\u001a\u00020\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R@\u0010!\u001a,\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\"¢\u0006\u0002\b)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R@\u0010,\u001a,\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\"¢\u0006\u0002\b)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R@\u0010.\u001a,\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\"¢\u0006\u0002\b)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R@\u00100\u001a,\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\"¢\u0006\u0002\b)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R8\u00102\u001a,\u0012\u0004\u0012\u00020\u0000\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\"¢\u0006\u0002\b)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\u0004\u0018\u0001048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/drake/statelayout/StateLayout;", "Landroid/widget/FrameLayout;", d.R, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickThrottle", "", "getClickThrottle", "()J", "setClickThrottle", "(J)V", "value", "emptyLayout", "getEmptyLayout", "()I", "setEmptyLayout", "(I)V", "errorLayout", "getErrorLayout", "setErrorLayout", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "onContent", "Lkotlin/Function2;", "Landroid/view/View;", "", "Lkotlin/ParameterName;", "name", "tag", "", "Lkotlin/ExtensionFunctionType;", "getOnContent", "()Lkotlin/jvm/functions/Function2;", "onEmpty", "getOnEmpty", "onError", "getOnError", "onLoading", "getOnLoading", "onRefresh", "retryIds", "", "getRetryIds", "()[I", "stateChanged", "stateChangedHandler", "Lcom/drake/statelayout/StateChangedHandler;", "getStateChangedHandler", "()Lcom/drake/statelayout/StateChangedHandler;", "setStateChangedHandler", "(Lcom/drake/statelayout/StateChangedHandler;)V", "<set-?>", "Lcom/drake/statelayout/Status;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/drake/statelayout/Status;", "statusMap", "Landroid/util/ArrayMap;", "Lcom/drake/statelayout/StatusInfo;", "trigger", "getStatusView", "block", "onFinishInflate", "refresh", "refreshing", "removeStatus", "runMain", "Lkotlin/Function0;", "setContent", "view", "setRetryIds", "ids", "showContent", "showEmpty", "showError", "showLoading", NotificationCompat.GROUP_KEY_SILENT, "showStatus", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StateLayout extends FrameLayout {
    private long clickThrottle;
    private int emptyLayout;
    private int errorLayout;
    private boolean loaded;
    private int loadingLayout;
    private Function2<? super View, Object, Unit> onContent;
    private Function2<? super View, Object, Unit> onEmpty;
    private Function2<? super View, Object, Unit> onError;
    private Function2<? super View, Object, Unit> onLoading;
    private Function2<? super StateLayout, Object, Unit> onRefresh;
    private int[] retryIds;
    private boolean stateChanged;
    private StateChangedHandler stateChangedHandler;
    private Status status;
    private final ArrayMap<Status, StatusInfo> statusMap;
    private boolean trigger;

    /* JADX INFO: compiled from: StateLayout.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.EMPTY.ordinal()] = 1;
            iArr[Status.ERROR.ordinal()] = 2;
            iArr[Status.LOADING.ordinal()] = 3;
            iArr[Status.CONTENT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StateLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.statusMap = new ArrayMap<>();
        this.status = Status.CONTENT;
        this.clickThrottle = StateConfig.getClickThrottle();
        this.stateChangedHandler = StateConfig.getStateChangedHandler();
        this.errorLayout = -1;
        this.emptyLayout = -1;
        this.loadingLayout = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StateLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.StateLayout)");
        try {
            setEmptyLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_empty_layout, -1));
            setErrorLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_error_layout, -1));
            setLoadingLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_loading_layout, -1));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] getRetryIds() {
        int[] iArr = this.retryIds;
        return iArr == null ? StateConfig.INSTANCE.getRetryIds$statelayout_release() : iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnEmpty() {
        Function2 function2 = this.onEmpty;
        return function2 == null ? StateConfig.INSTANCE.getOnEmpty$statelayout_release() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnError() {
        Function2 function2 = this.onError;
        return function2 == null ? StateConfig.INSTANCE.getOnError$statelayout_release() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnContent() {
        Function2 function2 = this.onContent;
        return function2 == null ? StateConfig.INSTANCE.getOnContent$statelayout_release() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnLoading() {
        Function2 function2 = this.onLoading;
        return function2 == null ? StateConfig.INSTANCE.getOnLoading$statelayout_release() : function2;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final void setLoaded(boolean z) {
        this.loaded = z;
    }

    public final long getClickThrottle() {
        return this.clickThrottle;
    }

    public final void setClickThrottle(long j) {
        this.clickThrottle = j;
    }

    public final StateChangedHandler getStateChangedHandler() {
        return this.stateChangedHandler;
    }

    public final void setStateChangedHandler(StateChangedHandler stateChangedHandler) {
        Intrinsics.checkNotNullParameter(stateChangedHandler, "<set-?>");
        this.stateChangedHandler = stateChangedHandler;
    }

    public final int getErrorLayout() {
        int i = this.errorLayout;
        return i == -1 ? StateConfig.getErrorLayout() : i;
    }

    public final void setErrorLayout(int i) {
        if (this.errorLayout != i) {
            removeStatus(Status.ERROR);
            this.errorLayout = i;
        }
    }

    public final int getEmptyLayout() {
        int i = this.emptyLayout;
        return i == -1 ? StateConfig.getEmptyLayout() : i;
    }

    public final void setEmptyLayout(int i) {
        if (this.emptyLayout != i) {
            removeStatus(Status.EMPTY);
            this.emptyLayout = i;
        }
    }

    public final int getLoadingLayout() {
        int i = this.loadingLayout;
        return i == -1 ? StateConfig.getLoadingLayout() : i;
    }

    public final void setLoadingLayout(int i) {
        if (this.loadingLayout != i) {
            removeStatus(Status.LOADING);
            this.loadingLayout = i;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1 || getChildCount() == 0) {
            throw new UnsupportedOperationException("StateLayout only have one child view");
        }
        if (this.statusMap.size() == 0) {
            View view = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            setContent(view);
        }
    }

    public final StateLayout onLoading(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onLoading = block;
        return this;
    }

    public final StateLayout onEmpty(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onEmpty = block;
        return this;
    }

    public final StateLayout onError(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onError = block;
        return this;
    }

    public final StateLayout onRefresh(Function2<? super StateLayout, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onRefresh = block;
        return this;
    }

    public final StateLayout onContent(Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onContent = block;
        return this;
    }

    public final void refresh() {
        showLoading$default(this, null, true, false, 5, null);
    }

    public static /* synthetic */ void refreshing$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.refreshing(obj);
    }

    public final void refreshing(Object tag) {
        if (this.loaded) {
            refresh();
        } else {
            showLoading$default(this, tag, false, false, 6, null);
        }
    }

    public static /* synthetic */ void showLoading$default(StateLayout stateLayout, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        stateLayout.showLoading(obj, z, z2);
    }

    public final void showLoading(Object tag, boolean silent, boolean refresh) {
        Function2<? super StateLayout, Object, Unit> function2;
        if (!silent) {
            showStatus(Status.LOADING, tag);
        }
        if (!refresh || (function2 = this.onRefresh) == null) {
            return;
        }
        function2.invoke(this, tag);
    }

    public static /* synthetic */ void showEmpty$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showEmpty(obj);
    }

    public final void showEmpty(Object tag) {
        showStatus(Status.EMPTY, tag);
    }

    public static /* synthetic */ void showError$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showError(obj);
    }

    public final void showError(Object tag) {
        showStatus(Status.ERROR, tag);
    }

    public static /* synthetic */ void showContent$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showContent(obj);
    }

    public final void showContent(Object tag) {
        if (this.trigger && this.stateChanged) {
            return;
        }
        showStatus(Status.CONTENT, tag);
        this.loaded = true;
    }

    public final StateLayout setRetryIds(int... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.retryIds = ids;
        return this;
    }

    public final boolean trigger() {
        boolean z = !this.trigger;
        this.trigger = z;
        if (!z) {
            this.stateChanged = false;
        }
        return z;
    }

    static /* synthetic */ void showStatus$default(StateLayout stateLayout, Status status, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        stateLayout.showStatus(status, obj);
    }

    private final void showStatus(final Status status, final Object tag) {
        if (this.trigger) {
            this.stateChanged = true;
        }
        Status status2 = this.status;
        if (status2 == status) {
            StatusInfo statusInfo = this.statusMap.get(status2);
            if (Intrinsics.areEqual(statusInfo != null ? statusInfo.getTag() : null, tag)) {
                return;
            }
        }
        runMain(new Function0<Unit>() { // from class: com.drake.statelayout.StateLayout.showStatus.1

            /* JADX INFO: renamed from: com.drake.statelayout.StateLayout$showStatus$1$WhenMappings */
            /* JADX INFO: compiled from: StateLayout.kt */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Status.values().length];
                    iArr[Status.EMPTY.ordinal()] = 1;
                    iArr[Status.ERROR.ordinal()] = 2;
                    iArr[Status.LOADING.ordinal()] = 3;
                    iArr[Status.CONTENT.ordinal()] = 4;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i;
                int[] retryIds;
                Function2 onContent;
                try {
                    View statusView = StateLayout.this.getStatusView(status, tag);
                    ArrayMap arrayMap = StateLayout.this.statusMap;
                    Status status3 = status;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator it = arrayMap.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if ((entry.getKey() != status3 ? 1 : 0) != 0) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    StateLayout stateLayout = StateLayout.this;
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        StatusInfo statusInfo2 = (StatusInfo) entry2.getValue();
                        if (entry2.getKey() == stateLayout.getStatus()) {
                            StateChangedHandler stateChangedHandler = stateLayout.getStateChangedHandler();
                            View view = statusInfo2.getView();
                            Object key = entry2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "it.key");
                            stateChangedHandler.onRemove(stateLayout, view, (Status) key, statusInfo2.getTag());
                        }
                    }
                    StateLayout.this.getStateChangedHandler().onAdd(StateLayout.this, statusView, status, tag);
                    if ((status == Status.EMPTY || status == Status.ERROR) && (retryIds = StateLayout.this.getRetryIds()) != null) {
                        final StateLayout stateLayout2 = StateLayout.this;
                        int length = retryIds.length;
                        while (i < length) {
                            View viewFindViewById = statusView.findViewById(retryIds[i]);
                            if (viewFindViewById != null) {
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(it)");
                                ThrottleClickKt.throttleClick$default(viewFindViewById, stateLayout2.getClickThrottle(), null, new Function1<View, Unit>() { // from class: com.drake.statelayout.StateLayout$showStatus$1$3$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                                        invoke2(view2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(View throttleClick) {
                                        Intrinsics.checkNotNullParameter(throttleClick, "$this$throttleClick");
                                        StateLayout stateLayout3 = stateLayout2;
                                        StatusInfo statusInfo3 = (StatusInfo) stateLayout3.statusMap.get(Status.LOADING);
                                        StateLayout.showLoading$default(stateLayout3, statusInfo3 != null ? statusInfo3.getTag() : null, false, false, 6, null);
                                    }
                                }, 2, null);
                            }
                            i++;
                        }
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                    if (i2 == 1) {
                        Function2 onEmpty = StateLayout.this.getOnEmpty();
                        if (onEmpty != null) {
                            onEmpty.invoke(statusView, tag);
                        }
                    } else if (i2 == 2) {
                        Function2 onError = StateLayout.this.getOnError();
                        if (onError != null) {
                            onError.invoke(statusView, tag);
                        }
                    } else if (i2 == 3) {
                        Function2 onLoading = StateLayout.this.getOnLoading();
                        if (onLoading != null) {
                            onLoading.invoke(statusView, tag);
                        }
                    } else if (i2 == 4 && (onContent = StateLayout.this.getOnContent()) != null) {
                        onContent.invoke(statusView, tag);
                    }
                    StateLayout.this.status = status;
                } catch (Exception e) {
                    Log.e(StateLayout.this.getClass().getSimpleName(), "", e);
                }
            }
        });
    }

    private final void removeStatus(Status status) {
        this.statusMap.remove(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getStatusView(Status status, Object tag) throws NullPointerException {
        int emptyLayout;
        StatusInfo statusInfo = this.statusMap.get(status);
        if (statusInfo != null) {
            statusInfo.setTag(tag);
            return statusInfo.getView();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            emptyLayout = getEmptyLayout();
        } else if (i == 2) {
            emptyLayout = getErrorLayout();
        } else if (i == 3) {
            emptyLayout = getLoadingLayout();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            emptyLayout = -1;
        }
        if (emptyLayout == -1) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i2 == 1) {
                throw new Resources.NotFoundException("No StateLayout emptyLayout is set");
            }
            if (i2 == 2) {
                throw new Resources.NotFoundException("No StateLayout errorLayout is set");
            }
            if (i2 == 3) {
                throw new Resources.NotFoundException("No StateLayout loadingLayout is set");
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            throw new Resources.NotFoundException("No StateLayout contentView is set");
        }
        View view = LayoutInflater.from(getContext()).inflate(emptyLayout, (ViewGroup) this, false);
        ArrayMap<Status, StatusInfo> arrayMap = this.statusMap;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        arrayMap.put(status, new StatusInfo(view, tag));
        return view;
    }

    public final void setContent(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.statusMap.put(Status.CONTENT, new StatusInfo(view, null));
    }

    private final void runMain(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.drake.statelayout.StateLayout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    StateLayout.m487runMain$lambda7(block);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runMain$lambda-7, reason: not valid java name */
    public static final void m487runMain$lambda7(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }
}
