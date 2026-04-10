package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b<Integer> {
    public c() {
        super("batchReportCacheType", 2);
    }

    public static int aS(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.b.d("batchReportCacheType", "loadBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return 2;
        }
        return sharedPreferences.getInt("batchReportCacheType", 2);
    }

    private static void h(@Nullable Context context, int i2) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.b.d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("batchReportCacheType", i2);
        editorEdit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(aS(KsAdSDK.getContext())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        h(KsAdSDK.getContext(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Integer.valueOf(jSONObject.optInt(getKey(), vj().intValue())) : vj());
    }
}
