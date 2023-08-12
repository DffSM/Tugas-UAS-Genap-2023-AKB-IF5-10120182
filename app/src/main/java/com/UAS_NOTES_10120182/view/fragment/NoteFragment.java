package com.UAS_NOTES_10120182.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.UAS_NOTES_10120182.databinding.FragmentNoteBinding;
import com.UAS_NOTES_10120182.view.activity.EditNoteActivity;
import com.UAS_NOTES_10120182.view.activity.LoginActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.UAS_NOTES_10120182.view.activity.AddNoteActivity;
import com.UAS_NOTES_10120182.view.activity.MainActivity;
import com.UAS_NOTES_10120182.R;
import com.UAS_NOTES_10120182.adapter.NoteAdapter;
import com.UAS_NOTES_10120182.model.Note;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoteFragment extends Fragment  {

    private MainActivity mainActivity;

    private com.UAS_NOTES_10120182.adapter.NoteAdapter noteAdapter;

    private FragmentNoteBinding binding;
    private FirebaseAuth auth;

    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Note");

        setupUser();
        loadData();

        binding.buttonAdd.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AddNoteActivity.class));
        });

    }

    private void loadData() {
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userNotesRef = databaseReference.child(userId);

            LinearLayoutManager manager = new LinearLayoutManager(requireContext());
            binding.mynote.setLayoutManager(manager);

            FirebaseRecyclerOptions<Note> options =
                    new FirebaseRecyclerOptions.Builder<Note>()
                            .setQuery(userNotesRef, Note.class)
                            .build();
            noteAdapter = new NoteAdapter(options, (item, noteKey) -> {
                // Handle item click here
                showDetailActivity(item, noteKey); // Pass the noteKey to the showDetailActivity method
            });
            binding.mynote.setAdapter(noteAdapter);
        } else {
            // Handle the case when currentUser is null
        }
    }

    private void showDetailActivity(Note item, String noteKey) {
        // Create an Intent to start the DetailActivity and pass the data
        Intent intent = new Intent(requireContext(), EditNoteActivity.class);
        intent.putExtra("daily_note",item);
        intent.putExtra("note_key", noteKey); // Pass the noteKey to the DetailActivity
        startActivity(intent);
    }


    private void setupUser() {
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser == null) {
            startActivity(new Intent(requireContext(), LoginActivity.class));
            requireActivity().finish();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        noteAdapter.startListening();
    }

    @Override
    public void onPause() {
        super.onPause();
        noteAdapter.stopListening();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
/// 10120182, Daffa Surya Mahardhika, IF-5