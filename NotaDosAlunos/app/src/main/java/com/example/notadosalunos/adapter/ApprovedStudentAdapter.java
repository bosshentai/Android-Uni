package com.example.notadosalunos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notadosalunos.R;
//import com.example.notadosalunos.StudentDeleteListener;
import com.example.notadosalunos.models.Student;
import com.example.notadosalunos.util.DBHelper;

import java.util.ArrayList;

public class ApprovedStudentAdapter extends RecyclerView.Adapter<ApprovedStudentAdapter.ApprovedHolder> {


    private Context context;
    private ArrayList<Student> mStudentList;

    public ApprovedStudentAdapter(Context context, ArrayList<Student> studentList) {
        this.context = context;
        this.mStudentList = studentList;
    }

    @NonNull
    @Override
    public ApprovedStudentAdapter.ApprovedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.approved_student_item_recycler_view_adapter, parent, false);
        return new ApprovedStudentAdapter.ApprovedHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovedStudentAdapter.ApprovedHolder holder, int position) {

        holder.studentName.setText(mStudentList.get(position).getName());
        holder.studentfinalGrade.setText(mStudentList.get(position).getFinalGrade());


    }

    @Override
    public int getItemCount() {
        if (mStudentList != null) {
            return mStudentList.size();
        }

        return 0;
    }


    public class ApprovedHolder extends RecyclerView.ViewHolder {

        private TextView studentName, studentfinalGrade;

//        private StudentDeleteListener deleteListener;

        DBHelper db;

        public ApprovedHolder(@NonNull View itemView) {
            super(itemView);

//            db = new DBHelper(context);
            studentName = itemView.findViewById(R.id.approved_student_name);
            studentfinalGrade = itemView.findViewById(R.id.approved_student_grade);


            itemView.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    PopupMenu popup = new PopupMenu(context, itemView);
                    popup.getMenuInflater().inflate(R.menu.student_menu, popup.getMenu());
                    popup.setOnMenuItemClickListener(
                            new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    switch (menuItem.getItemId()) {
                                        case R.id.deleteOption:
                                            db = new DBHelper(context);
                                            Integer id = mStudentList.get(getLayoutPosition()).getId();
//                                            Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show();
                                            long res = db.deleteStudent(id);
                                            notifyDataSetChanged();
//

                                            if (res > 0) {
                                                mStudentList.remove(getLayoutPosition());
                                                notifyDataSetChanged();
                                                }


                                            return true;
                                        default:
                                            return false;

                                    }

                                }
                            }
                    );

                    popup.show();

                }
            });


        }


    }
}
