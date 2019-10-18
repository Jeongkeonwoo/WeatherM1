package com.example.weatherm.fragment.daytime;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherm.WeatherUtil;
import com.example.weatherm.data.Data;
import com.example.weatherm.R;
import com.example.weatherm.data.ForecastData;

import java.util.ArrayList;
import java.util.List;

public class DaytimeAdapter extends RecyclerView.Adapter<DaytimeAdapter.DaytimeHolder> {

//    private List<Data> dataList;
    private List<ForecastData.ListBean> forecastList;
    //Adapter 에 전잘해 사용할 List 형의 데이터
/////////////////////////////////////////////////////////////
    public DaytimeAdapter(List<ForecastData.ListBean> forecastList){
        this.forecastList = forecastList;
    }
//    public void setDataList(ArrayList<Data> dataList) {
//        this.dataList = dataList;
//    }

    @NonNull
    @Override
    public DaytimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //view 실체화
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weekly_item, parent, false);
        //view 를 holder 에 넣어줌
        DaytimeHolder holder = new DaytimeHolder(view);

        return holder;
    }

    //onCreateViewHolder() 에서 holder 를 return 받은 holder 에 데이터를 셋팅해준다.
    @Override
    public void onBindViewHolder(@NonNull DaytimeHolder holder, int position) {
//        Data data = dataList.get(position);

        ForecastData.ListBean forecastBean = forecastList.get(position);

        Log.d("DaytimeAdapter","getHour"+ WeatherUtil.getHour(forecastBean.getDt_txt()));

        holder.daytime_weather_date.setText(WeatherUtil.getHour(forecastBean.getDt_txt()));

        int weatherId = forecastBean.getWeather().get(0).getId();
        int imageResource = WeatherUtil.getWeatherIcon(weatherId);
        holder.daytime_weather_icon.setImageResource(imageResource);

        String temp = WeatherUtil.getCelsius(forecastBean.getMain().getTemp());
        holder.daytime_weather_hightemperature.setText(temp+"˚");
//        holder.daytime_weather_weekly.setText(data.getWeekly());
//        //요일
//        holder.daytime_weather_date.setText(data.getDate());
//        //날짜
//        holder.daytime_weather_icon.setImageResource(data.getImg());
//        //날씨이미지
//        holder.daytime_weather_hightemperature.setText(data.getHight());
//        //최고온도
//        holder.daytime_weather_lowtemperature.setText(data.getLow());
//        //최저온도
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    class DaytimeHolder extends RecyclerView.ViewHolder {

        private TextView daytime_weather_weekly;
        private TextView daytime_weather_date;
        private ImageView daytime_weather_icon;
        private TextView daytime_weather_hightemperature;
        private TextView daytime_weather_lowtemperature;

        public DaytimeHolder(@NonNull View itemView) {
            super(itemView);

            daytime_weather_weekly = itemView.findViewById(R.id.daytime_weather_weekly);
            //요일
            daytime_weather_date = itemView.findViewById(R.id.daytime_weather_date);
            //날짜
            daytime_weather_icon = itemView.findViewById(R.id.daytime_weather_icon);
            //이미지 날씨
            daytime_weather_hightemperature = itemView.findViewById(R.id.daytime_weather_hightemperature);
            //최고온도
            daytime_weather_lowtemperature = itemView.findViewById(R.id.daytime_weather_lowtemperature);
            //최저온도
        }
    }
}
