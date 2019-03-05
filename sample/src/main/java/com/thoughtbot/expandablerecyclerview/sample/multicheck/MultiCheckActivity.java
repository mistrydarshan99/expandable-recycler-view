package com.thoughtbot.expandablerecyclerview.sample.multicheck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory;
import com.thoughtbot.expandablerecyclerview.sample.R;
import java.util.ArrayList;
import java.util.List;

import static com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory.makeMultiCheckGenres;

public class MultiCheckActivity extends AppCompatActivity {

  private MultiCheckGenreAdapter adapter;
  private List<MultiCheckGenre> originalList = new ArrayList<>();
  private RecyclerView recyclerView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multi_check);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(getClass().getSimpleName());

    originalList = makeMultiCheckGenres();

    EditText etSearch = (EditText) findViewById(R.id.etSearch);
    etSearch.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().length() > 0) {
          searchQuery(s.toString());
        } else {
          adapter = new MultiCheckGenreAdapter(originalList);
          recyclerView.setAdapter(adapter);
          adapter.notifyDataSetChanged();
        }
      }

      @Override public void afterTextChanged(Editable s) {

      }
    });

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    adapter = new MultiCheckGenreAdapter(originalList);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    Button clear = (Button) findViewById(R.id.clear_button);
    clear.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        adapter.clearChoices();
      }
    });

    Button check = (Button) findViewById(R.id.check_first_child);
    check.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        //adapter.checkChild(true, 0, 3);
        adapter = new MultiCheckGenreAdapter(GenreDataFactory.makeMultiCheckGenres1());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
      }
    });

    /*for (int i = adapter.getGroups().size() - 1; i >= 0; i--) {
      expandGroup(i);
    }*/
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    //super.onSaveInstanceState(outState);
    //adapter.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    //super.onRestoreInstanceState(savedInstanceState);
    //adapter.onRestoreInstanceState(savedInstanceState);
  }

  private void searchQuery(String query) {

    query = query.toLowerCase();
    final List<MultiCheckGenre> filterList = new ArrayList<>();

    for (MultiCheckGenre multiCheckGenre : originalList) {
      List<Artist> subFilterList = multiCheckGenre.getItems();
      List<Artist> newList = new ArrayList<>();
      for (Artist productList_data : subFilterList) {
        if (productList_data.getName().toLowerCase().startsWith(query)) {
          newList.add(productList_data);
        }
      }

      if (newList.size() > 0) {
        Log.e("if new lsit", ":if new list con");

        Log.e("categoryItem", multiCheckGenre.getTitle());

        MultiCheckGenre multiCheckGenre1 =
            new MultiCheckGenre(multiCheckGenre.getTitle(), newList, R.drawable.ic_electric_guitar);
        filterList.add(multiCheckGenre1);

        Log.e("filter_model_list", "------" + filterList.size());
      }
    }

    adapter = new MultiCheckGenreAdapter(filterList);
    adapter.setOnClickGroupChildListner(new OnClickGroupChildListner() {
      @Override public void onClickGroupChildListner(int groupId, int childId, boolean checked) {
        changeInOriginalList(groupId, childId);
      }
    });

    recyclerView.setAdapter(adapter);
    adapter.notifyDataSetChanged();

    /*for (int i = adapter.getGroups().size() - 1; i >= 0; i--) {
      expandGroup(i);
    }*/
  }

  private void changeInOriginalList(int groupId, int childId) {
    for (MultiCheckGenre multiCheckGenre : originalList) {
      List<Artist> items = multiCheckGenre.getItems();
      for (Artist item : items) {
          if (item.getParentId() == groupId && item.getId() == childId){
            item.setChecked(true);
          }
      }
    }
  }

  public void expandGroup(int gPos) {
    if (adapter.isGroupExpanded(gPos)) {
      return;
    }
    adapter.toggleGroup(gPos);
  }
}
