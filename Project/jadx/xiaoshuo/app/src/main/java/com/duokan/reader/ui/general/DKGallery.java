package com.duokan.reader.ui.general;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;

/* JADX INFO: loaded from: classes5.dex */
public class DKGallery extends Gallery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f5371b;
    public boolean c;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (DKGallery.this.getWindowToken() == null || !DKGallery.this.isShown() || DKGallery.this.getAdapter() == null || DKGallery.this.getAdapter().getCount() < 1 || DKGallery.this.c) {
                return true;
            }
            DKGallery dKGallery = DKGallery.this;
            dKGallery.setSelection((dKGallery.getSelectedItemPosition() + 1) % DKGallery.this.getAdapter().getCount(), true);
            DKGallery.this.f5371b = null;
            DKGallery dKGallery2 = DKGallery.this;
            dKGallery2.f(dKGallery2.f5370a);
            return true;
        }
    }

    public DKGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5370a = 0;
        this.f5371b = null;
        this.c = false;
    }

    public final boolean e(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX();
    }

    public final void f(int i) {
        if (this.f5370a > 0 && this.f5371b == null) {
            Handler handler = new Handler(new a());
            this.f5371b = handler;
            handler.sendEmptyMessageDelayed(0, this.f5370a);
        }
    }

    public final void g() {
        Handler handler = this.f5371b;
        if (handler != null) {
            handler.removeMessages(0);
            this.f5371b = null;
        }
    }

    @Override // android.widget.Gallery, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f(this.f5370a);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        onKeyDown(e(motionEvent, motionEvent2) ? 21 : 22, null);
        return true;
    }

    @Override // android.widget.Gallery, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
            f(this.f5370a);
        } else {
            this.c = true;
            g();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            f(this.f5370a);
        } else {
            g();
        }
    }

    public void setAutoScrollDuration(int i) {
        this.f5370a = i;
        g();
        f(this.f5370a);
    }
}
