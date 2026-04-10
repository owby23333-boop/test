package com.duokan.reader.domain.privacy;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PrivacyInfoBean {
    private String code;
    private DataBean data;
    private String msg;
    private String requestId;
    private String result;
    private String uiStyle;

    @Keep
    public static class ContentBean {

        @SerializedName("first_section")
        private Section firstSection;

        @SerializedName("second_section")
        private Section secondSection;

        public Section getFirstSection() {
            return this.firstSection;
        }

        public Section getSecondSection() {
            return this.secondSection;
        }

        public void setFirstSection(Section section) {
            this.firstSection = section;
        }

        public void setSecondSection(Section section) {
            this.secondSection = section;
        }
    }

    @Keep
    public static class DataBean {
        private String appId;
        private String content;
        private String status;
        private String url;
        private String version;

        public String getAppId() {
            return this.appId;
        }

        public String getContent() {
            return this.content;
        }

        public String getStatus() {
            return this.status;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVersion() {
            return this.version;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    @Keep
    public static class Section {
        private String content;
        private List<SectionLinks> links;

        public String getContent() {
            return this.content;
        }

        public List<SectionLinks> getLinks() {
            return this.links;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setLinks(List<SectionLinks> list) {
            this.links = list;
        }
    }

    @Keep
    public static class SectionLinks {
        private String text;
        private String url;

        public String getText() {
            return this.text;
        }

        public String getUrl() {
            return this.url;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public String getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getResult() {
        return this.result;
    }

    public String getUiStyle() {
        return this.uiStyle;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setUiStyle(String str) {
        this.uiStyle = str;
    }
}
