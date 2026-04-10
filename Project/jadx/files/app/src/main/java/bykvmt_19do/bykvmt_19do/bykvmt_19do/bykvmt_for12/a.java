package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: compiled from: TTOrientationSelectDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Dialog {
    RadioGroup a;
    TextView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    TextView f2116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f2118e;

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTOrientationSelectDialog.java */
    class C0068a implements RadioGroup.OnCheckedChangeListener {
        C0068a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R$id.radio_vertical) {
                a.this.f2117d = 1;
            } else if (i2 == R$id.radio_horizontal) {
                a.this.f2117d = 2;
            }
        }
    }

    /* JADX INFO: compiled from: TTOrientationSelectDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            d dVar = a.this.f2118e;
            if (dVar != null) {
                dVar.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: TTOrientationSelectDialog.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            a aVar = a.this;
            d dVar = aVar.f2118e;
            if (dVar != null) {
                dVar.a(aVar.f2117d);
            }
        }
    }

    /* JADX INFO: compiled from: TTOrientationSelectDialog.java */
    public interface d {
        void a(int i2);

        void onCancel();
    }

    public a(Context context, d dVar) {
        super(context);
        this.f2117d = 1;
        setContentView(R$layout.ttt_dialog_orientation_select);
        this.f2118e = dVar;
        this.a = (RadioGroup) findViewById(R$id.radio_group);
        this.b = (TextView) findViewById(R$id.cancel_btn);
        this.f2116c = (TextView) findViewById(R$id.confirm_btn);
        a();
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        setCanceledOnTouchOutside(false);
        this.a.setOnCheckedChangeListener(new C0068a());
        this.b.setOnClickListener(new b());
        this.f2116c.setOnClickListener(new c());
    }
}
