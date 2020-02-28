package com.example.mvvmdatabindingrecyclerview.viewmodels;

import android.app.Application;

import com.example.mvvmdatabindingrecyclerview.models.Employee;
import com.example.mvvmdatabindingrecyclerview.repositories.EmployeeRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class EmployeeViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }
    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }

}
