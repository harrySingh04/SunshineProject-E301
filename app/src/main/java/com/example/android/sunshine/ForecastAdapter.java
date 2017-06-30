package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by ishpr on 6/29/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{
    private String[] mWeatherData;

    public ForecastAdapter()
    {


    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutIdList = LayoutInflater.from(context);
        int layoutIdForList = R.layout.forecast_list_item;
        boolean shouldAttachImmediately = false;

        View view = layoutIdList.inflate(layoutIdForList,parent,shouldAttachImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData==null)
            return  0;
        else
            return mWeatherData.length;
    }

    public void setmWeatherData(String[] weatherData)
    {
        mWeatherData = weatherData;
        notifyDataSetChanged();

    }
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{

        final public TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view)
        {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);

        }
    }
}
