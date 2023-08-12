// Generated by view binder compiler. Do not edit!
package com.UAS_NOTES_10120182.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.UAS_NOTES_10120182.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditNoteBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageButton back;

  @NonNull
  public final Button buttonAdd;

  @NonNull
  public final Button buttonDelete;

  @NonNull
  public final EditText category;

  @NonNull
  public final EditText title;

  @NonNull
  public final LinearLayout titleAddBar;

  @NonNull
  public final TextView txtAdd;

  @NonNull
  public final EditText txtDesc;

  private ActivityEditNoteBinding(@NonNull RelativeLayout rootView, @NonNull ImageButton back,
      @NonNull Button buttonAdd, @NonNull Button buttonDelete, @NonNull EditText category,
      @NonNull EditText title, @NonNull LinearLayout titleAddBar, @NonNull TextView txtAdd,
      @NonNull EditText txtDesc) {
    this.rootView = rootView;
    this.back = back;
    this.buttonAdd = buttonAdd;
    this.buttonDelete = buttonDelete;
    this.category = category;
    this.title = title;
    this.titleAddBar = titleAddBar;
    this.txtAdd = txtAdd;
    this.txtDesc = txtDesc;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_note, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditNoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      ImageButton back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.buttonAdd;
      Button buttonAdd = ViewBindings.findChildViewById(rootView, id);
      if (buttonAdd == null) {
        break missingId;
      }

      id = R.id.buttonDelete;
      Button buttonDelete = ViewBindings.findChildViewById(rootView, id);
      if (buttonDelete == null) {
        break missingId;
      }

      id = R.id.category;
      EditText category = ViewBindings.findChildViewById(rootView, id);
      if (category == null) {
        break missingId;
      }

      id = R.id.title;
      EditText title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.title_add_bar;
      LinearLayout titleAddBar = ViewBindings.findChildViewById(rootView, id);
      if (titleAddBar == null) {
        break missingId;
      }

      id = R.id.txt_add;
      TextView txtAdd = ViewBindings.findChildViewById(rootView, id);
      if (txtAdd == null) {
        break missingId;
      }

      id = R.id.txt_desc;
      EditText txtDesc = ViewBindings.findChildViewById(rootView, id);
      if (txtDesc == null) {
        break missingId;
      }

      return new ActivityEditNoteBinding((RelativeLayout) rootView, back, buttonAdd, buttonDelete,
          category, title, titleAddBar, txtAdd, txtDesc);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}