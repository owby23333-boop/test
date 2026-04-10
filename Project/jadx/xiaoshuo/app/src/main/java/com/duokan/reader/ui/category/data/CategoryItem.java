package com.duokan.reader.ui.category.data;

import com.duokan.reader.ui.store.data.cms.Data;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class CategoryItem extends Data {
    public String cover_url;
    public int id;
    public boolean is_sub;
    public int item_id;
    public int item_type;
    public String label;
    public int parent_id;
    public String summary;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CategoryItem categoryItem = (CategoryItem) obj;
        return this.id == categoryItem.id && this.item_type == categoryItem.item_type && this.item_id == categoryItem.item_id && this.parent_id == categoryItem.parent_id && Objects.equals(this.label, categoryItem.label) && Objects.equals(this.cover_url, categoryItem.cover_url);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), Integer.valueOf(this.item_type), Integer.valueOf(this.item_id), this.label, this.cover_url, Integer.valueOf(this.parent_id));
    }
}
