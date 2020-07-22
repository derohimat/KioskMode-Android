package net.derohimat.kioskmodesample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by derohimat on 19/08/2016.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        setUpAdmin();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) {
            finish();
        }
    }

    public static void startThisActivity(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }
}
