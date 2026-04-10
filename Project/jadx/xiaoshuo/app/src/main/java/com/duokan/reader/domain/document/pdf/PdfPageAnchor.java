package com.duokan.reader.domain.document.pdf;

import com.duokan.reader.domain.document.PageAnchor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PdfPageAnchor extends PageAnchor {
    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract PdfCharAnchor getEndAnchor();

    @Override // com.duokan.reader.domain.document.RangeAnchor
    public abstract PdfCharAnchor getStartAnchor();
}
