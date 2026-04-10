package com.amgcyo.cuttadon.h.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.view.dialog.c1;
import java.util.List;

/* JADX INFO: compiled from: SdkChaPingAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static void a(Context context, String str, List<BaseAd> list) {
        b(context, str, com.amgcyo.cuttadon.app.o.c.a(str, list));
    }

    private static void b(Context context, String str, BaseAd baseAd) {
        String strJ;
        if (baseAd == null) {
            return;
        }
        int style = baseAd.getStyle();
        String platform = baseAd.getPlatform();
        String str2 = "本次需要显示的插屏风格：" + style + " 平台是：" + platform;
        if (TextUtils.isEmpty(platform)) {
            return;
        }
        byte b = -1;
        int iHashCode = platform.hashCode();
        if (iHashCode != -103418728) {
            if (iHashCode != 3302) {
                if (iHashCode != 3432) {
                    if (iHashCode != 3526476) {
                        if (iHashCode == 1061735899 && platform.equals("csj_new")) {
                            b = 0;
                        }
                    } else if (platform.equals("self")) {
                        b = 2;
                    }
                } else if (platform.equals("ks")) {
                    b = 3;
                }
            } else if (platform.equals("gm")) {
                b = 4;
            }
        } else if (platform.equals("gdt_new")) {
            b = 1;
        }
        if (b == 0) {
            String strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "a");
            String str3 = "新插屏id：" + strA;
            com.amgcyo.cuttadon.h.b.c.d().a(context, strA, str, (com.amgcyo.cuttadon.h.f.c) null);
            return;
        }
        if (b == 1) {
            com.amgcyo.cuttadon.h.c.a.a(context, com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "a"), false, null);
            return;
        }
        if (b == 2) {
            try {
                String[] strArr = {str, "插屏"};
                if ("book".equals(str)) {
                    strArr[1] = "书籍详情插屏";
                } else if ("bookself".equals(str)) {
                    strArr[1] = "书架或养肥插屏";
                } else if ("book_city".equals(str)) {
                    strArr[1] = "书城插屏";
                } else {
                    strArr[1] = "间隔数量弹窗";
                }
                NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(strArr, style, new boolean[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("插屏广告：");
                sb.append(newApiAdA == null);
                sb.toString();
                if (newApiAdA == null || context == null) {
                    return;
                }
                a(context, newApiAdA);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (b == 3) {
            String strA2 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "a");
            String str4 = "ks_codeId:" + strA2;
            if (o.c(strA2)) {
                com.amgcyo.cuttadon.h.e.b.c().a(context, strA2);
                return;
            }
            return;
        }
        if (b != 4) {
            return;
        }
        if (5 == style) {
            strJ = com.amgcyo.cuttadon.sdk.utils.d.j(com.anythink.core.c.e.a);
            String str5 = style + " 插全屏-全屏：" + strJ;
        } else if (6 == style) {
            strJ = com.amgcyo.cuttadon.sdk.utils.d.j("f");
            String str6 = style + " 插全屏-半屏：" + strJ;
        } else {
            strJ = null;
        }
        if (TextUtils.isEmpty(strJ)) {
            return;
        }
        com.amgcyo.cuttadon.h.d.b.a((Activity) context, strJ, null);
    }

    public static void a(Context context, String str) {
        b(context, str, com.amgcyo.cuttadon.app.o.c.a(str, com.amgcyo.cuttadon.sdk.utils.i.b("interval_count", str, "table_plaque")));
    }

    public static void a(Context context, String str, int i2) {
        BaseAd baseAdA = com.amgcyo.cuttadon.app.o.c.a(str, com.amgcyo.cuttadon.utils.otherutils.h.i(i2));
        StringBuilder sb = new StringBuilder();
        sb.append("插屏对象：");
        sb.append(baseAdA != null);
        sb.toString();
        if (baseAdA != null && "self".equals(baseAdA.getPlatform()) && baseAdA.getStyle() == 3) {
            b(context, str, baseAdA);
        }
    }

    public static void a(Context context, String str, BaseAd baseAd) {
        StringBuilder sb = new StringBuilder();
        sb.append("加载插屏广告--插屏对象：");
        sb.append(baseAd != null);
        sb.toString();
        if (baseAd != null) {
            b(context, str, baseAd);
        }
    }

    public static void a(final Context context, final NewApiAd newApiAd) {
        if (context == null) {
            return;
        }
        me.jessyan.art.c.e.c cVarImageLoader = me.jessyan.art.f.e.a(context).imageLoader();
        c1 c1Var = new c1(context);
        c1Var.show();
        c1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.h.a.b
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                h.a(newApiAd, context);
            }
        });
        c1Var.a(newApiAd, cVarImageLoader);
    }

    static /* synthetic */ void a(NewApiAd newApiAd, Context context) {
        if (newApiAd == null) {
            return;
        }
        com.amgcyo.cuttadon.h.h.a.a(context, newApiAd);
    }
}
