package com.duokan.reader.ui.reading;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes5.dex */
public class DKImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f5745b;
    public boolean c;
    public long d;
    public Handler e;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && DKImageButton.this.f5745b != null) {
                DKImageButton.this.f5745b.a();
            }
            if (DKImageButton.this.c) {
                DKImageButton.this.e.sendEmptyMessageDelayed(0, DKImageButton.this.d);
            }
        }
    }

    public interface b {
        void a();
    }

    public DKImageButton(Context context) {
        super(context);
        this.f5744a = 0;
        this.c = false;
        this.d = 100L;
        this.e = new a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5745b == null || !isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.c = true;
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(0);
                this.e.sendEmptyMessageDelayed(0, this.d * 5);
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 6 || motionEvent.getAction() == 262 || motionEvent.getAction() == 518) {
            Handler handler2 = this.e;
            if (handler2 != null) {
                handler2.removeMessages(0);
            }
            if (this.c) {
                this.c = false;
                this.f5745b.a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnKeepLongPressListener(b bVar) {
        this.f5745b = bVar;
    }

    public DKImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5744a = 0;
        this.c = false;
        this.d = 100L;
        this.e = new a();
    }

    public DKImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5744a = 0;
        this.c = false;
        this.d = 100L;
        this.e = new a();
    }
}
