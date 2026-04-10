package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.PageAnchor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SbkPageAnchor extends PageAnchor {
    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract SbkCharAnchor getEndAnchor();

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract SbkCharAnchor getStartAnchor();
}
