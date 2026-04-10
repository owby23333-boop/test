package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class BookInfo {
    public int allWords;
    public String authorName;
    public BookChapterBean bookChapter;
    public int bookStatus;
    public int categoryId;
    public String categoryName;
    public String cbid;
    public int chargeType;
    public String coverUrl;
    public String createTime;
    public String intro;
    public int isInShelf;
    public String isbn;
    public int subCategoryId;
    public String subCategoryName;
    public String title;
    public int totalPrice;
    public int unitPrice;
    public String updateTime;
    public int vipStatus;

    public static class BookChapterBean {
        public Object cbid;
        public Object ccid;
        public Object chapterName;
        public Object createTime;
        public Object uploadTime;
        public int wordOffset;

        public Object getCbid() {
            return this.cbid;
        }

        public Object getCcid() {
            return this.ccid;
        }

        public Object getChapterName() {
            return this.chapterName;
        }

        public Object getCreateTime() {
            return this.createTime;
        }

        public Object getUploadTime() {
            return this.uploadTime;
        }

        public int getWordOffset() {
            return this.wordOffset;
        }

        public void setCbid(Object obj) {
            this.cbid = obj;
        }

        public void setCcid(Object obj) {
            this.ccid = obj;
        }

        public void setChapterName(Object obj) {
            this.chapterName = obj;
        }

        public void setCreateTime(Object obj) {
            this.createTime = obj;
        }

        public void setUploadTime(Object obj) {
            this.uploadTime = obj;
        }

        public void setWordOffset(int i) {
            this.wordOffset = i;
        }
    }

    public int getAllWords() {
        return this.allWords;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public BookChapterBean getBookChapter() {
        return this.bookChapter;
    }

    public int getBookStatus() {
        return this.bookStatus;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCbid() {
        return this.cbid;
    }

    public int getChargeType() {
        return this.chargeType;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getIntro() {
        return this.intro;
    }

    public int getIsInShelf() {
        return this.isInShelf;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public void setAllWords(int i) {
        this.allWords = i;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setBookChapter(BookChapterBean bookChapterBean) {
        this.bookChapter = bookChapterBean;
    }

    public void setBookStatus(int i) {
        this.bookStatus = i;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCbid(String str) {
        this.cbid = str;
    }

    public void setChargeType(int i) {
        this.chargeType = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsInShelf(int i) {
        this.isInShelf = i;
    }

    public void setIsbn(String str) {
        this.isbn = str;
    }

    public void setSubCategoryId(int i) {
        this.subCategoryId = i;
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalPrice(int i) {
        this.totalPrice = i;
    }

    public void setUnitPrice(int i) {
        this.unitPrice = i;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setVipStatus(int i) {
        this.vipStatus = i;
    }

    public String toString() {
        return "BookInfo{cbid='" + this.cbid + "', allWords=" + this.allWords + ", authorName='" + this.authorName + "', categoryId=" + this.categoryId + ", categoryName='" + this.categoryName + "', coverUrl='" + this.coverUrl + "', createTime='" + this.createTime + "', bookStatus=" + this.bookStatus + ", subCategoryId=" + this.subCategoryId + ", subCategoryName='" + this.subCategoryName + "', title='" + this.title + "', vipStatus=" + this.vipStatus + ", intro='" + this.intro + "', updateTime='" + this.updateTime + "', chargeType=" + this.chargeType + ", totalPrice=" + this.totalPrice + ", unitPrice=" + this.unitPrice + ", isInShelf=" + this.isInShelf + ", bookChapter=" + this.bookChapter + ", isbn='" + this.isbn + "'}";
    }
}
