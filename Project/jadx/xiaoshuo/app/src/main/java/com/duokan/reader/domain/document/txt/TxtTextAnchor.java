package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.TextAnchor;

/* JADX INFO: loaded from: classes3.dex */
public class TxtTextAnchor extends TextAnchor {
    private final TxtCharAnchor mEndAnchor;
    private final TxtCharAnchor mStartAnchor;

    public TxtTextAnchor() {
        this(new TxtCharAnchor(0L), new TxtCharAnchor(0L));
    }

    public static TxtTextAnchor intersect(TxtTextAnchor txtTextAnchor, TxtTextAnchor txtTextAnchor2) {
        if (txtTextAnchor.isEmpty() || txtTextAnchor2.isEmpty()) {
            return txtTextAnchor;
        }
        return new TxtTextAnchor(txtTextAnchor.getStartAnchor().isBefore(txtTextAnchor2.getStartAnchor()) ? txtTextAnchor2.getStartAnchor() : txtTextAnchor.getStartAnchor(), txtTextAnchor.getEndAnchor().isBefore(txtTextAnchor2.getEndAnchor()) ? txtTextAnchor.getEndAnchor() : txtTextAnchor2.getEndAnchor());
    }

    public static TxtTextAnchor union(TxtTextAnchor txtTextAnchor, TxtTextAnchor txtTextAnchor2) {
        if (txtTextAnchor.isEmpty()) {
            return txtTextAnchor2;
        }
        if (txtTextAnchor2.isEmpty()) {
            return txtTextAnchor;
        }
        return new TxtTextAnchor(txtTextAnchor.getStartAnchor().isBefore(txtTextAnchor2.getStartAnchor()) ? txtTextAnchor.getStartAnchor() : txtTextAnchor2.getStartAnchor(), txtTextAnchor.getEndAnchor().isAfter(txtTextAnchor2.getEndAnchor()) ? txtTextAnchor.getEndAnchor() : txtTextAnchor2.getEndAnchor());
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsValid() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsWeak() {
        return false;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong() {
        return true;
    }

    public TxtTextAnchor(TxtCharAnchor txtCharAnchor, TxtCharAnchor txtCharAnchor2) {
        this.mStartAnchor = txtCharAnchor;
        this.mEndAnchor = txtCharAnchor2;
    }

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public TxtCharAnchor getEndAnchor() {
        return this.mEndAnchor;
    }

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public TxtCharAnchor getStartAnchor() {
        return this.mStartAnchor;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        return true;
    }

    @Override // com.duokan.reader.domain.document.TextAnchor
    public TextAnchor intersect(TextAnchor textAnchor) {
        return intersect(this, (TxtTextAnchor) textAnchor);
    }

    @Override // com.duokan.reader.domain.document.TextAnchor
    public TextAnchor union(TextAnchor textAnchor) {
        return union(this, (TxtTextAnchor) textAnchor);
    }
}
