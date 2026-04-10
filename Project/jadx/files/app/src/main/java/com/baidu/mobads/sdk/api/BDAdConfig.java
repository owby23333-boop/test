package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.cn;
import com.baidu.mobads.sdk.internal.z;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BDAdConfig {
    private Context mAppContext;
    private String mAppName;
    private String mAppsid;
    private BDAdInitListener mBDAdInitListener;
    private String mChannelId;
    private boolean mCloseShake;
    private JSONObject mConfigObj;
    private boolean mDebug;
    private JSONObject mDialogParams;
    private boolean mHttps;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mSplashLog;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private String mWXAPPid;

    public interface BDAdInitListener {
        void fail();

        void success();
    }

    public static class Builder {
        private String mAppName;
        private String mAppsid;
        private BDAdInitListener mBDAdInitListener;
        private String mChannelId;
        private JSONObject mDialogParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private String mWXAPPid;
        private boolean mHttps = true;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;
        private boolean mDebug = false;
        private boolean mSplashLog = false;

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setBDAdInitListener(BDAdInitListener bDAdInitListener) {
            this.mBDAdInitListener = bDAdInitListener;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setCloseShake(boolean z2) {
            this.mCloseShake = z2;
            return this;
        }

        public Builder setDebug(boolean z2) {
            this.mDebug = z2;
            return this;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public Builder setHttps(boolean z2) {
            this.mHttps = z2;
            return this;
        }

        public Builder setLpMultiProcess(boolean z2) {
            this.mLpSupportMultiProcess = z2;
            return this;
        }

        public Builder setMtjSwitch(boolean z2) {
            this.mMtjSwitch = z2;
            return this;
        }

        public Builder setSplashLog(boolean z2) {
            this.mSplashLog = z2;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i2) {
            this.mVideoCacheCapacityMb = i2;
            return this;
        }

        public Builder setWXAppid(String str) {
            this.mWXAPPid = str;
            return this;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }
    }

    public static void clearMemoryCache() {
        try {
            z.a().c().onTaskDistribute(az.f12882c, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void init() {
        this.mConfigObj = new JSONObject();
        try {
            this.mConfigObj.put("https", "" + this.mHttps);
            this.mConfigObj.put(DispatchConstants.APP_NAME, this.mAppName);
            this.mConfigObj.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(URLPackage.KEY_CHANNEL_ID, this.mChannelId);
            this.mConfigObj.put("lpMultiProcess", "" + this.mLpMultiProcess);
            this.mConfigObj.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("sdk_debug", this.mDebug);
            this.mConfigObj.put("splashLog", this.mSplashLog);
            if (!TextUtils.isEmpty(this.mWXAPPid)) {
                this.mConfigObj.put("wxAppid", this.mWXAPPid);
            }
            cn.a().a(this.mLpMultiProcess);
            cn.a().b(this.mHttps);
            av.a(this.mDebug);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z.a().a(this.mAppContext, new z.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
            @Override // com.baidu.mobads.sdk.internal.z.a
            public void onFailure() {
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.fail();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.z.a
            public void onSuccess() {
                IXAdContainerFactory iXAdContainerFactoryC = z.a().c();
                if (iXAdContainerFactoryC != null) {
                    iXAdContainerFactoryC.initConfig(BDAdConfig.this.mConfigObj);
                    iXAdContainerFactoryC.onTaskDistribute(az.a, MobadsPermissionSettings.getPermissionInfo());
                }
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.success();
                }
            }
        });
    }

    private BDAdConfig(Context context, Builder builder) {
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
    }
}
