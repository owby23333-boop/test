package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.Anchor;
import com.duokan.reader.domain.document.CharAnchor;
import com.duokan.reader.domain.document.PointAnchor;
import com.duokan.reader.domain.document.RangeAnchor;
import com.yuewen.bc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TxtCharAnchor extends CharAnchor implements bc.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mByteOffset;

    public TxtCharAnchor(long j) {
        this.mByteOffset = j;
    }

    public static TxtCharAnchor valueOf(String str) {
        try {
            return valueOf(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof TxtCharAnchor) && this.mByteOffset == ((TxtCharAnchor) obj).mByteOffset;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getAtomIndex() {
        return getByteOffset();
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getByteOffset() {
        return this.mByteOffset;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public String getChapterId() {
        return "";
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getChapterIndex() {
        return 1L;
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
        return 0L;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isAfter(Anchor anchor) {
        return anchor instanceof RangeAnchor ? isAfterOrEqual(((RangeAnchor) anchor).getEndAnchor()) : this.mByteOffset > ((TxtCharAnchor) anchor).mByteOffset;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isBefore(Anchor anchor) {
        return anchor instanceof RangeAnchor ? isBefore(((RangeAnchor) anchor).getStartAnchor()) : this.mByteOffset < ((TxtCharAnchor) anchor).mByteOffset;
    }

    @Override // com.yuewen.bc.a
    public PointAnchor parsePointAnchor(JSONObject jSONObject) {
        return valueOf(jSONObject);
    }

    @Override // com.duokan.reader.domain.document.PointAnchor
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("byte_offset", getByteOffset());
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

    public static TxtCharAnchor valueOf(JSONObject jSONObject) {
        try {
            return new TxtCharAnchor(jSONObject.optLong("byte_offset", -1L));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
