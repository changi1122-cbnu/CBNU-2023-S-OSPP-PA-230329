package net.studio1122.p7_2_changing_buttoncolor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2= findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if (v == button2) {
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())  {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                button2.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                button1.setScaleY(2);
                button2.setScaleX(2);
                button2.setScaleY(2);
                return true;
        }
        return false;
    }
}