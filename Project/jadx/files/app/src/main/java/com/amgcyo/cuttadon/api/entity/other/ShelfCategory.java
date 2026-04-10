package com.amgcyo.cuttadon.api.entity.other;

import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.comic.CategoryComicBean;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShelfCategory implements Serializable {
    private List<MkBook> artBookList;
    private int categoryCount;
    private String categoryName;
    private List<CategoryComicBean> categoryPics;
    private boolean selected;
    private int sortModel;
    private int updateCount;

    public List<MkBook> getArtBookList() {
        return this.artBookList;
    }

    public int getCategoryCount() {
        return this.categoryCount;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<CategoryComicBean> getCategoryPics() {
        return this.categoryPics;
    }

    public int getSortModel() {
        return this.sortModel;
    }

    public int getUpdateCount() {
        return this.updateCount;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setArtBookList(List<MkBook> list) {
        this.artBookList = list;
    }

    public void setCategoryCount(int i2) {
        this.categoryCount = i2;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCategoryPics(List<CategoryComicBean> list) {
        this.categoryPics = list;
    }

    public void setSelected(boolean z2) {
        this.selected = z2;
    }

    public void setSortModel(int i2) {
        this.sortModel = i2;
    }

    public void setUpdateCount(int i2) {
        this.updateCount = i2;
    }

    @NonNull
    public String toString() {
        return this.categoryName + "共" + this.categoryCount + "本, categoryPics=" + this.categoryPics.size();
    }
}
