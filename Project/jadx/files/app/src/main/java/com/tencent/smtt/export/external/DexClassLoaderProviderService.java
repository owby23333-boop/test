package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.umeng.message.proguard.ad;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        System.exit(0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String str = "DexClassLoaderProviderService -- onStartCommand(" + intent + ad.f20406s;
        if (intent == null) {
            return 1;
        }
        try {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
            if (stringArrayListExtra == null) {
                return 1;
            }
            String str2 = stringArrayListExtra.get(0);
            String str3 = stringArrayListExtra.get(1);
            String str4 = stringArrayListExtra.get(2);
            String str5 = stringArrayListExtra.get(3);
            String str6 = "DexClassLoaderProviderService -- onStartCommand(" + str2 + ad.f20406s;
            ClassLoader classLoader = getClassLoader();
            File file = new File(str4);
            if (!file.exists()) {
                file.mkdirs();
            }
            DexClassLoaderProvider.createDexClassLoader(str3, str4, str5, classLoader, getApplicationContext());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 1;
    }
}
