package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UmPushBean implements Serializable {
    private BodyBean body;
    private String display_type;
    private ExtraBean extra;
    private String msg_id;

    public static class BodyBean implements Serializable {
        private String after_open;
        private String play_lights;
        private String play_sound;
        private String play_vibrate;
        private String text;
        private String ticker;
        private String title;

        public String getAfter_open() {
            return this.after_open;
        }

        public String getPlay_lights() {
            return this.play_lights;
        }

        public String getPlay_sound() {
            return this.play_sound;
        }

        public String getPlay_vibrate() {
            return this.play_vibrate;
        }

        public String getText() {
            return this.text;
        }

        public String getTicker() {
            return this.ticker;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAfter_open(String str) {
            this.after_open = str;
        }

        public void setPlay_lights(String str) {
            this.play_lights = str;
        }

        public void setPlay_sound(String str) {
            this.play_sound = str;
        }

        public void setPlay_vibrate(String str) {
            this.play_vibrate = str;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setTicker(String str) {
            this.ticker = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public static class ExtraBean implements Serializable {
        private String author;
        private int bookId;
        private String bookName;
        private String chapterName;
        private String feedback_url;
        private int form;
        private String image;
        private String ltype;
        private String notice_button;
        private int notice_open_type;
        private int notice_status;
        private String notice_url;
        private String remark;
        private String siteId;
        private String sitePath;
        private String status;
        private String type;

        public String getAuthor() {
            return this.author;
        }

        public int getBookId() {
            return this.bookId;
        }

        public String getBookName() {
            return this.bookName;
        }

        public String getChapterName() {
            return this.chapterName;
        }

        public String getFeedback_url() {
            return this.feedback_url;
        }

        public int getForm() {
            return this.form;
        }

        public String getImage() {
            return this.image;
        }

        public String getLtype() {
            return this.ltype;
        }

        public String getNotice_button() {
            return this.notice_button;
        }

        public int getNotice_open_type() {
            return this.notice_open_type;
        }

        public int getNotice_status() {
            return this.notice_status;
        }

        public String getNotice_url() {
            return this.notice_url;
        }

        public String getRemark() {
            return this.remark;
        }

        public String getSiteId() {
            return this.siteId;
        }

        public String getSitePath() {
            return this.sitePath;
        }

        public String getStatus() {
            return this.status;
        }

        public String getType() {
            return this.type;
        }

        public void setAuthor(String str) {
            this.author = str;
        }

        public void setBookId(int i2) {
            this.bookId = i2;
        }

        public void setBookName(String str) {
            this.bookName = str;
        }

        public void setChapterName(String str) {
            this.chapterName = str;
        }

        public void setFeedback_url(String str) {
            this.feedback_url = str;
        }

        public void setForm(int i2) {
            this.form = i2;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setLtype(String str) {
            this.ltype = str;
        }

        public void setNotice_button(String str) {
            this.notice_button = str;
        }

        public void setNotice_open_type(int i2) {
            this.notice_open_type = i2;
        }

        public void setNotice_status(int i2) {
            this.notice_status = i2;
        }

        public void setNotice_url(String str) {
            this.notice_url = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }

        public void setSiteId(String str) {
            this.siteId = str;
        }

        public void setSitePath(String str) {
            this.sitePath = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public BodyBean getBody() {
        return this.body;
    }

    public String getDisplay_type() {
        return this.display_type;
    }

    public ExtraBean getExtra() {
        return this.extra;
    }

    public String getMsg_id() {
        return this.msg_id;
    }

    public void setBody(BodyBean bodyBean) {
        this.body = bodyBean;
    }

    public void setDisplay_type(String str) {
        this.display_type = str;
    }

    public void setExtra(ExtraBean extraBean) {
        this.extra = extraBean;
    }

    public void setMsg_id(String str) {
        this.msg_id = str;
    }
}
