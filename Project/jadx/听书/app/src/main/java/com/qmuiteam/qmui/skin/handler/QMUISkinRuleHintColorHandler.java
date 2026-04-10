package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.widget.QMUISlider;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleHintColorHandler extends QMUISkinRuleColorStateListHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (view instanceof TextView) {
            ((TextView) view).setHintTextColor(colorStateList);
            return;
        }
        if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setHintTextColor(colorStateList);
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setRecordProgressColor(colorStateList.getDefaultColor());
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
