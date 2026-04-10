package u0.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JChineseConvertor.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f21718c;
    private Map<Character, Character> a;
    private Map<Character, Character> b;

    private a() throws IOException {
        List<Character> listB = b();
        this.a = new HashMap();
        this.b = new HashMap();
        for (int i2 = 0; i2 < listB.size(); i2 += 2) {
            int i3 = i2 + 1;
            this.a.put(listB.get(i2), listB.get(i3));
            this.b.put(listB.get(i3), listB.get(i2));
        }
    }

    public static a a() throws IOException {
        if (f21718c == null) {
            f21718c = new a();
        }
        return f21718c;
    }

    private List<Character> b() throws IOException {
        List<Character> listA = a("/cfg/ts.tab", "UTF-8");
        if (listA.size() % 2 == 0) {
            return listA;
        }
        throw new RuntimeException("The conversion table may be damaged or not exists");
    }

    public String a(String str) {
        char[] cArr = new char[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            cArr[i2] = a(str.charAt(i2)).charValue();
        }
        return new String(cArr);
    }

    public Character a(char c2) {
        return this.b.get(Character.valueOf(c2)) == null ? Character.valueOf(c2) : this.b.get(Character.valueOf(c2));
    }

    private List<Character> a(String str, String str2) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a.class.getResourceAsStream(str), str2));
        while (true) {
            int i2 = bufferedReader.read();
            if (i2 == -1) {
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(Character.valueOf((char) i2));
        }
    }
}
