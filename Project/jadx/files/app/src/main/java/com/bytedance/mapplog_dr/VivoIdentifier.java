package com.bytedance.mapplog_dr;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.l0;
import bykvm_19do.bykvm_19do.bykvm_19do.s0;
import bykvm_19do.bykvm_19do.bykvm_19do.t0;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.TnetStatusCode;

/* JADX INFO: loaded from: classes2.dex */
public final class VivoIdentifier {
    private static final Map<String, String> MSA_VERSION_MAP = new HashMap(4);
    private String oaid;
    private String resultCode;
    private final AtomicBoolean mSecondCallGetDeviceIds = new AtomicBoolean();
    private volatile boolean mProloading = false;
    private final Object mLock = new Object();
    private final IIdentifierListener listener = new IdentifierListener();

    class IdentifierListener implements IIdentifierListener {
        private IdentifierListener() {
        }

        public void OnSupport(IdSupplier idSupplier) {
            onSupport(idSupplier);
        }

        public void OnSupport(boolean z2, IdSupplier idSupplier) {
            try {
                t0.b("Oaid#", "OaidMiit#OnSupport isSupport=" + z2 + ", supplier=" + idSupplier);
                if (z2 && idSupplier != null) {
                    VivoIdentifier.this.setupOaid(idSupplier.getOAID());
                    synchronized (VivoIdentifier.this.mLock) {
                        VivoIdentifier.this.mProloading = false;
                        VivoIdentifier.this.mLock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                l0.a("", th);
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            try {
                t0.b("Oaid#", "OaidMiit#OnSupport supplier=" + idSupplier);
                if (idSupplier != null && idSupplier.isSupported()) {
                    OnSupport(true, idSupplier);
                }
            } catch (Throwable th) {
                l0.a("", th);
            }
        }
    }

    static {
        MSA_VERSION_MAP.put("1.0.26", "nllvm1623827671");
        MSA_VERSION_MAP.put("1.0.27", "nllvm1630571663641560568");
        MSA_VERSION_MAP.put("1.0.29", "nllvm1632808251147706677");
    }

    private int callFromReflect(Context context) {
        try {
            if (loadMSALibrary()) {
                MdidSdkHelper.InitCert(context, loadPemFromAssetFile(context, context.getPackageName() + ".cert.pem"));
            }
        } catch (Throwable th) {
            t0.b("Oaid#", "msa cert init exception", th);
        }
        try {
            return MdidSdkHelper.InitSdk(context, false, this.listener);
        } catch (Throwable th2) {
            t0.b("Oaid#", "msa sdk init exception", th2);
            return TnetStatusCode.TNET_SESSION_EXCEED_MAXED;
        }
    }

    private static void loadLibrary(ClassLoader classLoader, String str) throws IllegalAccessException, InvocationTargetException {
        Method accessibleMethod = MethodUtils.getAccessibleMethod(Runtime.class, "loadLibrary0", ClassLoader.class, String.class);
        if (accessibleMethod == null) {
            throw new IllegalAccessException("can not access loadLibrary0 method");
        }
        accessibleMethod.invoke(Runtime.getRuntime(), classLoader, str);
    }

    private boolean loadMSALibrary() {
        String strA = s0.a();
        ClassLoader classLoader = MdidSdkHelper.class.getClassLoader();
        if (strA == null || !MSA_VERSION_MAP.containsKey(strA)) {
            for (String str : MSA_VERSION_MAP.keySet()) {
                try {
                    loadLibrary(classLoader, MSA_VERSION_MAP.get(str));
                    return true;
                } catch (Throwable th) {
                    l0.c("如果信通院SDK不是" + str + "，请忽略这个错误: ", th);
                }
            }
        } else {
            String str2 = MSA_VERSION_MAP.get(strA);
            try {
                loadLibrary(classLoader, str2);
                return true;
            } catch (Throwable th2) {
                l0.c("加载信通院so库异常，msaVersion is " + strA + "，lib name is " + str2, th2);
            }
        }
        return false;
    }

    private static String loadPemFromAssetFile(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupOaid(String str) {
        synchronized (this) {
            t0.b("Oaid#", "OaidMiit#setupOaid current oaid=" + str + ", global oaid=" + this.oaid);
            if (!TextUtils.isEmpty(str) && !str.equals(this.oaid)) {
                this.oaid = str;
            }
        }
    }

    public a1.a getOaid(Context context) {
        synchronized (this.mLock) {
            if (this.mProloading) {
                try {
                    this.mLock.wait(10000L);
                } catch (Throwable th) {
                    l0.a("", th);
                }
            }
        }
        a1.a aVar = new a1.a();
        aVar.a = this.oaid;
        return aVar;
    }

    public void preloadOaid(Context context) {
        int iCallFromReflect;
        String str;
        synchronized (this.mLock) {
            this.mProloading = true;
            try {
                iCallFromReflect = callFromReflect(context);
            } catch (Throwable th) {
                l0.a("", th);
                this.mProloading = false;
            }
            if (iCallFromReflect == 1008614) {
                t0.b("Oaid#", "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.mSecondCallGetDeviceIds.compareAndSet(false, true)) {
                    preloadOaid(context);
                } else {
                    str = "结果会在回调中返回";
                    this.resultCode = str;
                }
            } else {
                if (iCallFromReflect != 0 && iCallFromReflect != 1008610) {
                    this.resultCode = "未知 resultCode=" + iCallFromReflect;
                    t0.b("Oaid#", "OaidMiit#getDeviceIds 未知 resultCode=" + iCallFromReflect);
                }
                t0.b("Oaid#", "OaidMiit#getDeviceIds 正确");
                str = "正确";
                this.resultCode = str;
            }
        }
    }
}
