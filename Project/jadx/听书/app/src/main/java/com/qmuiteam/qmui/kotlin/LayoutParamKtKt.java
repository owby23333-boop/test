package com.qmuiteam.qmui.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutParamKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\u000f\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\u0010\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\u0011\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\u0012\u001a\u00020\u000b*\u00020\f\u001a\u0012\u0010\u0013\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0015\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0017\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0018\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0019\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u001a\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0001\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003¨\u0006\u001b"}, d2 = {"constraintParentId", "", "getConstraintParentId", "()I", "matchConstraint", "getMatchConstraint", "matchParent", "getMatchParent", "wrapContent", "getWrapContent", "alignParent4", "", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "alignParentHor", "alignParentLeftBottom", "alignParentLeftTop", "alignParentRightBottom", "alignParentRightTop", "alignParentVer", "alignView4", "id", "alignViewHor", "alignViewLeftBottom", "alignViewLeftTop", "alignViewRightBottom", "alignViewRightTop", "alignViewVer", "qmui_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LayoutParamKtKt {
    private static final int constraintParentId = 0;
    private static final int matchConstraint = 0;
    private static final int matchParent = -1;
    private static final int wrapContent = -2;

    public static final int getMatchParent() {
        return matchParent;
    }

    public static final int getWrapContent() {
        return wrapContent;
    }

    public static final int getMatchConstraint() {
        return matchConstraint;
    }

    public static final int getConstraintParentId() {
        return constraintParentId;
    }

    public static final void alignParent4(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.leftToLeft = i;
        layoutParams.rightToRight = i;
        layoutParams.topToTop = i;
        layoutParams.bottomToBottom = i;
    }

    public static final void alignParentHor(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.leftToLeft = i;
        layoutParams.rightToRight = i;
    }

    public static final void alignParentVer(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.topToTop = i;
        layoutParams.bottomToBottom = i;
    }

    public static final void alignParentLeftTop(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.topToTop = i;
        layoutParams.leftToLeft = i;
    }

    public static final void alignParentLeftBottom(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.bottomToBottom = i;
        layoutParams.leftToLeft = i;
    }

    public static final void alignParentRightTop(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.topToTop = i;
        layoutParams.rightToRight = i;
    }

    public static final void alignParentRightBottom(ConstraintLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        int i = constraintParentId;
        layoutParams.bottomToBottom = i;
        layoutParams.rightToRight = i;
    }

    public static final void alignView4(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.leftToLeft = i;
        layoutParams.rightToRight = i;
        layoutParams.topToTop = i;
        layoutParams.bottomToBottom = i;
    }

    public static final void alignViewHor(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.leftToLeft = i;
        layoutParams.rightToRight = i;
    }

    public static final void alignViewVer(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.topToTop = i;
        layoutParams.bottomToBottom = i;
    }

    public static final void alignViewLeftTop(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.topToTop = i;
        layoutParams.leftToLeft = i;
    }

    public static final void alignViewLeftBottom(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.bottomToBottom = i;
        layoutParams.leftToLeft = i;
    }

    public static final void alignViewRightTop(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.topToTop = i;
        layoutParams.rightToRight = i;
    }

    public static final void alignViewRightBottom(ConstraintLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkNotNullParameter(layoutParams, "<this>");
        layoutParams.bottomToBottom = i;
        layoutParams.rightToRight = i;
    }
}
