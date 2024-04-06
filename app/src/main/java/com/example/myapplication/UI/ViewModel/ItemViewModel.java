package com.example.myapplication.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.DATA.Model.DataList;
import com.example.myapplication.R;

import java.util.List;

public class ItemViewModel extends ViewModel {
    private LiveData<List<DataList>> items = new MutableLiveData<>();

    public ItemViewModel() {
        for (int i = 0; i < 203; i++) {
            String text = "Котик №" + (i + 1);
            ((MutableLiveData<List<DataList>>) items).getValue().add(new DataList(text, R.drawable.cat));
        }
    }

    public LiveData<List<DataList>> getItems() {
        return items;
    }
}
    /*private Repositoriy repository = new Repositoriy();
    public LiveData<List<DataList>> getItems() {
        return repository.getItems();
    }
}*/