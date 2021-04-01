package com.ikhwan.emergencyinfo;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSEkaHospital extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);

        String[] listAct = new String[] {"Call Center", "SMS Center", "Location", "Website", "Info on Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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

            if (pilihan.equals("Call Center")) {
               String telp = "tel:0761-6989999";

               a = new Intent(Intent.ACTION_DIAL, Uri.parse(telp));

            } else if (pilihan.equals("SMS Center")) {
                String smsText = "Halo, Eka Hospital";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:08888905555"));
                a.putExtra("sms_body", smsText);
            } else if (pilihan.equals("Location")) {
                String lokasiRs = "google.navigation:q=0.482418, 101.419703";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasiRs));
            } else if (pilihan.equals("Website")) {
                String web = "https://www.ekahospital.com/id";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Info on Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "RS Eka Hospital Pekanbaru");
            }

            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
