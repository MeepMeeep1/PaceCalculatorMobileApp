package com.example.purenav;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner distanceSpinner;
    TextView paceTextView;
    TextView speedTextView;
    ArrayAdapter<CharSequence> distanceAdapter;
    ArrayAdapter<CharSequence> splitsAdapter;
    String getLanguage;
    String getUnit;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.fragment_home, container, false);
//        Intent intent = getIntent();
//
//        String getLanguage = intent.getStringExtra("language");
//        String getUnit = intent.getStringExtra("unit");

        getLanguage = "English";
        getUnit = "Metric";
        Bundle args = getArguments();
        if (args != null) {
            getLanguage = args.getString("language");
            getUnit = args.getString("unit");
        }
        TextView distanceText = view1.findViewById(R.id.distanceText);
        TextView timeText = view1.findViewById(R.id.timeText);
        TextView speedText = view1.findViewById(R.id.speedText);
        TextView paceText = view1.findViewById(R.id.paceText);


        distanceSpinner = view1.findViewById(R.id.distanceSpinner);
        paceTextView = view1.findViewById(R.id.paceSpinner);
        speedTextView = view1.findViewById(R.id.speedSpinner);

        distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.Events, R.layout.custom_spinner_dropdown_item);
        distanceAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
        distanceSpinner.setAdapter(distanceAdapter);

        Spinner splitSpinner = view1.findViewById(R.id.splitsText);
        splitsAdapter=ArrayAdapter.createFromResource(getContext(), R.array.EnglishSplits,R.layout.custom_spinner_dropdown_item);
        splitsAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
        splitSpinner.setAdapter(splitsAdapter);

        EditText customDistance = view1.findViewById(R.id.customDistance);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) customDistance.getLayoutParams();

        TextView splitTime = view1.findViewById(R.id.splitTimeText);

        if (getLanguage.equals("English")) {
            layoutParams.setMarginStart(280);
            customDistance.setLayoutParams(layoutParams);
            distanceText.setText("Distance");
            timeText.setText("Time");
            speedText.setText("Speed");
            paceText.setText("Pace");
            splitTime.setText("Split Time");

            if (getUnit.equals("Metric")) {
                customDistance.setHint("meters");
                speedTextView.setText("km/h");
                paceTextView.setText("min/km");
            } else {
                customDistance.setHint("miles");
                speedTextView.setText("mile/h");
                paceTextView.setText("min/mile");
            }
            splitsAdapter=ArrayAdapter.createFromResource(getContext(), R.array.EnglishSplits,R.layout.custom_spinner_dropdown_item);
            splitsAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            splitSpinner.setAdapter(splitsAdapter);

            distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.Events, R.layout.custom_spinner_dropdown_item);
            distanceAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            distanceSpinner.setAdapter(distanceAdapter);

        } else if (getLanguage.equals("Français")) {
            layoutParams.setMarginStart(400);
            customDistance.setLayoutParams(layoutParams);
            distanceText.setText("Distance");
            timeText.setText("Temps");
            speedText.setText("Vitesse");
            paceText.setText("Allure");
            splitTime.setText("Fractionnement");

            if (getUnit.equals("Métrique")) {
                customDistance.setHint("mètres");
                speedTextView.setText("km/h");
                paceTextView.setText("min/km");
            } else {
                customDistance.setHint("milles");
                speedTextView.setText("mille/h");
                paceTextView.setText("min/mille");
            }
            splitsAdapter=ArrayAdapter.createFromResource(getContext(), R.array.FrenchSplits,R.layout.custom_spinner_dropdown_item);
            splitsAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            splitSpinner.setAdapter(splitsAdapter);

            distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.EventsFrench, R.layout.custom_spinner_dropdown_item);
            distanceAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            distanceSpinner.setAdapter(distanceAdapter);

        } else {
            layoutParams.setMarginStart(0);
            customDistance.setLayoutParams(layoutParams);
            distanceText.setText("المسافة");
            timeText.setText("الوقت");
            speedText.setText("السرعة");
            paceText.setText("المعدل");
            splitTime.setText("وقت القسم");
            if (getUnit.equals("متري")) {
                customDistance.setHint("أمتار");
                speedTextView.setText("كم/ساعة");
                paceTextView.setText("دقيقة/كم");
            } else {
                customDistance.setHint("أميال");
                speedTextView.setText("ميل/ساعة");
                paceTextView.setText("دقيقة/ميل");
            }
            splitsAdapter=ArrayAdapter.createFromResource(getContext(), R.array.ArabicSplits,R.layout.custom_spinner_dropdown_item);
            splitsAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            splitSpinner.setAdapter(splitsAdapter);

            distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.EventsArabic, R.layout.custom_spinner_dropdown_item);
            distanceAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_style);
            distanceSpinner.setAdapter(distanceAdapter);


        }


        NumberPicker timeSec = view1.findViewById(R.id.timeInputSec);

        timeSec.setMinValue(0);
        timeSec.setMaxValue(59);
        NumberPicker timeMin = view1.findViewById(R.id.timeInputMin);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            timeMin.setTextColor(Color.BLUE);
