package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.PageAnchor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TxtPageAnchor extends PageAnchor {
    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract TxtCharAnchor getEndAnchor();

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract TxtCharAnchor getStartAnchor();
}
