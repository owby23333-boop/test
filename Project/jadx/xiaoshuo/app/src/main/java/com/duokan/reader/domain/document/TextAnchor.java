package com.duokan.reader.domain.document;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextAnchor extends RangeAnchor {
    public abstract TextAnchor intersect(TextAnchor textAnchor);

    public abstract TextAnchor union(TextAnchor textAnchor);
}
