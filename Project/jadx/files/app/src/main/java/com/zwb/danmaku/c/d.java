package com.zwb.danmaku.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.zwb.danmaku.b;
import com.zwb.danmaku.model.BaseDanmaku;

/* JADX INFO: compiled from: DanmakuTouchHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    private final GestureDetector a;
    private com.zwb.danmaku.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f20640c = new a();

    /* JADX INFO: compiled from: DanmakuTouchHelper.java */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            b.a onDanmakuClickListener;
            if (d.this.b == null || (onDanmakuClickListener = d.this.b.getOnDanmakuClickListener()) == null) {
                return false;
            }
            if (onDanmakuClickListener.b(motionEvent.getX(), motionEvent.getY())) {
                return true;
            }
            return d.this.b.a(motionEvent.getX(), motionEvent.getY()) != null && onDanmakuClickListener.a(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            BaseDanmaku baseDanmakuA;
            b.a onDanmakuClickListener = d.this.b.getOnDanmakuClickListener();
            if (onDanmakuClickListener == null) {
                return;
            }
            if (onDanmakuClickListener.b(motionEvent.getX(), motionEvent.getY())) {
                d.this.a(true);
            } else if (onDanmakuClickListener.a(motionEvent.getX(), motionEvent.getY()) && (baseDanmakuA = d.this.b.a(motionEvent.getX(), motionEvent.getY())) != null) {
                d.this.a(baseDanmakuA, true);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            BaseDanmaku baseDanmakuA;
            b.a onDanmakuClickListener = d.this.b.getOnDanmakuClickListener();
            if (onDanmakuClickListener == null) {
                return false;
            }
            if (onDanmakuClickListener.b(motionEvent.getX(), motionEvent.getY())) {
                return d.this.a(false);
            }
            if (onDanmakuClickListener.a(motionEvent.getX(), motionEvent.getY()) && (baseDanmakuA = d.this.b.a(motionEvent.getX(), motionEvent.getY())) != null) {
                return d.this.a(baseDanmakuA, false);
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(com.zwb.danmaku.b bVar) {
        this.b = bVar;
        this.a = new GestureDetector(((View) bVar).getContext(), this.f20640c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(BaseDanmaku baseDanmaku, boolean z2) {
        b.a onDanmakuClickListener = this.b.getOnDanmakuClickListener();
        if (onDanmakuClickListener == null) {
            return false;
        }
        if (z2) {
            return onDanmakuClickListener.b(baseDanmaku);
        }
        return onDanmakuClickListener.a(baseDanmaku);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z2) {
        b.a onDanmakuClickListener = this.b.getOnDanmakuClickListener();
        if (onDanmakuClickListener == null) {
            return false;
        }
        if (!z2) {
            return onDanmakuClickListener.b(this.b);
        }
        return onDanmakuClickListener.a(this.b);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
