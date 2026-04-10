package com.duokan.reader.ui.reading.menufree;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.duokan.core.app.AppWrapper;
import com.duokan.reader.ui.reading.ReadingTheme;
import com.yuewen.rt2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ReadingMenuThemeBase {

    public static class ResourceRecord extends HashMap<ReadingTheme, Integer> {
        private boolean mChangeMenuTheme = true;
        private final int mDefaultRes;

        public ResourceRecord(int i) {
            this.mDefaultRes = i;
        }

        public ReadingTheme changeMenuTheme(ReadingTheme readingTheme) {
            return !this.mChangeMenuTheme ? readingTheme : (readingTheme == ReadingTheme.NIGHT_1 || readingTheme == ReadingTheme.NIGHT_2) ? ReadingTheme.NIGHT : (readingTheme == ReadingTheme.FREE_THEME0_1 || readingTheme == ReadingTheme.FREE_THEME0_2) ? ReadingTheme.FREE_THEME0 : (readingTheme == ReadingTheme.FREE_THEME1_1 || readingTheme == ReadingTheme.FREE_THEME1_2) ? ReadingTheme.FREE_THEME1 : (readingTheme == ReadingTheme.FREE_THEME2_1 || readingTheme == ReadingTheme.FREE_THEME2_2) ? ReadingTheme.FREE_THEME2 : (readingTheme == ReadingTheme.FREE_THEME3_1 || readingTheme == ReadingTheme.FREE_THEME3_2) ? ReadingTheme.FREE_THEME3 : readingTheme;
        }

        public int getOrDefault(ReadingTheme readingTheme) {
            Integer num = get(changeMenuTheme(readingTheme));
            return num == null ? this.mDefaultRes : num.intValue();
        }

        public void noChangeMenuTheme() {
            this.mChangeMenuTheme = false;
        }
    }

    public static class ThemeBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ReadingTheme[][] f6179a = {new ReadingTheme[]{ReadingTheme.FREE_THEME0, ReadingTheme.FREE_THEME1, ReadingTheme.FREE_THEME2, ReadingTheme.FREE_THEME3}, new ReadingTheme[]{ReadingTheme.FREE_THEME0_1, ReadingTheme.FREE_THEME1_1, ReadingTheme.FREE_THEME2_1, ReadingTheme.FREE_THEME3_1}, new ReadingTheme[]{ReadingTheme.FREE_THEME0_2, ReadingTheme.FREE_THEME1_2, ReadingTheme.FREE_THEME2_2, ReadingTheme.FREE_THEME3_2}};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[][] f6180b = {new String[]{"白色", "蓝色", "黄色", "绿色"}, new String[]{"白色_质感", "蓝色_质感", "黄色_质感", "绿色_质感"}, new String[]{"白色_水墨", "蓝色_水墨", "黄色_水墨", "绿色_水墨"}};
        public static final List<ReadingTheme> c;

        public enum ReadingThemeMode {
            PURE_COLOR,
            VINE,
            SCENE
        }

        static {
            ArrayList arrayList = new ArrayList();
            c = arrayList;
            arrayList.add(ReadingTheme.NIGHT);
            arrayList.add(ReadingTheme.NIGHT_1);
            arrayList.add(ReadingTheme.NIGHT_2);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResourceRecord f6181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6182b;

        public a(int i) {
            this.f6182b = i;
            this.f6181a = new ResourceRecord(i);
        }

        public a a(ReadingTheme readingTheme, int i) {
            this.f6181a.put(readingTheme, Integer.valueOf(i));
            return this;
        }

        public void b(Map<Integer, ResourceRecord> map) {
            map.put(Integer.valueOf(this.f6182b), this.f6181a);
        }

        public a c() {
            this.f6181a.noChangeMenuTheme();
            return this;
        }
    }

    public static a e(int i) {
        return new a(i);
    }

    public static Toast f(Context context, Toast toast, boolean z) {
        View view = toast.getView();
        if (view != null) {
            int i = z ? rt2.h.p1 : rt2.h.o1;
            int i2 = z ? rt2.f.KP : rt2.f.Fq;
            view.setBackgroundResource(i);
            TextView textView = (TextView) view.findViewById(rt2.k.E3);
            if ((AppWrapper.v().getResources().getConfiguration().uiMode & 48) == 32) {
                if (textView != null) {
                    textView.setTextColor(context.getResources().getColor(rt2.f.zl));
                }
            } else if (textView != null) {
                textView.setTextColor(context.getResources().getColor(i2));
            }
        }
        return toast;
    }

    public List<ReadingTheme> a(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            ReadingTheme[][] readingThemeArr = ThemeBuilder.f6179a;
            if (i2 >= readingThemeArr.length) {
                return arrayList;
            }
            arrayList.add(readingThemeArr[i2][i]);
            i2++;
        }
    }

    public String[][] b() {
        return ThemeBuilder.f6180b;
    }

    public ReadingTheme[][] c() {
        return ThemeBuilder.f6179a;
    }

    public boolean d(ReadingTheme readingTheme, int i) {
        int i2 = 0;
        while (true) {
            ReadingTheme[][] readingThemeArr = ThemeBuilder.f6179a;
            if (i2 >= readingThemeArr.length) {
                return false;
            }
            if (readingThemeArr[i2][i] == readingTheme) {
                return true;
            }
            i2++;
        }
    }
}
