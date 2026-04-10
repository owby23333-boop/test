package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import android.text.TextUtils;
import com.yuewen.gh0;
import com.yuewen.tl4;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudItem implements Serializable {
    private static final long serialVersionUID = 0;
    private long mCloudVersion;

    public DkCloudItem(long j) {
        this.mCloudVersion = j;
    }

    public abstract void fillJsonObject(JSONObject jSONObject) throws JSONException;

    public abstract void fillXmlNode(Node node);

    public abstract String getCloudId();

    public long getCloudVersion() {
        return this.mCloudVersion;
    }

    public abstract DkCloudItem merge(DkCloudItem dkCloudItem);

    public void setCloudVersion(long j) {
        this.mCloudVersion = j;
    }

    public Date xmlGetDate(Node node, String str) throws DOMException, ParseException {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(tl4.g(node, str));
    }

    public gh0 xmlGetRefPos(Node node, String str) {
        Element elementD = tl4.d(node, str);
        return new gh0(tl4.f(elementD, "ChapterIndex"), tl4.f(elementD, "ParaIndex"), tl4.f(elementD, "AtomIndex"), tl4.g(elementD, "ChapterID"), tl4.f(elementD, "Offset"));
    }

    public void xmlInsertColor(Node node, String str, int i) {
        tl4.j(node, str, String.format("%d %d %d", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i))));
    }

    public void xmlInsertDate(Node node, String str, Date date) {
        tl4.j(node, str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date));
    }

    public void xmlInsertRefPos(Node node, String str, gh0 gh0Var) {
        Element elementI = tl4.i(node, str);
        tl4.j(elementI, "ChapterID", gh0Var.c());
        tl4.j(elementI, "Offset", "" + gh0Var.b());
        tl4.j(elementI, "ChapterIndex", "" + gh0Var.d());
        tl4.j(elementI, "ParaIndex", "" + gh0Var.e());
        tl4.j(elementI, "AtomIndex", "" + gh0Var.a());
    }

    public int xmlOptColor(Node node, String str, int i) {
        String strG = tl4.g(node, str);
        if (TextUtils.isEmpty(strG)) {
            return i;
        }
        String[] strArrSplit = strG.split(" ");
        return Color.rgb(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue(), Integer.valueOf(strArrSplit[2]).intValue());
    }

    public Date xmlOptDate(Node node, String str, Date date) throws DOMException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String strG = tl4.g(node, str);
        return !TextUtils.isEmpty(strG) ? simpleDateFormat.parse(strG) : date;
    }

    public DkCloudItem(Node node, long j) throws DOMException, ParseException {
        this.mCloudVersion = j;
    }

    public DkCloudItem(DkCloudItem dkCloudItem) {
        this.mCloudVersion = dkCloudItem.mCloudVersion;
    }
}
