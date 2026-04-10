package com.duokan.reader.domain.store;

import net.oauth.http.HttpResponseMessage;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreBookTocInfo extends DkStoreItemInfo {
    public String mTitle = null;
    public String mPreview = null;
    public DkStoreBookTocInfo[] mChildToc = new DkStoreBookTocInfo[0];
    private String childLine = null;

    public String getChilidLine() {
        DkStoreBookTocInfo[] dkStoreBookTocInfoArr;
        if (this.childLine == null && (dkStoreBookTocInfoArr = this.mChildToc) != null && dkStoreBookTocInfoArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                DkStoreBookTocInfo[] dkStoreBookTocInfoArr2 = this.mChildToc;
                if (i >= dkStoreBookTocInfoArr2.length) {
                    break;
                }
                stringBuffer.append(dkStoreBookTocInfoArr2[i].mTitle);
                stringBuffer.append(HttpResponseMessage.EOL);
                i++;
            }
            this.childLine = stringBuffer.toString();
        }
        return this.childLine;
    }
}
