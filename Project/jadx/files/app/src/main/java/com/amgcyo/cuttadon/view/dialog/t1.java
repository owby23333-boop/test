package com.amgcyo.cuttadon.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.other.EngineInfoBean;
import com.amgcyo.cuttadon.widget.util.NoUnderlineSpan;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TtsEngineListDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class t1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4806s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f4807t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RecyclerView f4808u;

    /* JADX INFO: compiled from: TtsEngineListDialog.java */
    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            com.amgcyo.cuttadon.utils.otherutils.g.e((Activity) t1.this.f4806s);
        }
    }

    /* JADX INFO: compiled from: TtsEngineListDialog.java */
    class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(t1.this.f4806s);
        }
    }

    /* JADX INFO: compiled from: TtsEngineListDialog.java */
    public interface c {
        void a(EngineInfoBean engineInfoBean);
    }

    public t1(@NonNull Context context) {
        super(context);
        this.f4806s = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.ttsengine_dialog_list, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        double dC = com.amgcyo.cuttadon.utils.otherutils.n.c(this.f4806s);
        Double.isNaN(dC);
        attributes.width = (int) (dC * 0.85d);
        attributes.height = -2;
        window.setAttributes(attributes);
        a();
    }

    public void a(final List<EngineInfoBean> list) {
        com.amgcyo.cuttadon.adapter.other.u uVar = new com.amgcyo.cuttadon.adapter.other.u(list);
        uVar.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.view.dialog.o0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f4767s.a(list, baseQuickAdapter, view, i2);
            }
        });
        this.f4808u.setLayoutManager(new LinearLayoutManager(this.f4806s));
        this.f4808u.setAdapter(uVar);
    }

    public /* synthetic */ void a(List list, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        c cVar = this.f4807t;
        if (cVar != null) {
            cVar.a((EngineInfoBean) list.get(i2));
        }
        dismiss();
    }

    public void a(c cVar) {
        this.f4807t = cVar;
    }

    private void a() {
        this.f4808u = (RecyclerView) findViewById(android.R.id.list);
        TextView textView = (TextView) findViewById(R.id.tv_cate_name);
        TextView textView2 = (TextView) findViewById(R.id.tv_tip);
        textView.setText("请选择朗读引擎");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "温馨提示:\n1，如果选择引擎后朗读声音不对或列表中没有显示相关引擎，请").append((CharSequence) "###点击此处###").append((CharSequence) "重新设置TTS首选引擎或重新启动对应的引擎APP即可解决。\n").append((CharSequence) "2，如果遇到锁屏或者后台听书停止的问题，请点击").append((CharSequence) "【后台运行白名单权限设置】").append((CharSequence) "，根据指引步骤设置后重试！");
        spannableStringBuilder.setSpan(new a(), 35, 45, 33);
        spannableStringBuilder.setSpan(new NoUnderlineSpan(), 35, 45, 17);
        spannableStringBuilder.setSpan(new b(), 98, 111, 33);
        spannableStringBuilder.setSpan(new NoUnderlineSpan(), 98, 111, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary)), 35, 45, 33);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(spannableStringBuilder);
        Animation animationA = com.amgcyo.cuttadon.j.g.a.a(15, com.anythink.expressad.video.module.a.a.m.ag);
        textView2.setAnimation(animationA);
        textView2.startAnimation(animationA);
        Toast.makeText(this.f4806s, "如果遇到问题，请按照晃动提示的文字信息进行处理~", 1).show();
        this.f4808u.setItemAnimator(null);
    }
}
