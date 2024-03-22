package com.example.purenav;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class SettingsFragment extends Fragment {

    Spinner languageSpinner;
    RadioButton metricButton;
    RadioButton imperialButton;
    Button continueButton;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    public SettingsFragment() {
    }


    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        String startingLanguage="English";
        String startingUnit="Metric";
        Bundle args1 = getArguments();
        if (args1 != null) {
            startingLanguage = args1.getString("language");
            startingUnit = args1.getString("unit");
        }
        languageSpinner = view.findViewById(R.id.language_spinner);
        metricButton = view.findViewById(R.id.metric_radio_button);
        imperialButton = view.findViewById(R.id.imperial_radio_button);




        continueButton = view.findViewById(R.id.continue_button);
        RadioGroup unitGroup = view.findViewById(R.id.unit_system_radio_group);
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.languages_array, R.layout.custom_language_spinner);
        languageAdapter.setDropDownViewResource(R.layout.custom_language_dropdown);
        languageSpinner.setAdapter(languageAdapter);
//        TextView welcomeText = view.findViewById(R.id.welcome_text);
        TextView preferencesText = view.findViewById(R.id.choose_preferences_text);
        TextView languageText = view.findViewById(R.id.language_label);
        TextView unitText = view.findViewById(R.id.unit_system_label);
        LinearLayout languageLayout = view.findViewById(R.id.languageLayout);
        LinearLayout unitLayout = view.findViewById(R.id.unitLayout);
        if(startingLanguage.equals("English")){
            languageSpinner.setSelection(0);
            Log.d("English", "Language: " + languageSpinner.getSelectedItem() + ", Unit: " + imperialButton.isChecked());
        }
        else if(startingLanguage.equals("Français")) {
            languageSpinner.setSelection(1);
            Log.d("French", "Language: " + languageSpinner.getSelectedItem() + ", Unit: " + imperialButton.isChecked());
        }
        else {
            languageSpinner.setSelection(2);
            Log.d("Arabic", "Language: " + languageSpinner.getSelectedItem() + ", Unit: " + imperialButton.isChecked());
        }


        if(startingUnit.equals("Metric")){
            metricButton.setChecked(true);
        }
        else imperialButton.setChecked(true);
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                if (selectedLanguage.equals("English")) {
//                    welcomeText.setText("Welcome to My Pace !");
                    preferencesText.setText("Choose your preferences :");
                    languageText.setText("Language :");
                    unitText.setText("Unit System :");
                    metricButton.setText("Metric");
                    imperialButton.setText("Imperial");
                    continueButton.setText("Set");
                    languageLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    unitLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
//                    welcomeText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    preferencesText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    languageText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    unitText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    metricButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    imperialButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    continueButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    continueButton.setLayoutDirection(View.LAYOUT_DIRECTION_INHERIT);
                    continueButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);


                    if (navigationView != null) {
                        Menu menu = navigationView.getMenu();
                        if (menu != null) {
                            MenuItem homeItem = menu.findItem(R.id.nav_home);
                            MenuItem settingsItem = menu.findItem(R.id.nav_settings);
                            homeItem.setTitle("Calculate");
                            settingsItem.setTitle("Settings");
                        }
                    }


                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
                    continueButton.setLayoutParams(layoutParams);

                } else if (selectedLanguage.equals("Français")) {
//                    welcomeText.setText("Bienvenue sur My Pace !");
                    preferencesText.setText("Choisissez vos préférences :");
                    languageText.setText("Langue :");
                    unitText.setText("Système d'unité :");
                    metricButton.setText("Métrique");
                    imperialButton.setText("Impérial");
                    continueButton.setText("Définir");

                    if (navigationView != null) {
                        Menu menu = navigationView.getMenu();
                        if (menu != null) {
                            MenuItem homeItem = menu.findItem(R.id.nav_home);
                            MenuItem settingsItem = menu.findItem(R.id.nav_settings);
                            homeItem.setTitle("Calculer");
                            settingsItem.setTitle("Paramètres");
                        }
                    }

                    languageLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    unitLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
//                    welcomeText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    preferencesText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    languageText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    unitText.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    metricButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    imperialButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    continueButton.setTextDirection(View.TEXT_DIRECTION_INHERIT);
                    continueButton.setLayoutDirection(View.LAYOUT_DIRECTION_INHERIT);
                    continueButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
                    continueButton.setLayoutParams(layoutParams);
                } else if (selectedLanguage.equals("العربية")) {
//                    welcomeText.setText("مرحبًا بك في My Pace !");
                    preferencesText.setText("اختر تفضيلاتك :");
                    languageText.setText("اللغة :");
                    unitText.setText("نظام الوحدات :");
                    metricButton.setText("متري");
                    imperialButton.setText("إمبراطوري");
                    continueButton.setText("تعيين");

                    if (navigationView != null) {
                        Menu menu = navigationView.getMenu();
                        if (menu != null) {
                            MenuItem homeItem = menu.findItem(R.id.nav_home);
                            MenuItem settingsItem = menu.findItem(R.id.nav_settings);
                            homeItem.setTitle("حساب");
                            settingsItem.setTitle("الإعدادات");
                        }
                    }

                    languageLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                    unitLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//                    welcomeText.setTextDirection(View.TEXT_DIRECTION_RTL);
                    preferencesText.setTextDirection(View.TEXT_DIRECTION_RTL);
                    languageText.setTextDirection(View.TEXT_DIRECTION_RTL);
                    unitText.setTextDirection(View.TEXT_DIRECTION_RTL);
                    metricButton.setTextDirection(View.TEXT_DIRECTION_RTL);
                    imperialButton.setTextDirection(View.TEXT_DIRECTION_RTL);
                    continueButton.setTextDirection(View.TEXT_DIRECTION_RTL);
                    continueButton.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    continueButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.gravity = Gravity.START;
                    continueButton.setLayoutParams(layoutParams);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                HomeFragment homeFragment = new HomeFragment();

                Bundle args = new Bundle();

                args.putString("language", languageSpinner.getSelectedItem().toString());
                if (imperialButton.isChecked()) {
                    args.putString("unit", imperialButton.getText().toString());
                    homeFragment.setArguments(args);

                    fragmentTransaction.replace(R.id.fragment_container, homeFragment);

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                    NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                    Menu menu = navigationView.getMenu();
                    MenuItem menuItem = menu.findItem(R.id.nav_home);
                    if (menuItem != null) {
                        menuItem.setChecked(true);
                    }
                } else if (metricButton.isChecked()) {
                    args.putString("unit", metricButton.getText().toString());
                    homeFragment.setArguments(args);
                    fragmentTransaction.replace(R.id.fragment_container, homeFragment);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                    NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                    Menu menu = navigationView.getMenu();
                    MenuItem menuItem = menu.findItem(R.id.nav_home);
                    if (menuItem != null) {
                        menuItem.setChecked(true);
                    }
                }

            }
        });
        return view;
    }
}