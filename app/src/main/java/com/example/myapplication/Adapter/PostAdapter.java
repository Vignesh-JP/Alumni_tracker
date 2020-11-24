package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Post;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public Context mContext;
    public List<Post>mPost;

    private FirebaseUser firebaseUserpost;

    public PostAdapter(Context mContext, List<Post>mPost){
        this.mContext =mContext;
        this.mPost=mPost;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item,parent,false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        firebaseUserpost = FirebaseAuth.getInstance().getCurrentUser();

        Post post = mPost.get(i);

        Glide.with(mContext).load(post.getPostimage()).into(viewHolder.post_image);

        if(post.getDescriptionpost().equals("")){
            viewHolder.descriptionpost.setVisibility(View.GONE);

        }else{
            viewHolder.descriptionpost.setVisibility(View.VISIBLE);
            viewHolder.descriptionpost.setText(post.getDescriptionpost());
        }

        publisherInfo(viewHolder.image_profile_post,viewHolder.usernamepost,viewHolder.publisher,post.getPublisher());

    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_profile_post,post_image,like,comment,save;
        public TextView usernamepost,likes,publisher,descriptionpost,viewcomments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_profile_post = itemView.findViewById(R.id.image_profile_post);
            post_image = itemView.findViewById(R.id.post_image);
            viewcomments = itemView.findViewById(R.id.viewcomments);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            save = itemView.findViewById(R.id.save);
            usernamepost = itemView.findViewById(R.id.usernamepost);
            likes = itemView.findViewById(R.id.likes);
            publisher = itemView.findViewById(R.id.publisher);
            descriptionpost = itemView.findViewById(R.id.descriptionpost);
        }
    }
    private void publisherInfo(final ImageView image_profile_post, final TextView usernamepost, final TextView publisher, String userid){
        DatabaseReference referencepub = FirebaseDatabase.getInstance().getReference("Users").child(userid);

        referencepub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User userpub = dataSnapshot.getValue(User.class);
                assert userpub!=null;
                Glide.with(mContext).load(userpub.getImageurl()).into(image_profile_post);
                usernamepost.setText(userpub.getUsername());
                publisher.setText(userpub.getUsername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
