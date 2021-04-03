package com.example.tasks_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TasksFragment extends Fragment {

    RecyclerView recyclerView , recyclerView1;

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        recyclerView =  view.findViewById(R.id.recycler_view_my_tasks);
        recyclerView1 =  view.findViewById(R.id.recycler_view_days);

        ArrayList<Day> days = new ArrayList<>();
        Day day1 = new Day("07","Fri");
        days.add(day1);
        Day day2 = new Day("08","Sat");
        days.add(day2);
        Day day3 = new Day("09","Sun");
        days.add(day3);
        Day day4 = new Day("10","Mon");
        days.add(day4);
        Day day5 = new Day("11","Tue");
        days.add(day5);
        Day day6 = new Day("12","Wed");
        days.add(day6);
        Day day7 = new Day("13","Thu");
        days.add(day7);

        CustomAdapter1 adapter1 = new CustomAdapter1(days,getContext());
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(layoutManager1);

        ArrayList<Task> tasks = new ArrayList<>();
        Task task1 = new Task("9:00","Send the documents to the client");
        tasks.add(task1);
        Task task2 = new Task("11:00","Get the wireframes as soon as possible");
        tasks.add(task2);
        Task task3 = new Task("14:00","Make a draft design and send it to review");
        tasks.add(task3);
        Task task4 = new Task("16:00","Start Development discussion with design team");
        tasks.add(task4);
        Task task5 = new Task("21:00","Watch Champions league game");
        tasks.add(task5);

        CustomAdapter adapter = new CustomAdapter(tasks,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    public static class CustomAdapter extends RecyclerView.Adapter<TasksFragment.CustomAdapter.ViewHolder> {

        private ArrayList<Task> localDataSet;
        private Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textViewTasksTime;
            private final TextView textViewTasksTitle;
            private final ImageView imageViewTask;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                textViewTasksTime = (TextView) view.findViewById(R.id.tv_Task_Time);
                textViewTasksTitle = (TextView) view.findViewById(R.id.tv_Task_Title);
                imageViewTask = (ImageView) view.findViewById(R.id.iv_task);
            }

            public TextView getTasksNumber() {
                return textViewTasksTime;
            }

            public TextView getTasksTitle() {
                return textViewTasksTitle;
            }

            public  ImageView getTasksImage(){
                return imageViewTask;
            }
        }

        public CustomAdapter(ArrayList<Task> dataSet , Context context) {
            localDataSet = dataSet;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public TasksFragment.CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.task, viewGroup, false);

            return new TasksFragment.CustomAdapter.ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(TasksFragment.CustomAdapter.ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element

            viewHolder.getTasksNumber().setText(localDataSet.get(position).taskTime);
            viewHolder.getTasksTitle().setText(localDataSet.get(position).taskTitle);

            if (position == 0){
                viewHolder.getTasksImage().setImageDrawable(ContextCompat.getDrawable(context,R.drawable.row_checked_icon));
                viewHolder.getTasksTitle().setTextColor(ContextCompat.getColor(context,R.color.white));
                viewHolder.getTasksTitle().setBackground(ContextCompat.getDrawable(context,R.drawable.background_home_tasks_orange));
            }else if (position == getItemCount()-1){
                viewHolder.getTasksImage().setImageDrawable(ContextCompat.getDrawable(context,R.drawable.row_checked_icon));
            }
            else {
                viewHolder.getTasksImage().setImageDrawable(ContextCompat.getDrawable(context,R.drawable.row_later_icon));
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }

    public class Task{

        private String taskTime;
        private String taskTitle;

        public Task(String taskTime, String taskTitle) {
            this.taskTime = taskTime;
            this.taskTitle = taskTitle;
        }

    }

    public static class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.ViewHolder> {

        private ArrayList<Day> localDataSet;
        private Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textViewDayNumber;
            private final TextView textViewDayName;
            private final LinearLayout linearLayout;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                textViewDayNumber = (TextView) view.findViewById(R.id.tv_Day_Number);
                textViewDayName = (TextView) view.findViewById(R.id.tv_Day_Name);
                linearLayout = (LinearLayout) view.findViewById(R.id.l_Day);
            }

            public TextView getDaysNumber() {
                return textViewDayNumber;
            }

            public TextView getDayTitle() {
                return textViewDayName;
            }

            public LinearLayout getLinearLayout() {
                return linearLayout;
            }
        }

        public CustomAdapter1(ArrayList<Day> dataSet , Context context) {
            localDataSet = dataSet;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CustomAdapter1.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.days, viewGroup, false);

            return new CustomAdapter1.ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(CustomAdapter1.ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            if (position == 0){
                viewHolder.getDaysNumber().setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                viewHolder.getLinearLayout().setBackground(ContextCompat.getDrawable(context, R.drawable.background_days_white));
            }
            viewHolder.getDaysNumber().setText(localDataSet.get(position).dayNumber);
            viewHolder.getDayTitle().setText(localDataSet.get(position).dayName);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }

    public class Day{

        private String dayNumber;
        private String dayName;

        public Day(String dayNumber, String dayName) {
            this.dayNumber = dayNumber;
            this.dayName = dayName;
        }
    }
}