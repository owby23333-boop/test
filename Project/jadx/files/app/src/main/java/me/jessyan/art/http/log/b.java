package me.jessyan.art.http.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;

/* JADX INFO: compiled from: FormatPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a(long j2, boolean z2, int i2, @NonNull String str, @NonNull List<String> list, @NonNull String str2, @NonNull String str3);

    void a(long j2, boolean z2, int i2, @NonNull String str, @Nullable MediaType mediaType, @Nullable String str2, @NonNull List<String> list, @NonNull String str3, @NonNull String str4);

    void a(@NonNull Request request);

    void a(@NonNull Request request, @NonNull String str);
}
