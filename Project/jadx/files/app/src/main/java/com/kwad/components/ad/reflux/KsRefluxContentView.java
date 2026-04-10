package com.kwad.components.ad.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.core.d.b;

/* JADX INFO: loaded from: classes2.dex */
public class KsRefluxContentView extends FrameLayout implements GestureDetector.OnGestureListener {
    private GestureDetector nX;
    private a nY;

    public interface a {
        boolean ff();

        boolean fg();
    }

    public KsRefluxContentView(@NonNull Context context) {
        super(context);
        N(context);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        N(context);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        N(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        N(context);
    }

    private void N(@NonNull Context context) {
        this.nX = new GestureDetector(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.nY;
        if (aVar == null || aVar.ff()) {
            b.d("KsRefluxContentView", "dispatchTouchEvent consumed");
            return super.dispatchTouchEvent(motionEvent);
        }
        b.d("KsRefluxContentView", "dispatchTouchEvent mGestureDetector onTouchEvent");
        this.nX.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onDown");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        b.d("KsRefluxContentView", "onFling");
        a aVar = this.nY;
        if (aVar != null) {
            return aVar.fg();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onLongPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        b.d("KsRefluxContentView", "onScroll");
        a aVar = this.nY;
        if (aVar != null) {
            return aVar.fg();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onShowPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onSingleTapUp");
        a aVar = this.nY;
        if (aVar != null) {
            return aVar.fg();
        }
        return false;
    }

    public void setContentViewListener(a aVar) {
        this.nY = aVar;
    }
}
