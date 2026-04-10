package com.qmuiteam.qmui.skin.handler;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.core.widget.ImageViewCompat;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleTintColorHandler extends QMUISkinRuleColorStateListHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof QMUILoadingView) {
            ((QMUILoadingView) view).setColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIPullRefreshLayout.RefreshView) {
            ((QMUIPullRefreshLayout.RefreshView) view).setColorSchemeColors(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof ImageView) {
            ImageViewCompat.setImageTintList((ImageView) view, colorStateList);
        } else if (view instanceof CompoundButton) {
            CompoundButtonCompat.setButtonTintList((CompoundButton) view, colorStateList);
        } else {
            QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
