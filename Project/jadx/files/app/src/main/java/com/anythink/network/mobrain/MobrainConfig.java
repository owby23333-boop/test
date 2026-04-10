package com.anythink.network.mobrain;

import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.anythink.core.api.ATAdConst;
import com.anythink.network.toutiao.TTATConst;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainConfig {
    int a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f12574e;
    public int mAdStyleType;
    public int mHeight;
    public int mWidth;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12575f = -1;
    public int mOrientation = 1;
    public String mUnitType = "";
    public String mRatio = "";
    public int mSize = 1;
    public int mRefreshTime = 0;
    public boolean mShowCloseButton = true;
    public int mAdCount = 1;
    public int mSplashButtonType = -1;
    public int mDownloadType = -1;
    public String mRewardName = "";
    public int mRewardAmount = 1;
    public String mUserId = "";
    public String mUserData = "";

    public static class KEY {
        public static final String MOBRAIN_SPLASH_NETWORK_FIRM_ID = "MOBRAIN_SPLASH_FIRM_ID";
        public static final String MORBAIN_DEFAULT_APP_ID = "MORBAIN_DEFAULT_APP_ID";
        public static final String MORBAIN_DEFAULT_PLACEMENT_ID = "MORBAIN_DEFAULT_PLACEMENT_ID";
    }

    public MobrainConfig(Context context, int i2) {
        this.mAdStyleType = i2;
        this.mWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    private void c(Map<String, Object> map) {
        String[] strArrSplit;
        String string = map.get("user_id") != null ? map.get("user_id").toString() : "";
        String string2 = map.get(ATAdConst.KEY.AD_WIDTH) != null ? map.get(ATAdConst.KEY.AD_WIDTH).toString() : "";
        this.mHeight = 0;
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.mWidth = Integer.parseInt(string2);
            }
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(this.mRatio) && (strArrSplit = this.mRatio.split(":")) != null && strArrSplit.length == 2) {
                this.mHeight = (this.mWidth / Integer.parseInt(strArrSplit[0])) * Integer.parseInt(strArrSplit[1]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(string)) {
            this.mUserId = string;
        }
        try {
            if (map.containsKey(ATAdConst.KEY.AD_SOUND)) {
                this.f12575f = Integer.parseInt(map.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused2) {
        }
    }

    private void d(Map<String, Object> map) {
        String string = map.get("reward_name") != null ? map.get("reward_name").toString() : "";
        String string2 = map.get("reward_amount") != null ? map.get("reward_amount").toString() : "";
        String string3 = map.get("user_id") != null ? map.get("user_id").toString() : "";
        String string4 = map.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
        if (!TextUtils.isEmpty(string)) {
            this.mRewardName = string;
        }
        try {
            if (!TextUtils.isEmpty(string2)) {
                this.mRewardAmount = Integer.parseInt(string2);
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(string3)) {
            this.mUserId = string3;
        }
        if (!TextUtils.isEmpty(string4)) {
            this.mUserData = string4;
        }
        try {
            if (map.containsKey(ATAdConst.KEY.AD_SOUND)) {
                this.f12575f = Integer.parseInt(map.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused2) {
        }
    }

    private void e(Map<String, Object> map) {
        String string = map.get(ATAdConst.KEY.AD_WIDTH) != null ? map.get(ATAdConst.KEY.AD_WIDTH).toString() : "";
        String string2 = map.get(ATAdConst.KEY.AD_HEIGHT) != null ? map.get(ATAdConst.KEY.AD_HEIGHT).toString() : "";
        int i2 = !TextUtils.isEmpty(string) ? Integer.parseInt(string) : 0;
        int i3 = !TextUtils.isEmpty(string2) ? Integer.parseInt(string2) : 0;
        if (i2 == 0 || i3 == 0) {
            switch (this.mSize) {
                case 1:
                    this.mHeight = (this.mWidth * 50) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 2:
                    this.mHeight = (this.mWidth * 100) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 3:
                    this.mHeight = (this.mWidth * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 4:
                    this.mHeight = (this.mWidth * 60) / 428;
                    break;
                case 5:
                    this.mHeight = (this.mWidth * 90) / 728;
                    break;
                case 6:
                    this.mHeight = 0;
                    break;
            }
        } else {
            this.mSize = 6;
            this.mWidth = i2;
            this.mHeight = i3;
        }
        try {
            if (map.containsKey(ATAdConst.KEY.AD_SOUND)) {
                this.f12575f = Integer.parseInt(map.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused) {
        }
    }

    private void f(Map<String, Object> map) {
        if (map.containsKey("default_info")) {
            try {
                JSONObject jSONObject = new JSONObject(map.get("default_info").toString());
                try {
                    this.a = Integer.parseInt(jSONObject.optString(KEY.MOBRAIN_SPLASH_NETWORK_FIRM_ID));
                } catch (Throwable unused) {
                }
                try {
                    this.b = jSONObject.optString(KEY.MORBAIN_DEFAULT_APP_ID);
                } catch (Throwable unused2) {
                }
                this.f12573d = jSONObject.optString(KEY.MORBAIN_DEFAULT_PLACEMENT_ID);
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0137 A[Catch: all -> 0x0162, TryCatch #0 {all -> 0x0162, blocks: (B:7:0x0013, B:9:0x0020, B:12:0x0060, B:14:0x0066, B:15:0x0069, B:16:0x006b, B:18:0x0071, B:20:0x0079, B:21:0x007b, B:23:0x0083, B:24:0x0085, B:26:0x008d, B:27:0x0094, B:53:0x00df, B:54:0x00e2, B:55:0x00e6, B:56:0x00e9, B:57:0x00ec, B:58:0x00ef, B:29:0x0098, B:32:0x00a2, B:35:0x00ac, B:38:0x00b6, B:41:0x00c0, B:44:0x00ca, B:62:0x00fd, B:64:0x0103, B:65:0x0109, B:68:0x0115, B:82:0x0134, B:83:0x0137, B:72:0x011e, B:75:0x0126, B:84:0x0139, B:86:0x013f, B:99:0x015c, B:100:0x015f, B:90:0x0148, B:93:0x0150), top: B:106:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.mobrain.MobrainConfig.a(java.util.Map):void");
    }

    final void b(Map<String, Object> map) {
        String string = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH).toString() : "";
        Object obj = null;
        if (map.containsKey(TTATConst.NATIVE_AD_IMAGE_HEIGHT)) {
            obj = map.get(TTATConst.NATIVE_AD_IMAGE_HEIGHT);
        } else if (map.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
            obj = map.get(ATAdConst.KEY.AD_HEIGHT);
        }
        int i2 = this.mWidth;
        int i3 = this.mHeight;
        try {
            if (!TextUtils.isEmpty(string)) {
                this.mWidth = (int) Double.parseDouble(string);
            }
        } catch (Throwable unused) {
        }
        if (obj != null) {
            try {
                this.mHeight = (int) Double.parseDouble(obj.toString());
            } catch (Throwable unused2) {
            }
        }
        if (this.mWidth <= 0) {
            this.mWidth = i2;
        }
        if (this.mHeight < 0) {
            this.mHeight = i3;
        }
        try {
            if (map.containsKey(ATAdConst.KEY.AD_SOUND)) {
                this.f12575f = Integer.parseInt(map.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r14) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.mobrain.MobrainConfig.a(org.json.JSONObject):void");
    }
}
