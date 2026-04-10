package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleTextCompoundTintColorHandler extends QMUISkinRuleColorStateListHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawableTintList(colorStateList);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
