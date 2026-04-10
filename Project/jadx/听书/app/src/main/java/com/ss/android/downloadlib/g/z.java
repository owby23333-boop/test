package com.ss.android.downloadlib.g;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static final String z = "z";

    public static boolean z(com.ss.android.downloadlib.addownload.g.gc gcVar) {
        boolean z2;
        com.ss.android.z.z.gc.g gVarL = gcVar.g.l();
        String strG = gVarL == null ? null : gVarL.g();
        JSONObject jSONObjectZ = com.ss.android.downloadlib.e.m.z(new JSONObject(), gcVar);
        i.z(jSONObjectZ, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.a.z.z().g("applink_click", jSONObjectZ, gcVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(strG, gcVar);
        if (eVarZ.getType() == 2) {
            if (!TextUtils.isEmpty(strG)) {
                g("by_url", eVarZ, jSONObjectZ, gcVar);
            }
            eVarZ = com.ss.android.downloadlib.e.fo.z(wp.getContext(), gcVar.g.sy(), gcVar);
        }
        boolean z3 = false;
        if (z(gcVar.z) && wp.fo().optInt("link_ad_click_event") == 1) {
            if (gcVar.g instanceof com.ss.android.g.z.z.dl) {
                ((com.ss.android.g.z.z.dl) gcVar.g).dl(4);
            }
            com.ss.android.downloadlib.a.z.z().z(gcVar.z, 0);
            z2 = true;
        } else {
            z2 = false;
        }
        int type = eVarZ.getType();
        if (type == 1) {
            g("by_url", jSONObjectZ, gcVar);
        } else if (type == 3) {
            z("by_package", jSONObjectZ, gcVar);
        } else {
            if (type == 4) {
                z("by_package", eVarZ, jSONObjectZ, gcVar);
            } else {
                com.ss.android.downloadlib.gc.dl.z().g("AppLinkClick default");
            }
            if (z3 && !z2 && ((com.ss.android.downloadlib.a.dl.z().g() && !com.ss.android.downloadlib.a.dl.z().g(gcVar.z, gcVar.g.uf())) || com.ss.android.downloadlib.a.dl.z().dl())) {
                com.ss.android.downloadlib.a.z.z().z(gcVar.z, 2);
            }
            return z3;
        }
        z3 = true;
        if (z3) {
            com.ss.android.downloadlib.a.z.z().z(gcVar.z, 2);
        }
        return z3;
    }

    public static void z(com.ss.android.g.z.g.g gVar) {
        String strM = gVar.m();
        JSONObject jSONObjectZ = com.ss.android.downloadlib.e.m.z(new JSONObject(), gVar);
        i.z(jSONObjectZ, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.a.z.z().g("applink_click", jSONObjectZ, gVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(strM, gVar);
        if (eVarZ.getType() == 2) {
            if (!TextUtils.isEmpty(strM)) {
                g("notify_by_url", eVarZ, jSONObjectZ, gVar);
            }
            eVarZ = com.ss.android.downloadlib.e.fo.z(wp.getContext(), gVar.gc(), gVar);
        }
        int type = eVarZ.getType();
        if (type == 1) {
            g("notify_by_url", jSONObjectZ, gVar);
            return;
        }
        if (type == 3) {
            z("notify_by_package", jSONObjectZ, gVar);
        } else if (type == 4) {
            z("notify_by_package", eVarZ, jSONObjectZ, gVar);
        } else {
            com.ss.android.downloadlib.gc.dl.z().g("AppLinkClickNotification default");
        }
    }

    public static void g(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return;
        }
        String strM = com.ss.android.socialbase.downloader.i.z.dl().g("app_link_opt") == 1 ? gVar.m() : null;
        JSONObject jSONObjectZ = com.ss.android.downloadlib.e.m.z(new JSONObject(), gVar);
        i.z(jSONObjectZ, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.a.z.z().g("applink_click", jSONObjectZ, gVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(strM, gVar);
        if (eVarZ.getType() == 2) {
            if (!TextUtils.isEmpty(strM)) {
                g("dialog_by_url", eVarZ, jSONObjectZ, gVar);
            }
            eVarZ = com.ss.android.downloadlib.e.fo.z(wp.getContext(), gVar.gc(), gVar);
        }
        int type = eVarZ.getType();
        if (type == 1) {
            g("dialog_by_url", jSONObjectZ, gVar);
            return;
        }
        if (type == 3) {
            z("dialog_by_package", jSONObjectZ, gVar);
        } else if (type == 4) {
            z("dialog_by_package", eVarZ, jSONObjectZ, gVar);
        } else {
            com.ss.android.downloadlib.gc.dl.z().g("AppLinkClickDialog default");
        }
    }

    public static boolean z(String str, com.ss.android.g.z.g.g gVar) {
        if (!com.ss.android.downloadlib.addownload.fo.g(gVar.j())) {
            return false;
        }
        if (TextUtils.isEmpty(gVar.m()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.g.z().m(gVar.js());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.e.m.z(jSONObject, gVar);
        i.z(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.a.z.z().g("applink_click", gVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(gVar, gVar.m(), gVar.gc());
        int type = eVarZ.getType();
        if (type == 1) {
            g("auto_by_url", jSONObject, gVar);
            return true;
        }
        if (type == 2) {
            g("auto_by_url", eVarZ, jSONObject, gVar);
            return false;
        }
        if (type == 3) {
            z("auto_by_package", jSONObject, gVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        z("auto_by_package", eVarZ, jSONObject, gVar);
        return false;
    }

    public static void z(String str, final JSONObject jSONObject, final com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, "applink_source", str);
        i.z(jSONObject, "download_scene", Integer.valueOf(zVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("deeplink_app_open", jSONObject, zVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((wp.fo().optInt("check_applink_mode") & 1) != 0) {
                    i.z(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    gc.z().z(new a() { // from class: com.ss.android.downloadlib.g.z.1
                        @Override // com.ss.android.downloadlib.g.a
                        public void z(boolean z2) {
                            com.ss.android.downloadlib.a.z.z().g(z2 ? "deeplink_success" : "deeplink_failed", jSONObject, zVar);
                            if (z2) {
                                wp.q();
                                wp.getContext();
                                zVar.q();
                                zVar.zw();
                                zVar.iq();
                            }
                        }
                    });
                    break;
                } else {
                    wp.g();
                    wp.getContext();
                    zVar.q();
                    zVar.zw();
                    zVar.iq();
                    break;
                }
                break;
        }
    }

    public static void g(String str, final JSONObject jSONObject, final com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, "applink_source", str);
        i.z(jSONObject, "download_scene", Integer.valueOf(zVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("deeplink_url_open", jSONObject, zVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((wp.fo().optInt("check_applink_mode") & 1) != 0) {
                    i.z(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    gc.z().z(new a() { // from class: com.ss.android.downloadlib.g.z.2
                        @Override // com.ss.android.downloadlib.g.a
                        public void z(boolean z2) {
                            com.ss.android.downloadlib.a.z.z().g(z2 ? "deeplink_success" : "deeplink_failed", jSONObject, zVar);
                            if (z2) {
                                wp.q();
                                wp.getContext();
                                zVar.q();
                                zVar.zw();
                                zVar.iq();
                            }
                        }
                    });
                    break;
                } else {
                    wp.g();
                    wp.getContext();
                    zVar.q();
                    zVar.zw();
                    zVar.iq();
                    break;
                }
                break;
        }
    }

    public static void z(String str, com.ss.android.downloadlib.addownload.g.e eVar, JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, "applink_source", str);
        i.z(jSONObject, "error_code", Integer.valueOf(eVar.z()));
        i.z(jSONObject, "download_scene", Integer.valueOf(zVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("deeplink_app_open_fail", jSONObject, zVar);
    }

    public static void g(String str, com.ss.android.downloadlib.addownload.g.e eVar, JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, "applink_source", str);
        i.z(jSONObject, "error_code", Integer.valueOf(eVar.z()));
        i.z(jSONObject, "download_scene", Integer.valueOf(zVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("deeplink_url_open_fail", jSONObject, zVar);
    }

    public static boolean z(com.ss.android.downloadlib.addownload.g.gc gcVar, int i) {
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("market_click_open", jSONObject, gcVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(wp.getContext(), gcVar, gcVar.g.sy());
        String strZ = i.z(eVarZ.g(), "open_market");
        int type = eVarZ.getType();
        if (type == 5) {
            z(strZ, jSONObject, gcVar, true);
        } else {
            if (type == 6) {
                i.z(jSONObject, "error_code", Integer.valueOf(eVarZ.z()));
                i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
                com.ss.android.downloadlib.a.z.z().g("market_open_failed", jSONObject, gcVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.a.z.z().z(gcVar.z, i);
        return true;
    }

    public static void z(final String str, final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.g.gc gcVar, boolean z2) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.gc.dl.z().z(e, "onMarketSuccess");
                return;
            }
        }
        i.z(jSONObject, "applink_source", str);
        i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
        if (z2) {
            com.ss.android.downloadlib.a.z.z().g("market_open_success", jSONObject, gcVar);
        }
        if ((wp.fo().optInt("check_applink_mode") & 4) != 0) {
            gc.z().g(new a() { // from class: com.ss.android.downloadlib.g.z.3
                @Override // com.ss.android.downloadlib.g.a
                public void z(boolean z3) {
                    if (!z3 && !"open_market".equals(str)) {
                        z.z(com.ss.android.downloadlib.e.fo.z(wp.getContext(), Uri.parse("market://details?id=" + gcVar.gc())), gcVar, false);
                    }
                    com.ss.android.downloadlib.a.z.z().z(z3 ? "market_delay_success" : "market_delay_failed", jSONObject, gcVar);
                    if (z3) {
                        wp.q();
                        wp.getContext();
                    }
                }
            });
        } else {
            wp.g();
            wp.getContext();
        }
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(gcVar.g.sy());
        if (gVarZ != null) {
            com.ss.android.downloadlib.e.wp.z().z(z, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.ss.android.downloadlib.e.wp.z().z(z, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            gVarZ = new com.ss.android.g.z.g.g(gcVar.g, gcVar.dl, gcVar.f1987a);
        }
        gVarZ.gc(2);
        gVarZ.m(System.currentTimeMillis());
        gVarZ.gz(4);
        gVarZ.fo(2);
        com.ss.android.downloadlib.addownload.g.m.z().z(gVarZ);
        com.ss.android.downloadlib.e.wp.z().z(z, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.fo.z().z(gcVar, gVarZ);
    }

    public static void z(com.ss.android.downloadlib.addownload.g.e eVar, com.ss.android.downloadlib.addownload.g.gc gcVar, boolean z2) {
        String strZ = i.z(eVar.g(), "open_market");
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = eVar.getType();
        if (type == 5) {
            z(strZ, jSONObject, gcVar, z2);
        } else {
            if (type != 6) {
                return;
            }
            i.z(jSONObject, "error_code", Integer.valueOf(eVar.z()));
            i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
            com.ss.android.downloadlib.a.z.z().g("market_open_failed", jSONObject, gcVar);
        }
    }

    public static boolean z(long j) {
        return com.ss.android.downloadlib.addownload.g.m.z().a(j) == null;
    }
}
