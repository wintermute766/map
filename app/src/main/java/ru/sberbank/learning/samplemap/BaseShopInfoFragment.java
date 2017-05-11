package ru.sberbank.learning.samplemap;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Тичер on 11.05.2017.
 */
public abstract class BaseShopInfoFragment extends Fragment {

    private static final String ARG_SHOP = "shop";

    public static BaseShopInfoFragment newInstance(Address address) {
        BaseShopInfoFragment fragment;
        if (address.hasGeo()) {
            fragment = new MapShopInfoFragment();
        } else {
            fragment = new TextShopInfoFragement();
        }

        Bundle args = new Bundle();
        args.putSerializable(ARG_SHOP, address);
        fragment.setArguments(args);

        return fragment;
    }

    protected Address getShop() {
        Address shop = (Address) getArguments().getSerializable(ARG_SHOP);
        return shop;
    }
}
