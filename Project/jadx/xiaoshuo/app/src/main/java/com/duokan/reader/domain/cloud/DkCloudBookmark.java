package com.duokan.reader.domain.cloud;

import com.yuewen.gh0;
import com.yuewen.tl4;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudBookmark extends DkCloudAnnotation {
    public DkCloudBookmark(String str, String str2, String str3, long j, Date date, Date date2, gh0 gh0Var, String str4) {
        super(str, str2, str3, j, date, date2, gh0Var, null, str4);
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudAnnotation, com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        tl4.j(node, "Type", "BOOKMARK");
    }

    public DkCloudBookmark(String str, String str2, Node node, long j) throws DOMException, ParseException {
        super(str, str2, node, j);
    }
}
