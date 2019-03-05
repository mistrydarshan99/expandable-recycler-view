package com.thoughtbot.expandablerecyclerview.sample.multicheck;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;
import com.thoughtbot.expandablerecyclerview.sample.Artist;
import com.thoughtbot.expandablerecyclerview.sample.R;

public class MultiCheckArtistViewHolder extends CheckableChildViewHolder {

  private CheckedTextView childCheckedTextView;

  public MultiCheckArtistViewHolder(View itemView) {
    super(itemView);
    childCheckedTextView =
        (CheckedTextView) itemView.findViewById(R.id.list_item_multicheck_artist_name);
  }

  @Override public Checkable getCheckable() {
    return childCheckedTextView;
  }

  public void setArtistName(final Artist artist,
      final OnClickGroupChildListner onClickGroupChildListner) {
    childCheckedTextView.setText(artist.getName());
    if (artist.isChecked()) {
      childCheckedTextView.setChecked(true);
    } else {
      childCheckedTextView.setChecked(false);
    }
    childCheckedTextView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (artist.isChecked()) {
          childCheckedTextView.setChecked(false);
          artist.setChecked(false);
        } else {
          childCheckedTextView.setChecked(true);
          artist.setChecked(true);
        }
        if (onClickGroupChildListner != null) {
          onClickGroupChildListner.onClickGroupChildListner(artist.getParentId(), artist.getId(),
              artist.isChecked());
        }
      }
    });
  }
}
