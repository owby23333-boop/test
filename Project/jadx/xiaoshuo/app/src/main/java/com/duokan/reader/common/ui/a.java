package com.duokan.reader.common.ui;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.duokan.reader.common.ui.PagesController;
import com.yuewen.xv1;

/* JADX INFO: loaded from: classes2.dex */
public class a extends PagesController {

    /* JADX INFO: renamed from: com.duokan.reader.common.ui.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0266a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4062a;

        static {
            int[] iArr = new int[PagesController.AnimationType.values().length];
            f4062a = iArr;
            try {
                iArr[PagesController.AnimationType.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4062a[PagesController.AnimationType.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4062a[PagesController.AnimationType.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4062a[PagesController.AnimationType.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(xv1 xv1Var) {
        super(xv1Var);
    }

    @Override // com.duokan.reader.common.ui.PagesController
    public Animation Df(PagesController.AnimationType animationType, PagesController.g gVar, PagesController.g gVar2) {
        int i = C0266a.f4062a[animationType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? super.Df(animationType, gVar, gVar2) : new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
    }

    @Override // com.duokan.reader.common.ui.PagesController
    public Animation Ff(PagesController.AnimationType animationType, PagesController.g gVar, PagesController.g gVar2) {
        int i = C0266a.f4062a[animationType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? super.Ff(animationType, gVar, gVar2) : new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f) : new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
    }
}
