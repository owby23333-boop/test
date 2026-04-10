package com.lxj.xpopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.lxj.xpopup.c.c;
import com.lxj.xpopup.c.f;
import com.lxj.xpopup.c.h;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.enums.PopupType;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;

/* JADX INFO: compiled from: XPopup.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static int a = Color.parseColor("#121212");
    private static int b = 300;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f17316c = Color.parseColor("#55000000");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f17317d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f17318e = Color.parseColor("#7F000000");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PointF f17319f = null;

    /* JADX INFO: renamed from: com.lxj.xpopup.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: XPopup.java */
    static class ViewOnTouchListenerC0492a implements View.OnTouchListener {
        ViewOnTouchListenerC0492a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.f17319f = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
            }
            if ("xpopup".equals(view.getTag()) && motionEvent.getAction() == 2) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (motionEvent.getAction() == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                view.setTag(null);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: XPopup.java */
    public static class b {
        private final com.lxj.xpopup.core.b a = new com.lxj.xpopup.core.b();
        private Context b;

        /* JADX INFO: renamed from: com.lxj.xpopup.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: XPopup.java */
        class ViewOnTouchListenerC0493a implements View.OnTouchListener {
            ViewOnTouchListenerC0493a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                b.this.a.f17416k = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                return false;
            }
        }

        public b(Context context) {
            this.b = context;
        }

        public b b(View view) {
            com.lxj.xpopup.core.b bVar = this.a;
            bVar.f17413h = view;
            bVar.f17413h.setOnTouchListener(new ViewOnTouchListenerC0493a());
            return this;
        }

        public b c(Boolean bool) {
            this.a.b = bool;
            return this;
        }

        public b d(Boolean bool) {
            this.a.f17408c = bool;
            return this;
        }

        public b e(Boolean bool) {
            this.a.f17410e = bool;
            return this;
        }

        public b f(Boolean bool) {
            this.a.f17424s = bool;
            return this;
        }

        public b a(PopupType popupType) {
            this.a.a = popupType;
            return this;
        }

        public b c(boolean z2) {
            this.a.J = z2;
            return this;
        }

        public b a(Boolean bool) {
            this.a.f17409d = bool;
            return this;
        }

        public b b(Boolean bool) {
            this.a.f17422q = bool;
            return this;
        }

        public b a(View view) {
            this.a.f17412g = view;
            return this;
        }

        public b b(int i2) {
            this.a.A = i2;
            return this;
        }

        public b a(PopupAnimation popupAnimation) {
            this.a.f17414i = popupAnimation;
            return this;
        }

        public b b(boolean z2) {
            this.a.C = z2;
            return this;
        }

        public b a(int i2) {
            this.a.f17417l = i2;
            return this;
        }

        public b a(PopupPosition popupPosition) {
            this.a.f17425t = popupPosition;
            return this;
        }

        public b a(boolean z2) {
            this.a.f17428w = Boolean.valueOf(z2);
            return this;
        }

        public b a(h hVar) {
            this.a.f17423r = hVar;
            return this;
        }

        public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, c cVar, com.lxj.xpopup.c.a aVar, boolean z2, int i2) {
            a(PopupType.Center);
            ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.b, i2);
            confirmPopupView.a(charSequence, charSequence2, null);
            confirmPopupView.a(charSequence3);
            confirmPopupView.b(charSequence4);
            confirmPopupView.a(cVar, aVar);
            confirmPopupView.f17484i0 = z2;
            confirmPopupView.f17361s = this.a;
            return confirmPopupView;
        }

        public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, c cVar, com.lxj.xpopup.c.a aVar, boolean z2) {
            return a(charSequence, charSequence2, charSequence3, charSequence4, cVar, aVar, z2, 0);
        }

        public CenterListPopupView a(CharSequence charSequence, String[] strArr, int[] iArr, int i2, f fVar, int i3, int i4) {
            a(PopupType.Center);
            CenterListPopupView centerListPopupViewA = new CenterListPopupView(this.b, i3, i4).a(charSequence, strArr, iArr).b(i2).a(fVar);
            centerListPopupViewA.f17361s = this.a;
            return centerListPopupViewA;
        }

        public CenterListPopupView a(CharSequence charSequence, String[] strArr, int[] iArr, int i2, f fVar) {
            return a(charSequence, strArr, iArr, i2, fVar, 0, 0);
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, f fVar, int i2, int i3, int i4) {
            a(PopupType.AttachView);
            AttachListPopupView attachListPopupViewA = new AttachListPopupView(this.b, i2, i3).a(strArr, iArr).b(i4).a(fVar);
            attachListPopupViewA.f17361s = this.a;
            return attachListPopupViewA;
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, f fVar) {
            return a(strArr, iArr, fVar, 0, 0, 17);
        }

        public BasePopupView a(BasePopupView basePopupView) {
            if (basePopupView instanceof CenterPopupView) {
                a(PopupType.Center);
            } else if (basePopupView instanceof BottomPopupView) {
                a(PopupType.Bottom);
            } else if (basePopupView instanceof AttachPopupView) {
                a(PopupType.AttachView);
            } else if (basePopupView instanceof ImageViewerPopupView) {
                a(PopupType.ImageViewer);
            } else if (basePopupView instanceof PositionPopupView) {
                a(PopupType.Position);
            }
            basePopupView.f17361s = this.a;
            return basePopupView;
        }
    }

    public static void a(int i2) {
        a = i2;
    }

    public static int b() {
        return f17317d;
    }

    public static int c() {
        return a;
    }

    public static int d() {
        return f17318e;
    }

    public static int e() {
        return f17316c;
    }

    public static int a() {
        return b;
    }

    public static void a(View view) {
        view.setOnTouchListener(new ViewOnTouchListenerC0492a());
        view.setTag("xpopup");
    }
}
