package com.skanderjabouzi.displaysoftkeys;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSoftKeys();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (ViewConfiguration.get(this).hasPermanentMenuKey() == true) {
            Log.e("MainActivity","IT HAS A SOFTKEYS");
        } else {
            Log.e("MainActivity","IT DOESN'T HAS A SOFTKEYS");
        }

        boolean hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

        if(!hasMenuKey && !hasBackKey) {
            Log.e("MainActivity","IT DOESN'T HAS A SOFTKEYS # 2");
        } else  {
            Log.e("MainActivity","IT HAS A SOFTKEYS # 2");
        }

        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void getSoftKeys() {

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display d = windowManager.getDefaultDisplay();

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        d.getRealMetrics(realDisplayMetrics);

        int realHeight = realDisplayMetrics.heightPixels;
        int realWidth = realDisplayMetrics.widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getMetrics(displayMetrics);

        int displayHeight = displayMetrics.heightPixels;
        int displayWidth = displayMetrics.widthPixels;

        int navigationBarHeight = realHeight - displayHeight;

        int navigationBarWidth = realWidth - displayWidth;

        Log.e("MainActivity","navigationBarHeight = "+navigationBarHeight+" and navigationBarWidth = "+navigationBarWidth);
        Log.e("MainActivity","realHeight = "+realHeight+" and realWidth = "+realWidth);
        Log.e("MainActivity","displayHeight = "+displayHeight+" and displayWidth = "+displayWidth);


//        return (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
    }
}
