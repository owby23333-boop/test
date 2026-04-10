package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.IBasicCPUAggregation;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCPUAggregationData implements IBasicCPUAggregation {
    private static final String CLASS_NAME = w.f13189n;
    private final ClassLoader mClassLoader;
    private IBasicCPUAggregation.ICpuHotNativeStatus mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public aq remoteUtils;

    public NativeCPUAggregationData(Context context, Object obj, HashMap<String, Object> map) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = map;
        this.remoteUtils = aq.a(context, CLASS_NAME);
        this.mClassLoader = bp.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickView(View view) {
        HashMap<String, Object> map = this.mSettings;
        if (map != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", map);
        }
        this.remoteUtils.a(this.mInstance, "handleClickView", view);
    }

    private void onImpression(View view) {
        HashMap<String, Object> map = this.mSettings;
        if (map != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", map);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    private void setStatusListener(IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        this.mCpuNativeStatusCBListener = iCpuHotNativeStatus;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.mClassLoader, new Class[]{ar.a(w.f13190o, this.mClassLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (NativeCPUAggregationData.this.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                        NativeCPUAggregationData.this.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                    }
                    return null;
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getContentId() {
        Object objB = this.remoteUtils.b(this.mInstance, "getContentId", new Object[0]);
        return objB instanceof String ? (String) objB : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public List<String> getImagesList() {
        Object objB = this.remoteUtils.b(this.mInstance, "getImagesList", new Object[0]);
        if (objB instanceof List) {
            return (List) objB;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getLongTitle() {
        Object objB = this.remoteUtils.b(this.mInstance, "getLongTitle", new Object[0]);
        return objB instanceof String ? (String) objB : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getShortTitle() {
        Object objB = this.remoteUtils.b(this.mInstance, "getShortTitle", new Object[0]);
        return objB instanceof String ? (String) objB : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getTitle() {
        Object objB = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        return objB instanceof String ? (String) objB : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public void registerViewForInteraction(View view, List<View> list, IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        setStatusListener(iCpuHotNativeStatus);
        onImpression(view);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (final View view2 : list) {
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        NativeCPUAggregationData.this.handleClickView(view3);
                        view2.setClickable(false);
                        view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                View view4 = view2;
                                if (view4 != null) {
                                    view4.setClickable(true);
                                }
                            }
                        }, 1000L);
                    }
                });
            }
        }
    }
}
