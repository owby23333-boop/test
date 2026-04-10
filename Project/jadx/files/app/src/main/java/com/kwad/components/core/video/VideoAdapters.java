package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class VideoAdapters {

    /* JADX INFO: renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Ry = new int[AdaptType.values().length];

        static {
            try {
                Ry[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Ry[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i2, int i3) {
            if (view == null || i2 == 0 || i3 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i2, int i3) {
            if (!b(view, view2, i2, i3)) {
                com.kwad.sdk.core.d.b.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i2, i3);
            boolean z2 = dVar2.getRatio() >= 1.0f;
            boolean z3 = dVar.getRatio() >= 1.0f;
            AdaptType adaptType = (z3 && z2) ? AdaptType.PORTRAIT_VERTICAL : z3 ? AdaptType.PORTRAIT_HORIZONTAL : z2 ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        protected abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    public static class b extends a {
        private float Rz = 0.8f;
        private float RA = 0.9375f;
        private float RB = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float fQS;
            float f2;
            float fQR;
            float f3;
            float fQT = dVar.qT();
            float fQT2 = dVar2.qT();
            float fQS2 = dVar.qS();
            float fQR2 = dVar.qR();
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo containerSize: " + fQR2 + ", " + fQS2);
            int i2 = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (fQT > fQT2) {
                    fQR = dVar.qR();
                    f3 = fQR / fQT2;
                    float f4 = fQS2 / f3;
                    float f5 = this.Rz;
                    if (f4 < f5) {
                        fQS = fQS2 / f5;
                        f2 = fQS * fQT2;
                    }
                } else {
                    fQS = dVar.qS();
                    f2 = fQT2 * fQS;
                    float f6 = fQR2 / f2;
                    float f7 = this.RA;
                    if (f6 < f7) {
                        fQR = fQR2 / f7;
                        f3 = fQR / fQT2;
                    }
                }
                float f8 = f2;
                f3 = fQS;
                fQR = f8;
            } else if (i2 == 3 || i2 == 4) {
                fQR = this.RB * fQS2;
                f3 = fQR / fQT2;
            } else {
                fQR = -2.1474836E9f;
                f3 = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo result: " + fQR + ", " + f3);
            if (fQR == -2.1474836E9f || f3 == -2.1474836E9f) {
                return;
            }
            int i3 = (int) f3;
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = i3;
                layoutParams.height = (int) fQR;
            } else {
                layoutParams.height = i3;
                layoutParams.width = (int) fQR;
            }
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float fQR;
            float f2;
            float fQT = dVar.qT();
            float fQT2 = dVar2.qT();
            int i2 = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (fQT >= fQT2) {
                    float fQS = dVar.qS();
                    f2 = fQS;
                    fQR = fQS * fQT2;
                } else {
                    fQR = dVar.qR();
                    f2 = fQR / fQT2;
                }
            } else if (i2 == 3 || i2 == 4) {
                fQR = dVar.qS();
                f2 = fQR / fQT2;
            } else {
                fQR = 0.0f;
                f2 = -2.1474836E9f;
            }
            if (f2 == -2.1474836E9f || fQR == -2.1474836E9f) {
                return;
            }
            int i3 = (int) f2;
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = i3;
                layoutParams.height = (int) fQR;
            } else {
                layoutParams.height = i3;
                layoutParams.width = (int) fQR;
            }
        }
    }

    static class d {
        float RC;
        float height;
        float width;

        public d(float f2, float f3) {
            this.RC = -1.0f;
            this.width = f2;
            this.height = f3;
            if (f2 <= 0.0f || f3 <= 0.0f) {
                return;
            }
            this.RC = f3 / f2;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.RC;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float qR() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float qS() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float qT() {
            if (!isValid()) {
                return -1.0f;
            }
            float f2 = this.height;
            float f3 = this.width;
            return f2 > f3 ? f2 / f3 : f3 / f2;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.RC + '}';
        }
    }
}
