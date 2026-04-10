package com.dangdang.reader.dread.data;

import com.dangdang.reader.dread.data.IFootprintData;

/* JADX INFO: loaded from: classes10.dex */
public class BookEnd implements IFootprintData {
    public long endTime;

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public long getAddTime() {
        return this.endTime;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public int getChapterIndex() {
        return 0;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public String getChapterName() {
        return null;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public String getContent() {
        return null;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public IFootprintData.CONTENT_TYPE getContentType() {
        return IFootprintData.CONTENT_TYPE.READEND;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public int getElementIndex() {
        return 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(IFootprintData iFootprintData) {
        return (int) (iFootprintData.getAddTime() - getAddTime());
    }
}
