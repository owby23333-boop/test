package me.jessyan.art.f;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CharacterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: compiled from: CharacterHandler.java */
    class a implements InputFilter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Pattern f21182s = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

        a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            if (this.f21182s.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    }

    static {
        new a();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "Empty/Null json content";
        }
        try {
            str = str.trim();
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException unused) {
        }
        return str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "Empty/Null xml content";
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">\n");
        } catch (TransformerException unused) {
            return str;
        }
    }
}
