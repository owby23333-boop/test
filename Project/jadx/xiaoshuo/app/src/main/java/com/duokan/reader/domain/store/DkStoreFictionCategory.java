package com.duokan.reader.domain.store;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreFictionCategory extends DkStoreCategory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DkStoreFictionCategoryInfo mCategoryInfo;

    public DkStoreFictionCategory(DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo) {
        this.mCategoryInfo = dkStoreFictionCategoryInfo;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public int getBookCount() {
        return this.mCategoryInfo.mFictionCount;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getCategoryId() {
        return this.mCategoryInfo.mCategoryId;
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public DkStoreCategory[] getChildBookCategories() {
        if (this.mCategoryInfo.mChildCategoryInfos == null) {
            return new DkStoreFictionCategory[0];
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            DkStoreFictionCategoryInfo[] dkStoreFictionCategoryInfoArr = this.mCategoryInfo.mChildCategoryInfos;
            if (i >= dkStoreFictionCategoryInfoArr.length) {
                return (DkStoreCategory[]) arrayList.toArray(new DkStoreFictionCategory[0]);
            }
            arrayList.add(new DkStoreFictionCategory(dkStoreFictionCategoryInfoArr[i]));
            i++;
        }
    }

    @Override // com.duokan.reader.domain.store.DkStoreCategory
    public String getChildCategoriesLabel() {
        DkStoreFictionCategoryInfo[] dkStoreFictionCategoryInfoArr = this.mCategoryInfo.mChildCategoryInfos;
        if (dkStoreFictionCategoryInfoArr == null || dkStoreFictionCategoryInfoArr.length == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            DkStoreFictionCategoryInfo[] dkStoreFictionCategoryInfoArr2 = this.mCategoryInfo.mChildCategoryInfos;
            if (i >= dkStoreFictionCategoryInfoArr2.length) {
                return TextUtils.join(" / ", arrayList.toArray(new String[0]));
            }
            arrayList.add(dkStoreFictionCategoryInfoArr2[i].mLabel);
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
        return this.mCategoryInfo.mDescription;
    }
}
