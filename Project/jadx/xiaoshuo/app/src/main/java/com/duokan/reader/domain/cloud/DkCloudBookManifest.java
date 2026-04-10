package com.duokan.reader.domain.cloud;

import com.yuewen.ip0;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudBookManifest extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ip0 mBookCertification;
    private String mBookMd5;
    private final String mBookRevision;
    private String mBookUri;
    private final String mBookUuid;
    private String mOpfMd5;
    private String mOpfUri;

    public DkCloudBookManifest(String str, String str2, String str3, String str4, String str5, String str6, ip0 ip0Var) {
        super(0L);
        this.mBookUuid = str;
        this.mBookRevision = str2;
        this.mBookUri = str3;
        this.mBookMd5 = str4;
        this.mOpfUri = str5;
        this.mOpfMd5 = str6;
        this.mBookCertification = ip0Var;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
    }

    public ip0 getBookCertification() {
        return this.mBookCertification;
    }

    public String getBookMd5() {
        return this.mBookMd5;
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    public String getBookUri() {
        return this.mBookUri;
    }

    public String getBookUuid() {
        return this.mBookUuid;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return getBookUuid();
    }

    public String getOpfMd5() {
        return this.mOpfMd5;
    }

    public String getOpfUri() {
        return this.mOpfUri;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return dkCloudItem;
    }
}
