package muustack.com.mascotasgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class MenuAcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_acerca_de);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.inflateMenu(R.menu.menu_main);

        miActionBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.menuContacto)
                {
                    Intent intent2= new Intent(MenuAcercaDe.this, MenuContacto.class);
                    startActivity(intent2);
                    return true;
                }
                else if(item.getItemId()== R.id.menuAcerca)
                {
                    Intent intent3 = new Intent(MenuAcercaDe.this, MenuAcercaDe.class);
                    startActivity(intent3);
                    return true;
                }
                else{
                    // do something
                }

                return false;
            }
        });
    }
}