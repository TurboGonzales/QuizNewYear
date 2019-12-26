package by.bsuir.QuizNewYear.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import by.bsuir.QuizNewYear.R;
import by.bsuir.QuizNewYear.adapters.TestListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadTestList();
    }

    private void loadTestList() {
        List<Field> fieldList = Arrays.asList(R.raw.class.getFields());
        RecyclerView recyclerView = findViewById(R.id.rv_test_list);
        TestListAdapter adapter = new TestListAdapter(this, fieldList);
        recyclerView.setAdapter(adapter);
    }

}
