package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.io;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static int z(na naVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL;
        JSONObject jSONObjectDl;
        int iOptInt;
        if (naVar == null || (zVarL = naVar.l()) == null || (jSONObjectDl = zVarL.dl()) == null || (iOptInt = jSONObjectDl.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    public static boolean g(na naVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL;
        JSONObject jSONObjectDl;
        return (naVar == null || (zVarL = naVar.l()) == null || (jSONObjectDl = zVarL.dl()) == null || jSONObjectDl.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean dl(na naVar) {
        if (naVar == null) {
            return false;
        }
        int iSy = naVar.sy();
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVarHh = naVar.hh();
        return zVarHh != null && iSy == 1 && zVarHh.a() == 4;
    }

    public static boolean a(na naVar) {
        if (naVar == null) {
            return false;
        }
        int iSy = naVar.sy();
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVarHh = naVar.hh();
        return zVarHh != null && iSy == 1 && zVarHh.a() == 3;
    }

    public static boolean gc(na naVar) {
        if (naVar == null) {
            return false;
        }
        int iSy = naVar.sy();
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVarHh = naVar.hh();
        return zVarHh != null && iSy == 1 && zVarHh.a() == 2;
    }

    public static boolean m(na naVar) {
        if (naVar == null) {
            return false;
        }
        return e(naVar) || gz(naVar);
    }

    public static boolean e(na naVar) {
        return (naVar == null || naVar.sy() != 1 || js.z(naVar)) ? false : true;
    }

    public static boolean gz(na naVar) {
        return naVar != null && naVar.fv() > 0;
    }

    public static JSONObject z(na naVar, View view, boolean z) {
        int i;
        JSONObject jSONObjectKv = naVar.kv();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.gk.z zVarFv = zw.g().fv(String.valueOf(eo.fo(naVar)));
            if (com.bytedance.sdk.openadsdk.core.component.reward.a.a.z(naVar) == 4) {
                i = zVarFv.dl;
            } else {
                i = zVarFv.kb;
            }
            if (eo.gc(naVar)) {
                i = zVarFv.dl;
            }
            boolean z2 = false;
            jSONObject.put("voice_control", i == 1);
            Context context = zw.getContext();
            jSONObject3.put(MediaFormat.KEY_WIDTH, oq.a(context, oq.a(context)));
            jSONObject3.put(MediaFormat.KEY_HEIGHT, oq.a(context, oq.gc(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(MediaFormat.KEY_WIDTH, oq.a(context, width) * 1.0f);
                jSONObject4.put(MediaFormat.KEY_HEIGHT, oq.a(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            jSONObjectKv.put("env_info", jSONObject2);
            jSONObjectKv.put("setting", jSONObject);
            jSONObjectKv.put("meta_hashcode", naVar.gc());
            if (z && zw.g().xo()) {
                z2 = true;
            }
            jSONObjectKv.put("gesture_through_enable", z2);
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObjectKv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final boolean z, final String str, final dl dlVar) {
        if (dlVar != null) {
            com.bytedance.sdk.component.utils.gz.g().post(new com.bytedance.sdk.component.uy.fo("tt_ugen_tpl") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.uy.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        dlVar.z(str);
                    } else {
                        dlVar.z();
                    }
                }
            });
        }
    }

    private static void g(String str, final String str2, final dl dlVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            g(false, (String) null, dlVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
        if (dlVarDl == null) {
            g(false, (String) null, dlVar);
        } else {
            dlVarDl.z(str);
            dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.uy.2
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar != null) {
                        try {
                            if (gVar.gz() && gVar.a() != null) {
                                com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("ugeno_template_kv");
                                String strA = gVar.a();
                                dlVarZ.put(str2, strA);
                                uy.g(true, strA, dlVar);
                                return;
                            }
                        } catch (Exception unused) {
                            uy.g(false, (String) null, dlVar);
                            return;
                        }
                    }
                    uy.g(false, (String) null, dlVar);
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    uy.g(false, (String) null, dlVar);
                }
            });
        }
    }

    public static boolean fo(na naVar) {
        return (naVar == null || naVar.vx() == null) ? false : true;
    }

    public static boolean z(Context context, na naVar, String str) {
        return g(context, naVar, str) == 1;
    }

    public static int g(Context context, na naVar, String str) {
        if (naVar == null) {
            return -1;
        }
        io ioVarVx = naVar.vx();
        if (ioVarVx == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String strG = ioVarVx.g();
        if (z(strG, ioVarVx.dl(), (dl) null) == null) {
            return TextUtils.isEmpty(strG) ? 2 : 3;
        }
        return 1;
    }

    public static String z(Context context, String str, na naVar, String str2) {
        io ioVarVx = naVar.vx();
        JSONObject jSONObjectBg = naVar.bg();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String strHe = naVar.he();
            if (!TextUtils.isEmpty(strHe)) {
                jSONObject.put("description", strHe);
            }
            if (jSONObjectBg != null) {
                jSONObject.put("easy_pl_material", jSONObjectBg.toString());
            }
            if (ioVarVx != null) {
                jSONObject.put("ugen_dialog_url", ioVarVx.g());
                jSONObject.put("ugen_dialog_md5", ioVarVx.dl());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    public static JSONObject z(String str, String str2, dl dlVar) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (dlVar != null) {
                dlVar.z();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("ugeno_template_kv");
        if (dlVarZ == null) {
            if (dlVar != null) {
                dlVar.z();
            }
            return null;
        }
        try {
            str3 = dlVarZ.get(str2, "");
        } catch (Exception unused) {
            if (dlVar != null) {
                dlVar.z();
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (dlVar != null) {
                dlVar.z(str3);
            }
            return new JSONObject(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            g(str, str2, dlVar);
            return null;
        }
        if (dlVar != null) {
            dlVar.z();
        }
        return null;
    }
}
