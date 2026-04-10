package xyz.doikki.videoplayer.player;

import androidx.annotation.Nullable;
import xyz.doikki.videoplayer.render.RenderViewFactory;
import xyz.doikki.videoplayer.render.TextureRenderViewFactory;

/* JADX INFO: loaded from: classes4.dex */
public class VideoViewConfig {
    public final boolean mAdaptCutout;
    public final boolean mEnableAudioFocus;
    public final boolean mEnableOrientation;
    public final boolean mIsEnableLog;
    public final boolean mPlayOnMobileNetwork;
    public final PlayerFactory mPlayerFactory;
    public final ProgressManager mProgressManager;
    public final RenderViewFactory mRenderViewFactory;
    public final int mScreenScaleType;

    public static final class Builder {
        private boolean mEnableOrientation;
        private boolean mIsEnableLog;
        private PlayerFactory mPlayerFactory;
        private ProgressManager mProgressManager;
        private RenderViewFactory mRenderViewFactory;
        private int mScreenScaleType;
        private boolean mPlayOnMobileNetwork = true;
        private boolean mEnableAudioFocus = true;
        private boolean mAdaptCutout = true;

        public VideoViewConfig build() {
            return new VideoViewConfig(this);
        }

        public Builder setAdaptCutout(boolean z2) {
            this.mAdaptCutout = z2;
            return this;
        }

        public Builder setEnableAudioFocus(boolean z2) {
            this.mEnableAudioFocus = z2;
            return this;
        }

        public Builder setEnableOrientation(boolean z2) {
            this.mEnableOrientation = z2;
            return this;
        }

        public Builder setLogEnabled(boolean z2) {
            this.mIsEnableLog = z2;
            return this;
        }

        public Builder setPlayOnMobileNetwork(boolean z2) {
            this.mPlayOnMobileNetwork = z2;
            return this;
        }

        public Builder setPlayerFactory(PlayerFactory playerFactory) {
            this.mPlayerFactory = playerFactory;
            return this;
        }

        public Builder setProgressManager(@Nullable ProgressManager progressManager) {
            this.mProgressManager = progressManager;
            return this;
        }

        public Builder setRenderViewFactory(RenderViewFactory renderViewFactory) {
            this.mRenderViewFactory = renderViewFactory;
            return this;
        }

        public Builder setScreenScaleType(int i2) {
            this.mScreenScaleType = i2;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private VideoViewConfig(Builder builder) {
        this.mIsEnableLog = builder.mIsEnableLog;
        this.mEnableOrientation = builder.mEnableOrientation;
        this.mPlayOnMobileNetwork = builder.mPlayOnMobileNetwork;
        this.mEnableAudioFocus = builder.mEnableAudioFocus;
        this.mProgressManager = builder.mProgressManager;
        this.mScreenScaleType = builder.mScreenScaleType;
        if (builder.mPlayerFactory == null) {
            this.mPlayerFactory = AndroidMediaPlayerFactory.create();
        } else {
            this.mPlayerFactory = builder.mPlayerFactory;
        }
        if (builder.mRenderViewFactory == null) {
            this.mRenderViewFactory = TextureRenderViewFactory.create();
        } else {
            this.mRenderViewFactory = builder.mRenderViewFactory;
        }
        this.mAdaptCutout = builder.mAdaptCutout;
    }
}
