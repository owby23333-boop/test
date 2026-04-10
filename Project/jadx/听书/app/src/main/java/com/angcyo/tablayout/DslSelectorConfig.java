package com.angcyo.tablayout;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslSelector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011Rz\u0010\u0012\u001ab\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRt\u0010 \u001a\\\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR|\u0010'\u001ad\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b((\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020!0\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR_\u0010,\u001aG\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001b0-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/angcyo/tablayout/DslSelectorConfig;", "", "()V", "dslMaxSelectLimit", "", "getDslMaxSelectLimit", "()I", "setDslMaxSelectLimit", "(I)V", "dslMinSelectLimit", "getDslMinSelectLimit", "setDslMinSelectLimit", "dslMultiMode", "", "getDslMultiMode", "()Z", "setDslMultiMode", "(Z)V", "onSelectIndexChange", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "fromIndex", "", "selectIndexList", "reselect", "fromUser", "", "getOnSelectIndexChange", "()Lkotlin/jvm/functions/Function4;", "setOnSelectIndexChange", "(Lkotlin/jvm/functions/Function4;)V", "onSelectItemView", "Landroid/view/View;", "itemView", "index", "select", "getOnSelectItemView", "setOnSelectItemView", "onSelectViewChange", "fromView", "selectViewList", "getOnSelectViewChange", "setOnSelectViewChange", "onStyleItemView", "Lkotlin/Function3;", "getOnStyleItemView", "()Lkotlin/jvm/functions/Function3;", "setOnStyleItemView", "(Lkotlin/jvm/functions/Function3;)V", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslSelectorConfig {
    private boolean dslMultiMode;
    private int dslMinSelectLimit = 1;
    private int dslMaxSelectLimit = Integer.MAX_VALUE;
    private Function3<? super View, ? super Integer, ? super Boolean, Unit> onStyleItemView = new Function3<View, Integer, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslSelectorConfig$onStyleItemView$1
        public final void invoke(View view, int i, boolean z) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Boolean bool) {
            invoke(view, num.intValue(), bool.booleanValue());
            return Unit.INSTANCE;
        }
    };
    private Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> onSelectViewChange = new Function4<View, List<? extends View>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslSelectorConfig$onSelectViewChange$1
        public final void invoke(View view, List<? extends View> list, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(list, "<anonymous parameter 1>");
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, List<? extends View> list, Boolean bool, Boolean bool2) {
            invoke(view, list, bool.booleanValue(), bool2.booleanValue());
            return Unit.INSTANCE;
        }
    };
    private Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> onSelectIndexChange = new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslSelectorConfig$onSelectIndexChange$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
            invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i, List<Integer> selectList, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(selectList, "selectList");
            LibExKt.logi("选择:[" + i + "]->" + selectList + " reselect:" + z + " fromUser:" + z2);
        }
    };
    private Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> onSelectItemView = new Function4<View, Integer, Boolean, Boolean, Boolean>() { // from class: com.angcyo.tablayout.DslSelectorConfig$onSelectItemView$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Boolean bool, Boolean bool2) {
            return invoke(view, num.intValue(), bool.booleanValue(), bool2.booleanValue());
        }

        public final Boolean invoke(View view, int i, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            return false;
        }
    };

    public final int getDslMinSelectLimit() {
        return this.dslMinSelectLimit;
    }

    public final void setDslMinSelectLimit(int i) {
        this.dslMinSelectLimit = i;
    }

    public final int getDslMaxSelectLimit() {
        return this.dslMaxSelectLimit;
    }

    public final void setDslMaxSelectLimit(int i) {
        this.dslMaxSelectLimit = i;
    }

    public final boolean getDslMultiMode() {
        return this.dslMultiMode;
    }

    public final void setDslMultiMode(boolean z) {
        this.dslMultiMode = z;
    }

    public final Function3<View, Integer, Boolean, Unit> getOnStyleItemView() {
        return this.onStyleItemView;
    }

    public final void setOnStyleItemView(Function3<? super View, ? super Integer, ? super Boolean, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.onStyleItemView = function3;
    }

    public final Function4<View, List<? extends View>, Boolean, Boolean, Unit> getOnSelectViewChange() {
        return this.onSelectViewChange;
    }

    public final void setOnSelectViewChange(Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.onSelectViewChange = function4;
    }

    public final Function4<Integer, List<Integer>, Boolean, Boolean, Unit> getOnSelectIndexChange() {
        return this.onSelectIndexChange;
    }

    public final void setOnSelectIndexChange(Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.onSelectIndexChange = function4;
    }

    public final Function4<View, Integer, Boolean, Boolean, Boolean> getOnSelectItemView() {
        return this.onSelectItemView;
    }

    public final void setOnSelectItemView(Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.onSelectItemView = function4;
    }
}
