package com.thoughtbot.expandablerecyclerview.sample.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import com.thoughtbot.expandablerecyclerview.sample.Genre;
import com.thoughtbot.expandablerecyclerview.sample.R;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.OnClickGroupChildListner;
import java.util.ArrayList;
import java.util.List;

import static com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory.makeClassicGenre;
import static com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory.makeGenres;
import static com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory.makeRefresh;

public class CustomExpandActivity extends AppCompatActivity {

  public ItemTreeAdapter adapter;
  private Button btnRefresh;
  private EditText etSearch;
  private List<Genre> originalList;
  private RecyclerView recyclerView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expand);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(getClass().getSimpleName());

    originalList = makeGenres();
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
    // Specifically when you call notifyItemChanged() it does a fade animation for the changing
    // of the data in the ViewHolder. If you would like to disable this you can use the following:
    RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
    if (animator instanceof DefaultItemAnimator) {
      ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
    }

    loadOriginalList();
    recyclerView.setLayoutManager(layoutManager);

    Button clear = (Button) findViewById(R.id.toggle_button);
    clear.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        adapter.toggleGroup(makeClassicGenre());
      }
    });

    btnRefresh = (Button) findViewById(R.id.btnRefresh);
    btnRefresh.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        //adapter = new GenreAdapter(makeRefresh());
        //recyclerView.setAdapter(adapter);
        List<Genre> groups = (List<Genre>) adapter.getGroups();
        groups.clear();
        groups.addAll(makeRefresh());
        adapter.notifyDataSetChanged();
      }
    });

    etSearch = (EditText) findViewById(R.id.etSearch);
    etSearch.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().length() > 0) {
          searchQuery(s.toString());
        } else {
          loadOriginalList();
        }
      }

      @Override public void afterTextChanged(Editable s) {

      }
    });
  }

  private void loadOriginalList() {
    adapter = new ItemTreeAdapter(originalList);
    recyclerView.setAdapter(adapter);
    expandAll();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    adapter.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    adapter.onRestoreInstanceState(savedInstanceState);
  }

  private void searchQuery(String query) {

    query = query.toLowerCase();
    final List<Genre> filterList = new ArrayList<>();

    for (Genre multiCheckGenre : originalList) {
      List<Artist> subFilterList = multiCheckGenre.getItems();
      List<Artist> newList = new ArrayList<>();

      String titleName = multiCheckGenre.getTitle();
      if (titleName.toLowerCase().startsWith(query)) {
        /*if (subFilterList != null && subFilterList.size() > 0) {
          newList.addAll(subFilterList);
        }
        Genre multiCheckGenre1 =
            new Genre(multiCheckGenre.getTitle(), newList, R.drawable.ic_electric_guitar);
        if (newList.size() == 0) {
          multiCheckGenre1.setParentId(multiCheckGenre.getParentId());
          multiCheckGenre1.setChildAvaiable(true);
        }*/
        filterList.add(multiCheckGenre);
      } else {
        for (Artist productList_data : subFilterList) {
          if (productList_data.getName().toLowerCase().startsWith(query)) {
            newList.add(productList_data);
          }
        }

        if (newList.size() > 0) {
          Genre multiCheckGenre1 =
              new Genre(multiCheckGenre.getTitle(), newList, R.drawable.ic_electric_guitar);
          filterList.add(multiCheckGenre1);
        }
      }

      /*for (Artist productList_data : subFilterList) {
        if (productList_data.getName().toLowerCase().startsWith(query)) {
          newList.add(productList_data);
        }
      }*/

      /*if (newList.size() > 0) {
        Genre multiCheckGenre1 =
            new Genre(multiCheckGenre.getTitle(), newList, R.drawable.ic_electric_guitar);
        filterList.add(multiCheckGenre1);
      }*/
    }

    adapter = new ItemTreeAdapter(filterList);
    recyclerView.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    adapter.setOnClickGroupChildListner(new OnClickGroupChildListner() {
      @Override public void onClickGroupChildListner(int groupId, int childId, boolean checked) {
        changeInOriginalList(groupId, childId, checked);
      }
    });
    expandAll();
  }

  private void changeInOriginalList(int groupId, int childId, boolean checked) {
    for (Genre multiCheckGenre : originalList) {
      List<Artist> items = multiCheckGenre.getItems();
      if (items != null && items.size() > 0) {
        for (Artist item : items) {
          if (item.getParentId() == groupId && item.getId() == childId) {
            item.setChecked(checked);
          }
        }
      } else {
        if (multiCheckGenre.getParentId() == groupId) {
          multiCheckGenre.setCheck(checked);
        }
      }
    }
  }

  public void expandAll() {
    for (int i = 0; i < adapter.getItemCount(); i++) {
      if (!adapter.isGroupExpanded(i)) {
        adapter.toggleGroup(i);
      }
    }
  }
}