//        }
        timeMin.setMaxValue(59);
        timeMin.setMinValue(0);
        NumberPicker timeHrs = view1.findViewById(R.id.timeInputHrs);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            timeHrs.setTextColor(Color.BLUE);
//        }
        timeHrs.setMaxValue(23);
        timeHrs.setMinValue(0);
        NumberPicker paceSec = view1.findViewById(R.id.paceInputSec);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            paceSec.setTextColor(Color.BLUE);
//        }
        paceSec.setMinValue(0);
        paceSec.setMaxValue(59);
        NumberPicker paceMin = view1.findViewById(R.id.paceInputMin);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            paceMin.setTextColor(Color.BLUE);
//        }
        paceMin.setMaxValue(59);
        paceMin.setMinValue(0);
        EditText speedIn = view1.findViewById(R.id.speedInput);


        String finalGetUnit = getUnit;
        speedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String speed = speedIn.getText().toString();
                boolean infinity = false;
                if (speed.equals(""))
                    infinity = true;
                else {
                    for (char c : speed.toCharArray()) {
                        if (Character.isLetter(c)) {
                            infinity = true;
                            break;
                        }
                    }
                }
                if (!infinity) {
                    String item = distanceSpinner.getSelectedItem().toString();
                    double pace = 60.0 / Double.parseDouble((String.valueOf(speedIn.getText().toString())));
                    paceMin.setValue((int) pace);
                    paceSec.setValue((int) ((pace - paceMin.getValue()) * 60));
                    double time;
                    double distance;
                    if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص") && !customDistance.getText().equals("")) {
                        if (finalGetUnit.equals("Metric") || finalGetUnit.equals("Métrique") || finalGetUnit.equals("متري"))
                            distance = Double.parseDouble(customDistance.getText().toString());
                        else
                            distance = Double.parseDouble(customDistance.getText().toString()) * 1609.34;
                    } else if (item.equals("Mile") || item.equals("Mille") || item.equals("ميل")) {
                        distance = 1609.34;

                    } else if (item.equals("10 km") || item.equals("10 كيلومترات")) {
                        distance = 10000.0;
                    } else if (item.equals("5 km") || item.equals("5 كيلومترات")) {
                        distance = 5000.0;
                    } else if (item.equals("Half Marathon") || item.equals("Semi-marathon") || item.equals("نصف ماراثون")) {
                        distance = 21097.5;
                    } else if (item.equals("Marathon") || item.equals("ماراثون")) {
                        distance = 21097.5 * 2;
                    } else
                        distance = Double.parseDouble(distanceSpinner.getSelectedItem().toString());

                    if (finalGetUnit.equals("Metric") || finalGetUnit.equals("Métrique") || finalGetUnit.equals("متري")) {
                        time = pace * (distance / 1000.0);
                    } else {
                            time = pace * (distance / 1609.34);
                    }

                    double timeInHours = time / 60.0;
                    timeHrs.setValue((int) timeInHours);
                    double minutes = (timeInHours - timeHrs.getValue()) * 60;
                    timeMin.setValue((int) minutes);
                    timeSec.setValue((int) ((minutes - timeMin.getValue()) * 60));
                    if (finalGetUnit.equals("Metric") || finalGetUnit.equals("Métrique") || finalGetUnit.equals("متري"))
                        splitMaker(time * 60, distance, view1,splitSpinner);
                    else splitMaker(time * 60, distance , view1,splitSpinner);
                }
            }
        });


        String finalGetUnit1 = getUnit;
        distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) distanceSpinner.getSelectedItem();
                double pace;
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص")) {
                    customDistance.setVisibility(View.VISIBLE);
                } else {
                    customDistance.setVisibility(View.GONE);
                    pace = timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit1, view1,splitSpinner);
                    double speed = 60.0 / pace;
                    speedIn.setText(String.valueOf(speed));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        String finalGetUnit2 = getUnit;
        customDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customDistance.getText().toString().equals("")) {

                } else
                    timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit2, view1,splitSpinner);
            }
        });


        String finalGetUnit3 = getUnit;
        timeSec.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String item = (String) distanceSpinner.getSelectedItem();
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص")) {
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit3, view1,splitSpinner);
                } else
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit3, view1,splitSpinner);
            }
        });
        String finalGetUnit4 = getUnit;
        timeMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String item = (String) distanceSpinner.getSelectedItem();
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص")) {
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit4, view1,splitSpinner);
                } else
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit4, view1,splitSpinner);


            }
        });
        String finalGetUnit5 = getUnit;
        timeHrs.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String item = (String) distanceSpinner.getSelectedItem();
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص")) {
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit5, view1,splitSpinner);
                } else
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit5, view1,splitSpinner);
            }
        });

        String finalGetUnit6 = getUnit;
        paceMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String item = distanceSpinner.getSelectedItem().toString();
                double pace;
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص"))
                    pace = timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit6, view1,splitSpinner);
                else
                    pace = timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit6, view1,splitSpinner);
                double speed = 60.0 / pace;
                speedIn.setText(String.valueOf(speed));
            }
        });
        String finalGetUnit7 = getUnit;
        paceSec.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String item = distanceSpinner.getSelectedItem().toString();
                double pace;
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص"))
                    pace = timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit7, view1, splitSpinner);
                else
                    pace = timeSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit7, view1, splitSpinner);
                double speed = 60.0 / pace;
                speedIn.setText(String.valueOf(speed));

            }
        });
        splitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = distanceSpinner.getSelectedItem().toString();
                if (item.equals("Custom") || item.equals("Personnalisé") || item.equals("مخصص")) {
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, customDistance, speedIn, finalGetUnit3, view1,splitSpinner);
                } else
                    paceSetter(paceMin, paceSec, timeHrs, timeMin, timeSec, distanceSpinner, speedIn, finalGetUnit3, view1,splitSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view1;
    }

    public static double timeSetter(NumberPicker paceMin, NumberPicker paceSec, NumberPicker timeHrs, NumberPicker timeMin, NumberPicker timeSec, Spinner distanceSpinner, EditText speedIn, String getUnit, View view, Spinner splitSpinner) {
        double pace = paceMin.getValue() + paceSec.getValue() / 60.0;
        String item = distanceSpinner.getSelectedItem().toString();
        double distance;
        if (item.equals("Mile") || item.equals("Mille") || item.equals("ميل")) {
            distance = 1609.34;

        } else if (item.equals("10 km") || item.equals("10 كيلومترات")) {
            distance = 10000.0;
        } else if (item.equals("5 km") || item.equals("5 كيلومترات")) {
            distance = 5000.0;
        } else if (item.equals("Half Marathon") || item.equals("Semi-marathon") || item.equals("نصف ماراثون")) {
            distance = 21097.5;
        } else if (item.equals("Marathon") || item.equals("ماراثون")) {
            distance = 21097.5 * 2;
        } else distance = Double.parseDouble((String) distanceSpinner.getSelectedItem());


        double time;
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            time = pace * distance / 1000.0;
        else {
                time = pace * distance / 1609.34;
        }
        double timeInHours = time / 60.0;
        timeHrs.setValue((int) (timeInHours));
        time = (timeInHours - timeHrs.getValue()) * 60;
        timeMin.setValue((int) time);
        timeSec.setValue((int) ((time - timeMin.getValue()) * 60));

        splitMaker(time * 60, distance, view, splitSpinner);
        return pace;
    }

    public static double timeSetter(NumberPicker paceMin, NumberPicker paceSec, NumberPicker timeHrs, NumberPicker timeMin, NumberPicker timeSec, EditText customDistance, EditText speedIn, String getUnit, View view, Spinner splitSpinner) {
        if (customDistance.getText().toString().equals(""))
            return 0;
        double pace = paceMin.getValue() + paceSec.getValue() / 60.0;
        double distance = Double.parseDouble(customDistance.getText().toString());
        double time;
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            time = pace * (distance / 1000.0);
        else {
            time = pace * distance;
        }
        double timeInHours = time / 60.0;
        timeHrs.setValue((int) (timeInHours));
        time = (timeInHours - timeHrs.getValue()) * 60;
        timeMin.setValue((int) time);
        timeSec.setValue((int) ((time - timeMin.getValue()) * 60));
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            splitMaker(time * 60, distance, view,splitSpinner);
        else {
            splitMaker(time * 60, distance * 1609.34, view, splitSpinner);
        }
        return pace;
    }

    public static void paceSetter(NumberPicker paceMin, NumberPicker paceSec, NumberPicker timeHrs, NumberPicker timeMin, NumberPicker timeSec, Spinner distanceSpinner, EditText speedIn, String getUnit, View view, Spinner splitSpinner) {
        double minutes = timeHrs.getValue() * 60 + timeMin.getValue() + (double) timeSec.getValue() / 60.0;
        String item = distanceSpinner.getSelectedItem().toString();
        double distance;
        if (item.equals("Mile") || item.equals("Mille") || item.equals("ميل")) {
            distance = 1609.34;

        } else if (item.equals("10 km") || item.equals("10 كيلومترات")) {
            distance = 10000.0;
        } else if (item.equals("5 km") || item.equals("5 كيلومترات")) {
            distance = 5000.0;
        } else if (item.equals("Half Marathon") || item.equals("Semi-marathon") || item.equals("نصف ماراثون")) {
            distance = 21097.5;
        } else if (item.equals("Marathon") || item.equals("ماراثون")) {
            distance = 21097.5 * 2;
        } else distance = Double.parseDouble((String) distanceSpinner.getSelectedItem());

        double pace;
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            pace = minutes / (distance / 1000.0);
        else {
            pace = minutes / (distance / 1609.34);
        }

        paceMin.setValue((int) pace);
        paceSec.setValue((int) ((pace - paceMin.getValue()) * 60));
        double speed = 60.0 / pace;
        speedIn.setText(String.valueOf(speed));
        splitMaker(minutes * 60, distance, view, splitSpinner);
    }

    public static void paceSetter(NumberPicker paceMin, NumberPicker paceSec, NumberPicker timeHrs, NumberPicker timeMin, NumberPicker timeSec, EditText customDistance, EditText speedIn, String getUnit, View view, Spinner splitSpinner) {
        if (customDistance.getText().toString().equals(""))
            return;
        double minutes = timeHrs.getValue() * 60 + timeMin.getValue() + (double) timeSec.getValue() / 60.0;
        double distance;
        double pace;
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            distance = (Double.parseDouble(customDistance.getText().toString()) / 1000.0);
        else
            distance = (Double.parseDouble(customDistance.getText().toString()));
        pace = minutes / distance;
        paceMin.setValue((int) pace);
        paceSec.setValue((int) ((pace - paceMin.getValue()) * 60));
        double speed = 60.0 / pace;
        speedIn.setText(String.valueOf(speed));
        if (getUnit.equals("Metric") || getUnit.equals("Métrique") || getUnit.equals("متري"))
            splitMaker(minutes * 60, distance*1000, view, splitSpinner);
        else splitMaker(minutes * 60, distance*1609.34, view, splitSpinner);
    }

    public static void splitMaker(double sec, double distance, View view, Spinner splitSpinner) {
        int split;
        if(splitSpinner.getSelectedItem().toString().equals("Splits/400m") || splitSpinner.getSelectedItem().toString().equals("تقسيمات/400 متر") || splitSpinner.getSelectedItem().toString().equals("Fractures/400m"))
            split=400;
        else if(splitSpinner.getSelectedItem().toString().equals("Splits/100m") || splitSpinner.getSelectedItem().toString().equals("تقسيمات/100 متر") || splitSpinner.getSelectedItem().toString().equals("Fractures/100m"))
            split=100;
        else
            split=1000;
        int numSplits = (int) (distance / split);
        double splitTimeInSeconds = sec / numSplits;
        List<String> splitTimes = new ArrayList<>();

        for (int i = 0; i < numSplits; i++) {
            double splitTime = splitTimeInSeconds * (i + 1);
            int minutes = (int) (splitTime / 60);
            int seconds = (int) (splitTime % 60);
            splitTimes.add(String.format("       %d                                         %d : %02d", split*(i+1), minutes, seconds));
        }

        ListView listView = view.findViewById(R.id.list_view);
        if (listView != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1, splitTimes);
            listView.setAdapter(adapter);
        } else {
            Log.e("splitMaker", "ListView not found in the layout");
        }
    }
}