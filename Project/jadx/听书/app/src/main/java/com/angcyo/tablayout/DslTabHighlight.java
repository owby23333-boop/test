package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.angcyo.tablayout.DslTabLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslTabHighlight.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/angcyo/tablayout/DslTabHighlight;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "(Lcom/angcyo/tablayout/DslTabLayout;)V", "highlightDrawable", "Landroid/graphics/drawable/Drawable;", "getHighlightDrawable", "()Landroid/graphics/drawable/Drawable;", "setHighlightDrawable", "(Landroid/graphics/drawable/Drawable;)V", "highlightHeight", "", "getHighlightHeight", "()I", "setHighlightHeight", "(I)V", "highlightHeightOffset", "getHighlightHeightOffset", "setHighlightHeightOffset", "highlightWidth", "getHighlightWidth", "setHighlightWidth", "highlightWidthOffset", "getHighlightWidthOffset", "setHighlightWidthOffset", "getTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", MediationConstant.RIT_TYPE_DRAW, "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "updateOriginDrawable", "Landroid/graphics/drawable/GradientDrawable;", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslTabHighlight extends DslGradientDrawable {
    private Drawable highlightDrawable;
    private int highlightHeight;
    private int highlightHeightOffset;
    private int highlightWidth;
    private int highlightWidthOffset;
    private final DslTabLayout tabLayout;

    public DslTabHighlight(DslTabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        this.highlightWidth = -1;
        this.highlightHeight = -1;
    }

    public final DslTabLayout getTabLayout() {
        return this.tabLayout;
    }

    public final Drawable getHighlightDrawable() {
        return this.highlightDrawable;
    }

    public final void setHighlightDrawable(Drawable drawable) {
        this.highlightDrawable = drawable;
    }

    public final int getHighlightWidth() {
        return this.highlightWidth;
    }

    public final void setHighlightWidth(int i) {
        this.highlightWidth = i;
    }

    public final int getHighlightHeight() {
        return this.highlightHeight;
    }

    public final void setHighlightHeight(int i) {
        this.highlightHeight = i;
    }

    public final int getHighlightWidthOffset() {
        return this.highlightWidthOffset;
    }

    public final void setHighlightWidthOffset(int i) {
        this.highlightWidthOffset = i;
    }

    public final int getHighlightHeightOffset() {
        return this.highlightHeightOffset;
    }

    public final void setHighlightHeightOffset(int i) {
        this.highlightHeightOffset = i;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void initAttribute(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.highlightDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DslTabLayout_tab_highlight_drawable);
        this.highlightWidth = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_highlight_width, this.highlightWidth);
        this.highlightHeight = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.DslTabLayout_tab_highlight_height, this.highlightHeight);
        this.highlightWidthOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_highlight_width_offset, this.highlightWidthOffset);
        this.highlightHeightOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_highlight_height_offset, this.highlightHeightOffset);
        typedArrayObtainStyledAttributes.recycle();
        if (this.highlightDrawable == null && isValidConfig()) {
            updateOriginDrawable();
        }
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable
    public GradientDrawable updateOriginDrawable() {
        GradientDrawable gradientDrawableUpdateOriginDrawable = super.updateOriginDrawable();
        this.highlightDrawable = getOriginDrawable();
        return gradientDrawableUpdateOriginDrawable;
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable highlightDrawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        View currentItemView = this.tabLayout.getCurrentItemView();
        if (currentItemView != null) {
            ViewGroup.LayoutParams layoutParams = currentItemView.getLayoutParams();
            if (!(layoutParams instanceof DslTabLayout.LayoutParams) || (highlightDrawable = ((DslTabLayout.LayoutParams) layoutParams).getHighlightDrawable()) == null) {
                highlightDrawable = this.highlightDrawable;
            }
            if (highlightDrawable != null) {
                int intrinsicWidth = this.highlightWidth;
                if (intrinsicWidth == -2) {
                    intrinsicWidth = highlightDrawable.getIntrinsicWidth();
                } else if (intrinsicWidth == -1) {
                    intrinsicWidth = currentItemView.getMeasuredWidth();
                }
                int i = intrinsicWidth + this.highlightWidthOffset;
                int intrinsicHeight = this.highlightHeight;
                if (intrinsicHeight == -2) {
                    intrinsicHeight = highlightDrawable.getIntrinsicHeight();
                } else if (intrinsicHeight == -1) {
                    intrinsicHeight = currentItemView.getMeasuredHeight();
                }
                int i2 = intrinsicHeight + this.highlightHeightOffset;
                int left = currentItemView.getLeft() + ((currentItemView.getRight() - currentItemView.getLeft()) / 2);
                int top2 = currentItemView.getTop() + ((currentItemView.getBottom() - currentItemView.getTop()) / 2);
                int i3 = i / 2;
                int i4 = i2 / 2;
                highlightDrawable.setBounds(left - i3, top2 - i4, left + i3, top2 + i4);
                highlightDrawable.draw(canvas);
                canvas.save();
                if (this.tabLayout.isHorizontal()) {
                    canvas.translate(currentItemView.getLeft(), 0.0f);
                } else {
                    canvas.translate(0.0f, currentItemView.getTop());
                }
                currentItemView.draw(canvas);
                canvas.restore();
            }
        }
    }
}
