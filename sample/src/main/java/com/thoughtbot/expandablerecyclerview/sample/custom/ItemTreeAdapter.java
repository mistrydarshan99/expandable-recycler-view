package com.thoughtbot.expandablerecyclerview.sample.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import com.thoughtbot.expandablerecyclerview.sample.Genre;
import com.thoughtbot.expandablerecyclerview.sample.R;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.OnClickGroupChildListner;
import java.util.ArrayList;
import java.util.List;

public class ItemTreeAdapter
    extends ExpandableRecyclerViewAdapter<ParentViewHolder, ChildViewHolder> {

  List<Genre> parentList;
  private List<Genre> originalList;
  private OnClickGroupChildListner onClickGroupChildListner;

  public void setOnClickGroupChildListner(OnClickGroupChildListner onClickGroupChildListner) {
    this.onClickGroupChildListner = onClickGroupChildListner;
  }

  public ItemTreeAdapter(List<Genre> parentList) {
    super(parentList);
    this.parentList = parentList;
    this.originalList = new ArrayList<Genre>();
    this.originalList.addAll(parentList);
  }

  @Override public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.group_layout, parent, false);
    return new ParentViewHolder(view);
  }

  @Override public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.child_layout, parent, false);
    return new ChildViewHolder(view);
  }

  @Override
  public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group,
      int childIndex) {

    final Artist artist = ((Genre) group).getItems().get(childIndex);
    holder.setArtist(artist, onClickGroupChildListner);
  }

  @Override public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition,
      ExpandableGroup group) {

    holder.setGenreTitle(group, onClickGroupChildListner);
  }


}
