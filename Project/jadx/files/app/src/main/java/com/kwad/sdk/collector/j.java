package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.s;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        long jObtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> listA = b.tO().a(uploadTargets, jObtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> listAK = aK(context);
        if (listAK != null) {
            listA.addAll(listAK);
            HashSet hashSet = new HashSet(listA);
            listA.clear();
            listA.addAll(hashSet);
        }
        b(context, listA);
    }

    private static List<UploadEntryNative> aK(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return s.ei(com.kwad.sdk.crash.utils.h.D(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void aL(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void b(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new m<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            @NonNull
            private static CollectResponse bc(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: tT, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.kwai.b createRequest() {
                return new com.kwad.sdk.collector.kwai.b(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bc(str);
            }
        }.request(new p<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.b bVar) {
                super.onStartRequest(bVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.sdk.collector.kwai.b bVar, int i2, String str) {
                super.onError(bVar, i2, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.sdk.collector.kwai.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                tU();
            }

            private synchronized void tU() {
                j.aL(context);
            }
        });
    }
}
