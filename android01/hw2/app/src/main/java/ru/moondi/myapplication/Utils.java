package ru.moondi.myapplication;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_WHITE = 1;
    public final static int THEME_DARK = 2;
    public final static int THEME_ANCIENT_RUS = 3;
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            case THEME_DEFAULT:
                activity.setTheme(R.style.Theme_MyApplicationLight);
                break;
            case THEME_WHITE:
                activity.setTheme(R.style.AppThemeLight);
                break;
            case THEME_DARK:
                activity.setTheme(R.style.AppThemeDark);
                break;
            case THEME_ANCIENT_RUS:
                activity.setTheme(R.style.AncientRus);

        }
    }
}
