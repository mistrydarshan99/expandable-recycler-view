package com.thoughtbot.expandablerecyclerview.sample.custom;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import com.thoughtbot.expandablerecyclerview.sample.R;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.OnClickGroupChildListner;

public class ChildViewHolder
    extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

  private TextView tvItemName;
  private ImageView ivArrow;
  private CheckBox chkGroup;

  public ChildViewHolder(View itemView) {
    super(itemView);
    tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
    ivArrow = (ImageView) itemView.findViewById(R.id.ivArrow);
    chkGroup = (CheckBox) itemView.findViewById(R.id.chkGroup);
  }

  public void setArtist(final Artist artist,
      final OnClickGroupChildListner onClickGroupChildListner) {
    ivArrow.setVisibility(View.GONE);
    tvItemName.setText(artist.getName());
    if (artist.isChecked()) {
      chkGroup.setChecked(true);
    } else {
      chkGroup.setChecked(false);
    }
    chkGroup.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (artist.isChecked()) {
          chkGroup.setChecked(false);
          artist.setChecked(false);
        } else {
          chkGroup.setChecked(true);
          artist.setChecked(true);
        }
        if (onClickGroupChildListner != null) {
          onClickGroupChildListner.onClickGroupChildListner(artist.getParentId(), artist.getId(), artist.isChecked());
        }
      }
    });
  }
}
