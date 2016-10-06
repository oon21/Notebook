package com.brianexample.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends android.app.ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        String[] values = new String[]{ "Cat","Dog","Horse","Snake","Mouse","Rat","Monkey","Chicken","Dragon","Pig","Sheep"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values );

        setListAdapter(adapter);
        */

        notes = new ArrayList<Note>();
        notes.add(new Note("This is a new note title!", "This is the body of our note!", Note.Category.PERSONAL));
        notes.add(new Note("Title 2 mang comon", "yo yo yo", Note.Category.PERSONAL));
        notes.add(new Note("Bo cheddar", "L to the J!", Note.Category.QUOTE));
        notes.add(new Note("Jack Peper cheese", "Shoppin shoppin give me the ravioli", Note.Category.FINANCE));
        notes.add(new Note("asdf", "asdf!", Note.Category.QUOTE));
        notes.add(new Note("Paramour", "Maddddd good niggaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Note.Category.TECHNICAL));
        notes.add(new Note("This is a new note title!", "This is the body of our note!", Note.Category.TECHNICAL));

        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

        // Sometimes the divider line between each notes don't show. This fixes that.
        //getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        //getListView().setDividerHeight(1);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);
    }
    // SEND INFO TO NoteViewFragment.java
    private void launchNoteDetailActivity(int position){
        //grab the note information with whatever note item you clicked on
        Note note = (Note) getListAdapter().getItem(position);
        //create new intent that launches our noteDetailActivity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);
        //pass along the information of the note we clicked on to our noteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getId());

        startActivity(intent);
    }

}
