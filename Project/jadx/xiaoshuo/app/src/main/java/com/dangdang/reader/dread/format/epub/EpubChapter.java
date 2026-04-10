package com.dangdang.reader.dread.format.epub;

import android.text.TextUtils;
import com.dangdang.reader.format.Chapter;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class EpubChapter extends Chapter {
    private static final long serialVersionUID = 1;

    public EpubChapter() {
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null || !(obj instanceof EpubChapter) || (str = this.path) == null || str.trim().length() == 0) {
            return false;
        }
        return this.path.equals(((EpubChapter) obj).path);
    }

    public int hashCode() {
        return TextUtils.isEmpty(this.path) ? super.hashCode() : this.path.hashCode();
    }

    public String toString() {
        return "Html[" + this.path + "-(" + this.startPageNum + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.endPageNum + ")(" + this.startIndexInBook + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.endIndexInBook + ")]";
    }

    public EpubChapter(String str) {
        this.path = str;
    }
}
