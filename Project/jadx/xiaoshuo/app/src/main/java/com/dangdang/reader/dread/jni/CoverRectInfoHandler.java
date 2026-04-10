package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.jni.BaseJniWarp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class CoverRectInfoHandler {
    private List<CoverRectInfo> mCoverRectInfos;

    public class CoverRectInfo {
        public boolean bCovered = true;
        public int color;
        public BaseJniWarp.ERect[] rects;

        public CoverRectInfo() {
        }
    }

    public List<CoverRectInfo> getCoverRectInfos() {
        return this.mCoverRectInfos;
    }

    public void init(int i) {
        this.mCoverRectInfos = new ArrayList();
    }

    public void setCoverRectInfo(boolean z, int i) {
        CoverRectInfo coverRectInfo = new CoverRectInfo();
        coverRectInfo.bCovered = z;
        coverRectInfo.color = i;
        this.mCoverRectInfos.add(coverRectInfo);
    }

    public void setRects(BaseJniWarp.ERect[] eRectArr) {
        this.mCoverRectInfos.get(r0.size() - 1).rects = eRectArr;
    }
}
