package com.angcyo.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslBadgeDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\nH\u0016J\b\u0010X\u001a\u00020\nH\u0016J\u001a\u0010Y\u001a\u00020T2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR$\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020@@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010J\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0006R\u0011\u0010K\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bL\u0010\fR\u0011\u0010M\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bN\u0010\fR\u0011\u0010O\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bP\u0010CR\u0011\u0010Q\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bR\u0010C¨\u0006^"}, d2 = {"Lcom/angcyo/tablayout/DslBadgeDrawable;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "()V", "badgeAutoCircle", "", "getBadgeAutoCircle", "()Z", "setBadgeAutoCircle", "(Z)V", "badgeCircleOffsetX", "", "getBadgeCircleOffsetX", "()I", "setBadgeCircleOffsetX", "(I)V", "badgeCircleOffsetY", "getBadgeCircleOffsetY", "setBadgeCircleOffsetY", "badgeCircleRadius", "getBadgeCircleRadius", "setBadgeCircleRadius", "badgeGravity", "getBadgeGravity", "setBadgeGravity", "badgeMinHeight", "getBadgeMinHeight", "setBadgeMinHeight", "badgeMinWidth", "getBadgeMinWidth", "setBadgeMinWidth", "badgeOffsetX", "getBadgeOffsetX", "setBadgeOffsetX", "badgeOffsetY", "getBadgeOffsetY", "setBadgeOffsetY", "badgePaddingBottom", "getBadgePaddingBottom", "setBadgePaddingBottom", "badgePaddingLeft", "getBadgePaddingLeft", "setBadgePaddingLeft", "badgePaddingRight", "getBadgePaddingRight", "setBadgePaddingRight", "badgePaddingTop", "getBadgePaddingTop", "setBadgePaddingTop", "badgeText", "", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "badgeTextColor", "getBadgeTextColor", "setBadgeTextColor", "badgeTextOffsetX", "getBadgeTextOffsetX", "setBadgeTextOffsetX", "badgeTextOffsetY", "getBadgeTextOffsetY", "setBadgeTextOffsetY", "value", "", "badgeTextSize", "getBadgeTextSize", "()F", "setBadgeTextSize", "(F)V", "dslGravity", "Lcom/angcyo/tablayout/DslGravity;", "getDslGravity", "()Lcom/angcyo/tablayout/DslGravity;", "isCircle", "maxHeight", "getMaxHeight", "maxWidth", "getMaxWidth", "textHeight", "getTextHeight", "textWidth", "getTextWidth", MediationConstant.RIT_TYPE_DRAW, "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "initAttribute", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslBadgeDrawable extends DslGradientDrawable {
    private int badgeCircleOffsetX;
    private int badgeCircleOffsetY;
    private int badgeOffsetX;
    private int badgeOffsetY;
    private int badgePaddingBottom;
    private int badgePaddingLeft;
    private int badgePaddingRight;
    private int badgePaddingTop;
    private String badgeText;
    private int badgeTextOffsetX;
    private int badgeTextOffsetY;
    private final DslGravity dslGravity = new DslGravity();
    private int badgeGravity = 17;
    private int badgeTextColor = -1;
    private float badgeTextSize = 12 * LibExKt.getDp();
    private boolean badgeAutoCircle = true;
    private int badgeCircleRadius = LibExKt.getDpi() * 4;
    private int badgeMinHeight = -2;
    private int badgeMinWidth = -2;

    public final DslGravity getDslGravity() {
        return this.dslGravity;
    }

    public final int getBadgeGravity() {
        return this.badgeGravity;
    }

    public final void setBadgeGravity(int i) {
        this.badgeGravity = i;
    }

    public final int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    public final void setBadgeTextColor(int i) {
        this.badgeTextColor = i;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final void setBadgeText(String str) {
        this.badgeText = str;
    }

    public final float getBadgeTextSize() {
        return this.badgeTextSize;
    }

    public final void setBadgeTextSize(float f) {
        this.badgeTextSize = f;
        getTextPaint().setTextSize(this.badgeTextSize);
    }

    public final boolean getBadgeAutoCircle() {
        return this.badgeAutoCircle;
    }

    public final void setBadgeAutoCircle(boolean z) {
        this.badgeAutoCircle = z;
    }

    public final int getBadgeCircleRadius() {
        return this.badgeCircleRadius;
    }

    public final void setBadgeCircleRadius(int i) {
        this.badgeCircleRadius = i;
    }

    public final int getBadgeCircleOffsetX() {
        return this.badgeCircleOffsetX;
    }

    public final void setBadgeCircleOffsetX(int i) {
        this.badgeCircleOffsetX = i;
    }

    public final int getBadgeCircleOffsetY() {
        return this.badgeCircleOffsetY;
    }

    public final void setBadgeCircleOffsetY(int i) {
        this.badgeCircleOffsetY = i;
    }

    public final int getBadgeOffsetX() {
        return this.badgeOffsetX;
    }

    public final void setBadgeOffsetX(int i) {
        this.badgeOffsetX = i;
    }

    public final int getBadgeOffsetY() {
        return this.badgeOffsetY;
    }

    public final void setBadgeOffsetY(int i) {
        this.badgeOffsetY = i;
    }

    public final int getBadgeTextOffsetX() {
        return this.badgeTextOffsetX;
    }

    public final void setBadgeTextOffsetX(int i) {
        this.badgeTextOffsetX = i;
    }

    public final int getBadgeTextOffsetY() {
        return this.badgeTextOffsetY;
    }

    public final void setBadgeTextOffsetY(int i) {
        this.badgeTextOffsetY = i;
    }

    public final int getBadgePaddingLeft() {
        return this.badgePaddingLeft;
    }

    public final void setBadgePaddingLeft(int i) {
        this.badgePaddingLeft = i;
    }

    public final int getBadgePaddingRight() {
        return this.badgePaddingRight;
    }

    public final void setBadgePaddingRight(int i) {
        this.badgePaddingRight = i;
    }

    public final int getBadgePaddingTop() {
        return this.badgePaddingTop;
    }

    public final void setBadgePaddingTop(int i) {
        this.badgePaddingTop = i;
    }

    public final int getBadgePaddingBottom() {
        return this.badgePaddingBottom;
    }

    public final void setBadgePaddingBottom(int i) {
        this.badgePaddingBottom = i;
    }

    public final int getBadgeMinHeight() {
        return this.badgeMinHeight;
    }

    public final void setBadgeMinHeight(int i) {
        this.badgeMinHeight = i;
    }

    public final int getBadgeMinWidth() {
        return this.badgeMinWidth;
    }

    public final void setBadgeMinWidth(int i) {
        this.badgeMinWidth = i;
    }

    public final float getTextWidth() {
        return LibExKt.textWidth(getTextPaint(), this.badgeText);
    }

    public final int getMaxWidth() {
        int textWidth = (int) getTextWidth();
        Drawable originDrawable = getOriginDrawable();
        return Math.max(textWidth, originDrawable != null ? originDrawable.getMinimumWidth() : 0) + this.badgePaddingLeft + this.badgePaddingRight;
    }

    public final int getMaxHeight() {
        int textHeight = (int) getTextHeight();
        Drawable originDrawable = getOriginDrawable();
        return Math.max(textHeight, originDrawable != null ? originDrawable.getMinimumHeight() : 0) + this.badgePaddingTop + this.badgePaddingBottom;
    }

    public final float getTextHeight() {
        return LibExKt.textHeight(getTextPaint());
    }

    public final boolean isCircle() {
        return TextUtils.isEmpty(this.badgeText);
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void initAttribute(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.initAttribute(context, attributeSet);
        updateOriginDrawable();
    }

    @Override // com.angcyo.tablayout.DslGradientDrawable, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(final Canvas canvas) {
        int i;
        float fMax;
        float fMax2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.badgeText == null) {
            return;
        }
        final DslGravity dslGravity = this.dslGravity;
        if (isViewRtl()) {
            i = this.badgeGravity;
            if (i == 3) {
                i = 5;
            } else if (i == 5) {
                i = 3;
            }
        } else {
            i = this.badgeGravity;
        }
        dslGravity.setGravity(i);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        dslGravity.setGravityBounds(bounds);
        if (isCircle()) {
            dslGravity.setGravityOffsetX(this.badgeCircleOffsetX);
            dslGravity.setGravityOffsetY(this.badgeCircleOffsetY);
        } else {
            dslGravity.setGravityOffsetX(this.badgeOffsetX);
            dslGravity.setGravityOffsetY(this.badgeOffsetY);
        }
        final float fTextWidth = LibExKt.textWidth(getTextPaint(), this.badgeText);
        final float fTextHeight = LibExKt.textHeight(getTextPaint());
        if (isCircle()) {
            fMax = this.badgeCircleRadius;
        } else {
            fMax = this.badgePaddingTop + fTextHeight + this.badgePaddingBottom;
            int i2 = this.badgeMinHeight;
            if (i2 > 0) {
                fMax = Math.max(fMax, i2);
            }
        }
        final float f = fMax;
        if (isCircle()) {
            fMax2 = this.badgeCircleRadius;
        } else {
            fMax2 = this.badgePaddingLeft + fTextWidth + this.badgePaddingRight;
            int i3 = this.badgeMinWidth;
            if (i3 == -1) {
                fMax2 = Math.max(fMax2, f);
            } else if (i3 > 0) {
                fMax2 = Math.max(fMax2, i3);
            }
        }
        final float f2 = fMax2;
        dslGravity.applyGravity(f2, f, new Function2<Integer, Integer, Unit>() { // from class: com.angcyo.tablayout.DslBadgeDrawable$draw$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x014b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(int r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 422
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslBadgeDrawable$draw$1$1.invoke(int, int):void");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getIntrinsicWidth() {
        /*
            r3 = this;
            boolean r0 = r3.isCircle()
            if (r0 == 0) goto Lb
            int r0 = r3.badgeCircleRadius
            int r0 = r0 * 2
            goto L2f
        Lb:
            boolean r0 = r3.badgeAutoCircle
            if (r0 == 0) goto L2b
            java.lang.String r0 = r3.badgeText
            r1 = 0
            if (r0 == 0) goto L1c
            int r0 = r0.length()
            r2 = 1
            if (r0 != r2) goto L1c
            r1 = r2
        L1c:
            if (r1 == 0) goto L2b
            int r0 = r3.getMaxWidth()
            int r1 = r3.getMaxHeight()
            int r0 = java.lang.Math.max(r0, r1)
            goto L2f
        L2b:
            int r0 = r3.getMaxWidth()
        L2f:
            int r1 = r3.badgeMinWidth
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslBadgeDrawable.getIntrinsicWidth():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getIntrinsicHeight() {
        /*
            r3 = this;
            boolean r0 = r3.isCircle()
            if (r0 == 0) goto Lb
            int r0 = r3.badgeCircleRadius
            int r0 = r0 * 2
            goto L2f
        Lb:
            boolean r0 = r3.badgeAutoCircle
            if (r0 == 0) goto L2b
            java.lang.String r0 = r3.badgeText
            r1 = 0
            if (r0 == 0) goto L1c
            int r0 = r0.length()
            r2 = 1
            if (r0 != r2) goto L1c
            r1 = r2
        L1c:
            if (r1 == 0) goto L2b
            int r0 = r3.getMaxWidth()
            int r1 = r3.getMaxHeight()
            int r0 = java.lang.Math.max(r0, r1)
            goto L2f
        L2b:
            int r0 = r3.getMaxHeight()
        L2f:
            int r1 = r3.badgeMinHeight
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslBadgeDrawable.getIntrinsicHeight():int");
    }
}
