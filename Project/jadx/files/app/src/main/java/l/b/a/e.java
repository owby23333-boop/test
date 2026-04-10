package l.b.a;

import android.R;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: compiled from: NormalToast.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends Toast {
    private TextView a;

    public e(Application application) {
        super(application);
    }

    void a(TextView textView) {
        this.a = textView;
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        super.setView(view);
        a(a(view));
    }

    static TextView a(View view) {
        TextView textViewA;
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (view.findViewById(R.id.message) instanceof TextView) {
            return (TextView) view.findViewById(R.id.message);
        }
        if (!(view instanceof ViewGroup) || (textViewA = a((ViewGroup) view)) == null) {
            throw new IllegalArgumentException("The layout must contain a TextView");
        }
        return textViewA;
    }

    private static TextView a(ViewGroup viewGroup) {
        TextView textViewA;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (textViewA = a((ViewGroup) childAt)) != null) {
                return textViewA;
            }
        }
        return null;
    }
}
