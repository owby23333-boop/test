package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AdListenerAdapter f17758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private NativeADUnifiedListener f17759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Integer> f17760i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f17761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f17762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f17763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f17764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LoadAdParams f17765n;

    private static class AdListenerAdapter implements ADListener {
        private NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f17759h = nativeADUnifiedListener;
        this.f17758g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f17759h = nativeADUnifiedListener;
        this.f17758g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i2, boolean z2) {
        if (a()) {
            if (!b()) {
                if (z2) {
                    this.f17760i.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                LoadAdParams loadAdParams = this.f17765n;
                NUADI nuadi = (NUADI) t2;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f17758g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a(nuadi);
        nuadi.setMinVideoDuration(this.f17762k);
        nuadi.setMaxVideoDuration(this.f17763l);
        nuadi.setVastClassName(this.f17764m);
        List<String> list = this.f17761j;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f17760i.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f17759h;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((NUADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i2) {
        a(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        this.f17765n = loadAdParams;
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f17761j = list;
        T t2 = this.a;
        if (t2 == 0 || list == null) {
            return;
        }
        ((NUADI) t2).setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.f17763l = i2;
        if (this.f17763l > 0 && this.f17762k > this.f17763l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((NUADI) t2).setMaxVideoDuration(this.f17763l);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f17762k = i2;
        if (this.f17763l > 0 && this.f17762k > this.f17763l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((NUADI) t2).setMinVideoDuration(this.f17762k);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f17764m = str;
        T t2 = this.a;
        if (t2 != 0) {
            ((NUADI) t2).setVastClassName(str);
        }
    }
}
