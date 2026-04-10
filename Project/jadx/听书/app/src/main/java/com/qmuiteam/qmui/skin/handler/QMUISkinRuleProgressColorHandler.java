package com.qmuiteam.qmui.skin.handler;

import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUISlider;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleProgressColorHandler extends QMUISkinRuleColorHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorHandler
    protected void handle(View view, String str, int i) {
        if (view instanceof QMUIProgressBar) {
            ((QMUIProgressBar) view).setProgressColor(i);
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setBarProgressColor(i);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
