package com.qmuiteam.qmui.skin.handler;

import android.content.res.Resources;
import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUISkinRuleFloatHandler implements IQMUISkinRuleHandler {
    protected abstract void handle(View view, String str, float f);

    @Override // com.qmuiteam.qmui.skin.handler.IQMUISkinRuleHandler
    public final void handle(QMUISkinManager qMUISkinManager, View view, Resources.Theme theme, String str, int i) {
        handle(view, str, QMUIResHelper.getAttrFloatValue(theme, i));
    }
}
