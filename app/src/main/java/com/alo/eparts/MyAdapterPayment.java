package com.alo.eparts;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapterPayment extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapterPayment(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Wallet WalletFragment = new Wallet();
                return WalletFragment;
            case 1:
                transaction transactionFragment = new transaction();
                return transactionFragment;
            case 2:
                NBA nbaFragment = new NBA();
                return nbaFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
