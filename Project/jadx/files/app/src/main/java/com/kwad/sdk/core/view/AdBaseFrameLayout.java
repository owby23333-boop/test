package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.UiThread;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AdBaseFrameLayout extends FrameLayout implements e {
    private static final ab.a mTouchCoords = new ab.a();
    private List<View.OnTouchListener> anL;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.anL = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anL = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.anL = new ArrayList();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.anL.contains(onTouchListener)) {
            return;
        }
        this.anL.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            b.printStackTrace(th);
            com.kwad.sdk.service.b.gatherException(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.anL.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.anL.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            mTouchCoords.t(getWidth(), getHeight());
            mTouchCoords.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            mTouchCoords.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ab.a getTouchCoords() {
        return mTouchCoords;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }
}
