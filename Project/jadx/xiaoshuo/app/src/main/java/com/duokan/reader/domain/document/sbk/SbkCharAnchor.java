package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.Anchor;
import com.duokan.reader.domain.document.CharAnchor;
import com.duokan.reader.domain.document.PointAnchor;
import com.duokan.reader.domain.document.RangeAnchor;
import com.yuewen.bc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SbkCharAnchor extends CharAnchor implements bc.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mAtomIndex;
    private final long mChapterIndex;
    private final long mParaIndex;

    public SbkCharAnchor(long j, long j2, long j3) {
        this.mChapterIndex = j;
        this.mParaIndex = j2;
        this.mAtomIndex = j3;
    }

    public static SbkCharAnchor valueOf(String str) {
        try {
            return valueOf(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SbkCharAnchor)) {
            return false;
        }
        SbkCharAnchor sbkCharAnchor = (SbkCharAnchor) obj;
        return this.mChapterIndex == sbkCharAnchor.mChapterIndex && this.mParaIndex == sbkCharAnchor.mParaIndex && this.mAtomIndex == sbkCharAnchor.mAtomIndex;
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
        return this.mChapterIndex;
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

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getParaIndex() {
        return this.mParaIndex;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isAfter(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isAfterOrEqual(((RangeAnchor) anchor).getEndAnchor());
        }
        SbkCharAnchor sbkCharAnchor = (SbkCharAnchor) anchor;
        long j = this.mChapterIndex;
        long j2 = sbkCharAnchor.mChapterIndex;
        if (j > j2) {
            return true;
        }
        if (j != j2 || this.mParaIndex <= sbkCharAnchor.mParaIndex) {
            return j == j2 && this.mParaIndex == sbkCharAnchor.mParaIndex && this.mAtomIndex > sbkCharAnchor.mAtomIndex;
        }
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isBefore(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isBefore(((RangeAnchor) anchor).getStartAnchor());
        }
        SbkCharAnchor sbkCharAnchor = (SbkCharAnchor) anchor;
        long j = this.mChapterIndex;
        long j2 = sbkCharAnchor.mChapterIndex;
        if (j < j2) {
            return true;
        }
        if (j != j2 || this.mParaIndex >= sbkCharAnchor.mParaIndex) {
            return j == j2 && this.mParaIndex == sbkCharAnchor.mParaIndex && this.mAtomIndex < sbkCharAnchor.mAtomIndex;
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
            jSONObject.put("chapter_index", getChapterIndex());
            jSONObject.put("para_index", getParaIndex());
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

    public static SbkCharAnchor valueOf(JSONObject jSONObject) {
        try {
            return new SbkCharAnchor(jSONObject.optLong("chapter_index", 0L), jSONObject.optLong("para_index", 0L), jSONObject.optLong("atom_index", 0L));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
