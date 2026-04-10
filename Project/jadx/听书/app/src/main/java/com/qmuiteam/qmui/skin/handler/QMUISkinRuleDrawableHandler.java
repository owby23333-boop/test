package com.qmuiteam.qmui.skin.handler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUISkinRuleDrawableHandler implements IQMUISkinRuleHandler {
    protected abstract void handle(View view, String str, Drawable drawable);

    @Override // com.qmuiteam.qmui.skin.handler.IQMUISkinRuleHandler
    public final void handle(QMUISkinManager qMUISkinManager, View view, Resources.Theme theme, String str, int i) {
        handle(view, str, QMUIResHelper.getAttrDrawable(view.getContext(), theme, i));
    }
}
