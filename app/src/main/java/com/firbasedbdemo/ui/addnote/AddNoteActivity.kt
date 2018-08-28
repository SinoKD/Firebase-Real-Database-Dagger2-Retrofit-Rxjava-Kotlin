package com.firbasedbdemo.ui.addnote

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.firbasedbdemo.R
import com.firbasedbdemo.base.BaseActivity
import com.firbasedbdemo.data.Post
import com.google.firebase.database.DatabaseReference
import com.google.gson.Gson
import javax.inject.Inject


class AddNoteActivity : BaseActivity() {

    lateinit var tvNote: EditText
    lateinit var btnSave: Button


    @Inject
    lateinit var myRef: DatabaseReference

    var activityMode: String? = null
    var post: Post? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        tvNote = findViewById(R.id.tv_note)
        btnSave = findViewById(R.id.btn_save)


        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            post = Gson().fromJson(bundle.getString("note", ""), Post::class.java)
            activityMode = bundle.getString("mode", "")
            if (activityMode == "edit" && post != null) tvNote.setText(post!!.content)
        }

        btnSave.setOnClickListener({

            if (activityMode == null) {
                val newPost = Post(tvNote.text.toString())
                addPost(newPost)
            } else if (activityMode == "edit") {
                editPost(post!!)
                post = null
            }
            finish()

        })

    }

    private fun addPost(post: Post) {
        myRef.child(post.id!!).setValue(post);
    }


    private fun editPost(post: Post) {
        post.content = tvNote.text.toString()
        myRef.child(post.id!!).setValue(post);
    }

}
