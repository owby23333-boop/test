package com.duokan.reader.domain.document.epub;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class EpubContentEntryData implements Serializable {
    private static final long serialVersionUID = 1;
    public String mTitle = "";
    public long mChapterIndex = 0;
    public EpubContentEntryData[] mChildEntries = new EpubContentEntryData[0];
}
