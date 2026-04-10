package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslTabBorder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u0002012\u0006\u00102\u001a\u000203J\u001a\u00105\u001a\u0002012\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\nH\u0016J(\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0013H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u0006C"}, d2 = {"Lcom/angcyo/tablayout/DslTabBorder;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "()V", "borderBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBorderBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBorderBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "borderBackgroundHeightOffset", "", "getBorderBackgroundHeightOffset", "()I", "setBorderBackgroundHeightOffset", "(I)V", "borderBackgroundWidthOffset", "getBorderBackgroundWidthOffset", "setBorderBackgroundWidthOffset", "borderDrawItemBackground", "", "getBorderDrawItemBackground", "()Z", "setBorderDrawItemBackground", "(Z)V", "borderItemBackgroundGradientColors", "", "getBorderItemBackgroundGradientColors", "()[I", "setBorderItemBackgroundGradientColors", "([I)V", "borderItemBackgroundSolidColor", "getBorderItemBackgroundSolidColor", "()Ljava/lang/Integer;", "setBorderItemBackgroundSolidColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "borderItemBackgroundSolidDisableColor", "getBorderItemBackgroundSolidDisableColor", "setBorderItemBackgroundSolidDisableColor", "borderKeepItemRadius", "getBorderKeepItemRadius", "setBorderKeepItemRadius", "itemDeselectBgDrawable", "getItemDeselectBgDrawable", "setItemDeselectBgDrawable", "itemSelectBgDrawable", "getItemSelectBgDrawable", "setItemSelectBgDrawable", MediationConstant.RIT_TYPE_DRAW, "", "canvas", "Landroid/graphics/Canvas;", "drawBorderBackground", "initAttribute", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "updateBorderBackgroundSolidColor", "borderBackgroundColor", "updateItemBackground", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "itemView", "Landroid/view/View;", "index", "select", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslTabBorder extends DslGradientDrawable {
    private Drawable borderBackgroundDrawable;
    private int borderBackgroundHeightOffset;
    private int borderBackgroundWidthOffset;
    private boolean borderDrawItemBackground = true;
    private int[] borderItemBackgroundGradientColors;
    private Integer borderItemBackgroundSolidColor;
    private Integer borderItemBackgroundSolidDisableColor;
    private boolean borderKeepItemRadius;
    private Drawable itemDeselectBgDrawable;
    private Drawable itemSelectBgDrawable;

    public final boolean getBorderDrawItemBackground() {
        return this.borderDrawItemBackground;
    }

    public final void setBorderDrawItemBackground(boolean z) {
        this.borderDrawItemBackground = z;
    }

    public final boolean getBorderKeepItemRadius() {
        return this.borderKeepItemRadius;
    }

    public final void setBorderKeepItemRadius(boolean z) {
        this.borderKeepItemRadius = z;
    }

    public final Drawable getBorderBackgroundDrawable() {
        return this.borderBackgroundDrawable;
    }

    public final void setBorderBackgroundDrawable(Drawable drawable) {
        this.borderBackgroundDrawable = drawable;
    }

    public final int getBorderBackgroundWidthOffset() {
        return this.borderBackgroundWidthOffset;
    }

    public final void setBorderBackgroundWidthOffset(int i) {
        this.borderBackgroundWidthOffset = i;
    }

    public final int getBorderBackgroundHeightOffset() {
        return this.borderBackgroundHeightOffset;
    }

    public final void setBorderBackgroundHeightOffset(int i) {
        this.borderBackgroundHeightOffset = i;
    }

    public final Integer getBorderItemBackgroundSolidColor() {
        return this.borderItemBackgroundSolidColor;
    }

    public final void setBorderItemBackgroundSolidColor(Integer num) {
        this.borderItemBackgroundSolidColor = num;
    }

    public final Integer getBorderItemBackgroundSolidDisableColor() {
        return this.borderItemBackgroundSolidDisableColor;
    }

    public final void setBorderItemBackgroundSolidDisableColor(Integer num) {
        this.borderItemBackgroundSolidDisableColor = num;
    }

    public final int[] getBorderItemBackgroundGradientColors() {
        return this.borderItemBackgroundGradientColors;
    }

    public final void setBorderItemBackgroundGradientColors(int[] iArr) {
        this.borderItemBackgroundGradientColors = iArr;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void initAttribute(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_border_solid_color, getGradientSolidColor());
        setGradientStrokeColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_border_stroke_color, getGradientStrokeColor()));
        setGradientStrokeWidth(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_border_stroke_width, LibExKt.getDpi() * 2));
        cornerRadius(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_border_radius_size, 0));
        setOriginDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.DslTabLayout_tab_border_drawable));
        this.borderDrawItemBackground = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_border_draw_item_background, this.borderDrawItemBackground);
        this.borderKeepItemRadius = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_border_keep_item_radius, this.borderKeepItemRadius);
        this.borderBackgroundWidthOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_border_item_background_width_offset, this.borderBackgroundWidthOffset);
        this.borderBackgroundHeightOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_border_item_background_height_offset, this.borderBackgroundHeightOffset);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_border_item_background_solid_color)) {
            this.borderItemBackgroundSolidColor = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_border_item_background_solid_color, getGradientStrokeColor()));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_border_item_background_solid_disable_color)) {
            int i = R.styleable.DslTabLayout_tab_border_item_background_solid_disable_color;
            Integer num = this.borderItemBackgroundSolidColor;
            this.borderItemBackgroundSolidDisableColor = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i, num != null ? num.intValue() : getGradientStrokeColor()));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_border_item_background_gradient_start_color) || typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_border_item_background_gradient_end_color)) {
            this.borderItemBackgroundGradientColors = new int[]{typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_border_item_background_gradient_start_color, getGradientStrokeColor()), typedArrayObtainStyledAttributes.getColor(R.styleable.DslTabLayout_tab_border_item_background_gradient_end_color, getGradientStrokeColor())};
        }
        typedArrayObtainStyledAttributes.recycle();
        if (getOriginDrawable() == null) {
            updateBorderBackgroundSolidColor(color);
            updateOriginDrawable();
        }
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Drawable originDrawable = getOriginDrawable();
        if (originDrawable != null) {
            originDrawable.setBounds(getPaddingLeft(), getPaddingBottom(), getViewWidth() - getPaddingRight(), getViewHeight() - getPaddingBottom());
            originDrawable.draw(canvas);
        }
    }

    public final void drawBorderBackground(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Drawable drawable = this.borderBackgroundDrawable;
        if (drawable != null) {
            drawable.setBounds(getPaddingLeft(), getPaddingBottom(), getViewWidth() - getPaddingRight(), getViewHeight() - getPaddingBottom());
            drawable.draw(canvas);
        }
    }

    public final Drawable getItemSelectBgDrawable() {
        return this.itemSelectBgDrawable;
    }

    public final void setItemSelectBgDrawable(Drawable drawable) {
        this.itemSelectBgDrawable = drawable;
    }

    public final Drawable getItemDeselectBgDrawable() {
        return this.itemDeselectBgDrawable;
    }

    public final void setItemDeselectBgDrawable(Drawable drawable) {
        this.itemDeselectBgDrawable = drawable;
    }

    public void updateItemBackground(final DslTabLayout tabLayout, View itemView, int index, boolean select) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (this.borderDrawItemBackground) {
            if (select) {
                final boolean z = index == 0;
                final boolean z2 = index == tabLayout.getDslSelector().getVisibleViewList().size() - 1;
                DslGradientDrawable dslGradientDrawableConfigDrawable = new DslGradientDrawable().configDrawable(new Function1<DslGradientDrawable, Unit>() { // from class: com.angcyo.tablayout.DslTabBorder$updateItemBackground$drawable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DslGradientDrawable dslGradientDrawable) {
                        invoke2(dslGradientDrawable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DslGradientDrawable configDrawable) {
                        Intrinsics.checkNotNullParameter(configDrawable, "$this$configDrawable");
                        configDrawable.setGradientWidthOffset(this.this$0.getBorderBackgroundWidthOffset());
                        configDrawable.setGradientHeightOffset(this.this$0.getBorderBackgroundHeightOffset());
                        Integer borderItemBackgroundSolidColor = this.this$0.getBorderItemBackgroundSolidColor();
                        configDrawable.setGradientSolidColor(borderItemBackgroundSolidColor != null ? borderItemBackgroundSolidColor.intValue() : this.this$0.getGradientStrokeColor());
                        if (!tabLayout.getItemEnableSelector() && this.this$0.getBorderItemBackgroundSolidDisableColor() != null) {
                            Integer borderItemBackgroundSolidDisableColor = this.this$0.getBorderItemBackgroundSolidDisableColor();
                            Intrinsics.checkNotNull(borderItemBackgroundSolidDisableColor);
                            configDrawable.setGradientSolidColor(borderItemBackgroundSolidDisableColor.intValue());
                        }
                        configDrawable.setGradientColors(this.this$0.getBorderItemBackgroundGradientColors());
                        if ((z && z2) || this.this$0.getBorderKeepItemRadius()) {
                            configDrawable.setGradientRadii(this.this$0.getGradientRadii());
                            return;
                        }
                        if (z) {
                            if (tabLayout.isHorizontal()) {
                                if (tabLayout.isLayoutRtl()) {
                                    configDrawable.setGradientRadii(new float[]{0.0f, 0.0f, this.this$0.getGradientRadii()[2], this.this$0.getGradientRadii()[3], this.this$0.getGradientRadii()[4], this.this$0.getGradientRadii()[5], 0.0f, 0.0f});
                                    return;
                                } else {
                                    configDrawable.setGradientRadii(new float[]{this.this$0.getGradientRadii()[0], this.this$0.getGradientRadii()[1], 0.0f, 0.0f, 0.0f, 0.0f, this.this$0.getGradientRadii()[6], this.this$0.getGradientRadii()[7]});
                                    return;
                                }
                            }
                            configDrawable.setGradientRadii(new float[]{this.this$0.getGradientRadii()[0], this.this$0.getGradientRadii()[1], this.this$0.getGradientRadii()[2], this.this$0.getGradientRadii()[3], 0.0f, 0.0f, 0.0f, 0.0f});
                            return;
                        }
                        if (z2) {
                            if (tabLayout.isHorizontal()) {
                                if (tabLayout.isLayoutRtl()) {
                                    configDrawable.setGradientRadii(new float[]{this.this$0.getGradientRadii()[0], this.this$0.getGradientRadii()[1], 0.0f, 0.0f, 0.0f, 0.0f, this.this$0.getGradientRadii()[6], this.this$0.getGradientRadii()[7]});
                                    return;
                                } else {
                                    configDrawable.setGradientRadii(new float[]{0.0f, 0.0f, this.this$0.getGradientRadii()[2], this.this$0.getGradientRadii()[3], this.this$0.getGradientRadii()[4], this.this$0.getGradientRadii()[5], 0.0f, 0.0f});
                                    return;
                                }
                            }
                            configDrawable.setGradientRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, this.this$0.getGradientRadii()[4], this.this$0.getGradientRadii()[5], this.this$0.getGradientRadii()[6], this.this$0.getGradientRadii()[7]});
                        }
                    }
                });
                this.itemSelectBgDrawable = dslGradientDrawableConfigDrawable;
                ViewCompat.setBackground(itemView, dslGradientDrawableConfigDrawable);
                return;
            }
            ViewCompat.setBackground(itemView, this.itemDeselectBgDrawable);
        }
    }

    public void updateBorderBackgroundSolidColor(final int borderBackgroundColor) {
        this.borderBackgroundDrawable = new DslGradientDrawable().configDrawable(new Function1<DslGradientDrawable, Unit>() { // from class: com.angcyo.tablayout.DslTabBorder.updateBorderBackgroundSolidColor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DslGradientDrawable dslGradientDrawable) {
                invoke2(dslGradientDrawable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DslGradientDrawable configDrawable) {
                Intrinsics.checkNotNullParameter(configDrawable, "$this$configDrawable");
                configDrawable.setGradientSolidColor(borderBackgroundColor);
                configDrawable.setGradientRadii(this.getGradientRadii());
            }
        }).getOriginDrawable();
    }
}
