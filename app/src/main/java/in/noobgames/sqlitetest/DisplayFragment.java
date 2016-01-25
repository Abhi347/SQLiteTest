package in.noobgames.sqlitetest;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    ListView mDisplayListView;
    ArrayList<Student> mStudents = new ArrayList<>();
    SQLiteDatabase readableDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_display, container, false);
        mDisplayListView = (ListView) parent.findViewById(R.id.display_list);
        readData();
        DisplayAdapter adapter = new DisplayAdapter(getActivity(), R.layout.item_student_row, mStudents);

        mDisplayListView.setAdapter(adapter);
        return parent;
    }

    private void readData() {
        mStudents.clear();

        MainActivity mainActivity = (MainActivity) getActivity();
        readableDB = mainActivity.getDBHelper().getReadableDatabase();

        String[] projection = {
                DBHelper.COLUMN_ID,
                DBHelper.COLUMN_NAME,
                DBHelper.COLUMN_COURSE,
                DBHelper.COLUMN_CONTACT,
                DBHelper.COLUMN_EMAIL
        };

        Cursor cursor = readableDB.query(
                DBHelper.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        cursor.moveToFirst();
        do {
            Student student = new Student();
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID));
            student.setId(id);

            String name = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_NAME));
            student.setName(name);

            String course = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_COURSE));
            student.setCourse(course);

            String phone = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_CONTACT));
            student.setPhone(phone);

            String email = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_EMAIL));
            student.setEmail(email);

            mStudents.add(student);
            cursor.moveToNext();
        } while (!cursor.isAfterLast());
    }
}
