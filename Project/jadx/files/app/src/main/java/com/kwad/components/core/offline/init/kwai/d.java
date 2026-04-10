package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import android.location.Location;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bc;

/* JADX INFO: loaded from: classes3.dex */
final class d implements IEnvironment {
    d() {
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.r.b.ar(context).a(offlineOnAudioConflictListener);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppId() {
        return KsAdSDKImpl.get().getAppId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppVersion() {
        return "3.3.38";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getBiz() {
        return com.kwad.sdk.d.Yd;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final Context getContext() {
        return KsAdSDKImpl.get().getContext();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getDeviceId() {
        return bc.getDeviceId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpf() {
        return "ANDROID_PHONE";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpn() {
        return "kseulivesdk";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLatitude(Context context) {
        Location locationBX = at.bX(context);
        return locationBX != null ? locationBX.getLatitude() : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLongitude(Context context) {
        Location locationBX = at.bX(context);
        return locationBX != null ? locationBX.getLongitude() : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOperator(Context context) {
        return String.valueOf(af.cp(context));
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOsVersion() {
        return bc.getOsVersion();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getProcessName(Context context) {
        return SystemUtil.getProcessName(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getSdkVersion() {
        return "3.3.38";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final int getStatusBarHeight(Context context) {
        return com.kwad.sdk.b.kwai.a.getStatusBarHeight(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getUserAgent() {
        return q.getUserAgent();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isArm64(Context context) {
        return AbiUtil.isArm64(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDebug() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDevelopEnable() {
        return com.kwad.components.core.a.bI.booleanValue();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isInMainProcess(Context context) {
        return SystemUtil.isInMainProcess(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String localIpAddress() {
        return "10.244.154.152";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.r.b.ar(context).b(offlineOnAudioConflictListener);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean requestAudioFocus(Context context, boolean z2) {
        return com.kwad.components.core.r.b.ar(context).aI(z2);
    }
}
