package com.yuewen.openapi.entity;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ChapterOutline {
    public String bookName;
    public String cbid;
    public List<ChapterListBean> chapterList;

    public static class ChapterListBean {
        public List<ChaptersBean> chapters;
        public String cvid;
        public String volumeName;
        public int volumeSort;

        public static class ChaptersBean {
            public String ccid;
            public String chapterName;
            public int chapterSort;
            public int freeStatus;
            public int isTaked;
            public String nextCcid;
            public int originalWords;
            public String prevCcid;
            public int updateTime;
            public int vipStatus;

            public String getCcid() {
                return this.ccid;
            }

            public String getChapterName() {
                return this.chapterName;
            }

            public int getChapterSort() {
                return this.chapterSort;
            }

            public int getFreeStatus() {
                return this.freeStatus;
            }

            public int getIsTaked() {
                return this.isTaked;
            }

            public String getNextCcid() {
                return this.nextCcid;
            }

            public int getOriginalWords() {
                return this.originalWords;
            }

            public String getPrevCcid() {
                return this.prevCcid;
            }

            public int getUpdateTime() {
                return this.updateTime;
            }

            public int getVipStatus() {
                return this.vipStatus;
            }

            public void setCcid(String str) {
                this.ccid = str;
            }

            public void setChapterName(String str) {
                this.chapterName = str;
            }

            public void setChapterSort(int i) {
                this.chapterSort = i;
            }

            public void setFreeStatus(int i) {
                this.freeStatus = i;
            }

            public void setIsTaked(int i) {
                this.isTaked = i;
            }

            public void setNextCcid(String str) {
                this.nextCcid = str;
            }

            public void setOriginalWords(int i) {
                this.originalWords = i;
            }

            public void setPrevCcid(String str) {
                this.prevCcid = str;
            }

            public void setUpdateTime(int i) {
                this.updateTime = i;
            }

            public void setVipStatus(int i) {
                this.vipStatus = i;
            }
        }

        public List<ChaptersBean> getChapters() {
            return this.chapters;
        }

        public String getCvid() {
            return this.cvid;
        }

        public String getVolumeName() {
            return this.volumeName;
        }

        public int getVolumeSort() {
            return this.volumeSort;
        }

        public void setChapters(List<ChaptersBean> list) {
            this.chapters = list;
        }

        public void setCvid(String str) {
            this.cvid = str;
        }

        public void setVolumeName(String str) {
            this.volumeName = str;
        }

        public void setVolumeSort(int i) {
            this.volumeSort = i;
        }

        public String toString() {
            return "ChapterListBean{cvid='" + this.cvid + "', volumeName='" + this.volumeName + "', volumeSort=" + this.volumeSort + ", chapters=" + this.chapters + '}';
        }
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getCbid() {
        return this.cbid;
    }

    public List<ChapterListBean> getChapterList() {
        return this.chapterList;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setCbid(String str) {
        this.cbid = str;
    }

    public void setChapterList(List<ChapterListBean> list) {
        this.chapterList = list;
    }

    public String toString() {
        return "ChapterOutline{cbid='" + this.cbid + "', bookName='" + this.bookName + "', chapterList=" + this.chapterList + '}';
    }
}
