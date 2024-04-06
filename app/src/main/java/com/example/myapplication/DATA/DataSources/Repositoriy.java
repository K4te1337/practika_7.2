package com.example.myapplication.DATA.DataSources;
import androidx.lifecycle.LiveData;
import com.example.myapplication.DATA.Model.DataList;
import java.util.List;

public class Repositoriy {
    private DataSource dataSource = new LocalDataSource();
    public LiveData<List<DataList>> getItems() {
        return dataSource.getItems();
    }
    public LiveData<DataList> getItem(int itemId) {
        return dataSource.getItem(itemId);
    }
}
