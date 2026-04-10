package com.qmuiteam.qmui.widget.section;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUISection.Model;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIStickySectionAdapter<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
    public static final int ITEM_TYPE_CUSTOM_OFFSET = 1000;
    public static final int ITEM_TYPE_SECTION_HEADER = 0;
    public static final int ITEM_TYPE_SECTION_ITEM = 1;
    public static final int ITEM_TYPE_SECTION_LOADING = 2;
    public static final int ITEM_TYPE_UNKNOWN = -1;
    private static final String TAG = "StickySectionAdapter";
    private List<QMUISection<H, T>> mBackupData;
    private Callback<H, T> mCallback;
    private List<QMUISection<H, T>> mCurrentData;
    private SparseIntArray mItemIndex;
    private ArrayList<QMUISection<H, T>> mLoadingAfterSections;
    private ArrayList<QMUISection<H, T>> mLoadingBeforeSections;
    private final boolean mRemoveSectionTitleIfOnlyOneSection;
    private SparseIntArray mSectionIndex;
    private ViewCallback mViewCallback;

    public interface Callback<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> {
        void loadMore(QMUISection<H, T> qMUISection, boolean z);

        void onItemClick(ViewHolder viewHolder, int i);

        boolean onItemLongClick(ViewHolder viewHolder, int i);
    }

    public interface PositionFinder<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> {
        boolean find(QMUISection<H, T> qMUISection, T t);
    }

    public interface ViewCallback {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition(int i);

        void requestChildFocus(View view);

        void scrollToPosition(int i, boolean z, boolean z2);
    }

    protected void beforeDiffInSet(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
    }

    protected int getCustomItemViewType(int i, int i2) {
        return -1;
    }

    protected void onBindCustomItem(VH vh, int i, QMUISection<H, T> qMUISection, int i2) {
    }

    protected void onBindSectionHeader(VH vh, int i, QMUISection<H, T> qMUISection) {
    }

    protected void onBindSectionItem(VH vh, int i, QMUISection<H, T> qMUISection, int i2) {
    }

    protected void onBindSectionLoadingItem(VH vh, int i, QMUISection<H, T> qMUISection, boolean z) {
    }

    protected abstract VH onCreateCustomItemViewHolder(ViewGroup viewGroup, int i);

    protected abstract VH onCreateSectionHeaderViewHolder(ViewGroup viewGroup);

    protected abstract VH onCreateSectionItemViewHolder(ViewGroup viewGroup);

    protected abstract VH onCreateSectionLoadingViewHolder(ViewGroup viewGroup);

    public QMUIStickySectionAdapter() {
        this(false);
    }

    public QMUIStickySectionAdapter(boolean z) {
        this.mBackupData = new ArrayList();
        this.mCurrentData = new ArrayList();
        this.mSectionIndex = new SparseIntArray();
        this.mItemIndex = new SparseIntArray();
        this.mLoadingBeforeSections = new ArrayList<>(2);
        this.mLoadingAfterSections = new ArrayList<>(2);
        this.mRemoveSectionTitleIfOnlyOneSection = z;
    }

    public final void setData(List<QMUISection<H, T>> list) {
        setData(list, true);
    }

    public final void setData(List<QMUISection<H, T>> list, boolean z) {
        setData(list, z, true);
    }

    public final void setData(List<QMUISection<H, T>> list, boolean z, boolean z2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (list != null) {
            this.mCurrentData.addAll(list);
        }
        beforeDiffInSet(this.mBackupData, this.mCurrentData);
        if (!this.mCurrentData.isEmpty() && z2) {
            lock(this.mCurrentData.get(0));
        }
        diff(true, z);
    }

    public final void setDataWithoutDiff(List<QMUISection<H, T>> list, boolean z) {
        setDataWithoutDiff(list, z, true);
    }

    public final void setDataWithoutDiff(List<QMUISection<H, T>> list, boolean z, boolean z2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (list != null) {
            this.mCurrentData.addAll(list);
        }
        if (z2 && !this.mCurrentData.isEmpty()) {
            lock(this.mCurrentData.get(0));
        }
        QMUISectionDiffCallback<H, T> qMUISectionDiffCallbackCreateDiffCallback = createDiffCallback(this.mBackupData, this.mCurrentData);
        qMUISectionDiffCallbackCreateDiffCallback.generateIndex(this.mRemoveSectionTitleIfOnlyOneSection);
        qMUISectionDiffCallbackCreateDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        notifyDataSetChanged();
        this.mBackupData.clear();
        for (QMUISection<H, T> qMUISection : this.mCurrentData) {
            this.mBackupData.add(z ? qMUISection.mutate() : qMUISection.cloneForDiff());
        }
    }

    private void diff(boolean z, boolean z2) {
        QMUISectionDiffCallback<H, T> qMUISectionDiffCallbackCreateDiffCallback = createDiffCallback(this.mBackupData, this.mCurrentData);
        qMUISectionDiffCallbackCreateDiffCallback.generateIndex(this.mRemoveSectionTitleIfOnlyOneSection);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(qMUISectionDiffCallbackCreateDiffCallback, false);
        qMUISectionDiffCallbackCreateDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        if (z || this.mBackupData.size() != this.mCurrentData.size()) {
            this.mBackupData.clear();
            for (QMUISection<H, T> qMUISection : this.mCurrentData) {
                this.mBackupData.add(z2 ? qMUISection.mutate() : qMUISection.cloneForDiff());
            }
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            this.mCurrentData.get(i).cloneStatusTo(this.mBackupData.get(i));
        }
    }

    public void refreshCustomData() {
        QMUISectionDiffCallback<H, T> qMUISectionDiffCallbackCreateDiffCallback = createDiffCallback(this.mBackupData, this.mCurrentData);
        qMUISectionDiffCallbackCreateDiffCallback.generateIndex(this.mRemoveSectionTitleIfOnlyOneSection);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(qMUISectionDiffCallbackCreateDiffCallback, false);
        qMUISectionDiffCallbackCreateDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    protected QMUISectionDiffCallback<H, T> createDiffCallback(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
        return new QMUISectionDiffCallback<>(list, list2);
    }

    public void setCallback(Callback<H, T> callback) {
        this.mCallback = callback;
    }

    void setViewCallback(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    public int getSectionCount() {
        return this.mCurrentData.size();
    }

    public int getItemIndex(int i) {
        if (i < 0 || i >= this.mItemIndex.size()) {
            return -1;
        }
        return this.mItemIndex.get(i);
    }

    public int getSectionIndex(int i) {
        if (i < 0 || i >= this.mSectionIndex.size()) {
            return -1;
        }
        return this.mSectionIndex.get(i);
    }

    public QMUISection<H, T> getSection(int i) {
        int i2;
        if (i < 0 || i >= this.mSectionIndex.size() || (i2 = this.mSectionIndex.get(i)) < 0 || i2 >= this.mCurrentData.size()) {
            return null;
        }
        return this.mCurrentData.get(i2);
    }

    public QMUISection<H, T> getSectionDirectly(int i) {
        if (i < 0 || i >= this.mCurrentData.size()) {
            return null;
        }
        return this.mCurrentData.get(i);
    }

    public boolean isSectionFold(int i) {
        QMUISection<H, T> section = getSection(i);
        if (section == null) {
            return false;
        }
        return section.isFold();
    }

    public T getSectionItem(int i) {
        QMUISection<H, T> section;
        int itemIndex = getItemIndex(i);
        if (itemIndex >= 0 && (section = getSection(i)) != null) {
            return (T) section.getItemAt(itemIndex);
        }
        return null;
    }

    public void finishLoadMore(QMUISection<H, T> qMUISection, List<T> list, boolean z, boolean z2) {
        if (z) {
            this.mLoadingBeforeSections.remove(qMUISection);
        } else {
            this.mLoadingAfterSections.remove(qMUISection);
        }
        if (this.mCurrentData.indexOf(qMUISection) < 0) {
            return;
        }
        if (z && !qMUISection.isFold()) {
            int i = 0;
            while (true) {
                if (i >= this.mItemIndex.size()) {
                    break;
                }
                int iKeyAt = this.mItemIndex.keyAt(i);
                if (this.mItemIndex.valueAt(i) == 0 && qMUISection == getSection(iKeyAt)) {
                    ViewCallback viewCallback = this.mViewCallback;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = viewCallback == null ? null : viewCallback.findViewHolderForAdapterPosition(iKeyAt);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        this.mViewCallback.requestChildFocus(viewHolderFindViewHolderForAdapterPosition.itemView);
                    }
                } else {
                    i++;
                }
            }
        }
        qMUISection.finishLoadMore(list, z, z2);
        lock(qMUISection);
        diff(true, true);
    }

    private void lock(QMUISection<H, T> qMUISection) {
        boolean z = (qMUISection.isFold() || !qMUISection.isExistBeforeDataToLoad() || qMUISection.isErrorToLoadBefore()) ? false : true;
        boolean z2 = (qMUISection.isFold() || !qMUISection.isExistAfterDataToLoad() || qMUISection.isErrorToLoadAfter()) ? false : true;
        int iIndexOf = this.mCurrentData.indexOf(qMUISection);
        if (iIndexOf < 0 || iIndexOf >= this.mCurrentData.size()) {
            return;
        }
        qMUISection.setLocked(false);
        lockBefore(iIndexOf - 1, z);
        lockAfter(iIndexOf + 1, z2);
    }

    private void lockBefore(int i, boolean z) {
        while (i >= 0) {
            QMUISection<H, T> qMUISection = this.mCurrentData.get(i);
            if (z) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                z = (qMUISection.isFold() || !qMUISection.isExistBeforeDataToLoad() || qMUISection.isErrorToLoadBefore()) ? false : true;
            }
            i--;
        }
    }

    private void lockAfter(int i, boolean z) {
        while (i < this.mCurrentData.size()) {
            QMUISection<H, T> qMUISection = this.mCurrentData.get(i);
            if (z) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                z = (qMUISection.isFold() || !qMUISection.isExistAfterDataToLoad() || qMUISection.isErrorToLoadAfter()) ? false : true;
            }
            i++;
        }
    }

    public void scrollToSectionHeader(QMUISection<H, T> qMUISection, boolean z) {
        if (this.mViewCallback == null) {
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            QMUISection<H, T> qMUISection2 = this.mCurrentData.get(i);
            if (qMUISection.getHeader().isSameItem(qMUISection2.getHeader())) {
                if (qMUISection2.isLocked()) {
                    lock(qMUISection2);
                    diff(false, true);
                    safeScrollToSection(qMUISection2, z);
                    return;
                }
                safeScrollToSection(qMUISection2, z);
                return;
            }
        }
    }

    private void safeScrollToSection(QMUISection<H, T> qMUISection, boolean z) {
        for (int i = 0; i < this.mSectionIndex.size(); i++) {
            int iKeyAt = this.mSectionIndex.keyAt(i);
            int iValueAt = this.mSectionIndex.valueAt(i);
            if (iValueAt >= 0 && iValueAt < this.mCurrentData.size() && this.mItemIndex.get(iKeyAt) == -2 && this.mCurrentData.get(iValueAt).getHeader().isSameItem(qMUISection.getHeader())) {
                this.mViewCallback.scrollToPosition(iKeyAt, true, z);
                return;
            }
        }
    }

    public void scrollToSectionItem(QMUISection<H, T> qMUISection, T t, boolean z) {
        if (this.mViewCallback == null) {
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            QMUISection<H, T> qMUISection2 = this.mCurrentData.get(i);
            if ((qMUISection == null && qMUISection2.existItem(t)) || qMUISection == qMUISection2) {
                if (qMUISection2.isFold() || qMUISection2.isLocked()) {
                    qMUISection2.setFold(false);
                    lock(qMUISection2);
                    diff(false, true);
                    safeScrollToSectionItem(qMUISection2, t, z);
                    return;
                }
                safeScrollToSectionItem(qMUISection2, t, z);
                return;
            }
        }
    }

    private void safeScrollToSectionItem(QMUISection<H, T> qMUISection, T t, boolean z) {
        QMUISection<H, T> section;
        for (int i = 0; i < this.mItemIndex.size(); i++) {
            int iKeyAt = this.mItemIndex.keyAt(i);
            int iValueAt = this.mItemIndex.valueAt(i);
            if (iValueAt >= 0 && (section = getSection(iKeyAt)) == qMUISection && section.getItemAt(iValueAt).isSameItem(t)) {
                this.mViewCallback.scrollToPosition(iKeyAt, false, z);
                return;
            }
        }
    }

    public int findCustomPosition(int i, int i2, boolean z) {
        return findPosition(i, i2 - 1000, z);
    }

    public int findPosition(int i, int i2, boolean z) {
        QMUISection<H, T> qMUISection;
        if (z && i >= 0 && (qMUISection = this.mCurrentData.get(i)) != null && qMUISection.isFold()) {
            qMUISection.setFold(false);
            lock(qMUISection);
            diff(false, true);
        }
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            if (this.mSectionIndex.get(i3) == i && this.mItemIndex.get(i3) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public int findPosition(PositionFinder<H, T> positionFinder, boolean z) {
        Object obj;
        Object itemAt = null;
        int i = 0;
        if (!z) {
            while (i < getItemCount()) {
                QMUISection<H, T> section = getSection(i);
                if (section != null) {
                    int itemIndex = getItemIndex(i);
                    if (itemIndex == -2) {
                        if (positionFinder.find(section, null)) {
                            return i;
                        }
                    } else if (itemIndex >= 0 && positionFinder.find(section, section.getItemAt(itemIndex))) {
                        return i;
                    }
                }
                i++;
            }
            return -1;
        }
        for (int i2 = 0; i2 < this.mCurrentData.size(); i2++) {
            QMUISection<H, T> qMUISection = this.mCurrentData.get(i2);
            if (!positionFinder.find(qMUISection, null)) {
                for (int i3 = 0; i3 < qMUISection.getItemCount(); i3++) {
                    if (positionFinder.find(qMUISection, qMUISection.getItemAt(i3))) {
                        itemAt = qMUISection.getItemAt(i3);
                        if (qMUISection.isFold()) {
                            qMUISection.setFold(false);
                            lock(qMUISection);
                            diff(false, true);
                        }
                    }
                }
            }
            obj = itemAt;
            itemAt = qMUISection;
        }
        obj = null;
        while (i < getItemCount()) {
            QMUISection<H, T> section2 = getSection(i);
            if (section2 == itemAt) {
                int itemIndex2 = getItemIndex(i);
                if (itemIndex2 == -2 && obj == null) {
                    return i;
                }
                if (itemIndex2 >= 0 && section2.getItemAt(itemIndex2).isSameItem(obj)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public void toggleFold(int i, boolean z) {
        QMUISection<H, T> section = getSection(i);
        if (section == null) {
            return;
        }
        section.setFold(!section.isFold());
        lock(section);
        diff(false, true);
        if (!z || section.isFold() || this.mViewCallback == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mSectionIndex.size(); i2++) {
            int iKeyAt = this.mSectionIndex.keyAt(i2);
            if (getItemIndex(iKeyAt) == -2 && getSection(iKeyAt) == section) {
                this.mViewCallback.scrollToPosition(iKeyAt, true, true);
                return;
            }
        }
    }

    public int getRelativeStickyPosition(int i) {
        while (getItemViewType(i) != 0) {
            i--;
            if (i < 0) {
                return -1;
            }
        }
        return i;
    }

    public boolean isRemoveSectionTitleIfOnlyOneSection() {
        return this.mRemoveSectionTitleIfOnlyOneSection;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.mItemIndex.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return (VH) onCreateSectionHeaderViewHolder(viewGroup);
        }
        if (i == 1) {
            return (VH) onCreateSectionItemViewHolder(viewGroup);
        }
        if (i == 2) {
            return (VH) onCreateSectionLoadingViewHolder(viewGroup);
        }
        return (VH) onCreateCustomItemViewHolder(viewGroup, i - 1000);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final VH vh, final int i) {
        QMUISection<H, T> section = getSection(i);
        int itemIndex = getItemIndex(i);
        if (itemIndex == -2) {
            onBindSectionHeader(vh, i, section);
        } else if (itemIndex >= 0) {
            onBindSectionItem(vh, i, section, itemIndex);
        } else if (itemIndex == -3 || itemIndex == -4) {
            onBindSectionLoadingItem(vh, i, section, itemIndex == -3);
        } else {
            onBindCustomItem(vh, i, section, itemIndex + 1000);
        }
        if (itemIndex == -4) {
            vh.isLoadBefore = false;
        } else if (itemIndex == -3) {
            vh.isLoadBefore = true;
        }
        vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = vh.isForStickyHeader ? i : vh.getAdapterPosition();
                if (adapterPosition == -1 || QMUIStickySectionAdapter.this.mCallback == null) {
                    return;
                }
                QMUIStickySectionAdapter.this.mCallback.onItemClick(vh, adapterPosition);
            }
        });
        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int adapterPosition = vh.isForStickyHeader ? i : vh.getAdapterPosition();
                if (adapterPosition == -1 || QMUIStickySectionAdapter.this.mCallback == null) {
                    return false;
                }
                return QMUIStickySectionAdapter.this.mCallback.onItemLongClick(vh, adapterPosition);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        int itemIndex = getItemIndex(i);
        if (itemIndex == -1) {
            Log.e(TAG, "the item index is undefined, you may need to check your data if not called by QMUIStickySectionItemDecoration.");
            return -1;
        }
        if (itemIndex == -2) {
            return 0;
        }
        if (itemIndex == -3 || itemIndex == -4) {
            return 2;
        }
        if (itemIndex >= 0) {
            return 1;
        }
        return getCustomItemViewType(itemIndex + 1000, i) + 1000;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(VH vh) {
        QMUISection<H, T> section;
        if (vh.getItemViewType() != 2 || this.mCallback == null || vh.isLoadError || (section = getSection(vh.getAdapterPosition())) == null) {
            return;
        }
        if (vh.isLoadBefore) {
            if (this.mLoadingBeforeSections.contains(section)) {
                return;
            }
            this.mLoadingBeforeSections.add(section);
            this.mCallback.loadMore(section, true);
            return;
        }
        if (this.mLoadingAfterSections.contains(section)) {
            return;
        }
        this.mLoadingAfterSections.add(section);
        this.mCallback.loadMore(section, false);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public boolean isForStickyHeader;
        public boolean isLoadBefore;
        public boolean isLoadError;

        public ViewHolder(View view) {
            super(view);
            this.isLoadError = false;
            this.isLoadBefore = false;
            this.isForStickyHeader = false;
        }
    }
}
