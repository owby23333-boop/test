package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RewardVideoADListener f17773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f17774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LoadAdParams f17775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ServerSideVerificationOptions f17776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f17777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ADListenerAdapter f17778l;

    public static class ADListenerAdapter implements ADListener {
        private NegativeFeedbackListener a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    break;
                case 103:
                    this.adListener.onADExpose();
                    break;
                case 104:
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        HashMap map = new HashMap();
                        map.put("transId", str);
                        this.adListener.onReward(map);
                    }
                    break;
                case 105:
                    this.adListener.onADClick();
                    break;
                case 106:
                    this.adListener.onADClose();
                    break;
                case 107:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num.intValue()));
                    }
                    break;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z2) {
        this(rewardVideoADListener, z2);
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z2, String str2) {
        this(rewardVideoADListener, z2);
        a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z2) {
        this.f17775i = null;
        this.f17777k = z2;
        this.f17773g = rewardVideoADListener;
        this.f17778l = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f17778l);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        RewardVideoADListener rewardVideoADListener = this.f17773g;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((RVADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((RVADI) t2).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((RVADI) t2).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((RVADI) t2).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f17774h = true;
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((RVADI) t2).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f17775i = loadAdParams;
        T t2 = this.a;
        if (t2 != 0) {
            ((RVADI) t2).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.a(this.f17778l, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f17776j = serverSideVerificationOptions;
        T t2 = this.a;
        if (t2 != 0) {
            ((RVADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t2 = this.a;
        if (t2 != 0) {
            ((RVADI) t2).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t2 = this.a;
        if (t2 != 0) {
            ((RVADI) t2).showAD(activity);
        } else {
            a("showAD");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.f17777k);
        rvadi.setLoadAdParams(this.f17775i);
        rvadi.setServerSideVerificationOptions(this.f17776j);
        if (this.f17774h) {
            loadAD();
        }
    }
}
