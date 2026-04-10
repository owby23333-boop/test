package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class au extends at {
    public static final String b = "logout";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f12878c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    @NonNull
    String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory iXAdContainerFactoryC = z.a().c();
            if (iXAdContainerFactoryC != null) {
                iXAdContainerFactoryC.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f12878c[i2] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
