package in.nullify.survey;

import android.app.Activity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alespero.expandablecardview.ExpandableCardView;

import java.util.ArrayList;

/**
 * Created by Abhishekpalodath on 20-12-2018.
 */

public class LiveStockListAdapter extends RecyclerView.Adapter<LiveStockListAdapter.ViewHolder> {
    private Activity context;
    private ArrayList<String> housetype = new ArrayList<>();

    public LiveStockListAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public LiveStockListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.live_stock_item, viewGroup, false);
        return new LiveStockListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LiveStockListAdapter.ViewHolder viewHolder, final int i) {

        housetype.clear();

        housetype.add("Kutcha");
        housetype.add("Pucca");
        housetype.add("Open");

        viewHolder.familty_item.setTitle("Live Stock "+(i+1));

        viewHolder.name.setText(((ProfileActivity)context).liveStocklist.get(i).getName());
        viewHolder.count.setText(((ProfileActivity)context).liveStocklist.get(i).getCount());

        ArrayAdapter aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, housetype);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.shelter.setAdapter(aa);

        int pos = housetype.indexOf(((ProfileActivity)context).liveStocklist.get(i).getShelter());
        viewHolder.shelter.setSelection(pos);


        viewHolder.name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((ProfileActivity)context).liveStocklist.get(i).setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewHolder.count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((ProfileActivity)context).liveStocklist.get(i).setCount(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        viewHolder.shelter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((ProfileActivity)context).liveStocklist.get(i).setShelter(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return ((ProfileActivity)context).liveStocklist.size();
    }

    public void removeItem(int position) {
        ((ProfileActivity)context).liveStocklist.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Stock item, int position) {
        ((ProfileActivity)context).liveStocklist.add(position, item);
        notifyItemInserted(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ExpandableCardView familty_item;

        private AppCompatEditText name;
        private AppCompatEditText count;

        private Spinner shelter;


        public ViewHolder(View view) {
            super(view);

            familty_item = (ExpandableCardView) view.findViewById(R.id.live_item);

            name = (AppCompatEditText) view.findViewById(R.id.name);
            count = (AppCompatEditText) view.findViewById(R.id.count);
            shelter = (Spinner) view.findViewById(R.id.shelter);

        }
    }

}