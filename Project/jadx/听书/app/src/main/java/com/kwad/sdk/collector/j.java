package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Environment;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static void a(Context context, AppStatusRules appStatusRules) {
        long jObtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> listA = b.DF().a(uploadTargets, jObtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> listBm = bm(context);
        if (listBm != null) {
            listA.addAll(listBm);
            HashSet hashSet = new HashSet(listA);
            listA.clear();
            listA.addAll(hashSet);
        }
        d(context, listA);
    }

    private static void d(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cE(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: DK, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.b createRequest() {
                return new com.kwad.sdk.collector.a.b(list);
            }

            private static CollectResponse cE(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }
        }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.sdk.collector.a.b bVar) {
                super.onStartRequest(bVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.sdk.collector.a.b bVar, CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                DL();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.sdk.collector.a.b bVar, int i, String str) {
                super.onError(bVar, i, str);
            }

            private synchronized void DL() {
                j.bn(context);
            }
        });
    }

    private static List<UploadEntryNative> bm(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return aa.gV(com.kwad.sdk.crash.utils.h.J(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void bn(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }
}
