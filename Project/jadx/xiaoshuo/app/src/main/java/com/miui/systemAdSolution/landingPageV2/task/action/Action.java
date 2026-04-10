package com.miui.systemAdSolution.landingPageV2.task.action;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class Action<T extends IInterface> implements Parcelable {
    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() { // from class: com.miui.systemAdSolution.landingPageV2.task.action.Action.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action createFromParcel(Parcel parcel) {
            return ActionCreator.obtainAction(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action[] newArray(int i) {
            return new Action[i];
        }
    };
    private static final String TAG = "Action";
    protected AdTrackInfo mAdTrackInfo;
    protected boolean mIsForwardWhenSuccess;
    protected T mListener;
    protected int mType;

    public static class AdTrackInfo {
        private static final String KEY_AD_CONFIG_KEY = "configKey";
        private static final String KEY_AD_PASSBACK = "adPassback";
        private static final String KEY_APK_CHANNEL = "apkChannel";
        private static final String KEY_APP_CLIENT_ID = "appClientId";
        private static final String KEY_APP_SIGNATURE = "appSignature";
        private static final String KEY_MIMARKET_REF = "ref";
        private static final String KEY_NONCE = "nonce";
        private static final String KEY_TRACK_PACKAGE = "trackPackage";
        private String adPassback;
        private String apkChannel;
        private String appClientId;
        private String appSignature;
        private String configKey;
        private String nonce;
        private String ref;
        private String trackPackage;

        public AdTrackInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.adPassback = str;
            this.configKey = str2;
            this.ref = str3;
            this.apkChannel = str4;
            this.trackPackage = str5;
            this.appClientId = str6;
            this.appSignature = str7;
            this.nonce = str8;
        }

        public static AdTrackInfo deserialize(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new AdTrackInfo(jSONObject.optString(KEY_AD_PASSBACK), jSONObject.optString(KEY_AD_CONFIG_KEY), jSONObject.optString("ref"), jSONObject.optString("apkChannel"), jSONObject.optString(KEY_TRACK_PACKAGE), jSONObject.optString("appClientId"), jSONObject.optString("appSignature"), jSONObject.optString("nonce"));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getAdPassback() {
            return this.adPassback;
        }

        public String getApkChannel() {
            return this.apkChannel;
        }

        public String getAppClientId() {
            return this.appClientId;
        }

        public String getAppSignature() {
            return this.appSignature;
        }

        public String getConfigKey() {
            return this.configKey;
        }

        public String getNonce() {
            return this.nonce;
        }

        public String getRef() {
            return this.ref;
        }

        public String getTrackPackage() {
            return this.trackPackage;
        }

        public String serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_AD_PASSBACK, this.adPassback);
                jSONObject.put(KEY_AD_CONFIG_KEY, this.configKey);
                jSONObject.put("ref", this.ref);
                jSONObject.put("apkChannel", this.apkChannel);
                jSONObject.put(KEY_TRACK_PACKAGE, this.trackPackage);
                jSONObject.put("appClientId", this.appClientId);
                jSONObject.put("appSignature", this.appSignature);
                jSONObject.put("nonce", this.nonce);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public Action(Parcel parcel) {
        this.mType = getActionType();
        if (parcel != null) {
            this.mType = getActionType();
            this.mAdTrackInfo = parseAdTrackInfo(parcel.readString());
            this.mListener = (T) readBinder(parcel.readStrongBinder());
            this.mIsForwardWhenSuccess = parseIntToBoolean(parcel.readInt());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActionType() {
        return 0;
    }

    public AdTrackInfo getAdTracKInfo() {
        return this.mAdTrackInfo;
    }

    public boolean getIsForwardWhenSuccess() {
        return this.mIsForwardWhenSuccess;
    }

    public T getListener() {
        return this.mListener;
    }

    public final AdTrackInfo parseAdTrackInfo(String str) {
        try {
            return AdTrackInfo.deserialize(str);
        } catch (Exception e) {
            Log.e(TAG, "parseAdTrackInfo e : ", e);
            return null;
        }
    }

    public int parseBooleanToInt(boolean z) {
        return z ? 1 : 0;
    }

    public boolean parseIntToBoolean(int i) {
        return i > 0;
    }

    public T readBinder(IBinder iBinder) {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        AdTrackInfo adTrackInfo = this.mAdTrackInfo;
        parcel.writeString(adTrackInfo == null ? "" : adTrackInfo.serialize());
        parcel.writeStrongInterface(this.mListener);
        parcel.writeInt(parseBooleanToInt(this.mIsForwardWhenSuccess));
    }

    public Action(AdTrackInfo adTrackInfo, T t, boolean z) {
        this.mType = getActionType();
        this.mAdTrackInfo = adTrackInfo;
        this.mListener = t;
        this.mIsForwardWhenSuccess = z;
    }
}
