package com.funny.audio.core.utils;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Md5Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/funny/audio/core/utils/Md5Utils;", "", "()V", "md5encode", "", "input", "", TKDownloadReason.KSAD_TK_MD5, "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Md5Utils {
    public static final Md5Utils INSTANCE = new Md5Utils();

    private Md5Utils() {
    }

    public final String md5encode(String input) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(input, "input");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String string = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(string, "BigInteger(1, md.digest(…yteArray())).toString(16)");
        return StringsKt.padStart(string, 32, '0');
    }

    public final String md5encode(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String string = new BigInteger(1, MessageDigest.getInstance("MD5").digest(input)).toString(16);
        Intrinsics.checkNotNullExpressionValue(string, "BigInteger(1, md.digest(input)).toString(16)");
        return StringsKt.padStart(string, 32, '0');
    }

    public final String md5(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return md5encode(str);
    }
}
