package com.duokan.reader.domain.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkShareBook implements Serializable {
    private static final long serialVersionUID = 1;
    public String mBookUuid = "";
    public String mTitle = "";
    public String mCoverUri = "";
    public String[] mAuthors = new String[0];
    public String mIntro = "";
    public String mSummary = "";
    public String mTraceId = "";

    public String getAuthor() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mAuthors) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public String getBookUuid() {
        return this.mBookUuid;
    }

    public String getCoverUri() {
        return this.mCoverUri;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTraceId() {
        return this.mTraceId;
    }
}
