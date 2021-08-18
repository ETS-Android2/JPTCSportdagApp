package nl.jpthijsse.sportdag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/* renamed from: nl.jpthijsse.sportdag.MainActivity */
public class MainActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.activity_main);
        final Intent LeerlingButtonIntent = new Intent(this, SportActivity.class);
        ((Button) findViewById(R.id.Leerlingbutton_id)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(LeerlingButtonIntent);
            }
        });
        final Intent BegeleidingBtnIntent = new Intent(this, BegeleidingActivity.class);
        ((Button) findViewById(R.id.Begeleidingbutton_id)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(BegeleidingBtnIntent);
            }
        });
        final Intent RecordsButtonIntent = new Intent(this, RecordsActivity.class);
        ((Button) findViewById(R.id.Recordsbutton_id)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(RecordsButtonIntent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
