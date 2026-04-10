package com.duokan.dkbookshelf.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.duokan.reader.ui.DkViewFlipper;

/* JADX INFO: loaded from: classes13.dex */
public class BookShelfViewFlipper extends DkViewFlipper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f3122a;

    public interface a {
        void a(int i);
    }

    public BookShelfViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        a aVar = this.f3122a;
        if (aVar != null) {
            aVar.a(getDisplayedChild());
        }
    }

    public void setOnShowChangeListener(a aVar) {
        this.f3122a = aVar;
    }

    @Override // android.widget.ViewAnimator
    public void showNext() {
        super.showNext();
        a();
    }
}
