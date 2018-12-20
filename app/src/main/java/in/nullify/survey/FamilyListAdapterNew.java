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
 * Created by Abhishekpalodath on 06-11-2018.
 */

public class FamilyListAdapterNew extends RecyclerView.Adapter<FamilyListAdapterNew.ViewHolder> {
    private Activity context;
    private ArrayList<String> yesno = new ArrayList<>();
    private ArrayList<String> involve = new ArrayList<>();
    private ArrayList<String> gender = new ArrayList<>();
    private ArrayList<String> marstat = new ArrayList<>();
    private ArrayList<String> edulvl = new ArrayList<>();
    private ArrayList<String> goschool = new ArrayList<>();
    private ArrayList<String> sope = new ArrayList<>();
    private ArrayList<String> occ = new ArrayList<>();

    public FamilyListAdapterNew(Activity context) {
        this.context = context;
    }

    @Override
    public FamilyListAdapterNew.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.family_member_list_style, viewGroup, false);
        return new FamilyListAdapterNew.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FamilyListAdapterNew.ViewHolder viewHolder, final int i) {

        gender.clear();
        yesno.clear();
        involve.clear();

        gender.add("Male");
        gender.add("Female");
        gender.add("Other");

        yesno.add("Yes");
        yesno.add("No");

        involve.add("Involved");
        involve.add("Not Involved");

        marstat.add("Not Married");
        marstat.add("Married");
        marstat.add("Widowed");
        marstat.add("Divorced/Separated");

        edulvl.add("Not Literate");
        edulvl.add("Literate");
        edulvl.add("Completed Class 5");
        edulvl.add("Class 8th");
        edulvl.add("Class 10th");
        edulvl.add("Class 12th");
        edulvl.add("ITI Diploma");
        edulvl.add("Graduate");
        edulvl.add("Post Graduate/Professional");

        goschool.add("Going to AWC");
        goschool.add("School");
        goschool.add("College");
        goschool.add("Not Going");
        goschool.add("Not Applicable");

        sope.add("No Pension");
        sope.add("Old Age Pension");
        sope.add("Widow Pension");
        sope.add("Disability Pension");
        sope.add("Other Pension");


        occ.add("Farming on own Land");
        occ.add("Sharecropping/Farming Leased Land");
        occ.add("Animal Husbandry");
        occ.add("Pisci-culture/Poultry");
        occ.add("Fishing");
        occ.add("Skilled Wage Worker");
        occ.add("Unskilled Wage Worker");
        occ.add("Salaried Employment in Government");
        occ.add("Salaried Employment in Private Sector");
        occ.add("Other Artisan");
        occ.add("Other Trade & Business");

        viewHolder.familty_item.setTitle("Family Member "+(i+1));

        ArrayAdapter aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fgender.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, yesno);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fcomp.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, yesno);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fmnrega.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, involve);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fshg.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, marstat);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fmar.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, edulvl);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fedu.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, goschool);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fgo.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, sope);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.fssp.setAdapter(aa);

        aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, occ);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.focc.setAdapter(aa);


        viewHolder.fname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        viewHolder.fphone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setPhone(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        viewHolder.fage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setAge(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewHolder.fadhaar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setAdhaar(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewHolder.fbankac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setBankac(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewHolder.fhealth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((AddActivity)context).familymebers.get(i).setHealthpb(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        viewHolder.fgender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setGender(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewHolder.fcomp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setComplit(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewHolder.fmnrega.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setMnrega(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewHolder.fshg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setShg(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewHolder.fmar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setMarital_status(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewHolder.fgo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setGo_school(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewHolder.fedu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setEducation_level(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewHolder.fssp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setSsp(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewHolder.focc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((AddActivity)context).familymebers.get(i).setOccupation(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return ((AddActivity)context).familymebers.size();
    }

    public void removeItem(int position) {
        ((AddActivity)context).familymebers.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Family item, int position) {
        ((AddActivity)context).familymebers.add(position, item);
        notifyItemInserted(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ExpandableCardView familty_item;

        private AppCompatEditText fname;
        private AppCompatEditText fage;
        private AppCompatEditText fphone;
        private Spinner fmar;
        private Spinner fedu;
        private Spinner fgo;
        private AppCompatEditText fadhaar;
        private AppCompatEditText fbankac;
        private Spinner fssp;
        private AppCompatEditText fhealth;
        private Spinner focc;

        private Spinner fgender;
        private Spinner fcomp;
        private Spinner fmnrega;
        private Spinner fshg;


        public ViewHolder(View view) {
            super(view);

            familty_item = (ExpandableCardView) view.findViewById(R.id.familty_item);

            fname = (AppCompatEditText) view.findViewById(R.id.fname);
            fage = (AppCompatEditText) view.findViewById(R.id.fage);
            fmar = (Spinner) view.findViewById(R.id.fmar);
            fedu = (Spinner) view.findViewById(R.id.fedu);
            fgo = (Spinner) view.findViewById(R.id.fgo);
            fadhaar = (AppCompatEditText) view.findViewById(R.id.fadhaar);
            fbankac = (AppCompatEditText) view.findViewById(R.id.fbank);
            fssp = (Spinner) view.findViewById(R.id.fsocial);
            fhealth = (AppCompatEditText) view.findViewById(R.id.fmajor);
            fphone = (AppCompatEditText) view.findViewById(R.id.fphone);
            focc = (Spinner) view.findViewById(R.id.foccu);

            fgender = (Spinner) view.findViewById(R.id.fgender);
            fcomp = (Spinner) view.findViewById(R.id.fcomp);
            fmnrega = (Spinner) view.findViewById(R.id.fmnrega);
            fshg = (Spinner) view.findViewById(R.id.fself);

        }
    }

}