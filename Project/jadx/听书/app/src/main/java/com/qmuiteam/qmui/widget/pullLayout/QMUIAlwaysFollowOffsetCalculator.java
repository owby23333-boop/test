package com.qmuiteam.qmui.widget.pullLayout;

import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIAlwaysFollowOffsetCalculator implements QMUIPullLayout.ActionViewOffsetCalculator {
    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator
    public int calculateOffset(QMUIPullLayout.PullAction pullAction, int i) {
        return i + pullAction.getActionInitOffset();
    }
}
