package v.abhijeet.firebaseregister;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter {
    private Activity mcontext;
    List<Member> studentsList;
    public ListAdapter(Activity mcontext,List<Member> studentsList){
        super(mcontext,R.layout.listitem,studentsList);
        this.mcontext = mcontext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mcontext.getLayoutInflater();
        View listItemview = inflater.inflate(R.layout.listitem,null,true);

        TextView tvName = listItemview.findViewById(R.id.tvName);
        TextView tvMobile = listItemview.findViewById(R.id.tvMobile);
        TextView tvEmail = listItemview.findViewById(R.id.tvEmail);

        Member member = studentsList.get(position);

        tvName.setText(member.getName());
        tvMobile.setText(member.getMobile());
        tvEmail.setText(member.getEmail());

        return listItemview;
    }
}
