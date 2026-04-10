package com.duokan.kernel.pdflib;

import com.duokan.kernel.DkBox;

/* JADX INFO: loaded from: classes11.dex */
public class DkpFlowParserOption {
    public DkBox mPageBox = new DkBox(0.0f, 0.0f, 0.0f, 0.0f);
    public DkBox mOddSubPageBox = new DkBox(0.0f, 0.0f, 1.0f, 1.0f);
    public DkBox mEvenSubPageBox = new DkBox(0.0f, 0.0f, 1.0f, 1.0f);
    public float mScale = 1.0f;
    public float mLineGap = 1.0f;
    public float mParaSpacing = 1.0f;
    public boolean mFastMode = false;

    public boolean equals(Object obj) {
        DkpFlowParserOption dkpFlowParserOption = (DkpFlowParserOption) obj;
        return this.mPageBox.equals(dkpFlowParserOption.mPageBox) && this.mOddSubPageBox.equals(dkpFlowParserOption.mOddSubPageBox) && this.mEvenSubPageBox.equals(dkpFlowParserOption.mEvenSubPageBox) && Float.compare(this.mScale, dkpFlowParserOption.mScale) == 0 && Float.compare(this.mLineGap, dkpFlowParserOption.mLineGap) == 0 && Float.compare(this.mParaSpacing, dkpFlowParserOption.mParaSpacing) == 0 && this.mFastMode == dkpFlowParserOption.mFastMode;
    }
}
