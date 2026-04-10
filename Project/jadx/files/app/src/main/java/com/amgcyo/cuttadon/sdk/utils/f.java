package com.amgcyo.cuttadon.sdk.utils;

import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean;
import com.amgcyo.cuttadon.api.entity.config.ChapterTCBAdBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import java.util.List;

/* JADX INFO: compiled from: ArtChapterUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static int a(int i2) {
        ChapterTCBAdBean chapterTCBAdBeanB = b(i2);
        if (chapterTCBAdBeanB == null) {
            return 0;
        }
        return chapterTCBAdBeanB.getNext_button_switch();
    }

    private static ChapterTCBAdBean b(int i2) {
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null) {
            return null;
        }
        return 1 == i2 ? mkAppConfigE.getChapter() : mkAppConfigE.getComics_chapter();
    }

    public static int a(int i2, String str, String str2) {
        ChapterTCBAdBean chapterTCBAdBeanB = b(i2);
        if (chapterTCBAdBeanB == null) {
            return 0;
        }
        BaseStochasticBean content_page = chapterTCBAdBeanB.getContent_page();
        if ("content_page1".equals(str2)) {
            content_page = chapterTCBAdBeanB.getContent_page1();
        }
        if (content_page == null) {
            return 0;
        }
        byte b = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != -797691627) {
            if (iHashCode == 109780401 && str.equals(com.anythink.expressad.foundation.h.i.f10647e)) {
                b = 0;
            }
        } else if (str.equals("interval_count")) {
            b = 1;
        }
        if (b == 0) {
            return content_page.getStyle();
        }
        if (b != 1) {
            return 0;
        }
        return content_page.getInterval_count();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int b(int i2, String str) {
        BaseStochasticBean read_ad_lock;
        ChapterTCBAdBean chapterTCBAdBeanB = b(i2);
        if (chapterTCBAdBeanB == null || (read_ad_lock = chapterTCBAdBeanB.getRead_ad_lock()) == null) {
            return 0;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1569533992:
                if (str.equals("interval_min")) {
                    b = 0;
                }
                break;
            case 3015911:
                if (str.equals("back")) {
                    b = 3;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    b = 2;
                }
                break;
            case 336650556:
                if (str.equals(CallMraidJS.f8282e)) {
                    b = 1;
                }
                break;
        }
        if (b == 0) {
            return read_ad_lock.getInterval_min();
        }
        if (b == 1) {
            return read_ad_lock.getLoading();
        }
        if (b == 2) {
            return read_ad_lock.getPlay();
        }
        if (b != 3) {
            return 0;
        }
        return read_ad_lock.getBack();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static List<BaseAd> a(int i2, String str) {
        BaseStochasticBean read_ad_lock;
        ChapterTCBAdBean chapterTCBAdBeanB = b(i2);
        if (chapterTCBAdBeanB == null) {
            return null;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -388823019:
                if (str.equals("content_end")) {
                    b = 2;
                }
                break;
            case -305948130:
                if (str.equals("read_ad_lock")) {
                    b = 5;
                }
                break;
            case 13011004:
                if (str.equals("content_page1")) {
                    b = 4;
                }
                break;
            case 15866033:
                if (str.equals("content_bottom")) {
                    b = 1;
                }
                break;
            case 516364623:
                if (str.equals("interface_top")) {
                    b = 0;
                }
                break;
            case 831703701:
                if (str.equals("content_page")) {
                    b = 3;
                }
                break;
        }
        if (b == 0) {
            BaseStochasticBean interface_top = chapterTCBAdBeanB.getInterface_top();
            if (interface_top != null) {
                return interface_top.getStochastic();
            }
            return null;
        }
        if (b == 1) {
            BaseStochasticBean content_bottom = chapterTCBAdBeanB.getContent_bottom();
            if (content_bottom != null) {
                return content_bottom.getStochastic();
            }
            return null;
        }
        if (b == 2) {
            BaseStochasticBean content_end = chapterTCBAdBeanB.getContent_end();
            if (content_end != null) {
                return content_end.getStochastic();
            }
            return null;
        }
        if (b == 3) {
            BaseStochasticBean content_page = chapterTCBAdBeanB.getContent_page();
            if (content_page != null) {
                return content_page.getStochastic();
            }
            return null;
        }
        if (b != 4) {
            if (b == 5 && (read_ad_lock = chapterTCBAdBeanB.getRead_ad_lock()) != null) {
                return read_ad_lock.getStochastic();
            }
            return null;
        }
        BaseStochasticBean content_page1 = chapterTCBAdBeanB.getContent_page1();
        if (content_page1 != null) {
            return content_page1.getStochastic();
        }
        return null;
    }
}
