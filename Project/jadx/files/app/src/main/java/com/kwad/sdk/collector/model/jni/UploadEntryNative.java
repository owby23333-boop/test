package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UploadEntryNative extends NativeObject implements e {
    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }

    public UploadEntryNative(long j2) {
        this.mPtr = j2;
    }

    private static String a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    private String tX() {
        try {
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return strUploadEntryGetOriginFilePath.substring(strUploadEntryGetOriginFilePath.indexOf(strUploadEntryGetPackageName)).replaceFirst(strUploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j2 = this.mPtr;
        if (j2 != 0) {
            AppStatusNative.nativeDeleteUploadEntry(j2);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UploadEntryNative.class == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (strUploadEntryGetPackageName == null ? a(uploadEntryNative) != null : !strUploadEntryGetPackageName.equals(a(uploadEntryNative))) {
                return false;
            }
            String strUploadEntryGetOriginFilePath2 = AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative);
            if (strUploadEntryGetOriginFilePath != null) {
                return strUploadEntryGetOriginFilePath.equals(strUploadEntryGetOriginFilePath2);
            }
            if (strUploadEntryGetOriginFilePath2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        return ((strUploadEntryGetPackageName != null ? strUploadEntryGetPackageName.hashCode() : 0) * 31) + (strUploadEntryGetOriginFilePath != null ? strUploadEntryGetOriginFilePath.hashCode() : 0);
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("packageName");
        String strOptString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, strOptString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, strOptString2);
    }

    @Override // com.kwad.sdk.collector.model.e
    @Nullable
    @WorkerThread
    public final JSONObject tV() {
        try {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
            s.putValue(jSONObject, "content", com.kwad.sdk.collector.e.bb(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            s.putValue(jSONObject, "fileName", tX());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
        s.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + '}';
    }
}
