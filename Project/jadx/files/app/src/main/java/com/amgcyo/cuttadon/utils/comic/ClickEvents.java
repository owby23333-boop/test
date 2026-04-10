package com.amgcyo.cuttadon.utils.comic;

/* JADX INFO: loaded from: classes.dex */
public class ClickEvents {

    public enum JoyLocks {
        LT,
        RT
    }

    public static int[] a(a aVar, int i2, boolean z2) {
        if (z2) {
            aVar.c("pref_reader_page_click_up", 1);
            aVar.c("pref_reader_page_click_down", 2);
        } else {
            aVar.c("pref_reader_page_click_up", 0);
            aVar.c("pref_reader_page_click_down", 0);
        }
        if (1 == i2) {
            aVar.c("pref_reader_page_click_left", 2);
            aVar.c("pref_reader_page_click_right", 1);
        } else if (i2 == 0) {
            aVar.c("pref_reader_page_click_left", 1);
            aVar.c("pref_reader_page_click_right", 2);
        }
        return new int[]{aVar.b("pref_reader_page_click_left", 1), aVar.b("pref_reader_page_click_top", 1), aVar.b("pref_reader_page_click_middle", 11), aVar.b("pref_reader_page_click_bottom", 2), aVar.b("pref_reader_page_click_right", 2), aVar.b("pref_reader_page_click_up", 1), aVar.b("pref_reader_page_click_down", 2), aVar.b("pref_reader_page_joy_lt", 1), aVar.b("pref_reader_page_joy_rt", 2), aVar.b("pref_reader_page_joy_left", 1), aVar.b("pref_reader_page_joy_right", 2), aVar.b("pref_reader_page_joy_up", 4), aVar.b("pref_reader_page_joy_b", 6), aVar.b("pref_reader_page_joy_a", 0), aVar.b("pref_reader_page_joy_x", 11), aVar.b("pref_reader_page_joy_y", 3)};
    }

    public static int[] b(a aVar) {
        return new int[]{aVar.b("pref_reader_stream_long_click_left", 0), aVar.b("pref_reader_stream_long_click_top", 0), aVar.b("pref_reader_stream_long_click_middle", 0), aVar.b("pref_reader_stream_long_click_bottom", 0), aVar.b("pref_reader_stream_long_click_right", 0), 0, 0};
    }

    public static int[] a(a aVar) {
        return new int[]{aVar.b("pref_reader_page_long_click_left", 0), aVar.b("pref_reader_page_long_click_top", 0), aVar.b("pref_reader_page_long_click_middle", 0), aVar.b("pref_reader_page_long_click_bottom", 0), aVar.b("pref_reader_page_long_click_right", 0)};
    }

    public static int[] a(a aVar, boolean z2) {
        if (!z2) {
            aVar.c("pref_reader_stream_click_up", 0);
            aVar.c("pref_reader_stream_click_down", 0);
        } else {
            aVar.c("pref_reader_stream_click_up", 1);
            aVar.c("pref_reader_stream_click_down", 2);
        }
        return new int[]{aVar.b("pref_reader_stream_click_left", 0), aVar.b("pref_reader_stream_click_top", 1), aVar.b("pref_reader_stream_click_middle", 11), aVar.b("pref_reader_stream_click_bottom", 2), aVar.b("pref_reader_stream_click_right", 0), aVar.b("pref_reader_stream_click_up", 1), aVar.b("pref_reader_stream_click_down", 2), aVar.b("pref_reader_stream_joy_lt", 1), aVar.b("pref_reader_stream_joy_rt", 2), aVar.b("pref_reader_stream_joy_left", 0), aVar.b("pref_reader_stream_joy_right", 0), aVar.b("pref_reader_stream_joy_up", 0), aVar.b("pref_reader_stream_joy_down", 0), aVar.b("pref_reader_stream_joy_b", 0), aVar.b("pref_reader_stream_joy_a", 0), aVar.b("pref_reader_stream_joy_x", 11), aVar.b("pref_reader_stream_joy_y", 3)};
    }
}
