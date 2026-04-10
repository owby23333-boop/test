package com.qmuiteam.qmui.skin.handler;

import android.view.View;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleSeparatorHandler extends QMUISkinRuleColorHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorHandler
    protected void handle(View view, String str, int i) {
        if (view instanceof IQMUILayout) {
            if (QMUISkinValueBuilder.TOP_SEPARATOR.equals(str)) {
                ((IQMUILayout) view).updateTopSeparatorColor(i);
                return;
            }
            if (QMUISkinValueBuilder.BOTTOM_SEPARATOR.equals(str)) {
                ((IQMUILayout) view).updateBottomSeparatorColor(i);
                return;
            } else if (QMUISkinValueBuilder.LEFT_SEPARATOR.equals(str)) {
                ((IQMUILayout) view).updateLeftSeparatorColor(i);
                return;
            } else {
                if (QMUISkinValueBuilder.RIGHT_SEPARATOR.equals(str)) {
                    ((IQMUILayout) view).updateRightSeparatorColor(i);
                    return;
                }
                return;
            }
        }
        QMUISkinHelper.warnRuleNotSupport(view, str);
    }
}
