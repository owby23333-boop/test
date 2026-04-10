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
import com.amgcyo.cuttadon.api.entity.other.FattenChapterNum;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import me.jessyan.art.base.d;

/* JADX INFO: compiled from: FattenChapterNumDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class w0 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4832s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4833t;

    /* JADX INFO: compiled from: FattenChapterNumDialog.java */
    public interface a {
        void a(FattenChapterNum fattenChapterNum);
    }

    public w0(@NonNull Context context) {
        super(context);
        this.f4832s = context;
    }

    private void a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        ((TextView) findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4741s.a(view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4832s);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        final int iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("fatten_chapter_num", 50);
        arrayList.add(new FattenChapterNum(this.f4832s.getResources().getString(R.string.fatten_10), 10));
        arrayList.add(new FattenChapterNum(this.f4832s.getResources().getString(R.string.fatten_20), 20));
        arrayList.add(new FattenChapterNum(this.f4832s.getResources().getString(R.string.fatten_50), 50));
        arrayList.add(new FattenChapterNum(this.f4832s.getResources().getString(R.string.fatten_100), 100));
        arrayList.add(new FattenChapterNum(this.f4832s.getResources().getString(R.string.fatten_200), 200));
        final com.amgcyo.cuttadon.adapter.other.h hVar = new com.amgcyo.cuttadon.adapter.other.h(arrayList, iA);
        recyclerView.setAdapter(hVar);
        hVar.a(new d.a() { // from class: com.amgcyo.cuttadon.view.dialog.k
            @Override // me.jessyan.art.base.d.a
            public final void a(View view, int i2, Object obj, int i3) {
                this.a.a(hVar, iA, view, i2, obj, i3);
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

    public /* synthetic */ void a(com.amgcyo.cuttadon.adapter.other.h hVar, int i2, View view, int i3, Object obj, int i4) {
        FattenChapterNum item;
        if (this.f4833t == null || (item = hVar.getItem(i4)) == null) {
            return;
        }
        if (item.getChapterNum() == i2) {
            String str = "没有变化" + item.getChapterNum() + "==" + item.getChapterTitle();
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("fatten_chapter_num", item.getChapterNum());
            this.f4833t.a(item);
            String str2 = item.getChapterNum() + "==" + item.getChapterTitle();
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f4833t = aVar;
    }
}
