package com.bykv.vk.component.ttvideo.player;

import android.util.Log;
import android.util.Pair;
import com.chinaums.pppay.unify.UnifyPayRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    static {
        HashMap map = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = map;
        map.put(UnifyPayRequest.CHANNEL_WEIXIN, 1);
        map.put(UnifyPayRequest.CHANNEL_ALIPAY, 2);
        map.put(UnifyPayRequest.CHANNEL_UMSPAY, 4);
        map.put(UnifyPayRequest.CHANNEL_ALIPAY_MINI_PROGRAM, 8);
        map.put("05", 16);
        map.put("06", 32);
        map.put("07", 64);
        map.put("08", 128);
        map.put("09", 256);
        HashMap map2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = map2;
        map2.put("00", 1);
        map2.put(UnifyPayRequest.CHANNEL_WEIXIN, 2);
        map2.put(UnifyPayRequest.CHANNEL_ALIPAY, 4);
        map2.put(UnifyPayRequest.CHANNEL_UMSPAY, 8);
        map2.put(UnifyPayRequest.CHANNEL_ALIPAY_MINI_PROGRAM, 16);
        map2.put("05", 32);
        map2.put("06", 64);
        map2.put("07", 128);
        map2.put("08", 256);
        map2.put("09", 512);
    }

    public static String getDolbyCodecs(int i, int i2) {
        String str;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        return str + ".0" + i + ".0" + i2;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(strGroup);
        if (num == null) {
            Log.w(TAG, "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        Log.w(TAG, "Unknown Dolby Vision level string: " + str2);
        return null;
    }
}
