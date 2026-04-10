package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import com.yuewen.gh0;
import com.yuewen.rd2;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudComment extends DkCloudThought {
    private final int mHighlightColor;

    public DkCloudComment(String str, String str2, String str3, long j, Date date, Date date2, gh0 gh0Var, gh0 gh0Var2, String str4, String str5, int i, rd2<Boolean> rd2Var) {
        super(str, str2, str3, j, date, date2, gh0Var, gh0Var2, str4, str5, rd2Var);
        this.mHighlightColor = i;
    }

    public String colorFormat(int i) {
        return String.format("%d %d %d", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)));
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudThought, com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
        super.fillJsonObject(jSONObject);
        jSONObject.put("Color", colorFormat(this.mHighlightColor));
        jSONObject.put("CreateTime", dateFormat(getCreationDate()));
        jSONObject.put("LastModifyTime", dateFormat(getCreationDate()));
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudThought, com.duokan.reader.domain.cloud.DkCloudAnnotation, com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        xmlInsertColor(node, "Color", this.mHighlightColor);
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudThought
    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudThought
    public String getType() {
        return "COMMENT";
    }

    public DkCloudComment(String str, String str2, Node node, long j) throws DOMException, ParseException {
        super(str, str2, node, j);
        this.mHighlightColor = xmlOptColor(node, "Color", Color.rgb(237, 88, 0));
    }
}
