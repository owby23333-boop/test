package com.yuewen;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class jg0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static final /* synthetic */ <T> T a(JSONObject json, String key, T t) {
        Object objValueOf;
        ?? r4;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(key, "key");
        ?? r42 = t;
        if (!json.isNull(key)) {
            if (t instanceof String) {
                objValueOf = json.optString(key, (String) t);
            } else if (t instanceof Boolean) {
                objValueOf = Boolean.valueOf(json.optBoolean(key, ((Boolean) t).booleanValue()));
            } else if (t instanceof Integer) {
                objValueOf = Integer.valueOf(json.optInt(key, ((Number) t).intValue()));
            } else if (t instanceof Long) {
                objValueOf = Long.valueOf(json.optLong(key, ((Number) t).longValue()));
            } else {
                boolean z = t instanceof Double;
                r4 = t;
                if (z) {
                    objValueOf = Double.valueOf(json.optDouble(key, ((Number) t).doubleValue()));
                }
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                r42 = r4;
            }
            r4 = (T) objValueOf;
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            r42 = r4;
        }
        return (T) r42;
    }
}
