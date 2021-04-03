package com.example.tasks_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView =  view.findViewById(R.id.recycler_view_tasks);

        ArrayList<Task> tasks = new ArrayList<>();
        Task task = new Task("12 tasks", "Web Development");
        tasks.add(task);
        Task task1 = new Task("7 tasks","App Design");
        tasks.add(task1);
        Task task2 = new Task("13 tasks","Monitoring");
        tasks.add(task2);
        Task task3 = new Task("2 tasks","Brain-Storming");
        tasks.add(task3);
        Task task4 = new Task("10 tasks","Freelancing");
        tasks.add(task4);

        CustomAdapter adapter = new CustomAdapter(tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private ArrayList<Task> localDataSet;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textViewTasksNumber;
            private final TextView textViewTasksTitle;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                textViewTasksNumber = (TextView) view.findViewById(R.id.tasks_number);
                textViewTasksTitle = (TextView) view.findViewById(R.id.tasks_title);
            }

            public TextView getTasksNumber() {
                return textViewTasksNumber;
            }

            public TextView getTasksTitle() {
                return textViewTasksTitle;
            }
        }

        public CustomAdapter(ArrayList<Task> dataSet) {
            localDataSet = dataSet;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_tasks, viewGroup, false);

            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.getTasksNumber().setText(localDataSet.get(position).taskNumber);
            viewHolder.getTasksTitle().setText(localDataSet.get(position).taskTitle);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }

    public class Task{

        private String taskNumber;
        private String taskTitle;

        public Task(String taskNumber, String taskTitle) {
            this.taskNumber = taskNumber;
            this.taskTitle = taskTitle;
        }

    }

}