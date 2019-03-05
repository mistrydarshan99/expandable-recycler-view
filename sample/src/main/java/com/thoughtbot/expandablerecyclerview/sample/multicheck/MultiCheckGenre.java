package com.thoughtbot.expandablerecyclerview.sample.multicheck;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import java.util.List;

public class MultiCheckGenre extends MultiCheckExpandableGroup {

  private int iconResId;
  public boolean expanded;

  public MultiCheckGenre(String title, List<Artist> items, int iconResId) {
    super(title, items);
    this.iconResId = iconResId;
  }

  public void setIconResId(int iconResId) {
    this.iconResId = iconResId;
  }

  public boolean isExpanded() {
    return expanded;
  }

  public void setExpanded(boolean expanded) {
    this.expanded = expanded;
  }

  public int getIconResId() {
    return iconResId;
  }
}

