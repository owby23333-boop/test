package miuix.graphics.shadow;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;

/* JADX INFO: loaded from: classes7.dex */
public class DropShadowConfig {
    float blurRadiusDp;
    BlurMaskFilter.Blur blurStyle;
    float dispersion;
    float offsetXDp;
    float offsetYDp;
    int shadowColor;
    int shadowDarkColor;

    public static class Builder {
        private DropShadowConfig dropShadowConfig;

        public Builder(float f) {
            this.dropShadowConfig = new DropShadowConfig(f);
        }

        public DropShadowConfig create() {
            return this.dropShadowConfig;
        }

        public Builder setBlurRadius(float f) {
            this.dropShadowConfig.blurRadiusDp = f;
            return this;
        }

        public Builder setColor(int i, int i2) {
            DropShadowConfig dropShadowConfig = this.dropShadowConfig;
            dropShadowConfig.shadowColor = i;
            dropShadowConfig.shadowDarkColor = i2;
            return this;
        }

        public Builder setDispersion(float f) {
            this.dropShadowConfig.dispersion = f;
            return this;
        }

        public Builder setOffsetXDp(int i) {
            this.dropShadowConfig.offsetXDp = i;
            return this;
        }

        public Builder setOffsetYDp(int i) {
            this.dropShadowConfig.offsetYDp = i;
            return this;
        }

        public Builder setStyle(BlurMaskFilter.Blur blur) {
            this.dropShadowConfig.blurStyle = blur;
            return this;
        }
    }

    public DropShadowConfig(float f) {
        this(f, BlurMaskFilter.Blur.NORMAL);
    }

    public DropShadowConfig(float f, BlurMaskFilter.Blur blur) {
        this(Color.parseColor("#0D000000"), Color.parseColor("#0DFFFFFF"), 0.0f, 0.0f, f, blur);
    }

    public DropShadowConfig(int i, int i2, float f, float f2, float f3, BlurMaskFilter.Blur blur) {
        this.dispersion = 1.0f;
        this.shadowColor = i;
        this.shadowDarkColor = i2;
        this.offsetXDp = f;
        this.offsetYDp = f2;
        this.blurRadiusDp = f3;
        this.blurStyle = blur;
    }
}
