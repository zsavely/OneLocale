package com.szagurskii.localizationshowcase;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * @author Savelii Zagurskii
 */
public class AndroidApp extends Application {
  private static final String TAG = AndroidApp.class.getSimpleName();

  @Override public void onCreate() {
    super.onCreate();
  }

  /**
   * This method doesn't always work. And if this method doesn't work,
   * the user stays in the default locale.
   */
  private void initLanguage() {
    try {
      Resources resources = getApplicationContext().getResources();
      DisplayMetrics displayMetrics = resources.getDisplayMetrics();
      Configuration configuration = resources.getConfiguration();
      Locale locale = new Locale("es", "ES");
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        configuration.setLocale(locale);
      } else {
        //noinspection deprecation
        configuration.locale = locale;
      }
      resources.updateConfiguration(configuration, displayMetrics);
    } catch (Throwable throwable) {
      Log.d(TAG, "Couldn't apply ES language.", throwable);
    }
  }
}
