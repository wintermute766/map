package ru.sberbank.learning.samplemap;

import android.content.Context;
import android.location.Geocoder;
import android.os.AsyncTask;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Дмитрий Соколов <DPSokolov.SBT@sberbank.ru>
 */
public class LoadTask extends AsyncTask<Void, Void, List<Address>> {

    private Context mContext;
    private WeakReference<ShopsListener> listenerRef;

    public LoadTask(Context context,
                    ShopsListener listener) {
        mContext = context;
        listenerRef = new WeakReference<>(listener);
    }

    @Override
    protected List<Address> doInBackground(Void... params) {
        AddressesLoader loader = new AddressesLoader();
        List<String> addresses = loader.doLoad();
        Geocoder geocoder = new Geocoder(mContext);

        List<Address> result = new ArrayList<>(addresses.size());
        for (String address: addresses) {
            Address addr = new Address();
            addr.setAddress(address);
            result.add(addr);

            if (Geocoder.isPresent()) {
                try {
                    List<android.location.Address> location = geocoder.getFromLocationName(address, 1);
                    if (location != null && location.size() > 0) {
                        addr.setLatitude(location.get(0).getLatitude());
                        addr.setLongitude(location.get(0).getLongitude());
                    }
                } catch (IOException e) {
                }
            }
        }

        return result;
    }

    @Override
    protected void onPostExecute(List<Address> points) {
        ShopsListener listener = listenerRef.get();

        if (listener != null) {
            listener.onReady(points);
        }
    }
}
