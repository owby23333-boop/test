package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleMoreTextColorHandler extends QMUISkinRuleColorStateListHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (view instanceof QMUIQQFaceView) {
            ((QMUIQQFaceView) view).setMoreActionColor(colorStateList);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
