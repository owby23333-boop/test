package com.yuewen.openapi.entity;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class KeySearchResponse {
    public List<ListBean> list;
    public double maxPage;
    public double page;

    public static class ListBean {
        public String algr_id;
        public String author;
        public String bookcover;
        public int bookstatus;
        public double categoryid;
        public String categoryname;
        public String cbid;
        public String description;
        public String title;

        public String getAlgr_id() {
            return this.algr_id;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getBookcover() {
            return this.bookcover;
        }

        public int getBookstatus() {
            return this.bookstatus;
        }

        public double getCategoryid() {
            return this.categoryid;
        }

        public String getCategoryname() {
            return this.categoryname;
        }

        public String getCbid() {
            return this.cbid;
        }

        public String getDescription() {
            return this.description;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAlgr_id(String str) {
            this.algr_id = str;
        }

        public void setAuthor(String str) {
            this.author = str;
        }

        public void setBookcover(String str) {
            this.bookcover = str;
        }

        public void setBookstatus(int i) {
            this.bookstatus = i;
        }

        public void setCategoryid(double d) {
            this.categoryid = d;
        }

        public void setCategoryname(String str) {
            this.categoryname = str;
        }

        public void setCbid(String str) {
            this.cbid = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String toString() {
            return "ListBean{cbid='" + this.cbid + "', title='" + this.title + "', author='" + this.author + "', categoryid=" + this.categoryid + ", categoryname='" + this.categoryname + "', description='" + this.description + "', bookcover='" + this.bookcover + "', bookstatus=" + this.bookstatus + ", algr_id='" + this.algr_id + "'}";
        }
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public double getMaxPage() {
        return this.maxPage;
    }

    public double getPage() {
        return this.page;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public void setMaxPage(double d) {
        this.maxPage = d;
    }

    public void setPage(double d) {
        this.page = d;
    }

    public String toString() {
        return "KeySearchResponse{page=" + this.page + ", maxPage=" + this.maxPage + ", list=" + this.list + '}';
    }
}
