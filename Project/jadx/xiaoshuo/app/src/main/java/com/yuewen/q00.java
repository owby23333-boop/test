package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class q00 {
    public static final String A = "1912";
    public static final String B = "2823";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16345a = "1586";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16346b = "2647";
    public static final String c = "1559";
    public static final String d = "1425";
    public static final String e = "1535";
    public static final String f = "1596";
    public static final String g = "1426";
    public static final String h = "2973";
    public static final String i = "分类列表";
    public static final String j = "二级分类";
    public static final String k = "分类-标签";
    public static final String l = "顶部tab";
    public static final String m = "猜你在找";
    public static final String n = "分类一级页顶tab";
    public static final String o = "筛选入口";
    public static final String p = "排序";
    public static final String q = "筛选模块";
    public static final String r = "阅读扉页";
    public static final String s = "同款热门书籍";
    public static final String t = "结束说明（去书城）";
    public static final String u = "免费阅读按钮";
    public static final String v = "展开收起按钮";
    public static final String w = "详情目录";
    public static final String x = "搜索";
    public static final String y = "预置词";
    public static final String z = "1431";

    public static String a() {
        String strH = DkSharedStorageManager.f().h();
        return TextUtils.equals(strH, "3") ? "1564" : TextUtils.equals(strH, "4") ? "1565" : c;
    }
}
