package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: ExitAddBookDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends Dialog {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static int f4820y = 160;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f4821z = 120;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4822s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4823t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4824u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f4825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Context f4826w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f4827x;

    /* JADX INFO: compiled from: ExitAddBookDialog.java */
    public interface a {
        void a();

        void b();
    }

    public v0(Context context, View view, int i2) {
        this(context, f4820y, f4821z, view, i2);
        this.f4826w = context;
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.f4827x;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    public /* synthetic */ void b(View view) {
        a aVar = this.f4827x;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void c(View view) {
        dismiss();
    }

    public v0(Context context, int i2, int i3, View view, int i4) {
        super(context, i4);
        setContentView(view);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            double dC = com.amgcyo.cuttadon.utils.otherutils.n.c(context);
            Double.isNaN(dC);
            attributes.width = (int) (dC * 0.8d);
            window.setAttributes(attributes);
        }
        TextView textView = (TextView) view.findViewById(R.id.btn_add_shelf);
        ((TextView) view.findViewById(R.id.tv_tips)).setText("来都来了，收藏一下呗😘");
        this.f4822s = (TextView) view.findViewById(R.id.tv_author);
        this.f4823t = (TextView) view.findViewById(R.id.tv_diandian);
        this.f4824u = (TextView) view.findViewById(R.id.tv_word_count);
        this.f4825v = (ImageView) view.findViewById(R.id.book_cover);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4721s.a(view2);
            }
        });
        ((TextView) view.findViewById(R.id.btn_exit)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4710s.b(view2);
            }
        });
        ((ImageView) view.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4714s.c(view2);
            }
        });
    }

    public void a(MkBook mkBook, me.jessyan.art.c.e.c cVar) {
        if (this.f4822s == null || mkBook == null) {
            return;
        }
        String author = mkBook.getAuthor();
        if (TextUtils.isEmpty(author)) {
            this.f4822s.setVisibility(8);
            this.f4823t.setVisibility(8);
        } else {
            this.f4822s.setVisibility(0);
            this.f4823t.setVisibility(0);
            this.f4822s.setText(String.format("%s", author));
        }
        if (3 == mkBook.getForm()) {
            this.f4824u.setText(String.format(Locale.getDefault(), "%s · %d话", mkBook.getStatus() == 1 ? "完结至" : "连载至", Integer.valueOf(mkBook.getChapter_count())));
        } else {
            this.f4824u.setText(String.format(Locale.getDefault(), "%s · %s", com.amgcyo.cuttadon.f.o.a(mkBook.getStatus()), mkBook.getStype()));
        }
        cVar.a(this.f4826w, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(this.f4825v).build());
    }

    public void a(a aVar) {
        this.f4827x = aVar;
    }
}
