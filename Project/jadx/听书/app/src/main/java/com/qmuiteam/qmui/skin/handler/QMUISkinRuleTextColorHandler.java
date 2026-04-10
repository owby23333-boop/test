package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleTextColorHandler extends QMUISkinRuleColorStateListHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(colorStateList);
            return;
        }
        if (view instanceof QMUIQQFaceView) {
            ((QMUIQQFaceView) view).setTextColor(colorStateList.getDefaultColor());
        } else if (view instanceof QMUIProgressBar) {
            ((QMUIProgressBar) view).setTextColor(colorStateList.getDefaultColor());
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
