package com.duokan.kernel.ddlib;

import android.text.TextUtils;
import com.dangdang.reader.dread.format.Book;
import com.dangdang.reader.dread.format.epub.EpubBook;
import com.duokan.kernel.epublib.DKETocPointWrapper;
import com.duokan.kernel.epublib.DKFlowPosition;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class DdTocPointWrapper extends DKETocPointWrapper {
    private final List<Book.BaseNavPoint> mDdChildNavs;
    private final EpubBook.EpubNavPoint mDdCurNav;

    public DdTocPointWrapper(EpubBook.EpubNavPoint epubNavPoint, List<Book.BaseNavPoint> list) {
        super(0L);
        this.mDdCurNav = epubNavPoint;
        this.mDdChildNavs = list;
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public long GetChildByIndex(int i) {
        return 0L;
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public long GetChildCount() {
        return this.mDdChildNavs.size();
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public int GetDepth() {
        EpubBook.EpubNavPoint epubNavPoint = this.mDdCurNav;
        if (epubNavPoint == null) {
            return 0;
        }
        return epubNavPoint.getLevel();
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public String GetDest() {
        EpubBook.EpubNavPoint epubNavPoint = this.mDdCurNav;
        return epubNavPoint == null ? "" : epubNavPoint.getAnchor();
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public boolean GetDestPosition(DKFlowPosition dKFlowPosition) {
        if (this.mDdCurNav == null) {
            return false;
        }
        dKFlowPosition.chapterIndex = r0.chapterIndex;
        dKFlowPosition.atomIndex = 0L;
        dKFlowPosition.paraIndex = 0L;
        return true;
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public String GetTitle() {
        EpubBook.EpubNavPoint epubNavPoint = this.mDdCurNav;
        return epubNavPoint == null ? "" : epubNavPoint.getLableText();
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public boolean IsContentValid() {
        return !this.mDdCurNav.isPayTip();
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public DKETocPointWrapper getChildByIndexEx(int i) {
        EpubBook.EpubNavPoint epubNavPoint = (EpubBook.EpubNavPoint) this.mDdChildNavs.get(i);
        return new DdTocPointWrapper(epubNavPoint, epubNavPoint.getSubNavPs() == null ? Collections.EMPTY_LIST : epubNavPoint.getSubNavPs());
    }

    @Override // com.duokan.kernel.epublib.DKETocPointWrapper
    public String getDestPortionId() {
        EpubBook.EpubNavPoint epubNavPoint = this.mDdCurNav;
        if (epubNavPoint == null) {
            return "";
        }
        String anchor = epubNavPoint.getAnchor();
        return TextUtils.isEmpty(anchor) ? "" : anchor;
    }
}
