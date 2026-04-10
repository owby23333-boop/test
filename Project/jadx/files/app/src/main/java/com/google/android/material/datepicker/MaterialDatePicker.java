package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object J = "CONFIRM_BUTTON_TAG";
    static final Object K = "CANCEL_BUTTON_TAG";
    static final Object L = "TOGGLE_BUTTON_TAG";
    private MaterialCalendar<S> A;

    @StringRes
    private int B;
    private CharSequence C;
    private boolean D;
    private int E;
    private TextView F;
    private CheckableImageButton G;

    @Nullable
    private MaterialShapeDrawable H;
    private Button I;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final LinkedHashSet<f<? super S>> f15266s = new LinkedHashSet<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f15267t = new LinkedHashSet<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f15268u = new LinkedHashSet<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f15269v = new LinkedHashSet<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @StyleRes
    private int f15270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private DateSelector<S> f15271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private k<S> f15272y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private CalendarConstraints f15273z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f15266s.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(MaterialDatePicker.this.g());
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f15267t.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialDatePicker.this.I.setEnabled(MaterialDatePicker.this.f15271x.k());
            MaterialDatePicker.this.G.toggle();
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.a(materialDatePicker.G);
            MaterialDatePicker.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int iD = d(requireContext());
        this.A = MaterialCalendar.a(this.f15271x, iD, this.f15273z);
        this.f15272y = this.G.isChecked() ? g.a(this.f15271x, iD, this.f15273z) : this.A;
        i();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R$id.mtrl_calendar_frame, this.f15272y);
        fragmentTransactionBeginTransaction.commitNow();
        this.f15272y.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String strF = f();
        this.F.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), strF));
        this.F.setText(strF);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f15268u.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f15270w = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f15271x = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f15273z = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.B = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.C = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.E = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), d(requireContext()));
        Context context = dialog.getContext();
        this.D = f(context);
        int iA = com.google.android.material.i.b.a(context, R$attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        this.H = new MaterialShapeDrawable(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.H.a(context);
        this.H.a(ColorStateList.valueOf(iA));
        this.H.b(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.D ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.D) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(c(context), -2));
        } else {
            View viewFindViewById = viewInflate.findViewById(R$id.mtrl_calendar_main_pane);
            View viewFindViewById2 = viewInflate.findViewById(R$id.mtrl_calendar_frame);
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(c(context), -1));
            viewFindViewById2.setMinimumHeight(b(requireContext()));
        }
        this.F = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        ViewCompat.setAccessibilityLiveRegion(this.F, 1);
        this.G = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.C;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setText(this.B);
        }
        e(context);
        this.I = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (this.f15271x.k()) {
            this.I.setEnabled(true);
        } else {
            this.I.setEnabled(false);
        }
        this.I.setTag(J);
        this.I.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag(K);
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f15269v.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f15270w);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f15271x);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f15273z);
        if (this.A.i() != null) {
            bVar.a(this.A.i().f15282x);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.B);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.C);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.D) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.H);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.H, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.d.a(requireDialog(), rect));
        }
        h();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f15272y.f();
        super.onStop();
    }

    class c extends j<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.j
        public void a(S s2) {
            MaterialDatePicker.this.i();
            MaterialDatePicker.this.I.setEnabled(MaterialDatePicker.this.f15271x.k());
        }

        @Override // com.google.android.material.datepicker.j
        public void a() {
            MaterialDatePicker.this.I.setEnabled(false);
        }
    }

    private static int b(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height) + (h.f15323x * resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height)) + ((h.f15323x - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    private static int c(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i2 = Month.c().f15280v;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int d(Context context) {
        int i2 = this.f15270w;
        return i2 != 0 ? i2 : this.f15271x.a(context);
    }

    private void e(Context context) {
        this.G.setTag(L);
        this.G.setImageDrawable(a(context));
        this.G.setChecked(this.E != 0);
        ViewCompat.setAccessibilityDelegate(this.G, null);
        a(this.G);
        this.G.setOnClickListener(new d());
    }

    public String f() {
        return this.f15271x.b(getContext());
    }

    @Nullable
    public final S g() {
        return this.f15271x.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.G.isChecked()) {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.G.setContentDescription(string);
    }

    static boolean f(@NonNull Context context) {
        return a(context, R.attr.windowFullscreen);
    }

    static boolean g(@NonNull Context context) {
        return a(context, R$attr.nestedScrollable);
    }

    @NonNull
    private static Drawable a(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    static boolean a(@NonNull Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.i.b.a(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }
}
