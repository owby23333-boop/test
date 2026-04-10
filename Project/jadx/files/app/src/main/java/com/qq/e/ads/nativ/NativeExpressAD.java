package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile int f17747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f17748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Integer> f17749i = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoOption f17750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ADSize f17751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private NativeExpressADListener f17752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ADListenerAdapter f17753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LoadAdParams f17754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f17755o;

    public static class ADListenerAdapter implements ADListener {
        private NativeExpressADListener a;
        private NativeExpressMediaListener b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private NegativeFeedbackListener f17756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ADRewardListener f17757d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.a(this.a, aDEvent) || NativeExpressAD.a(this.b, aDEvent) || NativeExpressAD.a(this.f17756c, aDEvent)) {
                return;
            }
            NativeExpressAD.a(this.f17757d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f17757d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f17756c = negativeFeedbackListener;
        }
    }

    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f17752l = nativeExpressADListener;
        this.f17753m = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f17752l = nativeExpressADListener;
        this.f17753m = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f17751k = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(2001);
        return true;
    }

    static boolean a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        super.a(neadi);
        neadi.setMinVideoDuration(this.f17747g);
        neadi.setMaxVideoDuration(this.f17748h);
        ((NEADI) this.a).setServerSideVerificationOptions(this.f17755o);
        VideoOption videoOption = this.f17750j;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f17749i) {
            Iterator<Integer> it = this.f17749i.iterator();
            while (it.hasNext()) {
                if (this.a != 0) {
                    if (this.f17754n != null) {
                        ((NEADI) this.a).loadAd(it.next().intValue(), this.f17754n);
                    } else {
                        ((NEADI) this.a).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        NativeExpressADListener nativeExpressADListener = this.f17752l;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((NEADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i2) {
        loadAD(i2, null);
    }

    public void loadAD(int i2, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f17749i) {
                    this.f17749i.add(Integer.valueOf(i2));
                }
                return;
            }
            T t2 = this.a;
            if (t2 == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f17754n;
            NEADI neadi = (NEADI) t2;
            if (loadAdParams2 != null) {
                neadi.loadAd(i2, loadAdParams2);
            } else {
                neadi.loadAd(i2);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f17754n = loadAdParams;
    }

    public void setMaxVideoDuration(int i2) {
        this.f17748h = i2;
        if (this.f17748h > 0 && this.f17747g > this.f17748h) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((NEADI) t2).setMaxVideoDuration(this.f17748h);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f17747g = i2;
        if (this.f17748h > 0 && this.f17747g > this.f17748h) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((NEADI) t2).setMinVideoDuration(this.f17747g);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f17753m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f17755o = serverSideVerificationOptions;
        T t2 = this.a;
        if (t2 != 0) {
            ((NEADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f17750j = videoOption;
        T t2 = this.a;
        if (t2 == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t2).setVideoOption(videoOption);
    }

    static boolean a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case 209:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    break;
                case 210:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) != null) {
                        nativeExpressMediaListener.onVideoReady(nativeExpressADView, r5.intValue());
                    }
                    break;
                case 211:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    break;
            }
            return true;
        }
        return false;
    }

    static boolean a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    static boolean a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str != null) {
            HashMap map = new HashMap();
            map.put("transId", str);
            aDRewardListener.onReward(map);
        }
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f17751k, str, str2, str3, this.f17753m);
    }
}
