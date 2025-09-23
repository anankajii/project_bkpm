package com.example.tugasbkpm.acara17;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.example.tugasbkpm.R;
public class FristFragment extends Fragment {
    View view;
    Button fristButton;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstance){
        view = inflater.inflate(R.layout.fragment_frist, container, false);
        fristButton= view.findViewById(R.id.fristButton);
        fristButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"frist fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
