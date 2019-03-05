package com.thoughtbot.expandablerecyclerview.sample;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class Genre extends ExpandableGroup<Artist> {

  private int iconResId;
  private boolean isExpand = true;
  //private boolean expanded;
  private boolean isCheck;
  private boolean isChildAvaiable;
  private int parentId;

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public Genre(String title, List<Artist> items, int iconResId) {
    super(title, items);
    this.iconResId = iconResId;
    //this.expanded = expanded;
  }

  public boolean isChildAvaiable() {
    return isChildAvaiable;
  }

  public void setChildAvaiable(boolean childAvaiable) {
    isChildAvaiable = childAvaiable;
  }

  public boolean isCheck() {
    return isCheck;
  }

  public void setCheck(boolean check) {
    isCheck = check;
  }

  public void setIconResId(int iconResId) {
    this.iconResId = iconResId;
  }

  public boolean isExpand() {
    return isExpand;
  }

  public void setExpand(boolean expand) {
    isExpand = expand;
  }

  public int getIconResId() {
    return iconResId;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Genre)) return false;

    Genre genre = (Genre) o;

    return getIconResId() == genre.getIconResId();
  }

  @Override public int hashCode() {
    return getIconResId();
  }
}

