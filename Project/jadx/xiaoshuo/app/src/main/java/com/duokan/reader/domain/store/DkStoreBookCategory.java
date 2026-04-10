package com.duokan.reader.domain.store;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreBookCategory extends DkStoreCategory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DkStoreBookCategoryInfo mCategoryInfo;

    public DkStoreBookCategory(DkStoreBookCategoryInfo dkStoreBookCategoryInfo) {
        this.mCategoryInfo = dkStoreBookCategoryInfo;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public int getBookCount() {
        return this.mCategoryInfo.mBookCount;
    }

    public String getBookTitles() {
        return this.mCategoryInfo.mBookTitles;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getCategoryId() {
        return this.mCategoryInfo.mCategoryId;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public DkStoreCategory[] getChildBookCategories() {
        if (this.mCategoryInfo.mChildCategoryInfos == null) {
            return new DkStoreBookCategory[0];
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            DkStoreBookCategoryInfo[] dkStoreBookCategoryInfoArr = this.mCategoryInfo.mChildCategoryInfos;
            if (i >= dkStoreBookCategoryInfoArr.length) {
                return (DkStoreCategory[]) arrayList.toArray(new DkStoreBookCategory[0]);
            }
            arrayList.add(new DkStoreBookCategory(dkStoreBookCategoryInfoArr[i]));
            i++;
        }
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getChildCategoriesLabel() {
        DkStoreBookCategoryInfo[] dkStoreBookCategoryInfoArr = this.mCategoryInfo.mChildCategoryInfos;
        if (dkStoreBookCategoryInfoArr == null || dkStoreBookCategoryInfoArr.length == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            DkStoreBookCategoryInfo[] dkStoreBookCategoryInfoArr2 = this.mCategoryInfo.mChildCategoryInfos;
            if (i >= dkStoreBookCategoryInfoArr2.length) {
                return TextUtils.join(" / ", arrayList.toArray(new String[0]));
            }
            arrayList.add(dkStoreBookCategoryInfoArr2[i].mLabel);
            i++;
        }
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getCoverUri() {
        return this.mCategoryInfo.mCoverUri;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getDescription() {
        return this.mCategoryInfo.mDescription;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getImageUri() {
        return this.mCategoryInfo.mImage;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getLabel() {
        return this.mCategoryInfo.mLabel;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getTitles() {
        return this.mCategoryInfo.mBookTitles;
    }
}
