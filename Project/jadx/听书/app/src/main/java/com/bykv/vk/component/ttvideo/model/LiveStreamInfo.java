package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.wp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LiveStreamInfo {
    public static final int LIVE_STREAM_INFO_CMAF_INVALID = 1;
    public static final int LIVE_STREAM_INFO_LLS_INVALID = 2;
    public static final String MPD_VERSION = "1.0";
    private JSONObject mCommonInfo;
    private String mDefaultResolution;
    private int mFlag;
    private String mHost;
    private String mIp;
    private boolean mIsABRListMatch;
    private String mRequestParams;
    private JSONObject mStreamInfo;
    private boolean mEnableOriginResolution = false;
    private long mAdjustedOriginBitRate = -1;
    private int mIsCodecSame = -1;
    private String mTransportProtocol = "";
    private String mPortNum = "";
    private int mRtcFallback = 0;
    private final String TAG = "LiveStreamInfo";
    public int mSRShorterSideUpperBound = 0;
    public int mSRLongerSideUpperBound = 0;
    private int mSRFrameRateUpperBound = 0;
    public int mSharpenLongerSideUpperBound = 0;
    public int mSharpenLongerSideLowerBound = 0;
    public int mSharpenShorterSideUpperBound = 0;
    public int mSharpenShorterSideLowerBound = 0;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        r6.mIsABRListMatch = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LiveStreamInfo(org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "list"
            java.lang.String r1 = "default"
            java.lang.String r2 = "common"
            r6.<init>()
            r3 = 0
            r6.mEnableOriginResolution = r3
            r4 = -1
            r6.mAdjustedOriginBitRate = r4
            r4 = -1
            r6.mIsCodecSame = r4
            java.lang.String r4 = ""
            r6.mTransportProtocol = r4
            r6.mPortNum = r4
            r6.mRtcFallback = r3
            java.lang.String r4 = "LiveStreamInfo"
            r6.TAG = r4
            r6.mSRShorterSideUpperBound = r3
            r6.mSRLongerSideUpperBound = r3
            r6.mSRFrameRateUpperBound = r3
            r6.mIsABRListMatch = r3
            r6.mSharpenLongerSideUpperBound = r3
            r6.mSharpenLongerSideLowerBound = r3
            r6.mSharpenShorterSideUpperBound = r3
            r6.mSharpenShorterSideLowerBound = r3
            if (r7 != 0) goto L32
            return
        L32:
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r7.getJSONObject(r5)     // Catch: org.json.JSONException -> La0
            r6.mStreamInfo = r5     // Catch: org.json.JSONException -> La0
            boolean r5 = r7.has(r2)     // Catch: org.json.JSONException -> La0
            if (r5 == 0) goto L46
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> La0
            r6.mCommonInfo = r7     // Catch: org.json.JSONException -> La0
        L46:
            org.json.JSONObject r7 = r6.mCommonInfo     // Catch: org.json.JSONException -> La0
            if (r7 == 0) goto La4
            java.lang.String r2 = "auto"
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> La0
            if (r7 == 0) goto L72
            boolean r2 = r7.has(r1)     // Catch: org.json.JSONException -> La0
            if (r2 == 0) goto L72
            java.lang.String r1 = r7.getString(r1)     // Catch: org.json.JSONException -> La0
            r6.mDefaultResolution = r1     // Catch: org.json.JSONException -> La0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> La0
            java.lang.String r2 = "mDefaultResolution: "
            r1.<init>(r2)     // Catch: org.json.JSONException -> La0
            java.lang.String r2 = r6.mDefaultResolution     // Catch: org.json.JSONException -> La0
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: org.json.JSONException -> La0
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> La0
            com.bykv.vk.component.ttvideo.log.MyLog.i(r4, r1)     // Catch: org.json.JSONException -> La0
        L72:
            r1 = 1
            r6.mIsABRListMatch = r1     // Catch: org.json.JSONException -> La0
            if (r7 == 0) goto La4
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> La0
            if (r1 == 0) goto La4
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> La0
            if (r7 == 0) goto La4
            int r0 = r7.length()     // Catch: org.json.JSONException -> La0
            if (r0 <= 0) goto La4
            r0 = r3
        L8a:
            int r1 = r7.length()     // Catch: org.json.JSONException -> La0
            if (r0 >= r1) goto La4
            java.lang.String r1 = r7.getString(r0)     // Catch: org.json.JSONException -> La0
            boolean r1 = r6.isSupport(r1)     // Catch: org.json.JSONException -> La0
            if (r1 != 0) goto L9d
            r6.mIsABRListMatch = r3     // Catch: org.json.JSONException -> La0
            goto La4
        L9d:
            int r0 = r0 + 1
            goto L8a
        La0:
            r7 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r7)
        La4:
            r6.mFlag = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.<init>(org.json.JSONObject):void");
    }

    public boolean setFlag(int i) {
        this.mFlag = i | this.mFlag;
        return true;
    }

    public void setRequestParams(String str) {
        this.mRequestParams = str;
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        this.mRequestParams = str;
        this.mIp = str2;
        this.mHost = str3;
    }

    public void setTransportProtocol(String str, String str2) {
        this.mTransportProtocol = str;
        this.mPortNum = str2;
    }

    public void setEnableOriginResolution(boolean z) {
        this.mEnableOriginResolution = z;
    }

    public String getStreamUrlForResolution(String str, String str2, String str3) {
        JSONObject jSONObject;
        String strOptString;
        String queryItems;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String strOptString2 = null;
        if (!TextUtils.isEmpty(str) && str.equals("auto")) {
            if (TextUtils.isEmpty(this.mDefaultResolution)) {
                return null;
            }
            return getMPDForFormat(str2, str3, this.mIp, this.mHost);
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            jSONObject2 = new JSONObject(this.mStreamInfo.optString(str));
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        if (jSONObject2.has(str3)) {
            jSONObject = new JSONObject(jSONObject2.optString(str3));
            try {
                jSONObject3 = new JSONObject(jSONObject.optString("sdk_params"));
            } catch (JSONException e2) {
                e = e2;
                wp.z(e);
            }
            strOptString = jSONObject3.has("SuggestFormat") ? jSONObject3.optString("SuggestFormat") : null;
        } else {
            strOptString = null;
            jSONObject = null;
        }
        boolean zEquals = LiveConfigKey.AVPH.equals(str2);
        String str4 = LiveConfigKey.FLV;
        if (zEquals) {
            str2 = LiveConfigKey.FLV;
        }
        if (strOptString == null || strOptString.equals("") || strOptString.equals(LiveConfigKey.AVPH)) {
            strOptString = str2;
        }
        if ((this.mFlag & 1) <= 0 || !strOptString.equals(LiveConfigKey.CMAF)) {
            str2 = strOptString;
        }
        if (this.mRtcFallback == 1 || (this.mFlag & 2) > 0) {
            str2 = LiveConfigKey.FLV;
        }
        if (jSONObject != null) {
            if (str2 == null || !str2.equals(LiveConfigKey.AVPH)) {
                str4 = str2;
            }
            strOptString2 = jSONObject.optString(str4);
        }
        if (strOptString2 == null || (queryItems = getQueryItems()) == null || queryItems.equals("")) {
            return strOptString2;
        }
        int iIndexOf = strOptString2.indexOf("?");
        if (iIndexOf == -1) {
            queryItems = "?" + queryItems.substring(1);
        } else if (iIndexOf == strOptString2.length() - 1) {
            queryItems = queryItems.substring(1);
        }
        return strOptString2 + queryItems;
    }

    public String getPortNum(String str, String str2, String str3) {
        String strOptString;
        if (this.mCommonInfo == null) {
            return null;
        }
        try {
            strOptString = new JSONObject(this.mCommonInfo.getJSONObject(str.equals(LiveConfigKey.RTMP) ? "rtmp_ports" : "http_ports").optString(str2)).optString(str3);
        } catch (JSONException e) {
            wp.z(e);
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String getAvLinesParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optString("AvLines");
            }
            return null;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public int getCheckSilenceInterval(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return -1;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optInt("CheckSilenceInterval");
            }
            return -1;
        } catch (JSONException e) {
            wp.z(e);
            return -1;
        }
    }

    public String getSuggestFormat(String str, String str2) {
        String strOptString;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            strOptString = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestFormat");
        } catch (JSONException e) {
            wp.z(e);
            strOptString = null;
        }
        if (strOptString == null || strOptString.isEmpty()) {
            return null;
        }
        return strOptString;
    }

    public String getSuggestProtocol(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestProtocol");
            str3 = LiveConfigKey.TCP;
        } catch (JSONException e) {
            wp.z(e);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getVCodec(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("VCodec");
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public long getBitrate(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("vbitrate");
        } catch (JSONException e) {
            wp.z(e);
            return 0L;
        }
    }

    public void setRtcFallback(int i) {
        this.mRtcFallback = i;
    }

    public boolean getSREnabled(String str, String str2, int i) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params"));
            long jOptLong = jSONObject.optLong("vbitrate");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NNSR"));
            int iOptInt = i == 1 ? jSONObject2.optInt("Enabled") : 0;
            long jOptLong2 = jSONObject2.optLong("VBitrateLowerBoundInKbps");
            this.mSRShorterSideUpperBound = jSONObject2.optInt("ShorterSideUpperBound");
            this.mSRLongerSideUpperBound = jSONObject2.optInt("LongerSideUpperBound");
            int iOptInt2 = jSONObject2.optInt("FrameRateUpperBound");
            this.mSRFrameRateUpperBound = iOptInt2;
            return iOptInt == 1 && jOptLong >= jOptLong2 * 1000 && this.mSRShorterSideUpperBound > 0 && this.mSRLongerSideUpperBound > 0 && iOptInt2 > 0;
        } catch (JSONException e) {
            wp.z(e);
            return false;
        }
    }

    public JSONObject getSharpenParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("ASF"));
            this.mSharpenLongerSideUpperBound = jSONObject.optInt("LongerSideUpperBound");
            this.mSharpenLongerSideLowerBound = jSONObject.optInt("LongerSideLowerBound");
            this.mSharpenShorterSideUpperBound = jSONObject.optInt("ShorterSideUpperBound");
            this.mSharpenShorterSideLowerBound = jSONObject.optInt("ShorterSideLowerBound");
            return jSONObject;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public boolean isSupportSharpen(int i, int i2) {
        int iMax = Math.max(i, i2);
        int iMin = Math.min(i, i2);
        return iMax >= this.mSharpenLongerSideLowerBound && iMax <= this.mSharpenLongerSideUpperBound && iMin >= this.mSharpenShorterSideLowerBound && iMin <= this.mSharpenShorterSideUpperBound;
    }

    public boolean isSupportSR(int i, int i2, float f) {
        return Math.max(i, i2) <= this.mSRLongerSideUpperBound && Math.min(i, i2) <= this.mSRShorterSideUpperBound && f <= ((float) this.mSRFrameRateUpperBound) && i < i2;
    }

    public long getGopDuration(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("gop");
        } catch (JSONException e) {
            wp.z(e);
            return 0L;
        }
    }

    public void setDefaultResolution(String str) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            this.mDefaultResolution = str;
        }
    }

    public String getDefaultResolution() {
        return this.mDefaultResolution;
    }

    public JSONObject getAbrInfo() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject("auto");
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public String getRuleIds() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("rule_ids")) {
            return null;
        }
        return this.mCommonInfo.optString("rule_ids");
    }

    public boolean isEnableAdaptive(String str) {
        JSONArray jSONArrayOptJSONArray;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject abrInfo = getAbrInfo();
            if (abrInfo != null && abrInfo.has("list") && (jSONArrayOptJSONArray = abrInfo.optJSONArray("list")) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String string = jSONArrayOptJSONArray.getString(i);
                    if (string != null && string.equals(str) && (!string.equals("origin") || this.mEnableOriginResolution)) {
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        return false;
    }

    public String getSessionID() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("session_id")) {
            return null;
        }
        return this.mCommonInfo.optString("session_id");
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("header");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.getString(next));
                }
                return map;
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return null;
    }

    public String getQueryItems() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("query")) {
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("query");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject2.getString(next);
                    String strEncode = URLEncoder.encode(next, "UTF-8");
                    sb.append("&").append(strEncode).append("=").append(URLEncoder.encode(string, "UTF-8"));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException | JSONException e) {
                wp.z(e);
            }
        }
        return null;
    }

    public String getSDKParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public String getLabelfromBitrate(long j, String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Iterator<String> itKeys = this.mStreamInfo.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (isEnableAdaptive(next) && j == getBitrate(next, str) / 1000) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean adjustOriginBitRate(String str, String str2, long j) {
        byte b;
        if (this.mAdjustedOriginBitRate > 0) {
            return true;
        }
        long j2 = -1;
        String str3 = LiveConfigKey.LOW;
        while (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(getStreamUrlForResolution(str3, str, str2))) {
                long bitrate = getBitrate(str3, str2);
                if (str3.equals("origin") && bitrate <= j2 && j > 0) {
                    this.mAdjustedOriginBitRate = j;
                    bitrate = j;
                }
                j2 = bitrate;
            }
            str3.hashCode();
            byte b2 = -1;
            switch (str3.hashCode()) {
                case -1008619738:
                    if (str3.equals("origin")) {
                        b2 = 0;
                    }
                    break;
                case 3324:
                    if (str3.equals(LiveConfigKey.HIGH)) {
                        b2 = 1;
                    }
                    break;
                case 3448:
                    if (str3.equals(LiveConfigKey.LOW)) {
                        b = 2;
                        b2 = b;
                    }
                    break;
                case 3665:
                    if (str3.equals(LiveConfigKey.STANDARD)) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 115761:
                    if (str3.equals(LiveConfigKey.UHD)) {
                        b = 4;
                        b2 = b;
                    }
                    break;
            }
            str3 = null;
            switch (b2) {
                case 1:
                    str3 = LiveConfigKey.UHD;
                    break;
                case 2:
                    str3 = LiveConfigKey.STANDARD;
                    break;
                case 3:
                    str3 = LiveConfigKey.HIGH;
                    break;
                case 4:
                    str3 = "origin";
                    break;
            }
        }
        return this.mAdjustedOriginBitRate > 0;
    }

    public boolean isCodecSame(String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        int i = this.mIsCodecSame;
        if (i >= 0) {
            return i == 1;
        }
        this.mIsCodecSame = 1;
        Iterator<String> itKeys = this.mStreamInfo.keys();
        String str2 = null;
        String vCodec = null;
        while (true) {
            if (!itKeys.hasNext()) {
                break;
            }
            vCodec = getVCodec(itKeys.next(), str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(vCodec) && !vCodec.equals(str2)) {
                this.mIsCodecSame = 0;
                break;
            }
            if (!TextUtils.isEmpty(vCodec)) {
                str2 = vCodec;
            }
        }
        if (TextUtils.isEmpty(vCodec) && TextUtils.isEmpty(str2)) {
            this.mIsCodecSame = 0;
        }
        return this.mIsCodecSame == 1;
    }

    public boolean isABRListMatch() {
        return this.mIsABRListMatch;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae A[Catch: JSONException -> 0x0150, TryCatch #0 {JSONException -> 0x0150, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00cd, B:36:0x00d5, B:40:0x00f4, B:42:0x00fe, B:44:0x010d, B:46:0x0118, B:47:0x011c, B:43:0x010a, B:24:0x0081, B:54:0x0134), top: B:65:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010a A[Catch: JSONException -> 0x0150, TryCatch #0 {JSONException -> 0x0150, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00cd, B:36:0x00d5, B:40:0x00f4, B:42:0x00fe, B:44:0x010d, B:46:0x0118, B:47:0x011c, B:43:0x010a, B:24:0x0081, B:54:0x0134), top: B:65:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0118 A[Catch: JSONException -> 0x0150, TryCatch #0 {JSONException -> 0x0150, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00cd, B:36:0x00d5, B:40:0x00f4, B:42:0x00fe, B:44:0x010d, B:46:0x0118, B:47:0x011c, B:43:0x010a, B:24:0x0081, B:54:0x0134), top: B:65:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getMPDForFormat(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getMPDForFormat(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private String set_url_port_scheme(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(".com");
        int iIndexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.mPortNum)) {
            if (iIndexOf3 != -1) {
                int i = iIndexOf3 + 5;
                int i2 = i + 1;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, this.mPortNum);
            } else if (iIndexOf2 != -1 && ((iIndexOf = str.indexOf("vhost")) == -1 || iIndexOf > iIndexOf2)) {
                sb.insert(iIndexOf2 + 4, ":" + this.mPortNum);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int iIndexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.mTransportProtocol)) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && iIndexOf4 != -1) {
                sb2.replace(0, iIndexOf4, "http");
            }
        }
        return sb2.toString();
    }

    public boolean isSupport(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mStreamInfo;
        if (jSONObject2 == null) {
            return false;
        }
        try {
            jSONObject = jSONObject2.getJSONObject(str);
        } catch (JSONException e) {
            wp.z(e);
            jSONObject = null;
        }
        return jSONObject != null;
    }

    private boolean isNeedUseDefaultResolution(String str) {
        return (TextUtils.isEmpty(str) || !str.equals("auto") || TextUtils.isEmpty(this.mDefaultResolution)) ? false : true;
    }

    public int getSRLongerSideUpperBound() {
        return this.mSRLongerSideUpperBound;
    }

    public int getSRShorterSideUpperBound() {
        return this.mSRShorterSideUpperBound;
    }
}
