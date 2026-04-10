package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.anythink.expressad.foundation.d.c;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Entity(indices = {@Index(unique = true, value = {"book_id"})}, tableName = "LocalReadHistoryBean")
public class LocalReadHistoryBean implements Serializable, b {

    @ColumnInfo(name = "author")
    private String author;

    @PrimaryKey
    @ColumnInfo(name = "book_id")
    private int book_id;

    @ColumnInfo(name = "chapter_count")
    private int chapter_count;

    @ColumnInfo(name = "comment_number")
    private int comment_number;

    @ColumnInfo(name = "created_at")
    private String created_at;

    @ColumnInfo(name = "fav_count")
    private int fav_count;

    @ColumnInfo(name = "form")
    private int form;

    @ColumnInfo(name = c.C0205c.f10205e)
    private String image;

    @Ignore
    private boolean isInshelf;

    @Ignore
    private int itemType;

    @ColumnInfo(name = "last_chapter_name")
    private String last_chapter_name;

    @ColumnInfo(name = "list_path")
    private String list_path;

    @ColumnInfo(name = "list_reload_path")
    private String list_reload_path;

    @ColumnInfo(name = "ltype")
    private String ltype;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "needToldServer")
    private int needToldServer;

    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "stype")
    private String stype;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "updated_at")
    private String updated_at;

    @ColumnInfo(name = "words_number")
    private int words_number;

    public LocalReadHistoryBean() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalReadHistoryBean) && getBook_id() == ((LocalReadHistoryBean) obj).getBook_id();
    }

    public String getAuthor() {
        return this.author;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getChapter_count() {
        return this.chapter_count;
    }

    public int getComment_number() {
        return this.comment_number;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getFav_count() {
        return this.fav_count;
    }

    public int getForm() {
        return this.form;
    }

    public String getImage() {
        return this.image;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getLast_chapter_name() {
        return this.last_chapter_name;
    }

    public String getList_path() {
        return this.list_path;
    }

    public String getList_reload_path() {
        return this.list_reload_path;
    }

    public String getLtype() {
        return this.ltype;
    }

    public String getName() {
        return this.name;
    }

    public int getNeedToldServer() {
        return this.needToldServer;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStype() {
        return this.stype;
    }

    public int getType() {
        return this.type;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public int getWords_number() {
        return this.words_number;
    }

    public boolean isInshelf() {
        return this.isInshelf;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setChapter_count(int i2) {
        this.chapter_count = i2;
    }

    public void setComment_number(int i2) {
        this.comment_number = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setFav_count(int i2) {
        this.fav_count = i2;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setInshelf(boolean z2) {
        this.isInshelf = z2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setLast_chapter_name(String str) {
        this.last_chapter_name = str;
    }

    public void setList_path(String str) {
        this.list_path = str;
    }

    public void setList_reload_path(String str) {
        this.list_reload_path = str;
    }

    public void setLtype(String str) {
        this.ltype = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedToldServer(int i2) {
        this.needToldServer = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStype(String str) {
        this.stype = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public void setWords_number(int i2) {
        this.words_number = i2;
    }

    @Ignore
    public LocalReadHistoryBean(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, int i5, int i6, int i7, String str7, String str8) {
        this.book_id = i2;
        this.form = i3;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.created_at = str4;
        this.ltype = str5;
        this.stype = str6;
        this.status = i4;
        this.fav_count = i5;
        this.comment_number = i6;
        this.words_number = i7;
        this.last_chapter_name = str7;
        this.updated_at = str8;
    }

    @Ignore
    public LocalReadHistoryBean(int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, int i5, int i6, int i7, String str7, String str8) {
        this.type = i2;
        this.book_id = i3;
        this.form = i4;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.created_at = str4;
        this.list_path = str5;
        this.list_reload_path = str6;
        this.status = i5;
        this.comment_number = i6;
        this.chapter_count = i7;
        this.last_chapter_name = str7;
        this.updated_at = str8;
    }
}
