package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.LruCache;
import com.qmuiteam.qmui.span.QMUITouchableSpan;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIQQFaceCompiler {
    private static final int SPAN_COLUMN = 2;
    private LruCache<CharSequence, ElementList> mCache = new LruCache<>(30);
    private IQMUIQQFaceManager mQQFaceManager;
    private static final Map<IQMUIQQFaceManager, QMUIQQFaceCompiler> sInstanceMap = new HashMap(4);
    private static IQMUIQQFaceManager sDefaultQQFaceManager = new QMUINoQQFaceManager();

    public enum ElementType {
        TEXT,
        DRAWABLE,
        SPECIAL_BOUNDS_DRAWABLE,
        SPAN,
        NEXTLINE
    }

    public static void setDefaultQQFaceManager(IQMUIQQFaceManager iQMUIQQFaceManager) {
        sDefaultQQFaceManager = iQMUIQQFaceManager;
    }

    public static QMUIQQFaceCompiler getDefaultInstance() {
        return getInstance(sDefaultQQFaceManager);
    }

    public static QMUIQQFaceCompiler getInstance(IQMUIQQFaceManager iQMUIQQFaceManager) {
        Map<IQMUIQQFaceManager, QMUIQQFaceCompiler> map = sInstanceMap;
        QMUIQQFaceCompiler qMUIQQFaceCompiler = map.get(iQMUIQQFaceManager);
        if (qMUIQQFaceCompiler != null) {
            return qMUIQQFaceCompiler;
        }
        QMUIQQFaceCompiler qMUIQQFaceCompiler2 = new QMUIQQFaceCompiler(iQMUIQQFaceManager);
        map.put(iQMUIQQFaceManager, qMUIQQFaceCompiler2);
        return qMUIQQFaceCompiler2;
    }

    private QMUIQQFaceCompiler(IQMUIQQFaceManager iQMUIQQFaceManager) {
        this.mQQFaceManager = iQMUIQQFaceManager;
    }

    public int getSpecialBoundsMaxHeight() {
        return this.mQQFaceManager.getSpecialDrawableMaxHeight();
    }

    public ElementList compile(CharSequence charSequence) {
        if (QMUILangHelper.isNullOrEmpty(charSequence)) {
            return null;
        }
        return compile(charSequence, 0, charSequence.length());
    }

    public ElementList compile(CharSequence charSequence, int i, int i2) {
        return compile(charSequence, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElementList compile(CharSequence charSequence, int i, int i2, boolean z) {
        QMUITouchableSpan[] qMUITouchableSpanArr;
        int[] iArr;
        int[] iArr2 = null;
        if (QMUILangHelper.isNullOrEmpty(charSequence)) {
            return null;
        }
        if (i < 0 || i >= charSequence.length()) {
            throw new IllegalArgumentException("start must >= 0 and < text.length");
        }
        if (i2 <= i) {
            throw new IllegalArgumentException("end must > start");
        }
        int length = charSequence.length();
        int i3 = i2 > length ? length : i2;
        int i4 = 0;
        if (z || !(charSequence instanceof Spannable)) {
            qMUITouchableSpanArr = null;
            iArr = null;
        } else {
            final Spannable spannable = (Spannable) charSequence;
            QMUITouchableSpan[] qMUITouchableSpanArr2 = (QMUITouchableSpan[]) spannable.getSpans(0, charSequence.length() - 1, QMUITouchableSpan.class);
            Arrays.sort(qMUITouchableSpanArr2, new Comparator<QMUITouchableSpan>() { // from class: com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler.1
                @Override // java.util.Comparator
                public int compare(QMUITouchableSpan qMUITouchableSpan, QMUITouchableSpan qMUITouchableSpan2) {
                    int spanStart = spannable.getSpanStart(qMUITouchableSpan);
                    int spanStart2 = spannable.getSpanStart(qMUITouchableSpan2);
                    if (spanStart > spanStart2) {
                        return 1;
                    }
                    return spanStart == spanStart2 ? 0 : -1;
                }
            });
            int i5 = qMUITouchableSpanArr2.length > 0 ? 1 : 0;
            if (i5 != 0) {
                iArr2 = new int[qMUITouchableSpanArr2.length * 2];
                while (i4 < qMUITouchableSpanArr2.length) {
                    int i6 = i4 * 2;
                    iArr2[i6] = spannable.getSpanStart(qMUITouchableSpanArr2[i4]);
                    iArr2[i6 + 1] = spannable.getSpanEnd(qMUITouchableSpanArr2[i4]);
                    i4++;
                }
            }
            iArr = iArr2;
            qMUITouchableSpanArr = qMUITouchableSpanArr2;
            i4 = i5;
        }
        ElementList elementList = this.mCache.get(charSequence);
        if (i4 == 0 && elementList != null && i == elementList.getStart() && i3 == elementList.getEnd()) {
            return elementList;
        }
        ElementList elementListRealCompile = realCompile(charSequence, i, i3, qMUITouchableSpanArr, iArr);
        if (i4 == 0 && !z) {
            this.mCache.put(charSequence, elementListRealCompile);
        }
        return elementListRealCompile;
    }

    public void setCache(LruCache<CharSequence, ElementList> lruCache) {
        this.mCache = lruCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler.ElementList realCompile(java.lang.CharSequence r18, int r19, int r20, com.qmuiteam.qmui.span.QMUITouchableSpan[] r21, int[] r22) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler.realCompile(java.lang.CharSequence, int, int, com.qmuiteam.qmui.span.QMUITouchableSpan[], int[]):com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementList");
    }

    public static class Element {
        private ElementList mChildList;
        private int mDrawableRes;
        private Drawable mSpecialBoundsDrawable;
        private CharSequence mText;
        private QMUITouchableSpan mTouchableSpan;
        private ElementType mType;

        public ElementType getType() {
            return this.mType;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public int getDrawableRes() {
            return this.mDrawableRes;
        }

        public ElementList getChildList() {
            return this.mChildList;
        }

        public QMUITouchableSpan getTouchableSpan() {
            return this.mTouchableSpan;
        }

        public Drawable getSpecialBoundsDrawable() {
            return this.mSpecialBoundsDrawable;
        }

        public static Element createTextElement(CharSequence charSequence) {
            Element element = new Element();
            element.mType = ElementType.TEXT;
            element.mText = charSequence;
            return element;
        }

        public static Element createDrawableElement(int i) {
            Element element = new Element();
            element.mType = ElementType.DRAWABLE;
            element.mDrawableRes = i;
            return element;
        }

        public static Element createSpeaicalBoundsDrawableElement(Drawable drawable) {
            Element element = new Element();
            element.mType = ElementType.SPECIAL_BOUNDS_DRAWABLE;
            element.mSpecialBoundsDrawable = drawable;
            return element;
        }

        public static Element createTouchSpanElement(CharSequence charSequence, QMUITouchableSpan qMUITouchableSpan, QMUIQQFaceCompiler qMUIQQFaceCompiler) {
            Element element = new Element();
            element.mType = ElementType.SPAN;
            element.mChildList = qMUIQQFaceCompiler.compile(charSequence, 0, charSequence.length(), true);
            element.mTouchableSpan = qMUITouchableSpan;
            return element;
        }

        public static Element createNextLineElement() {
            Element element = new Element();
            element.mType = ElementType.NEXTLINE;
            return element;
        }
    }

    public static class ElementList {
        private int mEnd;
        private int mStart;
        private int mQQFaceCount = 0;
        private int mNewLineCount = 0;
        private List<Element> mElements = new ArrayList();

        public ElementList(int i, int i2) {
            this.mStart = i;
            this.mEnd = i2;
        }

        public int getStart() {
            return this.mStart;
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getNewLineCount() {
            return this.mNewLineCount;
        }

        public int getQQFaceCount() {
            return this.mQQFaceCount;
        }

        public void add(Element element) {
            if (element.getType() == ElementType.DRAWABLE) {
                this.mQQFaceCount++;
            } else if (element.getType() == ElementType.NEXTLINE) {
                this.mNewLineCount++;
            } else if (element.getType() == ElementType.SPAN && element.getChildList() != null) {
                this.mQQFaceCount += element.getChildList().getQQFaceCount();
                this.mNewLineCount += element.getChildList().getNewLineCount();
            }
            this.mElements.add(element);
        }

        public List<Element> getElements() {
            return this.mElements;
        }
    }
}
