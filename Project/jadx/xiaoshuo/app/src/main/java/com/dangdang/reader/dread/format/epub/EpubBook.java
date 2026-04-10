package com.dangdang.reader.dread.format.epub;

import android.text.TextUtils;
import com.dangdang.reader.dread.format.Book;
import com.dangdang.reader.format.Chapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class EpubBook extends Book {
    private String mOpsPath;

    private boolean checkShortSrc(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.substring(str.lastIndexOf("/") + 1).equals(str2.substring(str2.lastIndexOf("/") + 1));
    }

    public EpubNavPoint findChapter(List<Book.BaseNavPoint> list, Chapter chapter) {
        EpubNavPoint epubNavPoint = null;
        for (Book.BaseNavPoint baseNavPoint : list) {
            if (chapter.getPath().equals(baseNavPoint.fullSrc) || baseNavPoint.fullSrc.contains(chapter.getPath())) {
                return (EpubNavPoint) baseNavPoint;
            }
            if (checkShortSrc(chapter.getPath(), baseNavPoint.fullSrc)) {
                return (EpubNavPoint) baseNavPoint;
            }
            List<Book.BaseNavPoint> list2 = baseNavPoint.subNavPs;
            if (list2 != null) {
                for (Book.BaseNavPoint baseNavPoint2 : list2) {
                    if (chapter.getPath().equals(baseNavPoint2.fullSrc) || baseNavPoint2.fullSrc.contains(chapter.getPath())) {
                        epubNavPoint = (EpubNavPoint) baseNavPoint2;
                        break;
                    }
                }
            }
        }
        return epubNavPoint;
    }

    @Override // com.dangdang.reader.dread.format.Book
    public List<Book.BaseNavPoint> getAllNavPointList() {
        if (this.mNavPointList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        for (Book.BaseNavPoint baseNavPoint : this.mNavPointList) {
            EpubNavPoint epubNavPoint = (EpubNavPoint) baseNavPoint;
            if (epubNavPoint.isPayTip()) {
                epubNavPoint.paytipIndex = i;
                i++;
            }
            arrayList.add(epubNavPoint);
            if (baseNavPoint.subNavPs != null) {
                Iterator<Book.BaseNavPoint> it = epubNavPoint.subNavPs.iterator();
                while (it.hasNext()) {
                    EpubNavPoint epubNavPoint2 = (EpubNavPoint) it.next();
                    epubNavPoint2.isSub = true;
                    if (epubNavPoint2.isPayTip()) {
                        epubNavPoint2.paytipIndex = i;
                        i++;
                    }
                    arrayList.add(epubNavPoint2);
                }
            }
        }
        return arrayList;
    }

    public String getOpsPath() {
        return this.mOpsPath;
    }

    public void setOpsPath(String str) {
        this.mOpsPath = str;
    }

    @Override // com.dangdang.reader.dread.format.Book
    public EpubNavPoint getNavPoint(Chapter chapter) {
        List<Book.BaseNavPoint> navPointList = getNavPointList();
        if (navPointList == null || chapter == null) {
            return null;
        }
        EpubNavPoint epubNavPointFindChapter = findChapter(navPointList, chapter);
        if (this.mChapterList != null) {
            while (epubNavPointFindChapter == null) {
                int iIndexOf = this.mChapterList.indexOf(chapter);
                if (iIndexOf >= this.mChapterList.size() || iIndexOf <= 0) {
                    break;
                }
                chapter = this.mChapterList.get(iIndexOf - 1);
                epubNavPointFindChapter = findChapter(navPointList, chapter);
            }
        }
        return epubNavPointFindChapter;
    }

    public static class EpubNavPoint extends Book.BaseNavPoint {
        public String anchor;
        public int chapterIndex;
        public String shortSrc;
        public boolean isSub = false;
        public int paytipIndex = 1;
        public int level = 0;

        public EpubNavPoint() {
        }

        public void addSubNavPoint(Book.BaseNavPoint baseNavPoint) {
            if (this.subNavPs == null) {
                this.subNavPs = new ArrayList();
            }
            this.subNavPs.add(baseNavPoint);
        }

        public String getAnchor() {
            return this.anchor;
        }

        public int getLevel() {
            return this.level;
        }

        public String getShortSrc() {
            return this.shortSrc;
        }

        public List<Book.BaseNavPoint> getSubNavPoint() {
            return this.subNavPs;
        }

        public boolean hasAnchor() {
            return !TextUtils.isEmpty(getAnchor());
        }

        public boolean isPayTip() {
            String str = this.shortSrc;
            if (str != null) {
                return str.toLowerCase().contains(Book.PAYTIP);
            }
            return false;
        }

        public void setAnchor(String str) {
            this.anchor = str;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setShortSrc(String str) {
            this.shortSrc = str;
        }

        public void setSubNavPoint(List<Book.BaseNavPoint> list) {
            this.subNavPs = list;
        }

        public boolean whetherHasSubs() {
            List<Book.BaseNavPoint> list = this.subNavPs;
            return (list == null || list.size() == 0) ? false : true;
        }

        public EpubNavPoint(String str, String str2, String str3) {
            this.lableText = str;
            this.fullSrc = str2;
            this.shortSrc = str3;
        }
    }
}
