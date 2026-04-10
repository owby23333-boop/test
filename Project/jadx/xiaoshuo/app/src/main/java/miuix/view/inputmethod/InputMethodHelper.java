package miuix.view.inputmethod;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import miuix.core.util.SoftReferenceSingleton;

/* JADX INFO: loaded from: classes9.dex */
public class InputMethodHelper {
    private static final SoftReferenceSingleton<InputMethodHelper> INSTANCE = new SoftReferenceSingleton<InputMethodHelper>() { // from class: miuix.view.inputmethod.InputMethodHelper.1
        @Override // miuix.core.util.SoftReferenceSingleton
        public InputMethodHelper createInstance(Object obj) {
            return new InputMethodHelper((Context) obj);
        }
    };
    private InputMethodManager mManager;

    public static InputMethodHelper getInstance(Context context) {
        return INSTANCE.get(context);
    }

    public InputMethodManager getManager() {
        return this.mManager;
    }

    public void hideKeyBoard(EditText editText) {
        this.mManager.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }

    public void showKeyBoard(EditText editText) {
        editText.requestFocus();
        this.mManager.viewClicked(editText);
        this.mManager.showSoftInput(editText, 0);
    }

    private InputMethodHelper(Context context) {
        this.mManager = (InputMethodManager) context.getApplicationContext().getSystemService("input_method");
    }
}
