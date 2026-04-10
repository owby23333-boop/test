package com.amgcyo.cuttadon.k.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkStatusView.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f4117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f4118v;

    public b(Context context, Runnable runnable) {
        super(context);
        a(context);
        this.f4117u = runnable;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_global_status, (ViewGroup) this, true);
        this.f4118v = (ImageView) findViewById(R.id.image);
        this.f4115s = (TextView) findViewById(R.id.text);
        this.f4116t = (TextView) findViewById(R.id.tv_reConnected);
        setBackgroundColor(-986896);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Runnable runnable = this.f4117u;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void setMsgViewVisibility(boolean z2) {
        this.f4115s.setVisibility(z2 ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setStatus(int r7) {
        /*
            r6 = this;
            r0 = 8
            r1 = 1
            r2 = 0
            r3 = 0
            r4 = 2131755522(0x7f100202, float:1.9141926E38)
            if (r7 == r1) goto L45
            r5 = 2
            if (r7 == r5) goto L42
            r5 = 3
            if (r7 == r5) goto L1c
            r5 = 4
            if (r7 == r5) goto L15
        L13:
            r7 = 0
            goto L49
        L15:
            r4 = 2131755232(0x7f1000e0, float:1.9141337E38)
            r7 = 2131231239(0x7f080207, float:1.8078553E38)
            goto L49
        L1c:
            r7 = 2131755326(0x7f10013e, float:1.9141528E38)
            android.content.Context r3 = r6.getContext()
            boolean r3 = me.jessyan.art.f.f.c(r3)
            if (r3 != 0) goto L35
            r7 = 2131755327(0x7f10013f, float:1.914153E38)
            android.widget.TextView r3 = r6.f4116t
            r3.setVisibility(r2)
            r4 = 2131755327(0x7f10013f, float:1.914153E38)
            goto L3d
        L35:
            android.widget.TextView r3 = r6.f4116t
            r3.setVisibility(r0)
            r4 = 2131755326(0x7f10013e, float:1.9141528E38)
        L3d:
            r7 = 2131231228(0x7f0801fc, float:1.8078531E38)
            r3 = r6
            goto L49
        L42:
            r7 = 0
            r1 = 0
            goto L49
        L45:
            r4 = 2131755328(0x7f100140, float:1.9141532E38)
            goto L13
        L49:
            if (r7 == 0) goto L50
            android.widget.ImageView r5 = r6.f4118v
            r5.setImageResource(r7)
        L50:
            r6.setOnClickListener(r3)
            android.widget.TextView r7 = r6.f4115s
            r7.setText(r4)
            if (r1 == 0) goto L5b
            r0 = 0
        L5b:
            r6.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.k.a.b.setStatus(int):void");
    }

    public b(Context context) {
        super(context);
        a(context);
    }
}
