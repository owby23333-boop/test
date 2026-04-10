package com.amgcyo.cuttadon.activity.setting;

import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: compiled from: DebugInfoActivity.java */
/* JADX INFO: loaded from: classes.dex */
class e0 extends com.amgcyo.cuttadon.j.g.h.a<String, Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DebugInfoActivity f2865c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e0(DebugInfoActivity debugInfoActivity, String str) {
        super(str);
        this.f2865c = debugInfoActivity;
    }

    @Override // com.amgcyo.cuttadon.j.g.g.a
    public Void a(String str) throws Throwable {
        this.f2865c.o();
        if (TextUtils.isEmpty(this.f2865c.q())) {
            this.f2865c.p();
        }
        DebugInfoActivity debugInfoActivity = this.f2865c;
        debugInfoActivity.isPingSuccess(5, debugInfoActivity.f2805o0);
        return null;
    }

    @Override // com.amgcyo.cuttadon.j.g.g.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Void r2) {
        TextView textView = this.f2865c.tv_submit;
        if (textView != null) {
            textView.setEnabled(true);
            this.f2865c.tv_submit.setAlpha(1.0f);
            this.f2865c.tv_submit.setText("开始测试");
        }
    }
}
