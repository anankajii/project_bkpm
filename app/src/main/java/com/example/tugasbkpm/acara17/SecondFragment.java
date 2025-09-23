package com.example.tugasbkpm.acara17;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tugasbkpm.R;
public class SecondFragment extends Fragment {
    View view;
    Button SeccondButton;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.fragment_second, container, false);
        SeccondButton = view .findViewById(R.id.secondButton);
        SeccondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Second Fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
