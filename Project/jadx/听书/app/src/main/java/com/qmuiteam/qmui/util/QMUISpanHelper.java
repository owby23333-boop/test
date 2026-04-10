package com.qmuiteam.qmui.util;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.qmuiteam.qmui.span.QMUIMarginImageSpan;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISpanHelper {
    public static CharSequence generateSideIconText(boolean z, int i, CharSequence charSequence, Drawable drawable) {
        return generateSideIconText(z, i, charSequence, drawable, 0);
    }

    public static CharSequence generateSideIconText(boolean z, int i, CharSequence charSequence, Drawable drawable, int i2) {
        return generateSideIconText(z, i, charSequence, drawable, i2, 0, null);
    }

    public static CharSequence generateSideIconText(boolean z, int i, CharSequence charSequence, Drawable drawable, int i2, View view) {
        return generateSideIconText(z, i, charSequence, drawable, 0, i2, view);
    }

    public static CharSequence generateSideIconText(boolean z, int i, CharSequence charSequence, Drawable drawable, int i2, int i3, View view) {
        return generateHorIconText(charSequence, z ? i : 0, z ? drawable : null, z ? i3 : 0, z ? 0 : i, z ? null : drawable, z ? 0 : i3, i2, view);
    }

    public static CharSequence generateHorIconText(CharSequence charSequence, int i, Drawable drawable, int i2, Drawable drawable2) {
        return generateHorIconText(charSequence, i, drawable, i2, drawable2, 0);
    }

    public static CharSequence generateHorIconText(CharSequence charSequence, int i, Drawable drawable, int i2, Drawable drawable2, int i3) {
        return generateHorIconText(charSequence, i, drawable, 0, i2, drawable2, 0, i3, null);
    }

    public static CharSequence generateHorIconText(CharSequence charSequence, int i, Drawable drawable, int i2, int i3, Drawable drawable2, int i4, View view) {
        return generateHorIconText(charSequence, i, drawable, i2, i3, drawable2, i4, 0, view);
    }

    public static CharSequence generateHorIconText(CharSequence charSequence, int i, Drawable drawable, int i2, int i3, Drawable drawable2, int i4, int i5, View view) {
        if (drawable == null && drawable2 == null) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.append((CharSequence) "[icon]");
            int length = spannableStringBuilder.length();
            QMUIMarginImageSpan qMUIMarginImageSpan = new QMUIMarginImageSpan(drawable, -100, 0, i, i5);
            qMUIMarginImageSpan.setSkinSupportWithTintColor(view, i2);
            qMUIMarginImageSpan.setAvoidSuperChangeFontMetrics(true);
            spannableStringBuilder.setSpan(qMUIMarginImageSpan, 0, length, 17);
        }
        spannableStringBuilder.append(charSequence);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[icon]");
            int length3 = spannableStringBuilder.length();
            QMUIMarginImageSpan qMUIMarginImageSpan2 = new QMUIMarginImageSpan(drawable2, -100, i3, 0, i5);
            qMUIMarginImageSpan2.setSkinSupportWithTintColor(view, i4);
            qMUIMarginImageSpan2.setAvoidSuperChangeFontMetrics(true);
            spannableStringBuilder.setSpan(qMUIMarginImageSpan2, length2, length3, 17);
        }
        return spannableStringBuilder;
    }
}
