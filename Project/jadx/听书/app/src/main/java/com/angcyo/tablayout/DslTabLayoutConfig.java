package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.angcyo.tablayout.DslTabLayout;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslTabLayoutConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u00142\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\fH\u0016J*\u0010~\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u00142\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\fH\u0016J,\u0010\u007f\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0080\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020\f2\u0006\u0010}\u001a\u00020\fH\u0016J-\u0010\u0082\u0001\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010 2\u0007\u0010\u0083\u0001\u001a\u00020\f2\u0007\u0010\u0084\u0001\u001a\u00020\f2\u0006\u0010}\u001a\u00020\fH\u0016J\u001c\u0010\u0085\u0001\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010\u0087\u0001\u001a\u00020y2\u0007\u0010\u0088\u0001\u001a\u00020 2\u0007\u0010\u0089\u0001\u001a\u00020,H\u0016J!\u0010\u008a\u0001\u001a\u00020y2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J!\u0010\u008f\u0001\u001a\u00020y2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J%\u0010\u0090\u0001\u001a\u00020y2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0092\u0001\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0093\u0001\u001a\u00020y2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020,H\u0016R_\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRT\u0010\u001b\u001a<\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u001c0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aRL\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u00010 0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aRT\u0010#\u001a<\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001c0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u00105\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001a\u00108\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001a\u0010;\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010/\"\u0004\b=\u00101R\u001a\u0010>\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010/\"\u0004\b@\u00101R\u001a\u0010A\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010/\"\u0004\bC\u00101R$\u0010D\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R\u001a\u0010G\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010(\"\u0004\bO\u0010*R\u001c\u0010P\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010*R\u001e\u0010S\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\u001a\u0010`\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010(\"\u0004\bb\u0010*R\u001a\u0010c\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010Z\"\u0004\be\u0010\\R\u001a\u0010f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010Z\"\u0004\bh\u0010\\R\u001e\u0010i\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010(\"\u0004\bk\u0010*R\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010r\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010o\"\u0004\bt\u0010qR\u001a\u0010u\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010/\"\u0004\bw\u00101¨\u0006\u0094\u0001"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayoutConfig;", "Lcom/angcyo/tablayout/DslSelectorConfig;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "(Lcom/angcyo/tablayout/DslTabLayout;)V", "onGetGradientIndicatorColor", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "fromIndex", "toIndex", "", "positionOffset", "getOnGetGradientIndicatorColor", "()Lkotlin/jvm/functions/Function3;", "setOnGetGradientIndicatorColor", "(Lkotlin/jvm/functions/Function3;)V", "onGetIcoStyleView", "Lkotlin/Function2;", "Landroid/view/View;", "itemView", "index", "getOnGetIcoStyleView", "()Lkotlin/jvm/functions/Function2;", "setOnGetIcoStyleView", "(Lkotlin/jvm/functions/Function2;)V", "onGetIcoStyleViewList", "", "getOnGetIcoStyleViewList", "setOnGetIcoStyleViewList", "onGetTextStyleView", "Landroid/widget/TextView;", "getOnGetTextStyleView", "setOnGetTextStyleView", "onGetTextStyleViewList", "getOnGetTextStyleViewList", "setOnGetTextStyleViewList", "tabDeselectColor", "getTabDeselectColor", "()I", "setTabDeselectColor", "(I)V", "value", "", "tabEnableGradientColor", "getTabEnableGradientColor", "()Z", "setTabEnableGradientColor", "(Z)V", "tabEnableGradientScale", "getTabEnableGradientScale", "setTabEnableGradientScale", "tabEnableGradientTextSize", "getTabEnableGradientTextSize", "setTabEnableGradientTextSize", "tabEnableIcoColor", "getTabEnableIcoColor", "setTabEnableIcoColor", "tabEnableIcoGradientColor", "getTabEnableIcoGradientColor", "setTabEnableIcoGradientColor", "tabEnableIndicatorGradientColor", "getTabEnableIndicatorGradientColor", "setTabEnableIndicatorGradientColor", "tabEnableTextBold", "getTabEnableTextBold", "setTabEnableTextBold", "tabEnableTextColor", "getTabEnableTextColor", "setTabEnableTextColor", "tabGradientCallback", "Lcom/angcyo/tablayout/TabGradientCallback;", "getTabGradientCallback", "()Lcom/angcyo/tablayout/TabGradientCallback;", "setTabGradientCallback", "(Lcom/angcyo/tablayout/TabGradientCallback;)V", "tabIcoDeselectColor", "getTabIcoDeselectColor", "setTabIcoDeselectColor", "tabIcoSelectColor", "getTabIcoSelectColor", "setTabIcoSelectColor", "tabIconViewId", "getTabIconViewId", "setTabIconViewId", "getTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "tabMaxScale", "getTabMaxScale", "()F", "setTabMaxScale", "(F)V", "tabMinScale", "getTabMinScale", "setTabMinScale", "tabSelectColor", "getTabSelectColor", "setTabSelectColor", "tabTextMaxSize", "getTabTextMaxSize", "setTabTextMaxSize", "tabTextMinSize", "getTabTextMinSize", "setTabTextMinSize", "tabTextViewId", "getTabTextViewId", "setTabTextViewId", "tabTypefaceBold", "Landroid/graphics/Typeface;", "getTabTypefaceBold", "()Landroid/graphics/Typeface;", "setTabTypefaceBold", "(Landroid/graphics/Typeface;)V", "tabTypefaceNormal", "getTabTypefaceNormal", "setTabTypefaceNormal", "tabUseTypefaceBold", "getTabUseTypefaceBold", "setTabUseTypefaceBold", "_gradientColor", "", "view", "startColor", "endColor", "percent", "_gradientIcoColor", "_gradientScale", "startScale", "endScale", "_gradientTextSize", "startTextSize", "endTextSize", "_updateIcoColor", "color", "_updateTextStyle", "textView", "select", "initAttribute", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "onPageIndexScrolled", "onPageViewScrolled", "fromView", "toView", "onUpdateItemStyle", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslTabLayoutConfig extends DslSelectorConfig {
    private Function3<? super Integer, ? super Integer, ? super Float, Integer> onGetGradientIndicatorColor;
    private Function2<? super View, ? super Integer, ? extends View> onGetIcoStyleView;
    private Function2<? super View, ? super Integer, ? extends List<? extends View>> onGetIcoStyleViewList;
    private Function2<? super View, ? super Integer, ? extends TextView> onGetTextStyleView;
    private Function2<? super View, ? super Integer, ? extends List<? extends TextView>> onGetTextStyleViewList;
    private int tabDeselectColor;
    private boolean tabEnableGradientColor;
    private boolean tabEnableGradientScale;
    private boolean tabEnableGradientTextSize;
    private boolean tabEnableIcoColor;
    private boolean tabEnableIcoGradientColor;
    private boolean tabEnableIndicatorGradientColor;
    private boolean tabEnableTextBold;
    private boolean tabEnableTextColor;
    private TabGradientCallback tabGradientCallback;
    private int tabIcoDeselectColor;
    private int tabIcoSelectColor;
    private int tabIconViewId;
    private final DslTabLayout tabLayout;
    private float tabMaxScale;
    private float tabMinScale;
    private int tabSelectColor;
    private float tabTextMaxSize;
    private float tabTextMinSize;
    private int tabTextViewId;
    private Typeface tabTypefaceBold;
    private Typeface tabTypefaceNormal;
    private boolean tabUseTypefaceBold;

    public void onPageIndexScrolled(int fromIndex, int toIndex, float positionOffset) {
    }

    public DslTabLayoutConfig(DslTabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        this.tabEnableTextColor = true;
        this.tabSelectColor = -1;
        this.tabDeselectColor = Color.parseColor("#999999");
        this.tabEnableIcoColor = true;
        this.tabIcoSelectColor = -2;
        this.tabIcoDeselectColor = -2;
        this.tabMinScale = 0.8f;
        this.tabMaxScale = 1.2f;
        this.tabEnableGradientTextSize = true;
        this.tabTextMinSize = -1.0f;
        this.tabTextMaxSize = -1.0f;
        this.tabGradientCallback = new TabGradientCallback();
        this.tabTextViewId = -1;
        this.tabIconViewId = -1;
        this.onGetTextStyleView = new Function2<View, Integer, TextView>() { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetTextStyleView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ TextView invoke(View view, Integer num) {
                return invoke(view, num.intValue());
            }

            public final TextView invoke(View itemView, int i) {
                View viewFindViewById;
                View childOrNull;
                View viewFindViewById2;
                View childOrNull2;
                View viewFindViewById3;
                View childOrNull3;
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                if (this.this$0.getTabTextViewId() == -1) {
                    View view = itemView instanceof TextView ? (TextView) itemView : null;
                    if (this.this$0.getTabLayout().getTabIndicator().getIndicatorContentIndex() != -1 && (childOrNull3 = LibExKt.getChildOrNull(itemView, this.this$0.getTabLayout().getTabIndicator().getIndicatorContentIndex())) != null && (childOrNull3 instanceof TextView)) {
                        view = childOrNull3;
                    }
                    if (this.this$0.getTabLayout().getTabIndicator().getIndicatorContentId() != -1 && (viewFindViewById3 = itemView.findViewById(this.this$0.getTabLayout().getTabIndicator().getIndicatorContentId())) != null && (viewFindViewById3 instanceof TextView)) {
                        view = viewFindViewById3;
                    }
                    ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
                    if (layoutParams instanceof DslTabLayout.LayoutParams) {
                        DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
                        if (layoutParams2.getIndicatorContentIndex() != -1 && (itemView instanceof ViewGroup) && (childOrNull2 = LibExKt.getChildOrNull(itemView, layoutParams2.getIndicatorContentIndex())) != null && (childOrNull2 instanceof TextView)) {
                            view = childOrNull2;
                        }
                        if (layoutParams2.getIndicatorContentId() != -1 && (viewFindViewById2 = itemView.findViewById(layoutParams2.getIndicatorContentId())) != null && (viewFindViewById2 instanceof TextView)) {
                            view = viewFindViewById2;
                        }
                        if (layoutParams2.getContentTextViewIndex() != -1 && (itemView instanceof ViewGroup) && (childOrNull = LibExKt.getChildOrNull(itemView, layoutParams2.getContentTextViewIndex())) != null && (childOrNull instanceof TextView)) {
                            view = childOrNull;
                        }
                        if (layoutParams2.getContentTextViewId() != -1 && (viewFindViewById = itemView.findViewById(layoutParams2.getContentTextViewId())) != null && (viewFindViewById instanceof TextView)) {
                            view = viewFindViewById;
                        }
                    }
                    return (TextView) view;
                }
                return (TextView) itemView.findViewById(this.this$0.getTabTextViewId());
            }
        };
        this.onGetTextStyleViewList = new Function2() { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetTextStyleViewList$1
            public final Void invoke(View view, int i) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                return null;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((View) obj, ((Number) obj2).intValue());
            }
        };
        this.onGetIcoStyleView = new Function2<View, Integer, View>() { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetIcoStyleView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ View invoke(View view, Integer num) {
                return invoke(view, num.intValue());
            }

            public final View invoke(View itemView, int i) {
                View childOrNull;
                View viewFindViewById;
                View viewFindViewById2;
                View viewFindViewById3;
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                if (this.this$0.getTabIconViewId() == -1) {
                    if (this.this$0.getTabLayout().getTabIndicator().getIndicatorContentIndex() == -1 || (childOrNull = LibExKt.getChildOrNull(itemView, this.this$0.getTabLayout().getTabIndicator().getIndicatorContentIndex())) == null) {
                        childOrNull = itemView;
                    }
                    if (this.this$0.getTabLayout().getTabIndicator().getIndicatorContentId() != -1 && (viewFindViewById3 = itemView.findViewById(this.this$0.getTabLayout().getTabIndicator().getIndicatorContentId())) != null) {
                        childOrNull = viewFindViewById3;
                    }
                    ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
                    if (!(layoutParams instanceof DslTabLayout.LayoutParams)) {
                        return childOrNull;
                    }
                    DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
                    if (layoutParams2.getIndicatorContentIndex() != -1 && (itemView instanceof ViewGroup)) {
                        childOrNull = LibExKt.getChildOrNull(itemView, layoutParams2.getIndicatorContentIndex());
                    }
                    if (layoutParams2.getIndicatorContentId() != -1 && (viewFindViewById2 = itemView.findViewById(layoutParams2.getIndicatorContentId())) != null) {
                        childOrNull = viewFindViewById2;
                    }
                    if (layoutParams2.getContentIconViewIndex() != -1 && (itemView instanceof ViewGroup)) {
                        childOrNull = LibExKt.getChildOrNull(itemView, layoutParams2.getContentIconViewIndex());
                    }
                    return (layoutParams2.getContentIconViewId() == -1 || (viewFindViewById = itemView.findViewById(layoutParams2.getContentIconViewId())) == null) ? childOrNull : viewFindViewById;
                }
                return itemView.findViewById(this.this$0.getTabIconViewId());
            }
        };
        this.onGetIcoStyleViewList = new Function2() { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetIcoStyleViewList$1
            public final Void invoke(View view, int i) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                return null;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((View) obj, ((Number) obj2).intValue());
            }
        };
        this.onGetGradientIndicatorColor = new Function3<Integer, Integer, Float, Integer>() { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetGradientIndicatorColor$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2, Float f) {
                return invoke(num.intValue(), num2.intValue(), f.floatValue());
            }

            public final Integer invoke(int i, int i2, float f) {
                return Integer.valueOf(this.this$0.getTabLayout().getTabIndicator().getIndicatorColor());
            }
        };
        setOnStyleItemView(new Function3<View, Integer, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayoutConfig.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Boolean bool) {
                invoke(view, num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View itemView, int i, boolean z) {
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                DslTabLayoutConfig.this.onUpdateItemStyle(itemView, i, z);
            }
        });
        setOnSelectIndexChange(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayoutConfig.2
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, List<Integer> selectIndexList, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(selectIndexList, "selectIndexList");
                int iIntValue = ((Number) CollectionsKt.last((List) selectIndexList)).intValue();
                ViewPagerDelegate viewPagerDelegate = DslTabLayoutConfig.this.getTabLayout().get_viewPagerDelegate();
                if (viewPagerDelegate != null) {
                    viewPagerDelegate.onSetCurrentItem(i, iIntValue, z, z2);
                }
            }
        });
    }

    public final DslTabLayout getTabLayout() {
        return this.tabLayout;
    }

    public final boolean getTabEnableTextColor() {
        return this.tabEnableTextColor;
    }

    public final void setTabEnableTextColor(boolean z) {
        this.tabEnableTextColor = z;
        if (z) {
            this.tabEnableIcoColor = true;
        }
    }

    public final boolean getTabEnableGradientColor() {
        return this.tabEnableGradientColor;
    }

    public final void setTabEnableGradientColor(boolean z) {
        this.tabEnableGradientColor = z;
        if (z) {
            this.tabEnableIcoGradientColor = true;
        }
    }

    public final boolean getTabEnableIndicatorGradientColor() {
        return this.tabEnableIndicatorGradientColor;
    }

    public final void setTabEnableIndicatorGradientColor(boolean z) {
        this.tabEnableIndicatorGradientColor = z;
    }

    public final int getTabSelectColor() {
        return this.tabSelectColor;
    }

    public final void setTabSelectColor(int i) {
        this.tabSelectColor = i;
    }

    public final int getTabDeselectColor() {
        return this.tabDeselectColor;
    }

    public final void setTabDeselectColor(int i) {
        this.tabDeselectColor = i;
    }

    public final boolean getTabEnableTextBold() {
        return this.tabEnableTextBold;
    }

    public final void setTabEnableTextBold(boolean z) {
        this.tabEnableTextBold = z;
    }

    public final boolean getTabUseTypefaceBold() {
        return this.tabUseTypefaceBold;
    }

    public final void setTabUseTypefaceBold(boolean z) {
        this.tabUseTypefaceBold = z;
    }

    public final Typeface getTabTypefaceBold() {
        return this.tabTypefaceBold;
    }

    public final void setTabTypefaceBold(Typeface typeface) {
        this.tabTypefaceBold = typeface;
    }

    public final Typeface getTabTypefaceNormal() {
        return this.tabTypefaceNormal;
    }

    public final void setTabTypefaceNormal(Typeface typeface) {
        this.tabTypefaceNormal = typeface;
    }

    public final boolean getTabEnableIcoColor() {
        return this.tabEnableIcoColor;
    }

    public final void setTabEnableIcoColor(boolean z) {
        this.tabEnableIcoColor = z;
    }

    public final boolean getTabEnableIcoGradientColor() {
        return this.tabEnableIcoGradientColor;
    }

    public final void setTabEnableIcoGradientColor(boolean z) {
        this.tabEnableIcoGradientColor = z;
    }

    public final void setTabIcoSelectColor(int i) {
        this.tabIcoSelectColor = i;
    }

    public final int getTabIcoSelectColor() {
        int i = this.tabIcoSelectColor;
        return i == -2 ? this.tabSelectColor : i;
    }

    public final void setTabIcoDeselectColor(int i) {
        this.tabIcoDeselectColor = i;
    }

    public final int getTabIcoDeselectColor() {
        int i = this.tabIcoDeselectColor;
        return i == -2 ? this.tabDeselectColor : i;
    }

    public final boolean getTabEnableGradientScale() {
        return this.tabEnableGradientScale;
    }

    public final void setTabEnableGradientScale(boolean z) {
        this.tabEnableGradientScale = z;
    }

    public final float getTabMinScale() {
        return this.tabMinScale;
    }

    public final void setTabMinScale(float f) {
        this.tabMinScale = f;
    }

    public final float getTabMaxScale() {
        return this.tabMaxScale;
    }

    public final void setTabMaxScale(float f) {
        this.tabMaxScale = f;
    }

    public final boolean getTabEnableGradientTextSize() {
        return this.tabEnableGradientTextSize;
    }

    public final void setTabEnableGradientTextSize(boolean z) {
        this.tabEnableGradientTextSize = z;
    }

    public final float getTabTextMinSize() {
        return this.tabTextMinSize;
    }

    public final void setTabTextMinSize(float f) {
        this.tabTextMinSize = f;
    }

    public final float getTabTextMaxSize() {
        return this.tabTextMaxSize;
    }

    public final void setTabTextMaxSize(float f) {
        this.tabTextMaxSize = f;
    }

    public final TabGradientCallback getTabGradientCallback() {
        return this.tabGradientCallback;
    }

    public final void setTabGradientCallback(TabGradientCallback tabGradientCallback) {
        Intrinsics.checkNotNullParameter(tabGradientCallback, "<set-?>");
        this.tabGradientCallback = tabGradientCallback;
    }

    public final int getTabTextViewId() {
        return this.tabTextViewId;
    }

    public final void setTabTextViewId(int i) {
        this.tabTextViewId = i;
    }

    public final int getTabIconViewId() {
        return this.tabIconViewId;
    }

    public final void setTabIconViewId(int i) {
        this.tabIconViewId = i;
    }

    public final Function2<View, Integer, TextView> getOnGetTextStyleView() {
        return this.onGetTextStyleView;
    }

    public final void setOnGetTextStyleView(Function2<? super View, ? super Integer, ? extends TextView> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onGetTextStyleView = function2;
    }

    public final Function2<View, Integer, List<TextView>> getOnGetTextStyleViewList() {
        return this.onGetTextStyleViewList;
    }

    public final void setOnGetTextStyleViewList(Function2<? super View, ? super Integer, ? extends List<? extends TextView>> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onGetTextStyleViewList = function2;
    }

    public final Function2<View, Integer, View> getOnGetIcoStyleView() {
        return this.onGetIcoStyleView;
    }

    public final void setOnGetIcoStyleView(Function2<? super View, ? super Integer, ? extends View> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onGetIcoStyleView = function2;
    }

    public final Function2<View, Integer, List<View>> getOnGetIcoStyleViewList() {
        return this.onGetIcoStyleViewList;
    }

    public final void setOnGetIcoStyleViewList(Function2<? super View, ? super Integer, ? extends List<? extends View>> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onGetIcoStyleViewList = function2;
    }

    public final Function3<Integer, Integer, Float, Integer> getOnGetGradientIndicatorColor() {
        return this.onGetGradientIndicatorColor;
    }

    public final void setOnGetGradientIndicatorColor(Function3<? super Integer, ? super Integer, ? super Float, Integer> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.onGetGradientIndicatorColor = function3;
    }

    public static /* synthetic */ void initAttribute$default(DslTabLayoutConfig dslTabLayoutConfig, Context context, AttributeSet attributeSet, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initAttribute");
        }
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        dslTabLayoutConfig.initAttribute(context, attributeSet);
    }

    public void initAttribute(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.tabSelectColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_select_color, this.tabSelectColor);
        this.tabDeselectColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_deselect_color, this.tabDeselectColor);
        this.tabIcoSelectColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_ico_select_color, -2);
        this.tabIcoDeselectColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_ico_deselect_color, -2);
        setTabEnableTextColor(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_text_color, this.tabEnableTextColor));
        this.tabEnableIndicatorGradientColor = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_indicator_gradient_color, this.tabEnableIndicatorGradientColor);
        setTabEnableGradientColor(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_gradient_color, this.tabEnableGradientColor));
        this.tabEnableIcoColor = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_ico_color, this.tabEnableIcoColor);
        this.tabEnableIcoGradientColor = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_ico_gradient_color, this.tabEnableIcoGradientColor);
        this.tabEnableTextBold = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_text_bold, this.tabEnableTextBold);
        this.tabUseTypefaceBold = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_use_typeface_bold, this.tabUseTypefaceBold);
        this.tabEnableGradientScale = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_gradient_scale, this.tabEnableGradientScale);
        this.tabMinScale = typedArrayObtainStyledAttributes.getFloat(R.styleable.DslTabLayout_tab_min_scale, this.tabMinScale);
        this.tabMaxScale = typedArrayObtainStyledAttributes.getFloat(R.styleable.DslTabLayout_tab_max_scale, this.tabMaxScale);
        this.tabEnableGradientTextSize = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_gradient_text_size, this.tabEnableGradientTextSize);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_text_min_size)) {
            this.tabTextMinSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_text_min_size, (int) this.tabTextMinSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_text_max_size)) {
            this.tabTextMaxSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_text_max_size, (int) this.tabTextMaxSize);
        }
        this.tabTextViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_tab_text_view_id, this.tabTextViewId);
        this.tabIconViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_tab_icon_view_id, this.tabIconViewId);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void onUpdateItemStyle(View itemView, int index, boolean select) {
        DslTabBorder tabBorder;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        TextView textViewInvoke = this.onGetTextStyleView.invoke(itemView, Integer.valueOf(index));
        if (textViewInvoke != null) {
            _updateTextStyle(textViewInvoke, select);
        }
        List<? extends TextView> listInvoke = this.onGetTextStyleViewList.invoke(itemView, Integer.valueOf(index));
        if (listInvoke != null) {
            for (TextView textView : listInvoke) {
                if (textView != null) {
                    _updateTextStyle(textView, select);
                }
            }
        }
        if (this.tabEnableIcoColor) {
            View viewInvoke = this.onGetIcoStyleView.invoke(itemView, Integer.valueOf(index));
            if (viewInvoke != null) {
                _updateIcoColor(viewInvoke, select ? getTabIcoSelectColor() : getTabIcoDeselectColor());
            }
            List<? extends View> listInvoke2 = this.onGetIcoStyleViewList.invoke(itemView, Integer.valueOf(index));
            if (listInvoke2 != null) {
                for (View view : listInvoke2) {
                    if (view != null) {
                        _updateIcoColor(view, select ? getTabIcoSelectColor() : getTabIcoDeselectColor());
                    }
                }
            }
        }
        if (this.tabEnableGradientScale) {
            itemView.setScaleX(select ? this.tabMaxScale : this.tabMinScale);
            itemView.setScaleY(select ? this.tabMaxScale : this.tabMinScale);
        }
        if (!this.tabLayout.getDrawBorder() || (tabBorder = this.tabLayout.getTabBorder()) == null) {
            return;
        }
        tabBorder.updateItemBackground(this.tabLayout, itemView, index, select);
    }

    public void onPageViewScrolled(View fromView, View toView, float positionOffset) {
        Intrinsics.checkNotNullParameter(toView, "toView");
        if (Intrinsics.areEqual(fromView, toView)) {
            return;
        }
        int currentIndex = this.tabLayout.getTabIndicator().getCurrentIndex();
        int i = this.tabLayout.getTabIndicator().get_targetIndex();
        if (this.tabEnableIndicatorGradientColor) {
            this.tabLayout.getTabIndicator().setIndicatorColor(LibExKt.evaluateColor(positionOffset, this.onGetGradientIndicatorColor.invoke(Integer.valueOf(currentIndex), Integer.valueOf(currentIndex), Float.valueOf(0.0f)).intValue(), this.onGetGradientIndicatorColor.invoke(Integer.valueOf(currentIndex), Integer.valueOf(i), Float.valueOf(positionOffset)).intValue()));
        }
        if (this.tabEnableGradientColor) {
            if (fromView != null) {
                _gradientColor(this.onGetTextStyleView.invoke(fromView, Integer.valueOf(currentIndex)), this.tabSelectColor, this.tabDeselectColor, positionOffset);
            }
            _gradientColor(this.onGetTextStyleView.invoke(toView, Integer.valueOf(i)), this.tabDeselectColor, this.tabSelectColor, positionOffset);
        }
        if (this.tabEnableIcoGradientColor) {
            if (fromView != null) {
                _gradientIcoColor(this.onGetIcoStyleView.invoke(fromView, Integer.valueOf(currentIndex)), getTabIcoSelectColor(), getTabIcoDeselectColor(), positionOffset);
            }
            _gradientIcoColor(this.onGetIcoStyleView.invoke(toView, Integer.valueOf(i)), getTabIcoDeselectColor(), getTabIcoSelectColor(), positionOffset);
        }
        if (this.tabEnableGradientScale) {
            _gradientScale(fromView, this.tabMaxScale, this.tabMinScale, positionOffset);
            _gradientScale(toView, this.tabMinScale, this.tabMaxScale, positionOffset);
        }
        if (this.tabEnableGradientTextSize) {
            float f = this.tabTextMaxSize;
            if (f > 0.0f) {
                float f2 = this.tabTextMinSize;
                if (f2 > 0.0f) {
                    if (f2 == f) {
                        return;
                    }
                    _gradientTextSize(fromView != null ? this.onGetTextStyleView.invoke(fromView, Integer.valueOf(currentIndex)) : null, this.tabTextMaxSize, this.tabTextMinSize, positionOffset);
                    _gradientTextSize(this.onGetTextStyleView.invoke(toView, Integer.valueOf(i)), this.tabTextMinSize, this.tabTextMaxSize, positionOffset);
                    if (i == CollectionsKt.getLastIndex(this.tabLayout.getDslSelector().getVisibleViewList()) || i == 0) {
                        this.tabLayout._scrollToTarget(i, false);
                    }
                }
            }
        }
    }

    public void _gradientColor(View view, int startColor, int endColor, float percent) {
        this.tabGradientCallback.onGradientColor(view, startColor, endColor, percent);
    }

    public void _gradientIcoColor(View view, int startColor, int endColor, float percent) {
        this.tabGradientCallback.onGradientIcoColor(view, startColor, endColor, percent);
    }

    public void _gradientScale(View view, float startScale, float endScale, float percent) {
        this.tabGradientCallback.onGradientScale(view, startScale, endScale, percent);
    }

    public void _gradientTextSize(TextView view, float startTextSize, float endTextSize, float percent) {
        this.tabGradientCallback.onGradientTextSize(view, startTextSize, endTextSize, percent);
    }

    public void _updateTextStyle(TextView textView, boolean select) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            if (this.tabEnableTextBold && select) {
                if (this.tabUseTypefaceBold) {
                    Typeface typefaceDefaultFromStyle = this.tabTypefaceBold;
                    if (typefaceDefaultFromStyle == null) {
                        typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
                    }
                    paint.setTypeface(typefaceDefaultFromStyle);
                } else {
                    paint.setFlags(paint.getFlags() | 32);
                    paint.setFakeBoldText(true);
                }
            } else if (this.tabUseTypefaceBold) {
                Typeface typefaceDefaultFromStyle2 = this.tabTypefaceNormal;
                if (typefaceDefaultFromStyle2 == null) {
                    typefaceDefaultFromStyle2 = Typeface.defaultFromStyle(0);
                }
                paint.setTypeface(typefaceDefaultFromStyle2);
            } else {
                paint.setFlags(paint.getFlags() & (-33));
                paint.setFakeBoldText(false);
            }
        }
        if (this.tabEnableTextColor) {
            textView.setTextColor(select ? this.tabSelectColor : this.tabDeselectColor);
        }
        float f = this.tabTextMaxSize;
        if (f > 0.0f || this.tabTextMinSize > 0.0f) {
            float fMin = Math.min(this.tabTextMinSize, f);
            float fMax = Math.max(this.tabTextMinSize, this.tabTextMaxSize);
            if (select) {
                fMin = fMax;
            }
            textView.setTextSize(0, fMin);
        }
    }

    public void _updateIcoColor(View view, int color) {
        this.tabGradientCallback.onUpdateIcoColor(view, color);
    }
}
