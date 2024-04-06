package com.example.myapplication.UI.View;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.UI.ViewModel.ItemDataViewModel;
import com.example.myapplication.R;
public class FiveFragment extends Fragment {
    private ItemDataViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five, container, false);
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemDataViewModel.class);
        int itemId = getArguments().getInt("itemId");
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.text_view);
                ImageView itemDescription = view.findViewById(R.id.image_view);
                itemName.setText(item.getName());
                itemDescription.setImageResource(item.getImage());}
        });
        Button toFour = view.findViewById(R.id.to_four);
        toFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.FourFragment);
            }});
        return view;
    }
}