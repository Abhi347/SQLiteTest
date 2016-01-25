package in.noobgames.sqlitetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    InputFragment mInputFragment = new InputFragment();
    DisplayFragment mDisplayFragment = new DisplayFragment();
    DBHelper mDBHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frag_container, mInputFragment)
                .commit();
    }

    public DBHelper getDBHelper() {
        return mDBHelper;
    }

    public void showDisplayFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, mDisplayFragment)
                .addToBackStack(null)
                .commit();
    }

    public void onInputSubmitClick(View view) {
        mInputFragment.onInputSubmitClick();
        showDisplayFragment();
    }
}
