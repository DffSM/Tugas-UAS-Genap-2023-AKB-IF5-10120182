package com.UAS_NOTES_10120182.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.UAS_NOTES_10120182.R;
import com.UAS_NOTES_10120182.databinding.ItemNoteBinding;
import com.UAS_NOTES_10120182.model.Note;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NoteAdapter extends FirebaseRecyclerAdapter<Note, NoteAdapter.NoteViewHolder> {

    private OnItemClickListener itemClickListener;

    // Define the interface
    public interface OnItemClickListener {
        void onItemClick(Note item, String noteKey);
    }

    public NoteAdapter(FirebaseRecyclerOptions<Note> options, OnItemClickListener listener) {
        super(options);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindViewHolder(NoteViewHolder holder, int position, Note model) {
        holder.bind(model);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemNoteBinding binding = ItemNoteBinding.inflate(inflater, parent, false);
        return new NoteViewHolder(binding);
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private final ItemNoteBinding binding;

        public NoteViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            // Set click listener for the item
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && itemClickListener != null) {
                    itemClickListener.onItemClick(getItem(position), getRef(position).getKey()); // Pass the noteKey to the click listener
                }
            });
        }

        public void bind(Note item) {
            binding.titleNote.setText(item.getTitle());
            binding.categoryNote.setText(item.getCategory());
            binding.dateNote.setText(item.getDate());
        }
    }

    @Override
    public void onDataChanged() {
        super.onDataChanged();
        notifyDataSetChanged();
    }
}

/// 10120182, Daffa Surya Mahardhika, IF-5