package com.example.myapplication.UI.View;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.myapplication.R;
import com.example.myapplication.DATA.Model.FragmentNavigationData;
public class FirstFragment extends Fragment {
    public FragmentNavigationData data = new FragmentNavigationData();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        Button toSecond = view.findViewById(R.id.to_second);
        toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment);
                Bundle bundle = new Bundle();
                bundle.putString("res", data.getDataFrom1to2());
                Navigation.findNavController(view).navigate(R.id.SecondFragment, bundle);
            }
        });
        return view;
    }
}