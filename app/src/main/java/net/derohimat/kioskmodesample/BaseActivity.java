package net.derohimat.kioskmodesample;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by derohimat on 19/08/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected Context mContext = this;
    protected View mDecorView;
    protected DevicePolicyManager mDpm;

    protected void setUpAdmin() {
        if (!KioskModeApp.isInLockMode()) {
            ComponentName deviceAdmin = new ComponentName(this, AdminReceiver.class);
            mDpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
            if (!mDpm.isAdminActive(deviceAdmin)) {
                Log.e("Kiosk Mode Error", getString(R.string.not_device_admin));
            }

            if (mDpm.isDeviceOwnerApp(getPackageName())) {
                mDpm.setLockTaskPackages(deviceAdmin, new String[]{getPackageName()});
            } else {
                Log.e("Kiosk Mode Error", getString(R.string.not_device_owner));
            }

            enableKioskMode(true);
            //TODO : for clear device Owner
//        } else {
//            mDpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
//            mDpm.clearDeviceOwnerApp(getPackageName());
        }

        mDecorView = getWindow().getDecorView();
        hideSystemUI();
    }

    protected void enableKioskMode(boolean enabled) {
        try {
            if (enabled) {
                if (mDpm.isLockTaskPermitted(this.getPackageName())) {
                    KioskModeApp.setIsInLockMode(true);
                    startLockTask();
                } else {
                    KioskModeApp.setIsInLockMode(false);
                    Log.e("Kiosk Mode Error", getString(R.string.kiosk_not_permitted));
                }
            } else {
                KioskModeApp.setIsInLockMode(false);
                stopLockTask();
            }
        } catch (Exception e) {
            KioskModeApp.setIsInLockMode(false);
            // TODO: Log and handle appropriately
            Log.e("Kiosk Mode Error", e.getMessage());
        }
    }

    protected void hideSystemUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

}