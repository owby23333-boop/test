package com.duokan.reader.domain.cloud;

import com.yuewen.gh0;
import com.yuewen.tl4;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudReadingProgress extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Date mCreationDate;
    private final Date mModifiedDate;
    private final gh0 mStartPos;

    public DkCloudReadingProgress(gh0 gh0Var) {
        super(0L);
        this.mCreationDate = Calendar.getInstance().getTime();
        this.mModifiedDate = Calendar.getInstance().getTime();
        this.mStartPos = gh0Var;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
        jSONObject.put("Type", "PROGRESS");
        jSONObject.put("DataID", "0");
        jSONObject.put("CreateTime", "" + (this.mCreationDate.getTime() / 1000));
        jSONObject.put("LastModifyTime", "" + (this.mModifiedDate.getTime() / 1000));
        jSONObject.put("RefPos", this.mStartPos.m());
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
        tl4.j(node, "Type", "PROGRESS");
        tl4.j(node, "DataID", "0");
        xmlInsertRefPos(node, "RefPos", this.mStartPos);
        xmlInsertDate(node, "CreateTime", this.mCreationDate);
        xmlInsertDate(node, "LastModifyTime", this.mModifiedDate);
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return "0";
    }

    public gh0 getStartPos() {
        return this.mStartPos;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return new DkCloudReadingProgress(((DkCloudReadingProgress) dkCloudItem).getStartPos());
    }

    public DkCloudReadingProgress(Node node, long j) throws DOMException, ParseException {
        super(node, j);
        Date dateXmlOptDate = xmlOptDate(node, "CreateTime", new Date(0L));
        this.mCreationDate = dateXmlOptDate;
        this.mModifiedDate = xmlOptDate(node, "LastModifyTime", dateXmlOptDate);
        this.mStartPos = xmlGetRefPos(node, "RefPos");
    }
}
