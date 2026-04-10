package com.yuewen;

import android.content.Context;
import android.view.View;
import com.duokan.reader.DkApp;
import com.yuewen.ls2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ad1 implements bd1 {
    public static final int c = DkApp.get().getResources().getColor(ls2.f.nk);
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8474b;

    public static List<List<ad1>> f(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONObject("itemsInfo").getJSONArray("data");
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(new ln(jSONArray.optJSONObject(i2)));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList2.add(arrayList);
        }
        return arrayList2;
    }

    public static List<List<ad1>> g(Context context, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("itemsInfo");
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                int i3 = jSONObjectOptJSONObject.getInt("type");
                if (i3 == 1) {
                    arrayList.add(new og(jSONObjectOptJSONObject));
                } else if (i3 == 2) {
                    arrayList2.add(new ln(jSONObjectOptJSONObject));
                } else if (i3 == 3) {
                    arrayList3.add(new zk4(jSONObjectOptJSONObject.optString("sug")));
                }
            }
            og.m(context, arrayList);
        }
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.add(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            arrayList4.add(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList4.add(arrayList3);
        }
        return arrayList4;
    }

    public View b(View view) {
        ad1 ad1Var;
        if (view == null || (ad1Var = (ad1) view.getTag()) == null || ad1Var.getType() != getType()) {
            return null;
        }
        return view;
    }

    public String c() {
        return "";
    }

    public String d() {
        return this.f8473a;
    }

    public String e() {
        return this.f8473a;
    }

    public boolean h() {
        return this.f8474b;
    }

    public void i(com.duokan.dksearch.ui.a aVar) {
        if (getType() <= 2) {
            aVar.eg(e());
        }
    }

    public void j(boolean z) {
        this.f8474b = z;
    }

    public void k(View view) {
        view.setTag(this);
    }

    public void l(String str) {
        this.f8473a = str;
    }
}
