package com.example.jorav.pruebatab;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//Clase principal que controla todos los Tabs
public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout; //Creamos el tabLayout
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout2);
        avatar = (ImageView) findViewById(R.id.imageAvatar);

        //Añadimos los tabs necesarios en este caso 3
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        //A cada tab le asignamos una imagen
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.pills));
        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.hospital));
        tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.pharmacy));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creamos el ViewPager (Sirve para desplazarse por varios layout deslizandonos)
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager2);
        //Llamamos a la clase PagerAdapter que servira para podernos desplazar por los tabs y se la asignamos al viewPager
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Metodo que nos servira para ir directamente al tab que queramos cuando pulsemos uno de los tabs
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent que nos lleva a la pestaña del Card Expandible
                Intent intent = new Intent(MainActivity.this, CardsExpand.class);
                startActivity(intent);
            }
        });

    }
}
