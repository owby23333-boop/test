package com.qmuiteam.qmui.widget.section;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.DiffUtil;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUISection.Model;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISectionDiffCallback<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> extends DiffUtil.Callback {
    private boolean mRemoveSectionTitleIfOnlyOnceSection;
    private ArrayList<QMUISection<H, T>> mOldList = new ArrayList<>();
    private ArrayList<QMUISection<H, T>> mNewList = new ArrayList<>();
    private SparseIntArray mOldSectionIndex = new SparseIntArray();
    private SparseIntArray mOldItemIndex = new SparseIntArray();
    private SparseIntArray mNewSectionIndex = new SparseIntArray();
    private SparseIntArray mNewItemIndex = new SparseIntArray();

    protected boolean areCustomContentsTheSame(QMUISection<H, T> qMUISection, int i, QMUISection<H, T> qMUISection2, int i2) {
        return false;
    }

    protected void onGenerateCustomIndexAfterItemList(IndexGenerationInfo indexGenerationInfo, QMUISection<H, T> qMUISection, int i) {
    }

    protected void onGenerateCustomIndexAfterSectionList(IndexGenerationInfo indexGenerationInfo, List<QMUISection<H, T>> list) {
    }

    protected void onGenerateCustomIndexBeforeItemList(IndexGenerationInfo indexGenerationInfo, QMUISection<H, T> qMUISection, int i) {
    }

    protected void onGenerateCustomIndexBeforeSectionList(IndexGenerationInfo indexGenerationInfo, List<QMUISection<H, T>> list) {
    }

    public QMUISectionDiffCallback(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
        if (list != null) {
            this.mOldList.addAll(list);
        }
        if (list2 != null) {
            this.mNewList.addAll(list2);
        }
    }

    void generateIndex(boolean z) {
        this.mRemoveSectionTitleIfOnlyOnceSection = z;
        generateIndex(this.mOldList, this.mOldSectionIndex, this.mOldItemIndex, z);
        generateIndex(this.mNewList, this.mNewSectionIndex, this.mNewItemIndex, z);
    }

    public void cloneNewIndexTo(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        sparseIntArray.clear();
        sparseIntArray2.clear();
        for (int i = 0; i < this.mNewSectionIndex.size(); i++) {
            sparseIntArray.append(this.mNewSectionIndex.keyAt(i), this.mNewSectionIndex.valueAt(i));
        }
        for (int i2 = 0; i2 < this.mNewItemIndex.size(); i2++) {
            sparseIntArray2.append(this.mNewItemIndex.keyAt(i2), this.mNewItemIndex.valueAt(i2));
        }
    }

    private void generateIndex(List<QMUISection<H, T>> list, SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2, boolean z) {
        sparseIntArray.clear();
        sparseIntArray2.clear();
        IndexGenerationInfo indexGenerationInfo = new IndexGenerationInfo(sparseIntArray, sparseIntArray2);
        if (list.isEmpty() || !list.get(0).isLocked()) {
            onGenerateCustomIndexBeforeSectionList(indexGenerationInfo, list);
        }
        for (int i = 0; i < list.size(); i++) {
            QMUISection<H, T> qMUISection = list.get(i);
            if (!qMUISection.isLocked()) {
                if (!z || list.size() > 1) {
                    indexGenerationInfo.appendIndex(i, -2);
                }
                if (!qMUISection.isFold()) {
                    onGenerateCustomIndexBeforeItemList(indexGenerationInfo, qMUISection, i);
                    if (qMUISection.isExistBeforeDataToLoad()) {
                        indexGenerationInfo.appendIndex(i, -3);
                    }
                    for (int i2 = 0; i2 < qMUISection.getItemCount(); i2++) {
                        indexGenerationInfo.appendIndex(i, i2);
                    }
                    if (qMUISection.isExistAfterDataToLoad()) {
                        indexGenerationInfo.appendIndex(i, -4);
                    }
                    onGenerateCustomIndexAfterItemList(indexGenerationInfo, qMUISection, i);
                }
            }
        }
        if (list.isEmpty()) {
            onGenerateCustomIndexAfterSectionList(indexGenerationInfo, list);
            return;
        }
        QMUISection<H, T> qMUISection2 = list.get(list.size() - 1);
        if (qMUISection2.isLocked()) {
            return;
        }
        if (qMUISection2.isFold() || !qMUISection2.isExistAfterDataToLoad()) {
            onGenerateCustomIndexAfterSectionList(indexGenerationInfo, list);
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.mOldSectionIndex.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.mNewSectionIndex.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        int i3 = this.mOldSectionIndex.get(i);
        int i4 = this.mOldItemIndex.get(i);
        int i5 = this.mNewSectionIndex.get(i2);
        int i6 = this.mNewItemIndex.get(i2);
        if (i3 < 0 || i5 < 0) {
            return i3 == i5 && i4 == i6;
        }
        QMUISection<H, T> qMUISection = this.mOldList.get(i3);
        QMUISection<H, T> qMUISection2 = this.mNewList.get(i5);
        if (!qMUISection.getHeader().isSameItem(qMUISection2.getHeader())) {
            return false;
        }
        if (i4 < 0 && i4 == i6) {
            return true;
        }
        if (i4 < 0 || i6 < 0) {
            return false;
        }
        QMUISection.Model itemAt = qMUISection.getItemAt(i4);
        QMUISection.Model itemAt2 = qMUISection2.getItemAt(i6);
        if (itemAt == null && itemAt2 == null) {
            return true;
        }
        return (itemAt == null || itemAt2 == null || !itemAt.isSameItem(itemAt2)) ? false : true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        int i3 = this.mOldSectionIndex.get(i);
        int i4 = this.mOldItemIndex.get(i);
        int i5 = this.mNewSectionIndex.get(i2);
        int i6 = this.mNewItemIndex.get(i2);
        if (i5 < 0) {
            return areCustomContentsTheSame(null, i4, null, i6);
        }
        if (this.mRemoveSectionTitleIfOnlyOnceSection) {
            if (this.mOldList.size() == 1 && this.mNewList.size() != 1) {
                return false;
            }
            if (this.mOldList.size() != 1 && this.mNewList.size() == 1) {
                return false;
            }
        }
        QMUISection<H, T> qMUISection = this.mOldList.get(i3);
        QMUISection<H, T> qMUISection2 = this.mNewList.get(i5);
        if (i4 == -2) {
            return qMUISection.isFold() == qMUISection2.isFold() && qMUISection.getHeader().isSameContent(qMUISection2.getHeader());
        }
        if (i4 == -3 || i4 == -4) {
            return false;
        }
        if (QMUISection.isCustomItemIndex(i4)) {
            return areCustomContentsTheSame(qMUISection, i4, qMUISection2, i6);
        }
        QMUISection.Model itemAt = qMUISection.getItemAt(i4);
        QMUISection.Model itemAt2 = qMUISection2.getItemAt(i6);
        return (itemAt == null && itemAt2 == null) || !(itemAt == null || itemAt2 == null || !itemAt.isSameContent(itemAt2));
    }

    public static class IndexGenerationInfo {
        private int currentPosition;
        private SparseIntArray itemIndexArray;
        private SparseIntArray sectionIndexArray;

        private IndexGenerationInfo(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
            this.sectionIndexArray = sparseIntArray;
            this.itemIndexArray = sparseIntArray2;
            this.currentPosition = 0;
        }

        public final void appendCustomIndex(int i, int i2) {
            int i3 = i2 - 1000;
            if (!QMUISection.isCustomItemIndex(i3)) {
                throw new IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
            }
            appendIndex(i, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void appendIndex(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("use appendWholeListCustomIndex for whole list");
            }
            this.sectionIndexArray.append(this.currentPosition, i);
            this.itemIndexArray.append(this.currentPosition, i2);
            this.currentPosition++;
        }

        public final void appendWholeListCustomIndex(int i) {
            int i2 = i - 1000;
            if (!QMUISection.isCustomItemIndex(i2)) {
                throw new IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
            }
            appendWholeListIndex(i2);
        }

        private final void appendWholeListIndex(int i) {
            this.sectionIndexArray.append(this.currentPosition, -1);
            this.itemIndexArray.append(this.currentPosition, i);
            this.currentPosition++;
        }
    }
}
