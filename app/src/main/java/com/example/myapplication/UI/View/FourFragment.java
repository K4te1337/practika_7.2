package com.example.myapplication.UI.View;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.DATA.Model.DataList;
import com.example.myapplication.UI.View.MyRecyclerAdapter;
import com.example.myapplication.UI.ViewModel.ItemViewModel;
import com.example.myapplication.R;
import java.util.ArrayList;
public class FourFragment extends Fragment {
    private ItemViewModel viewModel;
    ArrayList<DataList> list = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView itemsList = view.findViewById(R.id.recycler_view);
        for (int i = 0; i < 203; i++) {
            String text = "Котик №" + (i + 1);
            DataList list2 = new DataList(text, R.drawable.cat);
            list.add(list2);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(ItemViewModel.class);
        viewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            adapter.notifyDataSetChanged();
        });
        itemsList.setAdapter(adapter);
    }
}