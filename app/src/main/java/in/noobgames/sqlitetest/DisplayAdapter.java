package in.noobgames.sqlitetest;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhishek on 25-01-2016.
 */
public class DisplayAdapter extends ArrayAdapter<Student> {
    ArrayList<Student> mStudents;
    int mResource;

    public DisplayAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource);
        mStudents = students;
        mResource = resource;
    }

    @Override
    public int getCount() {
        return mStudents.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(mResource, null);
        }

        TextView idText = (TextView) convertView.findViewById(R.id.student_id);
        TextView nameText = (TextView) convertView.findViewById(R.id.student_name);
        TextView courseText = (TextView) convertView.findViewById(R.id.student_course);
        TextView phoneText = (TextView) convertView.findViewById(R.id.student_phone);
        TextView emailText = (TextView) convertView.findViewById(R.id.student_email);

        Student student = mStudents.get(position);

        idText.setText("" + student.getId());
        nameText.setText(student.getName());
        courseText.setText(student.getCourse());
        phoneText.setText(student.getPhone());
        emailText.setText(student.getEmail());

        return convertView;
    }
}
