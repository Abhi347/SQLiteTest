package in.noobgames.sqlitetest;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {
    EditText mNameEdit, mCourseEdit, mPhoneEdit, mEmailEdit;
    SQLiteDatabase writableDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_input, container, false);
        mNameEdit = (EditText) parent.findViewById(R.id.name_input);
        mCourseEdit = (EditText) parent.findViewById(R.id.course_input);
        mPhoneEdit = (EditText) parent.findViewById(R.id.contact_input);
        mEmailEdit = (EditText) parent.findViewById(R.id.email_input);

        MainActivity mainActivity = (MainActivity) getActivity();

        writableDB = mainActivity.getDBHelper().getWritableDatabase();


        return parent;
    }

    public void onInputSubmitClick() {
        String name = mNameEdit.getText().toString();
        String course = mCourseEdit.getText().toString();
        String phone = mPhoneEdit.getText().toString();
        String email = mEmailEdit.getText().toString();


        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, name);
        values.put(DBHelper.COLUMN_COURSE, course);
        values.put(DBHelper.COLUMN_CONTACT, phone);
        values.put(DBHelper.COLUMN_EMAIL, email);


// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = writableDB.insert(DBHelper.TABLE_NAME, null, values);

        if (newRowId >= 0) {
            Toast.makeText(getActivity(), "Insert Successful: " + name, Toast.LENGTH_SHORT).show();
        }

        mNameEdit.setText("");
        mCourseEdit.setText("");
        mPhoneEdit.setText("");
        mEmailEdit.setText("");
    }
}
