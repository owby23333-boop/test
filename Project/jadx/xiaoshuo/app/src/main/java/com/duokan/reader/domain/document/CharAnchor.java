package com.duokan.reader.domain.document;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CharAnchor extends PointAnchor {
    public abstract long getAtomIndex();

    public abstract long getByteOffset();

    public String getChapterId() {
        return "";
    }

    public abstract long getChapterIndex();

    public abstract long getParaIndex();
}
