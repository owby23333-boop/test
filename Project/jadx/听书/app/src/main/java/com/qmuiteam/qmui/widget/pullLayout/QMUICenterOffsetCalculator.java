package com.qmuiteam.qmui.widget.pullLayout;

import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUICenterOffsetCalculator implements QMUIPullLayout.ActionViewOffsetCalculator {
    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator
    public int calculateOffset(QMUIPullLayout.PullAction pullAction, int i) {
        if (i < pullAction.getTargetTriggerOffset()) {
            return i + pullAction.getActionInitOffset();
        }
        return (i - pullAction.getActionPullSize()) / 2;
    }
}
