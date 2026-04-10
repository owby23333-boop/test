package com.kwad.sdk.contentalliance.a.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public AdTemplate adTemplate;
    public com.kwad.sdk.contentalliance.a.a.a awz;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        this.awz = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.awz != null) {
            this.awz.photoId = aVar.awz.photoId;
            this.awz.clickTime = aVar.awz.clickTime;
            this.awz.adStyle = aVar.awz.adStyle;
            this.awz.contentType = aVar.awz.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    public static class a {
        private AdTemplate adTemplate;
        private com.kwad.sdk.contentalliance.a.a.a awz;
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

        public final a dg(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a dh(String str) {
            this.manifest = str;
            return this;
        }

        public final a b(com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.awz = aVar;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a bo(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final b El() {
            return new b(this, (byte) 0);
        }
    }
}
