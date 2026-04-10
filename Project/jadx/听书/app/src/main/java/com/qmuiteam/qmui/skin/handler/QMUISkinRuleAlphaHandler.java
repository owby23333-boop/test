package com.qmuiteam.qmui.skin.handler;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinRuleAlphaHandler extends QMUISkinRuleFloatHandler {
    @Override // com.qmuiteam.qmui.skin.handler.QMUISkinRuleFloatHandler
    protected void handle(View view, String str, float f) {
        view.setAlpha(f);
    }
}
