package com.amgcyo.cuttadon.view.otherview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: ShelfEditDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f5125s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f5126t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View f5127u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MkBook f5128v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private me.jessyan.art.c.e.c f5129w;

    /* JADX INFO: compiled from: ShelfEditDialog.java */
    public static final class b {
        private Context a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private View f5130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5131d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private MkBook f5132e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private me.jessyan.art.c.e.c f5133f;

        public b(Context context) {
            this.a = context;
        }

        public b a(int i2) {
            this.f5130c = LayoutInflater.from(this.a).inflate(i2, (ViewGroup) null);
            return this;
        }

        public MkBook b() {
            return this.f5132e;
        }

        public b a(MkBook mkBook, me.jessyan.art.c.e.c cVar) {
            this.f5132e = mkBook;
            this.f5133f = cVar;
            return this;
        }

        public b a(boolean z2) {
            this.b = z2;
            return this;
        }

        public b a(int i2, View.OnClickListener onClickListener) {
            if (this.f5132e != null) {
                this.f5130c.findViewById(i2).setOnClickListener(onClickListener);
            }
            return this;
        }

        public b a(int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            if (this.f5132e != null) {
                ((Switch) this.f5130c.findViewById(i2)).setOnCheckedChangeListener(onCheckedChangeListener);
            }
            return this;
        }

        public m a() {
            int i2 = this.f5131d;
            if (i2 != -1) {
                return new m(this, i2);
            }
            return new m(this);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(this.f5127u);
        setCanceledOnTouchOutside(this.f5126t);
        Window window = getWindow();
        if (window == null || this.f5128v == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        getWindow().setBackgroundDrawable(gradientDrawable);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_animation);
        ((CustomTextView) this.f5127u.findViewById(R.id.bookNameTxt)).setText(this.f5128v.getName());
        TextView textView = (TextView) this.f5127u.findViewById(R.id.tvAuthorName);
        String author = this.f5128v.getAuthor();
        if (TextUtils.isEmpty(author)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(author);
        }
        TextView textView2 = (TextView) this.f5127u.findViewById(R.id.tv_comment_title);
        ImageView imageView = (ImageView) this.f5127u.findViewById(R.id.icon_mulu);
        if (com.amgcyo.cuttadon.utils.otherutils.h.L0()) {
            imageView.setImageResource(R.drawable.shelf_comment);
            textView2.setText(com.amgcyo.cuttadon.f.o.d(R.string.look_comment));
        } else {
            imageView.setImageResource(R.drawable.feedback_books);
            textView2.setText(com.amgcyo.cuttadon.f.o.d(R.string.feedback_book));
        }
        TextView textView3 = (TextView) this.f5127u.findViewById(R.id.tv_scsj);
        if (3 == this.f5128v.getForm()) {
            textView3.setText(com.amgcyo.cuttadon.f.o.d(R.string.delete_comic));
        } else {
            textView3.setText(com.amgcyo.cuttadon.f.o.d(R.string.delete));
        }
        ((Switch) this.f5127u.findViewById(R.id.switch_book_top)).setChecked(this.f5128v.getIs_top() == 1);
        ((TextView) this.f5127u.findViewById(R.id.tv_book_top)).setText("置  顶");
        TextView textView4 = (TextView) this.f5127u.findViewById(R.id.tv_batch_book);
        if (this.f5128v.getForm() == 1) {
            textView4.setText("批量管理小说书籍");
        } else {
            textView4.setText("批量管理漫画书籍");
        }
        Switch r02 = (Switch) this.f5127u.findViewById(R.id.switch_book_jpush);
        if (g0.a().a("swtich_jpush", true)) {
            r02.setChecked(this.f5128v.getJpush_status() == 1);
        } else {
            r02.setChecked(false);
        }
        ((CustomTextView) this.f5127u.findViewById(R.id.tv_lastchapter)).setText(String.format("最新：%s", this.f5128v.getLast_chapter_name()));
        ImageView imageView2 = (ImageView) this.f5127u.findViewById(R.id.book_cover);
        int form = this.f5128v.getForm();
        this.f5129w.a(this.f5125s, ImageConfigImpl.builder().imageRadius(8).form(form).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), this.f5128v.getImage())).imageView(imageView2).build());
    }

    private m(b bVar) {
        super(bVar.a);
        this.f5125s = bVar.a;
        this.f5126t = bVar.b;
        this.f5127u = bVar.f5130c;
        this.f5128v = bVar.f5132e;
        this.f5129w = bVar.f5133f;
    }

    private m(b bVar, int i2) {
        super(bVar.a, i2);
        this.f5125s = bVar.a;
        this.f5126t = bVar.b;
        this.f5127u = bVar.f5130c;
    }
}
