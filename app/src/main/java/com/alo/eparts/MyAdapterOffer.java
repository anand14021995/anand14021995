package com.alo.eparts;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapterOffer extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapterOffer(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                RequestOffer RequestFragment = new RequestOffer();
                return RequestFragment;
            case 1:
                ApprovedOffer approvedFragment = new ApprovedOffer();
                return approvedFragment;

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
