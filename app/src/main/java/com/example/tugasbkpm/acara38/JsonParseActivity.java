package com.example.tugasbkpm.acara38;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tugasbkpm.R;



public class JsonParseActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara38_json_parse);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("JSON");
        }

        String jsonStr = getListData();
        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            ListView lv = (ListView) findViewById(R.id.list);
            JSONObject jObj = new JSONObject(jsonStr);
            JSONArray jsonArry = jObj.getJSONArray("users");
            for (int i = 0; i < jsonArry.length(); i++) {
                JSONObject obj = jsonArry.getJSONObject(i);
                HashMap<String, String> user = new HashMap<>();
                user.put("name", obj.getString("name"));
                user.put("designation", obj.getString("designation"));
                user.put("location", obj.getString("location"));
                userList.add(user);
            }
            ListAdapter adapter = new SimpleAdapter(
                    JsonParseActivity.this, userList,
                    R.layout.acara38_list_row, new String[]{"name", "designation", "location"},
                    new int[]{R.id.name, R.id.designation, R.id.location}
            );
            lv.setAdapter(adapter);
        } catch (JSONException ex) {
            Log.e("JsonParser Example", "msg Unexpected JSON exception", ex);
        }
    }

    private String getListData() {
        String jsonStr = "{ \"users\" :[" +
                "{\"name\":\"Monkey D. Luffy\",\"designation\":\"Leader\",\"location\":\"East Blue\" }," +
                "{\"name\":\"Roronoa Zoro\",\"designation\":\"Swordsman\",\"location\":\"East Blue\" }," +
                "{\"name\":\"Nami\",\"designation\":\"Navigator\",\"location\":\"East Blue\" }] }";
        return jsonStr;
    }
}