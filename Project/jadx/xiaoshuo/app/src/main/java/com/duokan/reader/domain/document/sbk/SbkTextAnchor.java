package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.TextAnchor;

/* JADX INFO: loaded from: classes3.dex */
public class SbkTextAnchor extends TextAnchor {
    private final SbkCharAnchor mEndAnchor;
    private final SbkCharAnchor mStartAnchor;

    public SbkTextAnchor() {
        this(new SbkCharAnchor(0L, 0L, 0L), new SbkCharAnchor(0L, 0L, 0L));
    }

    public static SbkTextAnchor intersect(SbkTextAnchor sbkTextAnchor, SbkTextAnchor sbkTextAnchor2) {
        if (sbkTextAnchor.isEmpty() || sbkTextAnchor2.isEmpty()) {
            return sbkTextAnchor;
        }
        return new SbkTextAnchor(sbkTextAnchor.getStartAnchor().isBefore(sbkTextAnchor2.getStartAnchor()) ? sbkTextAnchor2.getStartAnchor() : sbkTextAnchor.getStartAnchor(), sbkTextAnchor.getEndAnchor().isBefore(sbkTextAnchor2.getEndAnchor()) ? sbkTextAnchor.getEndAnchor() : sbkTextAnchor2.getEndAnchor());
    }

    public static SbkTextAnchor union(SbkTextAnchor sbkTextAnchor, SbkTextAnchor sbkTextAnchor2) {
        if (sbkTextAnchor.isEmpty()) {
            return sbkTextAnchor2;
        }
        if (sbkTextAnchor2.isEmpty()) {
            return sbkTextAnchor;
        }
        return new SbkTextAnchor(sbkTextAnchor.getStartAnchor().isBefore(sbkTextAnchor2.getStartAnchor()) ? sbkTextAnchor.getStartAnchor() : sbkTextAnchor2.getStartAnchor(), sbkTextAnchor.getEndAnchor().isAfter(sbkTextAnchor2.getEndAnchor()) ? sbkTextAnchor.getEndAnchor() : sbkTextAnchor2.getEndAnchor());
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

    public SbkTextAnchor(SbkCharAnchor sbkCharAnchor, SbkCharAnchor sbkCharAnchor2) {
        this.mStartAnchor = sbkCharAnchor;
        this.mEndAnchor = sbkCharAnchor2;
    }

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public SbkCharAnchor getEndAnchor() {
        return this.mEndAnchor;
    }

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public SbkCharAnchor getStartAnchor() {
        return this.mStartAnchor;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        return true;
    }

    @Override // com.duokan.reader.domain.document.TextAnchor
    public TextAnchor intersect(TextAnchor textAnchor) {
        return intersect(this, (SbkTextAnchor) textAnchor);
    }

    @Override // com.duokan.reader.domain.document.TextAnchor
    public TextAnchor union(TextAnchor textAnchor) {
        return union(this, (SbkTextAnchor) textAnchor);
    }
}
