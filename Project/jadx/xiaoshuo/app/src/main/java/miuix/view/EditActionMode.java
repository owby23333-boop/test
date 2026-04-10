package miuix.view;

/* JADX INFO: loaded from: classes9.dex */
public interface EditActionMode {
    public static final int BUTTON1 = 16908313;
    public static final int BUTTON2 = 16908314;

    void addAnimationListener(ActionModeAnimationListener actionModeAnimationListener);

    void removeAnimationListener(ActionModeAnimationListener actionModeAnimationListener);

    void setButton(int i, int i2);

    void setButton(int i, int i2, int i3);

    void setButton(int i, CharSequence charSequence);

    void setButton(int i, CharSequence charSequence, int i2);

    void setButton(int i, CharSequence charSequence, CharSequence charSequence2, int i2);
}
