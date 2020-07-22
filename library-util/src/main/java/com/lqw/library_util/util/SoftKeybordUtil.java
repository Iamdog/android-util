package com.lqw.library_util.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.lqw.library_util.provider.AppContext;

public class SoftKeybordUtil {

    public static void closeSoftKeybord(EditText mEditText) {
        InputMethodManager imm = (InputMethodManager) AppContext.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    public static void showSoftKeybord(View view) {
        InputMethodManager imm = (InputMethodManager) AppContext.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

}
