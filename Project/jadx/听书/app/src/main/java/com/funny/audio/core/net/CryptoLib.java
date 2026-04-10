package com.funny.audio.core.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CryptoLib.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086 J\u0011\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086 J\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086 J\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086 J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086 ¨\u0006\f"}, d2 = {"Lcom/funny/audio/core/net/CryptoLib;", "", "()V", "decryptData", "", "encryptType", "input", "getSign1", "getSign2", "getSign3", "getSign4", "getSign5", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CryptoLib {
    public static final CryptoLib INSTANCE = new CryptoLib();

    public final native String getSign1(String input);

    public final native String getSign2(String input);

    public final native String getSign3(String input);

    public final native String getSign4(String input);

    public final native String getSign5(String input);

    private CryptoLib() {
    }

    static {
        System.loadLibrary("cryptolib");
    }

    public final String decryptData(String encryptType, String input) {
        Intrinsics.checkNotNullParameter(encryptType, "encryptType");
        Intrinsics.checkNotNullParameter(input, "input");
        return Intrinsics.areEqual(encryptType, "DnvVswKW") ? DesDecryptor.INSTANCE.decrypt(input, "rThYzbEp") : Intrinsics.areEqual(encryptType, "czXzSZjk") ? DesDecryptor.INSTANCE.decrypt(input, "AEEkTXLK") : "";
    }
}
