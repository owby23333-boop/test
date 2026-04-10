package com.sntech.cc.data;

import a0.a;
import android.content.pm.ActivityInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class MyPackageInfo {

    @SerializedName("activities")
    @Expose
    public ActivityInfo[] activities;

    @SerializedName("applicationInfo")
    @Expose
    public MyApplicationInfo applicationInfo;

    @SerializedName("baseRevisionCode")
    @Expose
    public int baseRevisionCode;

    @SerializedName("firstInstallTime")
    @Expose
    public long firstInstallTime;

    @SerializedName("gids")
    @Expose
    public int[] gids;

    @SerializedName("instrumentation")
    @Expose
    public InstrumentationInfo[] instrumentation;

    @SerializedName("isApex")
    @Expose
    public boolean isApex;

    @SerializedName("lastUpdateTime")
    @Expose
    public long lastUpdateTime;

    @SerializedName("packageName")
    @Expose
    public String packageName;

    @SerializedName(TTDelegateActivity.INTENT_PERMISSIONS)
    @Expose
    public PermissionInfo[] permissions;

    @SerializedName("providers")
    @Expose
    public ProviderInfo[] providers;

    @SerializedName("receivers")
    @Expose
    public ActivityInfo[] receivers;

    @SerializedName("requestedPermissions")
    @Expose
    public String[] requestedPermissions;

    @SerializedName("requestedPermissionsFlags")
    @Expose
    public int[] requestedPermissionsFlags;

    @SerializedName("services")
    @Expose
    public ServiceInfo[] services;

    @SerializedName("sharedUserId")
    @Expose
    public String sharedUserId;

    @SerializedName("sharedUserLabel")
    @Expose
    public int sharedUserLabel;

    @SerializedName("signatures")
    @Expose
    public String[] signatures;

    @SerializedName("signingInfo")
    @Expose
    public String signingInfo;

    @SerializedName("splitNames")
    @Expose
    public String[] splitNames;

    @SerializedName("splitRevisionCodes")
    @Expose
    public int[] splitRevisionCodes;

    @SerializedName("versionCode")
    @Expose
    public int versionCode;

    @SerializedName("versionName")
    @Expose
    public String versionName;

    public MyPackageInfo() {
    }

    public PackageInfo toPackageInfo() {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = this.packageName;
        if (Build.VERSION.SDK_INT >= 22) {
            packageInfo.splitNames = this.splitNames;
            packageInfo.baseRevisionCode = this.baseRevisionCode;
            packageInfo.splitRevisionCodes = this.splitRevisionCodes;
        }
        packageInfo.versionCode = this.versionCode;
        packageInfo.versionName = this.versionName;
        packageInfo.sharedUserId = this.sharedUserId;
        packageInfo.sharedUserLabel = this.sharedUserLabel;
        MyApplicationInfo myApplicationInfo = this.applicationInfo;
        if (myApplicationInfo != null) {
            packageInfo.applicationInfo = myApplicationInfo.toApplicationInfo();
        }
        packageInfo.firstInstallTime = this.firstInstallTime;
        packageInfo.lastUpdateTime = this.lastUpdateTime;
        packageInfo.gids = this.gids;
        packageInfo.activities = this.activities;
        packageInfo.receivers = this.receivers;
        packageInfo.services = this.services;
        packageInfo.providers = this.providers;
        packageInfo.instrumentation = this.instrumentation;
        packageInfo.permissions = this.permissions;
        packageInfo.requestedPermissions = this.requestedPermissions;
        packageInfo.requestedPermissionsFlags = this.requestedPermissionsFlags;
        String[] strArr = this.signatures;
        if (strArr != null) {
            packageInfo.signatures = new Signature[strArr.length];
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.signatures;
                if (i2 >= strArr2.length) {
                    break;
                }
                Signature[] signatureArr = packageInfo.signatures;
                String str = strArr2[i2];
                Parcelable.Creator creator = Signature.CREATOR;
                byte[] bArrDecode = Base64.decode(str, 0);
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                signatureArr[i2] = (Signature) creator.createFromParcel(parcelObtain);
                i2++;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            String str2 = this.signingInfo;
            if (str2 != null) {
                Parcelable.Creator creator2 = SigningInfo.CREATOR;
                byte[] bArrDecode2 = Base64.decode(str2, 0);
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.unmarshall(bArrDecode2, 0, bArrDecode2.length);
                parcelObtain2.setDataPosition(0);
                packageInfo.signingInfo = (SigningInfo) creator2.createFromParcel(parcelObtain2);
            }
            packageInfo.isApex = this.isApex;
        }
        return packageInfo;
    }

    public MyPackageInfo(PackageInfo packageInfo) {
        this.packageName = packageInfo.packageName;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            this.splitNames = packageInfo.splitNames;
            this.baseRevisionCode = packageInfo.baseRevisionCode;
            this.splitRevisionCodes = packageInfo.splitRevisionCodes;
        }
        this.versionCode = packageInfo.versionCode;
        this.versionName = packageInfo.versionName;
        this.sharedUserId = packageInfo.sharedUserId;
        this.sharedUserLabel = packageInfo.sharedUserLabel;
        this.applicationInfo = new MyApplicationInfo(packageInfo.applicationInfo);
        this.firstInstallTime = packageInfo.firstInstallTime;
        this.lastUpdateTime = packageInfo.lastUpdateTime;
        this.gids = packageInfo.gids;
        this.activities = packageInfo.activities;
        this.receivers = packageInfo.receivers;
        this.services = packageInfo.services;
        this.providers = packageInfo.providers;
        this.instrumentation = packageInfo.instrumentation;
        this.permissions = packageInfo.permissions;
        this.requestedPermissions = packageInfo.requestedPermissions;
        this.requestedPermissionsFlags = packageInfo.requestedPermissionsFlags;
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            this.signatures = a.a(signatureArr);
        }
        if (i2 >= 29) {
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo != null) {
                this.signingInfo = a.a(signingInfo);
            }
            this.isApex = packageInfo.isApex;
        }
    }
}
