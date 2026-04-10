package com.angcyo.tablayout;

import androidx.core.internal.view.SupportMenu;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslTabBadge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\bP\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005¢\u0006\u0002\u0010\u001bJ\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0018HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u000bHÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003JÝ\u0001\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005HÆ\u0001J\u0013\u0010d\u001a\u00020\u00182\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0005HÖ\u0001J\t\u0010g\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001fR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001d\"\u0004\bI\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006h"}, d2 = {"Lcom/angcyo/tablayout/TabBadgeConfig;", "", "badgeText", "", "badgeGravity", "", "badgeSolidColor", "badgeStrokeColor", "badgeStrokeWidth", "badgeTextColor", "badgeTextSize", "", "badgeCircleRadius", "badgeRadius", "badgeOffsetX", "badgeOffsetY", "badgeCircleOffsetX", "badgeCircleOffsetY", "badgePaddingLeft", "badgePaddingRight", "badgePaddingTop", "badgePaddingBottom", "badgeAnchorChildIndex", "badgeIgnoreChildPadding", "", "badgeMinHeight", "badgeMinWidth", "(Ljava/lang/String;IIIIIFIIIIIIIIIIIZII)V", "getBadgeAnchorChildIndex", "()I", "setBadgeAnchorChildIndex", "(I)V", "getBadgeCircleOffsetX", "setBadgeCircleOffsetX", "getBadgeCircleOffsetY", "setBadgeCircleOffsetY", "getBadgeCircleRadius", "setBadgeCircleRadius", "getBadgeGravity", "setBadgeGravity", "getBadgeIgnoreChildPadding", "()Z", "setBadgeIgnoreChildPadding", "(Z)V", "getBadgeMinHeight", "setBadgeMinHeight", "getBadgeMinWidth", "setBadgeMinWidth", "getBadgeOffsetX", "setBadgeOffsetX", "getBadgeOffsetY", "setBadgeOffsetY", "getBadgePaddingBottom", "setBadgePaddingBottom", "getBadgePaddingLeft", "setBadgePaddingLeft", "getBadgePaddingRight", "setBadgePaddingRight", "getBadgePaddingTop", "setBadgePaddingTop", "getBadgeRadius", "setBadgeRadius", "getBadgeSolidColor", "setBadgeSolidColor", "getBadgeStrokeColor", "setBadgeStrokeColor", "getBadgeStrokeWidth", "setBadgeStrokeWidth", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "getBadgeTextColor", "setBadgeTextColor", "getBadgeTextSize", "()F", "setBadgeTextSize", "(F)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TabBadgeConfig {
    private int badgeAnchorChildIndex;
    private int badgeCircleOffsetX;
    private int badgeCircleOffsetY;
    private int badgeCircleRadius;
    private int badgeGravity;
    private boolean badgeIgnoreChildPadding;
    private int badgeMinHeight;
    private int badgeMinWidth;
    private int badgeOffsetX;
    private int badgeOffsetY;
    private int badgePaddingBottom;
    private int badgePaddingLeft;
    private int badgePaddingRight;
    private int badgePaddingTop;
    private int badgeRadius;
    private int badgeSolidColor;
    private int badgeStrokeColor;
    private int badgeStrokeWidth;
    private String badgeText;
    private int badgeTextColor;
    private float badgeTextSize;

    public TabBadgeConfig() {
        this(null, 0, 0, 0, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 2097151, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBadgeText() {
        return this.badgeText;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getBadgeOffsetX() {
        return this.badgeOffsetX;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getBadgeOffsetY() {
        return this.badgeOffsetY;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getBadgeCircleOffsetX() {
        return this.badgeCircleOffsetX;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getBadgeCircleOffsetY() {
        return this.badgeCircleOffsetY;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getBadgePaddingLeft() {
        return this.badgePaddingLeft;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getBadgePaddingRight() {
        return this.badgePaddingRight;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getBadgePaddingTop() {
        return this.badgePaddingTop;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getBadgePaddingBottom() {
        return this.badgePaddingBottom;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getBadgeAnchorChildIndex() {
        return this.badgeAnchorChildIndex;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getBadgeIgnoreChildPadding() {
        return this.badgeIgnoreChildPadding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBadgeGravity() {
        return this.badgeGravity;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getBadgeMinHeight() {
        return this.badgeMinHeight;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getBadgeMinWidth() {
        return this.badgeMinWidth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBadgeSolidColor() {
        return this.badgeSolidColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBadgeStrokeColor() {
        return this.badgeStrokeColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getBadgeStrokeWidth() {
        return this.badgeStrokeWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getBadgeTextSize() {
        return this.badgeTextSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getBadgeCircleRadius() {
        return this.badgeCircleRadius;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBadgeRadius() {
        return this.badgeRadius;
    }

    public final TabBadgeConfig copy(String badgeText, int badgeGravity, int badgeSolidColor, int badgeStrokeColor, int badgeStrokeWidth, int badgeTextColor, float badgeTextSize, int badgeCircleRadius, int badgeRadius, int badgeOffsetX, int badgeOffsetY, int badgeCircleOffsetX, int badgeCircleOffsetY, int badgePaddingLeft, int badgePaddingRight, int badgePaddingTop, int badgePaddingBottom, int badgeAnchorChildIndex, boolean badgeIgnoreChildPadding, int badgeMinHeight, int badgeMinWidth) {
        return new TabBadgeConfig(badgeText, badgeGravity, badgeSolidColor, badgeStrokeColor, badgeStrokeWidth, badgeTextColor, badgeTextSize, badgeCircleRadius, badgeRadius, badgeOffsetX, badgeOffsetY, badgeCircleOffsetX, badgeCircleOffsetY, badgePaddingLeft, badgePaddingRight, badgePaddingTop, badgePaddingBottom, badgeAnchorChildIndex, badgeIgnoreChildPadding, badgeMinHeight, badgeMinWidth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabBadgeConfig)) {
            return false;
        }
        TabBadgeConfig tabBadgeConfig = (TabBadgeConfig) other;
        return Intrinsics.areEqual(this.badgeText, tabBadgeConfig.badgeText) && this.badgeGravity == tabBadgeConfig.badgeGravity && this.badgeSolidColor == tabBadgeConfig.badgeSolidColor && this.badgeStrokeColor == tabBadgeConfig.badgeStrokeColor && this.badgeStrokeWidth == tabBadgeConfig.badgeStrokeWidth && this.badgeTextColor == tabBadgeConfig.badgeTextColor && Float.compare(this.badgeTextSize, tabBadgeConfig.badgeTextSize) == 0 && this.badgeCircleRadius == tabBadgeConfig.badgeCircleRadius && this.badgeRadius == tabBadgeConfig.badgeRadius && this.badgeOffsetX == tabBadgeConfig.badgeOffsetX && this.badgeOffsetY == tabBadgeConfig.badgeOffsetY && this.badgeCircleOffsetX == tabBadgeConfig.badgeCircleOffsetX && this.badgeCircleOffsetY == tabBadgeConfig.badgeCircleOffsetY && this.badgePaddingLeft == tabBadgeConfig.badgePaddingLeft && this.badgePaddingRight == tabBadgeConfig.badgePaddingRight && this.badgePaddingTop == tabBadgeConfig.badgePaddingTop && this.badgePaddingBottom == tabBadgeConfig.badgePaddingBottom && this.badgeAnchorChildIndex == tabBadgeConfig.badgeAnchorChildIndex && this.badgeIgnoreChildPadding == tabBadgeConfig.badgeIgnoreChildPadding && this.badgeMinHeight == tabBadgeConfig.badgeMinHeight && this.badgeMinWidth == tabBadgeConfig.badgeMinWidth;
    }

    public int hashCode() {
        String str = this.badgeText;
        return ((((((((((((((((((((((((((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.badgeGravity)) * 31) + Integer.hashCode(this.badgeSolidColor)) * 31) + Integer.hashCode(this.badgeStrokeColor)) * 31) + Integer.hashCode(this.badgeStrokeWidth)) * 31) + Integer.hashCode(this.badgeTextColor)) * 31) + Float.hashCode(this.badgeTextSize)) * 31) + Integer.hashCode(this.badgeCircleRadius)) * 31) + Integer.hashCode(this.badgeRadius)) * 31) + Integer.hashCode(this.badgeOffsetX)) * 31) + Integer.hashCode(this.badgeOffsetY)) * 31) + Integer.hashCode(this.badgeCircleOffsetX)) * 31) + Integer.hashCode(this.badgeCircleOffsetY)) * 31) + Integer.hashCode(this.badgePaddingLeft)) * 31) + Integer.hashCode(this.badgePaddingRight)) * 31) + Integer.hashCode(this.badgePaddingTop)) * 31) + Integer.hashCode(this.badgePaddingBottom)) * 31) + Integer.hashCode(this.badgeAnchorChildIndex)) * 31) + Boolean.hashCode(this.badgeIgnoreChildPadding)) * 31) + Integer.hashCode(this.badgeMinHeight)) * 31) + Integer.hashCode(this.badgeMinWidth);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TabBadgeConfig(badgeText=");
        sb.append(this.badgeText).append(", badgeGravity=").append(this.badgeGravity).append(", badgeSolidColor=").append(this.badgeSolidColor).append(", badgeStrokeColor=").append(this.badgeStrokeColor).append(", badgeStrokeWidth=").append(this.badgeStrokeWidth).append(", badgeTextColor=").append(this.badgeTextColor).append(", badgeTextSize=").append(this.badgeTextSize).append(", badgeCircleRadius=").append(this.badgeCircleRadius).append(", badgeRadius=").append(this.badgeRadius).append(", badgeOffsetX=").append(this.badgeOffsetX).append(", badgeOffsetY=").append(this.badgeOffsetY).append(", badgeCircleOffsetX=");
        sb.append(this.badgeCircleOffsetX).append(", badgeCircleOffsetY=").append(this.badgeCircleOffsetY).append(", badgePaddingLeft=").append(this.badgePaddingLeft).append(", badgePaddingRight=").append(this.badgePaddingRight).append(", badgePaddingTop=").append(this.badgePaddingTop).append(", badgePaddingBottom=").append(this.badgePaddingBottom).append(", badgeAnchorChildIndex=").append(this.badgeAnchorChildIndex).append(", badgeIgnoreChildPadding=").append(this.badgeIgnoreChildPadding).append(", badgeMinHeight=").append(this.badgeMinHeight).append(", badgeMinWidth=").append(this.badgeMinWidth).append(')');
        return sb.toString();
    }

    public TabBadgeConfig(String str, int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, int i17, int i18) {
        this.badgeText = str;
        this.badgeGravity = i;
        this.badgeSolidColor = i2;
        this.badgeStrokeColor = i3;
        this.badgeStrokeWidth = i4;
        this.badgeTextColor = i5;
        this.badgeTextSize = f;
        this.badgeCircleRadius = i6;
        this.badgeRadius = i7;
        this.badgeOffsetX = i8;
        this.badgeOffsetY = i9;
        this.badgeCircleOffsetX = i10;
        this.badgeCircleOffsetY = i11;
        this.badgePaddingLeft = i12;
        this.badgePaddingRight = i13;
        this.badgePaddingTop = i14;
        this.badgePaddingBottom = i15;
        this.badgeAnchorChildIndex = i16;
        this.badgeIgnoreChildPadding = z;
        this.badgeMinHeight = i17;
        this.badgeMinWidth = i18;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final void setBadgeText(String str) {
        this.badgeText = str;
    }

    public final int getBadgeGravity() {
        return this.badgeGravity;
    }

    public final void setBadgeGravity(int i) {
        this.badgeGravity = i;
    }

    public final int getBadgeSolidColor() {
        return this.badgeSolidColor;
    }

    public final void setBadgeSolidColor(int i) {
        this.badgeSolidColor = i;
    }

    public final int getBadgeStrokeColor() {
        return this.badgeStrokeColor;
    }

    public final void setBadgeStrokeColor(int i) {
        this.badgeStrokeColor = i;
    }

    public final int getBadgeStrokeWidth() {
        return this.badgeStrokeWidth;
    }

    public final void setBadgeStrokeWidth(int i) {
        this.badgeStrokeWidth = i;
    }

    public final int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    public final void setBadgeTextColor(int i) {
        this.badgeTextColor = i;
    }

    public /* synthetic */ TabBadgeConfig(String str, int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? null : str, (i19 & 2) != 0 ? 17 : i, (i19 & 4) != 0 ? SupportMenu.CATEGORY_MASK : i2, (i19 & 8) != 0 ? 0 : i3, (i19 & 16) != 0 ? 0 : i4, (i19 & 32) != 0 ? -1 : i5, (i19 & 64) != 0 ? 12 * LibExKt.getDp() : f, (i19 & 128) != 0 ? LibExKt.getDpi() * 4 : i6, (i19 & 256) != 0 ? LibExKt.getDpi() * 10 : i7, (i19 & 512) != 0 ? 0 : i8, (i19 & 1024) != 0 ? 0 : i9, (i19 & 2048) != 0 ? 0 : i10, (i19 & 4096) != 0 ? 0 : i11, (i19 & 8192) != 0 ? LibExKt.getDpi() * 4 : i12, (i19 & 16384) != 0 ? LibExKt.getDpi() * 4 : i13, (i19 & 32768) != 0 ? 0 : i14, (i19 & 65536) != 0 ? 0 : i15, (i19 & 131072) != 0 ? -1 : i16, (i19 & 262144) != 0 ? true : z, (i19 & 524288) != 0 ? -2 : i17, (i19 & 1048576) != 0 ? -1 : i18);
    }

    public final float getBadgeTextSize() {
        return this.badgeTextSize;
    }

    public final void setBadgeTextSize(float f) {
        this.badgeTextSize = f;
    }

    public final int getBadgeCircleRadius() {
        return this.badgeCircleRadius;
    }

    public final void setBadgeCircleRadius(int i) {
        this.badgeCircleRadius = i;
    }

    public final int getBadgeRadius() {
        return this.badgeRadius;
    }

    public final void setBadgeRadius(int i) {
        this.badgeRadius = i;
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

    public final int getBadgeAnchorChildIndex() {
        return this.badgeAnchorChildIndex;
    }

    public final void setBadgeAnchorChildIndex(int i) {
        this.badgeAnchorChildIndex = i;
    }

    public final boolean getBadgeIgnoreChildPadding() {
        return this.badgeIgnoreChildPadding;
    }

    public final void setBadgeIgnoreChildPadding(boolean z) {
        this.badgeIgnoreChildPadding = z;
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
}
