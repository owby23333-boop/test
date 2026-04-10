package com.qmuiteam.qmui.skin.handler;

import android.content.res.Resources;
import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUISlider;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleBackgroundHandler implements IQMUISkinRuleHandler {
    @Override // com.qmuiteam.qmui.skin.handler.IQMUISkinRuleHandler
    public void handle(QMUISkinManager qMUISkinManager, View view, Resources.Theme theme, String str, int i) {
        if (view instanceof QMUIRoundButton) {
            ((QMUIRoundButton) view).setBgData(QMUIResHelper.getAttrColorStateList(view.getContext(), theme, i));
            return;
        }
        if (view instanceof QMUIProgressBar) {
            view.setBackgroundColor(QMUIResHelper.getAttrColor(theme, i));
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setBarNormalColor(QMUIResHelper.getAttrColor(theme, i));
        } else {
            QMUIViewHelper.setBackgroundKeepingPadding(view, QMUIResHelper.getAttrDrawable(view.getContext(), theme, i));
        }
    }
}
