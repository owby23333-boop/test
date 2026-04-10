package com.baidu.tts.flyweight.persistent;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.life.ILife;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class PersistentPool implements ILife {
    private static volatile PersistentPool mInstance;
    private WeakReference<Context> mContext;
    private Hashtable<WeakReference<Context>, AppPersistentValueFlyweight> mAppPool = new Hashtable<>();
    private Hashtable<String, Object> mValuePool = new Hashtable<>();

    private PersistentPool() {
        this.mValuePool.put(KeyEnum.CTP.getShortName(), AgooConstants.ACK_REMOVE_PACKAGE);
        this.mValuePool.put(KeyEnum.VERSION.getShortName(), SpeechSynthesizer.VERSION_NAME);
    }

    public static PersistentPool getInstance() {
        if (mInstance == null) {
            synchronized (PersistentPool.class) {
                if (mInstance == null) {
                    mInstance = new PersistentPool();
                }
            }
        }
        return mInstance;
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
        Hashtable<WeakReference<Context>, AppPersistentValueFlyweight> hashtable = this.mAppPool;
        if (hashtable != null) {
            hashtable.clear();
        }
        this.mContext = null;
    }

    public Object get(String str) {
        return this.mValuePool.get(str);
    }

    public AppPersistentValueFlyweight getAppPersistentValueFlyweight(WeakReference<Context> weakReference) {
        if (weakReference == null) {
            return null;
        }
        AppPersistentValueFlyweight appPersistentValueFlyweight = this.mAppPool.get(weakReference);
        if (appPersistentValueFlyweight != null) {
            return appPersistentValueFlyweight;
        }
        AppPersistentValueFlyweight appPersistentValueFlyweight2 = new AppPersistentValueFlyweight(weakReference);
        this.mAppPool.put(weakReference, appPersistentValueFlyweight2);
        return appPersistentValueFlyweight2;
    }

    public Context getContext() {
        return this.mContext.get();
    }

    public String getDeviceId() {
        try {
            AppPersistentValueFlyweight appPersistentValueFlyweight = getAppPersistentValueFlyweight();
            if (appPersistentValueFlyweight == null) {
                return null;
            }
            return appPersistentValueFlyweight.getDeviceId();
        } catch (Exception unused) {
            return null;
        }
    }

    public String getString(String str) {
        try {
            return (String) this.mValuePool.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getVersion() {
        return getString(KeyEnum.VERSION.getShortName());
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
    }

    public void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
    }

    public AppPersistentValueFlyweight getAppPersistentValueFlyweight() {
        return getAppPersistentValueFlyweight(this.mContext);
    }
}
