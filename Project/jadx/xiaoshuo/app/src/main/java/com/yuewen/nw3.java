package com.yuewen;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.duokan.free.tts.data.TtsTone;
import com.duokan.free.tts.datasource.TTSExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes15.dex */
public interface nw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TtsTone f15101a = TtsTone.AI_Male;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final TtsTone f15102a;

        /* JADX INFO: renamed from: com.yuewen.nw3$a$a, reason: collision with other inner class name */
        public static class C0676a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NonNull
            public TtsTone f15103a = nw3.f15101a;

            public a a() {
                return new a(this.f15103a);
            }

            public void b(@NonNull TtsTone ttsTone) {
                this.f15103a = ttsTone;
            }
        }

        @NonNull
        public TtsTone a() {
            return this.f15102a;
        }

        public a(@NonNull TtsTone ttsTone) {
            this.f15102a = ttsTone;
        }
    }

    @NonNull
    Future<Uri> a(@NonNull String str, @NonNull a aVar) throws TTSExecutionException;

    void release();
}
