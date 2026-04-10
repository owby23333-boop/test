package com.amgcyo.cuttadon.view.comic;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: ReloadCurrentChapterDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends Dialog {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f4550v = 160;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f4551w = 120;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f4552s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f4553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private a f4554u;

    /* JADX INFO: compiled from: ReloadCurrentChapterDialog.java */
    public interface a {
        void a();
    }

    public k(Context context, View view, int i2) {
        this(context, f4550v, f4551w, view, i2);
        this.f4553t = context;
    }

    public /* synthetic */ void a(View view) {
        a aVar = this.f4554u;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public /* synthetic */ void c(View view) {
        dismiss();
    }

    private k(Context context, int i2, int i3, View view, int i4) {
        super(context, i4);
        setContentView(view);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            double dC = n.c(context);
            Double.isNaN(dC);
            attributes.width = (int) (dC * 0.8d);
            window.setAttributes(attributes);
        }
        TextView textView = (TextView) view.findViewById(R.id.btn_reload);
        this.f4552s = (ImageView) view.findViewById(R.id.book_cover);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.comic.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4545s.a(view2);
            }
        });
        ((TextView) view.findViewById(R.id.btn_jxyd)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.comic.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4544s.b(view2);
            }
        });
        ((ImageView) view.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.comic.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4546s.c(view2);
            }
        });
    }

    public void a(MkBook mkBook, me.jessyan.art.c.e.c cVar) {
        cVar.a(this.f4553t, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(this.f4552s).build());
    }

    public void a(a aVar) {
        this.f4554u = aVar;
    }
}
