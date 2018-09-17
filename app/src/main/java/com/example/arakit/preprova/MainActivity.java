package com.example.arakit.preprova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intentjokenpo,intentTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcao1:
                intentjokenpo = new Intent(this,jankenpon.class);
                startActivity(intentjokenpo);
                return (true);
            case R.id.opcao2:
                intentTemp = new Intent(this,temperatura.class);
                startActivity(intentTemp);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
