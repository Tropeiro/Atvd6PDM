package com.example.atvd6pdm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.atvd6pdm.R;
import com.example.atvd6pdm.adapter.ViewPagerAdapter;
import com.example.atvd6pdm.fragments.CirculoFragment;
import com.example.atvd6pdm.fragments.TrapezioFragment;
import com.example.atvd6pdm.fragments.TrianguloFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TelaInicial extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        viewPager = findViewById(R.id.viewPager);
        tabs = findViewById(R.id.tabs);

        configTablayout();
    }

    private void configTablayout(){ // adicionando os fragments nas abas
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        adapter.addFragment(new CirculoFragment(), "Circulo");
        adapter.addFragment(new TrianguloFragment(), "Triangulo");
        adapter.addFragment(new TrapezioFragment(), "Trapézio");

        viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));

        });
        mediator.attach();
    }
}