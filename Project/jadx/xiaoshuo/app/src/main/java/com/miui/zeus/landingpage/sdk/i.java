package com.miui.zeus.landingpage.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class i extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<DownloadListener> f7201a = new CopyOnWriteArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f7202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7203b;

        public a(Intent intent, String str) {
            this.f7202a = intent;
            this.f7203b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int intExtra = this.f7202a.getIntExtra("errorCode", Integer.MIN_VALUE);
            int intExtra2 = this.f7202a.getIntExtra("progress", Integer.MIN_VALUE);
            int intExtra3 = this.f7202a.getIntExtra("status", Integer.MIN_VALUE);
            h.a("MarketDownloadBroadcastReceiver", "code=", Integer.valueOf(intExtra), ",progress=", Integer.valueOf(intExtra2), ",status=", Integer.valueOf(intExtra3));
            if (intExtra == -8) {
                i iVar = i.this;
                String str = this.f7203b;
                iVar.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onCancelDownload packageName=" + str);
                Iterator<DownloadListener> it = iVar.f7201a.iterator();
                while (it.hasNext()) {
                    it.next().onCancelDownload(str);
                }
                e eVar = k.a().d.get(str);
                if (eVar == null) {
                    k.a().d.put(str, new e(5, intExtra2));
                    return;
                } else {
                    eVar.f7196b = 5;
                    eVar.f7195a = intExtra2;
                    return;
                }
            }
            if (intExtra == -3) {
                i iVar2 = i.this;
                String str2 = this.f7203b;
                iVar2.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onInstallFail packageName=" + str2 + ",statusCode=" + intExtra3);
                Iterator<DownloadListener> it2 = iVar2.f7201a.iterator();
                while (it2.hasNext()) {
                    it2.next().onInstallFailed(str2, intExtra3);
                }
                return;
            }
            if (intExtra == -2) {
                i iVar3 = i.this;
                String str3 = this.f7203b;
                iVar3.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onDownloadFail packageName=" + str3 + ",statusCode=" + intExtra3);
                Iterator<DownloadListener> it3 = iVar3.f7201a.iterator();
                while (it3.hasNext()) {
                    it3.next().onDownloadFailed(str3, intExtra3);
                }
                k.a().d.remove(this.f7203b);
                return;
            }
            if (intExtra == 1) {
                i iVar4 = i.this;
                String str4 = this.f7203b;
                iVar4.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onDownloadStart packageName=" + str4);
                Iterator<DownloadListener> it4 = iVar4.f7201a.iterator();
                while (it4.hasNext()) {
                    it4.next().onDownloadStarted(str4);
                }
                e eVar2 = k.a().d.get(str4);
                if (eVar2 == null) {
                    k.a().d.put(str4, new e(1, 0));
                    return;
                } else {
                    eVar2.f7196b = 1;
                    eVar2.f7195a = 0;
                    return;
                }
            }
            if (intExtra == 2) {
                i iVar5 = i.this;
                String str5 = this.f7203b;
                iVar5.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onDownloadSuccess packageName=" + str5);
                Iterator<DownloadListener> it5 = iVar5.f7201a.iterator();
                while (it5.hasNext()) {
                    it5.next().onDownloadFinished(str5);
                }
                return;
            }
            if (intExtra == 3) {
                i iVar6 = i.this;
                String str6 = this.f7203b;
                iVar6.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onInstallStart packageName=" + str6);
                Iterator<DownloadListener> it6 = iVar6.f7201a.iterator();
                while (it6.hasNext()) {
                    it6.next().onInstallStart(str6);
                }
                return;
            }
            if (intExtra == 4) {
                i iVar7 = i.this;
                String str7 = this.f7203b;
                iVar7.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onInstallSuccess packageName=" + str7);
                Iterator<DownloadListener> it7 = iVar7.f7201a.iterator();
                while (it7.hasNext()) {
                    it7.next().onInstallSuccess(str7);
                }
                k.a().getClass();
                k.e.remove(str7);
                return;
            }
            if (intExtra != 5) {
                i iVar8 = i.this;
                String str8 = this.f7203b;
                Iterator<DownloadListener> it8 = iVar8.f7201a.iterator();
                while (it8.hasNext()) {
                    it8.next().onOtherOperation(str8, intExtra2, intExtra);
                }
                return;
            }
            if (intExtra3 == -3) {
                i iVar9 = i.this;
                String str9 = this.f7203b;
                iVar9.getClass();
                h.a("MarketDownloadBroadcastReceiver", "onDownloadPause packageName=" + str9);
                Iterator<DownloadListener> it9 = iVar9.f7201a.iterator();
                while (it9.hasNext()) {
                    it9.next().onDownloadPaused(str9);
                }
                e eVar3 = k.a().d.get(str9);
                if (eVar3 == null) {
                    k.a().d.put(str9, new e(2, intExtra2));
                    return;
                } else {
                    eVar3.f7196b = 2;
                    eVar3.f7195a = intExtra2;
                    return;
                }
            }
            if (intExtra3 != -2) {
                return;
            }
            i iVar10 = i.this;
            String str10 = this.f7203b;
            iVar10.getClass();
            h.a("MarketDownloadBroadcastReceiver", "onDownloadingProgress packageName=" + str10 + ",progress=" + intExtra2);
            Iterator<DownloadListener> it10 = iVar10.f7201a.iterator();
            while (it10.hasNext()) {
                it10.next().onDownloadProgressUpdated(str10, intExtra2);
            }
            e eVar4 = k.a().d.get(str10);
            if (eVar4 == null) {
                k.a().d.put(str10, new e(3, intExtra2));
            } else {
                eVar4.f7196b = 3;
                eVar4.f7195a = intExtra2;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction()) || !"com.xiaomi.market.DOWNLOAD_INSTALL_RESULT".equals(intent.getAction())) {
            return;
        }
        String stringExtra = intent.getStringExtra("packageName");
        h.a("MarketDownloadBroadcastReceiver", "packageName=" + stringExtra);
        ((ThreadPoolExecutor) m.f7207a).execute(new a(intent, stringExtra));
    }
}
