package net.derohimat.kioskmodesample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by derohimat on 19/08/2016.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnState, mBtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnState = (Button) findViewById(R.id.btnState);
        mBtnMove = (Button) findViewById(R.id.btnMove);

        mBtnState.setOnClickListener(this);
        mBtnMove.setOnClickListener(this);

        setUpAdmin();
        updateButtonState();
    }

    private void updateButtonState() {
        if (KioskModeApp.isInLockMode()) {
            mBtnState.setText("Disable Kiosk Mode");
        } else {
            mBtnState.setText("Enable Kiosk Mode");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnState) {
            enableKioskMode(!KioskModeApp.isInLockMode());
            updateButtonState();
        } else if (view.getId() == R.id.btnMove) {
            SecondActivity.startThisActivity(mContext);
        }
    }
}
