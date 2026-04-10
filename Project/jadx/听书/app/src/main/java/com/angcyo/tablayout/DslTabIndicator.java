package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.angcyo.tablayout.DslTabLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DslTabIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016J\u000e\u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ>\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJF\u0010c\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJF\u0010e\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJ\u000e\u0010g\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\u0010\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010m\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010n\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010o\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u001a\u0010p\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00062\b\b\u0002\u0010q\u001a\u00020\u0006H\u0016J\u001a\u0010r\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00062\b\b\u0002\u0010q\u001a\u00020\u0006H\u0016J\u0010\u0010s\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0012\u0010u\u001a\u0004\u0018\u00010j2\u0006\u0010i\u001a\u00020jH\u0016J\u001a\u0010v\u001a\u00020X2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016JK\u0010{\u001a\u00020X2\u0006\u0010V\u001a\u00020\u000629\u0010|\u001a5\u0012\u0013\u0012\u00110j¢\u0006\f\b~\u0012\b\b\u007f\u0012\u0004\b\b(i\u0012\u0016\u0012\u0014\u0018\u00010j¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u00020X0}H\u0016J\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0083\u0001\u001a\u00020\u0006H\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\fR(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\fR\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\fR\u001a\u00108\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\fR\u001a\u0010;\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\b\"\u0004\b=\u0010\fR\u001a\u0010>\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\fR\u001a\u0010A\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010\fR\u001a\u0010D\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010\fR\u001a\u0010G\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010\fR\u001a\u0010J\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\fR$\u0010N\u001a\u00020M2\u0006\u0010\u0019\u001a\u00020M@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0087\u0001"}, d2 = {"Lcom/angcyo/tablayout/DslTabIndicator;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "(Lcom/angcyo/tablayout/DslTabLayout;)V", "_indicatorDrawStyle", "", "get_indicatorDrawStyle", "()I", "_targetIndex", "get_targetIndex", "set_targetIndex", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "ignoreChildPadding", "", "getIgnoreChildPadding", "()Z", "setIgnoreChildPadding", "(Z)V", "indicatorAnim", "getIndicatorAnim", "setIndicatorAnim", "value", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "Landroid/graphics/drawable/Drawable;", "indicatorDrawable", "getIndicatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setIndicatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "indicatorEnableFlash", "getIndicatorEnableFlash", "setIndicatorEnableFlash", "indicatorEnableFlashClip", "getIndicatorEnableFlashClip", "setIndicatorEnableFlashClip", "indicatorEnableFlow", "getIndicatorEnableFlow", "setIndicatorEnableFlow", "indicatorFlowStep", "getIndicatorFlowStep", "setIndicatorFlowStep", "indicatorGravity", "getIndicatorGravity", "setIndicatorGravity", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorHeightOffset", "getIndicatorHeightOffset", "setIndicatorHeightOffset", "indicatorStyle", "getIndicatorStyle", "setIndicatorStyle", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "indicatorWidthOffset", "getIndicatorWidthOffset", "setIndicatorWidthOffset", "indicatorXOffset", "getIndicatorXOffset", "setIndicatorXOffset", "indicatorYOffset", "getIndicatorYOffset", "setIndicatorYOffset", "", "positionOffset", "getPositionOffset", "()F", "setPositionOffset", "(F)V", "getTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "_childConvexHeight", "index", MediationConstant.RIT_TYPE_DRAW, "", "canvas", "Landroid/graphics/Canvas;", "drawHorizontal", "drawIndicator", "indicator", "l", an.aI, "r", t.l, TypedValues.Cycle.S_WAVE_OFFSET, "drawIndicatorClipHorizontal", "endWidth", "drawIndicatorClipVertical", "endHeight", "drawVertical", "getChildTargetHeight", "childView", "Landroid/view/View;", "getChildTargetPaddingBottom", "getChildTargetPaddingLeft", "getChildTargetPaddingRight", "getChildTargetPaddingTop", "getChildTargetWidth", "getChildTargetX", "gravity", "getChildTargetY", "getIndicatorDrawHeight", "getIndicatorDrawWidth", "indicatorContentView", "initAttribute", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "targetChildView", "onChildView", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "contentChildView", "tintDrawableColor", "drawable", "color", "updateOriginDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Companion", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslTabIndicator extends DslGradientDrawable {
    public static final int INDICATOR_GRAVITY_CENTER = 4;
    public static final int INDICATOR_GRAVITY_END = 2;
    public static final int INDICATOR_GRAVITY_START = 1;
    public static final int INDICATOR_STYLE_BOTTOM = 2;
    public static final int INDICATOR_STYLE_CENTER = 4;
    public static final int INDICATOR_STYLE_FOREGROUND = 4096;
    public static final int INDICATOR_STYLE_NONE = 0;
    public static final int INDICATOR_STYLE_TOP = 1;
    public static final int NO_COLOR = -2;
    private int _targetIndex;
    private int currentIndex;
    private boolean ignoreChildPadding;
    private boolean indicatorAnim;
    private int indicatorColor;
    private int indicatorContentId;
    private int indicatorContentIndex;
    private Drawable indicatorDrawable;
    private boolean indicatorEnableFlash;
    private boolean indicatorEnableFlashClip;
    private boolean indicatorEnableFlow;
    private int indicatorFlowStep;
    private int indicatorGravity;
    private int indicatorHeight;
    private int indicatorHeightOffset;
    private int indicatorStyle;
    private int indicatorWidth;
    private int indicatorWidthOffset;
    private int indicatorXOffset;
    private int indicatorYOffset;
    private float positionOffset;
    private final DslTabLayout tabLayout;

    public DslTabIndicator(DslTabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        this.indicatorGravity = 4;
        this.indicatorEnableFlashClip = true;
        this.indicatorFlowStep = 1;
        this.indicatorColor = -2;
        this.indicatorContentIndex = -1;
        this.indicatorContentId = -1;
        this.indicatorAnim = true;
        this.ignoreChildPadding = true;
        setCallback(tabLayout);
        this.currentIndex = -1;
        this._targetIndex = -1;
    }

    public final DslTabLayout getTabLayout() {
        return this.tabLayout;
    }

    public final int getIndicatorStyle() {
        return this.indicatorStyle;
    }

    public final void setIndicatorStyle(int i) {
        this.indicatorStyle = i;
    }

    public final int get_indicatorDrawStyle() {
        return LibExKt.remove(this.indicatorStyle, 4096);
    }

    public final int getIndicatorGravity() {
        return this.indicatorGravity;
    }

    public final void setIndicatorGravity(int i) {
        this.indicatorGravity = i;
    }

    public final boolean getIndicatorEnableFlow() {
        return this.indicatorEnableFlow;
    }

    public final void setIndicatorEnableFlow(boolean z) {
        this.indicatorEnableFlow = z;
    }

    public final boolean getIndicatorEnableFlash() {
        return this.indicatorEnableFlash;
    }

    public final void setIndicatorEnableFlash(boolean z) {
        this.indicatorEnableFlash = z;
    }

    public final boolean getIndicatorEnableFlashClip() {
        return this.indicatorEnableFlashClip;
    }

    public final void setIndicatorEnableFlashClip(boolean z) {
        this.indicatorEnableFlashClip = z;
    }

    public final int getIndicatorFlowStep() {
        return this.indicatorFlowStep;
    }

    public final void setIndicatorFlowStep(int i) {
        this.indicatorFlowStep = i;
    }

    public final Drawable getIndicatorDrawable() {
        return this.indicatorDrawable;
    }

    public final void setIndicatorDrawable(Drawable drawable) {
        this.indicatorDrawable = tintDrawableColor(drawable, this.indicatorColor);
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final void setIndicatorColor(int i) {
        this.indicatorColor = i;
        setIndicatorDrawable(this.indicatorDrawable);
    }

    public final int getIndicatorWidth() {
        return this.indicatorWidth;
    }

    public final void setIndicatorWidth(int i) {
        this.indicatorWidth = i;
    }

    public final int getIndicatorWidthOffset() {
        return this.indicatorWidthOffset;
    }

    public final void setIndicatorWidthOffset(int i) {
        this.indicatorWidthOffset = i;
    }

    public final int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public final void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
    }

    public final int getIndicatorHeightOffset() {
        return this.indicatorHeightOffset;
    }

    public final void setIndicatorHeightOffset(int i) {
        this.indicatorHeightOffset = i;
    }

    public final int getIndicatorXOffset() {
        return this.indicatorXOffset;
    }

    public final void setIndicatorXOffset(int i) {
        this.indicatorXOffset = i;
    }

    public final int getIndicatorYOffset() {
        return this.indicatorYOffset;
    }

    public final void setIndicatorYOffset(int i) {
        this.indicatorYOffset = i;
    }

    public final int getIndicatorContentIndex() {
        return this.indicatorContentIndex;
    }

    public final void setIndicatorContentIndex(int i) {
        this.indicatorContentIndex = i;
    }

    public final int getIndicatorContentId() {
        return this.indicatorContentId;
    }

    public final void setIndicatorContentId(int i) {
        this.indicatorContentId = i;
    }

    public final boolean getIndicatorAnim() {
        return this.indicatorAnim;
    }

    public final void setIndicatorAnim(boolean z) {
        this.indicatorAnim = z;
    }

    public final boolean getIgnoreChildPadding() {
        return this.ignoreChildPadding;
    }

    public final void setIgnoreChildPadding(boolean z) {
        this.ignoreChildPadding = z;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void initAttribute(Context context, AttributeSet attributeSet) {
        int[] iArr_fillColor;
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setIndicatorDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.DslTabLayout_tab_indicator_drawable));
        setIndicatorColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_indicator_color, this.indicatorColor));
        boolean z = true;
        this.indicatorStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_indicator_style, this.tabLayout.isHorizontal() ? 2 : 1);
        this.indicatorGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_indicator_gravity, this.indicatorGravity);
        if (LibExKt.have(this.indicatorStyle, 4096)) {
            this.indicatorWidth = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_indicator_width, this.tabLayout.isHorizontal() ? -1 : LibExKt.getDpi() * 3);
            this.indicatorHeight = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_indicator_height, this.tabLayout.isHorizontal() ? LibExKt.getDpi() * 3 : -1);
            this.indicatorXOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_x_offset, this.tabLayout.isHorizontal() ? 0 : LibExKt.getDpi() * 2);
            this.indicatorYOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_y_offset, this.tabLayout.isHorizontal() ? LibExKt.getDpi() * 2 : 0);
        } else {
            if (this.tabLayout.isHorizontal()) {
                this.indicatorWidth = -1;
                this.indicatorHeight = -1;
            } else {
                this.indicatorHeight = -1;
                this.indicatorWidth = -1;
            }
            this.indicatorWidth = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_indicator_width, this.indicatorWidth);
            this.indicatorHeight = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_indicator_height, this.indicatorHeight);
            this.indicatorXOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_x_offset, this.indicatorXOffset);
            this.indicatorYOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_y_offset, this.indicatorYOffset);
        }
        this.ignoreChildPadding = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_indicator_ignore_child_padding, !LibExKt.have(this.indicatorStyle, 4));
        this.indicatorFlowStep = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_indicator_flow_step, this.indicatorFlowStep);
        this.indicatorEnableFlow = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_indicator_enable_flow, this.indicatorEnableFlow);
        this.indicatorEnableFlash = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_indicator_enable_flash, this.indicatorEnableFlash);
        this.indicatorEnableFlashClip = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_indicator_enable_flash_clip, this.indicatorEnableFlashClip);
        this.indicatorWidthOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_width_offset, this.indicatorWidthOffset);
        this.indicatorHeightOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_height_offset, this.indicatorHeightOffset);
        this.indicatorContentIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_indicator_content_index, this.indicatorContentIndex);
        this.indicatorContentId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_tab_indicator_content_id, this.indicatorContentId);
        this.indicatorAnim = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_indicator_anim, this.indicatorAnim);
        setGradientShape(typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_indicator_shape, getGradientShape()));
        setGradientSolidColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_indicator_solid_color, getGradientSolidColor()));
        setGradientStrokeColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_indicator_stroke_color, getGradientStrokeColor()));
        setGradientStrokeWidth(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_stroke_width, getGradientStrokeWidth()));
        setGradientDashWidth(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_dash_width, (int) getGradientDashWidth()));
        setGradientDashGap(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_dash_gap, (int) getGradientDashGap()));
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_indicator_radius, 0);
        if (dimensionPixelOffset > 0) {
            Arrays.fill(getGradientRadii(), dimensionPixelOffset);
        } else {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.DslTabLayout_tab_indicator_radii);
            if (string != null) {
                _fillRadii(getGradientRadii(), string);
            }
        }
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.DslTabLayout_tab_indicator_gradient_colors);
        String str = string2;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            int color = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_indicator_gradient_start_color, 0);
            int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_indicator_gradient_end_color, 0);
            if (color != color2) {
                iArr_fillColor = new int[]{color, color2};
            } else {
                iArr_fillColor = getGradientColors();
            }
        } else {
            iArr_fillColor = _fillColor(string2);
            if (iArr_fillColor == null) {
                iArr_fillColor = getGradientColors();
            }
        }
        setGradientColors(iArr_fillColor);
        typedArrayObtainStyledAttributes.recycle();
        if (this.indicatorDrawable == null && isValidConfig()) {
            updateOriginDrawable();
        }
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable
    public GradientDrawable updateOriginDrawable() {
        GradientDrawable gradientDrawableUpdateOriginDrawable = super.updateOriginDrawable();
        setIndicatorDrawable(getOriginDrawable());
        return gradientDrawableUpdateOriginDrawable;
    }

    public Drawable tintDrawableColor(Drawable drawable, int color) {
        return (drawable == null || color == -2) ? drawable : LibExKt.tintDrawableColor(drawable, color);
    }

    public View indicatorContentView(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        ViewGroup.LayoutParams layoutParams = childView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
        int indicatorContentId = layoutParams2.getIndicatorContentId() != -1 ? layoutParams2.getIndicatorContentId() : this.indicatorContentId;
        if (indicatorContentId != -1) {
            return childView.findViewById(indicatorContentId);
        }
        int indicatorContentIndex = layoutParams2.getIndicatorContentIndex() >= 0 ? layoutParams2.getIndicatorContentIndex() : this.indicatorContentIndex;
        if (indicatorContentIndex >= 0 && (childView instanceof ViewGroup)) {
            boolean z = false;
            if (indicatorContentIndex >= 0 && indicatorContentIndex < ((ViewGroup) childView).getChildCount()) {
                z = true;
            }
            if (z) {
                return ((ViewGroup) childView).getChildAt(indicatorContentIndex);
            }
        }
        return null;
    }

    public void targetChildView(int index, Function2<? super View, ? super View, Unit> onChildView) {
        Intrinsics.checkNotNullParameter(onChildView, "onChildView");
        View view = (View) CollectionsKt.getOrNull(this.tabLayout.getDslSelector().getVisibleViewList(), index);
        if (view != null) {
            onChildView.invoke(view, indicatorContentView(view));
        }
    }

    public int getChildTargetPaddingLeft(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (this.ignoreChildPadding) {
            return childView.getPaddingLeft();
        }
        return 0;
    }

    public int getChildTargetPaddingRight(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (this.ignoreChildPadding) {
            return childView.getPaddingRight();
        }
        return 0;
    }

    public int getChildTargetPaddingTop(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (this.ignoreChildPadding) {
            return childView.getPaddingTop();
        }
        return 0;
    }

    public int getChildTargetPaddingBottom(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (this.ignoreChildPadding) {
            return childView.getPaddingBottom();
        }
        return 0;
    }

    public int getChildTargetWidth(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        return this.ignoreChildPadding ? LibExKt.getViewDrawWidth(childView) : childView.getMeasuredWidth();
    }

    public int getChildTargetHeight(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        return this.ignoreChildPadding ? LibExKt.getViewDrawHeight(childView) : childView.getMeasuredHeight();
    }

    public static /* synthetic */ int getChildTargetX$default(DslTabIndicator dslTabIndicator, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChildTargetX");
        }
        if ((i3 & 2) != 0) {
            i2 = dslTabIndicator.indicatorGravity;
        }
        return dslTabIndicator.getChildTargetX(i, i2);
    }

    public int getChildTargetX(int index, final int gravity) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = index > 0 ? this.tabLayout.getMaxWidth() : 0;
        targetChildView(index, new Function2<View, View, Unit>() { // from class: com.angcyo.tablayout.DslTabIndicator.getChildTargetX.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, View view2) {
                invoke2(view, view2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View childView, View view) {
                int left;
                int left2;
                int left3;
                Intrinsics.checkNotNullParameter(childView, "childView");
                Ref.IntRef intRef2 = intRef;
                if (view == null) {
                    int i = gravity;
                    if (i == 1) {
                        left3 = childView.getLeft();
                    } else if (i == 2) {
                        left3 = childView.getRight();
                    } else {
                        left3 = childView.getLeft() + this.getChildTargetPaddingLeft(childView) + (this.getChildTargetWidth(childView) / 2);
                    }
                } else {
                    int i2 = gravity;
                    if (i2 == 1) {
                        left = childView.getLeft();
                        left2 = view.getLeft();
                    } else if (i2 == 2) {
                        left = childView.getLeft();
                        left2 = view.getRight();
                    } else {
                        left = childView.getLeft() + view.getLeft() + this.getChildTargetPaddingLeft(view);
                        left2 = this.getChildTargetWidth(view) / 2;
                    }
                    left3 = left2 + left;
                }
                intRef2.element = left3;
            }
        });
        return intRef.element;
    }

    public static /* synthetic */ int getChildTargetY$default(DslTabIndicator dslTabIndicator, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChildTargetY");
        }
        if ((i3 & 2) != 0) {
            i2 = dslTabIndicator.indicatorGravity;
        }
        return dslTabIndicator.getChildTargetY(i, i2);
    }

    public int getChildTargetY(int index, final int gravity) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = index > 0 ? this.tabLayout.getMaxHeight() : 0;
        targetChildView(index, new Function2<View, View, Unit>() { // from class: com.angcyo.tablayout.DslTabIndicator.getChildTargetY.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, View view2) {
                invoke2(view, view2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View childView, View view) {
                int top2;
                int top3;
                int top4;
                int top5;
                int bottom;
                Intrinsics.checkNotNullParameter(childView, "childView");
                Ref.IntRef intRef2 = intRef;
                if (view == null) {
                    int i = gravity;
                    if (i == 1) {
                        top4 = childView.getTop();
                    } else if (i == 2) {
                        top4 = childView.getBottom();
                    } else {
                        top5 = childView.getTop() + this.getChildTargetPaddingTop(childView);
                        bottom = this.getChildTargetHeight(childView) / 2;
                        top4 = top5 + bottom;
                    }
                } else {
                    int i2 = gravity;
                    if (i2 == 1) {
                        top2 = childView.getTop();
                        top3 = view.getTop();
                    } else if (i2 == 2) {
                        top5 = childView.getTop();
                        bottom = childView.getBottom();
                        top4 = top5 + bottom;
                    } else {
                        top2 = childView.getTop() + view.getTop() + this.getChildTargetPaddingTop(view);
                        top3 = this.getChildTargetHeight(view) / 2;
                    }
                    top4 = top3 + top2;
                }
                intRef2.element = top4;
            }
        });
        return intRef.element;
    }

    public int getIndicatorDrawWidth(int index) {
        View view;
        int childTargetWidth = this.indicatorWidth;
        if (childTargetWidth == -2) {
            View view2 = (View) CollectionsKt.getOrNull(this.tabLayout.getDslSelector().getVisibleViewList(), index);
            if (view2 != null) {
                View viewIndicatorContentView = indicatorContentView(view2);
                if (viewIndicatorContentView != null) {
                    view2 = viewIndicatorContentView;
                }
                childTargetWidth = getChildTargetWidth(view2);
            }
        } else if (childTargetWidth == -1 && (view = (View) CollectionsKt.getOrNull(this.tabLayout.getDslSelector().getVisibleViewList(), index)) != null) {
            childTargetWidth = view.getMeasuredWidth();
        }
        return childTargetWidth + this.indicatorWidthOffset;
    }

    public int getIndicatorDrawHeight(int index) {
        View view;
        int childTargetHeight = this.indicatorHeight;
        if (childTargetHeight == -2) {
            View view2 = (View) CollectionsKt.getOrNull(this.tabLayout.getDslSelector().getVisibleViewList(), index);
            if (view2 != null) {
                View viewIndicatorContentView = indicatorContentView(view2);
                if (viewIndicatorContentView != null) {
                    view2 = viewIndicatorContentView;
                }
                childTargetHeight = getChildTargetHeight(view2);
            }
        } else if (childTargetHeight == -1 && (view = (View) CollectionsKt.getOrNull(this.tabLayout.getDslSelector().getVisibleViewList(), index)) != null) {
            childTargetHeight = view.getMeasuredHeight();
        }
        return childTargetHeight + this.indicatorHeightOffset;
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isVisible() || get_indicatorDrawStyle() == 0 || this.indicatorDrawable == null) {
            return;
        }
        if (this.tabLayout.isHorizontal()) {
            drawHorizontal(canvas);
        } else {
            drawVertical(canvas);
        }
    }

    public final void drawHorizontal(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int viewHeight;
        Drawable drawable;
        int i6;
        float f;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int size = this.tabLayout.getDslSelector().getVisibleViewList().size();
        int iMax = this.currentIndex;
        int i11 = this._targetIndex;
        if (i11 >= 0 && i11 < size) {
            iMax = Math.max(0, iMax);
        }
        if (iMax >= 0 && iMax < size) {
            int childTargetX$default = getChildTargetX$default(this, iMax, 0, 2, null);
            int indicatorDrawWidth = getIndicatorDrawWidth(iMax);
            int indicatorDrawHeight = getIndicatorDrawHeight(iMax);
            int i12 = (childTargetX$default - (indicatorDrawWidth / 2)) + this.indicatorXOffset;
            int childTargetX$default2 = getChildTargetX$default(this, this._targetIndex, 0, 2, null);
            int indicatorDrawWidth2 = getIndicatorDrawWidth(this._targetIndex);
            int i13 = (childTargetX$default2 - (indicatorDrawWidth2 / 2)) + this.indicatorXOffset;
            int i14 = this._targetIndex;
            if (!(i14 >= 0 && i14 < size) || i14 == iMax) {
                i = size;
                i2 = indicatorDrawWidth;
                i3 = i12;
                i4 = indicatorDrawWidth2;
                i5 = 0;
            } else {
                int indicatorDrawHeight2 = getIndicatorDrawHeight(i14);
                if (this.indicatorEnableFlash) {
                    float f2 = this.positionOffset;
                    i7 = (int) (indicatorDrawWidth * (1 - f2));
                    i8 = (int) (indicatorDrawWidth2 * f2);
                    i3 = (childTargetX$default - (i7 / 2)) + this.indicatorXOffset;
                    i6 = indicatorDrawHeight2;
                    i = size;
                } else {
                    if (this.indicatorEnableFlow && Math.abs(this._targetIndex - iMax) <= this.indicatorFlowStep) {
                        if (this._targetIndex > iMax) {
                            int i15 = i13 - i12;
                            i9 = i15 + indicatorDrawWidth2;
                            float f3 = this.positionOffset;
                            i6 = indicatorDrawHeight2;
                            if (f3 >= 0.5d) {
                                i = size;
                                i10 = (int) (((double) i12) + ((((double) i15) * (((double) f3) - 0.5d)) / ((double) 0.5f)));
                            } else {
                                i = size;
                                i10 = i12;
                            }
                        } else {
                            i6 = indicatorDrawHeight2;
                            i = size;
                            int i16 = i12 - i13;
                            i9 = i16 + indicatorDrawWidth;
                            float f4 = this.positionOffset;
                            i10 = ((double) f4) >= 0.5d ? i13 : (int) (i12 - ((i16 * f4) / 0.5f));
                        }
                        i3 = i10;
                        int i17 = i9;
                        float f5 = this.positionOffset;
                        i7 = ((double) f5) >= 0.5d ? (int) (((double) i17) - ((((double) (i17 - indicatorDrawWidth2)) * (((double) f5) - 0.5d)) / ((double) 0.5f))) : (int) (indicatorDrawWidth + (((i17 - indicatorDrawWidth) * f5) / 0.5f));
                    } else {
                        i6 = indicatorDrawHeight2;
                        i = size;
                        if (this._targetIndex > iMax) {
                            f = i12 + ((i13 - i12) * this.positionOffset);
                        } else {
                            f = i12 - ((i12 - i13) * this.positionOffset);
                        }
                        i3 = (int) f;
                        i7 = (int) (indicatorDrawWidth + ((indicatorDrawWidth2 - indicatorDrawWidth) * this.positionOffset));
                    }
                    i8 = indicatorDrawWidth2;
                }
                i5 = (int) ((i6 - indicatorDrawHeight) * this.positionOffset);
                i4 = i8;
                i2 = i7;
            }
            int i18 = get_indicatorDrawStyle();
            if (i18 != 1) {
                if (i18 == 2) {
                    viewHeight = (getViewHeight() - indicatorDrawHeight) - this.indicatorYOffset;
                } else {
                    viewHeight = ((((getPaddingTop() + (getViewDrawHeight() / 2)) - (indicatorDrawHeight / 2)) + this.indicatorYOffset) - i5) + ((this.tabLayout.get_maxConvexHeight() - _childConvexHeight(iMax)) / 2);
                }
                z = false;
            } else {
                z = false;
                viewHeight = this.indicatorYOffset + 0;
            }
            Drawable drawable2 = this.indicatorDrawable;
            if (drawable2 != null) {
                if (this.indicatorEnableFlash) {
                    if (this.indicatorEnableFlashClip) {
                        drawable = drawable2;
                        drawIndicatorClipHorizontal(drawable2, canvas, i12, viewHeight, i12 + indicatorDrawWidth, viewHeight + indicatorDrawHeight + i5, i2, 1 - this.positionOffset);
                    } else {
                        drawable = drawable2;
                        drawIndicator(drawable, canvas, i3, viewHeight, i3 + i2, viewHeight + indicatorDrawHeight + i5, 1 - this.positionOffset);
                    }
                    int i19 = this._targetIndex;
                    if (i19 >= 0 && i19 < i) {
                        z = true;
                    }
                    if (z) {
                        if (this.indicatorEnableFlashClip) {
                            drawIndicatorClipHorizontal(drawable, canvas, i13, viewHeight, i13 + indicatorDrawWidth2, indicatorDrawHeight + viewHeight + i5, i4, this.positionOffset);
                            return;
                        } else {
                            drawIndicator(drawable, canvas, i13, viewHeight, i13 + i4, indicatorDrawHeight + viewHeight + i5, this.positionOffset);
                            return;
                        }
                    }
                    return;
                }
                drawIndicator(drawable2, canvas, i3, viewHeight, i3 + i2, indicatorDrawHeight + viewHeight + i5, 1 - this.positionOffset);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drawIndicator(Drawable indicator, Canvas canvas, int l, int t, int r, int b, float offset) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (indicator instanceof ITabIndicatorDraw) {
            indicator.setBounds(l, t, r, b);
            ((ITabIndicatorDraw) indicator).onDrawTabIndicator(this, canvas, offset);
            return;
        }
        indicator.setBounds(0, 0, r - l, b - t);
        int iSave = canvas.save();
        try {
            canvas.translate(l, t);
            indicator.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drawIndicatorClipHorizontal(Drawable indicator, Canvas canvas, int l, int t, int r, int b, int endWidth, float offset) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        int i = ((r - l) - endWidth) / 2;
        canvas.clipRect(l + i, t, r - i, b);
        indicator.setBounds(l, t, r, b);
        if (indicator instanceof ITabIndicatorDraw) {
            ((ITabIndicatorDraw) indicator).onDrawTabIndicator(this, canvas, offset);
        } else {
            indicator.draw(canvas);
        }
        canvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drawIndicatorClipVertical(Drawable indicator, Canvas canvas, int l, int t, int r, int b, int endHeight, float offset) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        int i = ((b - t) - endHeight) / 2;
        canvas.clipRect(l, t + i, r, b - i);
        indicator.setBounds(l, t, r, b);
        if (indicator instanceof ITabIndicatorDraw) {
            ((ITabIndicatorDraw) indicator).onDrawTabIndicator(this, canvas, offset);
        } else {
            indicator.draw(canvas);
        }
        canvas.restore();
    }

    public final void drawVertical(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int viewWidth;
        Drawable drawable;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int size = this.tabLayout.getDslSelector().getVisibleViewList().size();
        int iMax = this.currentIndex;
        int i12 = this._targetIndex;
        if (i12 >= 0 && i12 < size) {
            iMax = Math.max(0, iMax);
        }
        if (iMax >= 0 && iMax < size) {
            int childTargetY$default = getChildTargetY$default(this, iMax, 0, 2, null);
            int indicatorDrawWidth = getIndicatorDrawWidth(iMax);
            int indicatorDrawHeight = getIndicatorDrawHeight(iMax);
            int i13 = (childTargetY$default - (indicatorDrawHeight / 2)) + this.indicatorYOffset;
            int childTargetY$default2 = getChildTargetY$default(this, this._targetIndex, 0, 2, null);
            int indicatorDrawHeight2 = getIndicatorDrawHeight(this._targetIndex);
            int i14 = (childTargetY$default2 - (indicatorDrawHeight2 / 2)) + this.indicatorYOffset;
            int i15 = this._targetIndex;
            if (!(i15 >= 0 && i15 < size) || i15 == iMax) {
                i = indicatorDrawHeight;
                i2 = i13;
                i3 = indicatorDrawHeight2;
                i4 = i14;
                i5 = 0;
            } else {
                int indicatorDrawWidth2 = getIndicatorDrawWidth(i15);
                if (this.indicatorEnableFlash) {
                    float f2 = this.positionOffset;
                    i = (int) (indicatorDrawHeight * (1 - f2));
                    i7 = (int) (indicatorDrawHeight2 * f2);
                    int i16 = this.indicatorXOffset;
                    i6 = (childTargetY$default - (i / 2)) + i16;
                    i8 = (childTargetY$default2 - (i7 / 2)) + i16;
                } else {
                    if (this.indicatorEnableFlow && Math.abs(this._targetIndex - iMax) <= this.indicatorFlowStep) {
                        if (this._targetIndex > iMax) {
                            int i17 = i14 - i13;
                            int i18 = i17 + indicatorDrawHeight2;
                            float f3 = this.positionOffset;
                            if (f3 >= 0.5d) {
                                i9 = indicatorDrawHeight;
                                i11 = (int) (((double) i13) + ((((double) i17) * (((double) f3) - 0.5d)) / ((double) 0.5f)));
                            } else {
                                i9 = indicatorDrawHeight;
                                i11 = i13;
                            }
                            i6 = i11;
                            i10 = i18;
                        } else {
                            i9 = indicatorDrawHeight;
                            int i19 = i13 - i14;
                            i10 = i19 + i9;
                            float f4 = this.positionOffset;
                            i6 = ((double) f4) >= 0.5d ? i14 : (int) (i13 - ((i19 * f4) / 0.5f));
                        }
                        float f5 = this.positionOffset;
                        if (f5 >= 0.5d) {
                            i = (int) (((double) i10) - ((((double) (i10 - indicatorDrawHeight2)) * (((double) f5) - 0.5d)) / ((double) 0.5f)));
                            indicatorDrawHeight = i9;
                        } else {
                            indicatorDrawHeight = i9;
                            i = (int) (indicatorDrawHeight + (((i10 - indicatorDrawHeight) * f5) / 0.5f));
                        }
                    } else {
                        if (this._targetIndex > iMax) {
                            f = i13 + ((i14 - i13) * this.positionOffset);
                        } else {
                            f = i13 - ((i13 - i14) * this.positionOffset);
                        }
                        i6 = (int) f;
                        i = (int) (indicatorDrawHeight + ((indicatorDrawHeight2 - indicatorDrawHeight) * this.positionOffset));
                    }
                    i7 = indicatorDrawHeight2;
                    i8 = i14;
                }
                i5 = (int) ((indicatorDrawWidth2 - indicatorDrawWidth) * this.positionOffset);
                i4 = i8;
                i2 = i6;
                i3 = i7;
            }
            int i20 = get_indicatorDrawStyle();
            if (i20 != 1) {
                if (i20 == 2) {
                    viewWidth = (getViewWidth() - indicatorDrawWidth) - this.indicatorXOffset;
                } else {
                    viewWidth = ((getPaddingLeft() + this.indicatorXOffset) + ((getViewDrawWidth() / 2) - (indicatorDrawWidth / 2))) - ((this.tabLayout.get_maxConvexHeight() - _childConvexHeight(iMax)) / 2);
                }
                z = false;
            } else {
                z = false;
                viewWidth = this.indicatorXOffset + 0;
            }
            Drawable drawable2 = this.indicatorDrawable;
            if (drawable2 != null) {
                if (this.indicatorEnableFlash) {
                    if (this.indicatorEnableFlashClip) {
                        drawable = drawable2;
                        drawIndicatorClipVertical(drawable2, canvas, viewWidth, i13, viewWidth + indicatorDrawWidth + i5, i13 + indicatorDrawHeight, i, 1 - this.positionOffset);
                    } else {
                        drawable = drawable2;
                        drawIndicator(drawable, canvas, viewWidth, i2, viewWidth + indicatorDrawWidth + i5, i + i2, 1 - this.positionOffset);
                    }
                    int i21 = this._targetIndex;
                    if (i21 >= 0 && i21 < size) {
                        z = true;
                    }
                    if (z) {
                        if (this.indicatorEnableFlashClip) {
                            drawIndicatorClipVertical(drawable, canvas, viewWidth, i14, viewWidth + indicatorDrawWidth + i5, i14 + indicatorDrawHeight2, i3, this.positionOffset);
                            return;
                        } else {
                            drawIndicator(drawable, canvas, viewWidth, i4, viewWidth + indicatorDrawWidth + i5, i4 + i3, this.positionOffset);
                            return;
                        }
                    }
                    return;
                }
                drawIndicator(drawable2, canvas, viewWidth, i2, viewWidth + indicatorDrawWidth + i5, i + i2, 1 - this.positionOffset);
            }
        }
    }

    public final int _childConvexHeight(int index) {
        if (!(getAttachView() instanceof ViewGroup)) {
            return 0;
        }
        View attachView = getAttachView();
        Intrinsics.checkNotNull(attachView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) attachView).getChildAt(index).getLayoutParams();
        DslTabLayout.LayoutParams layoutParams2 = layoutParams instanceof DslTabLayout.LayoutParams ? (DslTabLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            return layoutParams2.getLayoutConvexHeight();
        }
        return 0;
    }

    public final float getPositionOffset() {
        return this.positionOffset;
    }

    public final void setPositionOffset(float f) {
        this.positionOffset = f;
        invalidateSelf();
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public final int get_targetIndex() {
        return this._targetIndex;
    }

    public final void set_targetIndex(int i) {
        this._targetIndex = i;
    }
}
