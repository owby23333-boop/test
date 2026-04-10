package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.google.common.base.Ascii;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static e z(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, com.bytedance.sdk.component.adexpress.g.i iVar) {
        if (context == null || dynamicBaseWidget == null || eVar == null) {
            return null;
        }
        String strXl = eVar.xl();
        String strHh = iVar.hh();
        strXl.hashCode();
        byte b = -1;
        switch (strXl.hashCode()) {
            case 48:
                if (strXl.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (strXl.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strXl.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strXl.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strXl.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strXl.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strXl.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 6;
                }
                break;
            case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                if (strXl.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 7;
                }
                break;
            case 1567:
                if (strXl.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strXl.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (strXl.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (strXl.equals("13")) {
                    b = 11;
                }
                break;
            case 1571:
                if (strXl.equals("14")) {
                    b = 12;
                }
                break;
            case 1573:
                if (strXl.equals("16")) {
                    b = 13;
                }
                break;
            case 1574:
                if (strXl.equals("17")) {
                    b = 14;
                }
                break;
            case 1575:
                if (strXl.equals("18")) {
                    b = 15;
                }
                break;
            case 1598:
                if (strXl.equals("20")) {
                    b = 16;
                }
                break;
            case 1600:
                if (strXl.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (strXl.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (strXl.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strXl.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (strXl.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                return new gc(context, dynamicBaseWidget, eVar);
            case 1:
                return new dl(context, dynamicBaseWidget, eVar);
            case 2:
                return new g(context, dynamicBaseWidget, eVar);
            case 3:
                if (eVar.gp() == 1) {
                    return new p(context, dynamicBaseWidget, eVar, eVar.zx());
                }
                return new ls(context, dynamicBaseWidget, eVar);
            case 4:
            case 9:
                return new i(context, dynamicBaseWidget, eVar);
            case 5:
            case 12:
                return new kb(context, dynamicBaseWidget, eVar);
            case 6:
                return new wp(context, dynamicBaseWidget, eVar);
            case 7:
            case 13:
                return new v(context, dynamicBaseWidget, eVar, strXl, uyVar, iVar.fo(), iVar.h());
            case 8:
                return new a(context, dynamicBaseWidget, eVar);
            case 10:
                return new ls(context, dynamicBaseWidget, eVar);
            case 11:
                return new p(context, dynamicBaseWidget, eVar);
            case 14:
            case 15:
                return new js(context, dynamicBaseWidget, eVar, strXl, uyVar, iVar.fo(), iVar.h());
            case 16:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    return new uy(context, dynamicBaseWidget, eVar, strHh + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new uy(context, dynamicBaseWidget, eVar, TextUtils.isEmpty(strHh) ? null : strHh + "brush_mask.json", "20");
            case 17:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    return new uy(context, dynamicBaseWidget, eVar, strHh + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new fv(context, dynamicBaseWidget, eVar);
            case 18:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    return new uy(context, dynamicBaseWidget, eVar, strHh + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case 19:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    return new z(context, dynamicBaseWidget, eVar);
                }
                return new uy(context, dynamicBaseWidget, eVar, TextUtils.isEmpty(strHh) ? null : strHh + "swiper_up_star.json", "24");
            case 20:
                if (com.bytedance.sdk.component.adexpress.a.z()) {
                    return new uy(context, dynamicBaseWidget, eVar, strHh + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case 21:
                return new m(context, dynamicBaseWidget, eVar, uyVar, iVar.fo(), iVar.h());
            default:
                return null;
        }
    }
}
