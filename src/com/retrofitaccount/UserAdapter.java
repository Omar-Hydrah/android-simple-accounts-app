package com.retrofitaccount;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

	private List<User> users;

	public UserAdapter(List<User> users){
		this.users = users;
	}

	@Override
	public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, 
													int viewType)
	{
		View view = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.user_row, parent, false);

		return new ViewHolder(view);	
	}

	@Override
	public void onBindViewHolder(UserAdapter.ViewHolder holder, int position){
		User user = users.get(position);
		holder.username.setText(user.getUsername());
		holder.email.setText(user.getEmail());
	}

	@Override
	public int getItemCount(){
		return users.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		public TextView username;
		public TextView email;

		public ViewHolder(View item){
			super(item);
			username = (TextView) item.findViewById(R.id.username);
			email    = (TextView) item.findViewById(R.id.email);
		} 
	}
}