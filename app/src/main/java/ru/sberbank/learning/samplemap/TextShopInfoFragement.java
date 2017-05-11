package ru.sberbank.learning.samplemap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Тичер on 11.05.2017.
 */

public class TextShopInfoFragement extends BaseShopInfoFragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shop_text,
                container, false);
        textView = (TextView) root.findViewById(R.id.shop_text);
        textView.setText(getShop().getAddress());

        return root;
    }
}
