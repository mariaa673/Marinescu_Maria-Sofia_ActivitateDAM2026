package com.example.laborator4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class masinaAdapter extends BaseAdapter {
    private List<Masina> masini = null;
    private Context ctx;
    private int resursaLayout;

    public masinaAdapter(List<Masina> masini, Context ctx, int resursaLayout) {
        this.masini = masini;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Object getItem(int i) {
        return masini.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, viewGroup, false);

        TextView marcaTV = v.findViewById(R.id.tvMarca);
        TextView anTV = v.findViewById(R.id.tvAn);
        TextView combustibilTV = v.findViewById(R.id.tvCombustibil);
        TextView caroserieTV = v.findViewById(R.id.tvCaroserie);
        RatingBar ratingRB = v.findViewById(R.id.rbRatingItem);
        CheckBox garantieCB = v.findViewById(R.id.cbGarantieItem);
        TextView nouaTV = v.findViewById(R.id.tvNoua);

        Masina masina = (Masina) getItem(i);

        marcaTV.setText(masina.getMarca());
        anTV.setText(String.valueOf(masina.getAnFabricatie()));
        combustibilTV.setText(masina.getCombustibil());
        caroserieTV.setText(masina.getCaroserie());
        ratingRB.setRating(masina.getRating());
        garantieCB.setChecked(masina.isAreGarantie());
        nouaTV.setText(masina.isEsteNoua() ? "Nouă" : "Second-hand");

        return v;
    }
}