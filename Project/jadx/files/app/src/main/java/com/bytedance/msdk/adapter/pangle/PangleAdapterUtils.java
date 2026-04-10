package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.anythink.core.api.ATAdConst;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PangleAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;
    public static final String MEDIA_EXTRA_COUPON = "coupon";
    public static final String MEDIA_EXTRA_LIVE_ROOM = "live_room";
    public static final String MEDIA_EXTRA_PRODUCT = "product";

    /* JADX INFO: renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GMAdConstant.GroMoreRitScenes.values().length];

        static {
            try {
                b[GMAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[GMAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            a = new int[TTAdConstant.GroMoreRitScenes.values().length];
            try {
                a[TTAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[TTAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private static TTAdConstant.RitScenes a(TTAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (AnonymousClass1.a[groMoreRitScenes.ordinal()]) {
            case 1:
                return TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
            case 2:
                return TTAdConstant.RitScenes.HOME_OPEN_BONUS;
            case 3:
                return TTAdConstant.RitScenes.HOME_SVIP_BONUS;
            case 4:
                return TTAdConstant.RitScenes.HOME_GET_PROPS;
            case 5:
                return TTAdConstant.RitScenes.HOME_TRY_PROPS;
            case 6:
                return TTAdConstant.RitScenes.HOME_GET_BONUS;
            case 7:
                return TTAdConstant.RitScenes.HOME_GIFT_BONUS;
            case 8:
                return TTAdConstant.RitScenes.GAME_START_BONUS;
            case 9:
                return TTAdConstant.RitScenes.GAME_REDUCE_WAITING;
            case 10:
                return TTAdConstant.RitScenes.GAME_MORE_KLLKRTUNITIES;
            case 11:
                return TTAdConstant.RitScenes.GAME_FINISH_REWARDS;
            case 12:
                return TTAdConstant.RitScenes.GAME_GIFT_BONUS;
            default:
                return null;
        }
    }

    private static TTAdConstant.RitScenes a(GMAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (AnonymousClass1.b[groMoreRitScenes.ordinal()]) {
            case 1:
                return TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
            case 2:
                return TTAdConstant.RitScenes.HOME_OPEN_BONUS;
            case 3:
                return TTAdConstant.RitScenes.HOME_SVIP_BONUS;
            case 4:
                return TTAdConstant.RitScenes.HOME_GET_PROPS;
            case 5:
                return TTAdConstant.RitScenes.HOME_TRY_PROPS;
            case 6:
                return TTAdConstant.RitScenes.HOME_GET_BONUS;
            case 7:
                return TTAdConstant.RitScenes.HOME_GIFT_BONUS;
            case 8:
                return TTAdConstant.RitScenes.GAME_START_BONUS;
            case 9:
                return TTAdConstant.RitScenes.GAME_REDUCE_WAITING;
            case 10:
                return TTAdConstant.RitScenes.GAME_MORE_KLLKRTUNITIES;
            case 11:
                return TTAdConstant.RitScenes.GAME_FINISH_REWARDS;
            case 12:
                return TTAdConstant.RitScenes.GAME_GIFT_BONUS;
            default:
                return null;
        }
    }

    private static Map<String, String> a() {
        return GMMediationAdSdk.getPangleExtraData();
    }

    static JSONArray a(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    private static void a(AdSlot.Builder builder, String str, String str2, boolean z2) {
        JSONArray pangleDataAndExtraData = getPangleDataAndExtraData();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", "mediation_sdk_version");
            jSONObject.putOpt("value", "3.9.0.2");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_req_type");
            jSONObject2.putOpt("value", "1");
            JSONObject jSONObject3 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject3 = new JSONObject();
                jSONObject3.putOpt("name", "waterfall_abtest");
                jSONObject3.putOpt("value", str);
            }
            pangleDataAndExtraData.put(jSONObject2);
            pangleDataAndExtraData.put(jSONObject);
            if (jSONObject3 != null) {
                pangleDataAndExtraData.put(jSONObject3);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt("value", str2);
                pangleDataAndExtraData.put(jSONObject4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z2) {
            setPanglePreviewParam(builder);
        }
        TTAdSdk.updatePaid(GMMediationAdSdk.getPanglePaid());
        if (builder != null) {
            builder.setUserData(pangleDataAndExtraData.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.openadsdk.AdSlot.Builder buildPangleAdSlot(com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.api.v2.slot.GMAdSlotBase r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = new com.bytedance.sdk.openadsdk.AdSlot$Builder
            r0.<init>()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r5 = r0.setCodeId(r5)
            r0 = 1
            com.bytedance.sdk.openadsdk.AdSlot$Builder r5 = r5.setAdCount(r0)
            if (r3 == 0) goto L77
            com.bytedance.msdk.api.TTRequestExtraParams r0 = r3.getReuestParam()
            java.util.Map r0 = r0.getExtraObject()
            r1 = 0
            if (r0 == 0) goto L28
            java.lang.String r2 = "pangle_vid"
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L24
            int[] r0 = (int[]) r0     // Catch: java.lang.Throwable -> L24
            goto L29
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r0 = r1
        L29:
            int r1 = r3.getAdloadSeq()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r5.setAdloadSeq(r1)
            java.lang.String r2 = r3.getAdUnitId()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r1.setPrimeRit(r2)
            boolean r2 = r3.isSupportDeepLink()
            r1.setSupportDeepLink(r2)
            if (r0 == 0) goto L48
            int r1 = r0.length
            if (r1 <= 0) goto L48
            r5.setExternalABVid(r0)
        L48:
            if (r4 != 0) goto L5e
            int r4 = r3.getAdType()
            r0 = 5
            if (r0 == r4) goto L59
            int r4 = r3.getAdType()
            r0 = 9
            if (r0 != r4) goto L77
        L59:
            int r3 = r3.getAdCount()
            goto L68
        L5e:
            boolean r3 = r4 instanceof com.bytedance.msdk.api.v2.slot.GMAdSlotNative
            if (r3 == 0) goto L6c
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r4 = (com.bytedance.msdk.api.v2.slot.GMAdSlotNative) r4
            int r3 = r4.getRequestCount()
        L68:
            r5.setAdCount(r3)
            goto L77
        L6c:
            boolean r3 = r4 instanceof com.bytedance.msdk.api.v2.slot.GMAdSlotDraw
            if (r3 == 0) goto L77
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r4 = (com.bytedance.msdk.api.v2.slot.GMAdSlotDraw) r4
            int r3 = r4.getAdCount()
            goto L68
        L77:
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L80
            r5.withBid(r8)
        L80:
            a(r5, r6, r7, r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.v2.slot.GMAdSlotBase, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):com.bytedance.sdk.openadsdk.AdSlot$Builder");
    }

    public static AdSlot.Builder buildPangleAdSlot(com.bytedance.msdk.api.AdSlot adSlot, String str, String str2, String str3, String str4, boolean z2) {
        return buildPangleAdSlot(adSlot, null, str, str2, str3, str4, z2);
    }

    public static int dp2px(@NonNull Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static long getAdId(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(GMAdConstant.EXTRA_ADID) != null) {
                return ((Long) map.get(GMAdConstant.EXTRA_ADID)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static long getCreativeId(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static String getCustomRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.CUSTOMIZE_RIT_SCENES);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static String getPangleData() {
        return GMMediationAdSdk.getPangleData();
    }

    public static JSONArray getPangleDataAndExtraData() {
        JSONArray jSONArrayA = a(getPangleData());
        try {
            Map<String, String> mapA = a();
            if (mapA != null && mapA.size() > 0) {
                for (String str : mapA.keySet()) {
                    String str2 = mapA.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt("value", str2);
                        jSONArrayA.put(jSONObject);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArrayA;
    }

    public static String getReqId(Map<String, Object> map) {
        if (map == null || map.get(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID) == null) {
            return null;
        }
        return (String) map.get(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID);
    }

    public static TTAdConstant.RitScenes getRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.RIT_SCENES);
        if (obj instanceof TTAdConstant.GroMoreRitScenes) {
            return a((TTAdConstant.GroMoreRitScenes) obj);
        }
        if (obj instanceof GMAdConstant.GroMoreRitScenes) {
            return a((GMAdConstant.GroMoreRitScenes) obj);
        }
        return null;
    }

    public static double getValue(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof Float) && !(obj instanceof Double)) {
            try {
                return obj instanceof String ? Double.valueOf((String) obj).doubleValue() : CPM_DEFLAUT_VALUE;
            } catch (Exception unused) {
                return CPM_DEFLAUT_VALUE;
            }
        }
        return ((Double) obj).doubleValue();
    }

    public static void setPangleData(String str) {
        GMMediationAdSdk.setPangleData(str);
    }

    public static void setPanglePreviewParam(AdSlot.Builder builder) {
        if (builder != null && GMMediationAdSdk.isTestDemo()) {
            try {
                String valueFromPPeInfo = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_ad_id");
                String valueFromPPeInfo2 = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_creative_id");
                String valueFromPPeInfo3 = GMMediationAdSdk.getValueFromPPeInfo("tt_pangle_preview_ext");
                if (TextUtils.isEmpty(valueFromPPeInfo) || TextUtils.isEmpty(valueFromPPeInfo2) || TextUtils.isEmpty(valueFromPPeInfo3)) {
                    return;
                }
                builder.setAdId(valueFromPPeInfo).setCreativeId(valueFromPPeInfo2).setExt(valueFromPPeInfo3);
            } catch (Throwable unused) {
            }
        }
    }
}
