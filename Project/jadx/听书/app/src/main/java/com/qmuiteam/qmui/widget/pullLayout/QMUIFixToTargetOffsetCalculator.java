package com.qmuiteam.qmui.widget.pullLayout;

import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIFixToTargetOffsetCalculator implements QMUIPullLayout.ActionViewOffsetCalculator {
    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator
    public int calculateOffset(QMUIPullLayout.PullAction pullAction, int i) {
        int actionInitOffset;
        if (i < pullAction.getTargetTriggerOffset()) {
            actionInitOffset = pullAction.getActionInitOffset();
        } else {
            i = pullAction.getTargetTriggerOffset();
            actionInitOffset = pullAction.getActionInitOffset();
        }
        return i + actionInitOffset;
    }
}
