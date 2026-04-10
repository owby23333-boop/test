package com.dangdang.reader.dread.format;

import com.dangdang.reader.format.Chapter;
import com.dangdang.reader.utils.DReaderConstants;
import com.dangdang.zframework.log.LogM;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Book implements IBook {
    public static final String PAYTIP = "paytip";
    protected String mBookName;
    protected String mBookPath;
    protected List<Chapter> mChapterList;
    protected String mDecipherKey;
    protected List<BaseNavPoint> mNavPointList;
    protected int mPageCount;
    protected String mVersion;
    protected long mfileSize = 0;
    protected boolean mTheSameFile = true;
    protected String mModVersion = DReaderConstants.BOOK_MODIFY_VERSION;
    protected Map<String, Chapter> mChapterMap = new HashMap();

    public static class BaseNavPoint implements Serializable {
        public String fullSrc;
        public String lableText;
        private int pageIndex;
        public BaseNavPoint parentNav;
        public List<BaseNavPoint> subNavPs;

        public String getFullSrc() {
            return this.fullSrc;
        }

        public String getLableText() {
            return this.lableText;
        }

        public int getPageIndex() {
            return this.pageIndex;
        }

        public BaseNavPoint getParentNav() {
            return this.parentNav;
        }

        public List<BaseNavPoint> getSubNavPs() {
            return this.subNavPs;
        }

        public void setFullSrc(String str) {
            this.fullSrc = str;
        }

        public void setLableText(String str) {
            this.lableText = str;
        }

        public void setPageIndex(int i) {
            this.pageIndex = i;
        }

        public void setParentNav(BaseNavPoint baseNavPoint) {
            this.parentNav = baseNavPoint;
        }

        public void setSubNavPs(List<BaseNavPoint> list) {
            this.subNavPs = list;
        }
    }

    public void addPageRange(String str, Chapter chapter) {
        this.mChapterMap.put(str, chapter);
    }

    public int chapterIndexInBook(Chapter chapter) {
        try {
            return this.mChapterList.indexOf(chapter);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void clearAll() {
        this.mChapterMap.clear();
        List<BaseNavPoint> list = this.mNavPointList;
        if (list != null) {
            list.clear();
        }
    }

    public int compareChapterPageIndex(Chapter chapter, int i) {
        if (chapter == null) {
            return -1;
        }
        if (i < chapter.getStartIndexInBook() || i > chapter.getEndIndexInBook()) {
            return i < chapter.getStartIndexInBook() ? 1 : -1;
        }
        return 0;
    }

    public BaseNavPoint findSubNavPoint(int i, BaseNavPoint baseNavPoint, Chapter chapter) {
        List<BaseNavPoint> subNavPs = baseNavPoint.getSubNavPs();
        if (subNavPs == null || subNavPs.size() == 0) {
            return null;
        }
        int startIndexInBook = chapter.getStartIndexInBook();
        int size = subNavPs.size();
        int i2 = 0;
        while (i2 < size) {
            BaseNavPoint baseNavPoint2 = subNavPs.get(i2);
            int pageIndex = baseNavPoint2.getPageIndex() + startIndexInBook;
            i2++;
            if (i2 < size) {
                pageIndex = (subNavPs.get(i2).getPageIndex() - 1) + startIndexInBook;
            }
            if (i > startIndexInBook && i < pageIndex) {
                return baseNavPoint2;
            }
        }
        return null;
    }

    public List<BaseNavPoint> getAllNavPointList() {
        return this.mNavPointList;
    }

    public String getBookName() {
        return this.mBookName;
    }

    public String getBookPath() {
        return this.mBookPath;
    }

    public Chapter getChapter(int i) {
        try {
            List<Chapter> list = this.mChapterList;
            if (list == null) {
                return null;
            }
            if (i < 0) {
                i = 0;
            }
            if (i >= list.size()) {
                return null;
            }
            return this.mChapterList.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Chapter getChapterByPageIndex(int i) {
        for (Chapter chapter : this.mChapterList) {
            if (isChapterContainPageIndex(chapter, i)) {
                return chapter;
            }
        }
        return null;
    }

    public Chapter getChapterByPath(String str) {
        return this.mChapterMap.get(str);
    }

    public Chapter getChapterByShortSrc(String str) {
        String str2 = File.separator;
        if (!str.startsWith(str2)) {
            str = str2 + str;
        }
        for (Chapter chapter : this.mChapterList) {
            String path = chapter.getPath();
            if (path.indexOf(str) == path.length() - str.length()) {
                return chapter;
            }
        }
        return null;
    }

    public int getChapterIndexByShortSrc(String str) {
        String str2 = File.separator;
        if (!str.startsWith(str2)) {
            str = str2 + str;
        }
        Iterator<Chapter> it = this.mChapterList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String path = it.next().getPath();
            if (path.indexOf(str) == path.length() - str.length()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public List<Chapter> getChapterList() {
        return this.mChapterList;
    }

    public String getChapterName(int i) {
        Chapter chapter = getChapter(i);
        return chapter != null ? getChapterName(chapter) : "";
    }

    public int getChapterSize() {
        List<Chapter> list = this.mChapterList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public String getDecipherKey() {
        return this.mDecipherKey;
    }

    public long getFileSize() {
        return this.mfileSize;
    }

    public Chapter getLastChapter() {
        return getChapter(getChapterSize() - 1);
    }

    public String getModVersion() {
        return this.mModVersion;
    }

    public abstract BaseNavPoint getNavPoint(Chapter chapter);

    public BaseNavPoint getNavPoint(Chapter chapter, int i) {
        BaseNavPoint baseNavPointFindSubNavPoint;
        BaseNavPoint navPoint = getNavPoint(chapter);
        return (navPoint == null || (baseNavPointFindSubNavPoint = findSubNavPoint(i, navPoint)) == null) ? navPoint : baseNavPointFindSubNavPoint;
    }

    public List<BaseNavPoint> getNavPointList() {
        return this.mNavPointList;
    }

    @Override // com.dangdang.reader.dread.format.IBook
    public int getPageCount() {
        return this.mPageCount;
    }

    public int getPageIndexInBookAtBeforeHtml(Chapter chapter) {
        List<Chapter> chapterList;
        int iIndexOf;
        if (chapter == null || (chapterList = getChapterList()) == null || chapterList.indexOf(chapter) - 1 < 0) {
            return 0;
        }
        return chapterList.get(iIndexOf).getEndIndexInBook();
    }

    public Chapter getPageRange(String str) {
        if (this.mChapterMap.containsKey(str)) {
            return this.mChapterMap.get(str);
        }
        return null;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public boolean hasChapterList() {
        List<Chapter> list = this.mChapterList;
        return list != null && list.size() > 0;
    }

    public boolean hasExistsChapter(Chapter chapter) {
        int iIndexOf;
        try {
            iIndexOf = this.mChapterList.indexOf(chapter);
            if (iIndexOf == -1) {
                try {
                    String path = chapter.getPath();
                    int iLastIndexOf = path.lastIndexOf(File.separator);
                    if (iLastIndexOf != -1) {
                        path = path.substring(iLastIndexOf + 1, path.length());
                    }
                    iIndexOf = getChapterIndexByShortSrc(path);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e = e2;
            iIndexOf = 0;
        }
        return iIndexOf != -1;
    }

    public boolean isChapterContainPageIndex(Chapter chapter, int i) {
        return chapter != null && i >= chapter.getStartIndexInBook() && i <= chapter.getEndIndexInBook();
    }

    public boolean isFirstChapter(Chapter chapter) {
        List<Chapter> chapterList = getChapterList();
        return chapterList != null && chapter != null && chapterList.size() > 0 && chapter.equals(chapterList.get(0));
    }

    public boolean isLastChapter(Chapter chapter) {
        List<Chapter> chapterList = getChapterList();
        if (chapterList == null) {
            return false;
        }
        int size = chapterList.size();
        return chapter != null && size > 0 && chapter.equals(chapterList.get(size - 1));
    }

    public boolean isTheSameFile() {
        return this.mTheSameFile;
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }

    public void reSet() {
        this.mChapterMap.clear();
        this.mPageCount = 0;
    }

    public void setBookPath(String str) {
        this.mBookPath = str;
    }

    public void setChapterList(List<Chapter> list) {
        this.mChapterList = list;
    }

    public void setDecipherKey(String str) {
        this.mDecipherKey = str;
    }

    public void setFileSize(long j) {
        this.mfileSize = j;
    }

    public void setModVersion(String str) {
        this.mModVersion = str;
    }

    public void setNavPointList(List<BaseNavPoint> list) {
        this.mNavPointList = list;
    }

    public void setPageCount(int i) {
        this.mPageCount = i;
    }

    public void setTheSameFile(boolean z) {
        this.mTheSameFile = z;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public static class ResourceFile {
        public String dir;
        public boolean isEncrtyped;

        public ResourceFile(String str, boolean z) {
            this.dir = str;
            this.isEncrtyped = z;
        }

        public ResourceFile() {
        }
    }

    public String getChapterName(Chapter chapter) {
        BaseNavPoint navPoint;
        return (chapter == null || (navPoint = getNavPoint(chapter)) == null) ? "" : navPoint.lableText;
    }

    public BaseNavPoint getNavPoint(int i) {
        BaseNavPoint navPoint;
        BaseNavPoint baseNavPointFindSubNavPoint;
        Chapter chapterByPageIndex = getChapterByPageIndex(i);
        if (chapterByPageIndex != null) {
            navPoint = getNavPoint(chapterByPageIndex);
            if (navPoint != null && (baseNavPointFindSubNavPoint = findSubNavPoint(i, navPoint, chapterByPageIndex)) != null) {
                navPoint = baseNavPointFindSubNavPoint;
            }
        } else {
            navPoint = null;
        }
        if (navPoint == null) {
            LogM.e(getClass().getSimpleName(), " getNavPoint == null index=" + i);
        }
        return navPoint;
    }

    public BaseNavPoint findSubNavPoint(int i, BaseNavPoint baseNavPoint) {
        List<BaseNavPoint> subNavPs;
        if (baseNavPoint == null || (subNavPs = baseNavPoint.getSubNavPs()) == null || subNavPs.size() == 0) {
            return null;
        }
        int size = subNavPs.size();
        int i2 = 0;
        while (i2 < size) {
            BaseNavPoint baseNavPoint2 = subNavPs.get(i2);
            int pageIndex = baseNavPoint2.getPageIndex();
            i2++;
            if (i2 < size) {
                pageIndex = subNavPs.get(i2).getPageIndex();
            }
            if (i > 1 && i <= pageIndex) {
                return baseNavPoint2;
            }
        }
        return null;
    }
}
