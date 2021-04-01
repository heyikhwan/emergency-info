package com.ikhwan.emergencyinfo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);

        String[] listRS = new String[] {"RS Eka Hospital", "RS Awal Bross", "RS Syafira", "RS Ibnu Sina", "RS Santa Maria"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listRS));
    }

    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();

        tampilPilihan(pilihan);
    }

    private void tampilPilihan(String pilihan) {
        try {
            Intent a = null;

            if (pilihan.equals("RS Eka Hospital")) {
                a = new Intent(this, RSEkaHospital.class);

            } else if (pilihan.equals("RS Awal Bross")) {

            }

            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
