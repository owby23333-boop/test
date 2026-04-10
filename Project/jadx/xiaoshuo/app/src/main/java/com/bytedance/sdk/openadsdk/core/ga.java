package com.bytedance.sdk.openadsdk.core;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdSlot;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    private float bh;
    private String cv;
    private String dt;
    private String e;
    private int f;
    private String k;
    private String l;
    private String lc;
    private int m;
    private String p;
    private float t;
    private int[] w;
    private String wl;
    private String wu;
    private int xu;
    private int y;
    private String za;
    private int bf = 640;
    private int d = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
    private boolean tg = true;
    private boolean ga = false;
    private int vn = 1;
    private String v = "defaultUser";
    private int zk = 2;
    private boolean s = true;
    private TTAdLoadType pe = null;

    public static final class e implements TTAdSlot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2139a;
        private String bf;
        private int bh;
        private String cv;
        private int d;
        private String dt;
        private String e;
        private String f;
        private float ga;
        private int k;
        private int[] l;
        private int lc;
        private String m;
        private int p;
        private String pe;
        private int s;
        private int t;
        private int tg;
        private boolean v;
        private float vn;
        private boolean w;
        private String wl;
        private String wu;
        private int xu;
        private String y;
        private TTAdLoadType za;
        private boolean zk;

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getAdCount() {
            return this.p;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getAdId() {
            return this.y;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public TTAdLoadType getAdLoadType() {
            return this.za;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getAdType() {
            return this.bh;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getAdloadSeq() {
            return this.k;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getBidAdm() {
            return this.pe;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getCodeId() {
            return this.bf;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getCreativeId() {
            return this.cv;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getDurationSlotType() {
            return this.s;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public float getExpressViewAcceptedHeight() {
            return this.vn;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public float getExpressViewAcceptedWidth() {
            return this.ga;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getExt() {
            return this.wl;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int[] getExternalABVid() {
            return this.l;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getExtraSmartLookParam() {
            return this.f;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getImgAcceptedHeight() {
            return this.tg;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getImgAcceptedWidth() {
            return this.d;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getMediaExtra() {
            return this.m;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getNativeAdType() {
            return this.t;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getOrientation() {
            return this.xu;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getPrimeRit() {
            String str = this.dt;
            return str == null ? "" : str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public int getRewardAmount() {
            return this.lc;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getRewardName() {
            return this.f2139a;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getUserData() {
            return this.e;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public String getUserID() {
            return this.wu;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public boolean isAutoPlay() {
            return this.w;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public boolean isSupportDeepLink() {
            return this.v;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public boolean isSupportRenderConrol() {
            return this.zk;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public void setAdCount(int i) {
            this.p = i;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public void setDurationSlotType(int i) {
            this.s = i;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSlot
        public void setNativeAdType(int i) {
            this.t = i;
        }

        public String toString() {
            return "AdSlot{mCodeId='" + this.bf + "', mImgAcceptedWidth=" + this.d + ", mImgAcceptedHeight=" + this.tg + ", mExpressViewAcceptedWidth=" + this.ga + ", mExpressViewAcceptedHeight=" + this.vn + ", mAdCount=" + this.p + ", mSupportDeepLink=" + this.v + ", mSupportRenderControl=" + this.zk + ", mMediaExtra='" + this.m + "', mUserID='" + this.wu + "', mOrientation=" + this.xu + ", mNativeAdType=" + this.t + ", mIsAutoPlay=" + this.w + ", mPrimeRit=" + this.dt + ", mAdloadSeq=" + this.k + ", mAdId=" + this.y + ", mCreativeId=" + this.cv + ", mExt=" + this.wl + ", mAdLoadType=" + this.za + ", mRewardName=" + this.f2139a + ", mRewardAmount=" + this.lc + '}';
        }

        private e() {
            this.xu = 2;
            this.w = true;
            this.za = null;
        }
    }

    public ga bf(String str) {
        this.wl = str;
        return this;
    }

    public ga d(String str) {
        this.za = str;
        return this;
    }

    public ga e(String str) {
        this.wu = str;
        return this;
    }

    public ga ga(String str) {
        this.e = str;
        return this;
    }

    public ga m(String str) {
        if (str == null) {
            return this;
        }
        this.dt = str;
        return this;
    }

    public ga p(String str) {
        this.v = str;
        return this;
    }

    public ga tg(String str) {
        this.lc = str;
        return this;
    }

    public ga v(String str) {
        this.k = str;
        return this;
    }

    public ga vn(String str) {
        this.p = str;
        return this;
    }

    public void wu(String str) {
        this.cv = str;
    }

    public ga zk(String str) {
        this.l = str;
        return this;
    }

    public ga bf(boolean z) {
        this.tg = z;
        return this;
    }

    public ga d(int i) {
        this.zk = i;
        return this;
    }

    public ga e(int i) {
        this.xu = i;
        return this;
    }

    public ga ga(int i) {
        this.f = i;
        return this;
    }

    public ga tg(int i) {
        this.m = i;
        return this;
    }

    public void vn(int i) {
        this.y = i;
    }

    public ga bf(int i) {
        if (i <= 0) {
            Log.i(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            i = 1;
        }
        if (i > 20) {
            Log.i(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
            i = 20;
        }
        this.vn = i;
        return this;
    }

    public ga e(boolean z) {
        this.s = z;
        return this;
    }

    public ga e(int i, int i2) {
        this.bf = i;
        this.d = i2;
        return this;
    }

    public TTAdSlot bf() {
        e eVar = new e();
        eVar.bf = this.e;
        eVar.p = this.vn;
        eVar.v = this.tg;
        eVar.zk = this.ga;
        eVar.d = this.bf;
        eVar.tg = this.d;
        float f = this.bh;
        if (f <= 0.0f) {
            eVar.ga = this.bf;
            eVar.vn = this.d;
        } else {
            eVar.ga = f;
            eVar.vn = this.t;
        }
        eVar.m = this.p;
        eVar.wu = this.v;
        eVar.xu = this.zk;
        eVar.t = this.m;
        eVar.w = this.s;
        eVar.l = this.w;
        eVar.k = this.f;
        eVar.dt = this.k;
        eVar.f = this.wu;
        eVar.y = this.wl;
        eVar.cv = this.za;
        eVar.wl = this.lc;
        eVar.bh = this.xu;
        eVar.pe = this.dt;
        eVar.e = this.l;
        eVar.za = this.pe;
        eVar.lc = this.y;
        eVar.f2139a = this.cv;
        return eVar;
    }

    public ga e(float f, float f2) {
        this.bh = f;
        this.t = f2;
        return this;
    }

    public ga e() {
        this.ga = true;
        return this;
    }

    public ga e(int... iArr) {
        this.w = iArr;
        return this;
    }

    public ga e(TTAdLoadType tTAdLoadType) {
        this.pe = tTAdLoadType;
        return this;
    }
}
