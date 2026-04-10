package com.xiaomi.accounts;

import android.accounts.AuthenticatorDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.accountsdk.utils.AccountLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public class AccountAuthenticatorCache {
    private static final String MI_ACCOUNT_TYPE = "com.xiaomi";
    private static final String TAG = "Account";
    private Context mContext;
    private final String mInterfaceName = AccountManager.ACTION_AUTHENTICATOR_INTENT;
    private ServiceInfo<AuthenticatorDescription> mServiceInfo;

    public static class ServiceInfo<V> {
        public final ComponentName componentName;
        public final V type;
        public final int uid;

        public ServiceInfo(V v, ComponentName componentName, int i) {
            this.type = v;
            this.componentName = componentName;
            this.uid = i;
        }

        public String toString() {
            return "ServiceInfo: " + this.type + ", " + this.componentName + ", uid " + this.uid;
        }
    }

    public AccountAuthenticatorCache(Context context) {
        this.mContext = context;
        generateServicesMap();
    }

    private ServiceInfo<AuthenticatorDescription> parseServiceInfo(ResolveInfo resolveInfo) {
        String packageName;
        ApplicationInfo applicationInfo;
        String str;
        if (resolveInfo != null) {
            android.content.pm.ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            packageName = serviceInfo.packageName;
            str = serviceInfo.name;
            applicationInfo = serviceInfo.applicationInfo;
        } else {
            packageName = this.mContext.getPackageName();
            applicationInfo = this.mContext.getApplicationInfo();
            str = "com.xiaomi.passport.accountmanager.MiAuthenticatorService";
        }
        String str2 = packageName;
        ComponentName componentName = new ComponentName(str2, str);
        int i = applicationInfo.uid;
        int i2 = applicationInfo.labelRes;
        int i3 = applicationInfo.icon;
        return new ServiceInfo<>(new AuthenticatorDescription("com.xiaomi", str2, i2, i3, i3, -1), componentName, i);
    }

    public void generateServicesMap() {
        Intent intent = new Intent(this.mInterfaceName);
        intent.setPackage(this.mContext.getPackageName());
        this.mServiceInfo = parseServiceInfo(this.mContext.getPackageManager().resolveService(intent, 0));
    }

    public Collection<ServiceInfo<AuthenticatorDescription>> getAllServices() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mServiceInfo);
        return Collections.unmodifiableCollection(arrayList);
    }

    public ServiceInfo<AuthenticatorDescription> getServiceInfo(AuthenticatorDescription authenticatorDescription) {
        if (authenticatorDescription != null && TextUtils.equals("com.xiaomi", authenticatorDescription.type)) {
            return this.mServiceInfo;
        }
        AccountLogger.log(TAG, "no xiaomi account type");
        return null;
    }
}
