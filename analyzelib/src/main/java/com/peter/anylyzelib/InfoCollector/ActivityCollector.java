package com.peter.anylyzelib.InfoCollector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class ActivityCollector implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activity.getWindow().setCallback(new Window.Callback() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                return false;
            }

            @Override
            public boolean dispatchKeyShortcutEvent(KeyEvent event) {
                return false;
            }

            @Override
            public boolean dispatchTouchEvent(MotionEvent event) {
                return false;
            }

            @Override
            public boolean dispatchTrackballEvent(MotionEvent event) {
                return false;
            }

            @Override
            public boolean dispatchGenericMotionEvent(MotionEvent event) {
                return false;
            }

            @Override
            public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
                return false;
            }

            @Override
            public View onCreatePanelView(int featureId) {
                return null;
            }

            @Override
            public boolean onCreatePanelMenu(int featureId, Menu menu) {
                return false;
            }

            @Override
            public boolean onPreparePanel(int featureId, View view, Menu menu) {
                return false;
            }

            @Override
            public boolean onMenuOpened(int featureId, Menu menu) {
                return false;
            }

            @Override
            public boolean onMenuItemSelected(int featureId, MenuItem item) {
                return false;
            }

            @Override
            public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {

            }

            @Override
            public void onContentChanged() {

            }

            @Override
            public void onWindowFocusChanged(boolean hasFocus) {

            }

            @Override
            public void onAttachedToWindow() {

            }

            @Override
            public void onDetachedFromWindow() {

            }

            @Override
            public void onPanelClosed(int featureId, Menu menu) {

            }

            @Override
            public boolean onSearchRequested() {
                return false;
            }

            @Override
            public boolean onSearchRequested(SearchEvent searchEvent) {
                return false;
            }

            @Override
            public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
                return null;
            }

            @Override
            public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
                return null;
            }

            @Override
            public void onActionModeStarted(ActionMode mode) {

            }

            @Override
            public void onActionModeFinished(ActionMode mode) {

            }
        });
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
