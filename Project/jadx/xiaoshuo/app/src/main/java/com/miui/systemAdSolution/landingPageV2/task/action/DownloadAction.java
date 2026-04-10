package com.miui.systemAdSolution.landingPageV2.task.action;

import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import com.miui.zeus.msa.framework.model.DownloadConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class DownloadAction extends Action<IDownloadListener> {
    public static final int DOWNLOAD_SOURCE_DEFAULT = 3;
    public static final int DOWNLOAD_SOURCE_MIMARKET = 1;
    public static final int FLOAT_CARD_BOTTOM = -1;
    public static final int FLOAT_CARD_TOP = 1;
    public static final int FLOAT_CARD_UNDEFINED = 0;
    public static final int MARKET_CARD_UNDEFINED = 0;
    public static final int MARKET_DETAIL_CARD = 2;
    public static final int MARKET_FLOAT_CARD = 3;
    public static final int MARKET_MINI_CARD = 1;
    private static final String TAG = "DownloadAction";
    private DownloadInfo mDownloadInfo;
    private int mDownloadSource;
    private boolean mIsDownloadAutoStart;
    private boolean mIsDownloadByMiniCard;
    private MiniCardConfig mMiniCardConfig;
    private String mPackageName;

    public static class MiniCardConfig {
        private static final String KEY_CAN_CANCEL = "canCancel";
        private static final String KEY_DISMISS_WHEN_DOWNLOADSTART = "dismissWhenDownloadStart";
        private boolean canCancel;
        private boolean dismissWhenDownloadStart;

        public MiniCardConfig(boolean z, boolean z2) {
            this.canCancel = z;
            this.dismissWhenDownloadStart = z2;
        }

        public static MiniCardConfig deserialize(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new MiniCardConfig(jSONObject.optBoolean(KEY_CAN_CANCEL), jSONObject.optBoolean("dismissWhenDownloadStart"));
            } catch (Exception e) {
                Log.e(DownloadAction.TAG, "parse MiniCardConfig e : ", e);
                return null;
            }
        }

        public boolean getDismissWhenDownloadStart() {
            return this.dismissWhenDownloadStart;
        }

        public String serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CAN_CANCEL, this.canCancel);
                jSONObject.put("dismissWhenDownloadStart", this.dismissWhenDownloadStart);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public DownloadAction(Parcel parcel) {
        super(parcel);
        if (parcel != null) {
            try {
                String string = parcel.readString();
                this.mPackageName = string;
                if (TextUtils.isEmpty(string)) {
                    this.mPackageName = getRealOrFakePackageName();
                }
                this.mDownloadSource = parcel.readInt();
                this.mIsDownloadByMiniCard = parseIntToBoolean(parcel.readInt());
                this.mIsDownloadAutoStart = parseIntToBoolean(parcel.readInt());
                this.mMiniCardConfig = MiniCardConfig.deserialize(parcel.readString());
                DownloadInfo downloadInfo = parseDownloadInfo(parcel.readString());
                this.mDownloadInfo = downloadInfo;
                if (downloadInfo == null) {
                    this.mDownloadInfo = new DownloadInfo();
                }
            } catch (Exception e) {
                Log.e(TAG, "DownloadAction parse parcel e : ", e);
            }
        }
    }

    private static String getRealOrFakePackageName() {
        String str = "FAKE_PACKAGE:" + String.valueOf(System.currentTimeMillis()).hashCode();
        Log.w(TAG, "generate fake packageName[" + str + "]");
        return str;
    }

    private final DownloadInfo parseDownloadInfo(String str) {
        try {
            return DownloadInfo.deserialize(str);
        } catch (Exception e) {
            Log.e(TAG, "parse DownloadInfo e : ", e);
            return null;
        }
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public int getActionType() {
        return 3;
    }

    public DownloadConfig getDownloadConfig() {
        DownloadConfig downloadConfig = new DownloadConfig();
        downloadConfig.trackInfo = getAdTracKInfo();
        downloadConfig.marketType = getMarketDownloadType();
        downloadConfig.floatCardPos = getMarketFloatCardPosition();
        downloadConfig.autoDownload = isDownloadAutoStart();
        downloadConfig.finishWhenStart = getMiniCardConfig().getDismissWhenDownloadStart();
        return downloadConfig;
    }

    public DownloadInfo getDownloadInfo() {
        return this.mDownloadInfo;
    }

    public int getDownloadSource() {
        return this.mDownloadSource;
    }

    public int getMarketDownloadType() {
        return this.mDownloadInfo.marketDownloadType;
    }

    public int getMarketFloatCardPosition() {
        return this.mDownloadInfo.marketFloatCardPosition;
    }

    public MiniCardConfig getMiniCardConfig() {
        return this.mMiniCardConfig;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean isDownloadAutoStart() {
        return this.mIsDownloadAutoStart;
    }

    public boolean isIsDownloadByMiniCard() {
        return this.mIsDownloadByMiniCard;
    }

    public void setMarketDownloadType(int i) {
        this.mDownloadInfo.marketDownloadType = i;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mPackageName);
        parcel.writeInt(this.mDownloadSource);
        parcel.writeInt(parseBooleanToInt(this.mIsDownloadByMiniCard));
        parcel.writeInt(parseBooleanToInt(this.mIsDownloadAutoStart));
        parcel.writeString(this.mMiniCardConfig.serialize());
        parcel.writeString(this.mDownloadInfo.serialize());
    }

    @Override // com.miui.systemAdSolution.landingPageV2.task.action.Action
    public IDownloadListener readBinder(IBinder iBinder) {
        return IDownloadListener.Stub.asInterface(iBinder);
    }

    public static class DownloadInfo {
        private static final String KEY_CATEGORY = "category";
        private static final String KEY_DOWNLOAD_URL = "downloadUrl";
        private static final String KEY_ICON_URL = "iconUrl";
        private static final String KEY_MARKET_DOWNLOAD_TYPE = "marketDownloadType";
        private static final String KEY_MARKET_FLOATCARD_POSITION = "marketFloatCardPosition";
        private static final String KEY_SIZE = "size";
        private static final String KEY_SUMMARY = "summary";
        private static final String KEY_TITLE = "title";
        private String category;
        private String downloadUrl;
        private String iconUrl;
        int marketDownloadType;
        int marketFloatCardPosition;
        private long size;
        private String summary;
        private String title;

        public DownloadInfo() {
            this.marketDownloadType = 0;
            this.marketFloatCardPosition = 0;
        }

        public static DownloadInfo deserialize(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new DownloadInfo(jSONObject.optString("downloadUrl"), jSONObject.optString("iconUrl"), jSONObject.optString("title"), jSONObject.optString(KEY_SUMMARY), jSONObject.optInt("size"), jSONObject.optString("category"), jSONObject.optInt("marketDownloadType"), jSONObject.optInt(KEY_MARKET_FLOATCARD_POSITION));
            } catch (Exception e) {
                Log.e(DownloadAction.TAG, "parse MiniCardConfig e : ", e);
                return null;
            }
        }

        public String serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("downloadUrl", this.downloadUrl);
                jSONObject.put("iconUrl", this.iconUrl);
                jSONObject.put("title", this.title);
                jSONObject.put(KEY_SUMMARY, this.summary);
                jSONObject.put("size", this.size);
                jSONObject.put("category", this.category);
                jSONObject.put("marketDownloadType", this.marketDownloadType);
                jSONObject.put(KEY_MARKET_FLOATCARD_POSITION, this.marketFloatCardPosition);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public DownloadInfo(String str, String str2, String str3, String str4, int i, String str5, int i2, int i3) {
            this.downloadUrl = str;
            this.iconUrl = str2;
            this.title = str3;
            this.summary = str4;
            this.size = i;
            this.category = str5;
            this.marketDownloadType = i2;
            this.marketFloatCardPosition = i3;
        }

        public DownloadInfo(String str, String str2, String str3, String str4, long j, String str5) {
            this.marketDownloadType = 0;
            this.marketFloatCardPosition = 0;
            this.downloadUrl = str;
            this.iconUrl = str2;
            this.title = str3;
            this.summary = str4;
            this.size = j;
            this.category = str5;
        }
    }

    public DownloadAction(Action.AdTrackInfo adTrackInfo, IDownloadListener iDownloadListener, boolean z, String str, int i, boolean z2, boolean z3, MiniCardConfig miniCardConfig, DownloadInfo downloadInfo, int i2, int i3) {
        super(adTrackInfo, iDownloadListener, z);
        if (miniCardConfig == null || downloadInfo == null) {
            Log.e(TAG, "config info can't be null");
        }
        this.mPackageName = str;
        this.mDownloadSource = i;
        this.mIsDownloadByMiniCard = z2;
        this.mIsDownloadAutoStart = z3;
        this.mMiniCardConfig = miniCardConfig;
        this.mDownloadInfo = downloadInfo;
        if (downloadInfo == null) {
            this.mDownloadInfo = new DownloadInfo();
        }
        DownloadInfo downloadInfo2 = this.mDownloadInfo;
        downloadInfo2.marketDownloadType = i2;
        downloadInfo2.marketFloatCardPosition = i3;
    }
}
