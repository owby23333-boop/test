package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.gc;

/* JADX INFO: loaded from: classes2.dex */
public class g extends AlertDialog implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f971a;
    private Context dl;
    private final String e;
    private long fo;
    protected final l g;
    private TextView gc;
    private final z gz;
    private TextView m;
    private boolean uy;
    public com.bytedance.sdk.openadsdk.core.g.g z;

    public interface z {
        void g(Dialog dialog);

        void z(Dialog dialog);
    }

    public g(Context context, na naVar, z zVar) {
        super(context);
        this.g = new l(Looper.getMainLooper(), this);
        this.uy = false;
        this.dl = context;
        if (context == null) {
            this.dl = zw.getContext();
        }
        this.e = ec.m(naVar);
        this.gz = zVar;
        if (ec.gc(naVar) == 3) {
            this.uy = true;
            this.fo = 5L;
        } else {
            this.fo = ec.gz(naVar);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(gc.ti(this.dl));
        setCanceledOnTouchOutside(false);
        z();
        this.g.sendEmptyMessageDelayed(101, 1000L);
    }

    private void z() {
        this.f971a = (TextView) findViewById(2114387826);
        this.gc = (TextView) findViewById(2114387638);
        this.m = (TextView) findViewById(2114387833);
        if (this.gz == null) {
            return;
        }
        oq.z((View) this.gc, (View.OnClickListener) this.z, "goLiveListener");
        oq.z(this.m, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gz.z(g.this);
            }
        }, "cancelTv");
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.z = gVar;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        oq.z(this.f971a, this.e);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.g.removeMessages(101);
            this.g.sendEmptyMessageDelayed(101, 1000L);
        } else {
            this.g.removeMessages(101);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        z zVar;
        if (message.what == 101) {
            long j = this.fo - 1;
            this.fo = j;
            if (j <= 0) {
                if (this.uy && (zVar = this.gz) != null) {
                    zVar.g(this);
                }
                z zVar2 = this.gz;
                if (zVar2 != null) {
                    zVar2.z(this);
                    return;
                }
                return;
            }
            if (this.uy) {
                oq.z(this.m, tb.z(this.dl, "tt_reward_live_dialog_cancel_text"));
            } else {
                oq.z(this.m, String.format(tb.z(this.dl, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j)));
            }
            this.g.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
