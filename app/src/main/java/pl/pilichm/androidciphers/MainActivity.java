package pl.pilichm.androidciphers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPagerCiphers = findViewById(R.id.viewPagerCiphers);
        viewPagerCiphers.setAdapter(new CiphersPagerAdapter(this));
    }
}