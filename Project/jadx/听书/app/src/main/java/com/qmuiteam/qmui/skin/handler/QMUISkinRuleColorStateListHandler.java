package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUISkinRuleColorStateListHandler implements IQMUISkinRuleHandler {
    protected abstract void handle(View view, String str, ColorStateList colorStateList);

    @Override // com.qmuiteam.qmui.skin.handler.IQMUISkinRuleHandler
    public final void handle(QMUISkinManager qMUISkinManager, View view, Resources.Theme theme, String str, int i) {
        handle(view, str, QMUIResHelper.getAttrColorStateList(view.getContext(), theme, i));
    }
}
