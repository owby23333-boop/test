package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.view.TintableBackgroundView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleBgTintColorHandler extends QMUISkinRuleColorStateListHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
