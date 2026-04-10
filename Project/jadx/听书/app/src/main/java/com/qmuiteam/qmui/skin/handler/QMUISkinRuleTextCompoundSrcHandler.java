package com.qmuiteam.qmui.skin.handler;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleTextCompoundSrcHandler extends QMUISkinRuleDrawableHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleDrawableHandler
    protected void handle(View view, String str, Drawable drawable) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (QMUISkinValueBuilder.TEXT_COMPOUND_LEFT_SRC.equals(str)) {
                compoundDrawables[0] = drawable;
            } else if (QMUISkinValueBuilder.TEXT_COMPOUND_TOP_SRC.equals(str)) {
                compoundDrawables[1] = drawable;
            } else if (QMUISkinValueBuilder.TEXT_COMPOUND_RIGHT_SRC.equals(str)) {
                compoundDrawables[2] = drawable;
            } else if (QMUISkinValueBuilder.TEXT_COMPOUND_BOTTOM_SRC.equals(str)) {
                compoundDrawables[3] = drawable;
            }
            textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        QMUISkinHelper.warnRuleNotSupport(view, str);
    }
}
