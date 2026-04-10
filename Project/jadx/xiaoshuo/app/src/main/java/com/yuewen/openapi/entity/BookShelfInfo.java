package com.yuewen.openapi.entity;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class BookShelfInfo {
    public List<BookListBean> bookList;
    public int maxPage;
    public int page;
    public int pageSize;
    public int totalCount;

    public static class BookListBean {
        public int bookStatus;
        public String cbid;
        public Object chapterId;
        public Object chapterName;
        public String coverUrl;
        public int isRead;
        public String title;
        public int wordOffset;

        public int getBookStatus() {
            return this.bookStatus;
        }

        public String getCbid() {
            return this.cbid;
        }

        public Object getChapterId() {
            return this.chapterId;
        }

        public Object getChapterName() {
            return this.chapterName;
        }

        public String getCoverUrl() {
            return this.coverUrl;
        }

        public int getIsRead() {
            return this.isRead;
        }

        public String getTitle() {
            return this.title;
        }

        public int getWordOffset() {
            return this.wordOffset;
        }

        public void setBookStatus(int i) {
            this.bookStatus = i;
        }

        public void setCbid(String str) {
            this.cbid = str;
        }

        public void setChapterId(Object obj) {
            this.chapterId = obj;
        }

        public void setChapterName(Object obj) {
            this.chapterName = obj;
        }

        public void setCoverUrl(String str) {
            this.coverUrl = str;
        }

        public void setIsRead(int i) {
            this.isRead = i;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setWordOffset(int i) {
            this.wordOffset = i;
        }

        public String toString() {
            return "BookListBean{cbid='" + this.cbid + "', title='" + this.title + "', chapterId=" + this.chapterId + ", isRead=" + this.isRead + ", coverUrl='" + this.coverUrl + "', chapterName=" + this.chapterName + ", wordOffset=" + this.wordOffset + ", bookStatus=" + this.bookStatus + '}';
        }
    }

    public List<BookListBean> getBookList() {
        return this.bookList;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setBookList(List<BookListBean> list) {
        this.bookList = list;
    }

    public void setMaxPage(int i) {
        this.maxPage = i;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public String toString() {
        return "BookShelfInfo{totalCount=" + this.totalCount + ", maxPage=" + this.maxPage + ", page=" + this.page + ", pageSize=" + this.pageSize + ", bookList=" + this.bookList + '}';
    }
}
