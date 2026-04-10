package com.funny.audio.core.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u0002H\n\"\u0006\b\u0000\u0010\n\u0018\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/funny/audio/core/utils/TextUtils;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "deserializeJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "serializeJson", "obj", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextUtils {
    public static final TextUtils INSTANCE = new TextUtils();
    private static Gson gson;

    private TextUtils() {
    }

    static {
        Gson gsonCreate = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(gsonCreate, "GsonBuilder().create()");
        gson = gsonCreate;
    }

    public final Gson getGson() {
        return gson;
    }

    public final void setGson(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "<set-?>");
        gson = gson2;
    }

    public final String serializeJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String json = gson.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(obj)");
        return json;
    }

    public final /* synthetic */ <T> T deserializeJson(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Gson gson2 = getGson();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) gson2.fromJson(json, (Class) Object.class);
    }
}
