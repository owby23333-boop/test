package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetModels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003¨\u0006\u0006"}, d2 = {"success", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/core/net/ResponseInfo;", "successWithData", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NetModelsKt {
    public static final boolean success(ResponseInfo responseInfo) {
        return responseInfo != null && responseInfo.getCode() == 1001;
    }

    public static final <T> boolean success(Response<T> response) {
        return response != null && response.getCode() == 1001;
    }

    public static final <T> boolean successWithData(Response<T> response) {
        if (response != null && response.getCode() == 1001 && response.getBody() != null) {
            AppBody<T> body = response.getBody();
            Intrinsics.checkNotNull(body);
            if (body.getData() != null) {
                return true;
            }
        }
        return false;
    }
}
