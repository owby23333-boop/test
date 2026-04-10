package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.reader.TtsEngineBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: NovelLockTimeDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class g1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4709t;

    /* JADX INFO: compiled from: NovelLockTimeDialog.java */
    public interface a {
        void a(TtsEngineBean ttsEngineBean);
    }

    public g1(@NonNull Context context) {
        super(context);
        this.f4708s = context;
    }

    private void a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        ((TextView) findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4834s.a(view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4708s);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        final int iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("read_lock_screen_time_index", 3);
        arrayList.add(new TtsEngineBean(this.f4708s.getResources().getString(R.string.reader_lock_time_5), 0));
        arrayList.add(new TtsEngineBean(this.f4708s.getResources().getString(R.string.reader_lock_time_15), 1));
        arrayList.add(new TtsEngineBean(this.f4708s.getResources().getString(R.string.reader_lock_time_30), 2));
        arrayList.add(new TtsEngineBean(this.f4708s.getResources().getString(R.string.reader_lock_time_xt), 3));
        final com.amgcyo.cuttadon.adapter.other.q qVar = new com.amgcyo.cuttadon.adapter.other.q(arrayList);
        qVar.e(iA);
        recyclerView.setAdapter(qVar);
        qVar.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.view.dialog.y
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f4835s.a(qVar, iA, baseQuickAdapter, view, i2);
            }
        });
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.bottom_shelfsort_dialog, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_animation);
        a();
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public /* synthetic */ void a(com.amgcyo.cuttadon.adapter.other.q qVar, int i2, BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        TtsEngineBean item;
        if (this.f4709t == null || (item = qVar.getItem(i3)) == null) {
            return;
        }
        if (item.getTts_type() == i2) {
            String str = "没有变化" + item.getTts_type() + "==" + item.getTitle();
        } else {
            this.f4709t.a(item);
            String str2 = item.getTts_type() + "==" + item.getTitle();
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("read_lock_screen_time_index", item.getTts_type());
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f4709t = aVar;
    }
}
