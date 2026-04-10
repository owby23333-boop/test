package com.duokan.dkcategory.ui.secondary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.yuewen.gs2;

/* JADX INFO: loaded from: classes13.dex */
public class BookTagsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView[] f3332a;

    public BookTagsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.f3332a = new TextView[3];
        View.inflate(getContext(), gs2.n.K0, this);
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<java.lang.String> r7) {
        /*
            r6 = this;
            r0 = 8
            if (r7 == 0) goto L59
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto Lb
            goto L59
        Lb:
            int r1 = r7.size()
            android.widget.TextView[] r2 = r6.f3332a
            int r3 = r2.length
            r4 = 0
            if (r1 <= r3) goto L1a
            int r1 = r2.length
            java.util.List r7 = r7.subList(r4, r1)
        L1a:
            r1 = r4
        L1b:
            android.widget.TextView[] r2 = r6.f3332a
            int r3 = r2.length
            if (r1 >= r3) goto L40
            r2 = r2[r1]
            int r3 = r7.size()
            if (r1 >= r3) goto L39
            java.lang.Object r3 = r7.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L39
            r2.setText(r3)
            r3 = r4
            goto L3a
        L39:
            r3 = r0
        L3a:
            com.yuewen.le4.j(r2, r3)
            int r1 = r1 + 1
            goto L1b
        L40:
            int r7 = r2.length
            r1 = r4
        L42:
            if (r1 >= r7) goto L51
            r3 = r2[r1]
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L4e
            r7 = 1
            goto L52
        L4e:
            int r1 = r1 + 1
            goto L42
        L51:
            r7 = r4
        L52:
            if (r7 == 0) goto L55
            r0 = r4
        L55:
            com.yuewen.le4.j(r6, r0)
            return
        L59:
            com.yuewen.le4.j(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.dkcategory.ui.secondary.BookTagsView.a(java.util.List):void");
    }

    public final void b() {
        setOrientation(0);
        this.f3332a[0] = (TextView) findViewById(gs2.k.q1);
        this.f3332a[1] = (TextView) findViewById(gs2.k.r1);
        this.f3332a[2] = (TextView) findViewById(gs2.k.s1);
    }
}
