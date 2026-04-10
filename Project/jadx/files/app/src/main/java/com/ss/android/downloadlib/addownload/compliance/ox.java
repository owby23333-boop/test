package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.ko;
import com.ss.android.downloadlib.utils.Chain;
import com.ss.android.downloadlib.utils.jb;
import com.taobao.accs.common.Constants;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    private SoftReference<Activity> mb;

    private static class mb {
        private static ox mb = new ox();
    }

    public void ox(long j2) {
        com.ss.android.downloadlib.addownload.h hVarMb = ko.mb().mb(u.mb().h(j2).ox.getDownloadUrl());
        if (hVarMb != null) {
            hVarMb.mb(true, true);
        } else {
            h.mb(11, j2);
            com.ss.android.downloadlib.exception.b.mb().ox("startDownload handler null");
        }
    }

    private ox() {
    }

    public static ox mb() {
        return mb.mb;
    }

    public void mb(long j2) {
        TTDelegateActivity.mb(j2);
    }

    public boolean mb(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || x.lz().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(x.lz().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity ox() {
        Activity activity = this.mb.get();
        this.mb = null;
        return activity;
    }

    public boolean mb(@NonNull com.ss.android.downloadlib.addownload.model.h hVar) {
        long jMb;
        long j2;
        if (!TextUtils.isEmpty(hVar.ox.getLogExtra())) {
            try {
                jMb = jb.mb(new JSONObject(hVar.ox.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                jMb = 0;
            }
            if (jMb <= 0) {
                h.mb(3, hVar);
            }
            j2 = jMb;
        } else {
            h.mb(9, hVar);
            com.ss.android.downloadlib.exception.b.mb().mb("requestAppInfo getLogExtra null");
            j2 = 0;
        }
        final long j3 = hVar.mb;
        com.ss.android.downloadlib.addownload.model.ox oxVarMb = b.mb().mb(j2, j3);
        if (oxVarMb != null) {
            hj.mb().mb(oxVarMb.mb(), j3, oxVarMb.hj);
            mb(oxVarMb.mb());
            h.mb(EventConstants.Label.LP_APP_DIALOG_TRY_SHOW, hVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!TextUtils.isEmpty(hVar.ox.getPackageName())) {
            if (sb.length() > 0) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            sb.append("package_name=");
            sb.append(hVar.ox.getPackageName());
        }
        if (sb.length() <= 0) {
            h.mb(6, hVar);
            return false;
        }
        final long j4 = j2;
        Chain.mb((Chain.mb<String, R>) new Chain.mb<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.2
            @Override // com.ss.android.downloadlib.utils.Chain.mb
            public Boolean mb(String str) {
                final boolean[] zArr = {false};
                x.hj().mb("GET", str, new HashMap(), new l() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.2.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = ox.this.mb(j4, j3, str2);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        h.mb(2, j3);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).mb(new Chain.mb<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.1
            @Override // com.ss.android.downloadlib.utils.Chain.mb
            public Object mb(Boolean bool) {
                if (!bool.booleanValue()) {
                    ox.this.ox(j3);
                    return null;
                }
                ox.this.mb(com.ss.android.downloadlib.addownload.model.ox.mb(j4, j3));
                h.ox(EventConstants.Label.LP_APP_DIALOG_TRY_SHOW, j3);
                return null;
            }
        }).mb();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mb(long j2, long j3, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(Constants.KEY_PACKAGE);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.model.ox oxVar = new com.ss.android.downloadlib.addownload.model.ox();
                oxVar.mb = j2;
                oxVar.ox = j3;
                oxVar.hj = jSONObjectOptJSONObject.optString("icon_url");
                oxVar.f18011h = jSONObjectOptJSONObject.optString("app_name");
                oxVar.b = jSONObjectOptJSONObject.optString("package_name");
                oxVar.f18012u = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                oxVar.ko = jSONObjectOptJSONObject.optString("developer_name");
                oxVar.lz = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(com.bytedance.msdk.api.activity.TTDelegateActivity.INTENT_PERMISSIONS);
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i2);
                        oxVar.ww.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                b.mb().mb(oxVar);
                hj.mb().mb(oxVar.mb(), j3, oxVar.hj);
                return true;
            }
            h.mb(7, j3);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.exception.b.mb().mb(e2, "AdLpComplianceManager parseResponse");
            h.mb(7, j3);
            return false;
        }
    }

    public void mb(Activity activity) {
        this.mb = new SoftReference<>(activity);
    }
}
