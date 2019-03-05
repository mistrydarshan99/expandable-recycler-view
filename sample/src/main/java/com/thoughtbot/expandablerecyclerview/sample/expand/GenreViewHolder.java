package com.thoughtbot.expandablerecyclerview.sample.expand;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.sample.Genre;
import com.thoughtbot.expandablerecyclerview.sample.R;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.MultiCheckGenre;
import com.thoughtbot.expandablerecyclerview.sample.singlecheck.SingleCheckGenre;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class GenreViewHolder extends GroupViewHolder {

  private TextView genreName;
  private ImageView arrow;
  private ImageView icon;
  private Genre genre1;

  public GenreViewHolder(View itemView) {
    super(itemView);
    genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
    arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
    icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
  }

  public void setGenreTitle(ExpandableGroup genre) {
    if (genre instanceof Genre) {
      this.genre1 = (Genre) genre;
      genreName.setText(genre.getTitle());
      icon.setBackgroundResource(genre1.getIconResId());
      if (genre1.isExpand()) {
        expandAnimation(genre1);
      } else {
        collapseAnimation(genre1);
      }
    }
    if (genre instanceof MultiCheckGenre) {
      genreName.setText(genre.getTitle());
      this.genre1 = (Genre) genre;
      if (genre1.isExpand()) {
        expandAnimation(genre1);
      } else {
        collapseAnimation(genre1);
      }
      icon.setBackgroundResource(((MultiCheckGenre) genre).getIconResId());
    }
    if (genre instanceof SingleCheckGenre) {
      genreName.setText(genre.getTitle());
      icon.setBackgroundResource(((SingleCheckGenre) genre).getIconResId());
    }
  }

  @Override public void expand() {
    //animateExpand();
    super.expand();
    expandAnimation(genre1);
  }

  @Override public void collapse() {
    //animateCollapse();
    super.collapse();
    collapseAnimation(genre1);
  }

  private void animateExpand() {
    RotateAnimation rotate =
        new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }

  private void animateCollapse() {
    RotateAnimation rotate =
        new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }

  private void expandAnimation(Genre genre) {
    genre.setExpand(true);
    ObjectAnimator animation = ObjectAnimator.ofFloat(arrow, "rotation", 180f);
    animation.setDuration(0);
    animation.start();
  }

  private void collapseAnimation(Genre genre) {
    genre.setExpand(false);
    ObjectAnimator animation = ObjectAnimator.ofFloat(arrow, "rotation", 0f);
    animation.setDuration(0);
    animation.start();
  }
}
