package com.example.hesapmakinesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.Script;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hesapmakinesi.databinding.FragmentAnaSayfaBinding;

import java.nio.charset.StandardCharsets;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class AnaSayfaFragment extends Fragment {
private FragmentAnaSayfaBinding binding;
String workings = "";




private  void setWorkings(String givenValue){
    workings = workings+givenValue;
    binding.TextViewsSonuc.setText(workings);

}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false);



        binding.button0.setOnClickListener(view -> {
           setWorkings("0");





        });
        binding.button1.setOnClickListener(view -> {
            setWorkings("1");



        });
        binding.button2.setOnClickListener(view -> {
            setWorkings("2");



        });
        binding.button3.setOnClickListener(view -> {
            setWorkings("3");



        });
        binding.button4.setOnClickListener(view -> {
            setWorkings("4");



        });
        binding.button5.setOnClickListener(view -> {
            setWorkings("5");



        });
        binding.button6.setOnClickListener(view -> {
            setWorkings("6");



        });
        binding.button7.setOnClickListener(view -> {
            setWorkings("7");



        });
        binding.button8.setOnClickListener(view -> {
            setWorkings("8");



        });
        binding.button9.setOnClickListener(view -> {
            setWorkings("9");



        });
        binding.buttonAC.setOnClickListener(view -> {
            workings = "";
            setWorkings("");





        });
        binding.buttonTopla.setOnClickListener(view -> {
            setWorkings("+");
        });
        binding.buttonEksi.setOnClickListener(view -> {
            setWorkings("-");
        });
        binding.buttoNokta.setOnClickListener(view -> {

            setWorkings(".");
        });
        binding.buttondel.setOnClickListener(view -> {

         if (workings.length()==0){

         }
         else {
             workings = workings.substring(0,workings.length()-1);
             binding.TextViewsSonuc.setText(workings);

         }






        });
        binding.buttonEsittir.setOnClickListener(view -> {

           Double result = null;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            try {
                result = (double) engine.eval(workings);
            } catch (ScriptException e) {


            }
            if(result != null){
                binding.TextViewsSonuc.setText(String.valueOf(result.doubleValue()));
            }







        });

        return binding.getRoot();
    }
}