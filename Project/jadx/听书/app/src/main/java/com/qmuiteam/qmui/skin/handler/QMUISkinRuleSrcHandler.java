package com.qmuiteam.qmui.skin.handler;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleSrcHandler extends QMUISkinRuleDrawableHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleDrawableHandler
    protected void handle(View view, String str, Drawable drawable) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else if (view instanceof CompoundButton) {
            ((CompoundButton) view).setButtonDrawable(drawable);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
