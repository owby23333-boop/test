package com.anythink.network.toutiao;

import com.anythink.core.api.ATCustomVideo;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: loaded from: classes2.dex */
public class TTATCustomVideo implements ATCustomVideo {
    TTFeedAd.CustomizeVideo a;

    public TTATCustomVideo(TTFeedAd.CustomizeVideo customizeVideo) {
        this.a = customizeVideo;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public String getVideoUrl() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return null;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoBreak(long j2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j2);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoContinue(long j2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j2);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoError(long j2, int i2, int i3) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j2, i2, i3);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoPause(long j2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j2);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStartError(int i2, int i3) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i2, i3);
        }
    }
}
