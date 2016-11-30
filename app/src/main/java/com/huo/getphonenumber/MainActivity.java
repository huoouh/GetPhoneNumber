package com.huo.getphonenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ContactsInfo> contactsInfoList = GetPhoneInfo.getContactsInfo(this);
        mAdapter = new ContactsAdapter(this, contactsInfoList);

        mListView = (ListView) findViewById(R.id.lvContacts);
        mListView.setAdapter(mAdapter);

    }
}
