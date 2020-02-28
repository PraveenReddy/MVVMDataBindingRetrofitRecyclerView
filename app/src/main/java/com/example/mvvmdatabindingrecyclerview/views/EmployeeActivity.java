package com.example.mvvmdatabindingrecyclerview.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmdatabindingrecyclerview.R;
import com.example.mvvmdatabindingrecyclerview.adapters.EmployeeDataAdapter;
import com.example.mvvmdatabindingrecyclerview.databinding.ActivityMainBinding;
import com.example.mvvmdatabindingrecyclerview.models.Employee;
import com.example.mvvmdatabindingrecyclerview.viewmodels.EmployeeViewModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    private EmployeeViewModel employeeViewModel;
    private EmployeeDataAdapter employeeDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);
        getAllEmployee();
    }

    private void getAllEmployee() {
        employeeViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
            }
        });
    }
}