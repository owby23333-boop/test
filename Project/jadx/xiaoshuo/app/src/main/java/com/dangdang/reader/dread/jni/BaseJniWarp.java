package com.dangdang.reader.dread.jni;

import android.graphics.Bitmap;
import com.dangdang.reader.format.Chapter;

/* JADX INFO: loaded from: classes10.dex */
public class BaseJniWarp {
    public static final int BOOKTYPE_DD_DRM_COMICS = 8;
    public static final int BOOKTYPE_DD_DRM_EPUB = 2;
    public static final int BOOKTYPE_DD_DRM_HTML = 7;
    public static final int BOOKTYPE_DD_DRM_SPEPUB = 6;
    public static final int BOOKTYPE_DD_PDF = 4;
    public static final int BOOKTYPE_DD_TXT = 3;
    public static final int BOOKTYPE_THIRD_EPUB = 1;
    protected static final int TTS_PARAGTEXT_LEN = 300;

    public static class EPageIndex {
        public String filePath;
        public int bookType = 0;
        public int pageIndexInChapter = 0;
        public int subIndexInPage = 0;
        public int startByte = -1;
        public int endByte = -1;
        public String chapterContent = "";
    }

    public static class EPoint {
        public float x;
        public float y;

        public boolean equals(Object obj) {
            if (!(obj instanceof EPoint)) {
                return super.equals(obj);
            }
            EPoint ePoint = (EPoint) obj;
            return ePoint.x == this.x && ePoint.y == this.y;
        }
    }

    public static class ERect {
        public float bottom;
        public float left;
        public float right;
        public float top;

        public ERect(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }
    }

    public static class ElementIndex {
        protected Chapter chapter;
        protected int elementIndex;

        public ElementIndex() {
        }

        public static ElementIndex max(ElementIndex elementIndex, ElementIndex elementIndex2) {
            return elementIndex.getIndex() > elementIndex2.getIndex() ? elementIndex : elementIndex2;
        }

        public static ElementIndex min(ElementIndex elementIndex, ElementIndex elementIndex2) {
            return elementIndex.getIndex() > elementIndex2.getIndex() ? elementIndex2 : elementIndex;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof ElementIndex) && ((ElementIndex) obj).getIndex() == getIndex();
        }

        public Chapter getChapter() {
            return this.chapter;
        }

        public int getIndex() {
            return this.elementIndex;
        }

        public void setChapter(Chapter chapter) {
            this.chapter = chapter;
        }

        public void setIndex(int i) {
            this.elementIndex = i;
        }

        public String toString() {
            return "[" + this.elementIndex + "]";
        }

        public ElementIndex(int i) {
            this.elementIndex = i;
        }

        public ElementIndex(int i, Chapter chapter) {
            this.elementIndex = i;
            this.chapter = chapter;
        }
    }

    static {
        System.loadLibrary("ddlayoutkit");
    }

    public static native String ConvertToGBorBig5(String str, int i);

    public static native void destoryData();

    public static int getCompVersion() {
        return 8;
    }

    public static int getKernelVersion() {
        return 8;
    }

    public static final native void initParseEngine(WrapClass wrapClass);

    public static native void setBig5Encoding(boolean z);

    public static final native void setScrollPagingMode(boolean z);

    public native int UpdateElementIndex(String str, String str2, String str3, int i);

    public native boolean addBasicFont(String str, String str2, String str3);

    public native boolean addGlobalFont(String str, String str2, String str3);

    public native boolean addPresetFont(String str, String str2, String str3, boolean z);

    public native void clearData();

    public final native boolean compareLineIndexOfTwoPoint(EPageIndex ePageIndex, EPoint ePoint, EPoint ePoint2);

    public final native int drawPage(EPageIndex ePageIndex, Bitmap bitmap);

    public final native int drawString(String str, boolean z, StringRenderHandler stringRenderHandler, int i, int i2, ERect eRect, float f, float f2);

    public final native int getChapterInfo(EPageIndex ePageIndex, ChaterInfoHandler chaterInfoHandler);

    public final native int getElementIndexByClickPoint(EPageIndex ePageIndex, EPoint ePoint);

    public final native int getElementIndexByPoint(EPageIndex ePageIndex, EPoint ePoint);

    public native String getExplain(String str);

    public final native int getPageByIndex(EPageIndex ePageIndex, int i);

    public final native int getPageCount(EPageIndex ePageIndex, boolean z);

    public final native int getPageScrollHeight(EPageIndex ePageIndex);

    public final native int[] getPageStartAndEndIndex(EPageIndex ePageIndex);

    public final native int[] getParaStartAndEndIndexByElement(EPageIndex ePageIndex, int i);

    public final native int getParagraphText(EPageIndex ePageIndex, int i, boolean z, boolean z2, int i2, ParagraphTextHandler paragraphTextHandler);

    public final native ERect[] getSelectedRectsByIndex(EPageIndex ePageIndex, int i, int i2);

    public final native ERect[] getSelectedRectsByPoint(EPageIndex ePageIndex, EPoint ePoint, EPoint ePoint2);

    public final native int[] getSelectedStartAndEndIndex(EPageIndex ePageIndex, EPoint ePoint, EPoint ePoint2);

    public final native String getText(EPageIndex ePageIndex, int i, int i2);

    public final native String[] getTextWithPara(EPageIndex ePageIndex, int i, int i2);

    public final native ERect[] getWordRectsByPoint(EPageIndex ePageIndex, EPoint ePoint);

    public final native boolean isInBookCache(EPageIndex ePageIndex);

    public final native boolean isInPageInfoCache(EPageIndex ePageIndex);

    public final native int layoutAndGetPageByIndex(EPageIndex ePageIndex, int i);

    public native void resetData();

    public final native int search(EPageIndex ePageIndex, String str, SearchHandler searchHandler);

    public native boolean setBkForeColor(int i, int i2);

    public native boolean setCurDefaultFont(String str, String str2, String str3);

    public final native void setDecryptAndUnzip(boolean z);

    public native void setDictPath(String str);

    public final native void setResourcePath(String str);

    public final native void setVaritionFontWeight(float f);
}
