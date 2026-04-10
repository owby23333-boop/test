package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2) {
        int i3;
        int i4;
        ChainHead[] chainHeadArr;
        if (i2 == 0) {
            int i5 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i4 = i5;
            i3 = 0;
        } else {
            i3 = 2;
            i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i2, i3, chainHead);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a A[PHI: r8 r14
  0x004a: PHI (r8v4 boolean) = (r8v2 boolean), (r8v48 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r14v4 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c A[PHI: r8 r14
  0x004c: PHI (r8v45 boolean) = (r8v2 boolean), (r8v48 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x004c: PHI (r14v16 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            Method dump skipped, instruction units count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
