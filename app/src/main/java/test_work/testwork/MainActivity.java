package test_work.testwork;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import me.pinxter.letters.Letters;
import test_work.testwork.Adapter.CustomAdapter;
import test_work.testwork.Item.ListElement;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private List<ListElement> list_elements = new ArrayList<>();
    private RecyclerView recycler;
    private CustomAdapter adapter;

    private int img1;
    private String header_1;
    private String date_1;
    private String apartments;
    private String apartments_build;
    private String location_text;
    private int img2;
    private String header_2;
    private String date_2;
    private String apartmens_2;
    private String apartmens_build2;
    private String locations_text2;
    private String topic;
    private int topic_image;
    private String text_body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusBarColor();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        initialize();
        addData();
        createRecycler();
        createFrameLayout();
    }

    private void statusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPink));
        }
    }

    private void initialize() {
        img1 = R.mipmap.ic_img1;
        header_1 = getString(R.string.header_1);
        date_1 = getString(R.string.date_1);
        apartments = getString(R.string.apartments_1);
        apartments_build = getString(R.string.apartments_build_1);
        location_text = getString(R.string.location_1);
        img2 = R.mipmap.ic_img2;
        header_2 = getString(R.string.header_2);
        date_2 = getString(R.string.date_2);
        apartmens_2 = getString(R.string.apartments_2);
        apartmens_build2 = getString(R.string.apartments_build_2);
        locations_text2 = getString(R.string.location_2);
        topic = getString(R.string.topic);
        topic_image = R.mipmap.ic_img3;
        text_body = getString(R.string.text_body);
    }

    private void addData() {
        list_elements.add(new ListElement(1, img1, header_1, date_1, apartments, apartments_build, location_text, "", 0, text_body));
        list_elements.add(new ListElement(2, img2, header_2, date_2, apartmens_2, apartmens_build2, locations_text2, topic, topic_image, text_body));
    }

    private void createRecycler() {
        RecyclerView.LayoutManager layoutMenager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutMenager);
        recycler.setHasFixedSize(true);
    }

    private void createFrameLayout() {
        Letters letters = new Letters(this, "name", (List) new ArrayList<>(list_elements));
        letters.setOnSelect(new Letters.OnSelect() {
            @Override
            public void onSelect(int index, String letter) {
                recycler.getLayoutManager().scrollToPosition(index);
            }
        });
        ((FrameLayout) findViewById(R.id.letters)).removeAllViews();

//        Error
//        ((FrameLayout) findViewById(R.id.letters)).addView(letters.getLetterLayout());

        adapter = new CustomAdapter(list_elements, this, letters);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
