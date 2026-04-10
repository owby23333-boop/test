package com.qmuiteam.qmui.widget.section;

import com.qmuiteam.qmui.widget.section.QMUISection.Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISection<H extends Model<H>, T extends Model<T>> {
    public static final int ITEM_INDEX_CUSTOM_OFFSET = -1000;
    public static final int ITEM_INDEX_INTERNAL_END = -4;
    public static final int ITEM_INDEX_LOAD_AFTER = -4;
    public static final int ITEM_INDEX_LOAD_BEFORE = -3;
    public static final int ITEM_INDEX_SECTION_HEADER = -2;
    public static final int ITEM_INDEX_UNKNOWN = -1;
    public static final int SECTION_INDEX_UNKNOWN = -1;
    private boolean mExistAfterDataToLoad;
    private boolean mExistBeforeDataToLoad;
    private H mHeader;
    private boolean mIsErrorToLoadAfter;
    private boolean mIsErrorToLoadBefore;
    private boolean mIsFold;
    private boolean mIsLocked;
    private ArrayList<T> mItemList;

    public interface Model<T> {
        T cloneForDiff();

        boolean isSameContent(T t);

        boolean isSameItem(T t);
    }

    public static final boolean isCustomItemIndex(int i) {
        return i < -4;
    }

    public QMUISection(H h, List<T> list) {
        this(h, list, false);
    }

    public QMUISection(H h, List<T> list, boolean z) {
        this(h, list, z, false, false, false);
    }

    public QMUISection(H h, List<T> list, boolean z, boolean z2, boolean z3, boolean z4) {
        this.mIsErrorToLoadBefore = false;
        this.mIsErrorToLoadAfter = false;
        this.mHeader = h;
        ArrayList<T> arrayList = new ArrayList<>();
        this.mItemList = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mIsFold = z;
        this.mIsLocked = z2;
        this.mExistBeforeDataToLoad = z3;
        this.mExistAfterDataToLoad = z4;
    }

    public H getHeader() {
        return this.mHeader;
    }

    public boolean isFold() {
        return this.mIsFold;
    }

    public void setFold(boolean z) {
        this.mIsFold = z;
    }

    public boolean isLocked() {
        return this.mIsLocked;
    }

    public void setLocked(boolean z) {
        this.mIsLocked = z;
    }

    public boolean isExistBeforeDataToLoad() {
        return this.mExistBeforeDataToLoad;
    }

    public void setExistBeforeDataToLoad(boolean z) {
        this.mExistBeforeDataToLoad = z;
    }

    public boolean isExistAfterDataToLoad() {
        return this.mExistAfterDataToLoad;
    }

    public void setExistAfterDataToLoad(boolean z) {
        this.mExistAfterDataToLoad = z;
    }

    public boolean isErrorToLoadBefore() {
        return this.mIsErrorToLoadBefore;
    }

    public void setErrorToLoadBefore(boolean z) {
        this.mIsErrorToLoadBefore = z;
    }

    public boolean isErrorToLoadAfter() {
        return this.mIsErrorToLoadAfter;
    }

    public void setErrorToLoadAfter(boolean z) {
        this.mIsErrorToLoadAfter = z;
    }

    public int getItemCount() {
        return this.mItemList.size();
    }

    public T getItemAt(int i) {
        if (i < 0 || i >= this.mItemList.size()) {
            return null;
        }
        return this.mItemList.get(i);
    }

    public boolean existItem(T t) {
        return this.mItemList.contains(t);
    }

    public void finishLoadMore(List<T> list, boolean z, boolean z2) {
        if (z) {
            if (list != null) {
                this.mItemList.addAll(0, list);
            }
            this.mExistBeforeDataToLoad = z2;
        } else {
            if (list != null) {
                this.mItemList.addAll(list);
            }
            this.mExistAfterDataToLoad = z2;
        }
    }

    public void cloneStatusTo(QMUISection<H, T> qMUISection) {
        qMUISection.mExistBeforeDataToLoad = this.mExistBeforeDataToLoad;
        qMUISection.mExistAfterDataToLoad = this.mExistAfterDataToLoad;
        qMUISection.mIsFold = this.mIsFold;
        qMUISection.mIsLocked = this.mIsLocked;
        qMUISection.mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
        qMUISection.mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
    }

    public QMUISection<H, T> mutate() {
        QMUISection<H, T> qMUISection = new QMUISection<>(this.mHeader, this.mItemList, this.mIsFold, this.mIsLocked, this.mExistBeforeDataToLoad, this.mExistAfterDataToLoad);
        qMUISection.mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
        qMUISection.mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
        return qMUISection;
    }

    public QMUISection<H, T> cloneForDiff() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().cloneForDiff());
        }
        QMUISection<H, T> qMUISection = new QMUISection<>((Model) this.mHeader.cloneForDiff(), arrayList, this.mIsFold, this.mIsLocked, this.mExistBeforeDataToLoad, this.mExistAfterDataToLoad);
        qMUISection.mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
        qMUISection.mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
        return qMUISection;
    }
}
