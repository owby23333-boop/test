package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.reader.ReadThemeBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.fatcatfat.io.R;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ColorStyle.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f4397s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static k f4398t;
    public int a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f4404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f4412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f4413q = "theme/";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, ReadThemeBean> f4414r;

    private k(String str) {
        this.f4412p = str;
        Map<String, ReadThemeBean> map = this.f4414r;
        if (map == null || map.size() == 0) {
            this.f4414r = new HashMap();
            b();
        }
    }

    public static k a(String str) {
        if (!f4397s.equals(str)) {
            f4398t = new k(str);
            f4398t.c();
            f4397s = str;
        }
        return f4398t;
    }

    private void b() {
        for (String str : v.b(MkApplication.getAppContext(), this.f4413q + "index").split(",")) {
            ReadThemeBean readThemeBean = (ReadThemeBean) r.a(v.b(MkApplication.getAppContext(), this.f4413q + str + "/theme.json"), ReadThemeBean.class);
            if (readThemeBean != null) {
                readThemeBean.setKey(str);
                this.f4414r.put(str, readThemeBean);
            }
        }
    }

    private void c() {
        try {
            ReadThemeBean readThemeBeanA = a();
            this.f4405i = Color.parseColor(readThemeBeanA.getBackground_color());
            this.f4406j = this.f4405i;
            this.a = Color.parseColor(readThemeBeanA.getTextcolor());
            this.b = Color.parseColor(readThemeBeanA.getFooter_color());
            Color.parseColor(readThemeBeanA.getSource_textcolor());
            this.f4399c = Color.parseColor(readThemeBeanA.getSk_sencond_color());
            this.f4400d = Color.parseColor(readThemeBeanA.getSb_thumb_color());
            this.f4401e = Color.parseColor(readThemeBeanA.getCatalog_head_color());
            this.f4402f = Color.parseColor(readThemeBeanA.getCatalog_cur_color());
            readThemeBeanA.getIndex();
            Color.parseColor(readThemeBeanA.getHighLight());
            this.f4407k = Color.parseColor(readThemeBeanA.getTint());
            this.f4410n = Color.parseColor(readThemeBeanA.getBtn_bg_color());
            Color.parseColor(readThemeBeanA.getNoread_bg_color());
            this.f4411o = Color.parseColor(readThemeBeanA.getReaded_bg_color());
            String source_bgcolor = readThemeBeanA.getSource_bgcolor();
            if (TextUtils.isEmpty(source_bgcolor)) {
                this.f4408l = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
            } else {
                this.f4408l = Color.parseColor(source_bgcolor);
            }
            this.f4403g = Color.parseColor(readThemeBeanA.getSource_textcolor());
            this.f4409m = Color.parseColor(readThemeBeanA.getLine());
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f4406j = Color.parseColor("#ffffff");
            this.f4405i = Color.parseColor("#f6f6f6");
            this.a = Color.parseColor("#262626");
            Color.parseColor("#ed424b");
            this.f4407k = Color.parseColor("#666666");
            this.f4408l = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
            this.f4409m = Color.parseColor("#dddddd");
        }
    }

    public ReadThemeBean a() {
        try {
            return this.f4414r.get(this.f4412p);
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f4414r.get("white");
        }
    }

    public Bitmap a(Context context) {
        try {
            this.f4404h = null;
            ReadThemeBean readThemeBeanA = a();
            if (readThemeBeanA == null) {
                return null;
            }
            if (readThemeBeanA.getType() == 1) {
                this.f4404h = v.a(context, this.f4413q + this.f4412p + File.separator + readThemeBeanA.getImage());
            }
            return this.f4404h;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
