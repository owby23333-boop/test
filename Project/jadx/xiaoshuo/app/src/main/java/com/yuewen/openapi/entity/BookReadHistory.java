package com.yuewen.openapi.entity;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class BookReadHistory {
    public List<ListBean> list;

    public static class ListBean {
        public int bookStatus;
        public String cbid;
        public String ccid;
        public String chapterName;
        public String coverUrl;
        public String createTime;
        public String title;
        public String uploadTime;
        public int vipStatus;
        public int wordOffset;

        public int getBookStatus() {
            return this.bookStatus;
        }

        public String getCbid() {
            return this.cbid;
        }

        public String getCcid() {
            return this.ccid;
        }

        public String getChapterName() {
            return this.chapterName;
        }

        public String getCoverUrl() {
            return this.coverUrl;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUploadTime() {
            return this.uploadTime;
        }

        public int getVipStatus() {
            return this.vipStatus;
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

        public void setCcid(String str) {
            this.ccid = str;
        }

        public void setChapterName(String str) {
            this.chapterName = str;
        }

        public void setCoverUrl(String str) {
            this.coverUrl = str;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUploadTime(String str) {
            this.uploadTime = str;
        }

        public void setVipStatus(int i) {
            this.vipStatus = i;
        }

        public void setWordOffset(int i) {
            this.wordOffset = i;
        }

        public String toString() {
            return "ListBean{cbid='" + this.cbid + "', coverUrl='" + this.coverUrl + "', bookStatus=" + this.bookStatus + ", title='" + this.title + "', vipStatus=" + this.vipStatus + ", ccid='" + this.ccid + "', chapterName='" + this.chapterName + "', wordOffset=" + this.wordOffset + ", uploadTime='" + this.uploadTime + "', createTime='" + this.createTime + "'}";
        }
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public String toString() {
        return "BookReadHistory{list=" + this.list + '}';
    }
}
