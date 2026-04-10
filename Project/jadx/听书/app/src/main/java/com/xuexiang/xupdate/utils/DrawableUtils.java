package com.xuexiang.xupdate.utils;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawableUtils {
    private DrawableUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static GradientDrawable getSolidRectDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setColor(i2);
        gradientDrawable.setGradientType(1);
        return gradientDrawable;
    }

    public static GradientDrawable getStrokeRectDrawable(int i, int i2, int i3, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(i4, i3);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setGradientType(1);
        return gradientDrawable;
    }

    public static StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, drawable);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable2);
        stateListDrawable.addState(new int[0], getSolidRectDrawable(10, QMUIProgressBar.DEFAULT_BACKGROUND_COLOR));
        return stateListDrawable;
    }

    public static StateListDrawable getDrawable(int i, int i2, int i3) {
        return getStateListDrawable(getSolidRectDrawable(i, i2), getSolidRectDrawable(i, i3));
    }

    public static StateListDrawable getStrokeSolidDrawable(int i, int i2, int i3, int i4) {
        return getStateListDrawable(getSolidRectDrawable(i, i3), getStrokeRectDrawable(i, i4, i3, i2));
    }

    public static StateListDrawable getSolidStrokeDrawable(int i, int i2, int i3, int i4) {
        return getStateListDrawable(getStrokeRectDrawable(i, i3, i4, i2), getSolidRectDrawable(i, i4));
    }

    public static StateListDrawable getDrawable(int i, int i2) {
        return getDrawable(i, ColorUtils.colorDeep(i2), i2);
    }

    public static StateListDrawable getDrawable(int i) {
        return getDrawable(i, ColorUtils.getRandomColor());
    }

    public static StateListDrawable getDrawable() {
        return getDrawable(10);
    }

    public static StateListDrawable getRandomColorDrawable(int i) {
        return getDrawable(i, ColorUtils.getRandomColor(), ColorUtils.getRandomColor());
    }

    public static StateListDrawable getRandomColorDrawable() {
        return getRandomColorDrawable(10);
    }

    public static StateListDrawable getStrokeRandomColorDrawable() {
        return getStrokeSolidDrawable(10, 4, ColorUtils.getRandomColor(), 0);
    }

    public static void setTextStrokeTheme(TextView textView, int i, int i2, int i3) {
        textView.setBackgroundDrawable(getStrokeSolidDrawable(i2, i, i3, -1));
        textView.setTextColor(ColorUtils.getColorStateList(-1, i3));
        textView.getPaint().setFlags(32);
    }

    public static void setTextStrokeTheme(TextView textView, int i, int i2) {
        setTextStrokeTheme(textView, i, i2, ColorUtils.getRandomColor());
    }

    public static void setTextStrokeTheme(TextView textView) {
        setTextStrokeTheme(textView, 6, 10);
    }

    public static void setTextStrokeTheme(TextView textView, int i) {
        setTextStrokeTheme(textView, 6, 10, i);
    }

    public static void setTextSolidTheme(TextView textView, int i, int i2, int i3) {
        textView.setBackgroundDrawable(getSolidStrokeDrawable(i2, i, -1, i3));
        textView.setTextColor(ColorUtils.getColorStateList(i3, -1));
        textView.getPaint().setFlags(32);
    }

    public static void setTextSolidTheme(TextView textView, int i, int i2) {
        setTextSolidTheme(textView, i, i2, ColorUtils.getRandomColor());
    }

    public static void setTextSolidTheme(TextView textView) {
        setTextSolidTheme(textView, 6, 10);
    }

    public static void setBackgroundCompat(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
