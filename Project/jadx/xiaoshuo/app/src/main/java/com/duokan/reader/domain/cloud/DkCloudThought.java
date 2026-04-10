package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import android.text.TextUtils;
import com.yuewen.gh0;
import com.yuewen.rd2;
import com.yuewen.tl4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudThought extends DkCloudAnnotation {
    private rd2<Boolean> mIsPublic;
    private String mNoteText;

    public DkCloudThought(String str, String str2, String str3, long j, Date date, Date date2, gh0 gh0Var, gh0 gh0Var2, String str4, String str5, rd2<Boolean> rd2Var) {
        super(str, str2, str3, j, date, date2, gh0Var, gh0Var2, str4);
        this.mNoteText = str5;
        this.mIsPublic = rd2Var;
    }

    public String dateFormat(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
        jSONObject.put("BeginRefPos", getStartPos().m());
        jSONObject.put("EndRefPos", getEndPos().m());
        jSONObject.put("Content", getNoteText());
        jSONObject.put("RefContent", getSample());
        if (this.mIsPublic.hasValue()) {
            jSONObject.put("Open", this.mIsPublic.getValue().booleanValue() ? 1 : 0);
        }
        jSONObject.put("Type", getType());
        jSONObject.put("DataID", getCloudId());
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudAnnotation, com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        tl4.j(node, "Content", this.mNoteText);
        if (this.mIsPublic.hasValue()) {
            tl4.j(node, "Open", String.valueOf(this.mIsPublic.getValue().booleanValue() ? 1 : 0));
        }
        tl4.j(node, "Type", getType());
    }

    public int getHighlightColor() {
        return Color.rgb(237, 108, 0);
    }

    public String getNoteText() {
        return this.mNoteText;
    }

    public abstract String getType();

    public rd2<Boolean> isPublic() {
        return this.mIsPublic;
    }

    public void setNoteText(String str) {
        this.mNoteText = str;
    }

    public void setPublic(rd2<Boolean> rd2Var) {
        this.mIsPublic = rd2Var;
    }

    public DkCloudThought(String str, String str2, Node node, long j) throws DOMException, ParseException {
        super(str, str2, node, j);
        this.mNoteText = tl4.l(node, "Content", "");
        String strG = tl4.g(node, "Open");
        if (TextUtils.isEmpty(strG)) {
            this.mIsPublic = new rd2<>();
        } else {
            this.mIsPublic = new rd2<>(Boolean.valueOf("1".equals(strG)));
        }
    }
}
