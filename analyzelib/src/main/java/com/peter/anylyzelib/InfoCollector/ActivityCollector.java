package com.peter.anylyzelib.InfoCollector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import java.util.Stack;

/**
 * 收集界面信息。存储activity调用栈。
 */
public class ActivityCollector implements Application.ActivityLifecycleCallbacks {

    private static ActivityCollector instance;
    private Application application;
    private Stack<Activity> activityStack = new Stack<>();

    private ActivityCollector(Application application) {
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public static void init(Application application){
        if (instance == null){
            instance = new ActivityCollector(application);
        }
    }

    public static ActivityCollector getInstance(){
        return instance;
    }

    public String getCurrentActivityName(){
        Activity activity = activityStack.peek();
        if (activity != null) {
            return activity.getLocalClassName();
        }else {
            return "null";
        }
    }

    @Override
    public void onActivityCreated(final Activity activity, Bundle savedInstanceState) {
        activityStack.push(activity);
//1        final Window.Callback callback = activity.getWindow().getCallback();
//
//        activity.getWindow().setCallback(new Window.Callback() {
//            @Override
//            public boolean dispatchKeyEvent(KeyEvent event) {
//                return callback.dispatchKeyEvent(event);
//            }
//
//            @Override
//            public boolean dispatchKeyShortcutEvent(KeyEvent event) {
//
//                return callback.dispatchKeyShortcutEvent(event);
//            }
//
//            @Override
//            public boolean dispatchTouchEvent(MotionEvent event) {
////                activity.getWindow().getCurrentFocus()
////                ViewGroup group = (ViewGroup) activity.getWindow().getDecorView().getRootView();
////                View view = ViewIdentifier.getViewByCoordinate((int) event.getRawX(), (int)event.getRawY(), group);
////                if(view != null){
////                    Log.d("peterTest", "View id is " + ViewIdentifier.getViewId(view));
////                }
//                return callback.dispatchTouchEvent(event);
//            }
//
//            @Override
//            public boolean dispatchTrackballEvent(MotionEvent event) {
//                return callback.dispatchTrackballEvent(event);
//            }
//
//            @Override
//            public boolean dispatchGenericMotionEvent(MotionEvent event) {
//                return callback.dispatchGenericMotionEvent(event);
//            }
//
//            @Override
//            public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
//                return callback.dispatchPopulateAccessibilityEvent(event);
//            }
//
//            @Override
//            public View onCreatePanelView(int featureId) {
//                return callback.onCreatePanelView(featureId);
//            }
//
//            @Override
//            public boolean onCreatePanelMenu(int featureId, Menu menu) {
//                return callback.onCreatePanelMenu(featureId, menu);
//            }
//
//            @Override
//            public boolean onPreparePanel(int featureId, View view, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onMenuOpened(int featureId, Menu menu) {
//                return onMenuOpened(featureId, menu);
//            }
//
//            @Override
//            public boolean onMenuItemSelected(int featureId, MenuItem item) {
//                return onMenuItemSelected(featureId, item);
//            }
//
//            @Override
//            public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
//
//            }
//
//            @Override
//            public void onContentChanged() {
//
//            }
//
//            @Override
//            public void onWindowFocusChanged(boolean hasFocus) {
//
//            }
//
//            @Override
//            public void onAttachedToWindow() {
//
//            }
//
//            @Override
//            public void onDetachedFromWindow() {
//
//            }
//
//            @Override
//            public void onPanelClosed(int featureId, Menu menu) {
//
//            }
//
//            @Override
//            public boolean onSearchRequested() {
//                return callback.onSearchRequested();
//            }
//
//            @Override
//            public boolean onSearchRequested(SearchEvent searchEvent) {
//                return callback.onSearchRequested(searchEvent);
//            }
//
//            @Override
//            public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
//                return null;
//            }
//
//            @Override
//            public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
//                return null;
//            }
//
//            @Override
//            public void onActionModeStarted(ActionMode mode) {
//
//            }
//
//            @Override
//            public void onActionModeFinished(ActionMode mode) {
//
//            }
//        });
        Log.d("peterTest", "activityName : " + activity.getLocalClassName());
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
        activityStack.pop();
        Log.d("peterTest", "activityName : " + activity.getLocalClassName());
    }
}
