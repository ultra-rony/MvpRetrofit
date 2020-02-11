package ru.msai.paper.main;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import ru.msai.paper.R;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private RecyclerView rView;
    private SwipeRefreshLayout sRefresh;
    private MainActivityPresenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sRefresh = findViewById(R.id.sRefreshScan);
        rView = findViewById(R.id.rViewScan);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        sRefresh.setRefreshing(true);

        // Call Presenter
        presenter = new MainActivityPresenter(MainActivity.this);
        presenter.onPaperParse();

        // Swipe Refreshing
        sRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onPaperParse();
            }
        });
        // Floating Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Success
    @Override
    public void getSuccess(List<MainModel> list) {
        // Swipe Refreshing
        sRefresh.setRefreshing(false);
        // Adapter
        adapter = new MainAdapter(MainActivity.this, list);
        LinearLayoutManager lManager = new LinearLayoutManager(this);
        rView.setLayoutManager(lManager);
        rView.setAdapter(adapter);
    }

    // Error
    @Override
    public void getError() {
        // Swipe Refreshing
        sRefresh.setRefreshing(false);
        // Toast
        Toast toast = Toast.makeText(getApplicationContext(),
                "Что-то пошло не так", Toast.LENGTH_LONG);
        toast.show();
    }
}
