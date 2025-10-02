package com.example.tugasbkpm.acara39;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tugasbkpm.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class FragmentMovie extends Fragment {

    private RecyclerView rvFilm;
    private ProgressBar progressBar;
    private ArrayList<ModelMovie> moviePopular = new ArrayList<>();
    private MovieAdapter adapter;

    private static final String API_KEY = "728a64c0649a8ccafee45edfe269597f"; // Ganti dengan API key TMDB Anda

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.acara39_fragment_film, container, false);

        progressBar = rootView.findViewById(R.id.progressBar);
        rvFilm = rootView.findViewById(R.id.rvFilm);
        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));

        getMoviePopular();

        return rootView;
    }

    private void getMoviePopular() {
        progressBar.setVisibility(View.VISIBLE);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY + "&language=en-US&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray array = response.getJSONArray("results");
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject obj = array.getJSONObject(i);
                            ModelMovie data = new ModelMovie();
                            data.setId(obj.getInt("id"));
                            data.setTitle(obj.getString("title"));
                            data.setVoteAverage(obj.getDouble("vote_average"));
                            data.setOverview(obj.getString("overview"));
                            data.setReleaseDate(obj.getString("release_date"));
                            data.setPosterPath(obj.getString("poster_path"));
                            data.setBackdropPath(obj.getString("backdrop_path"));
                            data.setPopularity(obj.getString("popularity"));
                            moviePopular.add(data);
                        }
                        adapter = new MovieAdapter(getActivity(), moviePopular);
                        rvFilm.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "Gagal memuat data", Toast.LENGTH_SHORT).show();
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);
    }
}