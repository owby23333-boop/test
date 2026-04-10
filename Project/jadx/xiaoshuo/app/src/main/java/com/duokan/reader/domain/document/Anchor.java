package com.duokan.reader.domain.document;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Anchor implements Serializable {
    public abstract boolean getIsCalibrated();

    public abstract boolean getIsPermanent();

    public final boolean getIsStrong() {
        return !getIsWeak();
    }

    public abstract boolean getIsValid();

    public abstract boolean getIsWeak();

    public abstract boolean isAfter(Anchor anchor);

    public boolean isAfterOrEqual(Anchor anchor) {
        return isAfter(anchor) || equals(anchor);
    }

    public abstract boolean isBefore(Anchor anchor);

    public boolean isBeforeOrEqual(Anchor anchor) {
        return isBefore(anchor) || equals(anchor);
    }

    public abstract boolean waitForStrong();

    public abstract boolean waitForStrong(long j);
}
