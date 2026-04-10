package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUISlider;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleBorderHandler extends QMUISkinRuleColorStateListHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof IQMUILayout) {
            ((IQMUILayout) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIRadiusImageView) {
            ((QMUIRadiusImageView) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIRoundButton) {
            ((QMUIRoundButton) view).setStrokeColors(colorStateList);
        } else if (view instanceof QMUISlider.DefaultThumbView) {
            ((QMUISlider.DefaultThumbView) view).setBorderColor(colorStateList.getDefaultColor());
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
