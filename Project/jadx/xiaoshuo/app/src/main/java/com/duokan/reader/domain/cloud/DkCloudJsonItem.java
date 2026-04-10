package com.duokan.reader.domain.cloud;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudJsonItem extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public DkCloudJsonItem(long j) {
        super(j);
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
    }

    public DkCloudJsonItem(DkCloudJsonItem dkCloudJsonItem) {
        super(dkCloudJsonItem);
    }
}
