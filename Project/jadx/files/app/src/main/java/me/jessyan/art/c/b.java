package me.jessyan.art.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: GlobalHttpHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: GlobalHttpHandler.java */
    class a implements b {
        a() {
        }

        @Override // me.jessyan.art.c.b
        @NonNull
        public Request a(@NonNull Interceptor.Chain chain, @NonNull Request request) {
            return request;
        }

        @Override // me.jessyan.art.c.b
        @NonNull
        public Response a(@Nullable String str, @NonNull Interceptor.Chain chain, @NonNull Response response) {
            return response;
        }
    }

    static {
        new a();
    }

    @NonNull
    Request a(@NonNull Interceptor.Chain chain, @NonNull Request request);

    @NonNull
    Response a(@Nullable String str, @NonNull Interceptor.Chain chain, @NonNull Response response) throws IOException;
}
