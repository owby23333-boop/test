package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.w0;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class DanmuColorSelectedView extends LinearLayout implements View.OnClickListener {

    @BindView(R.id.iv_inside)
    protected ImageView iv_inside;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a f4459s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4460t;

    @BindView(R.id.tv_inside)
    protected TextView tv_inside;

    public interface a {
        void a(DanmuColorSelectedView danmuColorSelectedView, boolean z2);
    }

    public DanmuColorSelectedView(Context context) {
        super(context);
        this.f4460t = false;
        a();
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.DanmuColorSelectedView);
        if (typedArrayObtainStyledAttributes != null) {
            this.tv_inside.setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.danmu_white_color));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View viewInflate = layoutInflater.inflate(R.layout.mk_view_widget_danmu_color, (ViewGroup) null);
        ButterKnife.bind(this, viewInflate);
        addView(viewInflate, layoutParams);
    }

    private void c() {
        w0.a(this, this.tv_inside, this.iv_inside);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4460t) {
            return;
        }
        this.f4460t = true;
        o.a(this.iv_inside, this.f4460t);
        a aVar = this.f4459s;
        if (aVar != null) {
            aVar.a(this, this.f4460t);
        }
    }

    public void setListener(a aVar) {
        this.f4459s = aVar;
    }

    public void setSelect(boolean z2) {
        this.f4460t = z2;
        o.a(this.iv_inside, this.f4460t);
    }

    public DanmuColorSelectedView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4460t = false;
        a();
        a(attributeSet);
    }

    private void a() {
        b();
        c();
    }
}
