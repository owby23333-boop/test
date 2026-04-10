package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoAdapters {

    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.c {
        protected abstract void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2);

        @Override // com.kwad.components.core.video.c
        public final void a(final View view, View view2, int i, int i2) {
            AdaptType adaptType;
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (C(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view.setLayoutParams(layoutParams);
            }
        }

        private static boolean C(View view) {
            return view.isInLayout() || view.isLayoutRequested();
        }

        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float fUa;
            float fUb;
            float fUc = dVar.uc();
            float fUc2 = dVar2.uc();
            int i = AnonymousClass1.aaV[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fUc >= fUc2) {
                    fUb = dVar.ub();
                    fUa = fUb * fUc2;
                } else {
                    fUa = dVar.ua();
                    fUb = fUa / fUc2;
                }
            } else if (i == 3 || i == 4) {
                fUa = dVar.ub();
                fUb = fUa / fUc2;
            } else {
                fUa = 0.0f;
                fUb = -2.1474836E9f;
            }
            if (fUb == -2.1474836E9f || fUa == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) fUb;
                layoutParams.height = (int) fUa;
            } else {
                layoutParams.height = (int) fUb;
                layoutParams.width = (int) fUa;
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aaV;

        static {
            int[] iArr = new int[AdaptType.values().length];
            aaV = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aaV[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aaV[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aaV[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b extends a {
        private float aaY = 0.8f;
        private float aaZ = 0.9375f;
        private float aba = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float fUb;
            float f;
            float fUc = dVar.uc();
            float fUc2 = dVar2.uc();
            float fUb2 = dVar.ub();
            float fUa = dVar.ua();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + fUa + ", " + fUb2);
            int i = AnonymousClass1.aaV[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fUc > fUc2) {
                    float fUa2 = dVar.ua();
                    float f2 = fUa2 / fUc2;
                    float f3 = fUb2 / f2;
                    float f4 = this.aaY;
                    if (f3 >= f4) {
                        f = fUa2;
                        fUb = f2;
                    } else {
                        fUb = fUb2 / f4;
                        f = fUb * fUc2;
                    }
                } else {
                    fUb = dVar.ub();
                    f = fUc2 * fUb;
                    float f5 = fUa / f;
                    float f6 = this.aaZ;
                    if (f5 < f6) {
                        f = fUa / f6;
                        fUb = f / fUc2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = fUb2 * this.aba;
                fUb = f / fUc2;
            } else {
                fUb = -2.1474836E9f;
                f = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + fUb);
            if (f == -2.1474836E9f || fUb == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) fUb;
                layoutParams.height = (int) f;
            } else {
                layoutParams.height = (int) fUb;
                layoutParams.width = (int) f;
            }
        }
    }

    static class d {
        float abb;
        float height;
        float width;

        public d(float f, float f2) {
            this.abb = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.abb = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.abb;
        }

        public final float ua() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float ub() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float uc() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            return f > f2 ? f / f2 : f2 / f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.abb + '}';
        }
    }
}
