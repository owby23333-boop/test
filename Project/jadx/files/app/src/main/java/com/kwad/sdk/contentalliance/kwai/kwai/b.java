package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public com.kwad.sdk.contentalliance.kwai.kwai.a abe;
    public AdTemplate adTemplate;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    public static class a {
        private com.kwad.sdk.contentalliance.kwai.kwai.a abe;
        private AdTemplate adTemplate;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public a(String str) {
            this.videoUrl = str;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a aS(boolean z2) {
            this.isNoCache = z2;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
            this.abe = aVar;
            return this;
        }

        public final a bd(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a be(String str) {
            this.manifest = str;
            return this;
        }

        public final b uc() {
            return new b(this, (byte) 0);
        }
    }

    private b(a aVar) {
        this.abe = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.abe != null) {
            this.abe.photoId = aVar.abe.photoId;
            this.abe.clickTime = aVar.abe.clickTime;
            this.abe.adStyle = aVar.abe.adStyle;
            this.abe.contentType = aVar.abe.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
