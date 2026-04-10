package com.duokan.reader.domain.document;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RangeAnchor extends Anchor {
    public final boolean contains(RangeAnchor rangeAnchor) {
        if (rangeAnchor == null) {
            return false;
        }
        return getStartAnchor().isBeforeOrEqual(rangeAnchor.getStartAnchor()) && getEndAnchor().isAfterOrEqual(rangeAnchor.getEndAnchor());
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RangeAnchor rangeAnchor = (RangeAnchor) obj;
        return getStartAnchor().equals(rangeAnchor.getStartAnchor()) && getEndAnchor().equals(rangeAnchor.getEndAnchor());
    }

    public abstract PointAnchor getEndAnchor();

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsCalibrated() {
        return getIsStrong() && getIsPermanent() && getStartAnchor().getIsCalibrated() && getEndAnchor().getIsCalibrated();
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsPermanent() {
        return getIsStrong() && getStartAnchor().getIsPermanent() && getEndAnchor().getIsPermanent();
    }

    public abstract PointAnchor getStartAnchor();

    public final boolean intersects(RangeAnchor rangeAnchor) {
        PointAnchor startAnchor = getStartAnchor();
        PointAnchor endAnchor = getEndAnchor();
        PointAnchor startAnchor2 = rangeAnchor.getStartAnchor();
        PointAnchor endAnchor2 = rangeAnchor.getEndAnchor();
        if (startAnchor.isBefore(startAnchor2)) {
            startAnchor = startAnchor2;
        }
        if (!endAnchor.isBefore(endAnchor2)) {
            endAnchor = endAnchor2;
        }
        return startAnchor.isBefore(endAnchor);
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public final boolean isAfter(Anchor anchor) {
        return anchor instanceof PointAnchor ? getStartAnchor().isAfter((PointAnchor) anchor) : getStartAnchor().isAfter(((RangeAnchor) anchor).getStartAnchor());
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public final boolean isBefore(Anchor anchor) {
        return anchor instanceof PointAnchor ? getStartAnchor().isBefore((PointAnchor) anchor) : getStartAnchor().isBefore(((RangeAnchor) anchor).getStartAnchor());
    }

    public final boolean isEmpty() {
        PointAnchor endAnchor;
        PointAnchor startAnchor = getStartAnchor();
        return startAnchor == null || (endAnchor = getEndAnchor()) == null || startAnchor.isAfterOrEqual(endAnchor);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", getStartAnchor().toJson());
            jSONObject.put("end", getEndAnchor().toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final boolean contains(PointAnchor pointAnchor) {
        return getStartAnchor().isBeforeOrEqual(pointAnchor) && getEndAnchor().isAfter(pointAnchor);
    }
}
