package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.Ignore;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkSiteBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private String choose;
    private int crawl_book_id;

    @Ignore
    private int itemType;
    private String last_chapter_name;

    @Ignore
    private String show_updated_at;
    private String site_id;
    private String site_name;
    private String site_path;
    private String site_path_reload;
    private String updated_at;

    public MkSiteBean() {
    }

    public String getChoose() {
        return this.choose;
    }

    public int getCrawl_book_id() {
        return this.crawl_book_id;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getLast_chapter_name() {
        return this.last_chapter_name;
    }

    public String getShow_updated_at() {
        return this.show_updated_at;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public String getSite_name() {
        return this.site_name;
    }

    public String getSite_path() {
        return this.site_path;
    }

    public String getSite_path_reload() {
        return this.site_path_reload;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setChoose(String str) {
        this.choose = str;
    }

    public void setCrawl_book_id(int i2) {
        this.crawl_book_id = i2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setLast_chapter_name(String str) {
        this.last_chapter_name = str;
    }

    public void setShow_updated_at(String str) {
        this.show_updated_at = str;
    }

    public void setSite_id(String str) {
        this.site_id = str;
    }

    public void setSite_name(String str) {
        this.site_name = str;
    }

    public void setSite_path(String str) {
        this.site_path = str;
    }

    public void setSite_path_reload(String str) {
        this.site_path_reload = str;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public MkSiteBean(int i2) {
        this.itemType = i2;
    }
}
