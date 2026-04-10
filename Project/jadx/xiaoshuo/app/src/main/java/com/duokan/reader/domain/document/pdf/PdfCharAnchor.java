package com.duokan.reader.domain.document.pdf;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.Anchor;
import com.duokan.reader.domain.document.CharAnchor;
import com.duokan.reader.domain.document.PointAnchor;
import com.duokan.reader.domain.document.RangeAnchor;
import com.yuewen.bc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PdfCharAnchor extends CharAnchor implements bc.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mAtomIndex;
    private final long mFixedIndex;
    private final long mNodeIndex;

    public PdfCharAnchor(long j, long j2, long j3) {
        this.mFixedIndex = j;
        this.mNodeIndex = j2;
        this.mAtomIndex = j3;
    }

    public static PdfCharAnchor valueOf(String str) {
        try {
            return valueOf(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PdfCharAnchor)) {
            return false;
        }
        PdfCharAnchor pdfCharAnchor = (PdfCharAnchor) obj;
        return this.mFixedIndex == pdfCharAnchor.mFixedIndex && this.mNodeIndex == pdfCharAnchor.mNodeIndex && this.mAtomIndex == pdfCharAnchor.mAtomIndex;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getAtomIndex() {
        return this.mAtomIndex;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getByteOffset() {
        return -1L;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getChapterIndex() {
        return getFixedIndex() + 1;
    }

    public DkFlowPosition getDkFlowPosition(DkpBook dkpBook) {
        return new DkFlowPosition(this.mFixedIndex + 1, this.mNodeIndex, this.mAtomIndex);
    }

    public long getFixedIndex() {
        return this.mFixedIndex;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsCalibrated() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsPermanent() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsValid() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsWeak() {
        return false;
    }

    public long getNodeIndex() {
        return this.mNodeIndex;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getParaIndex() {
        return getNodeIndex();
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isAfter(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isAfterOrEqual(((RangeAnchor) anchor).getEndAnchor());
        }
        PdfCharAnchor pdfCharAnchor = (PdfCharAnchor) anchor;
        long j = this.mFixedIndex;
        long j2 = pdfCharAnchor.mFixedIndex;
        if (j > j2) {
            return true;
        }
        if (j != j2 || this.mNodeIndex <= pdfCharAnchor.mNodeIndex) {
            return j == j2 && this.mNodeIndex == pdfCharAnchor.mNodeIndex && this.mAtomIndex > pdfCharAnchor.mAtomIndex;
        }
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isBefore(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isBefore(((RangeAnchor) anchor).getStartAnchor());
        }
        PdfCharAnchor pdfCharAnchor = (PdfCharAnchor) anchor;
        long j = this.mFixedIndex;
        long j2 = pdfCharAnchor.mFixedIndex;
        if (j < j2) {
            return true;
        }
        if (j != j2 || this.mNodeIndex >= pdfCharAnchor.mNodeIndex) {
            return j == j2 && this.mNodeIndex == pdfCharAnchor.mNodeIndex && this.mAtomIndex < pdfCharAnchor.mAtomIndex;
        }
        return true;
    }

    @Override // com.yuewen.bc.a
    public PointAnchor parsePointAnchor(JSONObject jSONObject) {
        return valueOf(jSONObject);
    }

    @Override // com.duokan.reader.domain.document.PointAnchor
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fixed_index", getFixedIndex());
            jSONObject.put("node_index", getNodeIndex());
            jSONObject.put("atom_index", getAtomIndex());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJson().toString();
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        return true;
    }

    public static PdfCharAnchor valueOf(JSONObject jSONObject) {
        try {
            return new PdfCharAnchor(jSONObject.optLong("fixed_index", 0L), jSONObject.optLong("node_index", 0L), jSONObject.optLong("atom_index", 0L));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
