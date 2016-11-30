package com.huo.getphonenumber;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huo on 22/11/2016.
 */

public class GetPhoneInfo {

    public static List<ContactsInfo> getContactsInfo(Context context) {
        Cursor cursor = context.getContentResolver().query(CommonDataKinds.Phone.CONTENT_URI,
                                            null, null, null, null);

        List<ContactsInfo> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER));
            ContactsInfo info = new ContactsInfo(name, number);
            list.add(info);
        }
        cursor.close();

        return list;
    }
}
