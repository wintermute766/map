package ru.sberbank.learning.samplemap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Тичер on 11.05.2017.
 */

public class ShopListFragment extends Fragment implements ShopsListener {

    private ListView listView;
    private View progressBar;

    private List<Address> addresses;
    private LoadTask loadTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (addresses == null || loadTask == null) {
            loadTask = new LoadTask(getContext().getApplicationContext(), this);
            loadTask.execute();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shops, container,
                false);

        listView = (ListView) root.findViewById(R.id.shops_list);
        progressBar = root.findViewById(R.id.progress);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Address shop = ((ShopsAdapter) parent.getAdapter())
                        .getItem(position);
                ((ShopInfoHost) getActivity()).displayShop(shop);
            }
        });

        showContent();
        return root;
    }

    private void showContent() {
        if (addresses != null) {
            listView.setAdapter(new ShopsAdapter(addresses));
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onReady(List<Address> result) {
        addresses = result;

        if (isVisible()) {
            showContent();
        }
    }
}
