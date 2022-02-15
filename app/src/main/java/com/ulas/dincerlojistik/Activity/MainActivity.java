package com.ulas.dincerlojistik.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.ulas.dincerlojistik.Fragment.HomeFragment;
import com.ulas.dincerlojistik.Fragment.RegisterFragment;
import com.ulas.dincerlojistik.Fragment.SettingsFragment;
import com.ulas.dincerlojistik.Fragment.VerifyFragment;
import com.ulas.dincerlojistik.R;
import com.ulas.dincerlojistik.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();

        binding.bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.verify));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.home));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_settings_24));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.register));
        binding.bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment=new VerifyFragment();
                        break;
                    case 2:
                        fragment=new HomeFragment();
                        break;
                    case 3:
                        fragment=new SettingsFragment();
                        break;
                    case 4:
                        fragment=new RegisterFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });
        binding.bottomNavigation.setCount(1,"10");
        binding.bottomNavigation.show(2,true);
        binding.bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        binding.bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
    }
    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }

}