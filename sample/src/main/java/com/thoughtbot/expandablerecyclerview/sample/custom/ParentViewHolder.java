package com.thoughtbot.expandablerecyclerview.sample.custom;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.sample.Genre;
import com.thoughtbot.expandablerecyclerview.sample.R;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.OnClickGroupChildListner;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ParentViewHolder extends GroupViewHolder {

  private TextView tvItemName;
  private ImageView ivArrow;
  private CheckBox chkGroup;
  private LinearLayout llSubLayout;
  private Genre genre1;

  public ParentViewHolder(View itemView) {
    super(itemView);
    llSubLayout = (LinearLayout) itemView.findViewById(R.id.llSubLayout);
    tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
    ivArrow = (ImageView) itemView.findViewById(R.id.ivArrow);
    chkGroup = (CheckBox) itemView.findViewById(R.id.chkGroup);
  }

  public void setGenreTitle(ExpandableGroup genre,
      final OnClickGroupChildListner onClickGroupChildListner) {
    if (genre instanceof Genre) {
      this.genre1 = (Genre) genre;



      if (genre1.isExpand()) {
        expandAnimation(genre1);
      } else {
        collapseAnimation(genre1);
      }
      
      if (genre1.isChildAvaiable()) {

        ivArrow.setVisibility(View.GONE);
        chkGroup.setVisibility(View.VISIBLE);
        tvItemName.setVisibility(View.GONE);

        chkGroup.setText(genre1.getTitle());
        chkGroup.setChecked(genre1.isCheck());
        chkGroup.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            if (genre1.isCheck()) {
              chkGroup.setChecked(false);
              genre1.setCheck(false);
            } else {
              chkGroup.setChecked(true);
              genre1.setCheck(true);
            }
            if (onClickGroupChildListner != null) {
              onClickGroupChildListner.onClickGroupChildListner(genre1.getParentId(), -9999,
                  genre1.isCheck());
            }
          }
        });
      } else {
        chkGroup.setVisibility(View.GONE);
        ivArrow.setVisibility(View.VISIBLE);
        tvItemName.setVisibility(View.VISIBLE);
        tvItemName.setText(genre1.getTitle());
      }
    }
  }

  @Override public void expand() {
    super.expand();
    expandAnimation(genre1);
  }

  @Override public void collapse() {
    super.collapse();
    collapseAnimation(genre1);
  }

  private void expandAnimation(Genre genre) {
    genre.setExpand(true);
    ObjectAnimator animation = ObjectAnimator.ofFloat(ivArrow, "rotation", 180f);
    animation.setDuration(0);
    animation.start();
  }

  private void collapseAnimation(Genre genre) {
    genre.setExpand(false);
    ObjectAnimator animation = ObjectAnimator.ofFloat(ivArrow, "rotation", 0f);
    animation.setDuration(0);
    animation.start();
  }
}
