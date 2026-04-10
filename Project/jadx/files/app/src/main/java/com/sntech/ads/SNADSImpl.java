package com.sntech.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.sntech.a4.A4AdListener;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import java.io.File;
import java.util.List;
import n.b;
import org.json.JSONException;
import org.json.JSONObject;
import q0.d;
import q0.e;
import q0.f;
import z0.o;

/* JADX INFO: loaded from: classes3.dex */
public class SNADSImpl implements ISNADS {
    private static SNADSImpl sInstance;
    private final Context mContext;

    @Keep
    private ISNADS mSnads;

    private SNADSImpl(Context context) {
        this.mContext = context;
        this.mSnads = makeSnads(context);
    }

    public static synchronized SNADSImpl get(Context context) {
        if (sInstance == null) {
            sInstance = new SNADSImpl(context.getApplicationContext());
        }
        return sInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x023a A[Catch: all -> 0x0289, Exception -> 0x028b, TryCatch #4 {Exception -> 0x028b, blocks: (B:54:0x01ad, B:56:0x0202, B:58:0x0206, B:61:0x020c, B:63:0x023a, B:65:0x0250, B:67:0x0256, B:69:0x0270, B:78:0x0288, B:77:0x0285), top: B:104:0x01ad, outer: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sntech.ads.SNADSImpl.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.sntech.ads.ISNADS
    public void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        this.mSnads.clickAd(adPlatform, str, str2);
    }

    @Override // com.sntech.ads.ISNADS
    public String did() {
        return this.mSnads.did();
    }

    @Override // com.sntech.ads.ISNADS
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        return this.mSnads.getAdEcpm(adPlatform, adType, str, d2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2) {
        return this.mSnads.getBannerPlacementId(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2) {
        return this.mSnads.getInterstitialPlacementId(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2) {
        return this.mSnads.getNativePlacementId(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public List<ClassLoader> getPluginClassloaders() {
        return this.mSnads.getPluginClassloaders();
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2) {
        return this.mSnads.getRewardVideoPlacementId(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2) {
        return this.mSnads.getSplashPlacementId(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public int getVersion() {
        return this.mSnads.getVersion();
    }

    @Override // com.sntech.ads.ISNADS
    public void initSDK(final String str, final String str2) {
        this.mSnads.initSDK(str, str2);
        new Thread(new Runnable() { // from class: com.sntech.ads.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17904s.a(str, str2);
            }
        }).start();
    }

    @Override // com.sntech.ads.ISNADS
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        return this.mSnads.isAdTypeAvailable(adPlatform, adType);
    }

    @Override // com.sntech.ads.ISNADS
    public void isRiskUser(RiskUserCallback riskUserCallback) {
        this.mSnads.isRiskUser(riskUserCallback);
    }

    public ISNADS makeSnads(Context context) {
        e eVar = new e(context);
        String str = d.E;
        d dVar = null;
        try {
            File fileA = b.a(context);
            File fileB = b.b(context);
            if (fileB.exists()) {
                dVar = new d(context, new c1.a(fileB.getPath(), fileA.getPath(), context.getApplicationInfo().nativeLibraryDir, context.getClassLoader()));
            } else {
                o.a().a("CLASSLOADER_INIT_NO_FILE", (JSONObject) null);
            }
        } catch (Throwable th) {
            if (b.b()) {
                th.printStackTrace();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception", e0.d.a(th));
            } catch (JSONException unused) {
            }
            o.a().a("CLASSLOADER_INIT_FAILED", jSONObject);
        }
        int version = -1;
        if (dVar != null) {
            try {
                version = dVar.getVersion();
            } catch (Exception e2) {
                if (b.b()) {
                    e2.printStackTrace();
                }
            }
        }
        return version > eVar.getVersion() ? new f(eVar, dVar) : eVar;
    }

    @Override // com.sntech.ads.ISNADS
    public void onNewVersion(int i2) {
        this.mSnads.onNewVersion(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        this.mSnads.onRequestPermissionResult(activity, i2, strArr, iArr);
    }

    @Override // com.sntech.ads.ISNADS
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        this.mSnads.onTopOnAdShow(adPlatform, adType, str, str2, d2);
    }

    @Override // com.sntech.ads.ISNADS
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        this.mSnads.onUserEvent(userEvent);
    }

    @Override // com.sntech.ads.ISNADS
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        this.mSnads.onWithdraw(str, f2, withdrawChannel, str2);
    }

    public void reload(String str, String str2) {
        this.mSnads = makeSnads(this.mContext);
        initSDK(str, str2);
    }

    @Override // com.sntech.ads.ISNADS
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        this.mSnads.requestPermissionsIfNeed(activity, strArr);
    }

    @Override // com.sntech.ads.ISNADS
    public void setUserId(String str) {
        this.mSnads.setUserId(str);
    }

    @Override // com.sntech.ads.ISNADS
    public void setupPlugins() {
        this.mSnads.setupPlugins();
    }

    @Override // com.sntech.ads.ISNADS
    public void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener) {
        this.mSnads.showA4InterstitialAd(activity, str, a4AdListener);
    }

    @Override // com.sntech.ads.ISNADS
    public void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        this.mSnads.showAd(view, adPlatform, str, d2, str2);
    }

    public void update(int i2) {
        onNewVersion(i2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2, String str) {
        return this.mSnads.getBannerPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2, String str) {
        return this.mSnads.getInterstitialPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2, String str) {
        return this.mSnads.getNativePlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2, String str) {
        return this.mSnads.getRewardVideoPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2, String str) {
        return this.mSnads.getSplashPlacementId(i2, str);
    }
}
