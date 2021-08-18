package p003nl.jpthijsse.sportdag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

/* renamed from: nl.jpthijsse.sportdag.SplashActivity */
public class SplashActivity extends Activity {
    /* access modifiers changed from: private */
    public Handler handler = new Handler();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(C0054R.layout.activity_splash);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2250);
                    SplashActivity.this.handler.post(new Runnable() {
                        public void run() {
                            SplashActivity.this.goToNextScreen();
                        }
                    });
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }

    /* access modifiers changed from: protected */
    public void goToNextScreen() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0054R.menu.splash, menu);
        return true;
    }
}
