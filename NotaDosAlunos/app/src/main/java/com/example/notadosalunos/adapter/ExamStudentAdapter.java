package com.example.notadosalunos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notadosalunos.R;
import com.example.notadosalunos.models.Student;

import java.util.ArrayList;

public class ExamStudentAdapter extends RecyclerView.Adapter<ExamStudentAdapter.ExamHolder> {

    private Context context;

    private ArrayList<Student> mStudentList;



    public ExamStudentAdapter (Context context,ArrayList<Student> studentList){
        this.context = context;
        this.mStudentList = studentList;
    }

    @NonNull
    @Override
    public ExamStudentAdapter.ExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.approved_student_item_recycler_view_adapter,parent,false);
        return new ExamStudentAdapter.ExamHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamStudentAdapter.ExamHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ExamHolder extends RecyclerView.ViewHolder{


        private TextView studentName, studentfinalGrade;

        public ExamHolder(@NonNull View itemView) {
            super(itemView);

//            studentName = itemView.findViewById(R)
        }
    }
}
