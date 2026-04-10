package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.bytedance.msdk.base.TTBaseAd;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    static final class a implements IGMInitAdnResult {
        final /* synthetic */ GMCustomInitConfig a;

        a(GMCustomInitConfig gMCustomInitConfig) {
            this.a = gMCustomInitConfig;
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
            if (adError != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(this.a.getADNName(), (Pair<Boolean, String>) new Pair(false, "errorCode = " + adError.code + " errorMessage = " + adError.message));
            }
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(this.a.getADNName(), (Pair<Boolean, String>) new Pair(true, ""));
        }
    }

    private static String a(GMCustomAdapterConfiguration gMCustomAdapterConfiguration) {
        return gMCustomAdapterConfiguration == null ? "customAdapterConfiguration 为null" : TextUtils.isEmpty(gMCustomAdapterConfiguration.getNetworkSdkVersion()) ? "自定义ADN 初始化失败 getNetworkSdkVersion()返字符串不能为空" : TextUtils.isEmpty(gMCustomAdapterConfiguration.getAdapterSdkVersion()) ? "自定义ADN 初始化失败 getAdapterSdkVersion()返字符串不能为空" : "";
    }

    public static void a(Context context) {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> listA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a();
        if (listA == null) {
            h.a("", (TTBaseAd) null, (AdSlot) null, (j) null, new AdError(AdError.ERROR_CODE_CUSTOM_INIT, "获取的自定义Adapter总配置为null"));
            return;
        }
        Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> it = listA.iterator();
        while (it.hasNext()) {
            GMCustomInitConfig gMCustomInitConfigC = it.next().c();
            try {
                a(context, gMCustomInitConfigC, new a(gMCustomInitConfigC));
            } catch (Exception e2) {
                e2.printStackTrace();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(gMCustomInitConfigC.getADNName(), (Pair<Boolean, String>) new Pair(false, e2.toString()));
                h.a(gMCustomInitConfigC.getADNName(), (TTBaseAd) null, (AdSlot) null, (j) null, new AdError(AdError.ERROR_CODE_CUSTOM_INIT, e2.toString()));
            }
        }
    }

    private static void a(Context context, GMCustomInitConfig gMCustomInitConfig, IGMInitAdnResult iGMInitAdnResult) throws Exception {
        if (gMCustomInitConfig == null || TextUtils.isEmpty(gMCustomInitConfig.getAdnInitClassName())) {
            if (gMCustomInitConfig != null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
        }
        try {
            Class<?> cls = Class.forName(gMCustomInitConfig.getAdnInitClassName());
            if (a(cls)) {
                try {
                    GMCustomAdapterConfiguration gMCustomAdapterConfigurationB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.d().b(gMCustomInitConfig.getADNName());
                    if (gMCustomAdapterConfigurationB == null) {
                        Object objNewInstance = cls.newInstance();
                        if (!(objNewInstance instanceof GMCustomAdapterConfiguration)) {
                            throw new Exception("自定义ADN初始化失败，初始化对象类型错误，对象类型为" + GMCustomAdapterConfiguration.class.getName());
                        }
                        GMCustomAdapterConfiguration gMCustomAdapterConfiguration = (GMCustomAdapterConfiguration) objNewInstance;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.d().a(gMCustomInitConfig.getADNName(), gMCustomAdapterConfiguration);
                        a(context, gMCustomInitConfig, gMCustomAdapterConfiguration);
                    } else if (!gMCustomAdapterConfigurationB.isInit()) {
                        a(context, gMCustomInitConfig, gMCustomAdapterConfigurationB);
                    }
                    iGMInitAdnResult.success();
                } catch (IllegalAccessException unused) {
                    throw new Exception("自定义ADN初始化失败，IllegalAccessException");
                } catch (InstantiationException unused2) {
                    throw new Exception("自定义ADN舒适化失败，InstantiationException");
                }
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new Exception("自定义ADN初始化失败，ClassNotFoundException");
        }
    }

    private static void a(Context context, GMCustomInitConfig gMCustomInitConfig, GMCustomAdapterConfiguration gMCustomAdapterConfiguration) {
        String aDNName;
        AdError adError;
        if (context == null) {
            aDNName = gMCustomInitConfig.getADNName();
            adError = new AdError(AdError.ERROR_CODE_CUSTOM_INIT, "context为null");
        } else {
            String strA = a(gMCustomAdapterConfiguration);
            if (TextUtils.isEmpty(strA)) {
                try {
                    gMCustomAdapterConfiguration.initializeInnerADN(context.getApplicationContext(), gMCustomInitConfig, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().h());
                    return;
                } catch (Exception e2) {
                    h.a(gMCustomInitConfig.getADNName(), (TTBaseAd) null, (AdSlot) null, (j) null, new AdError(AdError.ERROR_CODE_CUSTOM_INIT, "调用自定义Adapter初始化方法出现异常 " + e2.getClass().getName()));
                    e2.printStackTrace();
                    return;
                }
            }
            aDNName = gMCustomInitConfig.getADNName();
            adError = new AdError(AdError.ERROR_CODE_CUSTOM_INIT, strA);
        }
        h.a(aDNName, (TTBaseAd) null, (AdSlot) null, (j) null, adError);
    }

    private static boolean a(Class<?> cls) {
        String strB;
        if (a(cls, GMCustomAdapterConfiguration.class)) {
            strB = b(cls, GMCustomAdapterConfiguration.class);
        } else {
            strB = "自定义ADN初始化失败  ---------  初始化类 " + cls.getSimpleName() + " 需要继承自自定义ADN的初始化Adapter类 " + GMCustomAdapterConfiguration.class.getSimpleName();
        }
        if (TextUtils.isEmpty(strB)) {
            return true;
        }
        Logger.e("TTMediationSDK_SDK_Init", strB);
        h.a("", (TTBaseAd) null, (AdSlot) null, (j) null, new AdError(AdError.ERROR_CODE_CUSTOM_INIT, strB));
        return false;
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        } while (cls != cls2);
        return true;
    }

    public static String b(Class<?> cls, Class<?> cls2) {
        for (Method method : cls2.getMethods()) {
            HashSet hashSet = new HashSet();
            for (Method method2 : Object.class.getMethods()) {
                hashSet.add(method2.getName());
            }
            if (!hashSet.contains(method.getName())) {
                try {
                    cls.getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                    return "自定义ADN校验API失败接入API不符合版本需求，不符合的API的方法名为 " + method.getName();
                }
            }
        }
        return "";
    }
}
