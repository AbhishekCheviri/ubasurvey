package in.nullify.survey;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhishekpalodath on 28-09-2018.
 */

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {
    private String[] column;
    private ArrayList<String> values;
    private Activity context;

    public DataListAdapter(Activity context, String[] column, ArrayList<String> values) {
        this.context = context;
        this.column = column;
        this.values = values;
    }

    @Override
    public DataListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schemes_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataListAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.coulmn.setText(column[i]);
        viewHolder.value.setText(values.get(i));

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public ArrayList<String> getValues(){
        return  values;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView coulmn;
        private EditText value;

        public ViewHolder(View view) {
            super(view);

            coulmn = (TextView) view.findViewById(R.id.column_name);
            value = (EditText) view.findViewById(R.id.data);
            value.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    values.set(getAdapterPosition(),s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}



