package com.xiaomi.ad.mediation;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.v;
import com.xiaomi.ad.x;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class InterstitialTypeChecker {
    public static final String INTERSTITIAL_FULL_VIDEO = "22";
    public static final String INTERSTITIAL_FULL_VIDEO_HOR = "23";
    public static final String INTERSTITIAL_HALF_VIDEO = "24";
    public static final String INTERSTITIAL_HALF_VIDEO_HOR = "25";
    public static final String INTERSTITIAL_HALF_VIDEO_IMG = "26";
    public static final String INTERSTITIAL_HALF_VIDEO_IMG_HOR = "27";
    public static final String INTERSTITIAL_IMAGE = "20";
    public static final String INTERSTITIAL_IMAGE_HOR = "21";
    public static final String TAG = "InterstitialTypeChecker";
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;

    public static boolean checkInterstitialStyle(String str, int i) {
        String str2;
        boolean z = false;
        MLog.d(TAG, String.format("checkInterstitialStyle tagId: %s, type: %d", str, Integer.valueOf(i)));
        v vVarA = x.f().a();
        if (vVarA != null) {
            v.b bVarB = vVarA.b(str);
            if (bVarB != null) {
                String str3 = bVarB.h;
                MLog.d(TAG, "extraParams: " + str3);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        String strOptString = new JSONObject(str3).optString(TtmlNode.TAG_STYLE, "");
                        MLog.d(TAG, "style = " + strOptString);
                        if (i != 1 ? !(i != 2 || (!TextUtils.equals(INTERSTITIAL_FULL_VIDEO, strOptString) && !TextUtils.equals("23", strOptString))) : !(!TextUtils.equals("20", strOptString) && !TextUtils.equals(INTERSTITIAL_IMAGE_HOR, strOptString))) {
                            z = true;
                        }
                    } catch (JSONException e) {
                        MLog.e(TAG, "json exception: ", e);
                    }
                }
                return z;
            }
            str2 = "adPositionInfo is null";
        } else {
            str2 = "config is null";
        }
        MLog.d(TAG, str2);
        return z;
    }

    public static String getInterStitialType(String str) {
        String str2;
        v vVarA = x.f().a();
        if (vVarA != null) {
            v.b bVarB = vVarA.b(str);
            if (bVarB != null) {
                String str3 = bVarB.h;
                MLog.d(TAG, "extraParams: " + str3);
                if (TextUtils.isEmpty(str3)) {
                    return INTERSTITIAL_FULL_VIDEO;
                }
                try {
                    String strOptString = new JSONObject(str3).optString(TtmlNode.TAG_STYLE, "");
                    MLog.d(TAG, "style = " + strOptString);
                    return strOptString;
                } catch (JSONException e) {
                    MLog.e(TAG, "json exception: ", e);
                    return INTERSTITIAL_FULL_VIDEO;
                }
            }
            str2 = "adPositionInfo is null";
        } else {
            str2 = "config is null";
        }
        MLog.d(TAG, str2);
        return INTERSTITIAL_FULL_VIDEO;
    }
}
