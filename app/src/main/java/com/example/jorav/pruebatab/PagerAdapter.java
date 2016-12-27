package com.example.jorav.pruebatab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jorav on 17/11/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.numOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PillsActivity tabPills = new PillsActivity();
                return tabPills;
            case 1:
                HospitalActivity tabHospital = new HospitalActivity();
                return tabHospital;
            case 2:
                Pharmacy tabPharmacy = new Pharmacy();
                return tabPharmacy;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
