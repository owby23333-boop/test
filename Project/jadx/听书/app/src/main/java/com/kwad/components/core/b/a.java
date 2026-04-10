package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {
    private TextView Nm;
    private ImageView Nn;
    private ImageView No;
    private InterfaceC0322a Np;
    private ViewGroup vV;

    /* JADX INFO: renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0322a {
        void x(View view);

        void y(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.vV = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.Nm = (TextView) this.vV.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Nn = (ImageView) this.vV.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.vV.findViewById(R.id.ksad_kwad_web_navi_close);
        this.No = imageView;
        imageView.setOnClickListener(this);
        this.Nn.setOnClickListener(this);
    }

    public final void a(InterfaceC0322a interfaceC0322a) {
        this.Np = interfaceC0322a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.vV == null || (textView = this.Nm) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    public final void aj(boolean z) {
        ImageView imageView = this.No;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final ViewGroup hP() {
        return this.vV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Np == null) {
            return;
        }
        if (view.equals(this.No)) {
            this.Np.y(view);
        } else if (view.equals(this.Nn)) {
            this.Np.x(view);
        }
    }
}
