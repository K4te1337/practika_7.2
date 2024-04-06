package com.example.myapplication.UI.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.example.myapplication.R;
import com.example.myapplication.UI.ViewModel.ItemDataViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ItemDataViewModel viewModel = new ViewModelProvider(this).get(ItemDataViewModel.class);
    }
}