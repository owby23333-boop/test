package com.anythink.core.api;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ATDebuggerConfig {
    private int mBannerType;
    private int mInterstitialType;
    private int mNativeType;
    private int mNetworkFirmId;
    private int mRewarderVideoType;
    private int mSplashType;

    public static class Builder {
        private int mBannerType;
        private int mInterstitialType;
        private int mNativeType;
        private int mNetworkFirmId;
        private int mRewarderVideoType;
        private int mSplashType;

        public Builder(int i2) {
            this.mNetworkFirmId = i2;
            fillDefaultType(i2);
        }

        private void fillDefaultType(int i2) {
            if (i2 == 1) {
                this.mNativeType = 1;
                return;
            }
            if (i2 == 2 || i2 == 6 || i2 == 8) {
                this.mNativeType = 1;
            } else {
                if (i2 == 15) {
                    this.mNativeType = 101;
                    this.mInterstitialType = 3;
                    return;
                }
                if (i2 == 28) {
                    this.mNativeType = 101;
                    return;
                }
                if (i2 == 39) {
                    this.mNativeType = 1;
                } else {
                    if (i2 == 59) {
                        this.mBannerType = 1;
                        return;
                    }
                    if (i2 != 66) {
                        if (i2 == 22) {
                            this.mNativeType = 1;
                            this.mInterstitialType = 2;
                            return;
                        } else {
                            if (i2 != 23) {
                                return;
                            }
                            this.mInterstitialType = 1;
                            return;
                        }
                    }
                }
            }
            this.mInterstitialType = 1;
        }

        public ATDebuggerConfig build() {
            ATDebuggerConfig aTDebuggerConfig = new ATDebuggerConfig();
            aTDebuggerConfig.mNetworkFirmId = this.mNetworkFirmId;
            aTDebuggerConfig.mNativeType = this.mNativeType;
            aTDebuggerConfig.mBannerType = this.mBannerType;
            aTDebuggerConfig.mSplashType = this.mSplashType;
            aTDebuggerConfig.mInterstitialType = this.mInterstitialType;
            aTDebuggerConfig.mRewarderVideoType = this.mRewarderVideoType;
            return aTDebuggerConfig;
        }

        public Builder setBannerType(int i2) {
            this.mBannerType = i2;
            return this;
        }

        public Builder setInterstitial(int i2) {
            this.mInterstitialType = i2;
            return this;
        }

        public Builder setNativeType(int i2) {
            this.mNativeType = i2;
            return this;
        }

        public Builder setRewardedVideoType(int i2) {
            this.mRewarderVideoType = i2;
            return this;
        }

        public Builder setSplashType(int i2) {
            this.mSplashType = i2;
            return this;
        }
    }

    public void fillRequestParam(JSONObject jSONObject) {
        try {
            jSONObject.put("is_test", 1);
            jSONObject.put("test_nw_firm", this.mNetworkFirmId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", this.mNativeType);
            jSONObject2.put("2", this.mBannerType);
            jSONObject2.put("1", this.mRewarderVideoType);
            jSONObject2.put("3", this.mInterstitialType);
            jSONObject2.put("4", this.mSplashType);
            if (jSONObject2.length() > 0) {
                jSONObject.put("test_format_sub", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public int getBannerType() {
        return this.mBannerType;
    }

    public int getInterstitialType() {
        return this.mInterstitialType;
    }

    public int getNativeType() {
        return this.mNativeType;
    }

    public int getNetworkFirmId() {
        return this.mNetworkFirmId;
    }

    public int getRewarderVideoType() {
        return this.mRewarderVideoType;
    }

    public int getSplashType() {
        return this.mSplashType;
    }
}
