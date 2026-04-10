package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: compiled from: TTRenderSelectDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Dialog {
    RadioGroup a;
    TextView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    TextView f2119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    RadioButton f2120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    RadioButton f2121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    d f2123g;

    /* JADX INFO: compiled from: TTRenderSelectDialog.java */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R$id.radio_native) {
                b.this.f2122f = 2;
            } else if (i2 == R$id.radio_express1) {
                b.this.f2122f = 1;
            } else if (i2 == R$id.radio_express2) {
                b.this.f2122f = 3;
            }
        }
    }

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTRenderSelectDialog.java */
    class ViewOnClickListenerC0069b implements View.OnClickListener {
        ViewOnClickListenerC0069b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            d dVar = b.this.f2123g;
            if (dVar != null) {
                dVar.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: TTRenderSelectDialog.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b bVar = b.this;
            d dVar = bVar.f2123g;
            if (dVar != null) {
                dVar.a(bVar.f2122f);
            }
        }
    }

    /* JADX INFO: compiled from: TTRenderSelectDialog.java */
    public interface d {
        void a(int i2);

        void onCancel();
    }

    public b(Context context, int i2, d dVar) {
        super(context);
        this.f2122f = 2;
        setContentView(R$layout.ttt_dialog_render_select);
        this.f2123g = dVar;
        this.a = (RadioGroup) findViewById(R$id.radio_group);
        this.b = (TextView) findViewById(R$id.cancel_btn);
        this.f2119c = (TextView) findViewById(R$id.confirm_btn);
        this.f2120d = (RadioButton) findViewById(R$id.radio_express1);
        this.f2121e = (RadioButton) findViewById(R$id.radio_express2);
        if (i2 == 7) {
            this.f2120d.setText("模版（模版2.0）");
            this.f2121e.setVisibility(8);
        } else {
            this.f2120d.setText("模板（含广点通1.0）");
            this.f2121e.setVisibility(0);
        }
        a();
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        setCanceledOnTouchOutside(false);
        this.a.setOnCheckedChangeListener(new a());
        this.b.setOnClickListener(new ViewOnClickListenerC0069b());
        this.f2119c.setOnClickListener(new c());
    }
}
