package com.duokan.free.tts.service;

import com.duokan.free.tts.data.Sentence;
import com.duokan.free.tts.data.TTSIndex;

/* JADX INFO: loaded from: classes15.dex */
public interface f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f3733a;

        public a(Throwable th) {
            this.f3733a = th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3734a;

        public b(float f) {
            this.f3734a = f;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3735a;

        public c(int i) {
            this.f3735a = i;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Sentence f3736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TTSIndex f3737b;

        public d(Sentence sentence, TTSIndex tTSIndex) {
            this.f3736a = sentence;
            this.f3737b = tTSIndex;
        }
    }
}
