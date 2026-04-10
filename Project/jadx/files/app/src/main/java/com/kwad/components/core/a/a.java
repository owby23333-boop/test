package com.kwad.components.core.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private TextView HL;

    @Nullable
    private ImageView HM;

    @Nullable
    private ImageView HN;

    @Nullable
    private InterfaceC0385a HO;
    private ViewGroup sN;

    /* JADX INFO: renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0385a {
        void u(View view);

        void v(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.sN = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        if (this.sN == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.HL = (TextView) this.sN.findViewById(R.id.ksad_kwad_titlebar_title);
        this.HM = (ImageView) this.sN.findViewById(R.id.ksad_kwad_web_navi_back);
        this.HN = (ImageView) this.sN.findViewById(R.id.ksad_kwad_web_navi_close);
        this.HN.setOnClickListener(this);
        this.HM.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0385a interfaceC0385a) {
        this.HO = interfaceC0385a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sN == null || (textView = this.HL) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    @MainThread
    public final void aj(boolean z2) {
        ImageView imageView = this.HN;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    public final ViewGroup hc() {
        return this.sN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.HO == null) {
            return;
        }
        if (view.equals(this.HN)) {
            this.HO.v(view);
        } else if (view.equals(this.HM)) {
            this.HO.u(view);
        }
    }
}
