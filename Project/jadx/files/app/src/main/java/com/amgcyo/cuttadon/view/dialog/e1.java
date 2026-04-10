package com.amgcyo.cuttadon.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.other.EngineInfoBean;
import com.amgcyo.cuttadon.view.dialog.t1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: NoTtsEngineDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class e1 extends AlertDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f4697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f4698t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private t1.c f4699u;

    public e1(Context context) {
        super(context, R.style.style_permission_dialog);
        this.f4698t = context;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    private void a() {
        this.f4697s = (RecyclerView) findViewById(android.R.id.list);
        ((TextView) findViewById(R.id.tv_content)).setText("当前设备未找到TTS语音合成引擎，请在下方列表中选择你喜欢的引擎进行操作，如果操作过程中遇到问题，请反馈给客服。");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.no_tts_dialog);
        Window window = getWindow();
        if (window != null) {
            Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            double width = defaultDisplay.getWidth();
            Double.isNaN(width);
            attributes.width = (int) (width * 0.8d);
            window.setAttributes(attributes);
        }
        a();
    }

    public void a(final List<EngineInfoBean> list) {
        com.amgcyo.cuttadon.adapter.other.u uVar = new com.amgcyo.cuttadon.adapter.other.u(list);
        uVar.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.view.dialog.t
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f4802s.a(list, baseQuickAdapter, view, i2);
            }
        });
        this.f4697s.setLayoutManager(new LinearLayoutManager(this.f4698t));
        this.f4697s.setAdapter(uVar);
    }

    public /* synthetic */ void a(List list, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        t1.c cVar = this.f4699u;
        if (cVar != null) {
            cVar.a((EngineInfoBean) list.get(i2));
        }
        dismiss();
    }

    public void a(t1.c cVar) {
        this.f4699u = cVar;
    }
}
